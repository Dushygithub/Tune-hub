package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.Song;

public interface SongService 
{
	public void addSong(Song songs);
	public List<Song> fetchAllSong();
	public boolean songExists(String name);
	public void updateSong(Song songs);

}
