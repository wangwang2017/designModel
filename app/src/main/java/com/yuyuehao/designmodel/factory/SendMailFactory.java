package com.yuyuehao.designmodel.factory;

/**
 * Created by Wang
 * on 2018-09-19
 */

public class SendMailFactory implements Provider {
    @Override
    public Sender produce() {
        return new MailSender();
    }
}
