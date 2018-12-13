package com.yuyuehao.designmodel.model;

/**
 * Created by Wang
 * on 2018-12-11
 */

public interface IUser {
    String getName();
    String getPassword();
    int checkUserValidity(String name,String password);
}
