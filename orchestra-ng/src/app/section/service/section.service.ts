import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Sections } from "../model/sections";
import {Section} from "../model/section";
import {SectionDetails} from "../model/section-details";

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

  /**
   * Get a Section
   * @param id Section's ID
   * @return details of a Section with a list of its Instruments
   */
  getSection(id: string): Observable<SectionDetails> {
    //this.http.get('/api/sections/' + id + '/instruments');
    return this.http.get<SectionDetails>('/api/sections/' + id);
  }

}
