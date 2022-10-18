package com.wanji.etcxobu.util;

import com.google.gson.Gson;
import com.wanji.etcxobu.domain.Curlstatus;

import java.util.concurrent.ConcurrentHashMap;

public class OnlineOffMapUtil {
    private static final ConcurrentHashMap<String, Curlstatus> deviceStatus = new ConcurrentHashMap<>();

    public static void add(String SN, Curlstatus curlstatus){
        if(curlstatus.getLat()!=null) {
            double lon = Double.valueOf(curlstatus.getLon());
            double lat = Double.valueOf(curlstatus.getLat());
            double[] doubles = GPSUtil.gps84_To_Gcj02(lat, lon);
            java.text.DecimalFormat df = new java.text.DecimalFormat("#.#######");
            curlstatus.setLat(df.format(doubles[0]));
            curlstatus.setLon(df.format(doubles[1]));
        }
        deviceStatus.put(SN,curlstatus);
    }

    public static void addnotr(String SN, Curlstatus curlstatus){
        deviceStatus.put(SN,curlstatus);
    }

    public static void remove(String SN){deviceStatus.remove(SN);}

    public static Curlstatus getmes(String SN){
        return deviceStatus.get(SN);
    }

    public static boolean isKey(String SN){
        return deviceStatus.containsKey(SN);
    }

    public static ConcurrentHashMap getmap(){return deviceStatus;}

    public static void brokerput(){
        Gson gson=new Gson();
        String message= gson.toJson(deviceStatus);
        Broker.produce(message);
    }

    public static String getevent(Integer eventcode){
        switch (eventcode){
            case 0:
                return "默认状态";
            case 1:
                return "前向碰撞预警";
            case 2:
                return "交叉路口碰撞预警";
            case 3:
                return "左转辅助";
            case 4:
                return "盲区预警";
            case 5:
                return "变道预警";
            case 6:
                return "逆向超车预警";
            case 7:
                return "紧急制动预警";
            case 8:
                return "异常车辆提醒";
            case 9:
                return "失控车辆预警";
            case 10:
                return "紧急车辆预警";
            case 11:
                return "弱势交通参与者车辆预警";
            case 12:
                return "跟车过近";
            case 13:
                return "静止车辆预警";
            case 14:
                return "后方碰撞预警";
            case 15:
                return "慢速车辆预警";
            default:
                return "未定义预警";

        }
    }

//    private static String mapTo


}
