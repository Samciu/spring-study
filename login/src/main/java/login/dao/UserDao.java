package login.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import login.meta.User;

@Mapper
public interface UserDao{

	@Select("Select * from User")
	public List<User> getUserList();

	@Select("Select * from User where userName = #{param1} and userPassword = #{param2}")
	public List<User> login(String userName, String userPassword);
}