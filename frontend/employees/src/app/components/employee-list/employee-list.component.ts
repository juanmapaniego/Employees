import { Component, OnInit } from '@angular/core';
import { Employee } from 'src/app/common/employee';
import { EmployeesService } from 'src/app/services/employees.service';
import { DomSanitizer, SafeResourceUrl } from '@angular/platform-browser';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {

  employees : Employee[];
  imageBlobUrl: string;

  constructor(private _employeeService: EmployeesService,
    private _sanittizer : DomSanitizer) { }

  ngOnInit() {
    this.listEmployees();
  }

  listEmployees(){
    this._employeeService.getEmployees().subscribe(
      data => { 
        this.employees = data;      
        this.imageBlobUrl = "data:image/png;base64,"+this.employees[0].avatar;        
      }
    );
    
  }

}
