package com.example.pmp.service.impl.sap;

import com.example.pmp.mapper.sap.SapLotMapper;
import com.example.pmp.pojo.sap.SapLot;
import com.example.pmp.service.sap.SapLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Dandan
 * @date 2023/10/27 9:32
 **/

@Service
public class SapLotServiceImpl implements SapLotService {

    @Autowired
    private SapLotMapper sapLotMapper;

    @Override
    public List<SapLot> searchSapLotList(String pid, String status) {
        return sapLotMapper.searchSapLotList(pid, status);
    }
}
