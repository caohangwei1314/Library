package com.library.mana.service.impl;

import com.library.mana.dao.BooksMapper;
import com.library.mana.domain.Books;
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

    public int insertSelective(Books record)
    {
        Date date = new Date();
        record.setGmtCreate(date);
        record.setGmtModified(date);
        return booksMapper.insertSelective(record);
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

}
