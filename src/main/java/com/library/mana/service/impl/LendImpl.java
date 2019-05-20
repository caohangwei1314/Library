package com.library.mana.service.impl;

import com.library.mana.dao.AuthorityMapper;
import com.library.mana.dao.BooksBorrowMapper;
import com.library.mana.dao.UsersMapper;
import com.library.mana.domain.Authority;
import com.library.mana.domain.BooksBorrow;
import com.library.mana.domain.Conditions;
import com.library.mana.domain.Users;
import com.library.mana.service.LendService;
import com.library.mana.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class LendImpl implements LendService {

    @Autowired
    private BooksBorrowMapper booksBorrowMapper;

    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private AuthorityMapper authorityMapper;

    @Override
    public int insertSelective(BooksBorrow record){
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
        return booksBorrowMapper.insertSelective(record);
    }

    @Override
    public int deleteByPrimaryKey(Integer pkId){
        return booksBorrowMapper.deleteByPrimaryKey(pkId);
    }

    @Override
    public int updateByPrimaryKeySelective(BooksBorrow record){
        if(record.getIsReturn()==1)
            record.setActualReturn(new Date());
        return booksBorrowMapper.updateByPrimaryKeySelective(record);
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

}
