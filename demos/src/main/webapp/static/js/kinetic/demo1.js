/**
 * Created by 666666 on 2017/8/29.
 */
$(function () {
    var stage = new Kinetic.Stage({
        container: 'container',
        width: 600,
        height: 400,
    });
    var layer = new Kinetic.Layer();
    var rect = new Kinetic.Rect({
        x: 200,
        y: 150,
        width: 200,
        height: 100,
        fill: 'red',
        stroke: 'black',
        strokeWidth: 4
    });

    layer.add(rect);
    stage.add(layer);
    stage.draw();
});