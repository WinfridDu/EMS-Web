package com.ems.controller;

import cn.hutool.crypto.digest.BCrypt;
import com.ems.domain.entity.User;
import com.ems.domain.model.CommonResponseForm;
import com.ems.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dyf
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public CommonResponseForm register(User user){
        try{
            if(user == null || StringUtils.isEmpty(user.getPassword())){
                return CommonResponseForm.error("注册失败, 信息缺失");
            }
            user.setPassword(BCrypt.hashpw(user.getPassword()));
            userService.insertUser(user);
            return CommonResponseForm.success("注册成功");
        }catch (DuplicateKeyException e){
            return CommonResponseForm.error("注册失败, 用户名可能已经存在");
        }
    }
}
