package com.guigu.service.impl;


import com.guigu.bean.User;
import com.guigu.mapper.UserMapper;
import com.guigu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @ClassName com.guigu.service.impl.UserServiceImpl
 * @Description
 */
@Service
public class UserServiceImpl implements UserService {
 
	@Autowired
	private UserMapper userMapper;

	@Override
	public User getUserById(Integer id) {
		return userMapper.selectByPrimaryKey(id);

//		int t =id;
//		return new User();

	}

	@Override
	public List<User> getUserList() {
		return userMapper.getUserList();
//		return new ArrayList<>();
	}

	@Override
	public int add(User user) {
		return userMapper.insert(user);
//		return 0;
	}

	@Override
	public int update(Integer id, User user) {
		return userMapper.updateByPrimaryKey(user);
//		return 0;
	}

	@Override
	public int delete(Integer id) {
		return userMapper.deleteByPrimaryKey(id);
//		return 0;
	}
}
