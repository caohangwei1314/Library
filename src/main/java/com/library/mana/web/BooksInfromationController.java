package com.library.mana.web;

import com.library.mana.domain.BooksInformation;
import com.library.mana.service.BooksInformationService;
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
}
