var webSocket = 
	new WebSocket('ws://localhost:8080/assisenior/websocket');

webSocket.onerror = function(event) {
	onError(event)
};

webSocket.onopen = function(event) {
	onOpen(event)
};

webSocket.onmessage = function(event) {
	onMessage(event)
};

function onMessage(event) {
	document.getElementById('messages').innerHTML 
	+= '<br />Nouveau message: ' + event.data;
}

function onOpen(event) {
	document.getElementById('messages').innerHTML 
	= '';
}

function onError(event) {
	alert(event.data);
}

function send() {
	var txt = document.getElementById('contenu').value;
	webSocket.send(txt);
	return false;
}