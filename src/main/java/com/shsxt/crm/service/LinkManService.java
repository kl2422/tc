package com.shsxt.crm.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.shsxt.base.BaseQuery;
import com.shsxt.crm.dao.LinkManDao;
import com.shsxt.crm.model.LinkMan;
import com.shsxt.crm.util.AssertUtil;

@Service
public class LinkManService {
	
	@Autowired
	private LinkManDao linkManDao;
	
	/**
	 * 分页查询
	 * @param query
	 * @return
	 */
	public Map<String, Object> selectForPage(BaseQuery query) {
		PageList<LinkMan> linkMans = (PageList<LinkMan>) linkManDao
				.selectForPage(query, query.initPageBounds());
		Map<String, Object> result = new HashMap<>();
		result.put("rows", linkMans);
		result.put("total", linkMans.getPaginator().getTotalCount());
		return result;
	}
	
	/**
	 * 添加或者修改
	 * @param linkMan
	 */
	public void addOrUpdate(LinkMan linkMan) {
		
		// 基本参数验证
		AssertUtil.notEmpty(linkMan.getLinkName(), "请输入联系人的姓名");
		AssertUtil.notEmpty(linkMan.getSex(), "请选择性别");
		AssertUtil.notEmpty(linkMan.getZhiwei(), "请输入联系人的职位");
		AssertUtil.notEmpty(linkMan.getOfficePhone(), "请输入联系人的办办公室电话");
		AssertUtil.notEmpty(linkMan.getPhone(), "请输入联系人的电话");
		
		// 判断新增还是修改
		if (linkMan.getId() != null) {
            linkManDao.update(linkMan);
        } else {
            linkManDao.insert(linkMan);
        }
	}
	
	/**
	 * 删除
	 * @param id
	 */
	public void delete(Integer id) {
		AssertUtil.isTrue(id == null || id < 1, "请选择要删除的记录");
		linkManDao.delete(id);
	}

}
