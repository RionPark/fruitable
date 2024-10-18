package com.shop.fruitable.aop;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.shop.fruitable.util.HttpSessionUtil;

@Component
@Aspect
public class AuthAOP {
	@Around("execution(* com.shop.fruitable.controller.AdminController.*(..))")
	public Object authCheck(ProceedingJoinPoint pjp) throws Throwable {
		HttpSession session = HttpSessionUtil.getSession();
		if(session.getAttribute("user")==null) {
			throw new Exception("로그인이 필요합니다.");
		}
		return pjp.proceed();
	}
}