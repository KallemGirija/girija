import { TestBed } from '@angular/core/testing';

import { BillingOperationsService } from './billing-operations.service';

describe('BillingOperationsService', () => {
  let service: BillingOperationsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BillingOperationsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
