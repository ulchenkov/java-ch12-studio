package org.launchcode.spaday.controllers;

import org.launchcode.spaday.data.UserData;
import org.launchcode.spaday.models.User;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("add")
    public String displayAddUserForm(Model model) {
        model.addAttribute(new User());
        return "user/add";
    }

    @PostMapping("add")
    public String processAddUserForm(
            Model model,
            @ModelAttribute @Valid User user,
            Errors errors,
            String passwordVerify) {

        if (errors.hasFieldErrors()) {
            return "user/add";
        }

        UserData.add(user);
        return "redirect:";
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
