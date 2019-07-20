/**
 * Copyright (C), 2015-2019, XXX有限公司 FileName: UserRegisterEvent Author: 58pc Date: 2019/4/26 20:18 Description:
 * History: <author> <time> <version> <desc> 作者姓名 修改时间 版本号 描述
 */
package com.shawn.springEventDemo;

import org.springframework.context.ApplicationEvent;

/**
 * 〈一句话功能简述〉<br>
 * 〈用户注册时间〉
 *
 * @author 58pc
 * @create 2019/4/26
 * @backgroud
 * @since 1.0.0
 */
public class UserRegisterEvent extends ApplicationEvent {
    @Override
    public Object getSource() {
        return super.getSource();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public UserRegisterEvent(String name) {
        super(name);
    }
}
