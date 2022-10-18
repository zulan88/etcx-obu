package com.wanji.etcxobu.websocket.entity;

import com.wanji.etcxobu.domain.Curlstatus;
import com.wanji.etcxobu.util.OnlineOffMapUtil;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.websocket.Session;
import java.util.List;

@Component
@Data
public class FrameType_0x7005 extends BaseFrameType{


    private int frametype;      //服务类型
    private int rsctl;          //帧序列号，从0x0001开始依次递增，达到最大0xFFFF后从0x0001重新计数
    private String utc;            //数据产生的时间戳

    private int gnssStatus; // GNSS状态 0:无效(默认) 1：单点定位（E1）  2：差分定位（E2） 4：差分定位固定解（E4） 5：差分定位浮点解（E5） 6：普通定位
    private String vin;
    private int nRsmCnt; //RSM个数
    private List<DataRSM> data;

    @Override
    public void doHandle(String sn , String message, Session session){
        Curlstatus curlstatus=OnlineOffMapUtil.getmes(sn);
        curlstatus.setEvent("RSM事件:"+data.toString());
        OnlineOffMapUtil.addnotr(sn,curlstatus);
        OnlineOffMapUtil.brokerput();
    }
}
