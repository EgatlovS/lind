import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CardService } from './services/cards/card.service';

@NgModule({
  imports: [
    CommonModule
  ],
  declarations: [],
  providers: [ CardService ]
})
export class CoreModule { }
