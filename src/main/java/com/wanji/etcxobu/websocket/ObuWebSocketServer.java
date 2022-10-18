package com.wanji.etcxobu.websocket;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wanji.etcxobu.config.MySpringConfigurator;
import com.wanji.etcxobu.domain.Curlstatus;
import com.wanji.etcxobu.domain.EtcxObuRoute;
import com.wanji.etcxobu.domain.EtcxOnline;
import com.wanji.etcxobu.service.IEtcxObuRouteService;
import com.wanji.etcxobu.service.IEtcxOnlineService;
import com.wanji.etcxobu.util.ObuRouteRecordUtil;
import com.wanji.etcxobu.util.ObuWebSocketUtil;
import com.wanji.etcxobu.util.OnlineOffMapUtil;
import com.wanji.etcxobu.websocket.entity.BaseFrameType;
import com.wanji.etcxobu.websocket.entity.FrameType_0x8201;
import com.wanji.etcxobu.websocket.entity.Frametype;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.text.SimpleDateFormat;
import java.util.Date;

@ServerEndpoint(value = "/obuWebSocket", configurator = MySpringConfigurator.class)
@Component
@Slf4j
public class ObuWebSocketServer {

    @Autowired
    IEtcxObuRouteService etcxObuRouteService;

    @Autowired
    IEtcxOnlineService etcxOnlineService;

    /**
     * 连接建立成功调用的方法*/
    @OnOpen
    public void onOpen(Session session, EndpointConfig config) {
        log.info("一个obuWebSocket连接成功 SessionID:{}" , session.getId());
        // 最大空闲时间为 10s
        session.setMaxIdleTimeout(100 * 1000);
        session.setMaxTextMessageBufferSize(1024 * 1024 * 200);
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose(Session session) {
        String SN = ObuWebSocketUtil.remove(session);
        log.info("一个obuWebSocket连接关闭 SessionID:{}" , session.getId());
        if(SN!=null&&OnlineOffMapUtil.isKey(SN)) {
            Curlstatus curlstatus = OnlineOffMapUtil.getmes(SN);
            curlstatus.setStatus(1);
            OnlineOffMapUtil.addnotr(SN, curlstatus);
            OnlineOffMapUtil.brokerput();
            String routes = ObuRouteRecordUtil.getroutes(SN);
            EtcxObuRoute dbsign = new EtcxObuRoute();
            dbsign.setObuRoute("pass");
            dbsign.setSessionId(session.getId());
            dbsign.setObuSn(SN);
            EtcxObuRoute etcxObuRoute = etcxObuRouteService.selectEtcxObuRouteList(dbsign).get(0);
            etcxObuRoute.setObuRoute(routes);
            etcxObuRoute.setEndTime(new Date());
            etcxObuRouteService.updateEtcxObuRoute(etcxObuRoute);
            EtcxOnline etcxOnline=new EtcxOnline();
            etcxOnline.setSnId(SN);
            etcxOnline.setStatus(Long.valueOf(curlstatus.getStatus()));
            etcxOnline.setOlLat(curlstatus.getLat());
            etcxOnline.setOlLong(curlstatus.getLon());
            etcxOnlineService.updateEtcxOnline(etcxOnline);
            ObuRouteRecordUtil.removeroute(SN);
        }
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息*/
    @OnMessage
    public void onMessage(String message, Session session) {
        Gson gson = new GsonBuilder().create();
        Frametype frameType = null;
        try {
            frameType = gson.fromJson(message, Frametype.class);
        } catch (Exception e) {
            log.error("接收到的数据不符合标准: {}", message,e);
            return;
        }
        if(frameType == null){
            log.error("接收到的frameType 为null");
            return;
        }
        String toHexString = Integer.toHexString(frameType.getFrametype()).toUpperCase();
        try {
            Class<?> aClass = Class.forName("com.wanji.etcxobu.websocket.entity.FrameType_0x" + toHexString);
            Object object = gson.fromJson(message, aClass);
            if(object instanceof FrameType_0x8201){
                FrameType_0x8201 frameType_0x8201 = ((FrameType_0x8201) object);
                log.info(" SessionID:{}, sn:{} ,发起注册" , session.getId(),frameType_0x8201.getSN());
                frameType_0x8201.register(session);
            }
            if(object instanceof BaseFrameType){
                String snBySession = ObuWebSocketUtil.getSnBySession(session);
                if(snBySession != null){
                    log.info(" SessionID:{}, sn:{} ,发起frameType:{},0x{} " , session.getId(),snBySession,frameType.getFrametype(),toHexString);
//                    log.info(message);
                    ((BaseFrameType) object).doHandle( snBySession,message,session);
                }
            }
        } catch (ClassNotFoundException e) {
            log.error("未找到对应的frameType:{},{}",frameType,toHexString);
        }

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
