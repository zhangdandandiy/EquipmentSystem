package com.example.pmp.service.impl.hot;

import com.example.pmp.mapper.hot.MThermodynamicchartTMapper;
import com.example.pmp.pojo.hot.MThermodynamicchartT;
import com.example.pmp.service.hot.MThermodynamicchartTService;
import org.apache.commons.math3.distribution.NormalDistribution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Dandan
 * @date 2024/1/16 18:57
 **/
@Service
public class MThermodynamicchartTServiceImpl implements MThermodynamicchartTService {

    @Autowired
    private MThermodynamicchartTMapper mThermodynamicchartTMapper;

    @Override
    public int insertMThermodynamicchartT() {
        MThermodynamicchartT mThermodynamicchartT = new MThermodynamicchartT();
        mThermodynamicchartT.setTestpcid("WIN-SMJ1TEGDD9S");
        mThermodynamicchartT.setFileName("D9XD4Y(1).csv");
        mThermodynamicchartT.setProjectName("D9X");
        mThermodynamicchartT.setLineType("Main Line3");
        mThermodynamicchartT.setLineName("WZ-A118-01");
        mThermodynamicchartT.setModuleID("M4");
        mThermodynamicchartT.setCameraID("AOI1");
        mThermodynamicchartT.setBarcode("TF2H120P1W600000H2");
        mThermodynamicchartT.setErrorCode("1");
        mThermodynamicchartT.setErrorNum("1");
        mThermodynamicchartT.setResult("PASS");

        BigDecimal x;
        BigDecimal y;

        String Direction = "";
        // 均值和标准差
        double mean = 5.0;
        double standardDeviation = 3;

        // 创建正态分布对象
        NormalDistribution distribution = new NormalDistribution(mean, standardDeviation);

        Direction = "Top";
        mThermodynamicchartT.setDirection(Direction);
        for (int i = 0; i < 50000; i++) {
            mThermodynamicchartT.setCollecttime(new Date());
            mThermodynamicchartT.setTestTime(new Date());  // 生成 x 坐标数据

            x = BigDecimal.valueOf(distribution.sample());
            y = BigDecimal.valueOf(distribution.sample());

            mThermodynamicchartT.setPositionX(x);
            mThermodynamicchartT.setPositionY(y);
            mThermodynamicchartTMapper.insertMThermodynamicchartT(mThermodynamicchartT);

        }

        return 1;
    }

}
