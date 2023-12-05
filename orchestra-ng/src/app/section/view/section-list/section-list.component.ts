import { Component, OnInit } from '@angular/core';
import { Sections } from "../../model/sections";
import { Section } from "../../model/section";
import { SectionService } from "../../service/section.service";

/**
 * Navigable view with list of all sections.
 */
@Component({
  selector: 'app-section-list',
  templateUrl: './section-list.component.html',
  styleUrls: ['./section-list.component.css']
})
export class SectionListComponent implements OnInit {

  /**
   * @param service sections service
   */
  constructor(private service: SectionService) {
  }

  /**
   * Available sections.
   */
  sections: Sections | undefined;

  ngOnInit(): void {
    this.service.getSections().subscribe(sections => this.sections = sections);
  }

  /**
   * Deletes selected section.
   *
   * @param section section to be removed
   */
  onDelete(section: Section): void {
    this.service.deleteSection(section.id).subscribe(() => this.ngOnInit());
  }

}
