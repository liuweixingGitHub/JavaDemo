package com.ax.demo.uploadFile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class FileUploadServiceImpl implements FileUploadService {

    @Autowired
    private MessageProperties config; //用来获取file-message.properties配置文件中的信息


    @Override
    public Map<String, Object> uploadFile(MultipartFile multipartFile, HttpServletRequest request) {

        Map<String, Object> returnMap = new HashMap<>();


        if (null == multipartFile || multipartFile.isEmpty()) {

            returnMap.put("code", 404);
            returnMap.put("msg", "文件为空");

        } else {

            FileUploadMessage fileUploadMessage = uploadFlieDto(multipartFile,request);

            if (fileUploadMessage.getResult() == true) {
                returnMap.put("code", 200);
                returnMap.put("data", fileUploadMessage);
            } else {
                returnMap.put("code", 500);
                returnMap.put("msg", "上传失败");
            }
        }
        System.out.println("returnMap = " + returnMap);
        return returnMap;
    }

    public FileUploadMessage uploadFlieDto(MultipartFile file, HttpServletRequest request) {

        FileUploadMessage fileUploadMessage = new FileUploadMessage();

        try {

            String[] IMAGE_TYPE = config.getImageType().split(",");

            boolean flag = false;
            for (String type : IMAGE_TYPE) {
                if (StringUtils.endsWithIgnoreCase(file.getOriginalFilename(), type)) {
                    flag = true;
                    break;
                }
            }
            String path = null;

            if (flag) {

                // 原名称
                String originalFilename = file.getOriginalFilename();
                // 获得文件类型 fileType = image/jpeg 格式
                String contentType = file.getContentType();

                // 获得文件后缀名称 image/jpeg 截取
//                String prefix = fileType.substring(fileType.indexOf("/") + 1);
                String prefix = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
                // 新名称
                String uuid = UUID.randomUUID().toString().replaceAll("-", "");
                String newFileName = uuid + "." + prefix;

                /*文件大小*/
                long size = file.getSize();
                /*上传指定路径,*/
                String upPath = config.getUpPath();
                if (null == upPath) {
                    /*获取 tomcat 路径*/
                    upPath = request.getSession().getServletContext().getRealPath("/upload/");
                }

                // 进行压缩(大于4M)
//                if (file.getSize() > config.getFileSize()) {
//
//                    String  mkdir = fileSavePath + "/" + basedir + "/";
//                    // 如果目录不存在则创建目录
//                    File mkdirsFile = new File(mkdir);
//                    if (!mkdirsFile.exists() ) {
//                        mkdirsFile.mkdirs();
//                    }
//
//                    // 重新生成
//                    String newUUID = UUID.randomUUID().toString().replaceAll("-", "");
//
//                    newFileName = newUUID + "." + imageName;
//                    path = fileSavePath + "/" + basedir + "/" + newUUID + "." + imageName;
//                    File oldFile = new File(path);
//                    if (!oldFile.exists()) {
//                        file.transferTo(oldFile);
//                        // 压缩图片
//                        Thumbnails.of(oldFile).scale(config.getScaleRatio()).toFile(oldFile);
//                    }
//
//                    // 显示路径
//                    resMap.put("path", "/" + basedir + "/" + newUUID + "." + imageName);
//                } else {


                // 年月日文件夹 用时间做文件名,按时间分类
                String basedir = new SimpleDateFormat("yyyyMMdd").format(new Date());
                String mkdir = upPath + "/" + basedir + "/";

                // 如果目录不存在则创建目录
                File mkdirsFile = new File(mkdir);
                if (!mkdirsFile.exists()) {
                    mkdirsFile.mkdirs();
                }

                path = mkdir + newFileName;

                // 如果文件不存在,写入文件
                File uploadFile = new File(path);
                if (!uploadFile.exists() && !uploadFile.isDirectory()) {
                    file.transferTo(uploadFile);
                }


                // 显示路径
//                resMap.put("path", "/" + basedir + "/" + newFileName);
                fileUploadMessage.setResult(true);
                fileUploadMessage.setOriginalFilename(originalFilename);
                fileUploadMessage.setContentType(contentType);
                fileUploadMessage.setNewFileName(newFileName);
                fileUploadMessage.setPrefix(prefix);
                fileUploadMessage.setSize(size);
                fileUploadMessage.setPath(path);
//                }


//                resMap.put("originalFilename", originalFilename);
//                resMap.put("newFileName", newFileName);
//                resMap.put("fileSize", file.getSize());
            } else {
//                resMap.put("result", "图片格式不正确,支持png|jpg|jpeg");
                fileUploadMessage.setResult(true);
                return fileUploadMessage;
            }

        } catch (Exception e) {
            e.printStackTrace();
            fileUploadMessage.setResult(false);
        }
        return fileUploadMessage;
    }


}