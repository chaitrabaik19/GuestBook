package com.guestbook.poc.service;

import java.util.List;

import com.guestbook.poc.model.Message;
import com.guestbook.poc.model.User;

public interface UserService {

	void register(Message message);

	User getUserdetail(User user);

	List<Message> getMessageDetail();

	void updateStatus(int message_id, String status);

}
