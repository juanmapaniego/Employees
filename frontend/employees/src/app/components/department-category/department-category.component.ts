import { Component, OnInit } from '@angular/core';
import { Department } from 'src/app/common/department';
import { DepartmentService } from 'src/app/services/department.service';

@Component({
  selector: 'app-department-category',
  templateUrl: './department-category.component.html',
  styleUrls: ['./department-category.component.css']
})
export class DepartmentCategoryComponent implements OnInit {
  
  departments: Department[]; 

  constructor(private _departmentService: DepartmentService) { }

  ngOnInit() {
    this.listDepartmentCategories();
  }

  listDepartmentCategories(){
    this._departmentService.getDepartments().subscribe(
      data => this.departments = data
    )
  }
  
  logueo(){
    console.log(this.departments);
  }
}
