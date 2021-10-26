package com.topic.RestfulApiSpringBoot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Topic {
	
	//@GeneratedValue(generator = "UUID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String topicName;
	
	@Column
	private String description;
	
	public Topic() {
		
	}
	
	public Topic(int id, String topicName, String description) {
		this.id = id;
		this.topicName = topicName;
		this.description = description;
		System.out.println("hello..");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Topic [id=" + id + ", topicName=" + topicName + ", description=" + description + "]";
	}
	

}
