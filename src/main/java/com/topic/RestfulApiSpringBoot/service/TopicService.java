package com.topic.RestfulApiSpringBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.topic.RestfulApiSpringBoot.DAO.TopicRepository;
import com.topic.RestfulApiSpringBoot.entity.Topic;
import com.topic.RestfulApiSpringBoot.exception.TopicNotSaveException;

import antlr.collections.List;

@Service
public class TopicService {

	
	TopicRepository topicRepo;
	
	@Autowired
	public TopicService(TopicRepository theTopicRepo) {
		topicRepo = theTopicRepo; 
	}
		
	public Topic save(Topic topic) {
		if(topic.getTopicName().isBlank() || topic.getDescription().isBlank()) {
			throw new TopicNotSaveException("Topic contains blank values...");
		}
		
		return topicRepo.save(topic);		
	}
	
}