package com.library.mana.service.impl;

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

    public Users selectByUniqueId(String uniqueId)
    {
        return usersMapper.selectByUniqueId(uniqueId);
    }

    public Users selectByPrimaryKey(Integer pkId)
    {
        return usersMapper.selectByPrimaryKey(pkId);
    }

    public PageBean selectList(Conditions record){
        int count = usersMapper.count(record);
        if(count<0)
            return null;
        PageBean pageBean = new PageBean(record.getPage(),count,record.getLimit(),record);
        List<Users> usersList = usersMapper.selectList(record);
        if(usersList.size()<1 || usersList==null)
            return null;
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
}
