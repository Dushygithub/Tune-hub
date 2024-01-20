package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Playlist;

public interface PlaylistRepository extends JpaRepository<Playlist,Integer>
{

}
