package com.library.mana.service.impl;

import com.library.mana.dao.BooksClassMapper;
import com.library.mana.domain.BooksClass;
import com.library.mana.service.BooksClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BooksClassImpl implements BooksClassService {

    @Autowired
    private BooksClassMapper booksClassMapper;

    public int insertSelective(BooksClass record)
    {
        Date date = new Date();
        record.setGmtCreate(date);
        record.setGmtModified(date);
        return booksClassMapper.insertSelective(record);
    }

}
