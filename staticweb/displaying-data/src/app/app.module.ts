import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import {DisplayComponent} from "./display/display.component";
import {FormsModule} from "@angular/forms";
import {FormComponent} from "./form/form.component";

@NgModule({
  declarations: [
    AppComponent,
    DisplayComponent,
    FormComponent
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
