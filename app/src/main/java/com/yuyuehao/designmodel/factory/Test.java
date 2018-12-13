package com.yuyuehao.designmodel.factory;

/**
 * Created by Wang
 * on 2018-09-19
 */

public class Test {

    public static void main(String[] args) {
        Provider provider = new SendMailFactory();
        Sender sender = provider.produce();
        sender.Send();
    }
}
