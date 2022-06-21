package com.coderscampus.Assignment14.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.Assignment14.domain.Channel;
import com.coderscampus.Assignment14.repository.ChannelRepository;

@Service
public class ChannelService {
	
	@Autowired
	private ChannelRepository channelRepo;
	
	public List<Channel> findAll() {
		return channelRepo.findAll();
	}
	public void save(Channel channel) {
		channelRepo.save(channel);	
	}
	public Optional<Channel> findById(Long channelId) {
		return channelRepo.findById(channelId);
	}

	
}