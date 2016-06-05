package com.example.mac.xmppdemo01;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mac.xmppdemo01.common.XMPPUtil;
import com.example.mac.xmppdemo01.data.DataWarehouse;
import com.example.mac.xmppdemo01.data.LoginActivity;
import com.example.mac.xmppdemo01.data.LoginData;

import org.jivesoftware.smack.XMPPConnection;

public class MainActivity extends AppCompatActivity {

    private EditText mEditTextUsername;
    private EditText mEditTextPassword;
    private EditText mEditTextServer;
    private CheckBox mCheckBoxSavePassword;
    private CheckBox mCheckBoxAutoLogin;
    private LoginData mLoginData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditTextUsername = (EditText) findViewById(R.id.username);
        mEditTextPassword = (EditText) findViewById(R.id.password);
        mEditTextServer = (EditText) findViewById(R.id.server);
        mCheckBoxSavePassword = (CheckBox) findViewById(R.id.checkBox1);
        mCheckBoxAutoLogin = (CheckBox) findViewById(R.id.checkBox2);

        mLoginData = DataWarehouse.getApplication(this).loginData;

    }

    private Handler mHandler=new Handler();

    private boolean login(){

        try{
            XMPPConnection connection = XMPPUtil.getXMPPConnection(MainActivity.this,mLoginData.loginServer);
            if(connection==null){
               throw new Exception("连接聊天服务器失败");
            }
            connection.login(mLoginData.username, mLoginData.password);
            DataWarehouse.setXMPPConnection(MainActivity.this,connection);



        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }



    public void onClick_Login(View view){
        mLoginData.username= mEditTextUsername.toString();
        mLoginData.password=mEditTextPassword.toString();
        mLoginData.loginServer=mEditTextServer.toString();
        mLoginData.issAutoLogin=mCheckBoxAutoLogin.isChecked();
        mLoginData.isSavePassword=mCheckBoxSavePassword.isChecked();

        new Thread(new Runnable() {
            @Override
            public void run() {
                if(login()){
                    Intent intent =new Intent (MainActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                 mHandler.post(new Runnable() {
                     @Override
                     public void run() {
                         Toast.makeText(MainActivity.this,"连接失败",Toast.LENGTH_SHORT).show();
                     }
                 });
                }
            }
        }).start();



    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
