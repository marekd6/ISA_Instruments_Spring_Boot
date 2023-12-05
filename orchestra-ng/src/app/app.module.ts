import {NgModule} from "@angular/core";
import {InstrumentsListComponent} from "./instrument/view/instruments-list/instruments-list.component";
import {InstrumentService} from "./instrument/service/instrument.service";
import {SectionService} from "./section/service/section.service";
import {InstrumentViewComponent} from "./instrument/view/instrument-view/instrument-view.component";
import {InstrumentEditComponent} from "./instrument/view/instrument-edit/instrument-edit.component";
import {FormsModule} from "@angular/forms";
import {SectionListComponent} from "./section/view/section-list/section-list.component";

@NgModule({
  declarations: [InstrumentsListComponent, InstrumentViewComponent, InstrumentEditComponent,
    SectionListComponent],
  imports: [
    FormsModule
  ],
  providers: [InstrumentService, SectionService]
})
export class AppModule {

}
