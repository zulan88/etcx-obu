package com.wanji.etcxobu.service;

import java.util.List;
import com.wanji.etcxobu.domain.EtcxObuRoute;

/**
 * obuService接口
 * 
 * @author wanji
 * @date 2021-09-30
 */
public interface IEtcxObuRouteService 
{
    /**
     * 查询obu
     * 
     * @param id obuID
     * @return obu
     */
    public EtcxObuRoute selectEtcxObuRouteById(Long id);

    /**
     * 查询obu列表
     * 
     * @param etcxObuRoute obu
     * @return obu集合
     */
    public List<EtcxObuRoute> selectEtcxObuRouteList(EtcxObuRoute etcxObuRoute);

    /**
     * 新增obu
     * 
     * @param etcxObuRoute obu
     * @return 结果
     */
    public int insertEtcxObuRoute(EtcxObuRoute etcxObuRoute);

    /**
     * 修改obu
     * 
     * @param etcxObuRoute obu
     * @return 结果
     */
    public int updateEtcxObuRoute(EtcxObuRoute etcxObuRoute);

    /**
     * 批量删除obu
     * 
     * @param ids 需要删除的obuID
     * @return 结果
     */
    public int deleteEtcxObuRouteByIds(Long[] ids);

    /**
     * 删除obu信息
     * 
     * @param id obuID
     * @return 结果
     */
    public int deleteEtcxObuRouteById(Long id);
}
