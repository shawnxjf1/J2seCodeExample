/**
 * Copyright (C), 2015-2019, XXX有限公司 FileName: EmailService Author: 58pc Date: 2019/4/26 20:22 Description: History:
 * <author> <time> <version> <desc> 作者姓名 修改时间 版本号 描述
 */
package com.shawn.springEventDemo;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

/**
 * 〈一句话功能简述〉<br>
 * 〈邮件发送服务继承ApplicationListener〉
 *
 * @author 58pc
 * @create 2019/4/26
 * @backgroud
 * @since 1.0.0
 */
@Service
public class EmailService implements ApplicationListener<UserRegisterEvent> {
    @Override
    public void onApplicationEvent(UserRegisterEvent userRegisterEvent) {
        System.out.println("邮件服务器接收到，给" + userRegisterEvent.getSource() + "注册的通知，准备给用户发送邮件");
    }
}
