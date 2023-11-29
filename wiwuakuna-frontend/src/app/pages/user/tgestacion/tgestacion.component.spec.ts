import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TgestacionComponent } from './tgestacion.component';

describe('TgestacionComponent', () => {
  let component: TgestacionComponent;
  let fixture: ComponentFixture<TgestacionComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TgestacionComponent]
    });
    fixture = TestBed.createComponent(TgestacionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
