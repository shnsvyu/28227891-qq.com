package com;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 
 * Class description:
 * Copyright: Copyright (c) 2002-2020  CO.,LTD.  All rights reserved.
 * 
 * Author: liupengfei
 * Creation time: 2020年2月21日下午10:11:41
 */


@SpringBootApplication
/*@MapperScan("com.ehr.basic.dao.PSalaryItemsDao")*/
@MapperScan("com.ehr")
public class Application {
    public static void main(String[] args) throws Exception {
         SpringApplication.run(Application.class, args);
     }
}