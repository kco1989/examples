$(function () {
    $("#wiselyForm").submit(function (e) {
        e.preventDefault();
        var text = $('#wiselyForm').find('textarea[name="text"]').val();
        sendSpittle(text);
    });
    var sock = new SockJS("/endpointChat");
    var stomp = Stomp.over(sock);
    stomp.connect('guest', 'guest', function (frame) {
        stomp.subscribe("/user/queue/notifications", handleNotification)
    });
    function handleNotification(message) {
        $("#output").append("<b>Received: "+ message.body + "</b><br>");
    }
    function sendSpittle(text) {
        stomp.send("/chat", {}, text);
    }
    $("#stop").click(function () {
        sock.close();
    })

});