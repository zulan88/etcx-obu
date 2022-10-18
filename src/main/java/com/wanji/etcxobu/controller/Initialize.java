package com.wanji.etcxobu.controller;

import com.wanji.etcxobu.domain.Curlstatus;
import com.wanji.etcxobu.domain.EtcxOnline;
import com.wanji.etcxobu.service.IEtcxOnlineService;
import com.wanji.etcxobu.task.OfflineCalculation;
import com.wanji.etcxobu.util.OnlineOffMapUtil;
import com.wanji.etcxobu.util.TableDataInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Initialize")
public class Initialize {

    @Autowired
    IEtcxOnlineService etcxOnlineService;

    @Autowired
    OfflineCalculation offlineCalculation;

    @GetMapping("/start")
    public String start(){
        EtcxOnline ori=new EtcxOnline();
        List<EtcxOnline> list=etcxOnlineService.selectEtcxOnlineList(ori);
        for (EtcxOnline etcxOnline:list){
            String SN=etcxOnline.getSnId();
            if(OnlineOffMapUtil.isKey(SN)){
                Curlstatus curlstatus=OnlineOffMapUtil.getmes(SN);
//                curlstatus.setStatus(Math.toIntExact(etcxOnline.getStatus()));
                curlstatus.setVehPlate(etcxOnline.getVehPlate());
                OnlineOffMapUtil.addnotr(SN,curlstatus);
            }else {
                Curlstatus curlstatus=new Curlstatus();
                curlstatus.setStatus(Math.toIntExact(etcxOnline.getStatus()));
                curlstatus.setDevicetype(etcxOnline.getOlType());
                curlstatus.setLat(etcxOnline.getOlLat());
                curlstatus.setLon(etcxOnline.getOlLong());
                curlstatus.setVehPlate(etcxOnline.getVehPlate());
                OnlineOffMapUtil.add(SN,curlstatus);
            }
        }
        return "ok";
    }

    @GetMapping("/getobu")
    public TableDataInfo getobustatus(){
        EtcxOnline ori=new EtcxOnline();
        ori.setOlType("OBU");
        List<EtcxOnline> list=etcxOnlineService.selectEtcxOnlineList(ori);
        List<EtcxOnline> res=new ArrayList<>();
        for (EtcxOnline etcxOnline:list){
            if(OnlineOffMapUtil.isKey(etcxOnline.getSnId())){
                Curlstatus curlstatus=OnlineOffMapUtil.getmes(etcxOnline.getSnId());
                if(curlstatus.getStatus()==1) {
                    etcxOnline.setStatus(Long.valueOf(curlstatus.getStatus()));
                    etcxOnline.setOlLong(curlstatus.getLon());
                    etcxOnline.setOlLat(curlstatus.getLat());
                    if (curlstatus.getTrack() != null) {
                        etcxOnline.setOlEvent(Long.valueOf(curlstatus.getTrack()));
                    }
                    res.add(etcxOnline);
                }
                continue;
            }
            if(etcxOnline.getStatus()==1){
                res.add(etcxOnline);
            }

        }
        return getDataTable(res);
    }


    @GetMapping("/getobu2")
    public TableDataInfo getobustatus2(){
        EtcxOnline ori=new EtcxOnline();
        ori.setOlType("OBU");
        List<EtcxOnline> list=etcxOnlineService.selectEtcxOnlineList(ori);
        for (EtcxOnline etcxOnline:list){
            if(OnlineOffMapUtil.isKey(etcxOnline.getSnId())){
                Curlstatus curlstatus=OnlineOffMapUtil.getmes(etcxOnline.getSnId());
                etcxOnline.setStatus(Long.valueOf(curlstatus.getStatus()));
                etcxOnline.setOlLong(curlstatus.getLon());
                etcxOnline.setOlLat(curlstatus.getLat());
                if (curlstatus.getTrack() != null) {
                    etcxOnline.setOlEvent(Long.valueOf(curlstatus.getTrack()));
                }
            }
        }
        return getDataTable(list);
    }


    //获取obu设备状态
    @GetMapping("/online")
    public boolean getonline(){
        Map<String, Curlstatus>map=OnlineOffMapUtil.getmap();
        for(Map.Entry<String, Curlstatus>entry:map.entrySet()){
            if(entry.getValue().getDevicetype().equals("OBU")){
                if(entry.getValue().getStatus()==1){
                    OnlineOffMapUtil.remove(entry.getKey());
                }
            }
        }
        return true;
    }


    @GetMapping("/task")
    public String tasktest(){
        offlineCalculation.cron();
        return "ok";
    }

    protected TableDataInfo getDataTable(List<?> list)
    {
        TableDataInfo rspData = new TableDataInfo();
        rspData.setCode(200);
        rspData.setRows(list);
        rspData.setMsg("查询成功");
        rspData.setTotal(list.size());
        return rspData;
    }
}
