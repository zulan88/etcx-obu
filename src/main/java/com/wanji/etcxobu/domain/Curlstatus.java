package com.wanji.etcxobu.domain;

import lombok.Data;

@Data
public class Curlstatus {
    String lat;
    String lon;
    Integer status;
    String event;
    String vehPlate;
    String ueid;
    String devicetype;
    Integer track;
    Integer speed;
}
