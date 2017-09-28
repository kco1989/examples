// /**
//  * Created by 666666 on 2017/9/27.
//  */
// import {Component, Input} from '@angular/core'
// import {Hero} from './hero';
//
// @Component({
//   selector:'hero-detail',
//   template:`
//       <div *ngIf="hero">
//         <h2>{{hero.name}} details!</h2>
//         <div><label>id: </label>{{hero.id}}</div>
//         <div>
//             <label>name: </label>
//             <input [(ngModel)]="hero.name" placeholder="name">
//         </div>
//     </div>
//   `
// })
// export class HeroDetailComponent{
//   @Input() hero:Hero
// }
import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { Location }                 from '@angular/common';

import { HeroService } from './hero.service';
import 'rxjs/add/operator/switchMap';
import {Hero} from "./hero";

@Component({
  selector:'hero-detail',
  templateUrl: './hero-detail.component.html'
})
export class HeroDetailComponent implements OnInit{
  ngOnInit(): void {
    this.route.paramMap.switchMap((params: ParamMap) =>
      this.heroService.getHero(+params.get("id")))
      .subscribe(hero => this.hero = hero);
  }
  constructor(
    private heroService: HeroService,
    private route: ActivatedRoute,
    private location: Location
  ){}
  goBack():void{
      this.location.back();
  }
  @Input() hero: Hero;
}
