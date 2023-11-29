import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TanimalComponent } from './tanimal.component';

describe('TanimalComponent', () => {
  let component: TanimalComponent;
  let fixture: ComponentFixture<TanimalComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TanimalComponent]
    });
    fixture = TestBed.createComponent(TanimalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
