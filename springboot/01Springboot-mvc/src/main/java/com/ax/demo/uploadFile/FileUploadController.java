package com.ax.demo.uploadFile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class FileUploadController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileUploadController.class);


    @Autowired
    private FileUploadService fileUpAndDownService;


    @RequestMapping("/uploadfile")
    public String uploadOneFile() {

        return "uploadfile"; // 最终由ThymeleafView处理，转发 classpath:templates
    }

    @RequestMapping("/uploadfiles")
    public String uploadMultiFile() {

        return "uploadfiles"; // 最终由ThymeleafView处理，转发 classpath:templates
    }


    @RequestMapping(value = "/uploadsimplefile")
    @ResponseBody
    public Object setFileUpload(@RequestParam(value = "attachment", required = false) MultipartFile file) {
        System.out.println("file = " + file);

        return fileUpAndDownService.uploadFlie(file);

    }

    @RequestMapping(value = "/uploadmultifile")
    @ResponseBody
    public Object uploadMultiFile(@RequestParam("attachment") List<MultipartFile> multipartFiles,
                                  HttpServletRequest request) {

        List<Map<String, Object>> list = new ArrayList<>();

        for (int i = 0; i < multipartFiles.size(); i++) {

            MultipartFile file = multipartFiles.get(i);
            if (file.isEmpty()){
                break;
            }
            Map<String, Object> resultMap = fileUpAndDownService.uploadFlie(file);
            list.add(resultMap);
        }

        return list;
    }

}