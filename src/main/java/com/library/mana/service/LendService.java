package com.library.mana.service;

import com.library.mana.domain.BooksBorrow;
import com.library.mana.domain.Conditions;
import com.library.mana.utils.PageBean;

public interface LendService {

    int insertSelective(BooksBorrow record);

    int deleteByPrimaryKey(Integer pkId);

    int updateByPrimaryKeySelective(BooksBorrow record);

    PageBean selectList(Conditions record);

    int relend(BooksBorrow record);
}
