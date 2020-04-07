package com.gxlm.springboot.db.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.gxlm.springboot.db.entity.UserInfo;

/**
 * Description 类描述:
 * <br/> SpringBoot-Mybatis Dao层
 * 可以使用注解或者Mapper XML映射文件来处理SQL语句的问题.
 * 
 * @author 立子  E-mail: lingxiao.6540@foxmail.com
 * @version 创建时间：2018年11月28日 下午2:11:07
 */
//@Mapper注解表明这是一个mapper接口层,在SpringBoot中不可缺少,需要Spring将此接口扫描到IOC容器中管理
//这是不同于SSM结构的,毕竟在SSM中是命名明确配置了dao层接口的位置的
@Mapper
public interface UserDao {

//    @Insert("INSERT INTO tp_user(tel,password,nickname,secret) VALUES (#{tel},md5(#{password}),#{nickname},'')")
    void createUser(Map<String, Object> reqMap);

//    @Select("select tel,nickname,password FROM tp_user WHERE user_id = #{id}")
    UserInfo getUser(@Param("id") Integer id);

//    @Update("UPDATE tp_user SET nickname = #{nickName} WHERE user_id = #{userId}")
    void updateUser(@Param("userId") String user_id, @Param("nickName") String nickName);

//    @Delete("DELETE FROM tp_user WHERE tel = #{tel}")
    void deleteUserByUserId(UserInfo userInfo);
	
}

