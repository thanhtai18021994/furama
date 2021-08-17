import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {Education} from '../model/education';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class EducationService {
  private readonly URI_API="http://localhost:3000/education-degrees";
  constructor(
    private http:HttpClient
  ) { }
  findAll():Observable<Education[]>{
    return this.http.get<Education[]>(`${this.URI_API}`)
  }
}
