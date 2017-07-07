import { Component, OnInit } from '@angular/core';

import { FileService } from './../core/services/file/file.service';


/*
 * Displays a list of panels that each resemble a tutorial
 * A panel is represented by the 'topic-panel.component'
 */
@Component({
  selector: 'lt-tutorial',
  templateUrl: './tutorial.component.html',
  styleUrls: ['./tutorial.component.css']
})
export class TutorialComponent implements OnInit {

  // Tutorials displayed
  values: { title: string, content: string }[] = [];

  constructor(private fileService: FileService) { }

  ngOnInit() {
    // TODO: Init values by getting the structure/linkpoint from the server
    this.values.push({title: 'How to navbar', content: undefined});
    this.values.push({title: 'How to Dynamic Components', content: undefined});

    this.fileService.asPlainText('assets/tutorials/how-to-navbar.txt').subscribe(
      data => this.values[0].content = data,
      err => console.log('Err', err)
   );
  }
}
