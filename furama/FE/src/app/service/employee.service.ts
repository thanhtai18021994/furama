import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Employee} from '../model/employee';
import {environment} from '../../environments/environment';
import {filter, map} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  private readonly URI_API = environment.apiUrl;

  constructor(private http: HttpClient) {
  }

  public getEmployees(): Observable<Employee[]> {
    return this.http.get<Employee[]>(`${this.URI_API}/employee`);
  }



  searchName(name:string):Observable<Employee[]>{
    // console.log(111111);
    return this.http.get<Employee[]>(`${this.URI_API}/employee?name_like=${name}`);
  }

  searchPhone(phone:string):Observable<Employee[]>{
    console.log("abc");
    return this.http.get<Employee[]>(`${this.URI_API}/employee?phoneNumber_like=${phone}`);
  }

  createForm(employee: Employee): Observable<Employee> {
    return this.http.post<Employee>(`${this.URI_API}/employee`, employee);
  }

  findById(id: number): Observable<Employee> {
    return this.http.get<Employee>(`${this.URI_API}/employee/` + id);
  }

  delete(id: number) :Observable<Employee>{
    return this.http.delete<Employee>(`${this.URI_API}/employee/${id}`);
  }

  updateService(id:number,employee:Employee):Observable<Employee>{
    return this.http.put<Employee>(`${this.URI_API}/employee/${id}`,employee)
  }

  search(position:string,education:string,department:string):Observable<Employee[]>{
    let request="";
    if (position!='null'){
      request+=`position=${position}&`;
    }
    if (education!='null'){
      request+=`education=${education}&`;
    }
    if (department!='null'){
      request+=`department=${department}`;
    }
    console.log(request);
    return this.http.get<Employee[]>(`${this.URI_API}/employee?${request}`)
  }
}
