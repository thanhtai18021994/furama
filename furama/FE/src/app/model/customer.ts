import {Employee} from './employee';
import {CustomerType} from './customer-type';
import {Contract} from './contract';

export interface Customer {
  customerId:number;
  customerName:string;
  customerBirthday:string;
  customerGender:string;
  customerIdCard:string;
  customerPhone:string;
  customerEmail:string;
  customerAddress:string;
  customerType:CustomerType;
  contracts:Contract[];
}
