package com.wanji.etcxobu.websocket.entity;

import lombok.Data;

/**
 * 平台应答注册信息
 */
@Data
public class FrameType_0x8202 extends BaseFrameType {

    private int frametype;      //服务类型
    private int rsctl;          //帧序列号，从0x0001开始依次递增，达到最大0xFFFF后从0x0001重新计数
    private String SN;         //车架号
    private String utc;            //数据产生的时间戳
    private int registerFlag;     //注册结果 0：注册成功 1：注册失败

}
