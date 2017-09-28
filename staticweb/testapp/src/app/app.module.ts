import {BrowserModule} from "@angular/platform-browser";
import {FormsModule} from "@angular/forms";
import {NgModule} from "@angular/core";

import {AppComponent} from "./app.component";
import {HeroDetailComponent} from "./detail/hero-detail.component";
import {HeroService} from "./utils/HelloService";
import {HeroesComponent} from "./heroes/heroes.component";
import {DashboardComponent} from "./dashboard/dashboard.component";
import {AppRoutingModule} from "./app-route.module";

@NgModule({
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule
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
