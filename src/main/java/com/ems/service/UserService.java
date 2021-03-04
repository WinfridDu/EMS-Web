package com.ems.service;

import com.ems.domain.entity.User;
import com.ems.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * 用户信息业务层接口实现类
 *
 * @author dyf
 */
@Service
public class UserService{

    @Autowired
    private UserMapper userMapper;

    /**
    * 用户信息条件查询
    */
    public List<User> selectUserList(User user){
        //构建查询条件
        Example example = createExample(user);
        //根据构建的条件查询数据
        return userMapper.selectByExample(example);
    }

    /**
     * 用户信息构建查询对象
     */
    public Example createExample(User user){
        Example example=new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        if(user!=null){
            // 用户ID
            if(!StringUtils.isEmpty(user.getId())){
                    criteria.andEqualTo("id",user.getId());
            }
            // 用户姓名
            if(!StringUtils.isEmpty(user.getName())){
                    criteria.andLike("name","%"+user.getName()+"%");
            }
            // 手机号码
            if(!StringUtils.isEmpty(user.getTel())){
                    criteria.andEqualTo("tel",user.getTel());
            }
            // 密码
            if(!StringUtils.isEmpty(user.getPassword())){
                    criteria.andEqualTo("password",user.getPassword());
            }
        }
        return example;
    }

    /**
     * 删除
     */
    public void deleteUserById(Long id){
        userMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改用户信息
     */
    public void updateUser(User user){
        userMapper.updateByPrimaryKey(user);
    }

    /**
     * 增加用户信息
     */
    public void insertUser(User user){
        userMapper.insertSelective(user);
    }

    /**
     * 根据ID查询用户信息
     */
    public User selectUserById(Long id){
        return  userMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询用户信息全部数据
     */
    public List<User> selectAll() {
        return userMapper.selectAll();
    }
}
