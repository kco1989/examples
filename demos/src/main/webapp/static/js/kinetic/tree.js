/**
 * Created by 666666 on 2017/8/31.
 */

$(function () {
    var GLOBAL = {
        stageWidth: 600,
        stageHeight: 600,
        treeTrunkHeight: 150,
        treeBranchMinRate: 0.5,
        treeBranchMaxRate: 0.618,
        treeBranchCount: 10,
        treeLeftBranchMinAngle: 30,//Math.PI / 12,
        treeLeftBranchMaxAngle: 60,
        treeRightBranchMinAngle: -60, //Math.PI / 12,
        treeRightBranchMaxAngle: -30
    };
    var stage = new Kinetic.Stage({
        container: "container",
        width: GLOBAL.stageWidth,
        height: GLOBAL.stageHeight
    });
    var layer = new Kinetic.Layer();
    stage.add(layer);
    var Tree = function (config) {
        this._init(config);
    };
    Tree.prototype = {
        _init: function (config) {
            $.extend(this, config);
        },
        draw: function () {
            this.layer.removeChildren();
            this.layer.clear();
            this._drawTree();
            this.layer.draw();
        },
        _drawTree: function () {
            var startPoint = this.startPoint;
            var endPoint = {
                x: startPoint.x,
                y: startPoint.y - this.trunkHeight
            };
            this.layer.add(this._makeLine(startPoint, endPoint,{
                strokeWidth: 3
            }));

            this._drawBranck(this._randomBranchRate(this.trunkHeight),endPoint,this._randomAngle(true), 0, true);
            this._drawBranck(this._randomBranchRate(this.trunkHeight),endPoint,this._randomAngle(false), 0, false);
        },
        _drawBranck: function (height, startPoint, angle, branckCount, isLeft) {
            if (branckCount > this.branchCount){
                return;
            }
            var realAngle = 90 + angle ;
            console.log(isLeft + "," + branckCount + "," + angle + "," + realAngle);
            var endPoint = {
                x: startPoint.x + height * Math.cos(realAngle * Math.PI / 180) ,
                y: startPoint.y - height * Math.sin(realAngle * Math.PI / 180)
            };
            this.layer.add(this._makeLine(startPoint, endPoint,{
                strokeWidth: (this.branchCount - branckCount * 2 < 0) ? 1 : 3,
                stroke: (this.branchCount - branckCount * 2 < 0) ? 'red' : 'green'
            }));
            var randomAngle = this._randomAngle(isLeft);
            this._drawBranck(this._randomBranchRate(height),endPoint,isLeft ? angle + randomAngle : angle - randomAngle, branckCount + 1, true);
            this._drawBranck(this._randomBranchRate(height),endPoint,isLeft ? angle - randomAngle : angle + randomAngle, branckCount + 1, false);
        },
        _makeLine: function (startPoint, endPoint, config) {
            var c = config || {};
            return new Kinetic.Line($.extend({},{
                points: [
                    startPoint.x,startPoint.y,
                    endPoint.x, endPoint.y
                ],
                stroke: 'green',
                strokeWidth: 1
            }, c));
        },
        _randomAngle:function (isLeft) {
            var minAngle = isLeft ? this.leftBranchMinAngle : this.rightBranchMinAngle;
            var maxAngle = isLeft ? this.leftBranchMaxAngle : this.rightBranchMaxAngle;
            return Math.random() * (maxAngle - minAngle) + minAngle;
        },
        _randomBranchRate: function (height) {
           var rate = Math.random() * (this.treeBranchMaxRate - this.treeBranchMinRate) + this.treeBranchMinRate;
           return rate * height;
        }
    };
    var tree = new Tree({
        layer: layer,
        startPoint: {
            x: GLOBAL.stageWidth / 2,
            y: GLOBAL.stageHeight - 50
        },
        trunkHeight: GLOBAL.treeTrunkHeight,
        treeBranchMinRate: GLOBAL.treeBranchMinRate,
        treeBranchMaxRate: GLOBAL.treeBranchMaxRate,
        branchCount: GLOBAL.treeBranchCount,
        leftBranchMinAngle: GLOBAL.treeLeftBranchMinAngle,
        leftBranchMaxAngle: GLOBAL.treeLeftBranchMaxAngle,
        rightBranchMinAngle: GLOBAL.treeRightBranchMinAngle,
        rightBranchMaxAngle: GLOBAL.treeRightBranchMaxAngle
    });
    tree.draw();
});