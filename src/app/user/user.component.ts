import { Component } from '@angular/core';
import { Bill } from '../bill';
import { BillingOperationsService } from '../billing-operations.service';
import { ActivatedRoute, Route, Router } from '@angular/router';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent 
{

  __billService:BillingOperationsService;
  router:Router;

  allBills:Array<Bill>=[];
  
  
  constructor(billService:BillingOperationsService,router:Router){
    this.__billService=billService;
    this.allBills=this.__billService.getBillArr();
    this.router=router;
  }
 
}

  