package com.topic.RestfulApiSpringBoot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

	public java.util.List getAllTopic() {
		return topicRepo.findAll();
	}

	public Topic getTopicById(int id) {
		
		Topic theTopic = topicRepo.findById(id);
		if(theTopic.getId() == id ) {
			 return theTopic;
		}
		else {
			throw new TopicNotSaveException("Topic not present...");
		}
		
	}

	public Topic updateTopic(int id, Topic topic) {
	Topic thetopic = topicRepo.findById(id);
	thetopic.setTopicName(topic.getTopicName());
	thetopic.setDescription(topic.getDescription());
	return thetopic;

	}

	
	
}