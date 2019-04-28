package com.library.mana.service;

import com.library.mana.domain.BooksInformation;
import com.library.mana.domain.Conditions;
import com.library.mana.utils.PageBean;

public interface BooksInformationService {

    int insertSelective(BooksInformation record);

    BooksInformation selectByPrimaryKey(Integer pkId);

    PageBean selectList(Conditions record);
}
