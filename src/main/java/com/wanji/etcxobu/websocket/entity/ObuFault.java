package com.wanji.etcxobu.websocket.entity;

import lombok.Data;

@Data
public class ObuFault {

    private int DiagState;      //0x80：无故障 0x81：有故障  其他：无效
    private SnapShot SnapShot1;
    private SnapShot SnapShot2;

}
