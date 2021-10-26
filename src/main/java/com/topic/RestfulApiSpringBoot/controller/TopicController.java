package com.topic.RestfulApiSpringBoot.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.topic.RestfulApiSpringBoot.entity.Topic;
import com.topic.RestfulApiSpringBoot.service.TopicService;

@Controller
public class TopicController {
	
	@Autowired
	private TopicService topicService; 

	@PostMapping("/topic")
	public ResponseEntity<Object> saveTopic(@RequestBody Topic topic) {
		
		Topic savedTopic = topicService.save(topic);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
					   .path("/{id}").buildAndExpand(savedTopic.getId()).toUri();
		
		// return ResponseEntity.ok().build();
		
		return ResponseEntity.created(location).build();
	}
	
	/*
	 * @GetMapping("/gettopic") public List<Topic> getAllTopic() { return
	 * topicService.getAllTopic(); }
	 */
	
}
