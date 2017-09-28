/**
 * Created by 666666 on 2017/9/27.
 */
import {Injectable} from '@angular/core';
import {HEROES} from './mock-heroes';
import {Hero} from "./hero";
@Injectable()
export class HeroService {
  getHeroes(): Promise<Hero[]> {
    return Promise.resolve(HEROES);
  }
  getHeroesSlowly(): Promise<Hero[]>{
    return new Promise(resolve => {
      setTimeout(() => resolve(this.getHeroes()), 2000);
    });
  }

  getHero(id: number) {
    return this.getHeroes()
      .then(heroes => heroes.find(hero => hero.id === id));
  }
}
