package com.wanji.etcxobu.task;

import com.wanji.etcxobu.util.Broker;
import com.wanji.etcxobu.util.ShowWebSocketUtil;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.websocket.Session;

@Component
public class WebsocketPush {
    private static String message;

    @Async
    public void sendmessage(Session session){
        while (ShowWebSocketUtil.getSessionMap().containsKey(session.getId())){
            if (!Broker.isEmpty()){
                message=Broker.consume();
            }
            ShowWebSocketUtil.sendText(session,message);
            try {
                Thread.sleep(1200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


}
