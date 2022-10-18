package com.wanji.etcxobu.websocket.entity;

import lombok.Data;

import javax.websocket.Session;

@Data
public class BaseFrameType {

    public static final String timePattern = "yyyy.MM.dd HH:mm:ss.SSS";


    public static final int _0 = 0;// 设备不在线
    public static final int _1 = 1;// 设备超时未应答

    // 通知帧
    // 车身、场景、状态数据	
    public static final int _0x7001 = 0x7001;//自车信息
    public static final int _0x7002 = 0x7002;//周围车辆
    public static final int _0x7003 = 0x7003;//预警信息
    public static final int _0x7004 = 0x7004;//RSI信息
    public static final int _0x7005 = 0x7005;//RSM信息
    public static final int _0x7006 = 0x7006;//SPAT信息
    //OBU状态信息上传	
    public static final int _0x7101 = 0x7101;//	OBU状态信息上传
    // OBU故障信息上传	
    public static final int _0x7201 = 0x7201;//	OBU故障信息上传
    // 耐寒测试结果上传	
    public static final int _0x7301 = 0x7301;//	耐寒测试结果
    // 耐寒测试结果上传
    public static final int _0x7401 = 0x7401;//	OBU静态信息


    // 请求应答帧
    // 日志上传	
    public static final int _0x8001 = 0x8001;//	平台请求设备上传日志数据帧
    public static final int _0x8002 = 0x8002;//	OBU请求文件传输完成
    public static final int _0x8003 = 0x8003;//	OBU应答发送数据结果帧

    // 远程升级
    public static final int _0x8101 = 0x8101;//	云平台请求升级数据传输
    public static final int _0x8102 = 0x8102;//	OBU应答升级数据传输请求
    public static final int _0x8103 = 0x8103;//	平台请求模组配置升级消息

    // 注册
    public static final int _0x8201 = 0x8201;//	OBU注册请求
    public static final int _0x8202 = 0x8202;//	OBU注册应答
    // 在线配置
    public static final int _0x8301 = 0x8301;//	配置参数查询请求
    public static final int _0x8302 = 0x8302;//	配置参数查询应答
    public static final int _0x8303 = 0x8303;//	配置参数设置请求
    public static final int _0x8304 = 0x8304;//	配置参数设置应答

    // 重启
    public static final int _0x9001 = 0x9001;//	重启设备请求
    public static final int _0x9002 = 0x9002;//	重启设备应答

    // 接收到消息,做处理
    public void doHandle(String sn , String message, Session session){

    }

}
