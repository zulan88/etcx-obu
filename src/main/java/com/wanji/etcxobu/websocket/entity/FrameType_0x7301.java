package com.wanji.etcxobu.websocket.entity;

import lombok.Data;

import javax.websocket.Session;

/**
 * obu上传耐寒测试结果  100ms
 */
@Data
public class FrameType_0x7301 extends BaseFrameType {

    private int frametype;      //服务类型
    private int rsctl;          //帧序列号，从0x0001开始依次递增，达到最大0xFFFF后从0x0001重新计数
    private String vin;         //车架号
    private String utc;            //数据产生的时间戳
    private int can1TrueCnt;  // int	can1成功次数
    private int can1FailCnt;  // int	can1失败次数
    private int can2TrueCnt;  // int	can2成功次数
    private int can2FailCnt;  // int	can2失败次数
    private int can3TrueCnt;  // int	can3成功次数
    private int can3FailCnt;  // int	can3失败次数
    private int v2xTrueCnt;  // int	v2x成功次数
    private int v2xFalseCnt;  // int	v2x失败次数
    private int v2xDelayTime;  // int	v2x延迟时间，单位微妙
    private int v2xMaxDelayTime;  // int	v2x延迟时间，单位微妙
    private int v2xMinDelayTime;  // int	v2x延迟时间，单位微妙
    private int ethSendCnt;  // int	以太网发送包数
    private int ethRcvCnt;  // int	以太网接收包数
    private int ethLostCnt;  // int	以太网丢包数
    private int ethDelaytime;  // int	以太网实时时延
    private int ethMaxDelaytime;  // int	以太网最大时延
    private int ethMinDelaytime;  // int	以太网最小时延
    private int g4SendCnt;  // int	4g发送包数
    private int g4RcvCnt;  // int	4g接收包数
    private int g4LostCnt;  // int	4g丢包数
    private int g4Delaytime;  // int	4g实时时延
    private int g4MaxDelaytime;  // int	4g最大时延
    private int g4MinDelaytime;  // int	4g最小时延
    private int wifiSendCnt;  // int	wifi发送包数
    private int wifiRcvCnt;  // int	wifi接收包数
    private int wifiLostCnt;  // int	wifi丢包数
    private int wifiDelaytime;  // int	wifi实时时延
    private int wifiMaxDelaytime;  // int	wifi最大时延
    private int wifiMinDelaytime;  // int	wifi最小时延
    private int kl30Vol;  // int	AD值
    private int stateNum;  // int	卫星颗数
    private int snrNum;  // int	卫星颗数中大于30的个数
    private int distance;  // int	两次GNSS数据距离差
    private int maxDistance;  // int	当前最大距离差
    private int minDistance;  // int	当前最小距离差
    private int ag15StartTime;  // int	ag15启动时间
    private int ag35StartTime;  // int	ag35启动时间
    private int q8StartTime;  // int	8q启动时间
    private int ag15Temp;  // int	ag15实时温度
    private int ag35Temp;  // int	ag35实时温度
    private int q8Temp;  // int	8q实时温度

    // 接收到消息,做处理
    @Override
    public void doHandle(String vin , String message, Session session){
        // 保存最后一条信息
    }

}
