package com.enjoy02.service;

import com.enjoy02.dao.LogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LogService {
    @Autowired
    private LogDao logDao;

    //FIXME 自己写明目的，逾期结果，最终结果<br>
    @Transactional(propagation = Propagation.NEVER)
    public void addLog() {
        logDao.addLog();  //如果有一条数据
        int i = 10 / 0;
        logDao.addLog();
    }


}
