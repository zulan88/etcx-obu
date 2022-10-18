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
public class ShowWebSocketUtil {

    private static final ConcurrentHashMap<String, Session> SessionMap = new ConcurrentHashMap<>();

    public static void add(Session session){
        SessionMap.put(session.getId(),session);
    }

    public static void remove(Session session){
        SessionMap.remove(session.getId());
    }


    public static Session getSession(Session session){
        return SessionMap.get(session.getId());
    }


    public static ConcurrentHashMap<String, Session> getSessionMap() {
        return SessionMap;
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
