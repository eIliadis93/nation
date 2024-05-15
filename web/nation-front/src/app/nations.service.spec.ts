import { TestBed } from '@angular/core/testing';

import { NationsService } from './services/nations.service';

describe('NationsService', () => {
  let service: NationsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(NationsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
