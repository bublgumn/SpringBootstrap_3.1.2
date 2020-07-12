package org.springBootA.springBoot.controller;

import org.springBootA.springBoot.model.Role;
import org.springBootA.springBoot.model.User;
import org.springBootA.springBoot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String mainPageAdmin(ModelMap model, Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        model.addAttribute("mainUser", user);
        model.addAttribute("isRole", user.isAdmin());
        model.addAttribute("users", userService.findAll());
        return "mainPage";
    }

    @PostMapping("/addNewUser")
    public String createUser(@ModelAttribute User user,
                             @RequestParam(required = false, name = "role") Integer role) {
        Role roleUser = userService.findRoleByName("ROLE_user");
        user.setRole(new ArrayList<>());
        if (role == 1) {
            Role roleAdmin = userService.findRoleByName("ROLE_admin");
            user.getRole().add(roleAdmin);
        }
        user.getRole().add(roleUser);
        userService.saveUser(user);
        return "redirect:/admin";
    }

    @PostMapping("/deleteUser")
    public String deleteUser(@RequestParam Long id) {
        userService.deleteById(id);
        return "redirect:/admin";
    }

    @PostMapping("/editUser")
    public String editCar(@ModelAttribute User user,
                          @RequestParam(required = false, name = "role") Integer role,
                          @RequestParam Long id) {
        if (user.getPassword().trim().isEmpty()) {
            user.setPassword("111");
        }
        user.setId(id);
        if (role != null) {
            Role roleUser = userService.findRoleByName("ROLE_user");
            Role roleAdmin;
            user.setRole(new ArrayList<>());
            if (role == 1) {
                roleAdmin = userService.findRoleByName("ROLE_admin");
                user.getRole().add(roleAdmin);
            }
            user.getRole().add(roleUser);

        } else {
            user.setRole(userService.findById(id).getRole());
        }
        userService.updateUser(user);
        return "redirect:/admin";
    }
}