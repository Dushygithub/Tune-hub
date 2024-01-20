package com.example.demo.Service;
import java.util.List;

import com.example.demo.Entity.Playlist;

public interface PlaylistService {
	
	public void addPlaylist(Playlist playlist);
	
	public List<Playlist> fetchAllPlaylists();

}
