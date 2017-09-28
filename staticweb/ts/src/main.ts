import {sayHello} from "./greet";
import {Rx1} from "./rxjs/rx1";
console.log("good");
function showHello(divName: string, name: string){
    const el = document.getElementById(divName);
    el.innerText = sayHello(name);
}
showHello("greeting", "good1");
let rx1 = new Rx1();
rx1.test1rx();
rx1.test2rx();
rx1.test3rx();


