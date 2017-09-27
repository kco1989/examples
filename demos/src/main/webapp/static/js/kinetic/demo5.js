/**
 * Created by 666666 on 2017/8/29.
 */
$(function () {
    var stage = new Kinetic.Stage({
        container: 'container',
        width: 600,
        height: 400
    });
    var layer = new Kinetic.Layer();
    var line = new Kinetic.Line({
        points:[100, 150, 340, 230],
        stroke: 'blue',
        strokeWidth: 10,
        draggable: true
    });
    layer.add(line);
    stage.add(layer);
    // line.saveData();
    // line.on("dragend", function () {
    //     // line.saveData();
    // });
    stage.draw();
});