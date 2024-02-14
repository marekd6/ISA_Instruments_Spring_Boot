import {Instrument} from "./instrument";

/**
 * List of Instruments
 */
export interface Instruments {

  /**
   * Description of a collection
   */
  description: string;

  /**
   * Names of the instruments
   */
  instruments: Instrument[];

}
