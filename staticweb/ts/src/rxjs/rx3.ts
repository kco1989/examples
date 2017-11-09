/**
 * Created by pc on 2017/9/28.
 */
// import * as Rx from 'rxjs';
import * as Rx from 'rxjs/Rx';
export class Rx3{
    test1():void{
        let observable = Rx.Observable.create(observer =>{
            observer.next(1);
            observer.next(2);
            observer.next(3);
            setTimeout(() => {
                console.log("send 4");
                observer.next(4);
            }, 2000);
            observer.complete();
        }, 1000);
        console.log("just before subscribe1");
        observable.subscribe({
            next: x => console.log('got value ' + x),
            error: err => console.error('something wrong occurred ' + err),
            complete: () => console.log('done')
        });
        console.log("just after subscribe");
    }

    test2():void{
        let foo = Rx.Observable.create(observe => {
            console.log("Hello");
            observe.next(42);
            observe.next(43);
            setTimeout(()=>{
                observe.next(44);
            },1000)
        });
        let subscribe = foo.subscribe(x => console.log(x));
        // foo.subscribe(x => console.log(x));
        // subscribe.unsubscribe();
    }

    test3():void{
        var observable = Rx.Observable.from([10, 20, 30]);
        var subscription = observable.subscribe(x => console.log(x));
        subscription.unsubscribe();
    }
    test4():void{
        let startTime = +new Date();
        let ob1 = Rx.Observable.interval(400);

        let sub = ob1.subscribe(x => console.log("first:"+ ((+new Date()) - startTime) +" -> " + x));
        let childSub = ob1.subscribe(x => console.log("sencond:"+ ((+new Date()) - startTime) +" -> " + x));

        sub.add(childSub);
        setTimeout(()=>{
            sub.unsubscribe();
        }, 1210)
    }
    test5():void{
        let subject = new Rx.Subject();
        subject.subscribe({
            next: v => console.log("observerA:" + v)
        });
        subject.subscribe({
            next: (v) => console.log('observerB: ' + v)
        });
        setTimeout(() => subject.next(1), 1000);
        setTimeout(() => subject.next(2), 2000);
        subject.next(3)
        subject.next(4)

    }
    test6():void{
        var source = Rx.Observable.from([1, 2, 3]);
        var subject = new Rx.Subject();
        var multicasted = source.multicast(subject);
        multicasted.subscribe({
            next: v => console.log("obA:" + v)
        });
        multicasted.subscribe({
            next: v => console.log("obB:" + v)
        });
        multicasted.connect();

    }
    test7():void{
        var source = Rx.Observable.interval(500);
        var subject = new Rx.Subject();
        var multicasted = source.multicast(subject);
        var subscription1, subscription2, subscriptionConnect;
        subscription1 = multicasted.subscribe({
            next: v => console.log("subscription1 " + v)
        });

        subscriptionConnect = multicasted.connect();

        setTimeout(() => {
            subscription2 = multicasted.subscribe({
                next: v => console.log("subscription2 " + v)
            });
        }, 600);
        setTimeout(() => {
            subscription1.unsubscribe();
        }, 1200);
        setTimeout(() => {
            subscription2.unsubscribe();
            subscriptionConnect.unsubscribe();
        }, 2100);

    }
    test8():void{
        var source = Rx.Observable.interval(500);
        var subject = new Rx.Subject();
        var refCounted = source.multicast(subject).refCount();
        var subscription1,subscription2,subscriptionConnect;
// This calls `connect()`, because
// it is the first subscriber to `refCounted`
        console.log('observerA subscribed');
        subscription1 = refCounted.subscribe({
            next: (v) => console.log('observerA: ' + v)
        });

        setTimeout(() => {
            console.log('observerB subscribed');
            subscription2 = refCounted.subscribe({
                next: (v) => console.log('observerB: ' + v)
            });
        }, 600);

        setTimeout(() => {
            console.log('observerA unsubscribed');
            subscription1.unsubscribe();
        }, 1200);

// This is when the shared Observable execution will stop, because
// `refCounted` would have no more subscribers after this
        setTimeout(() => {
            console.log('observerB unsubscribed');
            subscription2.unsubscribe();
        }, 2000);
    }
    test9():void{
        var subject = new Rx.Subject();
        subject.subscribe({
            next: v => console.log("obA:" + v)
        });
        subject.next(1);
        subject.next(2);
        subject.subscribe({
            next: v => console.log("obB:" + v)
        });
        subject.next(3);
    }
    test10():void{
        var subject = new Rx.BehaviorSubject(0);
        subject.subscribe({
            next: v => console.log("obA:" + v)
        });
        subject.next(1);
        subject.next(2);
        subject.subscribe({
            next: v => console.log("obB:" + v)
        });
        subject.next(3);
    }
    test11():void{
        var subject = new Rx.ReplaySubject(3);
        subject.subscribe(v => console.log("obA " + v));
        subject.next(1);
        subject.next(2);
        subject.next(3);
        subject.next(4);
        subject.subscribe(v => console.log("ob " + v));
        subject.next(5);
    }
    test12():void{
        var subject = new Rx.ReplaySubject(100, 500);
        subject.subscribe(v => console.log("obA " + v));
        var i = 1;
        setInterval(() => subject.next(i++), 200);
        setTimeout(() => subject.subscribe(v => console.log("ob " + v)), 1000);
    }
    test13():void{
        var subject = new Rx.AsyncSubject();
        subject.subscribe(v => console.log("A -> " + v));
        subject.next(1);
        subject.next(2);
        subject.next(3);
        subject.next(4);
        subject.subscribe(v => console.log("B -> " + v));
        subject.next(5);
        subject.complete();
    }
    test14():void{
        var data = {
            a: 12,
            b: "sdsd";
        };

    }
}
console.log("============= start ==============");
let rx3 = new Rx3();
rx3.test13();
