package com.library.mana.service.impl;

import com.library.mana.dao.BooksInformationMapper;
import com.library.mana.dao.BooksMapper;
import com.library.mana.domain.Books;
import com.library.mana.domain.BooksInformation;
import com.library.mana.domain.Conditions;
import com.library.mana.service.BooksService;
import com.library.mana.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BooksImpl implements BooksService {

    @Autowired
    private BooksMapper booksMapper;

    @Autowired
    private BooksInformationMapper booksInformationMapper;

    public int insertSelective(Books record)
    {
        Date date = new Date();
        record.setGmtCreate(date);
        record.setGmtModified(date);
        if(booksMapper.insertSelective(record)>0){
            BooksInformation booksInformation = booksInformationMapper.selectByPrimaryKey(record.getInfoId());
            booksInformation.setNum(booksInformation.getNum()+1);
            return booksInformationMapper.updateByPrimaryKeySelective(booksInformation);
        }
        return 0;
    }

    public Books selectByPrimaryKey(Integer pkId)
    {
        return booksMapper.selectByPrimaryKey(pkId);
    }

    public PageBean selectList(Conditions record)
    {
        int count = booksMapper.count(record);
        if(count<1)
            return null;
        PageBean pageBean = new PageBean(record.getPage(),count,record.getLimit(),record);
        pageBean.setList(booksMapper.selectList(record));
        return pageBean;
    }

    public int updateByPrimaryKeySelective(Books record)
    {
        record.setGmtModified(new Date());
        return booksMapper.updateByPrimaryKeySelective(record);
    }

    public int deleteByPrimaryKey(Integer pkId)
    {
        return booksMapper.deleteByPrimaryKey(pkId);
    }

    public int insertBatch(Books record)
    {
        if(record.getCount()<1)
            return 0;
        Date date = new Date();
        record.setGmtCreate(date);
        record.setGmtModified(date);
        int flag = 0;
        for(int i=0;i<record.getCount();i++){
            flag = booksMapper.insertSelective(record);
        }
        if(flag<1)
            return 0;
        BooksInformation booksInformation = booksInformationMapper.selectByPrimaryKey(record.getInfoId());
        booksInformation.setNum(booksInformation.getNum()+record.getCount());
        return booksInformationMapper.updateByPrimaryKeySelective(booksInformation);
    }

}
