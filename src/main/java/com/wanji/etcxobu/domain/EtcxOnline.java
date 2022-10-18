package com.wanji.etcxobu.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


/**
 * obu对象 etcx_online
 * 
 * @author wanji
 * @date 2021-09-30
 */
public class EtcxOnline
{
    private static final long serialVersionUID = 1L;


    private String snId;

    private String olLong;

    private String olLat;

    private String olType;

    private Long status;

    private Long olEvent;

    private String vehPlate;


    public void setSnId(String snId) 
    {
        this.snId = snId;
    }

    public String getSnId() 
    {
        return snId;
    }
    public void setOlLong(String olLong) 
    {
        this.olLong = olLong;
    }

    public String getOlLong() 
    {
        return olLong;
    }
    public void setOlLat(String olLat) 
    {
        this.olLat = olLat;
    }

    public String getOlLat() 
    {
        return olLat;
    }
    public void setOlType(String olType) 
    {
        this.olType = olType;
    }

    public String getOlType() 
    {
        return olType;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }
    public void setOlEvent(Long olEvent) 
    {
        this.olEvent = olEvent;
    }

    public Long getOlEvent() 
    {
        return olEvent;
    }
    public void setVehPlate(String vehPlate) 
    {
        this.vehPlate = vehPlate;
    }

    public String getVehPlate() 
    {
        return vehPlate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("snId", getSnId())
            .append("olLong", getOlLong())
            .append("olLat", getOlLat())
            .append("olType", getOlType())
            .append("status", getStatus())
            .append("olEvent", getOlEvent())
            .append("vehPlate", getVehPlate())
            .toString();
    }
}
