package com.library.mana.dao;

import com.library.mana.domain.BooksInformation;
import com.library.mana.domain.BooksInformationExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface BooksInformationMapper {
    long countByExample(BooksInformationExample example);

    int deleteByExample(BooksInformationExample example);

    int deleteByPrimaryKey(Integer pkId);

    int insert(BooksInformation record);

    int insertSelective(BooksInformation record);

    List<BooksInformation> selectByExample(BooksInformationExample example);

    BooksInformation selectByPrimaryKey(Integer pkId);

    int updateByExampleSelective(@Param("record") BooksInformation record, @Param("example") BooksInformationExample example);

    int updateByExample(@Param("record") BooksInformation record, @Param("example") BooksInformationExample example);

    int updateByPrimaryKeySelective(BooksInformation record);

    int updateByPrimaryKey(BooksInformation record);
}