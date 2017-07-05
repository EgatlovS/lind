import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { LindNavbarModule } from 'lind-navbar-plugin/index';

import { CoreModule } from './core/core.module';
import { AppComponent } from './app.component';
import { AboutCardComponent } from './about-card/about-card.component';

@NgModule({
  declarations: [
    AppComponent,
    AboutCardComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    CoreModule,

    LindNavbarModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
