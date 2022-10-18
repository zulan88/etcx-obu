package com.wanji.etcxobu.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * obu对象 etcx_obu_info
 * 
 * @author wanji
 * @date 2021-09-30
 */
public class EtcxObuInfo
{
    private static final long serialVersionUID = 1L;


    private String obuSn;

    private String vehPlate;

    private Date lastOlTime;

    private Long lastDistance;

    private Long cumulativeDistance;

    private Long cumulativeOlTime;

    private String lastRoute;

    private String likeRoute;

    private String avgSpeed;

    public void setObuSn(String obuSn) 
    {
        this.obuSn = obuSn;
    }

    public String getObuSn() 
    {
        return obuSn;
    }
    public void setVehPlate(String vehPlate) 
    {
        this.vehPlate = vehPlate;
    }

    public String getVehPlate() 
    {
        return vehPlate;
    }
    public void setLastOlTime(Date lastOlTime) 
    {
        this.lastOlTime = lastOlTime;
    }

    public Date getLastOlTime() 
    {
        return lastOlTime;
    }
    public void setLastDistance(Long lastDistance) 
    {
        this.lastDistance = lastDistance;
    }

    public Long getLastDistance() 
    {
        return lastDistance;
    }
    public void setCumulativeDistance(Long cumulativeDistance) 
    {
        this.cumulativeDistance = cumulativeDistance;
    }

    public Long getCumulativeDistance() 
    {
        return cumulativeDistance;
    }
    public void setCumulativeOlTime(Long cumulativeOlTime) 
    {
        this.cumulativeOlTime = cumulativeOlTime;
    }

    public Long getCumulativeOlTime() 
    {
        return cumulativeOlTime;
    }

    public void setLastRoute(String lastRoute) {
        this.lastRoute = lastRoute;
    }

    public String getLastRoute() {
        return lastRoute;
    }

    public void setAvgSpeed(String avgSpeed) {
        this.avgSpeed = avgSpeed;
    }

    public String getAvgSpeed() {
        return avgSpeed;
    }


    public void setLikeRoute(String likeRoute)
    {
        this.likeRoute = likeRoute;
    }

    public String getLikeRoute() 
    {
        return likeRoute;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("obuSn", getObuSn())
            .append("vehPlate", getVehPlate())
            .append("lastOlTime", getLastOlTime())
            .append("lastDistance", getLastDistance())
            .append("cumulativeDistance", getCumulativeDistance())
            .append("cumulativeOlTime", getCumulativeOlTime())
            .append("picturePath", getLastRoute())
            .append("likeRoute", getLikeRoute())
            .toString();
    }
}
