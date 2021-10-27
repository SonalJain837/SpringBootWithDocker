package com.topic.RestfulApiSpringBoot.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.topic.RestfulApiSpringBoot.entity.Topic;

public interface TopicRepository extends JpaRepository<Topic, Integer> {
 
	public Topic findById(int id);
}