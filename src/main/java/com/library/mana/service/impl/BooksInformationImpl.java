package com.library.mana.service.impl;

import com.library.mana.dao.BooksInformationMapper;
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

    private static final String IP = "192.168.10.112:8080";

    private static final String PATH = "E:\\网站设计\\images\\";

    public int insertSelective(BooksInformation record)
    {
        Date date = new Date();
        String[] images = record.getImage().split("\\\\");
        record.setImage(images[images.length-1]);
        record.setGmtCreate(date);
        record.setGmtModified(date);
        return booksInformationMapper.insertSelective(record);
    }

    public BooksInformation selectByPrimaryKey(Integer id)
    {
        return booksInformationMapper.selectByPrimaryKey(id);
    }

    public PageBean selectList(Conditions record)
    {
        int count = booksInformationMapper.count(record);
        if(count<1)
            return null;
        PageBean pageBean = new PageBean(record.getPage(),count,record.getLimit(),record);
        pageBean.setList(booksInformationMapper.selectList(record));
        return pageBean;
    }

    public int updateByPrimaryKeySelective(BooksInformation record)
    {
        record.setGmtModified(new Date());
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
                name = UUID.randomUUID().toString() + System.currentTimeMillis();
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
        return this.IP + File.separator + "images" + File.separator + name;
    }
}
