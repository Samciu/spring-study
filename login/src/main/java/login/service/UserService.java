package login.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import login.dao.UserDao;
import login.meta.User;

@Service
public class UserService {

    @Resource
    private UserDao dao;

    public List<User> getUserList() {
        return dao.getUserList();
    }

    public Map<String, Object> getUserListMap() {
        Map<String, Object> root = new HashMap<String, Object>();
        root.put("userList", this.getUserList());
        return root;
    }

    public User login(String userName, String userPassword) throws Exception{
        List<User> list = dao.login(userName, userPassword);
        return list.get(0);
    }
}
