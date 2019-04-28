package com.library.mana.service.impl;

import com.library.mana.dao.BooksInformationMapper;
import com.library.mana.domain.BooksInformation;
import com.library.mana.service.BooksInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

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

}
