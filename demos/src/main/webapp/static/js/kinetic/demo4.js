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
    var rect1 = new Kinetic.Rect({
        x: 100,
        y: 50,
        width: 400,
        height: 100,
        fillLinearGradientColorStops:[0, "red", 0.5, "green", 1, "blue"],
        fillLinearGradientStartPoint:{
            x: 10,
            y: 10
        },
        fillLinearGradientEndPoint:{
            x: 400,
            y: 200
        }
    });
    var rect2 = new Kinetic.Rect({
        x: 100,
        y: 200,
        width: 400,
        height: 100,
        fillLinearGradientColorStops:[0, "yellow", 0.5, "cyan", 1, "purple"],
        fillLinearGradientStartPoint:{
            x: 10,
            y: 10
        },
        fillLinearGradientEndPoint:{
            x: 400,
            y: 100
        }
    });

    layer.add(rect1);
    layer.add(rect2);
    stage.add(layer);
    stage.draw();
});