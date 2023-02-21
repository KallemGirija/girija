import { Component } from '@angular/core';
import { Bill } from '../bill';
import { BillingOperationsService } from '../billing-operations.service';

@Component({
  selector: 'app-admin-work',
  templateUrl: './admin-work.component.html',
  styleUrls: ['./admin-work.component.css']
})
export class AdminWorkComponent 
{

  __billService: BillingOperationsService;

  constructor(billService: BillingOperationsService) {
    this.__billService = billService;
  }

  readBills(
    
    itemCount:string,
	  grossBillAmount:string,
	  gstAmount:string,
    restaurantName: string
    
    
    ) {
      console.log(restaurantName+""+itemCount+""+grossBillAmount+""+gstAmount);
      let billFromUser:Bill= new Bill(parseInt(itemCount),parseInt(grossBillAmount),parseInt(gstAmount),restaurantName)
      this.__billService.addBills(billFromUser);

  }


}