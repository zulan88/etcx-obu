package com.wanji.etcxobu.websocket.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class DataRSI {
    @SerializedName("wStr")
    private Integer wStr;

    @SerializedName("RsiType")
    private Integer rsiType;

    @SerializedName("dAdveLat")
    private Long dAdveLat;

    @SerializedName("dAdveLong")
    private Long dAdveLong;

    @SerializedName("DesLen")
    private Integer DesLen;

    @SerializedName("DesFlag")
    private Integer DesFlag;

    @SerializedName("DesData")
    private String DesData;
}
