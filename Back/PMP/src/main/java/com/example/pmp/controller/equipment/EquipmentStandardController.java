package com.example.pmp.controller.equipment;

import com.example.pmp.pojo.equipment.EquipmentStandard;
import com.example.pmp.service.equipment.EquipmentStandardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Date;
import java.util.List;

/**
 * @author Dandan
 * @date 2023/5/9 20:14
 **/
@RestController
@RequestMapping("/standardfile")
@Api(tags = "设备操作规相关文件范接口")
public class EquipmentStandardController {
    @Autowired
    private EquipmentStandardService equipmentStandardService;

    @Value("${file.save-path-standard-file}")
    private String savePath;

    @PostMapping("/upload")
    @ApiOperation(value = "提交设备操作规范相关文件，存储至服务器")
    public ResponseEntity<Object> uploadStandardFile(@RequestParam("file") MultipartFile[] files
            , @RequestParam("product") String product
            , @RequestParam(value = "remark", required = false) String remark
            , @RequestParam("standard_file_flag") String standard_file_flag) throws IOException {

        // uploadFlag:记录是否上传成功
        Boolean uploadFlag = false;

        // 文件一个一个上传，上传log一条一条插入
        for (MultipartFile file : files) {
            // 获取上传文件的名称、类型、大小等信息
            String fileName = file.getOriginalFilename();
            String fileType = fileName.substring(fileName.lastIndexOf(".") + 1);
            Long fileSize = file.getSize();
            String filePath = savePath;
            File newfile = new File(filePath, fileName);
            if (!newfile.getParentFile().exists()) {
                // 文件路径不存在则新建
                newfile.getParentFile().mkdirs();
            }

            EquipmentStandard equipmentStandard = new EquipmentStandard();
            equipmentStandard.setProduct(product);
            equipmentStandard.setRemark(remark);
            equipmentStandard.setStandard_file_name(fileName);
            equipmentStandard.setStandard_file_type(fileType);
            equipmentStandard.setStandard_file_path(filePath);
            equipmentStandard.setStandard_file_size(fileSize);
            equipmentStandard.setStandard_file_flag(standard_file_flag);
            equipmentStandard.setStandard_file_upload_time(new Date());

            if (!searchEquipmentStandardFileByFileName(fileName)) {
                // 如果不存在同名文件，将文件信息插入到数据库
                equipmentStandardService.insertEquipmentStandardFile(equipmentStandard);
            } else {
                // 如果存在更新数据库表中的log信息
                equipmentStandardService.updateEquipmentStandardFileByFileName(equipmentStandard);
            }

            try {
                // 将文件保存到服务器中
                file.transferTo(newfile);
                uploadFlag = true;
                // TODO: 将文件路径、文件名、文件类型、文件大小、上传时间等信息保存到数据库中
            } catch (IOException e) {
                e.printStackTrace();
                uploadFlag = false;
            }

        }

        if (uploadFlag) {
            return new ResponseEntity<>("上传成功", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("上传失败", HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/search")
    @CrossOrigin
    @ApiOperation(value = "查询文件，返回文件列表")
    public List<EquipmentStandard> searchEquipmentStandardFile(
            @RequestParam(value = "product", required = false) String product
            , @RequestParam(value = "remark", required = false) String remark
            , @RequestParam(value = "standard_file_flag", required = false) String standard_file_flag
            , @RequestParam(value = "standard_file_name", required = false) String standard_file_name) {

        return equipmentStandardService.searchEquipmentStandardFile(product, remark, standard_file_flag, standard_file_name);

    }

    @DeleteMapping("/delete/{id}")
    @CrossOrigin
    @ApiOperation(value = "根据设备操作规范id，删除文件")
    public ResponseEntity<Object> deleteStandardFile(@PathVariable Long id) {
        // 文件是否删除成功flag
        Boolean deleteFileResult = false;

        // 通过id查询是否存在文件，存在删除
        EquipmentStandard equipmentStandard = equipmentStandardService.searchEquipmentStandardFileById(id);

        if (equipmentStandard != null) {

            // 文件存在，删除数据库表中log
            equipmentStandardService.deleteEquipmentStandardFileById(id);

            // 获取文件在服务器中的路径并删除
            String fileName = equipmentStandard.getStandard_file_name();
            // 如果该存储路径不存在则新建存储路径
            File file = new File(savePath, fileName);

            if (!file.exists() || !file.isFile()) {
                // 文件不存在或不是文件
                deleteFileResult = false;
            }

            Boolean deleteResult = file.delete();
            if (!deleteResult) {
                deleteFileResult = false;
            } else {
                deleteFileResult = true;
            }

        }

        if (deleteFileResult) {
            return new ResponseEntity<>("删除成功", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("删除失败", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/download/{id}")
    @CrossOrigin
    @ApiOperation(value = "返回文件地址供下载")
    public ResponseEntity<ByteArrayResource> downloadStandardFile(@PathVariable Long id, HttpServletResponse response) throws IOException {
        EquipmentStandard equipmentStandard = equipmentStandardService.searchEquipmentStandardFileById(id);
        File file = new File(equipmentStandard.getStandard_file_path() + "/" + equipmentStandard.getStandard_file_name());
        ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(file.toPath()));

        // 设置各个类型文件的硬编码
        String MIME_Hard_Coding = "";
        String file_type = equipmentStandard.getStandard_file_type();
        MIME_Hard_Coding = getStringMIME(file_type);

        // 设置 HttpServletResponse 的响应头信息
        HttpHeaders headers = new HttpHeaders();
        // Content-Disposition : 用于设置响应的文件名和下载方式
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + equipmentStandard.getStandard_file_name() + "\"");
        // Content-Type：用于设置响应的数据类型
        headers.add(HttpHeaders.CONTENT_TYPE, MIME_Hard_Coding);
        // Content-Length：用于设置响应的数据长度
        headers.add(HttpHeaders.CONTENT_LENGTH, String.valueOf(equipmentStandard.getStandard_file_size()));

        return ResponseEntity.ok()
                // 将设置的响应头信息设置到响应中
                .headers(headers)
                .body(resource);
    }

    @GetMapping("/preview/{id}")
    @CrossOrigin
    @ApiOperation(value = "返回文件地址供预览")
    public void previewStandardFile(@PathVariable Long id, HttpServletResponse response) throws Exception {
        EquipmentStandard equipmentStandard = equipmentStandardService.searchEquipmentStandardFileById(id);

        if (equipmentStandard != null) {
            String filePath = equipmentStandard.getStandard_file_path();
            String fileName = equipmentStandard.getStandard_file_name();

            // 读取指定路径的文件数据
            File file = new File(filePath, fileName);
            // 读取文件字节
            FileInputStream inputStream = new FileInputStream(file);

            // 开辟内存空间，存储文件数据
            byte[] data = new byte[(int) file.length()];
            // 将文件数据读取到字节数组data中(内存中)
            inputStream.read(data);
            inputStream.close();

            String fileType = equipmentStandard.getStandard_file_type();
            String contentType = "";
            contentType = getStringMIME(fileType);

            response.setContentType(contentType);
            response.setHeader("Content-Disposition", "inline; filename=\"" + fileName + "\"");

            // 将数据写到响应流中，返回给前端
            ServletOutputStream outputStream = response.getOutputStream();
            outputStream.write(data);
            outputStream.flush();
            outputStream.close();
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    private String getStringMIME(String fileType) {
        String contentType = "";
        if (fileType.equals("xlsx")) {
            contentType = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
        } else if (fileType.equals("pptx")) {
            contentType = "application/vnd.openxmlformats-officedocument.presentationml.presentation";
        } else if (fileType.equals("docx")) {
            contentType = "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
        } else if (fileType.equals("txt")) {
            contentType = "text/plain";
        } else if (fileType.equals("pdf")) {
            contentType = "application/pdf";
        } else if (fileType.equals("jpg") || fileType.equals("jpeg")) {
            contentType = "image/jpeg";
        } else if (fileType.equals("png")) {
            contentType = "image/png";
        } else if (fileType.equals("gif")) {
            contentType = "image/gif";
        }
        return contentType;
    }

    public boolean searchEquipmentStandardFileByFileName(@RequestParam(value = "standard_file_name") String standard_file_name) {
        EquipmentStandard equipmentStandard;
        equipmentStandard = equipmentStandardService.searchEquipmentStandardFileByFileName(standard_file_name);
        if (equipmentStandard != null) {
            return true;
        } else {
            return false;
        }
    }

}
