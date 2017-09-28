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
        var button = document.querySelector('button');
        Rx.Observable.fromEvent(button, 'click')
            .scan(count => count + 1, 0)
            .subscribe(count => console.log(`Clicked ${count} times`));

    }
}