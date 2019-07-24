package com.guestbook.poc.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.guestbook.poc.dao.UserDao;
import com.guestbook.poc.model.Message;
import com.guestbook.poc.model.User;

public class UserDaoImpl implements UserDao{
	
	/* private JdbcTemplate jdbcTemplate;
	 
	    public UserDaoImpl(DataSource dataSource) {
	        jdbcTemplate = new JdbcTemplate(dataSource);
	    }*/
	
@Autowired
 DataSource datasource;

 @Autowired
JdbcTemplate jdbcTemplate;
	
	@Override
	public void register(Message message) {
    System.out.println("message from user is " + message.getUser_message());
		
    /*MESSAGE_ID
    USER_MESSAGE
    USER_ID*/
    
    Message msg =getMessageId();
    
    
		String sql = "insert into Message (MESSAGE_ID, USER_MESSAGE, USER_ID,message_status,userImage) VALUES (?,?,?,?,?)";
		
		jdbcTemplate.update(sql, new Object[] {msg.getMessage_id(), message.getUser_message(),"001" ,"review",message.getUserImage()});
			    }

	private Message getMessageId() {
		String seqSql = "select message_seq.NEXTVAL as message_id from dual ";
		 List<Message> msgList =jdbcTemplate.query(seqSql, new MessageIdMapper());
		  
		  return msgList.size()>0?msgList.get(0):null;
	}
	
	 class MessageIdMapper implements RowMapper<Message> {
		 
		  public Message mapRow(ResultSet rs, int arg1) throws SQLException {
			  System.out.println("isnide maprow");
			  Message msg = new Message();
			  if(rs!=null){
				  msg.setMessage_id(rs.getInt("message_id"));
			  }
		    return msg;
		  }
	 }
	
	

	@Override
	public User getUserDetail(User user) {
		List<User> userDeatilsList = new ArrayList<>();
		System.out.println("inside dao impl layer" +user.getPassword());
		//String sqls = "select * from users where user_name= + user.getUser_name()";+ "' and password='" + user.getPassword() +
		
		String sql = "select * from users where user_name='" + user.getUser_name()+ "'";		
		userDeatilsList =  jdbcTemplate.query(sql, new UserMapper());
		
		
		 return userDeatilsList.size() > 0 ? userDeatilsList.get(0) : null;
	}
	
	 class UserMapper implements RowMapper<User> {
		 
		  public User mapRow(ResultSet rs, int arg1) throws SQLException {
			  System.out.println("isnide maprow");
			  User user = new User();
			  if(rs!=null){
			    user.setUser_id(rs.getInt("user_id"));
			    user.setUser_name(rs.getString("user_name"));
			    user.setPassword(rs.getString("password"));
			    user.setUser_role(rs.getString("user_role"));
			  }
		    return user;
		  }
	 }

	@Override
	public List<Message> getMessageDetail() {
		List<Message> messageList = new ArrayList<>();
		//String sqls = "select * from users where user_name= + user.getUser_name()";+ "' and password='" + user.getPassword() +
		
		String sql = "select * from Message ";		
		messageList =  jdbcTemplate.query(sql, new MessageMapper());
		
		
		
		
		
		
		
		 return messageList;
	}
	 
	
	 class MessageMapper implements RowMapper<Message> {
	
	 public Message mapRow(ResultSet rs, int rowNum) throws SQLException  {
		 Message msg = new Message();
         msg.setMessage_id(rs.getInt("MESSAGE_ID"));
         msg.setUser_message(rs.getString("USER_MESSAGE"));
         msg.setUser_id(rs.getInt("user_id"));
         msg.setMessage_status(rs.getString("message_status"));
         return msg;
     }
	 }

	@Override
	public void updateMessageStatus(int message_id,String status) {
		System.out.println("inside updateMessageStatus ");
	String updateSql = "update message set message_status= ? where message_id=? ";	
	System.out.println(updateSql);
	Object[] params = { status, message_id};
	 
	   
    // define SQL types of the arguments
    int[] types = {Types.VARCHAR, Types.NUMERIC};

	
         jdbcTemplate.update(updateSql, params, types);
        
        
        System.out.println("pk of rows updated =" );
        
       // "UPDATE "SYSTEM"."MESSAGE" SET MESSAGE_STATUS = '" +message_id+"' WHERE ROWID = 'AAAEIyAABAAAKnaAAA'"
        
	}
}
	
