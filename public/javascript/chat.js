var app = angular.module('chatApp',['ngMaterial']);

app.controller('chatController',function ($scope) {
	$scope.messages = [
	{
		sender: "BOT",
		text :"hi how are you?",
		time :"1:12 PM"
    },
    {
    	sender:"user",
    	text:"what is your name",
		time :"1:12 PM"
    },
    
    {
    	sender: "BOT",
    	text: "vinod",
		time :"1:12 PM"
    },
   ]
var  exampleSocket =  new  WebSocket("ws://localhost:9000/chatSocket");
exampleSocket.onmessage  =   function  (event) {
       var jsonData = JSON.parse(event.data);
       console.log(jsonData);
   };

});