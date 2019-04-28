package com.library.mana.service;

import com.library.mana.domain.BooksInformation;

public interface BooksInformationService {

    int insertSelective(BooksInformation record);

    BooksInformation selectByPrimaryKey(Integer pkId);
}
