package template.web.controller;

import org.springframework.stereotype.Controller;
import template.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(path = { "/userlist"})
    public String userList(Model model) {
        model.addAttribute("userList", this.userService.getUserList());

        return "user";
    }
}