package com.library.mana.service.impl;

import com.library.mana.dao.*;
import com.library.mana.domain.*;
import com.library.mana.service.LendService;
import com.library.mana.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class LendImpl implements LendService {

    @Autowired
    private BooksMapper booksMapper;

    @Autowired
    private BooksBorrowMapper booksBorrowMapper;

    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private AuthorityMapper authorityMapper;

    @Override
    public int insertSelective(BooksBorrow record){
        Books bookss = booksMapper.selectByPrimaryKey(record.getBooksId());
        Conditions rec = new Conditions();
        rec.setUserId(record.getUserId());
        rec.setPkId(bookss.getInfoId());
        if(booksBorrowMapper.judge(rec)>0)
            return 2;
        if(usersMapper.selectByPrimaryKey(record.getUserId()).getBalance()<0)
            return 3;
        Conditions re = new Conditions();
        re.setStatus(0);
        re.setPkId(record.getBooksId());
        if(booksMapper.count(re)<1)
            return 0;
        Users users = usersMapper.selectByPrimaryKey(record.getUserId());
        Authority authority = authorityMapper.selectByClassId(users.getClassId());
        Conditions conditions = new Conditions();
        conditions.setUserId(users.getPkId());
        conditions.setIsReturn(0);
        if(booksBorrowMapper.count(conditions)>authority.getNumber())
            return 0;
        Long time = System.currentTimeMillis();
        record.setGmtCreate(new Date(time));
        long a=authority.getLendTime().longValue();
        time+=1000l*60l*60l*24l*a;
        Date date = new Date(time);
        record.setGmtReturn(date);
        if(booksBorrowMapper.insertSelective(record)>0){
            Books books =new Books();
            books.setPkId(record.getBooksId());
            books.setStatus(1);
            return booksMapper.updateByPrimaryKeySelective(books);
        }
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(Integer pkId){
        return booksBorrowMapper.deleteByPrimaryKey(pkId);
    }

    @Override
    public int updateByPrimaryKeySelective(BooksBorrow record){
        if(record.getIsReturn()==1)
            record.setActualReturn(new Date());
        if(booksBorrowMapper.updateByPrimaryKeySelective(record)>0){
            Books books = new Books();
            books.setPkId(record.getBooksId());
            books.setStatus(0);
            return booksMapper.updateByPrimaryKeySelective(books);
        }
        return 0;
    }

    @Override
    public PageBean selectList(Conditions record){
        int count = booksBorrowMapper.count(record);
        if(count<1)
            return null;
        PageBean pageBean = new PageBean(record.getPage(),count,record.getLimit(),record);
        pageBean.setList(booksBorrowMapper.selectList(record));
        return pageBean;
    }

    @Override
    public int relend(BooksBorrow record){
        BooksBorrow booksBorrow = booksBorrowMapper.selectByPrimaryKey(record.getPkId());
        if(booksBorrow.getIsReturn()!=0)
            return 0;
        booksBorrow.setIsReturn(2);
        booksBorrow.setGmtReturn(new Date(booksBorrow.getGmtReturn().getTime()+1000l*60l*60l*24l*30l));
        return booksBorrowMapper.updateByPrimaryKeySelective(booksBorrow);
    }

}
