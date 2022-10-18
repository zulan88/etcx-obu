package com.wanji.etcxobu.websocket.entity;

import lombok.Data;

@Data
public class Location {

    private Long Lon;//	Long	10	Y	经度(单位：0.0000001)
    private Long Lat;//	long	10	Y	纬度(单位：0.0000001)
    private Long Alt;//	long	10	N	海拔（单位：0.01m）

}
