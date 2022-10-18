package com.wanji.etcxobu.websocket.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class StaticParam {

    @SerializedName("BlindLength")
    private Double BlindLength;

    @SerializedName("BlindMirrorPos")
    private Double BlindMirrorPos;

    @SerializedName("BlindOffset")
    private Double BlindOffset;

    @SerializedName("BlindWidth")
    private Double BlindWidth;

    @SerializedName("BsmFuelType")
    private Double BsmFuelType;

    @SerializedName("BsmVehicleClass")
    private Double BsmVehicleClass;

    @SerializedName("GnssFrontOffset")
    private Double GnssFrontOffset;

    @SerializedName("GnssRightOffset")
    private Double GnssRightOffset;

    @SerializedName("SpeedLimitVehType")
    private Double SpeedLimitVehType;

    @SerializedName("VehicleHeight")
    private Double VehicleHeight;

    @SerializedName("VehicleLength")
    private Double VehicleLength;

    @SerializedName("VehicleWidth")
    private Double VehicleWidth;

}
