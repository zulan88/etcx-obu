package com.wanji.etcxobu.websocket.entity;

import com.wanji.etcxobu.domain.Curlstatus;
import com.wanji.etcxobu.util.OnlineOffMapUtil;
import lombok.Data;

import javax.websocket.Session;
import java.util.Date;

@Data
public class FrameType_0x7003 extends BaseFrameType{
    private int frametype;      //服务类型
    private int rsctl;          //帧序列号，从0x0001开始依次递增，达到最大0xFFFF后从0x0001重新计数
    private String utc;            //数据产生的时间戳

    private String vin; //车架号
    private String DangerAdveUEID; //危险状态车 UEID
    private int nAdveSafeState;
    private int nAdvePriority;
    private int nAdveRelativeOrientation;

    private String SN;//		OBU SN号
    private Date addTime;   // 添加时间

    @Override
    public void doHandle(String sn , String message, Session session){
        if(this.nAdveSafeState!=0) {
            this.SN = sn;
            Curlstatus curlstatus = OnlineOffMapUtil.getmes(SN);
            curlstatus.setEvent(OnlineOffMapUtil.getevent(this.nAdveSafeState));
            OnlineOffMapUtil.addnotr(SN, curlstatus);
//        if(this.DangerAdveUEID!=null&&!this.DangerAdveUEID.equals("")) {
//            Curlstatus curlstatus1 = OnlineOffMapUtil.getmes(this.DangerAdveUEID);
//            curlstatus1.setEvent(OnlineOffMapUtil.getevent(this.nAdveSafeState) + "-危险车");
//            OnlineOffMapUtil.addnotr(this.DangerAdveUEID, curlstatus1);
//        }
            OnlineOffMapUtil.brokerput();
        }
    }
}
