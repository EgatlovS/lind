import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';

import { SimpleCardLinkpoint } from './../../../models/SimpleCardLinkpoint';
import { SimpleCardField } from './../../../models/SimpleCardField';
import { CardLink } from './../../../models/CardLink';

@Injectable()
export class CardService {

  constructor(private http: Http) { }


  getLinkpoints(structureId: number, fields: { cardName: string, redirectLink: string, image: string }): Observable<SimpleCardLinkpoint[]> {
    return this.http.get('http://localhost:8080/api/structures/' + structureId + '/links')
      .map((response: Response) => this.mapToSimpleCardLinkpoints(response, fields));
  }

  getField(url: string): Observable<SimpleCardField> {
    return this.http.get(url)
      .map((response: Response) => this.mapToSimpleCardField(response));
  }

  private mapToSimpleCardField(response: Response): SimpleCardField {
     const data = response.json();
     const simpleField = new SimpleCardField();
     simpleField.id = data.id;
     simpleField.name = data.name;
     simpleField.value = data.value;

     return simpleField;
  }

  private mapToSimpleCardLinkpoints(response: Response, fields: { cardName: string, redirectLink: string, image: string }): SimpleCardLinkpoint[] {
    const values = response.json();
    const linkpoints: SimpleCardLinkpoint[] = [];
    for (const value of values) {
      const linkpoint = new SimpleCardLinkpoint();
      linkpoint.id = value.id;
      linkpoint.name = value.name;
      for (const field of value._links) {
        if (field.params.rel === fields.cardName) {
          const link = new CardLink();
          link.params = field.params;
          link.href = field.href;
          linkpoint.cardName = link;
        } else if (field.params.rel === fields.redirectLink) {
          const link = new CardLink();
          link.params = field.params;
          link.href = field.href;
          linkpoint.redirectLink = link;
        } else if (field.params.rel === fields.image) {
          const link = new CardLink();
          link.params = field.params;
          link.href = field.href;
          linkpoint.image = link;
        }
      }
      linkpoints.push(linkpoint);
    }

    return linkpoints;
  }
}
