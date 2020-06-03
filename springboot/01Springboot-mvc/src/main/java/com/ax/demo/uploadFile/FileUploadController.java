package com.ax.demo.uploadFile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class FileUploadController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileUploadController.class);

    @Autowired
    private FileUploadService fileUpAndDownService;


    @RequestMapping("/uploadFileOne.html")
    public String uploadOneFile() {

        return "uploadFileOne"; // 最终由ThymeleafView处理，转发 classpath:templates
    }

    @RequestMapping("/uploadFileMore.html")
    public String uploadMultiFile() {

        return "uploadFileMore"; // 最终由ThymeleafView处理，转发 classpath:templates
    }


    /**
     * value = "attachment"  ios 中  [formData appendPartWithFileData:imageData name:@"attachment"
     */
    @RequestMapping(value = "/uploadFileOne.do")
    @ResponseBody
    public Object setFileUpload(@RequestParam(value = "file", required = false) MultipartFile file,
                                HttpServletRequest request) {
        System.out.println("单个文件上传 file = " + file);

        return fileUpAndDownService.uploadFile(file, request);

    }

    @RequestMapping(value = "/uploadFileMore.do", method = RequestMethod.POST)
    @ResponseBody
    public Object uploadMultiFile(@RequestParam("files") List<MultipartFile> files,
                                  HttpServletRequest request) {
        System.out.println("多个文件上传 files = " + files);

        List<Map<String, Object>> list = new ArrayList<>();

        for (int i = 0; i < files.size(); i++) {

            MultipartFile file = files.get(i);
            if (file == null || file.isEmpty()) {
                break;
            }
            Map<String, Object> resultMap = fileUpAndDownService.uploadFile(file, request);
            list.add(resultMap);
        }

        return list;
    }


    @RequestMapping("/downFile.do")
    public ResponseEntity<byte[]> download(@RequestParam(value = "id", required = false) String id, HttpServletRequest request) throws IOException {

        System.out.println("id = " + id);

//        String pathname = "/Users/xing/Desktop/听力.docx";

        String pathname = "/Users/xing/Desktop/aa.zip";

        File file = new File(pathname);
        String filename = URLEncoder.encode(file.getName(), "UTF-8");

        byte[] body = null;
        InputStream is = new FileInputStream(file);
        body = new byte[is.available()];
        is.read(body);
        HttpHeaders headers = new HttpHeaders();
//        headers.add("Content-Disposition", "attchement;filename=" + URLEncoder.encode(file.getName(), "UTF-8"));
//        HttpStatus statusCode = HttpStatus.OK;
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", filename);
        ResponseEntity<byte[]> entity = new ResponseEntity(body, headers, HttpStatus.OK);
        return entity;


    }


}