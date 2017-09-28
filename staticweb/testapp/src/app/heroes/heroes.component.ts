import {Component, OnInit} from '@angular/core';
import {Hero} from "../utils/Hero";
import {HeroService} from "../utils/HelloService"
import {Router} from "@angular/router";

@Component({
  selector: 'my-heroes',
  templateUrl: './heroes.component.html',
  styleUrls: ['./heroes.component.css']
})
export class HeroesComponent implements OnInit{
  ngOnInit(): void {
    // this.getHeroes();
    this.getHeroesPromise();
    // this.getHerosPromiseSlowly();
  }
  constructor(
    private heroService: HeroService,
    private router: Router
  ){}
  title = 'app';
  heroes : Hero[];
  hero : Hero = {
    id: 1,
    name: 'Windstorm'
  };
  selectedHero: Hero;
  onSelect (hero: Hero):void{
    this.selectedHero = hero;
  }
  getHeroes():void{
    this.heroes = this.heroService.getHeros();
  }
  getHeroesPromise():void{
    this.heroService.getHeroesHttp().then(heroes => this.heroes = heroes);
  }
  getHerosPromiseSlowly():void{
    this.heroService.getHerosPromiseSlowly().then(heroes => this.heroes = heroes);
  }
  gotoDeatil():void{
    this.router.navigate(['/detail', this.selectedHero.id]);
  }
  add(name: string): void {
    name = name.trim();
    if (!name) { return; }
    this.heroService.create(name)
      .then(hero => {
        this.heroes.push(hero);
        this.selectedHero = null;
      });
  }
  delete(hero: Hero): void {
    this.heroService
      .delete(hero.id)
      .then(() => {
        this.heroes = this.heroes.filter(h => h !== hero);
        if (this.selectedHero === hero) { this.selectedHero = null; }
      });
  }
}




// import {Component} from "@angular/core";
// @Component({
//   selector: 'app-root',
//   templateUrl: './app.component.html',
//   styleUrls: ['./app.component.css']
// })
// export class AppComponent{
//   title = "Tour of Heroes";
// }
