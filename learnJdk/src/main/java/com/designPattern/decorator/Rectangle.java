package com.designPattern.decorator;

import com.support.PrintUtil;

/**
 * Created by shawn on 2017/8/6.
 */
public class Rectangle implements  Shape{
    @Override
    public void draw() {
        PrintUtil.SysOut("draw Rectangle",this);
    }
}
