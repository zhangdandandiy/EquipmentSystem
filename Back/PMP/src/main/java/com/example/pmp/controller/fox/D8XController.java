package com.example.pmp.controller.fox;

import com.example.pmp.common.lang.AjaxResult;
import com.example.pmp.pojo.fox.*;
import com.example.pmp.service.fox.D8XService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLSocketFactory;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Dandan
 * @date 2023/8/25 8:33
 **/
@Api(tags = "Fox相关接口")
@RestController
@RequestMapping("/fox")
public class D8XController {

    @Autowired
    private D8XService d8XService;

    @Autowired
    private RestTemplate restTemplate;

    // 要访问的url
    private static final String URL = "https://cougar-uat.apple.com/ITSZ/v3/Squirrel/s.mpl";
    // 证书路径
    private static final String CERT_PATH = "C:\\OpenSSL\\ITSZfox1.pfx";
    // 证书密码
    private static final String CERT_PASSWORD = "itsz2023";

    private SSLSocketFactory sslFactory = null;

//    @PostMapping("/d8x")
//    public AjaxResult selectD8XAll() {
//        AjaxResult ajaxResult = AjaxResult.success();
//        List<d8x> d8xList = d8XService.selectD8XAll();
//        ajaxResult.put("data", d8xList);
//        return ajaxResult;
//    }

