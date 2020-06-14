import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from 'rxjs';
import { Department } from '../common/department';

@Injectable({
  providedIn: 'root'
})
export class DepartmentService {

  private baseUrl = "http://localhost:8080/department";

  constructor(private httpClient: HttpClient ) { }

  getDepartments(): Observable<Department[]> {
    return this.httpClient.get<Department[]>(this.baseUrl); 
  }

}
