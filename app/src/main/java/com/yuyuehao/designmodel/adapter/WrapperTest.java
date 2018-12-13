package com.yuyuehao.designmodel.adapter;

/**
 * Created by Wang
 * on 2018-09-19
 */

public class WrapperTest {

    public static void main(String[] args) {

//接口的适配器模式：当不希望实现一个接口中所有的方法时，可以创建一个抽象类Wrapper，实现所有方法，我们写别的类的时候，继承抽象类即可。
        Sourceable s1 = new SourceSub1();

        Sourceable s2 = new SourceSub2();

        s1.method1();
        s1.method2();

        s2.method1();
        s2.method2();
    }
}
