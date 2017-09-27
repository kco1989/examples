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
    var config = {
        drawFunc: function () {
            var context = this.getContext();
            context.rect(200, 150, 200, 100);
            context.fillStrokeShape(this);

        },
        fill: 'green',
        stroke: 'black',
        strokeWidth: 4
    };
    var rectShape = new Kinetic.Shape(config);

    layer.add(rectShape);
    stage.add(layer);
    stage.draw();
});