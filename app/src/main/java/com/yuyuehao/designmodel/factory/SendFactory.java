package com.yuyuehao.designmodel.factory;

/**
 * Created by Wang
 * on 2018-09-19
 */

public class SendFactory {



    public static Sender produceMail(){
        return new MailSender();
    }

    public static Sender produceSms(){
        return new SmsSender();
    }
}
