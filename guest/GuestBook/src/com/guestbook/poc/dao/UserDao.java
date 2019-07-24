package com.guestbook.poc.dao;

import java.util.List;

import com.guestbook.poc.model.Message;
import com.guestbook.poc.model.User;

public interface UserDao {

	void register(Message message);

	User getUserDetail(User user);

	List<Message> getMessageDetail();

	void updateMessageStatus(int message_id,String status);

}
