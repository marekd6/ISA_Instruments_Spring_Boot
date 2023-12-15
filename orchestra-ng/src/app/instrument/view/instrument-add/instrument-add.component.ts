import {Component, OnInit} from '@angular/core';
import {InstrumentService} from '../../service/instrument.service';
import {ActivatedRoute, Router} from '@angular/router';
import {InstrumentForm} from '../../model/instrument-form';

@Component({
    selector: 'app-instrument-add',
    templateUrl: './instrument-add.component.html'
    //,styleUrls: ['./instrument-edit.component.css']
})
export class InstrumentAddComponent implements OnInit {

    /**
     * Character's id.
     */
    id: string | undefined;

    section: string | undefined;
    name: string | undefined;
    production_year: number | undefined;

    /**
     * Single character.
     */
    instrument: InstrumentForm | undefined;

    /**
     * Single character.
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
        // var param = this.route.params.pipe();
        this.route.params.subscribe(params => this.section = params['section']);

        /*    this.route.params.subscribe(params => {

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
            });*/
    }

    /**
     * Updates character.
     */
    onSubmit(): void {

        this.instrument = {
            name: this.name!,
            id: this.id!,
            production_year: this.production_year!,
            section: this.section!
        }

        // 2nd arg was: this.id!
        this.instrumentService.createInstrument(this.section!, this.instrument.id!, this.instrument!)
            .subscribe(() => this.router.navigate(['/sections', this.section!]));
    }

}
