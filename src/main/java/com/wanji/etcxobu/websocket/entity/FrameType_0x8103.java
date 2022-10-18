package com.wanji.etcxobu.websocket.entity;

import lombok.Data;


/**
 * 升级应答
 */
@Data
public class FrameType_0x8103 extends BaseFrameType {

    private int frametype;      //服务类型
    private int Type;   //升级状态：1:四跨 2:新四跨

}
