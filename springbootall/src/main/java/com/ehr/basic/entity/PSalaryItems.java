package com.ehr.basic.entity;


import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Generated;
import lombok.experimental.Accessors;
/**
 * 
 * Class description:
 * Copyright: Copyright (c) 2002-2020  CO.,LTD.  All rights reserved.
 * 
 * Author: liupengfei
 * Creation time: 2020年2月22日上午12:00:04
 */

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("p_salary_items")
public class PSalaryItems implements Serializable {
	private static final long serialVersionUID = 1L;
	//type= IdType.AUTO
	
	@TableId(value="id",type= IdType.ID_WORKER_STR)
	private String Id;

	@TableField("creater_by")
	private String createrBy;
	
	@TableField("creater_name")
	private String createrName;
	
	@TableField("creater_date")
	private Date createrDate;
	
	@TableField("salary_items_name")
	private String salaryItemsName;
	
	@TableField("salary_items_type")
	private int salaryItemsType;
	
	@TableField("accuracy")
	private int accuracy;
	
	@TableField("is_salary_archives")
	private int isSalaryArchives;
	
	@TableField("status_c")
	private int statusC;
	

	public PSalaryItems() {
		
	}


	
	
}
