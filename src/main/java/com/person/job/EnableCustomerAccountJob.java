package com.facishare.crm.customeraccount.predefine.job;

import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.facishare.crm.customeraccount.dao.CustomerAccountConfigDao;
import com.facishare.crm.customeraccount.entity.CustomerAccountConfig;
import com.facishare.crm.customeraccount.predefine.manager.CustomerAccountManager;
import com.facishare.crm.customeraccount.predefine.service.dto.CustomerAccountType;
import com.facishare.paas.appframework.core.model.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class EnableCustomerAccountJob implements Job {

    @Autowired
    CustomerAccountManager customerAccountManager;

    @Autowired
    CustomerAccountConfigDao customerAccountConfigDao;

    /**
     * 1.这里描述具体的任务如何执行<br>
     * @param context
     * @throws JobExecutionException
     */
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        // 查询 customer_account_enable 为开启中 配置企业信息
        List<CustomerAccountConfig> customerAccountConfigList = customerAccountConfigDao.findEnterpriseWithCustomerAccountOpening();
        for (CustomerAccountConfig customerAccountConfig : customerAccountConfigList) {

            try {
                User user = new User(customerAccountConfig.getTenantId(), User.SUPPER_ADMIN_USER_ID);

                Integer totalCount = customerAccountManager.getAllCustomerCount(user);
                customerAccountManager.batchInitCustomerAccountData(user, totalCount, customerAccountConfig);

                //更新为已经开启
                customerAccountConfig.setCustomerAccountEnable(CustomerAccountType.CustomerAccountEnableSwitchStatus.ENABLE.getValue());
                customerAccountManager.enabledCustomerAccountSwitch(user, customerAccountConfig);
            } catch (Exception e) {
                log.error("error opening customerAccount,for tenantId:{}", customerAccountConfig.getTenantId());
            }
        }

    }


}
