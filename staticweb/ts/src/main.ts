import {sayHello} from "./greet";
console.log("good");
function showHello(divName: string, name: string){
    const el = document.getElementById(divName);
    el.innerText = sayHello(name);
}
showHello("greeting", "good");