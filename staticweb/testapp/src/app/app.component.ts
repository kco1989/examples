// import {Component, OnInit} from '@angular/core';
// import {Hero} from "./utils/Hero";
// import {HeroService} from "./utils/HelloService"
//
// @Component({
//   selector: 'app-root',
//   templateUrl: './app.component.html',
//   styleUrls: ['./app.component.css']
// })
// export class AppComponent implements OnInit{
//   ngOnInit(): void {
//     // this.getHeroes();
//     // this.getHeroesPromise();
//     this.getHerosPromiseSlowly();
//   }
//   constructor(private heroService: HeroService){}
//   title = 'app';
//   heroes : Hero[];
//   hero : Hero = {
//     id: 1,
//     name: 'Windstorm'
//   };
//   selectedHero: Hero;
//   onSelect (hero: Hero):void{
//     this.selectedHero = hero;
//   }
//   getHeroes():void{
//     this.heroes = this.heroService.getHeros();
//   }
//   getHeroesPromise():void{
//     this.heroService.getHerosPromise().then(heroes => this.heroes = heroes);
//   }
//   getHerosPromiseSlowly():void{
//     this.heroService.getHerosPromiseSlowly().then(heroes => this.heroes = heroes);
//   }
// }
//
//
//
//


import {Component} from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls:['./app.component.css']
})
export class AppComponent{
  title = "Tour of Heroes";
}




