package com.example.mac.xmppdemo01.data;

import android.app.Application;

import org.jivesoftware.smack.XMPPConnection;

/**
 * Created by mac on 16/6/5.
 */
public class MyApplication extends Application {

  public XMPPConnection xmppConnection;
  public LoginData loginData =new LoginData();


}
