package com.library.mana.web;

import com.library.mana.domain.BooksClass;
import com.library.mana.service.BooksClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

}
