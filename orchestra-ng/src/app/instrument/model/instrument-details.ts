import {Section} from "../../section/model/section";

/**
 * An Instrument with details
 */
export interface InstrumentDetails {

  /**
   * Instrument's ID
   */
  id: string;

  /**
   * Instrument's name
   */
  name: string;

  /**
   * Instrument's production year
   */
  production_year: number;

  /**
   * Section the Instrument belongs to
   */
  section: Section

}
