/**
 * Created by pc on 2017/9/28.
 */
import * as Rx from 'rxjs';

export class Rx1{
    test1():void{
        const button = document.getElementById("test1");
        console.log("--> %o", button.id);
        button.addEventListener('click', () => console.log("clicked!"));
    }
    test1rx():void{
        var button = document.querySelector("#test1");
        Rx.Observable.fromEvent(button, 'click')
            .subscribe(() => console.log("clicked rx"));
    }

    test2():void{
        var count = 0;
        var button = document.querySelector("#test2");
        button.addEventListener('click',
            () => console.log(`clicked ${++count} times`));
    }

    test2rx():void {
        var button = document.querySelector('#test2');
        Rx.Observable.fromEvent(button, 'click')
            // .scan((count:number) => count + 1, 0)
            .scan((point : {x: number, y: number}) => {
                point.x += 1;
                point.y += 2;
                return point;
            }, {x: 0, y:0})
            .subscribe((point) =>
                console.log(`${point.x}, ${point.y}`));
    }
    // 1s内点击1次
    test3():void{
        var count = 0;
        var rate = 1000;
        var lastClick = Date.now() - rate;
        var button = document.querySelector('#test3');
        button.addEventListener('click', () => {
            if (Date.now() - lastClick >= rate) {
                console.log(`Clicked ${++count} times`);
                lastClick = Date.now();
            }
        });
    }
    test3rx():void {
        var button = document.querySelector("#test3");
        console.log("%o", button);
        Rx.Observable.fromEvent(button, 'click')
            .throttleTime(1000)
            .scan((count:number) => count + 1, 0)
            .subscribe(c => console.log(`clicked ${c} times`));
    }
}