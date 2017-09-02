/**
 * Created by 666666 on 2017/9/2.
 */
var Share = (function () {
    function Share(name, width, height) {
        this.name = name;
        this.width = width;
        this.height = height;
        this.area = width * height;
        this.color = 'pink';
    }
    Share.prototype.shoutout = function () {
        return "I'm " + this.color + " with an area of " + this.area;
    };
    return Share;
}());
var square = new Share('square', 30, 30);
console.log(square.shoutout());
console.log('Area of Shape: ' + square.area);
// console.log('Color of Shape: ' + square.color);
console.log('Name of Shape: ' + square.name);
console.log('width of Shape: ' + square.width);
console.log('height of Shape: ' + square.height);
