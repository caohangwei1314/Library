package com.library.mana.web;

import com.library.mana.domain.Authority;
import com.library.mana.domain.Conditions;
import com.library.mana.service.AuthorityService;
import com.library.mana.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/authority")
public class AuthorityController extends BaseController{

    @Autowired
    private AuthorityService authorityService;

    @RequestMapping(method = RequestMethod.POST)
    public Map<String,Object> insert(@RequestBody Authority record)
    {
        setMsg(authorityService.insertSelective(record),null,null);
        return msg;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Map<String,Object> select(@RequestParam("id") Integer id)
    {
        Authority booksClass = authorityService.selectByPrimaryKey(id);
        if(booksClass!=null)
            setMsg(1,null,booksClass);
        else
            setMsg(0,"该权限不存在！",null);
        return msg;
    }



    @RequestMapping(value = "/list",method = RequestMethod.POST)
    public Map<String,Object> selectList(@RequestBody Conditions record)
    {
        PageBean pageBean = authorityService.selectList(record);
        if(pageBean!=null)
            setMsg(1,null,pageBean);
        else
            setMsg(0,"暂无类别！",null);
        return msg;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Map<String,Object> update(@RequestBody Authority record)
    {
        setMsg(authorityService.updateByPrimaryKeySelective(record),null,null);
        return msg;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public Map<String,Object> delete(@RequestParam("id") Integer id)
    {
        setMsg(authorityService.deleteByPrimaryKey(id),null,null);
        return msg;
    }

}
