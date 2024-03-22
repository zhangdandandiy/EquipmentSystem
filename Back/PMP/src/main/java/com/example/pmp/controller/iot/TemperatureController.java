package com.example.pmp.controller.iot;

import com.example.pmp.common.lang.AjaxResult;
import com.example.pmp.pojo.iot.temperature;
import com.example.pmp.service.iot.TemperatureService;
import com.example.pmp.utils.DiffHandleUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Dandan
 * @date 2023/3/24 19:22
 **/

@RestController
@RequestMapping("/temperature")
@Api(tags = "温湿度接口")
public class TemperatureController {

    @Autowired
    private TemperatureService temperatureService;

    @GetMapping("/all")
    @ApiOperation(value = "查询所有温湿度")
    public AjaxResult selectAllTemperature() {
        AjaxResult ajaxResult = AjaxResult.success();
        List<temperature> temperature = temperatureService.selectAllTemperature();
        ajaxResult.put("data", temperature);
        return ajaxResult;
    }

    @PostMapping("/saveNew")
    @ApiOperation("保存新的表头")
    public void saveNew(@RequestBody String[] newTableHeader) {
        String[] prefixTableHeader = {"items", "Testpcid", "Collecttime", "FileName"};
        newTableHeader = Stream.concat(Arrays.stream(prefixTableHeader), Arrays.stream(newTableHeader))
                .toArray(String[]::new);
        String fileName = "newTable.txt";
        DiffHandleUtils.saveArrayToFile(newTableHeader, fileName);
    }

    @PostMapping("/saveOld")
    @ApiOperation("保存旧的表头同时生成文本差异高亮文件")
    public ResponseEntity<ByteArrayResource> saveOld(String tableName) throws IOException {
        String[] oldTableHeader = getTableColumn(tableName);
        if (oldTableHeader.length > 0) {
            String fileName = "oldTable.txt";
            DiffHandleUtils.saveArrayToFile(oldTableHeader, fileName);
            // 对比 两个文件，获得不同点
            List<String> diffString = DiffHandleUtils.diffString("C:\\PMP\\PMP\\back\\stationFile\\oldTable.txt", "C:\\PMP\\PMP\\back\\stationFile\\newTable.txt");
            // 在生成一个diff.html文件，打开便可看到两个文件的对比
            String differentFile = "C:\\PMP\\PMP\\back\\stationFile\\different.html";
            DiffHandleUtils.generateDiffHtml(diffString, differentFile);
            File file = new File(differentFile);
            ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(file.toPath()));

            // 设置 HttpServletResponse 的响应头信息
            HttpHeaders headers = new HttpHeaders();
            // Content-Disposition : 用于设置响应的文件名和下载方式
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + "different.html" + "\"");
            // Content-Type：用于设置响应的数据类型
            headers.add(HttpHeaders.CONTENT_TYPE, "text/plain");
            // Content-Length：用于设置响应的数据长度
            headers.add(HttpHeaders.CONTENT_LENGTH, String.valueOf(file.length()));

            return ResponseEntity.ok()
                    // 将设置的响应头信息设置到响应中
                    .headers(headers)
                    .body(resource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    private String[] getTableColumn(String tableName) {
        String url = "jdbc:sqlserver://10.52.6.23:1433;DatabaseName=MESDataCenter;trustServerCertificate=true";
        String username = "ictsfc";
        String password = "XUh7tZN9j%yTps";
        String columnName;
        String[] dataArr;
        List<String> tableHeaderList = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            DatabaseMetaData metaData = connection.getMetaData();

            ResultSet results = metaData.getColumns(null, null, tableName, null);
            while (results.next()) {
                columnName = results.getString("COLUMN_NAME");
                tableHeaderList.add(columnName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        dataArr = tableHeaderList.toArray(new String[tableHeaderList.size()]);
        return dataArr;
    }

}
