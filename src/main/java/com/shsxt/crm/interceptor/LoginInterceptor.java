package com.shsxt.crm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.shsxt.base.exception.LoginBizException;
import com.shsxt.crm.constant.Constant;
import com.shsxt.crm.util.LoginUserUtil;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	
	private static Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("方法执行前。。。。。。" + handler.toString());
		Integer loginUserId = LoginUserUtil.loadUserIdFromCookie(request);
		if (loginUserId == null || loginUserId < 1) {
			throw new LoginBizException(Constant.LOGIN_FIRST);
		}
		return super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.info("方法执行。。。。。。" + handler.toString());
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		logger.info("方法执行后。。。。。。" + handler.toString());
		super.afterCompletion(request, response, handler, ex);
	}
	
	/**
	 * afterConcurrentHandlingStarted方法，该方法是用来处理异步请求
	 * 当Controller中有异步请求方法的时候会触发该方法。
	 * 异步请求先支持preHandle、然后执行afterConcurrentHandlingStarted
	 * 异步线程完成之后执行preHandle、postHandle、afterCompletion
	 */

	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterConcurrentHandlingStarted(request, response, handler);
	}
	
	

}
