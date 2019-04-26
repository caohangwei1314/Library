package com.library.mana.web;

import com.library.mana.domain.Users;
import com.library.mana.service.UsersService;
import com.library.mana.utils.JwtUtil;
import com.library.mana.utils.Sha2Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
        if(Sha2Util.SHA256(users.getPassword()).equals(users1.getPassword())){
            JwtUtil jwtUtil =new JwtUtil();
            try {
                setMsg(1,null, jwtUtil.createJWT(users1.getPkId().toString(),users1.getUniqueId().toString(),1000*60*60*24));
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
            setMsg(usersService.insertSelective(users),null,jwtUtil.createJWT(users.getPkId().toString(),users.getUniqueId().toString(),1000*60*60*24));
        } catch (Exception e) {
            setMsg(0,e.getMessage(),null);
        }
        return msg;
    }

}
