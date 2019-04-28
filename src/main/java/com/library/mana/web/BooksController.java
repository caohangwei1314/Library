package com.library.mana.web;

import com.library.mana.domain.Books;
import com.library.mana.domain.Conditions;
import com.library.mana.service.BooksService;
import com.library.mana.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/books")
public class BooksController extends BaseController{

    @Autowired
    private BooksService booksService;

    @RequestMapping(method = RequestMethod.POST)
    public Map<String,Object> insert(@RequestBody Books record)
    {
        setMsg(booksService.insertSelective(record),null,null);
        return msg;
    }

    @RequestMapping(value = "/detail",method = RequestMethod.GET)
    public Map<String,Object> select(@RequestParam("id") Integer id)
    {
        Books booksClass = booksService.selectByPrimaryKey(id);
        if(booksClass!=null)
            setMsg(1,null,booksClass);
        else
            setMsg(0,"该类别不存在！",null);
        return msg;
    }



    @RequestMapping(value = "/list",method = RequestMethod.POST)
    public Map<String,Object> selectList(@RequestBody Conditions record)
    {
        PageBean pageBean = booksService.selectList(record);
        if(pageBean!=null)
            setMsg(1,null,pageBean);
        else
            setMsg(0,"暂无类别！",null);
        return msg;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Map<String,Object> update(@RequestBody Books record)
    {
        setMsg(booksService.updateByPrimaryKeySelective(record),null,null);
        return msg;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public Map<String,Object> delete(@RequestParam("id") Integer id)
    {
        setMsg(booksService.deleteByPrimaryKey(id),null,null);
        return msg;
    }

}
