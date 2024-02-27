package com.example.pmp.mapper.fox;

import com.example.pmp.pojo.fox.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Dandan
 * @date 2023/8/25 8:29
 **/
@Mapper
public interface D8xMapper {

    List<d8x> selectD8XAll();

    /**
     * 新增M5
     *
     * @param mD8xMainLine301M5T M5
     * @return 结果
     */
    public int insertMD8xMainLine301M5T(D8XMainLine301M5 mD8xMainLine301M5T);

    /**
     * 查询M5
     */
    public List<D8XMainLine301M5Search> searchMD8xMainLine301M5T(@Param("Barcode") String Barcode,
                                                                 @Param("StartTime") String StartTime,
                                                                 @Param("EndTime") String EndTime);

    /**
     * 新增M6
     *
     * @param mD8xMainLine301M6T M6
     * @return 结果
     */
    public int insertMD8xMainLine301M6T(D8XMainLine301M6 mD8xMainLine301M6T);

    /**
     * 查询M6
     */
    public List<D8XMainLine301M6Search> searchMD8xMainLine301M6T(@Param("Barcode") String Barcode,
                                                                 @Param("StartTime") String StartTime,
                                                                 @Param("EndTime") String EndTime);

    /**
     * 新增M7
     *
     * @param mD8xMainLine301M7T M7
     * @return 结果
     */
    public int insertMD8xMainLine301M7T(D8XMainLine301M7 mD8xMainLine301M7T);

    /**
     * 查询M7
     */
    public List<D8XMainLine301M7Search> searchMD8xMainLine301M7T(@Param("Barcode") String Barcode,
                                                           @Param("StartTime") String StartTime,
                                                           @Param("EndTime") String EndTime);

    /**
     * 新增M8
     *
     * @param mD8xMainLine301M8T M8
     * @return 结果
     */
    public int insertMD8xMainLine301M8T(D8XMainLine301M8 mD8xMainLine301M8T);

    /**
     * 查询M8
     */
    public List<D8XMainLine301M8Search> searchMD8xMainLine301M8T(@Param("Barcode") String Barcode,
                                                                 @Param("StartTime") String StartTime,
                                                                 @Param("EndTime") String EndTime);

    /**
     * 新增M9
     *
     * @param mD8xMainLine301M9T M9
     * @return 结果
     */
    public int insertMD8xMainLine301M9T(D8XMainLine301M9 mD8xMainLine301M9T);

    public List<D8XMainLine301M9Search> searchMD8xMainLine301M9T(@Param("Barcode") String Barcode,
                                                                 @Param("StartTime") String StartTime,
                                                                 @Param("EndTime") String EndTime);

}
