import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Department } from 'src/app/common/department';
import { DepartmentService } from 'src/app/services/department.service';
import { EmployeesService } from 'src/app/services/employees.service';

@Component({
  selector: 'app-edit-employee',
  templateUrl: './edit-employee.component.html',
  styleUrls: ['./edit-employee.component.css']
})
export class EditEmployeeComponent implements OnInit {

  newEmployeeFormGroup : FormGroup;
  departments : Department[];

  constructor(private _formBuilder: FormBuilder,
    private departmentService : DepartmentService,
    private employeeService : EmployeesService) { }

  ngOnInit() {
    this.listDepartments();
    this.newEmployeeFormGroup = this._formBuilder.group({
      employee : this._formBuilder.group({
        firstName : ["",Validators.required],
        lastName : [""],
        department : [""],
        avatar : [""]
      })
    });
  }

  listDepartments(){
    this.departmentService.getDepartments().subscribe(
      data => this.departments = data
    )
  }

  onSubmit(){
    let index = this.newEmployeeFormGroup.get("employee").value.avatar.indexOf("base64,");
    this.newEmployeeFormGroup.get("employee").value.avatar = 
          this.newEmployeeFormGroup.get("employee").value.avatar.slice(index+"base64,".length);
    console.log(this.newEmployeeFormGroup);
    console.log(this.newEmployeeFormGroup.get("employee").value);
    this.employeeService.create(this.newEmployeeFormGroup.get("employee").value);
    //this.newEmployeeFormGroup.reset();
  }

  onFileSelected(files){
    let file = <File>files[0];
    let fileReader = new FileReader();
    fileReader.onload = (e) => {
      this.newEmployeeFormGroup.get("employee").value.avatar = fileReader.result;
    }
    fileReader.readAsDataURL(file);
  }

}
