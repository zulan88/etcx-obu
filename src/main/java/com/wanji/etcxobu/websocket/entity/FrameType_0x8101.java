package com.wanji.etcxobu.websocket.entity;

import lombok.Data;

/**
 * 升级
 */
@Data
public class FrameType_0x8101 {

    private int frametype;      //服务类型
    private String UpdateVersion;   //待升级版本
    private String UpdateUrl;   //远程下载的FTP的地址：
    private String UserName ;   //ftp登录用户名
    private String PassWord;    //ftp登录密码
    private boolean Ack;        //是否需要确认
}
