package com.yuyuehao.designmodel.adapter;

/**
 * Created by Wang
 * on 2018-09-19
 */

public class Wrapper implements Targetable {

    private Source source;


    public Wrapper(Source source){
        super();
        this.source = source;
    }

    @Override
    public void method1() {
        source.method1();
    }

    @Override
    public void method2() {
        System.out.println("this is the targetable method!");
    }
}
