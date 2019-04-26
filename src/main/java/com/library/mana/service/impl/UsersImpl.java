package com.library.mana.service.impl;

import com.library.mana.dao.UsersMapper;
import com.library.mana.domain.Users;
import com.library.mana.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersImpl implements UsersService {

    @Autowired
    private UsersMapper usersMapper;

    public Users selectByPrimaryKey(Integer pkId){return usersMapper.selectByPrimaryKey(pkId);}

}
