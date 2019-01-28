package com.designPattern.decorator;

/**
 * Created by shawn on 2017/8/6.
 */
public class DecoratorDemo {
    public static void main(String[] args) {
        Circle c = new Circle();
        Rectangle r = new Rectangle();
        Shape s1 = new RedShapeDecorator(c);
        Shape s2 = new RedShapeDecorator(r);
        s1.draw();
        s2.draw();
    }
}
