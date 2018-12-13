package com.yuyuehao.designmodel;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.yuyuehao.designmodel.presenter.ILoginPresenter;
import com.yuyuehao.designmodel.presenter.LoginPresenterCompl;
import com.yuyuehao.designmodel.view.ILoginView;

public class MainActivity extends AppCompatActivity implements ILoginView{

    private EditText username;
    private EditText password;
    private Button login;
    private Button clear;
    private ProgressBar progressBar;
    ILoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) this.findViewById(R.id.username);
        password = (EditText) this.findViewById(R.id.password);
        login = (Button) this.findViewById(R.id.login);
        clear = (Button) this.findViewById(R.id.clear);
        progressBar = (ProgressBar) this.findViewById(R.id.progressBar);
        mLoginPresenter = new LoginPresenterCompl(this);

        mLoginPresenter.setProgressBarVisibility(View.INVISIBLE);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLoginPresenter.setProgressBarVisibility(View.VISIBLE);
                login.setEnabled(false);
                clear.setEnabled(false);
                mLoginPresenter.doLogin(username.getText().toString(),password.getText().toString());
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLoginPresenter.clear();
            }
        });

    }

    @Override
    public void onClearText() {
        username.setText("");
        password.setText("");
    }

    @Override
    public void onLoginResult(boolean result, int code) {
        mLoginPresenter.setProgressBarVisibility(View.INVISIBLE);
        login.setEnabled(true);
        clear.setEnabled(true);
        if (result){
            Toast.makeText(this,"Login Success",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"Login Fail,code = "+code,Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onSetProgressBarVisibility(int visibility) {
        progressBar.setVisibility(visibility);
    }
}
