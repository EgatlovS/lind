import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';

import { SimpleCardLinkpoint } from './../../../models/SimpleCardLinkpoint';
import { CardLink } from './../../../models/CardLink';

@Injectable()
export class CardService {

  constructor(private http: Http) { }

  test(): void {
    this.getLinkpoints(13, { cardName: 'CardName', redirectLink: 'RedirectLink', image: 'Image' }).subscribe(
      data => console.log('Data', JSON.stringify(data)),
      err => console.log('Error', err)
    );
  }

  getLinkpoints(structureId: number, fields: { cardName: string, redirectLink: string, image: string }): Observable<SimpleCardLinkpoint[]> {
    return this.http.get('http://localhost:8080/api/structures/' + structureId + '/links')
      .map((response: Response) => this.mapToSimpleCardLinkpoints(response, fields));
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
