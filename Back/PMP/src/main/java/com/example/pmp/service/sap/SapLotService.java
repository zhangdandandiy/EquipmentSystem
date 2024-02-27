package com.example.pmp.service.sap;

import com.example.pmp.pojo.sap.SapLot;

import java.util.List;

/**
 * @author Dandan
 * @date 2023/10/27 9:31
 **/

public interface SapLotService {

    List<SapLot> searchSapLotList(String pid, String status);

}
