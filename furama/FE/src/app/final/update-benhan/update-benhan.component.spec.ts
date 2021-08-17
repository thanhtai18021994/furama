import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateBenhanComponent } from './update-benhan.component';

describe('UpdateBenhanComponent', () => {
  let component: UpdateBenhanComponent;
  let fixture: ComponentFixture<UpdateBenhanComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpdateBenhanComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateBenhanComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
