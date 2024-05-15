import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GdpComponent } from './gdp.component';

describe('GdpComponent', () => {
  let component: GdpComponent;
  let fixture: ComponentFixture<GdpComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GdpComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GdpComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
