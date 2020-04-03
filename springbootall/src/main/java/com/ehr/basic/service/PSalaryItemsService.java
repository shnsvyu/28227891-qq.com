package com.ehr.basic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ehr.basic.entity.PSalaryItems;
import com.ehr.basic.mapper.PSalaryItemsMapper;

/** 
 * @Class description:
 * @Copyright: Copyright (c) 2002-2020  CO.,LTD.  All rights reserved.
 * @
 * @Author: liupengfei
 * @Creation time: 2020年2月22日上午1:01:57 
 */
@Service
public class PSalaryItemsService extends ServiceImpl<PSalaryItemsMapper, PSalaryItems>{
	@Autowired
    PSalaryItemsMapper pSalaryItemsMapper;
	
}
