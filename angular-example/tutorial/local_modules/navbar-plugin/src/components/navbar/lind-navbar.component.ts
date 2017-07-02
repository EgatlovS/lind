import { Component, Input, OnInit } from '@angular/core';

import { NavbarService } from './../../services/navbar.service';
import { SimpleNavbarLinkpoint } from './../../models/SimpleNavbarLinkpoint';
import { SimpleNavbarField } from './../../models/SimpleNavbarField';

@Component({
  selector: 'lind-navbar',
  templateUrl: 'lind-navbar.component.html',
  styleUrls: ['lind-navbar.component.css']
})
export class LindNavbarComponent implements OnInit {
  @Input()
  structureId: number;

  @Input()
  fieldNames: { tabname: string, applicationLink: string };

  fields: { tabname: SimpleNavbarField, applicationLink: SimpleNavbarField }[] = [];

  constructor(private navbarService: NavbarService) { }

  ngOnInit(): void {
    this.navbarService.getLinkpoints(this.structureId, this.fieldNames).subscribe(
      data => data.forEach((linkpoint) => this.getField(linkpoint)),
      err => console.log('Error', err)
    );
  }

  private getField(linkpoint: SimpleNavbarLinkpoint): void {
    const field = { tabname: undefined, applicationLink: undefined };
    console.log(JSON.stringify(field));

    this.navbarService.getField(linkpoint.tabNameLink.href).subscribe(
      data => {
        field.tabname = data;
        if (field.applicationLink) { this.fields.push(field); }
      },
      err => console.log('Error:', err)
    );

    this.navbarService.getField(linkpoint.applicationLink.href).subscribe(
      data => {
        field.applicationLink = data;
        if (field.tabname) { this.fields.push(field); }
      },
      err => console.log('Error:', err)
    );
  }
}
