import { Injectable } from '@angular/core';
import {environment} from '../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {PositionModel} from '../model/PositionModel';

@Injectable({
  providedIn: 'root'
})
export class PositionService {
  private readonly URI_API=environment.apiUrl;
  constructor(private http:HttpClient) { }
  public getPosition():Observable<PositionModel[]>{
    return this.http.get<PositionModel[]>(`${this.URI_API}/positions`)
  }
}
