package com.example.pmp.service.station;

import com.example.pmp.pojo.station.dto.CaseInfoSearchListDto;
import com.example.pmp.pojo.station.CaseInfo;

import java.util.List;

/**
 * @author Dandan
 * @date 2023/6/29 13:46
 **/
public interface CaseInfoService {

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
    List<String> searchAllLineTypeByProduct(String product);

    /**
     * 根据专案和线体类型查询所有线体编号
     *
     * @param product  专案
     * @param lineType 线体类型
     * @return 结果
     */
    List<String> searchAllLineIdByLineType(String product,
                                           String lineType);

    /**
     * 根据专案和线体类型和线体编号查询所有模组
     *
     * @param product  专案
     * @param lineType 线体类型
     * @param lineId   线体编号
     * @return 结果
     */
    List<String> searchAllModuleByLineId(String product,
                                         String lineType,
                                         String lineId);

    /**
     * 查询检测信息列表
     * @param searchListDto
     * @return
     */
    List<CaseInfo> searchCaseInfoList(CaseInfoSearchListDto searchListDto);

}
