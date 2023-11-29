import { Component, OnInit, DoCheck  } from '@angular/core';
import { LoginService } from 'src/app/service/login.service';
import { ResultComponent } from 'src/app/pages/result/result.component';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit, DoCheck{
  

  isLoggedIn = false;
  user:any = null;
  vali:boolean= false;
  
  constructor(public login:LoginService,  public router:Router ){
    
  }
 
  clickButton(valor: string): void{
    localStorage.setItem("busqueda", valor);
    window.location.href='/result';
   
   // this.router.navigate(['result'])
  }
  ngDoCheck(): void{
    if(localStorage.getItem("validador")==='false' || localStorage.getItem("validador")===undefined)
    {
      this.vali=false;
    }else if(localStorage.getItem("validador")==='true'){
      this.vali=true;
    }
    
  }
  ngOnInit(): void {

  
   
    this.isLoggedIn = this.login.isLoggedIn();
    this.user = this.login.getUser();
    this.login.loginStatusSubjec.asObservable().subscribe(
      data => {
        this.isLoggedIn = this.login.isLoggedIn();
        this.user = this.login.getUser();
      }
    )
  }

  public logout()
  {
    this.login.logout();
    window.location.reload();
  }

}
