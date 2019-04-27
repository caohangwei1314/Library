package com.library.mana.dao;

import com.library.mana.domain.BooksClass;
import com.library.mana.domain.BooksClassExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BooksClassMapper {
    long countByExample(BooksClassExample example);

    int deleteByExample(BooksClassExample example);

    int deleteByPrimaryKey(Integer pkId);

    int insert(BooksClass record);

    int insertSelective(BooksClass record);

    List<BooksClass> selectByExample(BooksClassExample example);

    BooksClass selectByPrimaryKey(Integer pkId);

    int updateByExampleSelective(@Param("record") BooksClass record, @Param("example") BooksClassExample example);

    int updateByExample(@Param("record") BooksClass record, @Param("example") BooksClassExample example);

    int updateByPrimaryKeySelective(BooksClass record);

    int updateByPrimaryKey(BooksClass record);
}