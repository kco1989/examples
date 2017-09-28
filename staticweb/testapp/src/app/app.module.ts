import {BrowserModule} from '@angular/platform-browser';
import {FormsModule} from '@angular/forms';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {HeroDetailComponent} from "./detail/hero-detail.component";
import {HeroService} from "./utils/HelloService";
import {HeroesComponent} from "./heroes/heroes.component";
import {RouterModule} from "@angular/router";
import {DashboardComponent} from "./dashboard/dashboard.component";

@NgModule({
  imports: [
    BrowserModule,
    FormsModule,
    RouterModule.forRoot([{
      path: '',
      redirectTo: '/dashboard',
      pathMatch: 'full'
    },{
      path: 'dashboard',
      component: DashboardComponent
    },{
      path: 'heroes',
      component: HeroesComponent
    },{
      path: 'detail/:id',
      component: HeroDetailComponent
    }])
  ],
  declarations: [
    AppComponent,
    HeroDetailComponent,
    HeroesComponent,
    DashboardComponent
  ],
  providers: [HeroService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
