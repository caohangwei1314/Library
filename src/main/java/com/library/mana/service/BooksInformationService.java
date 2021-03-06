package com.library.mana.service;

import com.library.mana.domain.BooksInformation;
import com.library.mana.domain.Conditions;
import com.library.mana.utils.PageBean;
import org.springframework.web.multipart.MultipartFile;

public interface BooksInformationService {

    int insertSelective(BooksInformation record);

    BooksInformation selectByPrimaryKey(Integer pkId);

    PageBean selectList(Conditions record);

    int updateByPrimaryKeySelective(BooksInformation record);

    int deleteByPrimaryKey(Integer pkId);

    String uploadTemp(MultipartFile file);
}
