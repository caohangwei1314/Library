package com.library.mana.service.impl;

import com.library.mana.dao.BooksBorrowMapper;
import com.library.mana.dao.BooksInformationMapper;
import com.library.mana.dao.BooksMapper;
import com.library.mana.domain.Books;
import com.library.mana.domain.BooksInformation;
import com.library.mana.domain.Conditions;
import com.library.mana.service.BooksInformationService;
import com.library.mana.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class BooksInformationImpl implements BooksInformationService {

    @Autowired
    private BooksInformationMapper booksInformationMapper;

    @Autowired
    private BooksMapper booksMapper;

    @Autowired
    private BooksBorrowMapper booksBorrowMapper;

    private static final String IP = "127.0.0.1:8080";

    private static final String PATH = "E:\\网站设计\\images\\";

    public int insertSelective(BooksInformation record)
    {
        Date date = new Date();
        if(record.getImage()!=null && !"".equals(record.getImage())){
            String[] images = record.getImage().split("\\\\");
            record.setImage(images[images.length-1]);
        }
        record.setGmtCreate(date);
        record.setGmtModified(date);
        return booksInformationMapper.insertSelective(record);
    }

    public BooksInformation selectByPrimaryKey(Integer id)
    {
        BooksInformation booksInformation =booksInformationMapper.selectByPrimaryKey(id);
        if(booksInformation.getImage()!=null && !"".equals(booksInformation))
            booksInformation.setImage(getUrl(booksInformation.getImage()));
        Conditions record = new Conditions();
        record.setStatus(1);
        record.setInfoId(booksInformation.getPkId());
        booksInformation.setCount(booksMapper.count(record));
        return booksInformation;
    }

    public PageBean selectList(Conditions record)
    {
        int count = booksInformationMapper.count(record);
        if(count<1)
            return null;
        PageBean pageBean = new PageBean(record.getPage(),count,record.getLimit(),record);
        List<BooksInformation> booksInformationList = booksInformationMapper.selectList(record);
        for(BooksInformation booksInformation : booksInformationList)
            if(booksInformation.getImage()!=null && !"".equals(booksInformation))
                booksInformation.setImage(getUrl(booksInformation.getImage()));
        pageBean.setList(booksInformationList);
        return pageBean;
    }

    public int updateByPrimaryKeySelective(BooksInformation record)
    {
        record.setGmtModified(new Date());
        if(record.getImage()!=null && !"".equals(record.getImage())){
            String[] images = record.getImage().split("\\\\");
            record.setImage(images[images.length-1]);
        }
        return booksInformationMapper.updateByPrimaryKeySelective(record);
    }

    public int deleteByPrimaryKey(Integer pkId)
    {
        return booksInformationMapper.deleteByPrimaryKey(pkId);
    }

    public String uploadTemp(MultipartFile file)
    {
        String name = setProfile(file,null,true);
        return getUrl(name);
    }

    private String setProfile(MultipartFile profile,String name,boolean isTemp)
    {
        if(!profile.isEmpty())
        {
            String[] originNames = profile.getOriginalFilename().split("\\.");
            String suffix = originNames[originNames.length-1];
            BufferedOutputStream out = null;
            if(!isTemp)
            {
                if(!name.split("\\.")[0].equals(suffix))
                {
                    File filed = new File(this.PATH + name);
                    if(filed.exists())
                        filed.delete();
                }
                name = name.split("\\.")[0] + suffix;
            }
            else
            {
                name = UUID.randomUUID().toString() + System.currentTimeMillis() + "." + suffix;
            }
            File file = new File(this.PATH);
            if(!file.exists())
                file.mkdirs();
            try {
                out = new BufferedOutputStream(new FileOutputStream(this.PATH + name));
                out.write(profile.getBytes());
                out.flush();
                return name;
            } catch (IOException e) {
                return null;
            } finally {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        else
        {
            return null;
        }
    }

    private String getUrl(String name)
    {
        return "http://" + this.IP + "/" + "books" + "/" + "images" + "/" + name;
    }
}
