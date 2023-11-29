import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.css']
})
export class IndexComponent implements OnInit{
  valorInput: string = '';
  ngOnInit(): void {
    localStorage.setItem("validador","false");
  }
  constructor(private snack:MatSnackBar, private router:Router) { }
  realizarbusqueta(valor: string)
  {        
    if(valor===null || valor===undefined || valor==='')
    {
    
      this.snack.open("Para poder buscar debe escribir alguna palabra, por ejemplo gallina sedosa", "Aceptar",{
        duration:5000, verticalPosition:'top', horizontalPosition:'right'
      })
      
    }else
    {
      
      localStorage.setItem("busqueda", valor);

      this.router.navigate(['result'])
      
    }
    

  }
}
