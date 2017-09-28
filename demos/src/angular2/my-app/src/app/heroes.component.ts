/**
 * Created by 666666 on 2017/9/27.
 */
import {Component, OnInit} from '@angular/core';
import {Hero} from "./hero";
import {HeroService} from "./hero.service";
@Component({
  selector: 'my-heroes',
  template: `
      <h1>{{title}}</h1>
      <h2>My Heroes</h2>
      <ul class="heroes">
        <li *ngFor="let hero of heroes"
          [class.selected]="hero === selectedHero"
          (click)="onSelect(hero)">
          <span class="badge">{{hero.id}}</span> {{hero.name}}
        </li>
      </ul>
      <hero-detail [hero]="selectedHero"></hero-detail>
  `,
  providers:[HeroService],
  styleUrls: ['./app.component.css']
})
export class HeroesComponent implements OnInit{

  ngOnInit(): void {
    this.getHeroes();
  }
  constructor(private heroService: HeroService){}
  hero: Hero = {
    id: 1,
    name: 'Windstorm'
  };
  heroes:Hero[];
  selectedHero: Hero;
  onSelect(hero : Hero): void{
    this.selectedHero = hero;
  }
  getHeroes():void{
    this.heroService.getHeroes().then(
      heroes => this.heroes = heroes
    );
  }
}
