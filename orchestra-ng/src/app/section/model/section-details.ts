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
