package com.websongs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.websongs.entity.Songs;

public interface SongsRepository extends JpaRepository<Songs, Long> {

}
