package com.wanji.etcxobu.websocket.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class SecurityParamConfig {

    @SerializedName("isInitSecLayer")
    private Integer isInitSecLayer;
    @SerializedName("isInclude")
    private Integer isInclude;
    @SerializedName("SignDeviceType")
    private Integer SignDeviceType;

}
