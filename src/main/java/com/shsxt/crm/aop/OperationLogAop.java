package com.shsxt.crm.aop;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import com.shsxt.crm.annotation.OptLog;
import com.shsxt.crm.mongodb.OperationLog;
import com.shsxt.crm.util.LoginUserUtil;

@Component
@Aspect
public class OperationLogAop {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	@Autowired
	private HttpServletRequest request;
	
	@Pointcut(value = "@annotation(com.shsxt.crm.annotation.OptLog)")
	public void pointcut() {
		
	}
	
	@Around(value = "pointcut()&&@annotation(optLog)")
	public Object around(ProceedingJoinPoint pjp, OptLog optLog) throws Throwable {
		
		String module = optLog.module();
		String desc = optLog.desc();
		
		OperationLog operationLog = new OperationLog();
		operationLog.setArgs(pjp.getArgs());
		operationLog.setDesc(desc);
		MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
		operationLog.setMethod(methodSignature.getName());
		operationLog.setModule(module);
		Integer userId = LoginUserUtil.loadUserIdFromCookie(request);
		operationLog.setOptUserId(userId);
		String userName = LoginUserUtil.loadUserNameFromCookie(request);
		operationLog.setOptUserName(userName);
		mongoTemplate.save(operationLog);
		return pjp.proceed();
		
	}
	
	
}
