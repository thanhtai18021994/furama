import {Component, Input, OnInit} from '@angular/core';
import {EmployeeService} from '../../service/employee.service';
import {ActivatedRoute} from '@angular/router';
import {Employee} from '../../model/employee';

@Component({
  selector: 'app-view-employee',
  templateUrl: './view-employee.component.html',
  styleUrls: ['./view-employee.component.css']
})
export class ViewEmployeeComponent implements OnInit {
  abc:any;
  employee:Employee;
  id: number;

  constructor(
    private employeeService: EmployeeService,
    private activatedRouter: ActivatedRoute
  ) {
    this.activatedRouter.paramMap.subscribe(param => {
      this.id = +param.get('id');
    });
    this.employeeService.findById(this.id).subscribe(employee => {
      this.employee = employee;
      // this.abc="abcbca"
      console.log(this.employee);
    });
  }

  ngOnInit(): void {

  }

  view() {
    Promise.resolve().then(() => {
      const id = +this.activatedRouter.snapshot.params['id'];
      console.log(id);
      return id;
    }).then((id) => {
      this.employeeService.findById(id).subscribe(employee => {
        console.log('hea');
        this.employee = employee;
        console.log(this.employee);
      });
    });
  }

}
