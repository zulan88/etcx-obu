package com.wanji.etcxobu.service;

import java.util.List;
import com.wanji.etcxobu.domain.EtcxOnline;

/**
 * obuService接口
 * 
 * @author wanji
 * @date 2021-09-30
 */
public interface IEtcxOnlineService 
{
    /**
     * 查询obu
     * 
     * @param snId obuID
     * @return obu
     */
    public EtcxOnline selectEtcxOnlineById(String snId);

    /**
     * 查询obu列表
     * 
     * @param etcxOnline obu
     * @return obu集合
     */
    public List<EtcxOnline> selectEtcxOnlineList(EtcxOnline etcxOnline);

    /**
     * 新增obu
     * 
     * @param etcxOnline obu
     * @return 结果
     */
    public int insertEtcxOnline(EtcxOnline etcxOnline);

    /**
     * 修改obu
     * 
     * @param etcxOnline obu
     * @return 结果
     */
    public int updateEtcxOnline(EtcxOnline etcxOnline);

    /**
     * 批量删除obu
     * 
     * @param snIds 需要删除的obuID
     * @return 结果
     */
    public int deleteEtcxOnlineByIds(String[] snIds);

    /**
     * 删除obu信息
     * 
     * @param snId obuID
     * @return 结果
     */
    public int deleteEtcxOnlineById(String snId);
}
