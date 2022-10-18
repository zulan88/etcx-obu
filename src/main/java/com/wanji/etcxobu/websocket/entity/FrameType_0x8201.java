package com.wanji.etcxobu.websocket.entity;

import com.wanji.etcxobu.domain.Curlstatus;
import com.wanji.etcxobu.util.ObuRouteRecordUtil;
import com.wanji.etcxobu.util.ObuWebSocketUtil;
import com.wanji.etcxobu.util.OnlineOffMapUtil;
import lombok.Data;

import javax.websocket.Session;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * OBU发送注册信息
 */
@Data
public class FrameType_0x8201{

    private int frametype;      //服务类型
    private int rsctl;          //帧序列号，从0x0001开始依次递增，达到最大0xFFFF后从0x0001重新计数
    private String SN;         //sn号
    private String utc;            //数据产生的时间戳
    private String ver;         //当前协议版本

    public void register(Session session) {
        int registerFlag = 1;
        FrameType_0x8202 frameType_0x8202 = new FrameType_0x8202();
        frameType_0x8202.setFrametype(BaseFrameType._0x8202);      //服务类型
        frameType_0x8202.setRsctl(1);          //帧序列号，从0x0001开始依次递增，达到最大0xFFFF后从0x0001重新计数
        frameType_0x8202.setUtc(LocalDateTime.now().format(DateTimeFormatter.ofPattern(BaseFrameType.timePattern)));            //数据产生的时间戳
        frameType_0x8202.setSN(this.SN);         //sn号

        // 校验SN
        if(checkSN(this.SN)){

            Session session1 = ObuWebSocketUtil.getSession(this.SN);
            if(session1 == null){
                registerFlag = 0;
                ObuWebSocketUtil.add(this.SN,session);
                if(OnlineOffMapUtil.isKey(SN)){
                    Curlstatus curlstatus=OnlineOffMapUtil.getmes(SN);
                    curlstatus.setDevicetype("OBU");
                    curlstatus.setStatus(0);
                    OnlineOffMapUtil.addnotr(this.SN,curlstatus);
                }else {
                    Curlstatus curlstatus = new Curlstatus();
                    curlstatus.setDevicetype("OBU");
                    curlstatus.setStatus(0);
                    OnlineOffMapUtil.add(this.SN, curlstatus);
                }
                ObuRouteRecordUtil.addflag(this.SN);
            }else if(session.getId()!=session1.getId()){
                ObuWebSocketUtil.add(this.SN,session);
            }
        }

        frameType_0x8202.setRegisterFlag(registerFlag);     //注册结果 0：注册成功 1：注册失败
        ObuWebSocketUtil.sendText(session,frameType_0x8202);
    }

    public static boolean checkSN(String vin){
        return vin != null && vin.length() == 16;
    }
}
