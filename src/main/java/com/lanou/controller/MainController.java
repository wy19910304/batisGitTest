package com.lanou.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.lanou.bean.Message;
import com.lanou.mapper.MessageMapper;
import com.lanou.service.MessageService;
import com.lanou.utils.AjaxResult;

@Controller
public class MainController {
	
	// 使用spring的依赖注入(DI)
	// 可以使用Resource和Autowired注解
	@Resource(name="msgMapper")
	private MessageMapper messageMapper;
	
	@Resource
	private MessageService messageService;
	
	@RequestMapping(value="/")
	public String frontPage(){
		
		return "messageBoard";
	}
	
	@RequestMapping(value="/findall")
	@ResponseBody
	public List<Message> findAllMsg(){
		
		PageInfo<Message> pageInfo = messageService.queryByPage(1, 2);
		
		List<Message> messages = pageInfo.getList();
		return messages;
	}
	
	@RequestMapping(value="/addnew")
	@ResponseBody
	public AjaxResult allNewMessage(Message message){
		
		message.setUp(0);
		message.setDown(0);
		messageMapper.insert(message);
		
		AjaxResult ajaxResult = AjaxResult.ajaxResult("添加成功", "0", message);
		
		return ajaxResult;
	}
	
	// .../deleteone?msgid=2
	@RequestMapping(value="/deleteone")
	@ResponseBody
	public Map<String, Object> deleteOneMessage(@RequestParam("msgid") Integer id){
		
		Integer count = messageMapper.deleteByPrimaryKey(id);
		
		Map<String, Object> reMap = new HashMap<String, Object>();
		
		reMap.put("msg", "删除成功!!");
		reMap.put("errorCode", 0);
		reMap.put("obj", id);
		
		return reMap;
	}
	
	

}








