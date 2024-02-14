import {Component, OnInit} from '@angular/core';
import {SectionService} from '../../service/section.service';
import {ActivatedRoute, Router} from '@angular/router';
import {SectionForm} from '../../model/section-form';

@Component({
  selector: 'app-section-add',
  templateUrl: './section-add.component.html'
})
export class SectionAddComponent implements OnInit {

  /**
   * Character's id.
   */
  id: string | undefined;

  volume: number | undefined;

  location: number | undefined;

  name: string | undefined;

  /**
   * Single character.
   */
  section: SectionForm | undefined;

  /**
   * Single character.
   */
  original: SectionForm | undefined;

  /**
   * @param sectionService
   * @param route activated route
   * @param router router
   */
  constructor(
    private sectionService: SectionService,
    private route: ActivatedRoute,
    private router: Router
  ) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => { this.id = params['id']; }); // key change
  }

  /**
   * Updates character.
   */
  onSubmit(): void {

    this.section = {
      name: this.name!,
      volume: this.volume!,
      location: this.location!,
      id: this.id!
    }

    this.sectionService.createSection(this.id!, this.section!)
      .subscribe(() => this.router.navigate(['/sections', this.id!]));
  }

}
