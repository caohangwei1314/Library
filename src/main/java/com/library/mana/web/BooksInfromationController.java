package com.library.mana.web;

import com.library.mana.domain.BooksInformation;
import com.library.mana.service.BooksInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

}
