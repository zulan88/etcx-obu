package com.wanji.etcxobu.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


/**
 * obu对象 etcx_obu_route
 * 
 * @author wanji
 * @date 2021-09-30
 */
public class EtcxObuRoute
{
    private static final long serialVersionUID = 1L;

    private Long id;

    private String obuSn;

    private Date startTime;

    private Date endTime;

    private String obuRoute;

    private String sessionId;

    private Double routeDis;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setObuSn(String obuSn) 
    {
        this.obuSn = obuSn;
    }

    public String getObuSn() 
    {
        return obuSn;
    }
    public void setStartTime(Date startTime) 
    {
        this.startTime = startTime;
    }

    public Date getStartTime() 
    {
        return startTime;
    }
    public void setEndTime(Date endTime)
    {
        this.endTime = endTime;
    }

    public Date getEndTime()
    {
        return endTime;
    }
    public void setObuRoute(String obuRoute) 
    {
        this.obuRoute = obuRoute;
    }

    public String getObuRoute() 
    {
        return obuRoute;
    }
    public void setSessionId(String sessionId) 
    {
        this.sessionId = sessionId;
    }

    public String getSessionId() 
    {
        return sessionId;
    }

    public void setRouteDis(Double routeDis) {
        this.routeDis = routeDis;
    }

    public Double getRouteDis() {
        return routeDis;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("obuSn", getObuSn())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .append("obuRoute", getObuRoute())
            .append("sessionId", getSessionId())
            .toString();
    }
}
