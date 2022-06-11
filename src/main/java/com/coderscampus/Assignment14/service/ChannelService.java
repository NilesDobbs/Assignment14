package com.coderscampus.Assignment14.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.Assignment14.domain.Channel;
import com.coderscampus.Assignment14.repository.ChannelRepository;

@Service
public class ChannelService {
	@Autowired
	private ChannelRepository channelRepo;
	public Channel createChannel(Channel channel) {
		channel.setName("Main Room");
		return channelRepo.save(channel);
	}
	public Channel findById(Long channelId) {
		return channelRepo.findByChannelId(channelId);
	}
	public List<Channel> findAll() {
		return channelRepo.findAll();
	}
	public void createCustomChannel(Channel channel) {
		channelRepo.save(channel);
	}
}