package com.wanji.etcxobu.websocket.entity;

import lombok.Data;

@Data
public class DataSPAT {

    private int phaseId;
    private int LightStatus;
    private int LightDirection;
    private int TimeLeft;
    private int SuggSdType;
    private int SuggSd;
}
