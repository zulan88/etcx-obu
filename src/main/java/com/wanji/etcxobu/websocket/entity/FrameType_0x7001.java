package com.wanji.etcxobu.websocket.entity;

import com.wanji.etcxobu.domain.Curlstatus;
import com.wanji.etcxobu.domain.EtcxObuRoute;
import com.wanji.etcxobu.service.IEtcxObuRouteService;
import com.wanji.etcxobu.util.GPSUtil;
import com.wanji.etcxobu.util.ObuRouteRecordUtil;
import com.wanji.etcxobu.util.OnlineOffMapUtil;
import com.wanji.etcxobu.util.SpringContextUtils;
import com.wanji.etcxobu.websocket.ObuWebSocketServer;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.websocket.Session;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Data
public class FrameType_0x7001 extends BaseFrameType{

    private static final Logger logger = LoggerFactory.getLogger(ObuWebSocketServer.class);

    private static final ConcurrentHashMap<String,Integer> cmap=new ConcurrentHashMap<>();

    private int frametype;      //服务类型
    private int rsctl;          //帧序列号，从0x0001开始依次递增，达到最大0xFFFF后从0x0001重新计数
    private String utc;            //数据产生的时间戳

    private int gnssStatus; // GNSS状态 0:无效(默认) 1：单点定位（E1）  2：差分定位（E2） 4：差分定位固定解（E4） 5：差分定位浮点解（E5） 6：普通定位
    private String ueid;
    private int nSelfLat; //纬度,单位1e-7°
    private int nSelfLong; //经度,单位1e-7°
    private int nSelfSpeed; //自车车速,单位0.02m/s
    private int nSelfTrack; //自车方向,单位0.0125°,车头方向与正北方向的顺时针夹角
    private int nSelfTurn;  //转向信息

    private String SN;//		OBU SN号
    private Date addTime;   // 添加时间

    @Override
    public void doHandle(String sn , String message, Session session){
        if(!cmap.containsKey(sn)){
            cmap.put(SN,0);
        }
        this.SN = sn;
        Curlstatus curlstatus=OnlineOffMapUtil.getmes(sn);
        curlstatus.setLat(String.valueOf(this.nSelfLat/1000000D));
        curlstatus.setLon(String.valueOf(this.nSelfLong/1000000D));
        curlstatus.setTrack(this.nSelfTrack);
        curlstatus.setSpeed((int) (this.nSelfSpeed*3.6/50));
        curlstatus.setUeid(ueid);
        OnlineOffMapUtil.add(sn,curlstatus);
        OnlineOffMapUtil.brokerput();
        if(ObuRouteRecordUtil.iskey(sn)){
            EtcxObuRoute etcxObuRoute=new EtcxObuRoute();
            etcxObuRoute.setObuSn(sn);
            etcxObuRoute.setStartTime(new Date());
            etcxObuRoute.setSessionId(session.getId());
            etcxObuRoute.setObuRoute("pass");
            IEtcxObuRouteService etcxObuRouteService = SpringContextUtils.getBean(IEtcxObuRouteService.class);
            etcxObuRouteService.insertEtcxObuRoute(etcxObuRoute);
            ObuRouteRecordUtil.removeflag(sn);
        }
        Integer count=cmap.get(SN);
        if(GPSUtil.outOfChina(Double.valueOf(curlstatus.getLat()),Double.valueOf(curlstatus.getLon()))){
            return;
        }
        if(count%10==0) {
            ObuRouteRecordUtil.addroute(sn, (this.nSelfLong / 1000000D),(this.nSelfLat / 1000000D));
        }
        ObuRouteRecordUtil.addspeed(sn,this.nSelfSpeed);
        cmap.put(SN,count+1);
    }
}
