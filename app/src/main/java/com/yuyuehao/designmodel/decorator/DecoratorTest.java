package com.yuyuehao.designmodel.decorator;

/**
 * Created by Wang
 * on 2018-09-19
 */

public class DecoratorTest {

    /**装饰器模式的应用场景：

     1、需要扩展一个类的功能。

     2、动态的为一个对象增加功能，而且还能动态撤销。（继承不能做到这一点，继承的功能是静态的，不能动态增删。）

     缺点：产生过多相似的对象，不易排错！*/


    public static void main(String[] args) {
        Sourceable s = new Source();
        Sourceable obj = new Decorator(s);
        obj.method();
    }
}
