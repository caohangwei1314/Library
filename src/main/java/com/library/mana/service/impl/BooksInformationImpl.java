package com.library.mana.service.impl;

import com.library.mana.dao.BooksInformationMapper;
import com.library.mana.domain.BooksInformation;
import com.library.mana.domain.Conditions;
import com.library.mana.service.BooksInformationService;
import com.library.mana.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BooksInformationImpl implements BooksInformationService {

    @Autowired
    private BooksInformationMapper booksInformationMapper;

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
}
