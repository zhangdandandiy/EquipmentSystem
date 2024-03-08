package com.example.pmp.controller.module;

import com.example.pmp.common.BaseController;
import com.example.pmp.common.lang.AjaxResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

/**
 * @author Dandan
 * @date 2024/3/7 9:48
 **/

@Api(tags = "模具系统相关接口")
@RestController
@RequestMapping("/module")
public class ModuleController extends BaseController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/test")
    @ApiOperation("测试发送命令")
    public AjaxResult getD9XComponent() {
        String apiUrl = "http://192.168.1.102/?command=rest";

        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.TEXT_PLAIN));
        restTemplate.getMessageConverters().add(converter);

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.TEXT_PLAIN));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        try {
            restTemplate.exchange(apiUrl, HttpMethod.GET, entity, String.class);
        } catch (Exception e) {
            // 异常处理
        }

        return success();
    }

}
