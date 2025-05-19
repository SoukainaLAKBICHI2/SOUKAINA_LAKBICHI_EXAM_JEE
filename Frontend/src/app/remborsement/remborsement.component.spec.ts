import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RemborsementComponent } from './remborsement.component';

describe('RemborsementComponent', () => {
  let component: RemborsementComponent;
  let fixture: ComponentFixture<RemborsementComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RemborsementComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RemborsementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
