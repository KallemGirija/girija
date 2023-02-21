export class Bill
{
    
     itemCount:number;
	 grossBillAmount:number;
	 gstAmount:number;
     restaurantName:string;

    constructor(
        
        itemCount:number,
        grossBillAmount:number,
        gstAmount:number,
        restaurantName:string,

        
    ){
        
        this.restaurantName=restaurantName;
        this.itemCount=itemCount;
        this.grossBillAmount=grossBillAmount;
        this.gstAmount=gstAmount;

    }

}

