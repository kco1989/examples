import {Component, Input, OnInit} from '@angular/core';
import {Hero} from "../utils/Hero";
import {HeroService} from "../utils/HelloService";
import {ActivatedRoute, ParamMap} from "@angular/router";
import {Location} from "@angular/common";
import 'rxjs/add/operator/switchMap';

@Component({
  selector: 'hero-detail',
  templateUrl: './hero-detail.component.html',
})
export class HeroDetailComponent implements OnInit{
  ngOnInit(): void {
    this.route.paramMap.switchMap((params: ParamMap) =>
      this.heroService.getHero(+params.get('id')))
      .subscribe(hero => this.hero = hero);
  }
  constructor(private heroService: HeroService,
              private route: ActivatedRoute,
              private location: Location) {
  }
  goBack(): void{
    this.location.back();
  }
  @Input() hero: Hero
}
