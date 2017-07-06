import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { CoreModule } from './core/core.module';
import { MarkdownModule } from 'angular2-markdown';
import { LindNavbarModule } from 'lind-navbar-plugin/index';
import { AppComponent } from './app.component';
import { MarkdownPanelComponent } from './markdown-panel/markdown-panel.component';

@NgModule({
  declarations: [
    AppComponent,
    MarkdownPanelComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,

    CoreModule,
    LindNavbarModule,
    MarkdownModule.forRoot()
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
