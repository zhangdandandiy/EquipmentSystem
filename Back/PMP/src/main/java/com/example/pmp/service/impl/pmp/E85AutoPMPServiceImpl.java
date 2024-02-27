package com.example.pmp.service.impl.pmp;

import com.example.pmp.mapper.pmp.E85AutoMapper;
import com.example.pmp.pojo.pmp.E85AutoPMP;
import com.example.pmp.service.pmp.E85AutoPMPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Dandan
 * @date 2023/5/24 15:11
 **/
@Service
public class E85AutoPMPServiceImpl implements E85AutoPMPService {

    @Autowired
    private E85AutoMapper E85AutoMapper;

    @Override
    public List<String> QueryConfig() {
        return E85AutoMapper.QueryConfig();
    }

    @Override
    public List<String> QueryLineType(String Config) {
        return E85AutoMapper.QueryLineType(Config);
    }

    @Override
    public List<String> QueryLineid(String Config, String Line_name) {
        return E85AutoMapper.QueryLineid(Config, Line_name);
    }

    @Override
    public List<String> QueryStationName(String Config, String Line_name, String Line_number) {
        return E85AutoMapper.QueryStationName(Config, Line_name, Line_number);
    }

    @Override
    public List<E85AutoPMP> QueryE85AutoPMP(String Config, String Line_name, String Line_number, String Station_name) {
        return E85AutoMapper.QueryE85AutoPMP(Config, Line_name, Line_number, Station_name);
    }
}
