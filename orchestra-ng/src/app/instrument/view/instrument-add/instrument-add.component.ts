import {Component, OnInit} from '@angular/core';
import {InstrumentService} from '../../service/instrument.service';
import {ActivatedRoute, Router} from '@angular/router';
import {InstrumentForm} from '../../model/instrument-form';

@Component({
    selector: 'app-instrument-add',
    templateUrl: './instrument-add.component.html'
})
export class InstrumentAddComponent implements OnInit {

    /**
     * Instrument's id.
     */
    id: string | undefined;

    section: string | undefined;
    name: string | undefined;
    production_year: number | undefined;

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

        this.id = this.instrumentService.getID();
        this.route.params.subscribe(params => this.section = params['section']);
    }

    /**
     * Updates Instrument.
     */
    onSubmit(): void {

        this.instrument = {
            name: this.name!,
            id: this.id!,
            production_year: this.production_year!,
            section: this.section!
        }

        this.instrumentService.createInstrument(this.section!, this.instrument.id!, this.instrument!)
            .subscribe(() => this.router.navigate(['/sections', this.section!]));
    }

}
