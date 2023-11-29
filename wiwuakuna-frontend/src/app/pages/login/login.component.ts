import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { UserService } from './../../service/user.service';
import { LoginService } from './../../service/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{
  public logiuser = {
    username : '',
    password : '',      
  }
  ngOnInit(): void {
  }
  constructor(private loginService:LoginService,private snack:MatSnackBar) { }
  formSubmit() {
    if(this.logiuser.username.trim() == '' || this.logiuser.username.trim() == null){
      this.snack.open('El nombre de usuario es requerido !!','Aceptar',{
        duration:3000
      })
      return;
    }
    if(this.logiuser.password.trim() == '' || this.logiuser.password.trim() == null){
      this.snack.open('La contraseña es requerida !!','Aceptar',{
        duration:3000
      })
      return;
    }
    this.loginService.generateToken(this.logiuser).subscribe(
      (data:any)=>{
        
        this.loginService.loginUser(data.token);
        this.loginService.getCurrentUser().subscribe((user:any)=>{
            console.log(user)
            this.loginService.setUser(user);
            let roleUser=this.loginService.getUserRole();
            if(roleUser==="ADMIN")
            {
             window.location.href='/admin'
            }else if(roleUser==="NORMAL"){
              window.location.href='/user-dashboard'
            } else
            {
              this.loginService.logout();
              window.location.href='/login'
            }

        });

      }
        ,(error)=>
        {
          console.log(error)
          this.snack.open('Detalles invalidos , vuelva a intentar  !!' , 'Aceptar' ,{
            duration: 3000
          }  )
        }
    )
    


  }
}
