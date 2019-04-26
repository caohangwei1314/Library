package com.library.mana.service.impl;

import com.library.mana.dao.UsersMapper;
import com.library.mana.domain.Users;
import com.library.mana.service.UsersService;
import com.library.mana.utils.Sha2Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public int insertSelective(Users record)
    {
        record.setPassword(Sha2Util.SHA256(record.getPassword()));
        return usersMapper.insertSelective(record);
    }

    public int deleteByPrimaryKey(Integer pkId){
        return usersMapper.deleteByPrimaryKey(pkId);
    }
}
