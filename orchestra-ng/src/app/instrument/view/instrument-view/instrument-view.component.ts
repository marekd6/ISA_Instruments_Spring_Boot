import { Component, OnInit } from '@angular/core';
import { InstrumentService } from "../../service/instrument.service";
import { ActivatedRoute, Router } from "@angular/router";
import { InstrumentDetails } from "../../model/instrument-details";

/**
 * Preview of an Instrument.
 */
@Component({
  selector: 'app-instrument-view',
  templateUrl: './instrument-view.component.html',
  styleUrls: ['./instrument-view.component.css']
})
export class InstrumentViewComponent implements OnInit {

  /**
   * Single character.
   */
  instrument: InstrumentDetails | undefined;

  /**
   *
   * @param service character service
   * @param route activated route
   * @param router router
   */
  constructor(private service: InstrumentService, private route: ActivatedRoute, private router: Router) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.service.getInstrument(params['id'])
        .subscribe(instrument => this.instrument = instrument)
    });
  }

}
