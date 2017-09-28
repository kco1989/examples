import {Injectable} from "@angular/core";
import {Hero} from "../utils/Hero";
import {Observable} from "rxjs";
import {Http} from "@angular/http";

@Injectable()
export class HeroSearchService {
  constructor(private http: Http) {}

  search(term: string): Observable<Hero[]> {
    return this.http
      .get(`api/heroes/?name=${term}`)
      .map(response => response.json().data as Hero[]);
  }
}

