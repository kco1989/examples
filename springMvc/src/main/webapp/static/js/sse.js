$(function () {
    if (!!window.EventSource) {
        var source = new EventSource($("#pushUrl").val());
        var s = '';
        source.addEventListener('message', function (e) {
            s += e.data + "<br/>";
            $("#msgFrompPush").html(s);
        });

        source.addEventListener('open', function (e) {
            console.log("链接打开.")
        }, false);

        source.addEventListener('error', function (e) {
            if (e.readyState == EventSource.CLOSED) {
                console.log("链接关闭.")
            } else {
                console.log(e.readyState)
            }
        }, false)
    } else {
        console.log("你的浏览器不支持SSE");
    }
});
