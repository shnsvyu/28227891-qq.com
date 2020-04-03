package com.ehr.basic.controller;

import java.util.List;


import org.assertj.core.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.ehr.basic.entity.PSalaryItems;
import com.ehr.basic.service.PSalaryItemsService;

/**
 * @Class description:
 * @Copyright: Copyright (c) 2002-2020  CO.,LTD. All rights reserved.
 * @
 * @Author: liupengfei
 * @Creation time: 2020年2月22日上午1:05:54
 */
@RestController
@RequestMapping("/PSalaryItems")
public class PSalaryItemsController {
	@Autowired
	private PSalaryItemsService pSalaryItemsService;

	/**
	 * 
	 * @Fields description:条件构造
	 * @时间：2020年2月23日 上午12:29:14
	 * @作者：liupengfei
	 * @param pSalaryItems
	 * @return
	 */
	private EntityWrapper<PSalaryItems> wrapper(PSalaryItems pSalaryItems) {
		EntityWrapper<PSalaryItems> ew = new EntityWrapper<>();
		ew.where(!Strings.isNullOrEmpty(pSalaryItems.getId()), "id={0}", pSalaryItems.getId())
				.like(!Strings.isNullOrEmpty(pSalaryItems.getSalaryItemsName()), "salary_items_name",
						"%" + pSalaryItems.getSalaryItemsName() + "%")
				.where(pSalaryItems.getStatusC() != 0, "status_c={0}", pSalaryItems.getStatusC());
		return ew;
	}

	/**
	 * 
	 * @Fields description:保存
	 * @时间：2020年2月23日 上午1:07:19
	 * @作者：liupengfei
	 * @param pSalaryItems
	 * @return
	 */
	@RequestMapping("/save")
	public PSalaryItems save(@ModelAttribute PSalaryItems pSalaryItems) {
		if (!"".equals(pSalaryItems.getId())) {
			pSalaryItemsService.updateById(pSalaryItems);
        } else {
        	pSalaryItemsService.insert(pSalaryItems);
        }
        return pSalaryItems;
	}
	/**
	 * 
	 * @Fields description:删除
	 * @时间：2020年2月23日 上午1:07:57
	 * @作者：liupengfei
	 * @param pSalaryItems
	 * @return
	 */
	@RequestMapping("/delete")
	public boolean delete(@ModelAttribute PSalaryItems pSalaryItems) {
		return pSalaryItemsService.delete(wrapper(pSalaryItems));
	}
	
	/**
	 * 
	 * @Fields description:修改
	 * @时间：2020年2月23日 上午1:08:10
	 * @作者：liupengfei
	 * @param pSalaryItems
	 * @return
	 */
	@RequestMapping("/update")
	public boolean update(@ModelAttribute PSalaryItems pSalaryItems) {
		if(!"".equals(pSalaryItems.getId())) return false;
		EntityWrapper<PSalaryItems> ew = new EntityWrapper<>();
		ew.where("id={0}", pSalaryItems.getId());
		return pSalaryItemsService.update(pSalaryItems, ew);
	}
	
	
	/**
	 * 
	 * @Fields description:获取条件下的所有数据
	 * @时间：2020年2月23日 上午12:29:38
	 * @作者：liupengfei
	 * @param pSalaryItems
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getAll")
	public List<PSalaryItems> getAll(@ModelAttribute PSalaryItems pSalaryItems) throws Exception {
		return pSalaryItemsService.selectList(wrapper(pSalaryItems));
	}

	/**
	 * 
	 * @Fields description:分页查询
	 * @时间：2020年2月23日 上午12:30:00
	 * @作者：liupengfei
	 * @param pSalaryItems
	 * @param currentPage
	 * @param pageSize
	 * @return
	 * @throws Exception
	 * http://localhost:8088/PSalaryItems/getAllPage?id=1&current=1&size=2
	 */
	@RequestMapping("/getAllPage")
	public List<PSalaryItems> getAllPage(@ModelAttribute PSalaryItems pSalaryItems, Page<PSalaryItems> page)
			throws Exception {
		Page<PSalaryItems> userIPage = pSalaryItemsService.selectPage(page, wrapper(pSalaryItems));
		System.out.printf("总条数 -------------> " + userIPage.getTotal());
		System.out.printf("当前页数 -------------> " + userIPage.getCurrent());
		System.out.printf("当前每页显示数 ------------->" + userIPage.getSize());
		return userIPage.getRecords();
	}

	/**
	 * 
	 * @Fields description:指定ID查询
	 * @时间：2020年2月23日 上午12:30:17
	 * @作者：liupengfei
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/load/{id}")
	public PSalaryItems load(@PathVariable(required = true, value = "id") int id) throws Exception {
		return pSalaryItemsService.selectById(id);
	}
}
