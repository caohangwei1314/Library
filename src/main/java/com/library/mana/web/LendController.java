package com.library.mana.web;

import com.library.mana.domain.BooksBorrow;
import com.library.mana.domain.Conditions;
import com.library.mana.service.LendService;
import com.library.mana.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/books/lend")
public class LendController extends BaseController{

    @Autowired
    private LendService lendService;

    @RequestMapping(method = RequestMethod.POST)
    public Map<String,Object> insert(@RequestBody BooksBorrow record,HttpServletRequest request)
    {
        if(record.getUserId()==null)
            record.setUserId(Integer.parseInt(request.getAttribute("userId").toString()));
        setMsg(lendService.insertSelective(record),null,null);
        return msg;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public Map<String,Object> delete(@RequestParam("id") Integer id)
    {
        setMsg(lendService.deleteByPrimaryKey(id),null,null);
        return msg;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Map<String,Object> update(@RequestBody BooksBorrow record)
    {
        setMsg(lendService.updateByPrimaryKeySelective(record),null,null);
        return msg;
    }

    @RequestMapping(value = "/record",method = RequestMethod.POST)
    public Map<String,Object> selectList(@RequestBody Conditions record,
                                         HttpServletRequest request)
    {
        if(record.getUserId()==null)
            record.setUserId(Integer.valueOf(request.getAttribute("userId").toString()));
        if(record.getUserId()==0)
            record.setUserId(null);
        PageBean pageBean = lendService.selectList(record);
        if(pageBean!=null)
            setMsg(1,null,pageBean);
        else
            setMsg(0,"暂无借阅信息",null);
        return msg;
    }

    @RequestMapping(value = "/relend",method = RequestMethod.POST)
    public Map<String,Object> relend(@RequestBody BooksBorrow record,HttpServletRequest request)
    {
        record.setUserId(Integer.parseInt(request.getAttribute("userId").toString()));
        setMsg(lendService.relend(record),null,null);
        return msg;
    }
}
