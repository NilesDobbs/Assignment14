var msgBox = document.getElementById('messageBox')
console.log(msgBox)
let messageContainer = document.getElementById("messageDisplay")
const queryString = window.location.href;
console.log(queryString)
let userId = user.userId
console.log(userId)
let channelId = queryString.substring(queryString.lastIndexOf("/") + 1, queryString.length);
console.log(channelId)

msgBox.addEventListener("keypress", submitOnEnter);
setInterval(getMessages, 500)

function submitOnEnter(event) {
	if (event.keyCode === 13) {
		let message = {
			messageName: user.name,
			messageContent: msgBox.value,
			channelId: channelId,
			userId: userId
		}
		msgBox.value = ""
		console.log("submitting message")
		fetch(`/channels/${channelId}/createMessage`, {
			method: "POST",
			headers: {
				"Content-Type": "application/json",
			},
			body: JSON.stringify(message)
		}).then(response => {getMessages()})
		return false;
	}
}
function getMessages(){
	fetch(`/channels/${channelId}/getMessages`, {
		method: "POST",
		headers: {
				"Content-Type": "application/json"
		}
		}).then(response => response.json()).then(function (data){ 
			appendMessages(data)
	})
}
function appendMessages(data) {
	var messageDisplay = document.getElementById("messageDisplay");
	messageDisplay.innerHTML = "";
	for (var i = 0; i < data.length; i++) {
		var div = document.createElement("div");
		div.innerHTML = data[i].messageName + ": " + data[i].messageContent;
		messageDisplay.appendChild(div);
	}
}