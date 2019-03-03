package login.web.controller;

import org.springframework.stereotype.Controller;
import login.service.UserService;
import login.meta.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(path = { "/login" })
    public String userList(@RequestParam String userName, @RequestParam String userPassword, Model model) {
        try {
            User user = this.userService.login(userName, userPassword);
            model.addAttribute("user", user);

            return "user";
        } catch (Exception e) {
            return "error";
        }

    }
}