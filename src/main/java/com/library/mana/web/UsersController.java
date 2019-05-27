package com.library.mana.web;

import com.library.mana.domain.Conditions;
import com.library.mana.domain.Users;
import com.library.mana.service.UsersService;
import com.library.mana.utils.JwtUtil;
import com.library.mana.utils.PageBean;
import com.library.mana.utils.Sha2Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UsersController extends BaseController{

    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Map<String,Object> login(@RequestBody Users users)
    {
        Users users1 = usersService.selectByUniqueId(users.getUniqueId());
        if(users1==null){
            setMsg(0,"该账号未注册",null);
            return msg;
        }
        if(Sha2Util.SHA256(users.getPassword()).equals(users1.getPassword())){
            JwtUtil jwtUtil =new JwtUtil();
            try {
                setMsg(1,null, jwtUtil.createJWT(users1.getPkId().toString(),users1.getUniqueId(),1000*60*60*24));
            } catch (Exception e) {
                setMsg(0,e.getMessage(),null);
            }
        }else{
            setMsg(0,"密码错误！",null);
        }
        return msg;
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public Map<String,Object> insert(@RequestBody Users users)
    {
        JwtUtil jwtUtil =new JwtUtil();
        try {
            setMsg(usersService.insertSelective(users),null,jwtUtil.createJWT(users.getPkId().toString(),users.getUniqueId(),1000*60*60*24));
        } catch (Exception e) {
            setMsg(0,e.getMessage(),null);
        }
        return msg;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Map<String,Object> select(HttpServletRequest request)
    {
        Users users = usersService.selectByPrimaryKey(Integer.parseInt(request.getAttribute("userId").toString()));
        if(users!=null)
            setMsg(1,null,users);
        else
            setMsg(0,"用户不存在",null);
        return msg;
    }

    @RequestMapping(value = "/detail",method = RequestMethod.GET)
    public Map<String,Object> selectDetail(@RequestParam("id") Integer id)
    {
        Users users = usersService.selectByPrimaryKey(id);
        if(users!=null)
            setMsg(1,null,users);
        else
            setMsg(0,"用户不存在",null);
        return msg;
    }

    @RequestMapping(value = "/list",method = RequestMethod.POST)
    public Map<String,Object> select(@RequestBody Conditions record)
    {
        PageBean pageBean = usersService.selectList(record);
        if(pageBean!=null)
            setMsg(1,null,pageBean);
        else
            setMsg(0,"用户不存在",null);
        return msg;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Map<String,Object> update(@RequestBody Users users)
    {
        setMsg(usersService.updateByPrimaryKeySelective(users),null,null);
        return msg;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public Map<String,Object> delete(@RequestParam("id") Integer id,HttpServletRequest request)
    {
        Integer usersId = Integer.parseInt(request.getAttribute("userId").toString());
        Users users = usersService.selectByPrimaryKey(usersId);
        if(users.getClassId()==0)
            setMsg(usersService.deleteByPrimaryKey(id),null,null);
        else
            setMsg(0,"你没有权限！",null);
        return msg;
    }

    @RequestMapping(value = "/balance",method = RequestMethod.POST)
    public Map<String,Object> balance(@RequestBody Users users,HttpServletRequest request){
        users.setPkId(Integer.parseInt(request.getAttribute("userId").toString()));
        setMsg(usersService.balance(users),null,null);
        return msg;
    }

}
