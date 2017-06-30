import { Component, OnInit } from '@angular/core';


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

  constructor() { }

  ngOnInit() {
    // TODO: Init values by getting the structure/linkpoint from the server
    this.values.push({title: 'How to navbar', content: 'Tutorial Anleitung'});
    this.values.push({title: 'How to Dynamic Components', content: 'Tutorial'});
  }

}
