
package com.websongs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.websongs.entity.NewPlaylist;

public interface NewPlaylistRepository extends JpaRepository<NewPlaylist, Long> {

	
}
