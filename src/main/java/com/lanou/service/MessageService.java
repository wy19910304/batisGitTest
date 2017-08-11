package com.lanou.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lanou.bean.Message;
import com.lanou.mapper.MessageMapper;

@Service
public class MessageService {
	
	@Resource(name="msgMapper")
	private MessageMapper messageMapper;

	public PageInfo<Message> queryByPage(Integer pageNo,Integer pageSize){
		
		
		pageNo = pageNo == null?1:pageNo;
	    pageSize = pageSize == null?10:pageSize;
	    PageHelper.startPage(pageNo, pageSize);
	    List<Message> list111 = messageMapper.findAllMessages();
	    System.out.println("aaaaa"+list111.getClass());
	    //用PageInfo对结果进行包装
	    PageInfo<Message> page = new PageInfo<Message>(list111);
	    //测试PageInfo全部属性
//	    System.out.println(page.getPageNum());
//	    System.out.println(page.getPageSize());
//	    System.out.println(page.getStartRow());
//	    System.out.println(page.getEndRow());
//	    System.out.println(page.getTotal());
//	    System.out.println(page.getPages());
//	    System.out.println(page.getFirstPage());
//	    System.out.println(page.getLastPage());
//	    System.out.println(page.isHasPreviousPage());
//	    System.out.println(page.isHasNextPage());
	    return page;
	}

	
}
