/**
 * Created by 666666 on 2017/9/2.
 */
// alert("hello world in TypeScript")
function Add(left, right) {
    return left + right;
}
function area(shape, width, height) {
    var area = width * height;
    return "I'm a " + shape + " with an area of " + area + " cm squared.";
}
document.body.innerText = area("rectangle", 20, 15);
