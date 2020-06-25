package com.example.demo.controller;

import com.example.demo.dao.AppUserRepository;
import com.example.demo.entity.AppUser;
import com.example.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * Created by A.A.MAMUN on 6/25/2020.
 */
@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = {"/","/login"},method = RequestMethod.GET)
    public String loginPage(AppUser appUser){
        return "login";
    }

    @PostMapping("/login-process")
    public String loginProcess(@Valid AppUser appUser, Errors errors, HttpServletRequest request, Model model){
        if(errors.hasErrors()){
            return "login";
        }
        if(loginService.isValidUser(appUser)){
            request.getSession().setAttribute("APP_USER", appUser.getEmail());
            return "redirect:/success";
        }else{
            return "redirect:/failed";
        }
    }

    @GetMapping("/success")
    public String loginSuccess(HttpServletRequest request, Model model){
        String email = (String) request.getSession().getAttribute("APP_USER");
        if(email==null){
            return "redirect:/login";
        }
        model.addAttribute("message","You have successfully logged to this demo project.");
        return "success";
    }

    @GetMapping("/failed")
    public String loginFailed(Model model){
        model.addAttribute("message","Login Failed! Please check your email address and password.");
        return "error";
    }
}
