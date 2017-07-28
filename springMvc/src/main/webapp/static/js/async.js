$(function () {
    var count = 0;
    function deferred() {
        if (count >= 10){
            return;
        }
        $.get($("#deferUrl").val(), function (data) {
            console.log(data);
            deferred(++count);
        })
    }

    deferred();
});
