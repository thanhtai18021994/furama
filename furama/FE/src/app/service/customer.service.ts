import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Customer} from '../model/customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  private readonly API_URI="http://localhost:8080/api/customer"
  constructor(
    private http:HttpClient
  ) { }

  public getAll():Observable<Customer[]>{
    return this.http.get<Customer[]>(`${this.API_URI}/get`);
  }

}
