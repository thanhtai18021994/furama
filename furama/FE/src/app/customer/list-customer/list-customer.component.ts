import { Component, OnInit } from '@angular/core';
import {Customer} from '../../model/customer';
import {CustomerService} from '../../service/customer.service';

@Component({
  selector: 'app-list-customer',
  templateUrl: './list-customer.component.html',
  styleUrls: ['./list-customer.component.css']
})
export class ListCustomerComponent implements OnInit {

  customers: Customer[];
  flag: any;
  p=1;

  constructor(
    private customerService: CustomerService
  ) {
  }

  ngOnInit(): void {
    this.getListCustomer();
  }

  getListCustomer() {
    this.customerService.getAll().subscribe(data => {
      this.customers = data;
      console.log(data);
    });
  }


  searchAllField(value: string) {

  }

  controlModal() {

  }

  delete(id: number) {

  }

  search(value: string, value2: string, value3: string) {

  }

}
