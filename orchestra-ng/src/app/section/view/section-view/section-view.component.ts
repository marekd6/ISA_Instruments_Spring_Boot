import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from "@angular/router";
import { SectionDetails } from "../../model/section-details";
import {SectionService} from "../../service/section.service";

/**
 * Preview of an Instrument.
 */
@Component({
  selector: 'app-section-view',
  templateUrl: './section-view.component.html',
  styleUrls: ['./section-view.component.css']
})
export class SectionViewComponent implements OnInit {

  /**
   * A section.
   */
  section: SectionDetails | undefined;

  /**
   *
   * @param service section service
   * @param route activated route
   * @param router router
   */
  constructor(private service: SectionService, private route: ActivatedRoute, private router: Router) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.service.getSection(params['id'])
        .subscribe(section => this.section = section)
    });
  }

  onDelete(section: SectionDetails) {
    this.service.deleteSection(section.id).subscribe(() => this.ngOnInit());
  }
}
