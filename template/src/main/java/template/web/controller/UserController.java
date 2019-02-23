package template.web.controller;

import org.springframework.web.bind.annotation.RestController;

import template.service.UserService;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(path = { "/userlist"})
    public ModelAndView userListHtml(ModelAndView modelAndView) {
        modelAndView.setViewName("user");

        modelAndView.addObject("userList", this.userService.getUserList());
        return modelAndView;
    }

    @RequestMapping(path = { "/userlist", "/userlist.json" }, produces = "application/json")
    public Map<String, Object> userList() {
        return this.userService.getUserListMap();
    }

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

}