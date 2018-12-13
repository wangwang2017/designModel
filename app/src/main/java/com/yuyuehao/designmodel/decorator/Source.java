package com.yuyuehao.designmodel.decorator;

/**
 * Created by Wang
 * on 2018-09-19
 */

public class Source implements Sourceable {

    @Override
    public void method() {
        System.out.println("the original method!");
    }
}
