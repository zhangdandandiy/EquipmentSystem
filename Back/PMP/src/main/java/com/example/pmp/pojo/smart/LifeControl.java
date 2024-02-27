package com.example.pmp.pojo.smart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Dandan
 * @date 2023/10/10 13:18
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LifeControl {

    private String LineType;
    private String LineID;
    private String ModuleID;
    private String LifeControlName;
    private String Count;
    private String WarningOfCount;
    private String UpperOfCount;
    private String Message;
}
