import { Component, OnInit } from '@angular/core';
import { InstrumentService } from '../../service/instrument.service';
import { ActivatedRoute, Router } from '@angular/router';
import { InstrumentForm } from '../../model/instrument-form';
import {SectionService} from "../../../section/service/section.service";
import {Sections} from "../../../section/model/sections";

@Component({
  selector: 'app-instrument-edit',
  templateUrl: './instrument-edit.component.html',
  styleUrls: ['./instrument-edit.component.css']
})
export class InstrumentEditComponent implements OnInit {

  /**
   * Instrument's id.
   */
  id: string | undefined;

  /**
   * Section's ID
   */
  section: string | undefined;

  /**
   * Single instrument.
   */
  instrument: InstrumentForm | undefined;

  /**
   * Single instrument.
   */
  original: InstrumentForm | undefined;

  /**
   * Available sections.
   */
  sections: Sections | undefined;

  /**
   * @param instrumentService instrument service
   * @param sectionService section service
   * @param route activated route
   * @param router router
   */
  constructor(
    private instrumentService: InstrumentService,
    private sectionService: SectionService,
    private route: ActivatedRoute,
    private router: Router
  ) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.sectionService.getSections()
        .subscribe(sections => this.sections = sections);

      this.instrumentService.getInstrument(this.section, this.id)
        .subscribe(instrument => {
          this.id = instrument.id;
          this.instrument = {
            id: instrument.id, // sth extra
            name: instrument.name,
            production_year: instrument.production_year,
            section: instrument.section.id
          };
          this.original = {...this.instrument};
        });
    });
  }

  /**
   * Updates an Instrument.
   */
  onSubmit(): void {
    this.instrumentService.createInstrument(this.id!, this.instrument!)
      .subscribe(() => this.router.navigate(['/instruments']));
  }

}
