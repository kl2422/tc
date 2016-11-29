package com.shsxt.crm.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.shsxt.crm.dao.ContactDao;
import com.shsxt.crm.model.Contact;
import com.shsxt.crm.query.LinkManQuery;
import com.shsxt.crm.util.AssertUtil;

@Service
public class ContactService {
	
	@Autowired
	private ContactDao contactDao;

	/**
	 * 分页查询
	 * @param query
	 * @return
	 */
	public Map<String, Object> selectForPage(LinkManQuery query) {
		PageList<Contact> linkMans = (PageList<Contact>) contactDao
				.selectForPage(query, query.initPageBounds());
		Map<String, Object> result = new HashMap<>();
		result.put("rows", linkMans);
		result.put("total", linkMans.getPaginator().getTotalCount());
		return result;
	}
	
	/**
	 * 新增或者修改
	 * @param contact
	 */
	public void addOrUpdate(Contact contact) {
		
		// 校验
		AssertUtil.isTrue(contact.getContactTime() == null, "请输入交往的时间");
		AssertUtil.notEmpty(contact.getAddress(), "请输入交往的地址");
		AssertUtil.notEmpty(contact.getOverview(), "请输入交往的内容");
		// 判断id是否新增还是修改
		if (contact.getId() != null) {
			contactDao.update(contact);
        } else {
        	contactDao.insert(contact);
        }
		
	}
	
	/**
	 * 删除
	 * @param id
	 */
	public void delete(Integer id) {
		AssertUtil.isTrue(id == null || id < 1, "请选择一条记录");
		contactDao.delete(id);
	}
	
}
