package com.wanji.etcxobu.websocket.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class AlgorithmParam {

    @SerializedName("BrakeWarnTTC")
    private Double BrakeWarnTTC;

    @SerializedName("DisFactor_EVW")
    private Double DisFactor_EVW;

    @SerializedName("DisFactor_LCW")
    private Double DisFactor_LCW;

    @SerializedName("DisOffset_EVW")
    private Double DisOffset_EVW;

    @SerializedName("DisOffset_LCW")
    private Double DisOffset_LCW;

    @SerializedName("MapMatchAngleFactor")
    private Double MapMatchAngleFactor;

    @SerializedName("MapMatchDistanceFactor")
    private Double MapMatchDistanceFactor;

    @SerializedName("MapMatchIncThres")
    private Double MapMatchIncThres;

    @SerializedName("MapMatchLinkFactor")
    private Double MapMatchLinkFactor;

    @SerializedName("MapMatchValidThres")
    private Double MapMatchValidThres;

    @SerializedName("MaxGuideSpeed")
    private Double MaxGuideSpeed;

    @SerializedName("MinGuideSpeed")
    private Double MinGuideSpeed;

    @SerializedName("NormalWarnTTC")
    private Double NormalWarnTTC;

    @SerializedName("PathDisFactor")
    private Double PathDisFactor;

    @SerializedName("PathDisOffset")
    private Double PathDisOffset;

    @SerializedName("SafeBorderBackFactor")
    private Double SafeBorderBackFactor;

    @SerializedName("SafeBorderFrontFactor")
    private Double SafeBorderFrontFactor;

    @SerializedName("SafeBorderLeftFactor")
    private Double SafeBorderLeftFactor;

    @SerializedName("SafeBorderMesFactor")
    private Double SafeBorderMesFactor;

    @SerializedName("SafeBorderRightFactor")
    private Double SafeBorderRightFactor;

    @SerializedName("ScenarioSpeed")
    private Double ScenarioSpeed;

    @SerializedName("ShowSpatDistance")
    private Double ShowSpatDistance;

    @SerializedName("VertDisFactor")
    private Double VertDisFactor;

    @SerializedName("VertDisOffset")
    private Double VertDisOffset;

    @SerializedName("WarnTTC_EVW")
    private Double WarnTTC_EVW;

    @SerializedName("WarnTTC_LCW")
    private Double WarnTTC_LCW;


}
