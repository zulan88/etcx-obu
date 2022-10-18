package com.wanji.etcxobu.websocket.entity;


import lombok.Data;

import javax.websocket.Session;
import java.util.Date;

/**
 * obu上传故障信息
 */
@Data
public class FrameType_0x7201 extends BaseFrameType {


    private int frametype;      //服务类型
    private int rsctl;          //帧序列号，从0x0001开始依次递增，达到最大0xFFFF后从0x0001重新计数
    private String vin;         //车架号
    private String utc;            //数据产生的时间戳

    private ObuFault GPSError;    //soc与GPS通讯异常故障
    private ObuFault GNSSComFault;  //gnss模块通讯故障
    private ObuFault GnssDataError; //gnss模块数据异常故障
     //TODO 字段名修改
    private ObuFault Error4G;    //4G故障
    private ObuFault AG15ComError;  //soc与ag15通信故障
    private ObuFault HSMError;  //HSM故障
    private ObuFault HighVoltage;  //电池电压过高故障
    private ObuFault LowVoltage;    //电池电压过低故障
    private ObuFault WIFIError; //WIFI故障

    private String SN;//		OBU SN号
    private Date addTime;   // 添加时间

    @Override
    public void doHandle(String sn , String message, Session session){
        this.SN = sn;
        this.addTime = new Date();
//        mongoTemplate.save(this);
        System.out.println(this);
    }

}
