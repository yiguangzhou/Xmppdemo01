package com.example.mac.xmppdemo01.common;

import android.util.Log;

import org.jivesoftware.smack.Roster;
import org.jivesoftware.smack.RosterEntry;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.packet.Packet;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.util.StringUtils;

import java.util.Collection;

/**
 * 更改用户状态
 * Created by mac on 16/6/7.
 */
public class setPresence {
    public void setPresence(XMPPConnection conn,int code) throws SmackException.NotConnectedException {
        if(conn==null) return;
        Presence presence;
       switch (code){
           case 0:
               presence=new Presence(Presence.Type.available);
               conn.sendPacket(presence);
               Log.v("state","设置在线");
               break;
           case 1:
               presence=new Presence(Presence.Type.available);
               presence.setMode(Presence.Mode.chat);
               conn.sendPacket(presence);
               Log.v("state","设置Q我吧");
               System.out.printf(String.valueOf(presence.toXML()));
               break;
           case 2:
               presence=new Presence(Presence.Type.available);
               presence.setMode(Presence.Mode.dnd);
               conn.sendPacket(presence);
               Log.v("state","设置忙碌");
               System.out.println(presence.toXML());
               break;
           case 3:
               presence=new Presence(Presence.Type.available);
               presence.setMode(Presence.Mode.away);
               conn.sendPacket(presence);
               Log.v("state","设置离开");
               System.out.println(presence.toXML());
           case 4:
               Roster roster=conn.getRoster();
               Collection<RosterEntry> entries=roster.getEntries();
               for(RosterEntry entry:entries){
                   presence =new Presence(Presence.Type.unavailable);
                   presence.setPacketID(Packet.ID_NOT_AVAILABLE);
                   presence.setFrom(conn.getUser());
                   presence.setTo(entry.getUser());
                   conn.sendPacket(presence);
                   System.out.println(presence.toXML());
               }
               //向同一用户的其他客户端发送隐身状态
               presence=new Presence(Presence.Type.unavailable);
               presence.setPacketID(Packet.ID_NOT_AVAILABLE);
               presence.setFrom(conn.getUser());
               presence.setTo(StringUtils.parseBareAddress(conn.getUser()));
               conn.sendPacket(presence);
               Log.v("state","设置隐身");
               break;
           case 5:
               presence=new Presence(Presence.Type.unavailable);
               conn.sendPacket(presence);
               Log.v("state","设置离线");
               break;
           default:
               break;

       }
    }

}
