package com.example.mac.xmppdemo01.common;


import org.jivesoftware.smack.PacketCollector;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.filter.AndFilter;
import org.jivesoftware.smack.filter.PacketFilter;
import org.jivesoftware.smack.filter.PacketIDFilter;
import org.jivesoftware.smack.filter.PacketTypeFilter;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Registration;
/*

//1 注册成功, 0,服务器没有返回结果, 2, 这个账号已经存在,3,注册失败
public class register {
    public String register(XMPPConnection conn, String account, String password) throws SmackException.NotConnectedException {
        if (conn == null) {
            return "0";
        }
        Registration reg = new Registration();
        reg.setType(IQ.Type.SET);
        reg.setTo(conn.getServiceName());

       // reg.setUsername(account);
       // reg.setPassword(password);


    }
}

}

*/