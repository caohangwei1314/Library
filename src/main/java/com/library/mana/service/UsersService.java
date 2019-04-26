package com.library.mana.service;

import com.library.mana.domain.Conditions;
import com.library.mana.domain.Users;
import com.library.mana.utils.PageBean;

public interface UsersService {

    Users selectByUniqueId(String uniqueId);

    Users selectByPrimaryKey(Integer pkId);

    PageBean selectList(Conditions record);

    int insertSelective(Users record);

    int updateByPrimaryKeySelective(Users record);

    int deleteByPrimaryKey(Integer pkId);
}
