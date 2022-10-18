package com.wanji.etcxobu.mapper;

import java.util.List;
import com.wanji.etcxobu.domain.EtcxObuRoute;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * obuMapper接口
 * 
 * @author wanji
 * @date 2021-09-30
 */
public interface EtcxObuRouteMapper 
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
     * 删除obu
     * 
     * @param id obuID
     * @return 结果
     */
    public int deleteEtcxObuRouteById(Long id);

    /**
     * 批量删除obu
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteEtcxObuRouteByIds(Long[] ids);

    @Select("select * from etcx_obu_route where id=(select max(id) from etcx_obu_route where obu_sn=#{tssn,jdbcType=VARCHAR})")
    @Results({
            @Result(column = "obu_sn", property = "obuSn"),
            @Result(column = "start_time", property = "startTime"),
            @Result(column = "end_time", property = "endTime"),
            @Result(column = "obu_route", property = "obuRoute"),
            @Result(column = "session_id", property = "sessionId")
    })
    public EtcxObuRoute selectlastroute(@Param("tssn") String tssn);
}
