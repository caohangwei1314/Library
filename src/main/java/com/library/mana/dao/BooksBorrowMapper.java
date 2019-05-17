package com.library.mana.dao;

import com.library.mana.domain.BooksBorrow;
import com.library.mana.domain.BooksBorrowExample;
import java.util.List;

import com.library.mana.domain.Conditions;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface BooksBorrowMapper {
    long countByExample(BooksBorrowExample example);

    int deleteByExample(BooksBorrowExample example);

    int deleteByPrimaryKey(Integer pkId);

    int insert(BooksBorrow record);

    int insertSelective(BooksBorrow record);

    List<BooksBorrow> selectByExample(BooksBorrowExample example);

    BooksBorrow selectByPrimaryKey(Integer pkId);

    int updateByExampleSelective(@Param("record") BooksBorrow record, @Param("example") BooksBorrowExample example);

    int updateByExample(@Param("record") BooksBorrow record, @Param("example") BooksBorrowExample example);

    int updateByPrimaryKeySelective(BooksBorrow record);

    int updateByPrimaryKey(BooksBorrow record);

    int count(Conditions record);

    List<BooksBorrow> selectList(Conditions record);
}