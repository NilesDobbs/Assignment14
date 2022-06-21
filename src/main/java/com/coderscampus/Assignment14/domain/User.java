package com.coderscampus.Assignment14.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	private Long userId;
	private String name;
	private List<Channel> channels = new ArrayList<Channel>();
	private List<Message> messages = new ArrayList<Message>();
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@ManyToMany( fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinTable(name = "user_channel",
	joinColumns = @JoinColumn(name = "user_id"), 
	inverseJoinColumns = @JoinColumn(name = "channel_id"))
	public List<Channel> getChannels() {
		return channels;
	}
	public void setChannels(List<Channel> channels) {
		this.channels = channels;
	}
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<Message> getMessages() {
		return messages;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", channels=" + channels + ", messages=" + messages + "]";
	}
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	@Override
	public int hashCode() {
		return Objects.hash(userId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(userId, other.userId);
	}
}