package com.wanji.etcxobu.controller;

import com.wanji.etcxobu.util.ObuWebSocketUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.websocket.Session;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 */
@Controller
@RequestMapping("obuWebsocket")
public class ObuWebsocketController {

    @RequestMapping("vin2SessionMap")
    @ResponseBody
    public Object vin2SessionMap(){
        HashMap<String, String> result = new HashMap<>();
        ConcurrentHashMap<String, Session> vin2SessionMap = ObuWebSocketUtil.getSn2SessionMap();
        for (Map.Entry<String,Session> entry : vin2SessionMap.entrySet()) {
            String key = entry.getKey();
            Session session = entry.getValue();
            result.put(key,session.getId() + "--" +session.isOpen());
        }
        return result;
    }

    @RequestMapping("sendMessage2Vin")
    @ResponseBody
    public Object sendMessage2Vin(String vin,String message){
        Session session = ObuWebSocketUtil.getSession(vin);
        if(session == null){
            return "vin:" + vin + ",连接不存在！";
        }
        return ObuWebSocketUtil.sendText(session,message);
    }

}
