
package com.wanji.etcxobu.websocket.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class QXWZ {

    @SerializedName("AK")
    private String aK;
    @SerializedName("AS")
    private String aS;
    @SerializedName("GPSName")
    private String GPSName;
    @SerializedName("GPSName_W")
    private String GPSName_W;
    @SerializedName("AppKey")
    private String AppKey;
    @SerializedName("AppSectet")
    private String AppSectet;
    @SerializedName("Dev_id")
    private String Dev_id;
    @SerializedName("Dev_type")
    private String Dev_type;

}
