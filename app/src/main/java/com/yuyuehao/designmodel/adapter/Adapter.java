package com.yuyuehao.designmodel.adapter;

/**
 * Created by Wang
 * on 2018-09-19
 */

public class Adapter extends Source implements Targetable {


    @Override
    public void method2() {
        System.out.println("this is the targetable method!");
    }
}
