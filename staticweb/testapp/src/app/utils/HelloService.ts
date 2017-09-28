import {Hero} from "./Hero";
import {Injectable} from "@angular/core";
import {Http} from "@angular/http";
import 'rxjs/add/operator/toPromise';
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
  headers: any;

  constructor(private http: Http){}

  private heroesUrl = 'api/heroes';
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

  getHero(id: number):Promise<Hero> {
    return this.getHerosPromise().then(heroes => heroes.find(hero => hero.id === id))
  }
  getHeroesHttp():Promise<Hero[]>{
    return this.http.get(this.heroesUrl).toPromise()
      .then(response => response.json().data as Hero[])
      .catch(this.handleError);
  }
  getHeroHttp(id: number):Promise<Hero>{
    const  url = `${this.heroesUrl}/${id}`;
    return this.http.get(url).toPromise()
      .then(response => response.json().data as Hero)
      .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }

  update(hero: Hero):Promise<Hero> {
     const url = `${this.heroesUrl}/${hero.id}`;
     return this.http.put(url, JSON.stringify(hero), {
       headers: this.headers
     }).toPromise()
       .then(() => hero)
       .catch(this.handleError);
  }

  create(name: string):Promise<Hero> {
    return this.http.post(this.heroesUrl, JSON.stringify({
      name: name
    }), {headers: this.headers}).toPromise()
      .then(res => res.json().data as Hero)
      .catch(this.handleError);
  }

  delete(id: number):Promise<void> {
    const url = `${this.heroesUrl}/${id}`;
    return this.http.delete(url, {headers: this.headers})
      .toPromise()
      .then(() => null)
      .catch(this.handleError);
  }
}
