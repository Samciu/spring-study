package blog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import blog.meta.Blog;

@Mapper
public interface BlogDao{

	@Select("Select * from Blog")
	public List<Blog> getBlogList();

	@Insert("insert into Blog (blogTitle, blogContent) values (#{param1}, #{param2})")
	public void insertBlog(String blogTitle, String blogContent);
	
}