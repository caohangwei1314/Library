package com.library.mana.service.impl;

import com.library.mana.dao.AuthorityMapper;
import com.library.mana.domain.Authority;
import com.library.mana.domain.Conditions;
import com.library.mana.service.AuthorityService;
import com.library.mana.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorityImpl implements AuthorityService {

    @Autowired
    private AuthorityMapper authorityMapper;

    @Override
    public int deleteByPrimaryKey(Integer pkId){
        return authorityMapper.deleteByPrimaryKey(pkId);
    }

    @Override
    public int insertSelective(Authority record){
        return authorityMapper.insertSelective(record);
    }

    @Override
    public Authority selectByPrimaryKey(Integer pkId){
        return authorityMapper.selectByPrimaryKey(pkId);
    }

    @Override
    public int updateByPrimaryKeySelective(Authority record){
        return authorityMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageBean selectList(Conditions record)
    {
        int count = authorityMapper.count(record);
        if(count<1)
            return null;
        PageBean pageBean = new PageBean(record.getPage(),count,record.getLimit(),record);
        pageBean.setList(authorityMapper.selectList(record));
        return pageBean;
    }

}
