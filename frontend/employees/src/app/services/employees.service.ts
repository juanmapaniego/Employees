import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, empty } from 'rxjs';
import { map } from 'rxjs/operators';
import { Employee } from '../common/employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeesService {
  
  create(value: any) {
    this.httpClient.post(this.baseUrl,value).subscribe(
      res => console.log(res)
    );
  }

  private baseUrl = "http://localhost:8080/employee";

  constructor(private httpClient: HttpClient) { }

  getEmployees(): Observable<Employee[]>{
    return this.httpClient.get<Employee[]>(this.baseUrl);
  }

}
