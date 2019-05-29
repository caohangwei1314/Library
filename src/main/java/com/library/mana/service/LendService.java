package com.library.mana.service;

import com.library.mana.domain.BooksBorrow;
import com.library.mana.domain.Conditions;
import com.library.mana.utils.PageBean;

import java.util.List;

public interface LendService {

    int insertSelective(BooksBorrow record);

    int deleteByPrimaryKey(Integer pkId);

    int updateByPrimaryKeySelective(BooksBorrow record);

    PageBean selectList(Conditions record);

    int relend(BooksBorrow record);

    List<BooksBorrow> statistic(String year, Integer userId);
}
