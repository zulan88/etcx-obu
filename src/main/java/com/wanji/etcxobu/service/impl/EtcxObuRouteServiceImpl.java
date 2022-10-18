package com.wanji.etcxobu.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wanji.etcxobu.mapper.EtcxObuRouteMapper;
import com.wanji.etcxobu.domain.EtcxObuRoute;
import com.wanji.etcxobu.service.IEtcxObuRouteService;

/**
 * obuService业务层处理
 * 
 * @author wanji
 * @date 2021-09-30
 */
@Service
public class EtcxObuRouteServiceImpl implements IEtcxObuRouteService 
{
    @Autowired
    private EtcxObuRouteMapper etcxObuRouteMapper;

    /**
     * 查询obu
     * 
     * @param id obuID
     * @return obu
     */
    @Override
    public EtcxObuRoute selectEtcxObuRouteById(Long id)
    {
        return etcxObuRouteMapper.selectEtcxObuRouteById(id);
    }

    /**
     * 查询obu列表
     * 
     * @param etcxObuRoute obu
     * @return obu
     */
    @Override
    public List<EtcxObuRoute> selectEtcxObuRouteList(EtcxObuRoute etcxObuRoute)
    {
        return etcxObuRouteMapper.selectEtcxObuRouteList(etcxObuRoute);
    }

    /**
     * 新增obu
     * 
     * @param etcxObuRoute obu
     * @return 结果
     */
    @Override
    public int insertEtcxObuRoute(EtcxObuRoute etcxObuRoute)
    {
        return etcxObuRouteMapper.insertEtcxObuRoute(etcxObuRoute);
    }

    /**
     * 修改obu
     * 
     * @param etcxObuRoute obu
     * @return 结果
     */
    @Override
    public int updateEtcxObuRoute(EtcxObuRoute etcxObuRoute)
    {
        return etcxObuRouteMapper.updateEtcxObuRoute(etcxObuRoute);
    }

    /**
     * 批量删除obu
     * 
     * @param ids 需要删除的obuID
     * @return 结果
     */
    @Override
    public int deleteEtcxObuRouteByIds(Long[] ids)
    {
        return etcxObuRouteMapper.deleteEtcxObuRouteByIds(ids);
    }

    /**
     * 删除obu信息
     * 
     * @param id obuID
     * @return 结果
     */
    @Override
    public int deleteEtcxObuRouteById(Long id)
    {
        return etcxObuRouteMapper.deleteEtcxObuRouteById(id);
    }
}
