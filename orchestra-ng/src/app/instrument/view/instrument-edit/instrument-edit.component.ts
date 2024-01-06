import {Component, OnInit} from '@angular/core';
import {InstrumentService} from '../../service/instrument.service';
import {ActivatedRoute, Router} from '@angular/router';
import {InstrumentForm} from '../../model/instrument-form';

@Component({
  selector: 'app-instrument-edit',
  templateUrl: './instrument-edit.component.html'
})
export class InstrumentEditComponent implements OnInit {

  /**
   * Instrument's id.
   */
  id: string | undefined;

  section: string | undefined;

  /**
   * Single Instrument.
   */
  instrument: InstrumentForm | undefined;

  /**
   * Single Instrument.
   */
  original: InstrumentForm | undefined;

  newid: string | undefined;

  /**
   * @param instrumentService
   * @param route activated route
   * @param router router
   */
  constructor(
    private instrumentService: InstrumentService,
    private route: ActivatedRoute,
    private router: Router
  ) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {

      this.instrumentService.getInstrument(params['section'], params['id'])
        .subscribe(instrument => {
          this.id = instrument.id;
          this.section = instrument.section.id;
          this.instrument = {
            name: instrument.name,
            production_year: instrument.production_year,
            section: instrument.section.id,
            id: instrument.id
          };
          this.original = {...this.instrument};
        });

       this.instrumentService.getNewId().subscribe(id => {this.newid=id.id});
    });
  }

  /**
   * Updates Instrument.
   */
  onSubmit(): void {
    this.instrumentService.createInstrument(this.section!, this.id!, this.instrument!)
      .subscribe(() => this.router.navigate(['/sections', this.section]));
  }

}
