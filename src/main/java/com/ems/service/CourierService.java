package com.ems.service;

import com.ems.domain.entity.Courier;
import com.ems.mapper.CourierMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * 快递员信息业务层接口实现类
 *
 * @author dyf
 */
@Service
public class CourierService{

    @Autowired
    private CourierMapper courierMapper;

    /**
    * 快递员信息条件查询
    */
    public List<Courier> selectCourierList(Courier courier){
        //构建查询条件
        Example example = createExample(courier);
        //根据构建的条件查询数据
        return courierMapper.selectByExample(example);
    }

    /**
     * 快递员信息构建查询对象
     */
    public Example createExample(Courier courier){
        Example example=new Example(Courier.class);
        Example.Criteria criteria = example.createCriteria();
        if(courier!=null){
            // 快递员ID
            if(!StringUtils.isEmpty(courier.getId())){
                    criteria.andEqualTo("id",courier.getId());
            }
            // 快递员姓名
            if(!StringUtils.isEmpty(courier.getName())){
                    criteria.andLike("name","%"+courier.getName()+"%");
            }
            // 手机号码
            if(!StringUtils.isEmpty(courier.getTel())){
                    criteria.andEqualTo("tel",courier.getTel());
            }
            // 密码
            if(!StringUtils.isEmpty(courier.getPassword())){
                    criteria.andEqualTo("password",courier.getPassword());
            }
            // 派送区
            if(!StringUtils.isEmpty(courier.getRegion())){
                    criteria.andEqualTo("region",courier.getRegion());
            }
        }
        return example;
    }

    /**
     * 删除
     */
    public void deleteCourierById(Long id){
        courierMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改快递员信息
     */
    public void updateCourier(Courier courier){
        courierMapper.updateByPrimaryKeySelective(courier);
    }

    /**
     * 增加快递员信息
     */
    public void insertCourier(Courier courier){
        courierMapper.insertSelective(courier);
    }

    /**
     * 根据ID查询快递员信息
     */
    public Courier selectCourierById(Long id){
        return  courierMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询快递员信息全部数据
     */
    public List<Courier> selectAll() {
        return courierMapper.selectAll();
    }
}