    @GetMapping("/formatData")
    public targetFormat formatData() {
        AjaxResult ajaxResult = AjaxResult.success();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<d8x> request = new HttpEntity<>(headers);

        String apiUrl = "http://localhost:8091/fox/d8x";
        LinkedHashMap d8xData = restTemplate.exchange(apiUrl, HttpMethod.POST, request, LinkedHashMap.class).getBody();

        // 获取 `data` 字段的值
        List<Map<String, Object>> dataList = (List<Map<String, Object>>) d8xData.get("data");

        List<d8x> d8xResultList = new ArrayList<>();
        for (Map<String, Object> map : dataList) {
            d8x d8xObject = new d8x();
            d8xObject.setBarcode(map.get("barcode").toString());
            d8xObject.setTestResult(map.get("testResult").toString());
            // 将转换后的对象添加到 resultList 中
            d8xResultList.add(d8xObject);
        }
        targetFormat targetFormat = d8XService.convertData(d8xResultList);

        ajaxResult.put("data", targetFormat);

        // 返回响应给客户端
        return targetFormat;
    }

//    @PostMapping("/sendData")
//    public void sendData() throws Exception {
//        String url = "https://cougar-uat.apple.com/ITSZ/v3/Squirrel/s.mpl"; // 替换成实际接口URL
//        String jsonInput = "";
//
//        // JSON文件路径
//        String filePath = "C:\\OpenSSL\\moduleData.json";
//
//        try {
//            // 读取JSON文件内容
//            String jsonContent = new String(Files.readAllBytes(Paths.get(filePath)));
//
//            // 创建ObjectMapper对象
//            ObjectMapper objectMapper = new ObjectMapper();
//
//            // 将JSON字符串转换为JSON对象
//            Object jsonObject = objectMapper.readValue(jsonContent, Object.class);
//
//            // 将JSON对象转换为JSON字符串
//            jsonInput = objectMapper.writeValueAsString(jsonObject);
//
//            // 输出JSON字符串
//            System.out.println(jsonInput);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        // 证书和私钥文件路径
//        String pfxPath = "C:\\OpenSSL\\ITSZfox1.pfx";
//        String password = "itsz2023"; // 如果PFX文件有密码，替换成实际密码
//
//        // 加载PFX文件
//        // KeyStore keyStore = KeyStore.getInstance("SunJSSE");
//        // KeyStore keyStore = KeyStore.getInstance("PKCS12");
//        // KeyStore keyStore = KeyStore.getInstance("JKS");
//        KeyStore keyStore = KeyStore.getInstance("Windows-MY");
//        try (InputStream inputStream = new FileInputStream(pfxPath)) {
//            keyStore.load(inputStream, password.toCharArray());
//        }
//
//        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
//        keyManagerFactory.init(keyStore, password.toCharArray());
//
//        // 创建SSL上下文
//        SSLContext sslContext = SSLContext.getInstance("TLS");
//        sslContext.init(keyManagerFactory.getKeyManagers(), null, null);
//
//        // 设置默认的SSL套接字工厂
//        SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
//        HttpsURLConnection.setDefaultSSLSocketFactory(sslSocketFactory);
//
//        // 创建URL对象
//        URL apiUrl = new URL(url);
//
//        // 打开连接
//        HttpsURLConnection connection = (HttpsURLConnection) apiUrl.openConnection();
//
//        // 设置请求方法和其他属性
//        connection.setRequestMethod("POST");
//        connection.setDoOutput(true);
//        connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
//
//        // 写入JSON数据
//        try (OutputStream outputStream = connection.getOutputStream()) {
//            byte[] input = jsonInput.getBytes(StandardCharsets.UTF_8);
//            outputStream.write(input, 0, input.length);
//        }
//
//        // 获取响应
//        int responseCode = connection.getResponseCode();
//        System.out.println("Response Code: " + responseCode);
//
//        // 读取响应内容
//        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
//            String line;
//            StringBuilder response = new StringBuilder();
//            while ((line = reader.readLine()) != null) {
//                response.append(line);
//            }
//            System.out.println("Response: " + response.toString());
//        }
//
//        // 关闭连接
//        connection.disconnect();
//    }
//
//    @PostMapping("/test")
//    public void test() throws Exception {
//        // 加载 .pfx 文件到 KeyStore 对象
//        KeyStore keyStore = KeyStore.getInstance("PKCS12");
//        FileInputStream inputStream = new FileInputStream("C:\\OpenSSL\\ITSZfox1.pfx");
//        keyStore.load(inputStream, "itsz2023".toCharArray());
//
//        // 初始化 KeyManagerFactory
//        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
//        keyManagerFactory.init(keyStore, "itsz2023".toCharArray());
//
//        // 初始化 SSLContext
//        SSLContext sslContext = SSLContext.getInstance("TLS");
//        sslContext.init(keyManagerFactory.getKeyManagers(), null, null);
//
//        // 创建 URL 对象和 HttpsURLConnection
//        URL url = new URL("https://cougar-uat.apple.com/ITSZ/v3/Squirrel/s.mpl");
//        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
//        connection.setSSLSocketFactory(sslContext.getSocketFactory());
//
//        // 设置请求方法和请求头
//        connection.setRequestMethod("POST");
//        connection.setDoOutput(true); // 添加该行
//        connection.setRequestProperty("Content-Type", "application/json");
//
//        // 加载 JSON 文件内容并发送请求
//        File jsonFile = new File("C:\\OpenSSL\\STATION7.json");
//        FileInputStream jsonInputStream = new FileInputStream(jsonFile);
//        OutputStream outputStream = connection.getOutputStream();
//        byte[] buffer = new byte[4096];
//        int bytesRead;
//        while ((bytesRead = jsonInputStream.read(buffer)) != -1) {
//            outputStream.write(buffer, 0, bytesRead);
//        }
//        jsonInputStream.close();
//        outputStream.close();
//
//        // 获取响应
//        int responseCode = connection.getResponseCode();
//        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//        String line;
//        StringBuilder response = new StringBuilder();
//        while ((line = reader.readLine()) != null) {
//            response.append(line);
//        }
//        reader.close();
//
//        // 处理响应数据
//        System.out.println("Response Code: " + responseCode);
//        System.out.println("Response Body: " + response);
//
//        // 关闭连接
//        connection.disconnect();
//    }
//
//    @PostMapping("/test1")
//    public void test1() throws Exception {
//        String url = "https://cougar-uat.apple.com/ITSZ/v3/Squirrel/s.mpl"; // 替换成实际接口URL
//        String jsonInput = ""; // 替换成要发送的JSON数据
//        String pfxPath = "C:\\OpenSSL\\ITSZfox1.pfx"; // 替换成PFX文件的路径
//        String pfxPassword = "itsz2023"; // 替换成PFX文件的密码
//
//        String filePath = "C:\\OpenSSL\\moduleData.json";
//
//        jsonInput = Files.readString(Paths.get(filePath));
//
//        // 创建KeyStore并加载PFX文件
//        KeyStore keyStore = KeyStore.getInstance("PKCS12");
//        try (FileInputStream fis = new FileInputStream(pfxPath)) {
//            keyStore.load(fis, pfxPassword.toCharArray());
//        }
//
//        // 创建SSL上下文
//        SSLContext sslContext = SSLContexts.custom()
//                .loadKeyMaterial(keyStore, pfxPassword.toCharArray())
//                .build();
//
//        // 创建HTTP客户端
//        CloseableHttpClient httpClient = HttpClients.custom()
//                .setSSLContext(sslContext)
//                .build();
//
//        // 创建POST请求
//        HttpPost httpPost = new HttpPost(url);
//        httpPost.addHeader("Content-Type", "application/json");
//
//        // 设置JSON数据
//        StringEntity jsonEntity = new StringEntity(jsonInput);
//        httpPost.setEntity(jsonEntity);
//
//        // 发送请求并获取响应
//        CloseableHttpResponse response = httpClient.execute(httpPost);
//
//        // 读取响应内容
//        System.out.println("Response：" + response.toString());
////        HttpEntity entity = response.getEntity();
////        if (entity != null) {
////            try (InputStream inputStream = entity.getContent();
////                 BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
////                String line;
////                StringBuilder responseContent = new StringBuilder();
////                while ((line = reader.readLine()) != null) {
////                    responseContent.append(line);
////                }
////                System.out.println("Response: " + responseContent.toString());
////            }
////        }
//
//        // 关闭响应和HTTP客户端
//        response.close();
//        httpClient.close();
//    }
//
//    @PostMapping("/test2")
//    public void test2() throws Exception {
//        // JSON文件路径
//        String filePath = "C:\\OpenSSL\\moduleData.json";
//        String jsonInput = "";
//        try {
//            // 读取JSON文件内容
//            String jsonContent = new String(Files.readAllBytes(Paths.get(filePath)));
//
//            // 创建ObjectMapper对象
//            ObjectMapper objectMapper = new ObjectMapper();
//
//            // 将JSON字符串转换为JSON对象
//            Object jsonObject = objectMapper.readValue(jsonContent, Object.class);
//
//            // 将JSON对象转换为JSON字符串
//            jsonInput = objectMapper.writeValueAsString(jsonObject);
//
//            // 输出JSON字符串
//            System.out.println(jsonInput);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        //测试线写死，后期改用配置文件
//        String keystoreFile = "C:\\OpenSSL\\ITSZfox1.p12";//jboss
//        String keystorePass = "itsz2023";
//        String keystoreType = "PKCS12";
//
//
//        String urlStr = "https://cougar-uat.apple.com/ITSZ/v3/Squirrel/s.mpl";
//        String charsetName = "UTF-8";
//        String result = sendHttpSSLJsonMsg(keystoreFile, keystorePass, keystoreType, urlStr, jsonInput, charsetName);
//        System.out.println("result:" + result);
//
//    }
//
//    @PostMapping("/test3")
//    public void test3() {
//        String url = "https://cougar-uat.apple.com/ITSZ/v3/Squirrel/s.mpl";
//        String jsonFilePath = "C:\\OpenSSL\\STATION7.json";
//        String pfxFilePath = "C:\\OpenSSL\\ITSZfox1.pfx";
//        String pfxPassword = "itsz2023";
//
//        try {
//            // 加载PFX文件
//            KeyStore keyStore = KeyStore.getInstance("PKCS12");
//            keyStore.load(Files.newInputStream(Paths.get(pfxFilePath)), pfxPassword.toCharArray());
//
//            // 创建SSL上下文
//            SSLContext sslContext = SSLContextBuilder.create()
//                    .loadKeyMaterial(keyStore, pfxPassword.toCharArray())
//                    //.loadTrustMaterial(TrustManagerBuilder.create().build())
//                    .build();
//
//            // 创建HTTP客户端
//            CloseableHttpClient httpClient = HttpClients.custom()
//                    .setSSLContext(sslContext)
//                    .build();
//
//            // 读取JSON文件内容
//            String jsonContent = readJsonFile(jsonFilePath);
//
//            // 创建POST请求
//            HttpPost httpPost = new HttpPost(url);
//            httpPost.setEntity(new StringEntity(jsonContent, ContentType.APPLICATION_JSON));
//
//            // 发送请求并获取响应
//            try (CloseableHttpResponse response = httpClient.execute(httpPost)) {
//                // 获取响应状态码
//                int statusCode = response.getStatusLine().getStatusCode();
//                System.out.println("Status Code: " + statusCode);
//
//                // 获取响应体内容
//                HttpEntity entity = response.getEntity();
//                String responseContent = EntityUtils.toString(entity, StandardCharsets.UTF_8);
//                System.out.println("Response Body: " + responseContent);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    private static String readJsonFile(String filePath) throws IOException {
//        // 读取JSON文件内容
//        byte[] jsonData = Files.readAllBytes(Paths.get(filePath));
//        return new String(jsonData, StandardCharsets.UTF_8);
//    }

