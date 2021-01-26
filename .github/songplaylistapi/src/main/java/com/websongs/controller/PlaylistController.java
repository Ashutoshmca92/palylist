package com.websongs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.websongs.entity.NewPlaylist;
import com.websongs.entity.Songs;
import com.websongs.repository.NewPlaylistRepository;
import com.websongs.repository.SongsRepository;

//import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api")

public class PlaylistController {

	@Autowired
	NewPlaylistRepository playRepository;

	@Autowired
	SongsRepository songRepository;
	@Autowired
	ObjectMapper objectMapper;

	/*
	 * new play list
	 */
	@RequestMapping(value = "/playList", method = RequestMethod.POST)
	public ResponseEntity<String> createNewPlaylist(@RequestBody String playlist)
			throws JsonMappingException, JsonProcessingException {

		NewPlaylist playobj = objectMapper.readValue(playlist, NewPlaylist.class);

		playRepository.save(playobj);

		return new ResponseEntity<>("song play list api created", HttpStatus.CREATED);

	}

	// songs list and singer name api list
	@RequestMapping(value = "/songs", method = RequestMethod.POST)
	public ResponseEntity<String> createNewSongslist(@RequestBody String songlist)
			throws JsonMappingException, JsonProcessingException {

		Songs sobj = objectMapper.readValue(songlist, Songs.class);

		songRepository.save(sobj);

		return new ResponseEntity<>("song  list api created", HttpStatus.CREATED);

	}

	// songs list and singer name api list

	@RequestMapping(value = "/songsDelete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<HttpStatus> deleteSongsById(@PathVariable Long id) {
		try {

			songRepository.deleteById(id);

			return new ResponseEntity("song deleted", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	//delete play list
	
	@RequestMapping(value="/playlistDelete", method = RequestMethod.DELETE)
	public ResponseEntity<String> deletePlayList(){
		try {
			playRepository.deleteAll();
			return new ResponseEntity ("playList deleted", HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
