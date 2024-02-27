package com.example.pmp.pojo.fox;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Dandan
 * @date 2023/8/25 9:37
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class targetFormat {

    private sendResultDetails sendResultDetails;

    private List<results> resultsList;

    private testAttributes testAttributes;

    private testStationAttributes testStationAttributes;

    private uutAttributes uutAttributes;

}
