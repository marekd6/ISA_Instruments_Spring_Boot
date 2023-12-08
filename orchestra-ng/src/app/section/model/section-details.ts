import {Instrument} from "../../instrument/model/instrument";
import {InstrumentDetails} from "../../instrument/model/instrument-details";

/**
 * A Section
 */
export interface SectionDetails {
  /**
   * Section's ID
   */
  id: string;

  /**
   * Section's name
   */
  name: string;

  /**
   * Section's volume
   */
  volume: number;

  /**
   * Section's location
   */
  location: number;

  /**
   * Instruments belonging to the Section
   */
  // instruments: InstrumentDetails[] może jednak nie, bo component instr-list

}
