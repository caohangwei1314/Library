package com.library.mana.service;

import com.library.mana.domain.Users;

public interface UsersService {

    Users selectByUniqueId(String uniqueId);

    Users selectByPrimaryKey(Integer pkId);

    int insertSelective(Users record);

    int updateByPrimaryKeySelective(Users record);

    int deleteByPrimaryKey(Integer pkId);
}
