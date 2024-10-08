package com.shop.fruitable.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class LogAOP {
	@Pointcut("execution(* com.shop.fruitable.controller.*.*(..))")
	private void allController() {}
	//서비스의 모든 메서드에 대한 로그를 찍는데 리턴타입이 int인것만 로그를 찍어주세요
	@Before("allController()")
	public void before(JoinPoint jp) {
		log.info("before execute controller");
	}

	@After("allController()")
	public void after(JoinPoint jp) {
		log.info("after execute controller");
	}

	@Around("allController()")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		log.info("aorund before execute controller");
		Object obj = pjp.proceed();
		log.info("around after execute controller");
		return obj;
	}
}
