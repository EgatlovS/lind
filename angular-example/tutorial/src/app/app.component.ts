import { Component } from '@angular/core';

@Component({
  selector: 'lt-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'lt works!';

  structureId = 1;
  fieldNames = {tabname: 'TabName', applicationLink: 'ApplicationLink'};
}
