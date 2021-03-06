import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import {DisplayComponent} from "./display/display.component";
import {FormsModule} from "@angular/forms";
import {FormComponent} from "./form/form.component";
import { jqxBarGaugeComponent } from 'jqwidgets-framework/jqwidgets-ts/angular_jqxbargauge';
@NgModule({
  declarations: [
    AppComponent,
    DisplayComponent,
    FormComponent,
    jqxBarGaugeComponent
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
