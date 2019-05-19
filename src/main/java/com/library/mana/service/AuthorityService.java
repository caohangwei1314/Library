package com.library.mana.service;

import com.library.mana.domain.Authority;
import com.library.mana.domain.Conditions;
import com.library.mana.utils.PageBean;

public interface AuthorityService {

    int deleteByPrimaryKey(Integer pkId);

    int insertSelective(Authority record);

    Authority selectByPrimaryKey(Integer pkId);

    int updateByPrimaryKeySelective(Authority record);

    PageBean selectList(Conditions record);
}
