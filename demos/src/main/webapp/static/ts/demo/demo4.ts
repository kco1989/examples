/**
 * Created by 666666 on 2017/9/2.
 */
class Share{
    area: number;
    private color: string;

    constructor(public name: string,public width: number,public height: number){
        this.area = width * height;
        this.color = 'pink';
    }

    shoutout(){
        return "I'm " + this.color + " with an area of " + this.area;
    }

}
var square = new Share('square', 30, 30);

console.log(square.shoutout());
console.log('Area of Shape: ' + square.area);
// console.log('Color of Shape: ' + square.color);
console.log('Name of Shape: ' + square.name);
console.log('width of Shape: ' + square.width);
console.log('height of Shape: ' + square.height);
