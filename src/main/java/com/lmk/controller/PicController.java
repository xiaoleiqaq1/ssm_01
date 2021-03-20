package com.lmk.controller;

import com.lmk.constants.ImgCodeUtil;
import com.lmk.constants.SysConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @auth: lmk
 * @Description:
 * @date: 2021/3/11
 */
@Component
@RequestMapping("/pic")
public class PicController {

    @RequestMapping("/getCode")
    public void getCode(HttpServletRequest request, HttpServletResponse response) {
        ImgCodeUtil imgCodeUtil = new ImgCodeUtil();
        BufferedImage image = imgCodeUtil.getImage();
        String code = imgCodeUtil.getText();

//        System.out.println(code);
        request.getSession().setAttribute(SysConstants.GET_SESSION, code);

        ServletOutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
            ImageIO.write(image, "jpg", outputStream);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
