package com.wanji.etcxobu.websocket.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class DataRSM {

    @SerializedName("nAdvePtcID")
    private Integer nAdvePtcID;

    @SerializedName("nAdveVehCls")
    private Integer nAdveVehCls;

    @SerializedName("nAdveLat")
    private Long nAdveLat;

    @SerializedName("nAdveLong")
    private Long nAdveLong;

    @SerializedName("nAdveColor")
    private Long nAdveColor;

    @SerializedName("nAdveHead")
    private Long nAdveHead;


}
