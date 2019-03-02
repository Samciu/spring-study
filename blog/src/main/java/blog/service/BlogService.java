package blog.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import blog.dao.BlogDao;
import blog.meta.Blog;

@Service
public class BlogService {

    @Resource
    private BlogDao dao;

    public List<Blog> getBlogList() {
        return dao.getBlogList();
    }

    public void insertBlog(String blogTitle, String blogContent) throws Exception {
        if (blogTitle.length() <= 20 && blogContent.length() <= 100) {
            dao.insertBlog(blogTitle, blogContent);
        } else {
            throw new Exception("限制blogTitle长度20个英文字符，blogContent长度为100个英文字符");
        }
    }
}
