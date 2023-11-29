
import { MatSnackBar } from '@angular/material/snack-bar';
import { UserService } from './../../service/user.service';
import { Component, OnInit } from '@angular/core';
@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})

export class SignupComponent  implements OnInit {
  public user = {
    username : '',
    password : '',
    nombre : '',
    apellido : '',
    email : '',
    telefono : '',
    fnacimiento:''
  }
  ngOnInit(): void {
  }
  constructor(private userService:UserService,private snack:MatSnackBar) { }
  formSubmit() {
    console.log(this.user);
    if (this.user.username == '' || this.user.username == null) {
      this.snack.open("El nombre de usuario es requerido", "Aceptar",{
        duration:3000, verticalPosition:'top', horizontalPosition:'right'
      })
    
      return
    }
    this.userService.añadirUsuario(this.user).subscribe(
      (data) => {
        console.log(data);
        alert("Usuario Guardado con exito")
      },(error)=>
      {
        console.log(error);
        alert("Error ene l sistema")
      }
    
    )
  }


  
}
