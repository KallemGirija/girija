import { Injectable } from '@angular/core';
import { Bill } from  './bill';


@Injectable({
  providedIn: 'root'
})
export class BillingOperationsService {
  
  constructor() { }

  billArr:Bill[]=[];

  addBills(billFromUser:Bill){
    this.billArr.push(billFromUser); 
    console.log("Inside Bill Service : Bill Added "+billFromUser.restaurantName);
    console.log(" Total Bill Are :- "+this.billArr.length);
  }

  getBillArr():Bill[]
  {
    
    return this.billArr;
  }

}
   
    
