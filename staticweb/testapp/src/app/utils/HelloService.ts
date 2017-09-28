import {Hero} from "./Hero";
import {Injectable} from "@angular/core";

/**
 * Created by 666666 on 2017/9/28.
 */
const HEROES: Hero[]=[
  { id: 11, name: 'Mr. Nice' },
  { id: 12, name: 'Narco' },
  { id: 13, name: 'Bombasto' },
  { id: 14, name: 'Celeritas' },
  { id: 15, name: 'Magneta' },
  { id: 16, name: 'RubberMan' },
  { id: 17, name: 'Dynama' },
  { id: 18, name: 'Dr IQ' },
  { id: 19, name: 'Magma' },
  { id: 20, name: 'Tornado' }
];
@Injectable()
export class HeroService{
  getHeros(): Hero[]{
    return HEROES;
  }
  getHerosPromise(): Promise<Hero[]>{
    return Promise.resolve(HEROES);
  }
  getHerosPromiseSlowly(): Promise<Hero[]>{
    return new Promise(resolve => {
      setTimeout(() => resolve(this.getHeros()), 2000);
    });
  }
}
