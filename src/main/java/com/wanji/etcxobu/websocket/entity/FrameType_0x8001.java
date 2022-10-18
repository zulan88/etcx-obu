package com.wanji.etcxobu.websocket.entity;

import lombok.Data;

/**
 * OBU上传日志
 */
@Data
public class FrameType_0x8001 extends BaseFrameType {

    private int frametype;      //服务类型
    private String UpdateUrl;         //ftp地址
    private String UserName;         //用户名称
    private String PassWord;         //登录密码
    private int Type;         //日志类型  1: 应用日志；2：算法日志； 3：系统日志； 4：关键配置文件 5：TBD
    private int Amount;         //文件数量

}
