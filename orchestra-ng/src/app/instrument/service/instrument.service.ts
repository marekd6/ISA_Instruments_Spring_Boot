import {Instruments} from "../model/instruments";
import {InstrumentDetails} from "../model/instrument-details";
import {InstrumentForm} from "../model/instrument-form";
import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Newid} from "../../section/model/newid";

/**
 * Service for Instrument
 */
@Injectable()
export class InstrumentService {

    idd: String | undefined;

  /**
   * a constructor
   * @param http
   */
  constructor(private http: HttpClient) {

  }

  /**
   * Get all Instruments
   * @return list of Instruments
   */
  getInstruments(): Observable<Instruments> {
    return this.http.get<Instruments>('/api/instruments');
  }

  getInstrumentsFromSection(idd: string | undefined): Observable<Instruments> {
    if (idd == undefined){
     return this.getInstruments();
    }
    else {
      return this.http.get<Instruments>('/api/sections/' + idd + '/instruments');
    }
  }

  /**
   * Get an Instrument
   * @return details of an Instrument
   * @param section
   * @param id
   */
  getInstrument(section: string, id: string): Observable<InstrumentDetails> {
    return this.http.get<InstrumentDetails>('/api/sections/' + section + '/instruments/' + id);
  }

  /**
   * Delete an Instrument
   * @param id Instrument's ID
   */
  deleteInstrument(id: string): Observable<any> {
    return this.http.delete('/api/instruments/' + id);
  }

  /**
   * Update an Instrument
   * @param section
   * @param id Instrument's ID
   * @param dto DTO with Instrument's details
   */
  createInstrument(section: string, id: string, dto: InstrumentForm): Observable<any> {
    return this.http.put('/api/sections/' + section + '/instruments/' + id, dto);
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
