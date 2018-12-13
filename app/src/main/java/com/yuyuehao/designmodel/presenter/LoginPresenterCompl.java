package com.yuyuehao.designmodel.presenter;

import android.os.Handler;
import android.os.Looper;

import com.yuyuehao.designmodel.model.IUser;
import com.yuyuehao.designmodel.model.UserModel;
import com.yuyuehao.designmodel.view.ILoginView;

/**
 * Created by Wang
 * on 2018-12-11
 */

public class LoginPresenterCompl implements ILoginPresenter {

    ILoginView iLoginView;
    IUser user;
    Handler handler;

    public LoginPresenterCompl(ILoginView iLoginView) {
        this.iLoginView = iLoginView;
        initUser();
        this.handler = new Handler(Looper.getMainLooper());
    }

    private void initUser() {
        user = new UserModel("mvp","mvp");
    }

    @Override
    public void clear() {
        iLoginView.onClearText();
    }

    @Override
    public void doLogin(String name, String password) {
        Boolean isLoginSuccess = true;
        final int code = user.checkUserValidity(name,password);
        if (code!=0) isLoginSuccess = false;
        final Boolean result = isLoginSuccess;
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                iLoginView.onLoginResult(result, code);
            }
        }, 5000);
    }

    @Override
    public void setProgressBarVisibility(int visibility) {
        iLoginView.onSetProgressBarVisibility(visibility);
    }
}
