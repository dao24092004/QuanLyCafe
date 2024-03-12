package com.cafe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("login")
public class ControllerLogin {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String login(@RequestParam(name = "username") String username,
                        @RequestParam(name = "passwords") String passwords, Model m, HttpSession session) {
    	String url = "http://localhost:8080/CafeSever/rest/login";
        // Kiểm tra username và passwords (đây là ví dụ đơn giản, bạn có thể sử dụng cách kiểm tra tài khoản thực tế của mình)
        if ("username".equals(username) && "passwords".equals(passwords)) {
            session.setAttribute("username", username);
            session.setAttribute("passwords", passwords);

            // Lấy thông tin nhân viên từ database hoặc service
            String tennv = "Tên Nhân Viên";  // Thay thế bằng thông tin nhân viên thực tế
            session.setAttribute("tennv", tennv);

            m.addAttribute("tennv", tennv);
            m.addAttribute("msg", "Đăng nhập thành công!!!");
            return "redirect:/Homepage";
        } else {
            m.addAttribute("msg", "Đăng nhập thất bại!!!");
            return "login";
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("username");
        session.removeAttribute("passwords");
        session.removeAttribute("tennv");
        return "redirect:/login";
    }
}
