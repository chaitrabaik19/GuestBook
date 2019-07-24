package com.guestbook.poc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.guestbook.poc.service.UserService;

@Controller
public class GuestUserController {
	
	@Autowired
	  public UserService userService;
	
	@RequestMapping(value="/",  method=RequestMethod.GET)
	public ModelAndView welcome(){
		System.out.println("inside controller");
		
		return new ModelAndView("welcomePage", "welcomeMessage", "Welcome to GuestBook!");
		
	}
	
	
}
