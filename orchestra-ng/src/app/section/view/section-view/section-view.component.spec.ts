import {ComponentFixture, TestBed} from '@angular/core/testing';

import {SectionViewComponent} from './section-view.component';

describe('InstrumentViewComponent', () => {
  let component: SectionViewComponent;
  let fixture: ComponentFixture<SectionViewComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SectionViewComponent]
    });
    fixture = TestBed.createComponent(SectionViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
