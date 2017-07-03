import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpModule } from '@angular/http';
import { LindNavbarComponent } from './src/components/navbar/lind-navbar.component';

import { NavbarService } from './src/services/navbar.service';

@NgModule({
  declarations: [
    LindNavbarComponent
  ],
  imports: [
     HttpModule,
     BrowserModule
  ],
  exports: [
    LindNavbarComponent
  ],
  providers: [NavbarService]
})
export class LindNavbarModule {

}
