import {RouterModule, Routes} from '@angular/router';
import {NgModule} from "@angular/core";
import {InstrumentViewComponent} from "./instrument/view/instrument-view/instrument-view.component";
import {SectionListComponent} from "./section/view/section-list/section-list.component";
import {SectionViewComponent} from "./section/view/section-view/section-view.component";
import {SectionEditComponent} from "./section/view/section-edit/section-edit.component";
import {InstrumentEditComponent} from "./instrument/view/instrument-edit/instrument-edit.component";
import {SectionAddComponent} from "./section/view/section-add/section-add.component";
import {InstrumentAddComponent} from "./instrument/view/instrument-add/instrument-add.component";

export const routes: Routes = [
  {
    component: SectionListComponent,
    path: "sections"
  },
  {
    component: SectionViewComponent,
    path: "sections/:id"
  },
  {
    component: SectionEditComponent,
    path: "sections/:id/edit"
  },
  {
    component: SectionAddComponent,
    path: "sections/:id/add"
  },
  {
    component: InstrumentViewComponent,
    path: "sections/:section/instruments/:id"
  },
  {
    component: InstrumentEditComponent,
    path: "sections/:section/instruments/:id/edit"
  },
  {
    component: InstrumentAddComponent,
    path: "sections/:section/instruments/:id/add"
  }
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
