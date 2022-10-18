
package com.wanji.etcxobu.websocket.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class GNSS {

    @SerializedName("RtcmFlag")
    private Integer RtcmFlag;
    @SerializedName("Locationsource")
    private Integer Locationsource;
    @SerializedName("Latitude")
    private Integer Latitude;
    @SerializedName("longtitude")
    private Integer longtitude;
    @SerializedName("Speed")
    private Integer Speed;
    @SerializedName("Heading")
    private Integer Heading;


}
