package com.wanji.etcxobu.websocket.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class BSMAIDGroup {

    @SerializedName("MsgName")
    private String MsgName;

    @SerializedName("MsgAID")
    private String MsgAID;

}
