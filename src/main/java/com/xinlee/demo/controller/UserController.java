package com.xinlee.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by xin.lee on 2017/2/20.
 * 用户控制器
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/gotoLogin")
    public String gotoLogin() {
        return "login";
    }

    @RequestMapping("/gotoUserSpace")
    public String gotoUserSpace() {
        return "userspace";
    }

    @RequestMapping("/login")
    public String login(HttpSession session, String username, String password) {
        // 调用service进行用户身份验证
        // ......

        // 在session中保存用户身份信息
        session.setAttribute("username", username);
        return "userspace";
    }
}
