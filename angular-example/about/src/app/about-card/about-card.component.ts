import { Component, OnInit, Input } from '@angular/core';

import { SimpleCardField } from './../models/SimpleCardField';

@Component({
  selector: 'la-about-card',
  templateUrl: './about-card.component.html',
  styleUrls: ['./about-card.component.css']
})
export class AboutCardComponent implements OnInit {
   @Input()
   cardField: { name: SimpleCardField, link: SimpleCardField, image: SimpleCardField };


  constructor() { }

  ngOnInit() {
  }

}
