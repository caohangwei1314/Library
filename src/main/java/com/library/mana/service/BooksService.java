package com.library.mana.service;

import com.library.mana.domain.Books;
import com.library.mana.domain.Conditions;
import com.library.mana.utils.PageBean;

public interface BooksService {

    int insertSelective(Books record);

    Books selectByPrimaryKey(Integer pkId);

    PageBean selectList(Conditions record);

    int updateByPrimaryKeySelective(Books record);

    int deleteByPrimaryKey(Integer pkId);

    int insertBatch(Books books);

}
