package blog.web.controller;

import org.springframework.stereotype.Controller;
import blog.service.BlogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import org.springframework.http.HttpEntity;

@Controller
public class BlogController {

    @Autowired
    private BlogService blogService;

    @RequestMapping(path = { "/insertblog" })
    @ResponseBody
    public String insertBlog(@RequestParam String blogTitle, @RequestParam String blogContent,
            HttpServletResponse response) {
        try {
            blogService.insertBlog(blogTitle, blogContent);    
        } catch (Exception e) {
            response.setStatus(400);
            return e.getMessage();
        }
        
        return "success 200";
    }
}