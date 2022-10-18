package com.wanji.etcxobu.util;

import java.util.concurrent.ConcurrentHashMap;

public class ObuRouteRecordUtil {
    private static final ConcurrentHashMap<String, String> routemap=new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, String> dbflag=new ConcurrentHashMap<>();
    public static void addroute(String SN,Double lon, Double lat){
        double[] doubles = GPSUtil.gps84_To_Gcj02(lat, lon);
        java.text.DecimalFormat df = new java.text.DecimalFormat("#.#######");
        String route=df.format(doubles[1])+","+df.format(doubles[0]);
        if(routemap.containsKey(SN)) {
            String routes=routemap.get(SN)+";"+route;
            routemap.put(SN, routes);
        }else {
            routemap.put(SN,route);
        }
    }
    public static void addflag(String SN){
        dbflag.put(SN,"flag");
    }
    public static void removeroute(String SN){
        routemap.remove(SN);
    }
    public static void removeflag(String SN){
        dbflag.remove(SN);
    }
    public static boolean iskey(String SN){
        return dbflag.containsKey(SN);
    }
    public static String getroutes(String SN){
        return routemap.get(SN);
    }


    private static final ConcurrentHashMap<String, Double>avgspeedmap =new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, Integer>speednum =new ConcurrentHashMap<>();

    public static void addspeed(String SN, int devicespeed){
        double speed=devicespeed*3.6/50;
        if(speed>5){
            if(avgspeedmap.containsKey(SN)){
                int num=speednum.get(SN)+1;
                double nespeed=(speed-avgspeedmap.get(SN))/num + avgspeedmap.get(SN);
                avgspeedmap.put(SN,nespeed);
                speednum.put(SN,num);
            }else {
                avgspeedmap.put(SN,speed);
                speednum.put(SN,1);
            }
        }
    }

    public static void removespeed(String SN){
        avgspeedmap.remove(SN);
        speednum.remove(SN);
    }

    public static boolean isspeed(String SN){
        return avgspeedmap.containsKey(SN);
    }

    public static double getspeed(String SN){
        return avgspeedmap.get(SN);
    }
}
