import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Sections } from "../model/sections";

/**
 * Section management service. Calls REST endpoints.
 */
@Injectable()
export class SectionService {

  /**
   * @param http HTTP client
   */
  constructor(private http: HttpClient) {

  }

  /**
   * Fetches all Sections.
   *
   * @return list of Sections
   */
  getSections(): Observable<Sections> {
    return this.http.get<Sections>('/api/sections');
  }

  /**
   * Removes single user.
   *
   * @param uuid user's id
   */
  deleteSection(uuid: string): Observable<any> {
    return this.http.delete('/api/sections/' + uuid);
  }

}
