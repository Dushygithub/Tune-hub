package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.Entity.Song;
import com.example.demo.Service.SongService;

@Controller
public class SongController {
	@Autowired
	SongService service;
	
	@PostMapping("/addsong")
	public String addSong(@ModelAttribute Song songs)
	{
		boolean songStatus=service.songExists(songs.getName());
		if(songStatus==false)
		{
			service.addSong(songs);
			System.out.println("song added sucessfully");
		}
		else
		{
			System.out.println("song is already added");
		}
		return "adminHome";
		
	}
	
	@GetMapping("/viewSong")
	public String viewSong(Model model)
	{
		List<Song> sl=service.fetchAllSong();
		model.addAttribute("songs",sl);
		return "displaysong";
	}
	
	@GetMapping("/playSong")
	public String playSong(Model model)
	{
		boolean prem=true;
		if(prem==true)
		{
		List<Song> sl=service.fetchAllSong();
		model.addAttribute("songs",sl);
		return "displaysong";
		}
		else
		{
			return "payment";
		}
	}
	

}
