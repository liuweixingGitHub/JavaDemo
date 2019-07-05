package com.ax.demo.uploadFile;

public interface IStatusMessage {

    String getCode();
    String getMessage();

    enum SystemStatus implements IStatusMessage {


        SUCCESS("1000", "操作成功"), //请求成功
        ERROR("1001", "网络异常，请稍后重试~"),

        PARAM_ERROR("1002", "网络异常，请稍后重试~"),

        FILE_UPLOAD_ERROR("1002", "网络异常，请稍后重试~"),



        FILE_UPLOAD_NULL("1002","上传图片为空文件"), ;      //请求失败



        private String code;
        private String message;

        SystemStatus(String code, String message) {
            this.code = code;
            this.message = message;
        }
        @Override
        public String getCode() {
            return this.code;
        }
        @Override
        public String getMessage() {
            return this.message;
        }
    }
}