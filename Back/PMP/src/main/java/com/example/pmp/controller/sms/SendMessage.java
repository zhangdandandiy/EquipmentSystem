package com.example.pmp.controller.sms;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Dandan
 * @date 2023/9/25 11:14
 **/
@RestController
@Api(tags = "短信通知相关接口")
@RequestMapping("/sms")
public class SendMessage {

//    @ApiOperation("发送短信")
//    @PostMapping("/send")
//    public void sendMessage() {
//        //短信api调用地址
//        String host = "https://dfsns.market.alicloudapi.com";
//        //请求路径
//        String path = "/data/send_sms";
//        //请求方式
//        String method = "POST";
//        //appcode：自己的AppCode，可以在自己的控制台找到，是一串32位的字符串
//        String appcode = "a4e60066fb1b4fb493ab340081085276";
//        Map<String, String> headers = new HashMap<String, String>();
//        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
//        headers.put("Authorization", "APPCODE " + appcode);
//        //根据API的要求，定义相对应的Content-Type
//        headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
//        Map<String, String> querys = new HashMap<String, String>();
//        Map<String, String> bodys = new HashMap<String, String>();
//
//        //使用随机数生成4位验证码
//        StringBuilder stringBuilder = new StringBuilder();
//        for (int i = 0; i < 4; i++) {
//            int randomNum = (int) (Math.random() * 10);
//            stringBuilder.append(randomNum);
//        }
//        String code = stringBuilder.toString();
//        //这里是要发送给用户的验证码，我们使用了随机数进行生成
//        bodys.put("content", "code:" + code);
//        //这里是接受短信的手机号码，我们在实际开发时这里就不能写死了
//        bodys.put("phone_number", "18294942774");
//        //这里是发送短信的模板ID：代表整体短信文案模板
//        bodys.put("template_id", "TPL_0000");
//        try {
////            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
////            System.out.println(response.toString());
//            //获取response的body
//            // System.out.println(EntityUtils.toString(response.getEntity()));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

}
