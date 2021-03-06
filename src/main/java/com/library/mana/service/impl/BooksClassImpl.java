package com.library.mana.service.impl;

import com.library.mana.dao.BooksClassMapper;
import com.library.mana.domain.BooksClass;
import com.library.mana.domain.Conditions;
import com.library.mana.service.BooksClassService;
import com.library.mana.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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

    public BooksClass selectByPrimaryKey(Integer pkId)
    {
        return booksClassMapper.selectByPrimaryKey(pkId);
    }

    public PageBean selectList(Conditions record)
    {
        int count = booksClassMapper.count(record);
        if(count<1)
            return null;
        PageBean pageBean = new PageBean(record.getPage(),count,record.getLimit(),record);
        pageBean.setList(booksClassMapper.selectList(record));
        return pageBean;
    }

    public int updateByPrimaryKeySelective(BooksClass record)
    {
        record.setGmtModified(new Date());
        return booksClassMapper.updateByPrimaryKeySelective(record);
    }

    public int deleteByPrimaryKey(Integer pkId)
    {
        return booksClassMapper.deleteByPrimaryKey(pkId);
    }
}
