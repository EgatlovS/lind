import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'lt-topic-panel',
  templateUrl: './topic-panel.component.html',
  styleUrls: ['./topic-panel.component.css']
})
export class TopicPanelComponent implements OnInit {

  @Input()
  value: { title: string, content: string };

  @Input()
  collapsableId = 'collapse1';

  constructor() { }

  ngOnInit() {
  }

}
