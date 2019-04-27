package com.library.mana.service;

import com.library.mana.domain.BooksClass;
import com.library.mana.domain.Conditions;
import com.library.mana.utils.PageBean;

public interface BooksClassService {

    int insertSelective(BooksClass record);

    BooksClass selectByPrimaryKey(Integer pkId);

    PageBean selectList(Conditions record);
}
