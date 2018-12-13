package com.yuyuehao.designmodel.factory;

/**
 * Created by Wang
 * on 2018-09-19
 */

public class SendSmsFactory implements Provider {

    @Override
    public Sender produce() {
        return new SmsSender();
    }
}
