package com.gxlm.springboot.web.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gxlm.springboot.db.entity.UserInfo;
import com.gxlm.springboot.db.service.UserService;

/**
 * Description 类描述:
 * <br/>Mybatis 整合测试
 * 
 * @author 立子  E-mail: lingxiao.6540@foxmail.com
 * @version 创建时间：2018年11月28日 下午2:09:49
 */
@RestController
public class MybatisController {
	
    @Autowired
    private UserService userService;
    
    /**
     * 更新用户信息
     * 
     * @author 立子
     * @version 日期:2020年4月7日
     * @param user_id
     * @param nickName
     */
    @PutMapping("/update/{id}")
    public void updateUser(@PathVariable("id") String user_id, @RequestParam("nickName") String nickName){
        userService.updateUser(user_id,nickName);
    }

    /**
     * 获取用户信息
     * 
     * @author 立子
     * @version 日期:2020年4月7日
     * @param id
     * @return
     */
    @GetMapping("/user/{id}")
    public UserInfo getUser(@PathVariable("id")  Integer id){
        return userService.getUser(id);
    }

    /**
     * 删除用户
     * 
     * @author 立子
     * @version 日期:2020年4月7日
     * @param tel
     */
    @DeleteMapping("/delByTel/{tel}")
    public void deleteUserByUserId(@PathVariable("tel")  String tel){
        UserInfo user  = new UserInfo();
        user.setTel(Long.valueOf(tel));
        userService.deleteUserByUserId(user);
    }

    /**
     * 使用@RequestBody获取参数，用map类型接收，再取出
     * 
     * @author 立子
     * @version 日期:2020年4月7日
     * @param reqMap
     */
    @PostMapping("/save")
    public void createUserByMap(@RequestBody Map<String,Object> reqMap){
        userService.createUser(reqMap);
    }

}

