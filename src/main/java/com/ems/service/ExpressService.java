package com.ems.service;

import com.ems.domain.entity.Express;
import com.ems.mapper.ExpressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 快递信息业务层接口实现类
 *
 * @author dyf
 */
@Service
public class ExpressService{

    @Autowired
    private ExpressMapper expressMapper;

    /**
     * 删除
     */
    public void deleteExpressById(Long id){
        expressMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改快递信息
     */
    public void updateExpress(Express express){
        expressMapper.updateExpress(express);
    }

    /**
     * 增加快递信息
     */
    public void insertExpress(Express express){
        expressMapper.insertSelective(express);
    }

    /**
     * 根据ID查询快递信息
     */
    public Express selectExpressById(Long id){
        return  expressMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询快递信息全部数据
     */
    public List<Express> selectAll() {
        return expressMapper.selectAll();
    }

    public List<Express> list(Express express) {
        return expressMapper.select(express);
    }

    public void updateExpressStatus(String courierNum) {
        expressMapper.updateStatus(courierNum);
    }
}
