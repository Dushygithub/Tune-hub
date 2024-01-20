package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavController {
	
	@GetMapping("/login")
	public String login()
	{
		return "login";
	}
	
	@GetMapping("/regi")
	public String register()
	{
		return "register";
	}
	
	@GetMapping("/newSong")
	public String newSong()
	{
		return "newSong";
	}
	
	
	
}
