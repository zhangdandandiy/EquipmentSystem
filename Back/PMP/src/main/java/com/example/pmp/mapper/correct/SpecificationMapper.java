package com.example.pmp.mapper.correct;

import com.example.pmp.pojo.correct.Specification;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Dandan
 * @date 2024/1/5 19:09
 **/
@Mapper
public interface SpecificationMapper {

    /**
     * 获取规格列表
     *
     * @param specification
     * @return
     */
    public List<Specification> getSpecList(Specification specification);

}
