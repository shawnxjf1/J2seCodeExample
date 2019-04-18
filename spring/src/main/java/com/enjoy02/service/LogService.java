
package com.enjoy02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.enjoy02.dao.LogDao;

@Service
public class LogService {
	@Autowired
	private LogDao logDao;

	@Transactional(propagation=Propagation.NEVER)
	public void addLog(){
		logDao.addLog();  //如果有一条数据
		int i =10/0;
		logDao.addLog();
	}


}
