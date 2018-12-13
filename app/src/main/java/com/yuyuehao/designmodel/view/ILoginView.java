package com.yuyuehao.designmodel.view;

/**
 * Created by Wang
 * on 2018-12-11
 */

public interface ILoginView {
    public void onClearText();
    public void onLoginResult(boolean result,int code);
    public void onSetProgressBarVisibility(int visibility);

}
