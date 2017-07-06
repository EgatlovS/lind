import { Component, OnInit, Input } from '@angular/core';

import { PanelContent } from './../models/PanelContent';

@Component({
  selector: 'lg-markdown-panel',
  templateUrl: './markdown-panel.component.html',
  styleUrls: ['./markdown-panel.component.css']
})
export class MarkdownPanelComponent implements OnInit {

   @Input()
   data: PanelContent;

   @Input()
   panelId: number;

  constructor() { }

  ngOnInit() {
  }

}
