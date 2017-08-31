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
            // this.layer = config && config.layer;
            // this.startPoint = config && config.startPoint;
            // this.trunkHeight = config && config.trunkHeight;
            // this.branchRate = config && config.branchRate;
            // this.branchCount = config && config.branchCount;
            // this.leftBranchMinAngle = config && config.leftBranchMinAngle;
            // this.leftBranchMaxAngle = config && config.leftBranchMaxAngle;
            // this.rightBranchMinAngle = config && config.rightBranchMinAngle;
            // this.rightBranchMaxAngle = config && config.rightBranchMaxAngle;
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
            // console.log(height + ", %o,"  +branckCount +"," + isLeft, startPoint);
            if (branckCount >= this.branchCount){
                return;
            }
            var realAngle = 90 + angle ;
            console.log(isLeft + "," + branckCount + "," + angle + "," + realAngle);
            var endPoint = {
                x: startPoint.x + height * Math.cos(realAngle * Math.PI / 180) ,
                y: startPoint.y - height * Math.sin(realAngle * Math.PI / 180)
            };
            this.layer.add(this._makeLine(startPoint, endPoint));
            var randomAngle = this._randomAngle(isLeft);
            this._drawBranck(this._randomBranchRate(height),endPoint,isLeft ? angle + randomAngle : angle - randomAngle, branckCount + 1, true);
            this._drawBranck(this._randomBranchRate(height),endPoint,isLeft ? angle - randomAngle : angle + randomAngle, branckCount + 1, false);
            // this._drawBranck(this._randomBranchRate(height),endPoint,angle - randomAngle, branckCount + 1, true);
            // this._drawBranck(this._randomBranchRate(height),endPoint,angle + randomAngle, branckCount + 1, true);
        },
        _makeLine: function (startPoint, endPoint, config) {
            // console.log("%o, %o", startPoint, endPoint);
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
            var angle = Math.random() * (maxAngle - minAngle) + minAngle;
            return angle;
        },
        _randomBranchRate: function (height) {
           var rate = Math.random() * (this.treeBranchMaxRate - this.treeBranchMinRate) + this.treeBranchMinRate;
           // console.log(rate * height);
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