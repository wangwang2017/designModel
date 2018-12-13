package com.yuyuehao.designmodel.decorator;

/**
 * Created by Wang
 * on 2018-09-19
 */

public class Decorator implements Sourceable {

    private Sourceable mSourceable;

    public Decorator(Sourceable mSourceable){
        super();
        this.mSourceable = mSourceable;
    }


    @Override
    public void method() {
        System.out.println("before decorator!");
        mSourceable.method();
        System.out.println("after decorator!");
    }
}
