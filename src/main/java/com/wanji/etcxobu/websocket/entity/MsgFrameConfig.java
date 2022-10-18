package com.wanji.etcxobu.websocket.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class MsgFrameConfig {

    @SerializedName("MsgFrameVersion")
    private Integer MsgFrameVersion;
}
