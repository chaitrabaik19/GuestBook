package com.guestbook.poc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.guestbook.poc.model.Message;
import com.guestbook.poc.model.User;
import com.guestbook.poc.service.UserService;


	@Controller
	public class GuestBookController {
		@Autowired
		  public UserService userService;
		
		@RequestMapping(value="/",  method=RequestMethod.GET)
		public ModelAndView welcome(){
			System.out.println("inside controller");
			
			return new ModelAndView("welcomePage", "welcomeMessage", "Welcome to GuestBook!");
			
		}
		
		
		
		@RequestMapping(value="/user", method=RequestMethod.POST)
		public ModelAndView showMessage(HttpServletRequest request, HttpServletResponse response,
				  @ModelAttribute("user") User user, Model mod,@ModelAttribute("message") Message message){
			System.out.println("inside usr");
			User userdetail = new User();
			List<User> list=new ArrayList<User>();  
			List<Message> messageList = null;
			ModelAndView mdv = null;
			
			
			
			//mod.addAttribute("user_name", user.getUser_name());
			//
			 userdetail= userService.getUserdetail(user);
			 messageList = userService.getMessageDetail();
			 if(userdetail!=null){
				 list.add(new User(userdetail.getUser_id(),userdetail.getUser_name(),userdetail.getPassword(), userdetail.getUser_role()));
				 
				 if(userdetail.getUser_name()!=null && userdetail.getPassword()!=null){
					 if (userdetail.getUser_role().equals("admin")){
						 
						  mdv = new ModelAndView("adminPage","messageList",messageList);  
						 
					 }
					 if(userdetail.getUser_role().equals("guest")){
						 
						  mdv = new ModelAndView("userPage","list",list);
					 }
					 
				 }
				 
			 }
			 else{
					
				 mdv = new ModelAndView("errorPage","list","Error occured , please check");
					 
			 }
			//mod.addAttribute("user_role", user.getUser_role());
			 //return new ModelAndView("userPage", "user_role", user.getUser_role());
			 return mdv  ;
			//return "userPage";
			
		}
		
		@RequestMapping(value="/saveUser", method=RequestMethod.POST)
		public ModelAndView saveEntry(HttpServletRequest request, HttpServletResponse response,
				  @ModelAttribute("message") Message message, Model mod){
			System.out.println("inside usr");
			userService.register(message);
			return new  ModelAndView("success","msg","success!!");
		}
		
		@RequestMapping(value="/home", method=RequestMethod.GET)
		public ModelAndView homePage(){
			System.out.println("home usr");
			return new  ModelAndView("welcomePage","welcomeMessage","You have logged out of Guest Book");
		}
		
		@RequestMapping(value="/approve/{message_id}", method=RequestMethod.GET)
		public ModelAndView approve(@PathVariable int message_id){
			System.out.println("delete usr"+  message_id);
			userService.updateStatus(message_id,"approved");
			List<Message> messageList = new ArrayList<>();
			messageList = userService.getMessageDetail();
			
			//return new  ModelAndView("UserPage","msg","success!!");
			return new ModelAndView("adminPage","messageList", messageList);
		}
		
		@RequestMapping(value="/reject/{message_id}", method=RequestMethod.GET)
		public ModelAndView reject(@PathVariable int message_id){
			System.out.println("reject usr"+  message_id);
			userService.updateStatus(message_id,"Rejected");
			List<Message> messageList = new ArrayList<>();
			messageList = userService.getMessageDetail();
			
			//return new  ModelAndView("reject","msg","success!!");
			
			return new ModelAndView("adminPage","messageList", messageList);
		}
		
		
	}

