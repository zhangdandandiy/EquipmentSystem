package com.example.pmp.pojo.hot;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Dandan
 * @date 2024/3/20 16:17
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotReport {

    private String ProjectName;

    private String LineType;

    private String LineName;

    private String Direction;

    private String StartTime;

    private String EndTime;

}
