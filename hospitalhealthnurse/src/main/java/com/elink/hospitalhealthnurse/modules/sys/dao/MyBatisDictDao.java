/**
 * Copyright &copy; 2012-2013 <a href="https://github.com/elink">JeeSite</a> All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.elink.hospitalhealthnurse.modules.sys.dao;

import java.util.List;

import com.elink.hospitalhealthnurse.common.persistence.annotation.MyBatisDao;
import com.elink.hospitalhealthnurse.modules.sys.entity.Dict;

/**
 * MyBatis字典DAO接口
 * @author 刘灵星
 * @version 2013-8-23
 */
@MyBatisDao
public interface MyBatisDictDao {
	
    Dict get(String id);
    
    List<Dict> find(Dict dict);
    
}
