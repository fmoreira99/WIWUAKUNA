import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-user-dashboard',
  templateUrl: './user-dashboard.component.html',
  styleUrls: ['./user-dashboard.component.css']
})
export class UserDashboardComponent implements OnInit {
  vali:number= 1;

  ngOnInit(): void {
    localStorage.setItem("itemDashBoard", "1")
    
  }
  hideElemenDash(option:number)
  {
    this.vali= option;
  }

}
