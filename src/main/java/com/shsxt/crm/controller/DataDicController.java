package com.shsxt.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shsxt.base.BaseController;
import com.shsxt.crm.model.DataDic;
import com.shsxt.crm.service.DataDicService;

@RestController
@RequestMapping("datadic")
public class DataDicController extends BaseController {
	
	@Autowired
	private DataDicService dataDicService;
	
	@RequestMapping("dataDicComboList")
	public List<DataDic> find(String dataDicName) {
		List<DataDic> result = dataDicService.findValueByType(dataDicName);
		return result;
	}
}
