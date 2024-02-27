package com.example.pmp.service.pmp;

import com.example.pmp.pojo.pmp.E85AutoPMP;

import java.util.List;

/**
 * @author Dandan
 * @date 2023/5/24 15:08
 **/
public interface E85AutoPMPService {

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
    List<String> QueryLineType(String Config);

    /**
     * 查询所有线体编号
     *
     * @param Config
     * @param Line_name
     * @return
     */
    List<String> QueryLineid(String Config, String Line_name);

    /**
     * 查询所有站点名
     *
     * @param Config
     * @param Line_name
     * @param Line_number
     * @return
     */
    List<String> QueryStationName(String Config, String Line_name, String Line_number);

    /**
     * 查询 PMP 数据
     *
     * @param Station_name
     * @param Config
     * @param Line_name
     * @param Line_number
     * @return
     */
    List<E85AutoPMP> QueryE85AutoPMP(String Config, String Line_name, String Line_number, String Station_name);

}
