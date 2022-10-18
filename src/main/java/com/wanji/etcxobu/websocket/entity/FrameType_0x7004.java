package com.wanji.etcxobu.websocket.entity;

import com.wanji.etcxobu.domain.Curlstatus;
import com.wanji.etcxobu.domain.EtcxObuRoute;
import com.wanji.etcxobu.service.IEtcxObuRouteService;
import com.wanji.etcxobu.util.ObuRouteRecordUtil;
import com.wanji.etcxobu.util.OnlineOffMapUtil;
import com.wanji.etcxobu.util.SpringContextUtils;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.websocket.Session;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Data
public class FrameType_0x7004 extends BaseFrameType{


    private int frametype;      //服务类型
    private int rsctl;          //帧序列号，从0x0001开始依次递增，达到最大0xFFFF后从0x0001重新计数
    private String vin;


    private int gnssStatus; // GNSS状态 0:无效(默认) 1：单点定位（E1）  2：差分定位（E2） 4：差分定位固定解（E4） 5：差分定位浮点解（E5） 6：普通定位
    private String utc;            //数据产生的时间戳
    private int nRsiCnt; //RSI个数
    private List<DataRSI> data;

    @Override
    public void doHandle(String sn , String message, Session session){
        for(DataRSI dataRSI:data) {
            if(dataRSI.getWStr()!=-1) {
                Curlstatus curlstatus = OnlineOffMapUtil.getmes(sn);
                curlstatus.setEvent("RSI事件:" + getevent(dataRSI.getWStr()));
                OnlineOffMapUtil.addnotr(sn, curlstatus);
                OnlineOffMapUtil.brokerput();
            }
        }
    }

    private String getevent(int code){
        switch (code) {
            case 0:
                return "车内标牌";
            case 1:
                return "道路危险状况提示";
            case 2:
                return "道路限速提醒";
            case 3:
                return "前方拥堵提醒";
            default:
                break;
        }
        return "未知事件编码";
    }
}
