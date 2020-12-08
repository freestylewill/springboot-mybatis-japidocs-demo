package com.guigu.service;

import com.guigu.bean.User;
import java.util.List;
 
/**
 * @ClassName com.guigu.service.UserService
 * @Description
 */
public interface UserService {
 
	User getUserById(Integer id);
 
	public List<User> getUserList();
 
	public int add(User user);
 
	public int update(Integer id, User user);
 
	public int delete(Integer id);
}
