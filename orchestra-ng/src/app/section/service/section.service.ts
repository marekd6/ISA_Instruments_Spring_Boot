import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Sections} from "../model/sections";
import {SectionDetails} from "../model/section-details";
import {SectionForm} from '../model/section-form';
import {Newid} from "../model/newid";


/**
 * Section management service. Calls REST endpoints.
 */
@Injectable()
export class SectionService {

  idd: String | undefined;

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
   * Removes single section.
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
  getSection(id: string | undefined): Observable<SectionDetails> {
    //this.http.get('/api/sections/' + id + '/instruments');
    return this.http.get<SectionDetails>('/api/sections/' + id);
  }

  /**
   * Create/Update a Section
   * @param id
   * @param section
   */
  createSection(id: string, section: SectionForm): Observable<any> {
    return this.http.put('/api/sections/' + id, section);
  }

  getNewId(): Observable<Newid> {
    let temp = this.http.get<Newid>('api/sections/newid');
    temp.subscribe(id => this.idd = id.id);
    return temp;
  }

  getID(): any {
    return this.idd;
  }

}
