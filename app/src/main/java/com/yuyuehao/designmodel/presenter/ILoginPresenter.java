package com.yuyuehao.designmodel.presenter;

/**
 * Created by Wang
 * on 2018-12-11
 */

public interface ILoginPresenter {
    void clear();
    void doLogin(String name,String password);
    void setProgressBarVisibility(int visibility);
}
