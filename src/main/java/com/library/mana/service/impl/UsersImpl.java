package com.library.mana.service.impl;

import com.library.mana.dao.AuthorityMapper;
import com.library.mana.dao.UsersMapper;
import com.library.mana.domain.Conditions;
import com.library.mana.domain.Users;
import com.library.mana.service.UsersService;
import com.library.mana.utils.PageBean;
import com.library.mana.utils.Sha2Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UsersImpl implements UsersService {

    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private AuthorityMapper authorityMapper;

    public Users selectByUniqueId(String uniqueId)
    {
        Users users = usersMapper.selectByUniqueId(uniqueId);
        if(users==null)
            return null;
        users.setAuthority(authorityMapper.selectByClassId(users.getClassId()));
        return users;
    }

    public Users selectByPrimaryKey(Integer pkId)
    {
        Users users = usersMapper.selectByPrimaryKey(pkId);
        users.setAuthority(authorityMapper.selectByClassId(users.getClassId()));
        return users;
    }

    public PageBean selectList(Conditions record){
        int count = usersMapper.count(record);
        if(count<1)
            return null;
        PageBean pageBean = new PageBean(record.getPage(),count,record.getLimit(),record);
        List<Users> usersList = usersMapper.selectList(record);
        for(Users users : usersList)
            users.setAuthority(authorityMapper.selectByClassId(users.getClassId()));
        pageBean.setList(usersList);
        return pageBean;
    }

    public int insertSelective(Users record)
    {
        Date date = new Date();
        record.setGmtCreate(date);
        record.setGmtModified(date);
        record.setPassword(Sha2Util.SHA256(record.getPassword()));
        return usersMapper.insertSelective(record);
    }

    public int updateByPrimaryKeySelective(Users record){
        record.setGmtModified(new Date());
        return usersMapper.updateByPrimaryKeySelective(record);
    }

    public int deleteByPrimaryKey(Integer pkId){
        return usersMapper.deleteByPrimaryKey(pkId);
    }

    public int balance(Users users){
        Users users1 = usersMapper.selectByPrimaryKey(users.getPkId());
        users1.setBalance(users1.getBalance()+users.getBalance());
        return updateByPrimaryKeySelective(users1);
    }
}
