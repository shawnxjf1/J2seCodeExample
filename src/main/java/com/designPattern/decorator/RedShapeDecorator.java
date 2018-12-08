package com.designPattern.decorator;

import com.support.PrintUtil;

/**
 * Created by shawn on 2017/8/6.
 */
public class RedShapeDecorator extends  ShapDecorator{

    //虽然没有写成员,但是代码上它继承了ShapDecorator。实际上是有private  Shape decoratedShape;成员在的
    public  RedShapeDecorator(Shape shape)
    {
        super(shape);
    }

    @Override
    public void draw() {
        super.draw();
    }

    public  void setBorder()
    {
        PrintUtil.SysOut("set border red",this);
    }
}
