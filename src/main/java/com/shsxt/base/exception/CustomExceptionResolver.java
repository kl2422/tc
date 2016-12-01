package com.shsxt.base.exception;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import com.alibaba.fastjson.JSON;
import com.shsxt.crm.constant.Constant;

/**
 * 全局异常处理
 */
public class CustomExceptionResolver extends SimpleMappingExceptionResolver {

    private Logger logger = LoggerFactory.getLogger(CustomExceptionResolver.class);

    @Override
    protected ModelAndView doResolveException(HttpServletRequest request,
                                              HttpServletResponse response, Object handler, Exception ex) {
        logger.error("", ex);
        // 判断是否有默认的处理页面
        String viewName = determineViewName(ex, request);
        if (StringUtils.isNotBlank(viewName)) {
            return getModelAndView("exception", ex, request);
        }
       
        // 如果是登录异常跳转到登录界面
        if (ex instanceof LoginBizException) {
        	ModelAndView mv = new ModelAndView("error");
        	mv.addObject("message", Constant.LOGIN_FIRST);
        	mv.addObject("ctx", request.getContextPath());
        	mv.addObject("uri", request.getRequestURI());
            return mv;
        }
        /*
        if(Constant.LOGIN_FIRST.equals(message)) {
        	ModelAndView mv = new ModelAndView("error");
        	mv.addObject("message", Constant.LOGIN_FIRST);
        	mv.addObject("ctx", request.getContextPath());
        	mv.addObject("uri", request.getRequestURI());
            return mv;
        }*/
        
        // 如果是其他异常的话就以json格式返回
        int resultCode = 0;
        String message = ex.getMessage();
        if (ex instanceof ParamException) {
            message = ((ParamException) ex).getMessage();
            resultCode = ((ParamException) ex).getErrorCode();
        }
        Map<String, Object> param = new HashMap<>();
        if (StringUtils.isBlank(message)) {
        	message = "未知异常，请联系老裴。";
        }
        param.put("message", message);
        param.put("resultCode", resultCode);
        
        PrintWriter out = null;
        try {
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();
            out.print(JSON.toJSON(param));
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
        return super.doResolveException(request, response, handler, ex);
    }
}

