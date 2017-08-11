package com.lanou.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lanou.bean.Message;

// 配置dao层注解, 用于对controller的依赖注入
@Repository("msgMapper")
public interface MessageMapper {
	
	// 添加一个新方法, 用来查询所有的消息
	List<Message> findAllMessages();
	
    int deleteByPrimaryKey(Integer id);

    int insert(Message record);

    int insertSelective(Message record);

    Message selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);
}