import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from "@angular/common/http";
import { RouterModule, Routes } from "@angular/router";

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DepartmentCategoryComponent } from './components/department-category/department-category.component';
import { DepartmentService } from './services/department.service';
import { EmployeeListComponent } from './components/employee-list/employee-list.component';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';
import { EditEmployeeComponent } from './components/edit-employee/edit-employee.component';
import { ReactiveFormsModule } from '@angular/forms';

const routes : Routes = [
  {path: "employees/create",component: EditEmployeeComponent},
  {path: "employees",component: EmployeeListComponent},
  {path: "", redirectTo:"employees",pathMatch:"full"},
  {path: "**", component: PageNotFoundComponent}
]

@NgModule({
  declarations: [
    AppComponent,
    DepartmentCategoryComponent,
    EmployeeListComponent,
    PageNotFoundComponent,
    EditEmployeeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    RouterModule.forRoot(routes),
    ReactiveFormsModule
  ],
  providers: [
    DepartmentService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
