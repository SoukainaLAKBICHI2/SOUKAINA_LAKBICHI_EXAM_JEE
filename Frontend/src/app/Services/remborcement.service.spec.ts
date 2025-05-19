import { TestBed } from '@angular/core/testing';

import { RemborcementService } from './remborcement.service';

describe('RemborcementService', () => {
  let service: RemborcementService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RemborcementService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
