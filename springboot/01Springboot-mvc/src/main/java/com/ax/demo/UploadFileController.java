package com.ax.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
public class UploadFileController {

    @RequestMapping("/uploadfile")

    public String uploadOneFile() {

        return "uploadfile"; // 最终由ThymeleafView处理，转发 classpath:templates
    }

    @RequestMapping("/uploadfiles")
    public String uploadMultiFile() {

        return "uploadfiles"; // 最终由ThymeleafView处理，转发 classpath:templates
    }

    /**
     * 上传单个文件
     *
     * @param multipartFile
     * @param request
     * @return
     */

    @RequestMapping(value = "/uploadsimplefile", method = RequestMethod.POST)

    @ResponseBody

    public String uploadSimpleFile(@RequestParam("attachment") MultipartFile multipartFile,
                                   HttpServletRequest request) {

        try {

            String fileDir = request.getSession().getServletContext().getRealPath("/upload/");

            System.out.println("fileDir = " + fileDir);

            File dir = new File(fileDir);

            if (!dir.exists()) {

                dir.mkdirs();

            }

            String fileName = multipartFile.getOriginalFilename();

            File upload_file = new File(fileDir + fileName);

            multipartFile.transferTo(upload_file);

        } catch (Exception e) {

            e.printStackTrace();

            System.out.println("上传失败 e = " + e);
            return "上传失败";

        }
        System.out.println("上传成功");
        return "上传成功";

    }

    /**
     * 上传多个文件
     *
     * @param multipartFiles
     * @param request
     * @return
     */

    @RequestMapping(value = "/uploadmultifile", method = RequestMethod.POST)

    @ResponseBody

    public String uploadMultiFile(@RequestParam("attachment") MultipartFile[] multipartFiles,
                                  HttpServletRequest request) {

        try {

            String fileDir = request.getSession().getServletContext().getRealPath("/upload/");

            System.out.println("fileDir = " + fileDir);

            File dir = new File(fileDir);

            if (!dir.exists()) {

                dir.mkdirs();

            }

            for (int i = 0; i < multipartFiles.length; i++) {

                if (multipartFiles[i] != null) {

                    uploadFile(fileDir, multipartFiles[i]);

                }

            }

        } catch (Exception e) {

            e.printStackTrace();

            return "上传失败";

        }
        System.out.println("上传成功");
        return "上传成功";

    }

    /**
     * @param uploadDir
     * @param file
     * @throws IOException
     */

    public void uploadFile(String uploadDir, MultipartFile file) throws IOException {

        String file_name = file.getOriginalFilename();

        File upload_file = new File(uploadDir + file_name);

        file.transferTo(upload_file);

    }

}


