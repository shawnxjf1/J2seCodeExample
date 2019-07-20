/**
 * Copyright (C), 2015-2019, XXX有限公司 FileName: UserService Author: 58pc Date: 2019/4/26 20:10 Description: History:
 * <author> <time> <version> <desc> 作者姓名 修改时间 版本号 描述
 */
package com.shawn.springEventDemo;

import org.springframework.stereotype.Service;

/**
 * 〈一句话功能简述〉<br>
 * 〈用户服务（该demo中，用户注册服务后需要发邮件，初始化积分等操作）〉 背景
 * 定义业务需求：用户注册后，系统需要给用户发送邮件告知用户注册成功，需要给用户初始化积分；隐含的设计需求，用户注册后，后续需求可能会添加其他操作，如再发送一条短信等等，希望程序具有扩展性，以及符合开闭原则。
 * 
 * @author 58pc
 * @create 2019/4/26
 * @backgroud
 * @since 1.0.0
 */
@Service
public class UserService {

    // @Autowired
    // EmailService emailService;
    // @Autowired
    // ScoreService scoreService;

    public void register(String name) {
        System.out.println("用户注册");
        // emailService.sendEmail(name)
        // scoreService.initSoce(name);
    }

}
