package com.wanji.etcxobu.task;

import com.wanji.etcxobu.domain.Curlstatus;
import com.wanji.etcxobu.domain.EtcxOnline;
import com.wanji.etcxobu.service.IEtcxOnlineService;
import com.wanji.etcxobu.util.OnlineOffMapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RsuCheck {

    @Autowired
    IEtcxOnlineService etcxOnlineService;

    @Scheduled(cron = "*/30 * * * * ?")
    public void cron(){
        EtcxOnline ori=new EtcxOnline();
        ori.setOlType("RSU");
        List<EtcxOnline>list=etcxOnlineService.selectEtcxOnlineList(ori);
        for (EtcxOnline etcxOnline:list){
            String SN=etcxOnline.getSnId();
            if(OnlineOffMapUtil.isKey(SN)){
                Curlstatus curlstatus=OnlineOffMapUtil.getmes(SN);
                curlstatus.setStatus(Math.toIntExact(etcxOnline.getStatus()));
                curlstatus.setLat(etcxOnline.getOlLat());
                curlstatus.setLon(etcxOnline.getOlLong());
                OnlineOffMapUtil.addnotr(SN,curlstatus);
            }else {
                Curlstatus curlstatus=new Curlstatus();
                curlstatus.setStatus(Math.toIntExact(etcxOnline.getStatus()));
                curlstatus.setDevicetype(etcxOnline.getOlType());
                curlstatus.setLat(etcxOnline.getOlLat());
                curlstatus.setLon(etcxOnline.getOlLong());
                OnlineOffMapUtil.add(SN,curlstatus);
            }
        }
        OnlineOffMapUtil.brokerput();
    }
}
