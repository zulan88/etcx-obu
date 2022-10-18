package com.wanji.etcxobu.websocket;


import com.wanji.etcxobu.config.MySpringConfigurator;
import com.wanji.etcxobu.task.WebsocketPush;
import com.wanji.etcxobu.util.ShowWebSocketUtil;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/showWebSocket", configurator = MySpringConfigurator.class)
@Component
@Slf4j
public class ShowWebSocketServer {

    @Autowired
    WebsocketPush websocketPush;

    /**
     * 连接建立成功调用的方法*/
    @OnOpen
    public void onOpen(Session session, EndpointConfig config) {
        log.warn("一个webSocket连接成功show SessionID:{}" , session.getId());
        // 最大空闲时间为 10s
        session.setMaxIdleTimeout(100 * 1000);
        session.setMaxTextMessageBufferSize(1024 * 1024 * 200);
        ShowWebSocketUtil.add(session);
        websocketPush.sendmessage(session);
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose(Session session) {
        ShowWebSocketUtil.remove(session);
        log.warn("一个webSocket连接关闭show SessionID:{}" , session.getId());
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息*/
    @OnMessage
    public void onMessage(String message, Session session) {

    }

    /**
     *
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        log.error("发生错误：SessionID: " + session.getId() , error);
    }

}
