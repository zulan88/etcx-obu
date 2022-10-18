package com.wanji.etcxobu.websocket.entity;

import lombok.Data;


import javax.websocket.Session;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * obu静态信息上报
 */
@Data
public class FrameType_0x7401 extends BaseFrameType {

    private String SN;//		OBU SN号
    private String SIM;//		SIM卡号
    private String IMEI;//		IMEI
    private String IMSI;//		IMSI
    private String ICCID;//		ICCID
    private Integer v2xVersion;//		3：三跨；4：四跨；5：新四跨；6：二期
    private String ag15;//		AG15固件版本
    private Integer ObuStatus;//		RSU运行状态0正常，1异常
    private Location Location;//		位置信息，包含经纬度数据
    private String HardwareVersion;//		硬件版本
    private String SoftwareVersion;//		集成软件版本：WVO-M923-0001-20210311-3767e52e
    private String APP_SW;//		WJ_OBU_APP_20210126_1
    private String VDS_SW;//		WJ_OBU_VDS_20210126_1
    private String NET_SW;//		WJ_OBU_NET_20210126_1
    private String SYS_SW;//		WJ_OBU_SYS_20210126_1
    private String V2X_SW;//		WJ_OBU_V2X_20210126_1
    private Boolean Ack;//		是否需要确认 TRUE需要，FALSE不需要

    private Date addTime;   // 添加时间


    // 接收到消息,做处理
    @Override
    public void doHandle(String sn, String message, Session session) {
        System.out.println(this);
    }

}
