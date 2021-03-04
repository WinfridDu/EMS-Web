package com.ems.controller;

import cn.hutool.crypto.digest.BCrypt;
import com.ems.domain.entity.Courier;
import com.ems.domain.entity.User;
import com.ems.domain.model.CommonResponseForm;
import com.ems.domain.model.LoginRequestForm;
import com.ems.service.CourierService;
import com.ems.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author dyf
 */
@RestController
public class LoginController {
    @Autowired
    private CourierService courierService;

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public CommonResponseForm login(LoginRequestForm loginRequestForm){
        if(StringUtils.isEmpty(loginRequestForm.getPassword()) || StringUtils.isEmpty(loginRequestForm.getTel())){
            return CommonResponseForm.error("登录失败，请检查用户名或密码");
        }
        boolean correct;
        if("courier".equals(loginRequestForm.getType())){
            Courier courier = new Courier();
            courier.setTel(loginRequestForm.getTel());
            List<Courier> couriers = courierService.selectCourierList(courier);
            if(couriers.size() == 0){
                return CommonResponseForm.error("登录失败，请检查用户名或密码");
            }
            correct = BCrypt.checkpw(loginRequestForm.getPassword(), couriers.get(0).getPassword());
        }else{
            User user = new User();
            user.setTel(loginRequestForm.getTel());
            List<User> users = userService.selectUserList(user);
            if(users.size() == 0){
                return CommonResponseForm.error("登录失败，请检查用户名或密码");
            }
            if("admin".equals(loginRequestForm.getType()) && users.get(0).getId() != 1L){
                return CommonResponseForm.error("登录失败，请检查用户名或密码");
            }
            correct = BCrypt.checkpw(loginRequestForm.getPassword(), users.get(0).getPassword());
        }
        if(correct){
            return CommonResponseForm.success("登录成功");
        }
        return CommonResponseForm.error("登录失败，请检查用户名或密码");
    }
}