    @PostMapping("/M5")
    public AjaxResult insertMD8xMainLine301M5T(@RequestBody D8XMainLine301M5 d8XMainLine301M5) {
        AjaxResult ajaxResult = AjaxResult.success();
        int result = d8XService.insertMD8xMainLine301M5T(d8XMainLine301M5);
        ajaxResult.put("result", result);
        return ajaxResult;
    }

    @GetMapping("/getM5")
    @ApiOperation("M5")
    public AjaxResult insertMD8xMainLine301M5T(String Barcode, String StartTime, String EndTime) {
        AjaxResult ajaxResult = AjaxResult.success();
        List<D8XMainLine301M5Search> result = d8XService.searchMD8xMainLine301M5T(Barcode, StartTime, EndTime);
        ajaxResult.put("result", result);
        return ajaxResult;
    }

    @PostMapping("/M6")
    public AjaxResult insertMD8xMainLine301M6T(@RequestBody D8XMainLine301M6 d8XMainLine301M6) {
        AjaxResult ajaxResult = AjaxResult.success();
        int result = d8XService.insertMD8xMainLine301M6T(d8XMainLine301M6);
        ajaxResult.put("result", result);
        return ajaxResult;
    }

    @GetMapping("/getM6")
    @ApiOperation("M6")
    public AjaxResult insertMD8xMainLine301M6T(String Barcode, String StartTime, String EndTime) {
        AjaxResult ajaxResult = AjaxResult.success();
        List<D8XMainLine301M6Search> result = d8XService.searchMD8xMainLine301M6T(Barcode, StartTime, EndTime);
        ajaxResult.put("result", result);
        return ajaxResult;
    }

