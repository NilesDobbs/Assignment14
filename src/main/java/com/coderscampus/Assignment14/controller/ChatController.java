package com.coderscampus.Assignment14.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coderscampus.Assignment14.DTO.MessageDTO;
import com.coderscampus.Assignment14.domain.Channel;
import com.coderscampus.Assignment14.domain.User;
import com.coderscampus.Assignment14.service.ChannelService;
import com.coderscampus.Assignment14.service.MessageService;
import com.coderscampus.Assignment14.service.UserService;

@Controller
public class ChatController {
	@Autowired
	private ChannelService channelService;
	@Autowired
	private UserService userService;
	@Autowired
	private MessageService messageService;

	@GetMapping("/")
	public String directToWelcome() {
		return "redirect:/welcome";
	}

	@GetMapping("/welcome")
	public String getWelcomePage(ModelMap model) {

		List<Channel> channels = channelService.findAll();
		model.put("channels", channels);
		model.put("channel", new Channel());

		return "welcome";
	}

	@GetMapping("/channels/{channelId}")
	public String getOneChannel(@PathVariable Long channelId) {
		return "channel";
	}

	@PostMapping("/channels/{channelId}/getMessages")
	@ResponseBody
	public List<MessageDTO> getMessages(@PathVariable Long channelId) {
		return messageService.findAllByChannelId(channelId);
	}

	@PostMapping("/channels/{channelId}/createMessage")
	@ResponseBody
	public void createMessage(@RequestBody MessageDTO message) {
		
		System.out.println("making new message");
		messageService.createMessage(message);

	}

	@PostMapping("/welcome/createChannel")
	public String createNewChannel(Channel channel) {
		
		channelService.save(channel);
		return "redirect:/welcome";
	}

	@PostMapping("/welcome/createUser")
	@ResponseBody
	public User createUser(@RequestBody String username) {
		
		return userService.createUser(username);

	}
}