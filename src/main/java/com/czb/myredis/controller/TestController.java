package com.czb.myredis.controller;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.czb.myredis.conf.RedisUtil;

@RestController
@RequestMapping("/redis")
public class TestController {
	
	
	//private AtomicInteger count = new AtomicInteger();
	
	@Autowired
	private RedisUtil redisUtil;
	
	@RequestMapping(value = "/testSend",method = RequestMethod.GET)
	public String testSend(Integer count) throws InterruptedException{
		long startTime = System.currentTimeMillis();
		if(count==null){
			count = 1;
		}
		
		
		//meSend.setSendTime(new Date());
		for(Integer i=0;i<count;i++){
			redisUtil.set(UUID.randomUUID().toString(), i);
			//System.out.println(redisUtil.get("aa"));
		}
		
		long endTime = System.currentTimeMillis();
		
		return ((endTime-startTime)/1000.0 + "秒");  
	}
	
	
	
	
}
