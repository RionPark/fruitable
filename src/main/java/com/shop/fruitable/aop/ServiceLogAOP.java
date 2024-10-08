package com.shop.fruitable.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class ServiceLogAOP {
	@Pointcut("execution(*int com.shop.fruitable.service.*.*(..))")
	private void allService() {}
	
	@Before("allService()")
	public void before(JoinPoint jp) {
		log.info("before execute Service");
	}
}
