var __extends = (this && this.__extends) || (function () {
    var extendStatics = Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
        function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
/**
 * Created by 666666 on 2017/9/2.
 */
/**
 * Created by 666666 on 2017/9/2.
 */
var Share = (function () {
    function Share(name, width, height) {
        this.area = width * height;
        this.color = 'pink';
    }
    Share.prototype.shoutout = function () {
        return "I'm " + this.color + " with an area of " + this.area;
    };
    return Share;
}());
var Shape3D = (function (_super) {
    __extends(Shape3D, _super);
    function Shape3D(name, width, height, length) {
        var _this = _super.call(this, name, width, height) || this;
        _this.name = name;
        _this.volume = length * _this.area;
        return _this;
    }
    Shape3D.prototype.shoutout = function () {
        return "I'm " + this.name + " with a volume of " + this.volume + " cm cube.";
    };
    Shape3D.prototype.superShout = function () {
        return _super.prototype.shoutout.call(this);
    };
    return Shape3D;
}(Share));
var cube = new Shape3D('cube', 30, 30, 30);
console.log(cube.shoutout());
console.log(cube.superShout());
