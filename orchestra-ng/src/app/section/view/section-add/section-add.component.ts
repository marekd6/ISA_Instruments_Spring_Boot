import {Component, OnInit} from '@angular/core';
import {SectionService} from '../../service/section.service';
import {ActivatedRoute, Router} from '@angular/router';
import {SectionForm} from '../../model/section-form';

@Component({
  selector: 'app-section-add',
  templateUrl: './section-add.component.html'
  //,styleUrls: ['./section-edit.component.css']
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
    // this.ngOnInit();
    // this.sectionService.getSections().subscribe();
    // this.sectionService.getNewId().subscribe(id => this.id = id.id)

    this.id = this.sectionService.getID();

/*    this.route.params.subscribe(params => {

      this.sectionService.getSection(params['id'])
        .subscribe(section => {
          // this.id = section.id;
          this.sectionService.getNewId().subscribe(id => this.id = id.id)
          this.section = {
            name: section.name,
            volume: section.volume,
            location: section.location
            , id: section.id// TODO
            // , id: this.sectionService.getNewId().subscribe(id => id.id)
          };
          // this.original = {...this.section};
        });
    });*/
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

    // {name: this.name!, volume: this.volume!, location: this.location!, id: this.id!}
    this.sectionService.createSection(this.id!, this.section!)
      .subscribe(() => this.router.navigate(['/sections']));
  }

}
