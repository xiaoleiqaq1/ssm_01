package com.lmk.controller;

import com.lmk.entity.User;
import com.lmk.qo.UserQo;
import com.lmk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @auth: lmk
 * @Description:
 * @date: 2021/3/10
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    //查询
    @RequestMapping("/selectAll")
    public ModelAndView selectAll(ModelAndView mav,UserQo userQo){
        int count = userService.getCount(userQo);
        userQo.setCount(count);

        int page=userQo.getPage();

        //下一页
        if(page>=userQo.getPageTotal()){
            page=userQo.getPageTotal();
        }
        //上一页
        if (page<1) {
            page=1;
        }

        userQo.setPage(page);

        List<User> users = userService.selectAll(userQo);
        //把createTime的".0"替换成"";
        for(User user:users){
            String createTime = user.getCreateTime();
            String replace = createTime.replace(".0", "");
            user.setCreateTime(replace);
        }
        mav.addObject("userQo",userQo);
        mav.addObject("user",users);
        mav.setViewName("list");
        return mav;
    }

    //删除
    @RequestMapping("/delete")
    public ModelAndView delete(Integer id){
        userService.delete(id);
        ModelAndView mav=new ModelAndView();
//        mav.setViewName("forward:/user/selectAll");
        mav.setViewName("redirect:/user/selectAll");
        return mav;
    }

    //添加
    @RequestMapping("/add")
    public ModelAndView add(User user){
        userService.add(user);
        ModelAndView mav=new ModelAndView();
//        mav.setViewName("forward:/user/selectAll");
        mav.setViewName("redirect:/user/selectAll");
        return mav;
    }

    //修改
    @RequestMapping("/toUpdate")
    public ModelAndView toUpdate(Integer id){
        User user = userService.toUpdate(id);
        ModelAndView mav=new ModelAndView();
        mav.addObject("users",user);
        mav.setViewName("update");
        return mav;
    }

    //修改
    @RequestMapping("/update")
    public ModelAndView update(User user){

        userService.update(user);
        ModelAndView mav=new ModelAndView();
        mav.setViewName("redirect:/user/selectAll");
        return mav;
    }




}
