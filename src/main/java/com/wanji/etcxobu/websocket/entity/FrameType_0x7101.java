package com.wanji.etcxobu.websocket.entity;

import lombok.Data;

import javax.websocket.Session;
import java.util.Date;

/**
 * obu状态信息上传
 */
@Data
public class FrameType_0x7101 extends BaseFrameType {

    private int frametype;      //服务类型
    private int rsctl;          //帧序列号，从0x0001开始依次递增，达到最大0xFFFF后从0x0001重新计数
    private String utc;            //数据产生的时间戳

    private int gnssStatus	;// GNSS状态 0:无效(默认) 1：单点定位（E1）  2：差分定位（E2） 4：差分定位固定解（E4） 5：差分定位浮点解（E5） 6：普通定位
    private String obuTemp	;// string 	设备温度 单位：0c
    private String cpuUsage	;// string	CPU占用率 单位%
    private String memUsage	;// string	内存占有率 单位%
    private String diskUsage	;// string	磁盘占用率 单位%

    private int V2XState;   //V2X 运行状态	V2X工作状态0正常，1异常
    private int State4G;    // 4G 运行状态	4G工作状态 0正常，1异常

    private String vdsCpuUsage	;// string	vds CPU占用率,单位%
    private String vdsMemUsage	;// string	vds 内存占有率,单位%
    private String netCpuUsage	;// string	net CPU占用率,单位%
    private String netMemUsage	;// string	net 内存占有率,单位%
    private String v2xCpuUsage	;// string	v2x CPU占用率,单位%
    private String v2xMemUsage	;// string	v2x 内存占有率,单位%
    private String appCpuUsage	;// string	app CPU占用率,单位%
    private String appMemUsage	;// string	app 内存占有率,单位%
    private String sysCpuUsage	;// string	sys CPU占用率,单位%
    private String sysMemUsage	;// string	sys 内存占有率,单位%

    private String SN;//		OBU SN号
    private Date addTime;   // 添加时间

    // 接收到消息,做处理
    @Override
    public void doHandle(String sn , String message, Session session){
        this.SN = sn;
        this.addTime = new Date();
//        mongoTemplate.save(this);
        System.out.println(this);
    }

}
