package com.example.mac.xmppdemo01.data;

import android.content.Context;

import org.jivesoftware.smack.XMPPConnection;

/**
 * Created by mac on 16/6/5.
 */
public class DataWarehouse {
    /**
     *  数据仓库
     * @param ctx
     * @return
     */
    public static MyApplication getApplication(Context ctx){
        return (MyApplication) ctx.getApplicationContext();
    }
    public static XMPPConnection getXMPPConnection(Context ctx){
        return getApplication(ctx).xmppConnection;
    }
    public static  void setXMPPConnection(Context ctx,XMPPConnection conn){
        getApplication(ctx).xmppConnection=conn;
    }
}
