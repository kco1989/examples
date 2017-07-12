var Gobj ={
    "and" :
    [{
        "or": [{
            "and": [{
                "or": [{
                    "kd": "1",
                    "op": "=",
                    "cmp": ""
                }, {
                    "kd": "2",
                    "op": "=",
                    "cmp": ""
                }]
            }, {
                "kd": "3",
                "op": "=",
                "cmp": ""
            }]
        }, {
            "kd": "4",
            "op": "=",
            "cmp": ""
        }]
    }, {
        "or": [{
            "and": [{
                "or": [{
                    "kd": "5",
                    "op": "=",
                    "cmp": ""
                }, {
                    "kd": "6",
                    "op": "=",
                    "cmp": ""
                }]
            }, {
                "kd": "7",
                "op": "=",
                "cmp": ""
            }]
        }, {
            "kd": "8",
            "op": "=",
            "cmp": ""
        }]
    }]
};
Gobj ={"or": [{
    "kd": "5",
    "op": "=",
    "cmp": ""
}, {
    "kd": "6",
    "op": "=",
    "cmp": ""
}]}
$(function () {
    var $main = $("#main");

    function list(obj, count, $parentBox) {
        var $tr = $("<tr></tr>");
        for(var key in obj){
            var $td = $("<td>" + key + "</td>");
            $tr.append($td);
            if($.isArray(obj[key])){

            }

        }
        $parentBox.append($tr);
    }
    list(Gobj, 0, $main);
});