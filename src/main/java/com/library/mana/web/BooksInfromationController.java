package com.library.mana.web;

import com.library.mana.domain.BooksInformation;
import com.library.mana.domain.Conditions;
import com.library.mana.service.BooksInformationService;
import com.library.mana.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/books/information")
public class BooksInfromationController extends BaseController{

    @Autowired
    private BooksInformationService booksInformationService;

    @RequestMapping(method = RequestMethod.POST)
    public Map<String,Object> insert(@RequestBody BooksInformation record)
    {
        setMsg(booksInformationService.insertSelective(record),null,null);
        return msg;
    }

    @RequestMapping(value = "/detail",method = RequestMethod.GET)
    public Map<String,Object> select(@RequestParam("id") Integer id)
    {
        BooksInformation booksInformation = booksInformationService.selectByPrimaryKey(id);
        if(booksInformation!=null)
            setMsg(1,null,booksInformation);
        else
            setMsg(0,"该信息不存在！",null);
        return msg;
    }

    @RequestMapping(value = "/list",method = RequestMethod.POST)
    public Map<String,Object> select(@RequestBody Conditions record)
    {
        PageBean pageBean = booksInformationService.selectList(record);
        if(pageBean!=null)
            setMsg(1,null,pageBean);
        else
            setMsg(0,"暂无信息！",null);
        return msg;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Map<String,Object> update(@RequestBody BooksInformation record)
    {
        setMsg(booksInformationService.updateByPrimaryKeySelective(record),null,null);
        return msg;
    }
}
