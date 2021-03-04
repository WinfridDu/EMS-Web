package com.ems.controller;

import cn.hutool.crypto.digest.BCrypt;
import com.ems.domain.entity.Courier;
import com.ems.domain.model.CommonResponseForm;
import com.ems.service.CourierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 快递员信息控制层
 *
 * @author dyf
 */

@RestController
@RequestMapping("/courier")
public class CourierController{

    @Autowired
    private CourierService courierService;

    @PostMapping("/register")
    public CommonResponseForm register(Courier courier){
        try{
            if(courier == null || StringUtils.isEmpty(courier.getPassword())){
                return CommonResponseForm.error("注册失败, 信息缺失");
            }
            courier.setPassword(BCrypt.hashpw(courier.getPassword()));
            courierService.insertCourier(courier);
            return CommonResponseForm.success("注册成功");
        }catch (DuplicateKeyException e){
            return CommonResponseForm.error("注册失败, 快递员账号可能已经存在");
        }
    }

    /***
     * 查询快递员信息全部数据
     */
    @GetMapping("/list")
    public CommonResponseForm getAllInfo(){
        //调用courierService实现查询所有快递员信息
        List<Courier> list = courierService.selectAll();
        return CommonResponseForm.success("查询成功", list);
    }
}
