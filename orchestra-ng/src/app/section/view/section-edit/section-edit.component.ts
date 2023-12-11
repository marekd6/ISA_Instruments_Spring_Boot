import { Component, OnInit } from '@angular/core';
import { SectionService } from '../../service/section.service';
import { ActivatedRoute, Router } from '@angular/router';
import { SectionForm } from '../../model/section-form';

@Component({
  selector: 'app-section-edit',
  templateUrl: './section-edit.component.html'
  //,styleUrls: ['./section-edit.component.css']
})
export class SectionEditComponent implements OnInit {

  /**
   * Character's id.
   */
  id: string | undefined;
  id2: string | undefined;

  /**
   * Single character.
   */
  section: SectionForm | undefined;

  /**
   * Single character.
   */
  original: SectionForm | undefined;

  newid: string | undefined;


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
    this.route.params.subscribe(params => {

      this.sectionService.getSection(params['id'])
        .subscribe(section => {
          this.id = section.id;
          this.section = {
            name: section.name,
            volume: section.volume,
            location: section.location
            ,id: section.id// TODO
          };
          this.original = {...this.section};
        });

      // this.sectionService.getNewId().subscribe(id => this.newid=id.id);
      this.newid = this.sectionService.getID();

      if (this.id==undefined) {
        this.id = this.newid;
        var param = params['id'];
        this.id = param;
        // this.section?.id = param;
      }

    });
  }

  /**
   * Updates character.
   */
  onSubmit(): void {
    // this.sectionService.createSection(this.id!, this.section!);

    this.sectionService.createSection(this.id!, this.section!)
      .subscribe(() => this.router.navigate(['/sections', this.id!]));
  }

}
