import { Instruments } from "../model/instruments";
import { InstrumentDetails } from "../model/instrument-details";
import { InstrumentForm } from "../model/instrument-form";
import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

/**
 * Service for Instrument
 */
@Injectable()
export class InstrumentService {

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
   * @param id Instrument's ID
   * @return details of an Instrument
   */
  getInstrument(id: string): Observable<InstrumentDetails> {
    return this.http.get<InstrumentDetails>('/api/instruments/' + id);
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
   * @param id Instrument's ID
   * @param dto DTO with Instrument's details
   */
  createInstrument(id: string, dto: InstrumentForm): Observable<any> {
    return this.http.put('/api/instruments/' + id, dto);
  }

}
