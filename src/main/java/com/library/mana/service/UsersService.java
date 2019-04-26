package com.library.mana.service;

import com.library.mana.domain.Users;

public interface UsersService {

    Users selectByUniqueId(Integer uniqueId);

    Users selectByPrimaryKey(Integer pkId);

    int insertSelective(Users record);
}
