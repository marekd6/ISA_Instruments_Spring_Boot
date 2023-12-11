import {RouterModule, Routes} from '@angular/router';
import {NgModule} from "@angular/core";
import {InstrumentViewComponent} from "./instrument/view/instrument-view/instrument-view.component";
import {InstrumentsListComponent} from "./instrument/view/instruments-list/instruments-list.component";
import {SectionListComponent} from "./section/view/section-list/section-list.component";
import {SectionViewComponent} from "./section/view/section-view/section-view.component";
import {SectionEditComponent} from "./section/view/section-edit/section-edit.component";
import {InstrumentEditComponent} from "./instrument/view/instrument-edit/instrument-edit.component";
import {SectionAddComponent} from "./section/view/section-add/section-add.component";

export const routes: Routes = [
  {
    component: SectionListComponent,
    path: "sections"
  },
  { // istotne mapowanie
    component: SectionViewComponent,
    path: "sections/:id"
  },
  { // nowe, istotne, dla edycji
    component: SectionEditComponent,
    path: "sections/:id/edit"
  },
  { // najnowsze, dodawanie sekcji
    component: SectionAddComponent,
    path: "sections/:id/add"
  },
/*  {
    component: InstrumentsListComponent,
    path: "instruments"
  },*/
/*  {
    component: InstrumentViewComponent,
    path: "instruments/:id"
  },*/
  { // dodane poprawne mapowanie przez sekcję
    component: InstrumentViewComponent,
    path: "sections/:section/instruments/:id"
  },
  {
    component: InstrumentEditComponent,
    path: "sections/:section/instruments/:id/edit"
  },
/*  { // dodane poprawne mapowanie przez sekcję
    component: InstrumentEditComponent,
    path: "sections/:ids/instruments/:idi/edit"
  }*/
];


/**
 * Global routing module.
 */
@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule {

}
