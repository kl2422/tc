package com.shsxt.crm.aop;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;

import com.shsxt.crm.annotation.OptLog;

//@Component
//@Aspect
public class TestAop {
	
	@Autowired
	private HttpServletRequest request;
	
	@Pointcut(value = "execution(* com.shsxt.crm.controller.*.*(..))")
	public void pointcut() {
		
	}
	
	@Around(value = "pointcut()")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println(pjp.toString());
		
		// 获取参数方式一
//		Object obj = pjp.getArgs();
		MethodSignature ms = (MethodSignature) pjp.getSignature();
		Method method = ms.getMethod();
		OptLog optLog = method.getAnnotation(OptLog.class);
		if (optLog == null) {
			return  pjp.proceed();
		} else { // 添加日志
			
		}
		
		
		// 获取参数方式二
//		Enumeration<String> map = request.getParameterNames();
//		while (map.hasMoreElements()) {
//			String name = (String) map.nextElement();
//			System.out.println(name + "----" + request.getParameter(name));
//		}
		
		Object result = pjp.proceed();
		return result;
	}
	
}
