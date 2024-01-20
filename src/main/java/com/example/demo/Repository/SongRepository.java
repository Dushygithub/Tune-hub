package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Song;

public interface SongRepository extends JpaRepository<Song, Integer>
{
	public Song findByName(String name);
}
