import {Employee} from './employee';
import {Customer} from './customer';
import {Service} from './service';
import {ContractDetail} from './contract-detail';

export interface Contract {
  contractId:number;
  contractStartDate:string;
  contractEndDate:string;
  contractDeposit:number;
  contractTotalMoney:number;
  employee:Employee;
  customer:Customer;
  services:Service;
  contractDetail:ContractDetail[];
}