    @PostMapping("/M7")
    public AjaxResult insertMD8xMainLine301M7T(@RequestBody D8XMainLine301M7 d8XMainLine301M7) {
        AjaxResult ajaxResult = AjaxResult.success();
        int result = d8XService.insertMD8xMainLine301M7T(d8XMainLine301M7);
        ajaxResult.put("result", result);
        return ajaxResult;
    }

    @GetMapping("/getM7")
    @ApiOperation("M7")
    public AjaxResult insertMD8xMainLine301M7T(String Barcode, String StartTime, String EndTime) {
        AjaxResult ajaxResult = AjaxResult.success();
        List<D8XMainLine301M7Search> result = d8XService.searchMD8xMainLine301M7T(Barcode, StartTime, EndTime);
        ajaxResult.put("result", result);
        return ajaxResult;
    }

    @PostMapping("/M8")
    public AjaxResult insertMD8xMainLine301M8T(@RequestBody D8XMainLine301M8 d8XMainLine301M8) {
        AjaxResult ajaxResult = AjaxResult.success();
        int result = d8XService.insertMD8xMainLine301M8T(d8XMainLine301M8);
        ajaxResult.put("result", result);
        return ajaxResult;
    }

    @GetMapping("/getM8")
    @ApiOperation("M8")
    public AjaxResult insertMD8xMainLine301M8T(String Barcode, String StartTime, String EndTime) {
        AjaxResult ajaxResult = AjaxResult.success();
        List<D8XMainLine301M8Search> result = d8XService.searchMD8xMainLine301M8T(Barcode, StartTime, EndTime);
        ajaxResult.put("result", result);
        return ajaxResult;
    }

    @PostMapping("/M9")
    public AjaxResult insertMD8xMainLine301M9T(@RequestBody D8XMainLine301M9 d8XMainLine301M9) {
        AjaxResult ajaxResult = AjaxResult.success();
        int result = d8XService.insertMD8xMainLine301M9T(d8XMainLine301M9);
        ajaxResult.put("result", result);
        return ajaxResult;
    }

    @GetMapping("/getM9")
    @ApiOperation("M9")
    public AjaxResult insertMD8xMainLine301M9T(String Barcode, String StartTime, String EndTime) {
        AjaxResult ajaxResult = AjaxResult.success();
        List<D8XMainLine301M9Search> result = d8XService.searchMD8xMainLine301M9T(Barcode, StartTime, EndTime);
        ajaxResult.put("result", result);
        return ajaxResult;
    }

}
