import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { LindNavbarModule } from 'lind-navbar-plugin/index';

import { AppComponent } from './app.component';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,

    LindNavbarModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
