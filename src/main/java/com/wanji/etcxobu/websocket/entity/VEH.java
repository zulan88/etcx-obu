
package com.wanji.etcxobu.websocket.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class VEH {

    @SerializedName("VehId")
    private String vehId;
    @SerializedName("VehType")
    private Integer vehType;
    @SerializedName("VehLength")
    private String vehLength;
    @SerializedName("VehWidth")
    private String vehWidth;
    @SerializedName("VehHigh")
    private String vehHigh;


}
