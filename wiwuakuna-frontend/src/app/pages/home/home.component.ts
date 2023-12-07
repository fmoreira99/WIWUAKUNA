import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  constructor(  public router:Router ){
    
  }
  ngOnInit(): void {
    // Ejecuta el href luego de 3 segundos
    setTimeout(() => {
      
      this.router.navigate(['index'])
  }, 1000);

  // Guarda el valor "false" en el localStorage
  localStorage.setItem("validador", "false");
  }

}
