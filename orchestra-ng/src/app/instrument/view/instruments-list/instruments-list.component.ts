import {Component, OnInit} from '@angular/core';
import {InstrumentService} from "../../service/instrument.service";
import {Instruments} from "../../model/instruments";
import {Instrument} from "../../model/instrument";

@Component({
  selector: 'app-instrument-list',
  templateUrl: './instruments-list.component.html',
  styleUrls: ['./instruments-list.component.css'],
  inputs: ['section']
})
//@Inject(section), private section: string
export class InstrumentsListComponent implements OnInit{

  /**
   * @param service instruments service
   */
  //@Inject(section)
  constructor(private service: InstrumentService) {
  }

  newid: string | undefined;

  section: string | undefined;

  /**
   * Available instruments.
   */
  instruments: Instruments | undefined;

  ngOnInit(): void {
    this.service.getNewId().subscribe(id => this.newid=id.id);

    this.newid = this.service.getID();
    this.service.getInstrumentsFromSection(this.section).subscribe(instruments => this.instruments = instruments);
  }

  ngOnChanges(): void { // responsible for refreshing this nested component
    this.service.getInstrumentsFromSection(this.section).subscribe(instruments => this.instruments = instruments);
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
