package com.designPattern.decorator;

/**
 * Created by shawn on 2017/8/6.
 */
public abstract class ShapDecorator implements  Shape{
    //注意,这里才带接口变量,这个接口变量是装饰的基础。
    private  Shape decoratedShape;

    /**
     *1.装饰者模式就是需要客户端还是透明的方式访问,既然都是继承自同一接口就是透明方式。 <br>
     *2.我要能够添加功能。既然((A)B)C,A被包装成B,B被包装成C.实际上先产生A对象再产生B对象再产生C对象。
     */

    public ShapDecorator(Shape shape)
    {
        this.decoratedShape = shape;
    }
    @Override
    public void draw() {
        decoratedShape.draw();
    }
}
