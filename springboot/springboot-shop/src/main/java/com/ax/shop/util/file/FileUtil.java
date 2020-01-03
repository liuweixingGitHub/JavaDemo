package com.ax.shop.util.file;

import java.io.File;
import java.io.FileOutputStream;
 
/**
 * @Author: Manitozhang
 * @Data: 2019/1/9 16:51
 * @Email: manitozhang@foxmail.com
 *
 * 文件工具类
 */
public class FileUtil {
 
    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath+fileName);
        out.write(file);
        out.flush();
        out.close();
    }
 
}