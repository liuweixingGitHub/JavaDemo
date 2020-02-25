package com.ax.shop.controller;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;


//@Controller
@RestController
public class ChaController {
    @Autowired
    private Producer captchaProducer;

    @GetMapping("/kap")
    public void getKaptchaImage(HttpServletResponse response, HttpSession session) throws Exception {

        response.setDateHeader("Expires", 0);

        // Set standard HTTP/1.1 no-cache headers.
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        // Set IE extended HTTP/1.1 no-cache headers (use addHeader).
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        // Set standard HTTP/1.0 no-cache header.
        response.setHeader("Pragma", "no-cache");
        // return a jpeg
        response.setContentType("image/jpeg");
        // create the text for the image
        String capText = captchaProducer.createText();

        System.out.println("图形capText = " + capText);

        //request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);
        /**把文字放在session中，使用时候，再对应的接口取值*/
        //将验证码存到session
        session.setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);
        // create the image with the text
        BufferedImage bi = captchaProducer.createImage(capText);
        ServletOutputStream out = response.getOutputStream();
        // write the data out
        ImageIO.write(bi, "jpg", out);
        try {
            out.flush();
        } finally {
            out.close();
        }
    }

    @ApiOperation(value = "获取图形验证码")
    @GetMapping("/kapCode")
//    @ResponseBody
    public Object kapCode(HttpServletResponse response, HttpSession session) throws Exception {

        Object object = session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
        System.out.println("object = " + object);

        return object;

    }


}