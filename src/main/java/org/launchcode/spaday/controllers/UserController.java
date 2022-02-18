package org.launchcode.spaday.controllers;

import org.launchcode.spaday.data.UserData;
import org.launchcode.spaday.models.User;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("add")
    public String displayAddUserForm() {
        return "user/add";
    }

    @PostMapping("add")
    public String processAddUserForm(Model model, @ModelAttribute User user, String passwordVerify) {
        if (user.getPassword().equals(passwordVerify)) {
            UserData.add(user);
            return "redirect:";
        }
        model.addAttribute("error", "Passwords should match!");
        model.addAttribute("username", user.getUsername());
        model.addAttribute("email", user.getEmail());
        return "user/add";
    }

    @GetMapping
    public String displayIndex(Model model) {
        model.addAttribute("users", UserData.getAll());
        return "user/index";
    }

    @GetMapping("info/{id}")
    public String displayInfo(Model model, @PathVariable Integer id) {
        model.addAttribute("user", UserData.getById(id));
        return "user/info";
    }
}
