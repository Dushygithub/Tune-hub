package com.example.demo.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.User;
import com.example.demo.Service.UserService;

import jakarta.servlet.http.HttpSession;

@org.springframework.stereotype.Controller
public class Controller {
	
	
	@Autowired
	UserService service;
	
	
	@PostMapping("/register")
	public String addUser(@ModelAttribute User user)
	{
		boolean userStatus=service.emailExists(user.getEmail());
		if(userStatus==false)
		{
		service.addUser(user);
		System.out.println("user added");
		}
		else
		{
			System.out.println("user is already exists");
		}
		return "home";
	}
		@PostMapping("/validate")
		public String validate(@RequestParam("email")String email,
				@RequestParam("password")String password,
				HttpSession session)
		{
			
			
			if(service.validateUser(email,password)== true)
			{
				String role=service.getRole(email);
				
				session.setAttribute("email",email);
				if(role.equals("admin"))
				{
					return "adminHome";
				}
				else
				{
					return "customerHome";
			
					
				}
			}
			else 
			{
				return "login";
			}
			
			}
		
		@GetMapping("/logout")
		public String logout(HttpSession session)
		{
			session.invalidate();
			return "login";
		}

}

