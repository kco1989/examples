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
    var circle = new Kinetic.Circle({
        x: 200,
        y: 100,
        radius: 50,
        fill: "red"
    });
    var rect = new Kinetic.Rect({
        x: 300,
        y: 200,
        width: 100,
        height: 100,
        fill: "blue"
    });

    var group = new Kinetic.Group({
        x: 220,
        y: 40,
        rotationDeg: 20
    });
    group.add(circle);
    group.add(rect);
    layer.add(group);
    stage.add(layer);
    stage.draw();
});