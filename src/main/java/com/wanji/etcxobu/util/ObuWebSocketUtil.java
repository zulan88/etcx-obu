package com.wanji.etcxobu.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;

import javax.websocket.Session;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class ObuWebSocketUtil {

    private static final ConcurrentHashMap<String, Session> sn2SessionMap = new ConcurrentHashMap<>();

    public static void add(String sn,Session session){
        sn2SessionMap.put(sn,session);
    }

    public static void remove(String sn){
        sn2SessionMap.remove(sn);
    }

    public static String remove(Session session){
        String key=null;
        for (Map.Entry<String,Session> entry : sn2SessionMap.entrySet()){
            Session value = entry.getValue();
            if(value.equals(session)){
                key = entry.getKey();
                sn2SessionMap.remove(key);
            }
        }
        return key;
    }

    public static Session getSession(String sn){
        return sn2SessionMap.get(sn);
    }

    public static String getSnBySession(Session session){
        for (Map.Entry<String,Session> entry : sn2SessionMap.entrySet()){
            Session value = entry.getValue();
            if(value.equals(session)){
                return entry.getKey();
            }
        }
        return null;
    }

    public static Set<String> getAllSn(){
        return sn2SessionMap.keySet();
    }

    public static ConcurrentHashMap<String, Session> getSn2SessionMap() {
        return sn2SessionMap;
    }

    static Gson gson = new GsonBuilder().create();

    public static boolean sendText(Session session,Object object){
        String json = gson.toJson(object);
        return sendText(session,json);
    }

    public static boolean sendText(Session session,String message){
        try {
            session.getBasicRemote().sendText(message);
            log.info("发送数据:" + message);
            return true;
        } catch (IOException e) {
            log.error("发生错误：{}，Session ID： {}",e.getMessage(),session.getId());
        }
        return false;
    }
}
