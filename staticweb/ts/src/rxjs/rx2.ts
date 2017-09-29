/**
 * Created by pc on 2017/9/28.
 */
// import * as Rx from 'rxjs';
import * as Rx from 'rxjs/Rx';
export class Rx2{
    test1():void{
        const time1 = Rx.Observable.create(e => {
            for (let i = 0; i < 20; i ++){
                e.next(i);
            }
        });
        const time2 = time1.filter(num => {
            return (num % 2 != 0)
        });
        const time3 = time2.debounceTime(3000);
        const time4 = time3.delay(2000);
        time1.subscribe(x => console.log("time1: " + x));
        time2.subscribe(x => console.log("time2: " + x));
        time3.subscribe(x => console.log("time3: " + x));
        time4.subscribe(x => console.log("time4: " + x));

    }

    test2():void{
        const book = "123456789";
        const sub1 = new Rx.ReplaySubject(Number.MAX_VALUE);
        const sub2 = new Rx.ReplaySubject(3);

        const source = Rx.Observable.from(book.split(""));
        source.subscribe(sub1);
        source.subscribe(sub2);

        sub1.map(x => {
            console.log("sub1 : " + x);
            return x;
        })
    }

    test3():void{
        Rx.Observable.range(1,10)
            .subscribe(x => console.log(x))
    }
}