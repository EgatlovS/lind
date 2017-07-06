import { Component, OnInit } from '@angular/core';

import { FileService } from './core/services/file/file.service';
import { PanelContent } from './models/PanelContent';

@Component({
  selector: 'lg-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  structureId = 1;
  fieldNames = { tabname: 'TabName', applicationLink: 'ApplicationLink' };

  content = {
               setupLind: new PanelContent(),
               structCreation: new PanelContent(),
               linkCreation: new PanelContent(),
               setupAngular: new PanelContent()
            };

  constructor(private fileService: FileService) { }

  ngOnInit(): void {
     this.content.setupLind.name = 'Setup lind-rs';
     this.content.structCreation.name = 'Structure Creation';
     this.content.linkCreation.name = 'Link Creation';
     this.content.setupAngular.name = 'Setup Angular Example';

     this.fileService.asPlainText('assets/panel-content/setup-lind.txt').subscribe(
       data => this.content.setupLind.value = data,
       err => console.log('Err:', err)
     );
     this.fileService.asPlainText('assets/panel-content/structure-creation.txt').subscribe(
       data => this.content.structCreation.value = data,
       err => console.log('Err:', err)
     );
     this.fileService.asPlainText('assets/panel-content/link-creation.txt').subscribe(
       data => this.content.linkCreation.value = data,
       err => console.log('Err:', err)
     );
     this.fileService.asPlainText('assets/panel-content/setup-angular.txt').subscribe(
        data => this.content.setupAngular.value = data,
        err => console.log('Err:', err)
     );
  }
}
