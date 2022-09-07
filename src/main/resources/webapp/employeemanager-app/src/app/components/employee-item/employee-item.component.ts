import { Component, OnInit, Input } from '@angular/core';
import {EmployeeInterface} from "../../interface/employee-interface";

@Component({
  selector: 'app-employee-item',
  templateUrl: './employee-item.component.html',
  styleUrls: ['./employee-item.component.css']
})
export class EmployeeItemComponent implements OnInit {


  @Input() employee!: EmployeeInterface;


  constructor() { }

  ngOnInit(): void {
  }

}
