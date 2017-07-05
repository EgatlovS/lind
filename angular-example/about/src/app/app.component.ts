import { Component, OnInit } from '@angular/core';

import { CardService } from './core/services/cards/card.service';
import { SimpleCardField } from './models/SimpleCardField';

@Component({
  selector: 'la-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  structureId = 1;
  fieldNames = { tabname: 'TabName', applicationLink: 'ApplicationLink' };

  cardFields: { name: SimpleCardField, link: SimpleCardField, image: SimpleCardField }[] = [];
  constructor(private cardService: CardService) {

  }

  ngOnInit(): void {
    this.cardService.getLinkpoints(13, { cardName: 'CardName', redirectLink: 'RedirectLink', image: 'Image' }).subscribe(
      data => {
        for (const element of data) {
          const field = { name: undefined, link: undefined, image: undefined };
          this.cardService.getField(element.cardName.href).subscribe(
            nameField => field.name = nameField,
            err => console.log('Error:', err)
          );
          this.cardService.getField(element.redirectLink.href).subscribe(
            linkField => field.link = linkField,
            err => console.log('Error:', err)
          );
          this.cardService.getField(element.image.href).subscribe(
            imageField => field.image = imageField,
            err => console.log('Error:', err)
          );
          this.cardFields.push(field);
        }
      },
      err => console.log('Error', err)
    );
  }
}
