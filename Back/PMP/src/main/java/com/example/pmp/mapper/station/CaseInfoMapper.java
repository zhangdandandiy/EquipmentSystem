package com.example.pmp.mapper.station;

import com.example.pmp.pojo.station.dto.CaseInfoSearchListDto;
import com.example.pmp.pojo.station.CaseInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 检测站点 数据层
 *
 * @author Dandan
 * @date 2023/6/29 11:30
 **/

@Mapper
@Repository
public interface CaseInfoMapper {

    /**
     * 查询所有专案
     *
     * @return
     */
    List<String> searchAllProduct();

    /**
     * 根据专案查询所有线体类型
     *
     * @param product 专案
     * @return 结果
     */
    List<String> searchAllLineTypeByProduct(@Param("product") String product);

    /**
     * 根据专案和线体类型查询所有线体编号
     *
     * @param product  专案
     * @param lineType 线体类型
     * @return 结果
     */
    List<String> searchAllLineIdByLineType(@Param("product") String product,
                                           @Param("lineType") String lineType);

    /**
     * 根据专案和线体类型和线体编号查询所有模组
     *
     * @param product  专案
     * @param lineType 线体类型
     * @param lineId   线体编号
     * @return 结果
     */
    List<String> searchAllModuleByLineId(@Param("product") String product,
                                         @Param("lineType") String lineType,
                                         @Param("lineId") String lineId);

    List<CaseInfo> searchAllCaseInfoList(@Param("searchListDto") CaseInfoSearchListDto searchListDto);

}
