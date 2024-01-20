package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Song;
import com.example.demo.Repository.SongRepository;

@Service
public class SongServiceImplementation implements SongService {
	@Autowired
	SongRepository srepo;

	@Override
	public void addSong(Song songs) {
		srepo.save(songs);
		
		
	}

	@Override
	public List<Song> fetchAllSong() {
		return srepo.findAll();
		 
	}

	@Override
	public boolean songExists(String name) {
		Song song=srepo.findByName(name);
		if(song==null)
		{
			return false;
		}
		else {
		return true;
		}
	}

	@Override
	public void updateSong(Song songs) {
		srepo.save(songs);
		
	}

}
