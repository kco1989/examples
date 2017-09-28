
import {Component, OnInit} from '@angular/core';
import {Hero} from "../utils/Hero";
import {HeroService} from "../utils/HelloService";

@Component({
  selector: 'my-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit{
  ngOnInit(): void {
    this.getHeroes();
  }
  constructor(private heroService: HeroService){}
  title = "Tour of Heroes";
  heroes: Hero[];
  getHeroes(){
    this.heroService.getHerosPromise().then(heroes => this.heroes = heroes.slice(0,4));

  }
}




