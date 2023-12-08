import {RouterModule, Routes} from '@angular/router';
import {NgModule} from "@angular/core";
import {InstrumentViewComponent} from "./instrument/view/instrument-view/instrument-view.component";
import {InstrumentsListComponent} from "./instrument/view/instruments-list/instruments-list.component";
import {InstrumentEditComponent} from "./instrument/view/instrument-edit/instrument-edit.component";
import {SectionListComponent} from "./section/view/section-list/section-list.component";
import {SectionViewComponent} from "./section/view/section-view/section-view.component";

export const routes: Routes = [
  {
    component: SectionListComponent,
    path: "sections"
  },
  {
    component: SectionViewComponent,//
    path: "sections/:id"
  },
  {
    component: InstrumentsListComponent,
    path: "instruments"
  },
  {
    component: InstrumentViewComponent,
    path: "instruments/:id"
  }
  ,
  {
    component: InstrumentEditComponent,
    path: "instruments/:id/edit"
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
