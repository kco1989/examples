$(function () {
   var stompClient = null;
   function setConnected(connected) {
        $("#connect").attr("disabled", connected);
        $("#disconnect").attr("disabled", !connected);
        $("#conversationDiv").css("visibility", connected ? "visible" : "hidden");
        $("#response").html();
   }
   
   function connect() {
       var socket = new SockJS("/endpointWisely");
       stompClient = Stomp.over(socket);
       stompClient.connect({}, function (frame) {
           setConnected(true);
           console.log('Connected: ' + frame);
           stompClient.subscribe('/topic/getResponse', function (respnose) {
               showResponse(JSON.parse(respnose.body).responseMessage);
           })
       })
   }

   function disconnect() {
       if (stompClient != null) {
           stompClient.disconnect();
       }
       setConnected(false);
       console.log("Disconnected");
   }
   function sendName() {
       var name = $("#name").val();
       stompClient.send("/welcome", {}, JSON.stringify({
           name: name
       }));
   }
   function showResponse(message) {
       $("#response").html(message);
   }

   function init() {
       $("#connect").click(connect);
       $("#disconnect").click(disconnect);
       $("#sendName").click(sendName);
       disconnect();
   }

   init();
});