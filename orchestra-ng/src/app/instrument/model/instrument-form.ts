/**
 * A form for an Instrument
 */
export interface InstrumentForm {

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
  section: string

}
