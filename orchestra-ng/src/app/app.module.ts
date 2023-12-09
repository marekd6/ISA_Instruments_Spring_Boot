import {NgModule} from "@angular/core";
import {InstrumentsListComponent} from "./instrument/view/instruments-list/instruments-list.component";
import {InstrumentService} from "./instrument/service/instrument.service";
import {SectionService} from "./section/service/section.service";
import {InstrumentViewComponent} from "./instrument/view/instrument-view/instrument-view.component";
import {FormsModule} from "@angular/forms";
import {SectionListComponent} from "./section/view/section-list/section-list.component";
import {MainComponent} from "./component/main/main.component";
import {NavComponent} from "./component/nav/nav.component";
import {HeaderComponent} from "./component/header/header.component";
import {FooterComponent} from "./component/footer/footer.component";
import {AppComponent} from "./app.component";
import {RouterLink} from "@angular/router";
import {HttpClientModule} from "@angular/common/http";
import {AppRoutingModule} from "./app.routes";
import {BrowserModule} from "@angular/platform-browser";
import {SectionViewComponent} from "./section/view/section-view/section-view.component";

@NgModule({
  declarations: [InstrumentsListComponent, InstrumentViewComponent,
    SectionListComponent, SectionViewComponent,
    FooterComponent, HeaderComponent, NavComponent, MainComponent, AppComponent],//AppComponent
  imports: [
/*    FormsModule,
    RouterLink,
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule*/
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule

  ],
  providers: [InstrumentService, SectionService],
  bootstrap: [AppComponent]
})
export class AppModule {

}
