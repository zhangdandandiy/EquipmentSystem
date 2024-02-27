package com.example.pmp.service.impl.station;

import com.example.pmp.mapper.station.CaseInfoMapper;
import com.example.pmp.pojo.station.dto.CaseInfoSearchListDto;
import com.example.pmp.pojo.station.CaseInfo;
import com.example.pmp.service.station.CaseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Dandan
 * @date 2023/6/29 13:47
 **/

@Service
public class CaseInfoServiceImpl implements CaseInfoService {

    @Autowired
    private CaseInfoMapper caseInfoMapper;

    @Override
    public List<String> searchAllProduct() {
        return caseInfoMapper.searchAllProduct();
    }

    @Override
    public List<String> searchAllLineTypeByProduct(String product) {
        return caseInfoMapper.searchAllLineTypeByProduct(product);
    }

    @Override
    public List<String> searchAllLineIdByLineType(String product, String lineType) {
        return caseInfoMapper.searchAllLineIdByLineType(product, lineType);
    }

    @Override
    public List<String> searchAllModuleByLineId(String product, String lineType, String lineId) {
        return caseInfoMapper.searchAllModuleByLineId(product, lineType, lineId);
    }

    @Override
    public List<CaseInfo> searchCaseInfoList(CaseInfoSearchListDto searchListDto) {
        return caseInfoMapper.searchAllCaseInfoList(searchListDto);
    }

}
