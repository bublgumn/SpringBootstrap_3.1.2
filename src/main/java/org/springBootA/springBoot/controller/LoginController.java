package org.springBootA.springBoot.controller;

import org.springBootA.springBoot.model.Role;
import org.springBootA.springBoot.model.User;
import org.springBootA.springBoot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/newLogin/user")
    public String RedirectNewUser(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        for (Role role : user.getRole()
        ) {
            if (role.getName().equals("ROLE_admin")) {
                return "redirect:/admin";
            }
        }
        return "redirect:/user";
    }

    @GetMapping("/testMethodAdmin")
    public String testMethodAdmin(Model model) {
        model.addAttribute("users", userService.findAll());
        return "adminPage";
    }

}
