package com.wanji.etcxobu.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wanji.etcxobu.mapper.EtcxOnlineMapper;
import com.wanji.etcxobu.domain.EtcxOnline;
import com.wanji.etcxobu.service.IEtcxOnlineService;

/**
 * obuService业务层处理
 * 
 * @author wanji
 * @date 2021-09-30
 */
@Service
public class EtcxOnlineServiceImpl implements IEtcxOnlineService 
{
    @Autowired
    private EtcxOnlineMapper etcxOnlineMapper;

    /**
     * 查询obu
     * 
     * @param snId obuID
     * @return obu
     */
    @Override
    public EtcxOnline selectEtcxOnlineById(String snId)
    {
        return etcxOnlineMapper.selectEtcxOnlineById(snId);
    }

    /**
     * 查询obu列表
     * 
     * @param etcxOnline obu
     * @return obu
     */
    @Override
    public List<EtcxOnline> selectEtcxOnlineList(EtcxOnline etcxOnline)
    {
        return etcxOnlineMapper.selectEtcxOnlineList(etcxOnline);
    }

    /**
     * 新增obu
     * 
     * @param etcxOnline obu
     * @return 结果
     */
    @Override
    public int insertEtcxOnline(EtcxOnline etcxOnline)
    {
        return etcxOnlineMapper.insertEtcxOnline(etcxOnline);
    }

    /**
     * 修改obu
     * 
     * @param etcxOnline obu
     * @return 结果
     */
    @Override
    public int updateEtcxOnline(EtcxOnline etcxOnline)
    {
        return etcxOnlineMapper.updateEtcxOnline(etcxOnline);
    }

    /**
     * 批量删除obu
     * 
     * @param snIds 需要删除的obuID
     * @return 结果
     */
    @Override
    public int deleteEtcxOnlineByIds(String[] snIds)
    {
        return etcxOnlineMapper.deleteEtcxOnlineByIds(snIds);
    }

    /**
     * 删除obu信息
     * 
     * @param snId obuID
     * @return 结果
     */
    @Override
    public int deleteEtcxOnlineById(String snId)
    {
        return etcxOnlineMapper.deleteEtcxOnlineById(snId);
    }
}
