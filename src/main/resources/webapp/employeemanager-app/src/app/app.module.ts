import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { EmployeeItemComponent } from './components/employee-item/employee-item.component';
import { OrderingComponent } from './components/ordering/ordering.component';
import {MatCardModule} from "@angular/material/card";
import { MenuComponent } from './components/menu/menu.component';
import { EmployeesComponent } from './components/employees/employees.component';
import {MatButtonModule} from "@angular/material/button";

@NgModule({
  declarations: [
    AppComponent,
    EmployeeItemComponent,
    OrderingComponent,
    MenuComponent,
    EmployeesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatCardModule,
    MatButtonModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
