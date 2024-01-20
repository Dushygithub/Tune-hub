package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Playlist;
import com.example.demo.Repository.PlaylistRepository;

@Service
public class PlaylistServiceImplementation implements PlaylistService
{
	@Autowired
	PlaylistRepository prepo;
	
	@Override
	public void addPlaylist(Playlist playlist) {
		prepo.save(playlist);
		
		
	}

	@Override
	public List<Playlist> fetchAllPlaylists() {
	
		return prepo.findAll();
	}

}
