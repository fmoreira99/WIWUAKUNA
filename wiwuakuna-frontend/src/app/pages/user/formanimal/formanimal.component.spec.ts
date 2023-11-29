import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormanimalComponent } from './formanimal.component';

describe('FormanimalComponent', () => {
  let component: FormanimalComponent;
  let fixture: ComponentFixture<FormanimalComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FormanimalComponent]
    });
    fixture = TestBed.createComponent(FormanimalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
