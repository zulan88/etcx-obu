package com.wanji.etcxobu.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wanji.etcxobu.mapper.EtcxObuInfoMapper;
import com.wanji.etcxobu.domain.EtcxObuInfo;
import com.wanji.etcxobu.service.IEtcxObuInfoService;

/**
 * obuService业务层处理
 * 
 * @author wanji
 * @date 2021-09-30
 */
@Service
public class EtcxObuInfoServiceImpl implements IEtcxObuInfoService 
{
    @Autowired
    private EtcxObuInfoMapper etcxObuInfoMapper;

    /**
     * 查询obu
     * 
     * @param obuSn obuID
     * @return obu
     */
    @Override
    public EtcxObuInfo selectEtcxObuInfoById(String obuSn)
    {
        return etcxObuInfoMapper.selectEtcxObuInfoById(obuSn);
    }

    /**
     * 查询obu列表
     * 
     * @param etcxObuInfo obu
     * @return obu
     */
    @Override
    public List<EtcxObuInfo> selectEtcxObuInfoList(EtcxObuInfo etcxObuInfo)
    {
        return etcxObuInfoMapper.selectEtcxObuInfoList(etcxObuInfo);
    }

    /**
     * 新增obu
     * 
     * @param etcxObuInfo obu
     * @return 结果
     */
    @Override
    public int insertEtcxObuInfo(EtcxObuInfo etcxObuInfo)
    {
        return etcxObuInfoMapper.insertEtcxObuInfo(etcxObuInfo);
    }

    /**
     * 修改obu
     * 
     * @param etcxObuInfo obu
     * @return 结果
     */
    @Override
    public int updateEtcxObuInfo(EtcxObuInfo etcxObuInfo)
    {
        return etcxObuInfoMapper.updateEtcxObuInfo(etcxObuInfo);
    }

    /**
     * 批量删除obu
     * 
     * @param obuSns 需要删除的obuID
     * @return 结果
     */
    @Override
    public int deleteEtcxObuInfoByIds(String[] obuSns)
    {
        return etcxObuInfoMapper.deleteEtcxObuInfoByIds(obuSns);
    }

    /**
     * 删除obu信息
     * 
     * @param obuSn obuID
     * @return 结果
     */
    @Override
    public int deleteEtcxObuInfoById(String obuSn)
    {
        return etcxObuInfoMapper.deleteEtcxObuInfoById(obuSn);
    }
}
