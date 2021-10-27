package com.topic.RestfulApiSpringBoot.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	
	
	 @GetMapping(value = "/topic", produces = MediaType.APPLICATION_JSON_VALUE)
	 public @ResponseBody List getAllTopic() {
		 return topicService.getAllTopic(); 
	 
	 }
	 
	 @GetMapping("/topic/{id}")
	 public @ResponseBody Topic getTopicById(@PathVariable int id) {
		 return topicService.getTopicById(id); 
	 }

	 @PutMapping("/topic/{id}")
	 public ResponseEntity<Object> updateTopic(@PathVariable int id, @RequestBody Topic topic) {
		
		 Topic updatedTopic = topicService.updateTopic(id, topic);
		 Topic savedTopic = topicService.save(updatedTopic);
		 
		 return ResponseEntity.ok().build();
	 }
}
