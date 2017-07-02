import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';

import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';

import { NavbarLink } from './../models/NavbarLink';
import { SimpleNavbarField } from './../models/SimpleNavbarField';
import { SimpleNavbarLinkpoint } from './../models/SimpleNavbarLinkpoint';


@Injectable()
export class NavbarService {
  constructor(private http: Http) { }

  getLinkpoints(structureId: number, fieldNames: {tabname: string, applicationLink: string}): Observable<SimpleNavbarLinkpoint[]> {
    return this.http.get('http://localhost:8080/api/structures/' + structureId + '/links')
      .map((response: Response) => this.mapToLinkpoints(response, fieldNames));
  }

  getField(url: string): Observable<SimpleNavbarField> {
    return this.http.get(url)
      .map((response: Response) => this.mapToField(response));
  }

  // workWithTheLinks(simpleLinkpoints: SimpleNavbarLinkpoint[]): void {
  //   for (const simpleLinkpoint of simpleLinkpoints) {
  //     this.getField(simpleLinkpoint.tabNameLink.href).subscribe(
  //       data => console.log('TabName:', JSON.stringify(data)),
  //       err => console.log('Error at tab')
  //     );
  //     this.getField(simpleLinkpoint.applicationLink.href).subscribe(
  //       data => console.log('TabName:', JSON.stringify(data)),
  //       err => console.log('Error at tab')
  //     );
  //   }
  // }

  private mapToLinkpoints(response: Response, fieldNames: {tabname: string, applicationLink: string}) {
    const linkpoints: SimpleNavbarLinkpoint[] = [];
    for (const linkpoint of response.json()) {
      const navbarLinkpoint = new SimpleNavbarLinkpoint();
      for (const link of linkpoint._links) {
        if (link.params.rel === fieldNames.tabname) {
          const navbarLink = new NavbarLink(link.params, link.href);
          navbarLinkpoint.tabNameLink = navbarLink;
       } else if (link.params.rel === fieldNames.applicationLink) {
          const navbarLink = new NavbarLink(link.params, link.href);
          navbarLinkpoint.applicationLink = navbarLink;
        }
      }
      linkpoints.push(navbarLinkpoint);
    }
    return linkpoints;
  }

  private mapToField(response: Response): SimpleNavbarField {
    const field = response.json();
    const simpleField = new SimpleNavbarField();

    simpleField.id = field.id;
    simpleField.name = field.name;
    simpleField.value = field.value;

    return simpleField;
  }
}
