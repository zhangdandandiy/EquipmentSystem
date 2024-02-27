package com.example.pmp.pojo.station;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 站点信息
 *
 * @author Dandan
 * @date 2023/6/29 11:23
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StationInfo {

    /**
     * 站点名称
     */
    private String stationName;

    /**
     * 站点投入
     */
    private String stationInput;

    /**
     * 站点产出
     */
    private String stationOutput;

    /**
     * 站点NG
     */
    private String stationNG;

    /**
     * 检测项列表
     */
    private List<SenseInfo> senseList;

}
