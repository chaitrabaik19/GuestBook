package com.guestbook.poc.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.guestbook.poc.dao.UserDao;
import com.guestbook.poc.model.Message;
import com.guestbook.poc.model.User;
import com.guestbook.poc.service.UserService;

public class UserServiceImpl implements UserService{
	
	@Autowired
	  public UserDao userDao;
	
	@Override
	public void register(Message message) {
		    userDao.register(message);
	}
	@Override
	public User getUserdetail(User user) {
		User userdetail = new User();
		 userdetail = userDao.getUserDetail(user);
		return userdetail;
	}
	@Override
	public List<Message> getMessageDetail() {
		List<Message> msglist = new ArrayList<Message>();
		msglist = userDao.getMessageDetail();
		return msglist;
	}
	@Override
	public void updateStatus(int message_id,String status) {
		userDao.updateMessageStatus(message_id,status);
	}

	
}
