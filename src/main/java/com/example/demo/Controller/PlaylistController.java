package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.Entity.Playlist;
import com.example.demo.Entity.Song;
import com.example.demo.Service.PlaylistService;
import com.example.demo.Service.SongService;

@Controller
public class PlaylistController {
	@Autowired
	PlaylistService service;
	
	@Autowired
	SongService songservice;
	
	@GetMapping("/createplaylist")
	public String createPlaylist(Model model)
	{
		List<Song> s1=songservice.fetchAllSong();
		model.addAttribute("songs",s1);
		
		return "playlist";
	}
	
	@PostMapping("/addPlaylist")
	public String addPlaylist(@ModelAttribute Playlist playlist)
	{
		service.addPlaylist(playlist);
		System.out.println(playlist);
		
		List<Song> songlist=playlist.getSongs();
		for(Song s:songlist)
		{
			s.getPlaylist().add(playlist);
			songservice.updateSong(s);
		}
		
		return "adminHome";
		
	}
	@GetMapping("/viewplaylist")
	public String display(Model model)
	{
		List<Playlist> allPlaylists=service.fetchAllPlaylists();
		model.addAttribute("allplaylists", allPlaylists);
		return "displayplaylist";
		
	}
}
