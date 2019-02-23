package template.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import template.meta.User;

@Mapper
public interface UserDao{

	@Select("Select * from User")
	public List<User> getUserList();

}