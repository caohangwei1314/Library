package com.library.mana.web;

import com.library.mana.domain.BooksClass;
import com.library.mana.domain.Conditions;
import com.library.mana.service.BooksClassService;
import com.library.mana.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/books/class")
public class BooksClassController extends BaseController{

    @Autowired
    private BooksClassService booksClassService;

    @RequestMapping(method = RequestMethod.POST)
    public Map<String,Object> insert(@RequestBody BooksClass record)
    {
        setMsg(booksClassService.insertSelective(record),null,null);
        return msg;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Map<String,Object> select(@RequestParam("id") Integer id)
    {
        BooksClass booksClass = booksClassService.selectByPrimaryKey(id);
        if(booksClass!=null)
            setMsg(1,null,booksClass);
        else
            setMsg(0,"该类别不存在！",null);
        return msg;
    }

}
