package com.lmk.controller;

import com.lmk.constants.ImgCodeUtil;
import com.lmk.constants.SysConstants;
import com.lmk.entity.User;
import com.lmk.qo.UserNo;
import com.lmk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

/**
 * @auth: lmk
 * @Description:
 * @date: 2021/3/11
 */
@Component
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;


    @RequestMapping("/login")
    public ModelAndView login(ModelAndView mav, UserNo userNo, HttpServletRequest request) {
        mav.setViewName("redirect:/user/selectAll");

        //验证验证码：
        String code = (String) request.getSession().getAttribute(SysConstants.GET_SESSION);
//        优化：
        if (!(code!=null && code.equalsIgnoreCase(userNo.getCode()))){
            mav.setViewName("redirect:/index.jsp");
        }
//        if (code == null) {
//            mav.setViewName("redirect:/index.jsp");
//        } else {
//            if (!code.equalsIgnoreCase(userNo.getCode())) {
//                mav.setViewName("redirect:/index.jsp");
//            }
//        }
        List<User> user = userService.selectNameAndPassword(userNo);
        if (user==null || user.size()!=1){
            mav.setViewName("redirect:/index.jsp");
        }

        //将对象取出来
        User user1 = user.get(0);
        request.getSession().setAttribute(SysConstants.GETGETSESSION,user1);
        //设置30分钟取消session
        request.getSession().setMaxInactiveInterval(30*60);

        return mav;
    }
}
