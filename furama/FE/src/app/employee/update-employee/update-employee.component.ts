import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {EmployeeService} from '../../service/employee.service';
import {Employee} from '../../model/employee';
import {ActivatedRoute} from '@angular/router';
import {EducationService} from '../../service/education.service';
import {DepartmentService} from '../../service/department.service';
import {PositionService} from '../../service/position.service';
import {Department} from '../../model/department';
import {PositionModel} from '../../model/PositionModel';
import {Education} from '../../model/education';
import {Observable} from 'rxjs';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-update-employee',
  templateUrl: './update-employee.component.html',
  styleUrls: ['./update-employee.component.css']
})
export class UpdateEmployeeComponent implements OnInit {

  employeeForm: FormGroup;
  departments: Department[];
  positions: PositionModel[];
  educations: Education[];
  currentEmployee: Employee;
  id:number;
  constructor(
    private fb: FormBuilder,
    private employeeService: EmployeeService,
    private educationService: EducationService,
    private departmentService: DepartmentService,
    private positionService: PositionService,
    private activatedRouter: ActivatedRoute
  ) {
    this.departmentService.findAll().subscribe(departments => {
      this.departments = departments;
    });
    this.educationService.findAll().subscribe(education => {
      this.educations = education;
    });
    this.positionService.getPosition().subscribe(positions => {
      this.positions = positions;
    });
  }

  validator = {
    name: [
      {type: 'required', msg: 'Làm ơn nhập trường này!'},
      {type: 'pattern', msg: 'Tên không đúng định dạng'}
    ], birthday: [
      {type: 'required', msg: 'Làm ơn nhập trường này!'},
      {type: 'pattern', msg: 'Tên không đúng định dạng'}
    ], idCard: [
      {type: 'required', msg: 'Làm ơn nhập trường này!'},
      {type: 'pattern', msg: 'Tên không đúng định dạng'}
    ], salary: [
      {type: 'required', msg: 'Làm ơn nhập trường này!'},
      {type: 'min', msg: 'Tên không đúng định dạng'}
    ], phoneNumber: [
      {type: 'required', msg: 'Làm ơn nhập trường này!'},
      {type: 'pattern', msg: 'Đầu số 090 hoặc 091'}
    ], email: [
      {type: 'required', msg: 'Làm ơn nhập trường này!'},
      {type: 'pattern', msg: 'Tên không đúng định dạng'}
    ], address: [
      {type: 'required', msg: 'Làm ơn nhập trường này!'}
    ], education: [
      {type: 'required', msg: 'Làm ơn nhập trường này!'}
    ], position: [
      {type: 'required', msg: 'Làm ơn nhập trường này!'}
    ], department: [
      {type: 'required', msg: 'Làm ơn nhập trường này!'}
    ]
  };

  ngOnInit(): void {
    this.getEmployee();
    this.activatedRouter.paramMap.subscribe(params=>{
      const id=+params.get("id");
      this.id=id;
      this.employeeService.findById(id).subscribe(employee=>{
        this.currentEmployee=employee;
      })
    })
  }

  onSubmit() {
    if (this.employeeForm.invalid) {
      Object.keys(this.employeeForm.controls).forEach(field => {
        const control = this.employeeForm.get(field);
        control.markAsTouched({onlySelf: true});
      });
    } else {
      let employee: Employee = this.employeeForm.value;

      this.employeeService.updateService(this.id,employee).subscribe(response => {
       this.employeeForm.reset(true);
       this.notify()
      });
    }
  }


  getEmployee() {
    this.activatedRouter.paramMap.subscribe(param => {
      const id = +param.get('id');
      this.employeeService.findById(id).subscribe(employee => {
        this.employeeForm = this.fb.group({
          name: [employee.name, [Validators.required, Validators.pattern('')]],
          birthday: [employee.birthday, [Validators.required, Validators.pattern('')]],
          idCard: [employee.idCard, [Validators.required, Validators.pattern('')]],
          salary: [employee.salary, [Validators.required, Validators.min(10)]],
          phoneNumber: [employee.phoneNumber, [Validators.required, Validators.pattern('^(090|091|(\\+84)09)\\d{8}')]],
          email: [employee.email, [Validators.required, Validators.pattern]],
          address: [employee.address, Validators.required],
          education: [employee.education, Validators.required],
          position: [employee.position, Validators.required],
          department: [employee.department, Validators.required]
        });
      });
    });
  }

  resetForm(){
    this.employeeForm.reset(true);
  }
  notify() {
    Swal.fire({
      position: 'center',
      icon: 'success',
      title: 'Chỉnh sửa thành công!',
      showConfirmButton: false,
      timer: 2000
    })
  }
}
