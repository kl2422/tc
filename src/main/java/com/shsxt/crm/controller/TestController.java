package com.shsxt.crm.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shsxt.base.ResultInfo;

@RestController
public class TestController {
	
	@RequestMapping("test")
	public ResultInfo test() {
		return new ResultInfo(0, "hello");
	}
	
	@RequestMapping("test1")
	public ResultInfo test1() {
		return new ResultInfo(0, "hello11");
	}
	
	@RequestMapping("test2")
	public String test2() {
		return "index";
	}
}
