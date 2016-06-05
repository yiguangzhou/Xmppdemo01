package com.example.mac.xmppdemo01.common;

import android.content.Context;

import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.SASLAuthentication;
import org.jivesoftware.smack.SmackAndroid;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;

/**
 * Created by mac on 16/6/5.
 */
public class XMPPUtil {
      //获取聊天服务器连接
    public static XMPPConnection getXMPPConnection(Context context,String server,int port){
        try {
            SmackAndroid.init(context);

            ConnectionConfiguration configuration=new ConnectionConfiguration(server);
            configuration.setReconnectionAllowed(true);
            configuration.setSecurityMode(ConnectionConfiguration.SecurityMode.disabled);
            configuration.setSendPresence(true);
            SASLAuthentication.supportSASLMechanism("PLAIN",0);


            XMPPConnection connection =new XMPPTCPConnection(configuration,null);
            connection.connect();
            return connection;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static XMPPConnection getXMPPConnection(Context context,String server){
        return  getXMPPConnection(context,server,5222);
    }
}
