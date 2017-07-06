import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';

import { Observable } from 'rxjs/Observable';

@Injectable()
export class FileService {

  constructor(private http: Http) { }

  asPlainText(url: string): Observable<string> {
     return this.http.get(url).map((response: Response) => response.text());
  }
}
