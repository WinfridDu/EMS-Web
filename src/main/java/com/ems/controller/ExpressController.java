package com.ems.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.json.JSONUtil;
import com.ems.domain.entity.Express;
import com.ems.domain.model.CommonResponseForm;
import com.ems.service.ExpressService;
import com.ems.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 快递信息控制层
 *
 * @author dyf
 */

@RestController
@RequestMapping("/express")
public class ExpressController{

    @Autowired
    private ExpressService expressService;

    /***
     * 根据ID删除快递信息数据
     */
    @DeleteMapping(value = "/{id}" )
    public CommonResponseForm remove(@PathVariable Long id){
        // 调用ExpressService实现根据主键删除
        expressService.deleteExpressById(id);
        return CommonResponseForm.success("删除成功");
    }

    /***
     * 修改快递信息数据
     */
    @PostMapping(value="/update")
    public CommonResponseForm edit(Express express){
        //调用ExpressService实现修改快递信息
        expressService.updateExpress(express);
        return CommonResponseForm.success("分配成功");
    }

    @PostMapping(value="/check")
    public CommonResponseForm check(Express express){
        //调用ExpressService实现修改快递信息
        Express temp = new Express();
        temp.setCourierNum(express.getCourierNum());
        List<Express> list = expressService.list(temp);
        if(list.isEmpty()){
            return CommonResponseForm.error("查无此人");
        }else if(StringUtils.isEmpty(list.get(0).getCourierTel()) || !list.get(0).getCourierTel().equals(express.getCourierTel())){
            return CommonResponseForm.error("无权查看此人信息");
        }
        return CommonResponseForm.success("操作成功");
    }

    @PostMapping(value="/changeStatus/{courierNum}")
    public CommonResponseForm changeStatus(@PathVariable String courierNum){
        //调用ExpressService实现修改快递信息
        expressService.updateExpressStatus(courierNum);
        return CommonResponseForm.success("分配成功");
    }

    /***
     * 新增快递信息数据
     */
    @PostMapping("/add")
    public CommonResponseForm add(Express express){
        //调用ExpressService实现添加快递信息
        try{
            String jsonStr = JSONUtil.parse(express).toString();
            String qrCode = ""+System.currentTimeMillis();
            express.setQrCode(qrCode);
            QrCodeUtil.generate(SecurityUtil.encode(jsonStr), 300, 300, FileUtil.file("D:/Users/18319/Desktop/" + qrCode + ".jpg"));
            expressService.insertExpress(express);
            return CommonResponseForm.success("添加成功");
        }catch (Exception e){
            e.printStackTrace();
            return CommonResponseForm.error("添加失败");
        }
    }

    /***
     * 根据ID查询快递信息数据
     */
    @GetMapping("/{id}")
    public CommonResponseForm getInfo(@PathVariable Long id){
        //调用ExpressService实现根据主键查询快递信息
        Express express = expressService.selectExpressById(id);
        return CommonResponseForm.success("查询成功", express);
    }

    /***
     * 查询快递信息全部数据
     */
    @GetMapping("/list")
    public CommonResponseForm getAllInfo(){
        //调用ExpressService实现查询所有快递信息
        List<Express> list = expressService.selectAll();
        return CommonResponseForm.success("查询成功", list);
    }

    /***
     * 查询快递信息全部数据
     */
    @GetMapping("/search")
    public CommonResponseForm list(Express express){
        //调用ExpressService实现查询用户寄出的快递信息
        List<Express> list = expressService.list(express);
        return CommonResponseForm.success("查询成功", list);
    }
}
