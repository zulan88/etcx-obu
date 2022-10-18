package com.wanji.etcxobu.task;

import com.wanji.etcxobu.domain.EtcxObuInfo;
import com.wanji.etcxobu.domain.EtcxObuRoute;
import com.wanji.etcxobu.service.IEtcxObuInfoService;
import com.wanji.etcxobu.service.IEtcxObuRouteService;
import com.wanji.etcxobu.util.GPSUtil;
import com.wanji.etcxobu.util.ObuRouteRecordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Component
public class OfflineCalculation {

    private static double EARTH_RADIUS = 6378.137;

    @Autowired
    IEtcxObuInfoService etcxObuInfoService;

    @Autowired
    IEtcxObuRouteService etcxObuRouteService;

    @Scheduled(cron = "0 0 1 * * ?")
    public void cron(){
        List<EtcxObuInfo> etcxObuInfos=etcxObuInfoService.selectEtcxObuInfoList(new EtcxObuInfo());
        for (EtcxObuInfo etcxObuInfo:etcxObuInfos){
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Calendar c = Calendar.getInstance();
            c.add(Calendar.DATE, -1);
            EtcxObuRoute dbroute=new EtcxObuRoute();
            dbroute.setObuSn(etcxObuInfo.getObuSn());
            dbroute.setEndTime(c.getTime());
            List<EtcxObuRoute>etcxObuRoutes=etcxObuRouteService.selectEtcxObuRouteList(dbroute);
            if(etcxObuRoutes.size()!=0) {
                Date lastoltime = null;
                Long addtime = etcxObuInfo.getCumulativeOlTime();
                Long lastdistance = null;
                Long maxId = 0l;
                Double distanced = 0d;
                String lastroute = null;
                for (EtcxObuRoute etcxObuRoute : etcxObuRoutes) {
                    addtime += getDatePoor(etcxObuRoute.getEndTime(), etcxObuRoute.getStartTime());
                    String routes = etcxObuRoute.getObuRoute();
                    if(routes.equals("pass")){
                        continue;
                    }
                    Double distance = 0d;
                    Double lastlon = null;
                    Double latslat = null;
                    for (String mes : routes.split(";")) {
                        Double lon = Double.valueOf(mes.split(",")[0]);
                        Double lat = Double.valueOf(mes.split(",")[1]);
                        if (lastlon != null) {
                            distance += getDistance(lon, lat, lastlon, latslat);
                        }
                        lastlon = lon;
                        latslat = lat;

                    }
                    distanced += distance;
                    if (etcxObuRoute.getId() > maxId) {
                        maxId = etcxObuRoute.getId();
                        lastdistance = distance.longValue();
                        lastoltime = etcxObuRoute.getStartTime();
                        lastroute = routes;
                    }
                    etcxObuRoute.setRouteDis(Math.round(distance * 1000) / 1000.0);
                    etcxObuRouteService.updateEtcxObuRoute(etcxObuRoute);
                }
//                String croutes = "";
                java.text.DecimalFormat df = new java.text.DecimalFormat("#.#######");
//                for (String mes : lastroute.split(";")) {
//                    Double lon = Double.valueOf(mes.split(",")[0]);
//                    Double lat = Double.valueOf(mes.split(",")[1]);
//                    double[] doubles = GPSUtil.gps84_To_Gcj02(lat, lon);
//                    croutes += df.format(doubles[1]) + "," + df.format(doubles[0]) + ";";
//                }
                if (ObuRouteRecordUtil.isspeed(etcxObuInfo.getObuSn())) {
                    etcxObuInfo.setAvgSpeed(String.valueOf(ObuRouteRecordUtil.getspeed(etcxObuInfo.getObuSn())));
                    ObuRouteRecordUtil.removespeed(etcxObuInfo.getObuSn());
                }
                etcxObuInfo.setCumulativeDistance(etcxObuInfo.getCumulativeDistance() + distanced.longValue());
                etcxObuInfo.setCumulativeOlTime(addtime);
                etcxObuInfo.setLastDistance(lastdistance);
                etcxObuInfo.setLastOlTime(lastoltime);
                etcxObuInfo.setLastRoute(lastroute);
                etcxObuInfoService.updateEtcxObuInfo(etcxObuInfo);
            }
        }
    }


    public static Long getDatePoor(Date endDate, Date nowDate) {

        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        // long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - nowDate.getTime();
        // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;
        // 计算差多少秒//输出结果
        // long sec = diff % nd % nh % nm / ns;
        return hour;
    }

    public static double getDistance(double lng1, double lat1, double lng2, double lat2) {
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;
        double b = rad(lng1) - rad(lng2);
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) + Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
        s = s * EARTH_RADIUS;
        s = Math.round(s * 10000d) / 10000d;
        s = s;
        return s;
    }

    public static double rad(double d) {
        return d * Math.PI / 180.0;
    }

}
