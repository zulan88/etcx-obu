package com.wanji.etcxobu.mapper;

import java.util.List;
import com.wanji.etcxobu.domain.EtcxObuInfo;

/**
 * obuMapper接口
 * 
 * @author wanji
 * @date 2021-09-30
 */
public interface EtcxObuInfoMapper 
{
    /**
     * 查询obu
     * 
     * @param obuSn obuID
     * @return obu
     */
    public EtcxObuInfo selectEtcxObuInfoById(String obuSn);

    /**
     * 查询obu列表
     * 
     * @param etcxObuInfo obu
     * @return obu集合
     */
    public List<EtcxObuInfo> selectEtcxObuInfoList(EtcxObuInfo etcxObuInfo);

    /**
     * 新增obu
     * 
     * @param etcxObuInfo obu
     * @return 结果
     */
    public int insertEtcxObuInfo(EtcxObuInfo etcxObuInfo);

    /**
     * 修改obu
     * 
     * @param etcxObuInfo obu
     * @return 结果
     */
    public int updateEtcxObuInfo(EtcxObuInfo etcxObuInfo);

    /**
     * 删除obu
     * 
     * @param obuSn obuID
     * @return 结果
     */
    public int deleteEtcxObuInfoById(String obuSn);

    /**
     * 批量删除obu
     * 
     * @param obuSns 需要删除的数据ID
     * @return 结果
     */
    public int deleteEtcxObuInfoByIds(String[] obuSns);
}
