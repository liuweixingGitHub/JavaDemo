package com.ax.demo.uploadFile;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface FileUploadService {

    Map<String, Object> uploadFlie(MultipartFile file, HttpServletRequest request);

}