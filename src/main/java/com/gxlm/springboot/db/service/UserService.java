package com.gxlm.springboot.db.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gxlm.springboot.db.dao.UserDao;
import com.gxlm.springboot.db.entity.UserInfo;

/**
 * Description 类描述:
 * <br/>
 * 
 * @author 立子  E-mail: lingxiao.6540@foxmail.com
 * @version 创建时间：2018年11月28日 下午2:43:50
 */
@Service
public class UserService {
	
	@Autowired
    private UserDao userDao;


    public void updateUser(String user_id, String nickName) {
    	userDao.updateUser(user_id,nickName);
    }

    public UserInfo getUser(Integer id) {
        return userDao.getUser(id);
    }

    public void deleteUserByUserId(UserInfo userInfo) {
    	userDao.deleteUserByUserId(userInfo);
    }

    public void createUser(Map<String, Object> reqMap) {
    	userDao.createUser(reqMap);
    }

}

