package org.springBootA.springBoot.controller;

import org.springBootA.springBoot.model.User;
import org.springBootA.springBoot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String greeting(Model model, Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        model.addAttribute("mainUser", user);
        model.addAttribute("isRole", user.isAdmin());
        return "mainPage";
    }

}
