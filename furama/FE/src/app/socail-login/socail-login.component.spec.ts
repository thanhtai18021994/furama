import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SocailLoginComponent } from './socail-login.component';

describe('SocailLoginComponent', () => {
  let component: SocailLoginComponent;
  let fixture: ComponentFixture<SocailLoginComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SocailLoginComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SocailLoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
