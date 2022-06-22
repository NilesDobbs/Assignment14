package com.coderscampus.Assignment14.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.Assignment14.DTO.MessageDTO;
import com.coderscampus.Assignment14.domain.Channel;
import com.coderscampus.Assignment14.domain.Message;
import com.coderscampus.Assignment14.domain.User;
import com.coderscampus.Assignment14.repository.MessageRepository;

@Service
public class MessageService {
	
	@Autowired
	private MessageRepository messageRepo;
	@Autowired
	private ChannelService channelService;
	@Autowired
	private UserService userService;

	public void createMessage(MessageDTO message, Long channelId) {
		Channel channel = channelService.findById(channelId);
		Message newMessage = new Message();
		User user = new User();
		user = userService.findByUserId(message.getUserId());
		newMessage.setUser(user);
		newMessage.setMessage(message.getMessage());
		newMessage.setChannel(channel);
		messageRepo.save(newMessage);
		
	}
	public List<MessageDTO> getMessageByChannelId(Long channelId) {
		List<Message> messageList = messageRepo.findAllByChannelId(channelId);
		List<MessageDTO> messagesDto = new ArrayList<>();
		for (Message message:messageList) {
			MessageDTO messageDto = new MessageDTO();
			messageDto.setMessage(message.getMessage());
			messageDto.setUserId(message.getUser().getUserId());
			messageDto.setChannelId(message.getMessageId());
			messageDto.setUsername(message.getUser().getUsername());
			messagesDto.add(messageDto);
		}
		return messagesDto;
	}
}	