import { Component, OnInit } from '@angular/core';
import { InstrumentService } from "../../service/instrument.service";
import { Instruments } from "../../model/instruments";
import { Instrument } from "../../model/instrument";

@Component({
  selector: 'app-instrument-list',
  templateUrl: './instruments-list.component.html',
  styleUrls: ['./instruments-list.component.css']
})
export class InstrumentsListComponent implements OnInit{

  /**
   * @param service instruments service
   */
  constructor(private service: InstrumentService) {
  }

  /**
   * Available instruments.
   */
  instruments: Instruments | undefined;

  ngOnInit(): void {
    this.service.getInstruments().subscribe(instruments => this.instruments = instruments);
  }

  /**
   * Deletes selected instrument.
   *
   * @param instrument instrument to be removed
   */
  onDelete(instrument: Instrument): void {
    this.service.deleteInstrument(instrument.id).subscribe(() => this.ngOnInit());
  }

}
