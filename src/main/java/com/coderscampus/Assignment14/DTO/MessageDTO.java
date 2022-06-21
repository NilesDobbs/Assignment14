package com.coderscampus.Assignment14.DTO;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageDTO {
	
	@JsonProperty("messageName")
	private String messageName;
	@JsonProperty("messageContent")
	private String messageContent;
	@JsonProperty("channelId")
	private Long channelId;
	@JsonProperty("userId")
	private Long userId;
	 
	public String getMessageContent() {
		return messageContent;
	}
	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
	public Long getChannelId() {
		return channelId;
	}
	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getMessageName() {
		return messageName;
	}
	public void setMessageName(String messageName) {
		this.messageName = messageName;
	}
	@Override
	public int hashCode() {
		return Objects.hash(channelId, messageContent, userId);
	}
	
	@Override
	public String toString() {
		return "MessageDto [messageName=" + messageName + ", messageContent=" + messageContent + ", channelId="
				+ channelId + ", userId=" + userId + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MessageDTO other = (MessageDTO) obj;
		return Objects.equals(channelId, other.channelId) && Objects.equals(messageContent, other.messageContent)
				&& Objects.equals(userId, other.userId);
	}	
}