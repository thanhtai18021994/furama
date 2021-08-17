import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Department} from '../model/department';

@Injectable({
  providedIn: 'root'
})
export class DepartmentService {
  private readonly URI_API="http://localhost:3000/departments";
  constructor(
    private http:HttpClient
  ) { }

  findAll():Observable<Department[]>{
    return this.http.get<Department[]>(`${this.URI_API}`);
  }
}
