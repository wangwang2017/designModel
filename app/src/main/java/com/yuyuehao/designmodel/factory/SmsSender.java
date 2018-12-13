package com.yuyuehao.designmodel.factory;

/**
 * Created by Wang
 * on 2018-09-19
 */

public class SmsSender implements Sender {

    @Override
    public void Send() {
        System.out.println("this is smsSender");
    }
}
