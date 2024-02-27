package com.example.pmp.mapper.pmp;

import com.example.pmp.pojo.pmp.E85AutoPMP;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Dandan
 * @date 2023/5/24 14:47
 **/
@Mapper
public interface E85AutoMapper {

    /**
     * 查询所有专案
     *
     * @return
     */
    List<String> QueryConfig();

    /**
     * 查询所有线体类型
     *
     * @param Config
     * @return
     */
    List<String> QueryLineType(@Param("Config") String Config);

    /**
     * 查询所有线体编号
     *
     * @param Config
     * @param Line_name
     * @return
     */
    List<String> QueryLineid(@Param("Config") String Config,
                             @Param("Line_name") String Line_name);

    /**
     * 查询所有站点名
     *
     * @param Config
     * @param Line_name
     * @param Line_number
     * @return
     */
    List<String> QueryStationName(@Param("Config") String Config,
                                  @Param("Line_name") String Line_name,
                                  @Param("Line_number") String Line_number);

    /**
     * 查询 PMP 数据
     *
     * @param Station_name
     * @param Config
     * @param Line_name
     * @param Line_number
     * @return
     */
    List<E85AutoPMP> QueryE85AutoPMP(@Param("Config") String Config,
                                     @Param("Line_name") String Line_name,
                                     @Param("Line_number") String Line_number,
                                     @Param("Station_name") String Station_name);

}
