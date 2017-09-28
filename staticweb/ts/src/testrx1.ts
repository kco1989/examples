/**
 * Created by 666666 on 2017/9/28.
 */
import * as Rx from 'rxjs'

var button = document.querySelector('#button');
Rx.Observable.fromEvent(button, 'click')
    .subscribe(() => console.log('Clicked!'));