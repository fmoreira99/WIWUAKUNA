import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import baseUrl from './helper';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  public loginStatusSubjec = new Subject<boolean>();

  constructor(private httpClient: HttpClient) { }

  public generateToken(loginDara:any)
  {
    return this.httpClient.post(`${baseUrl}/auth/v1/generate-token`, loginDara)
  }
  public loginUser(token:any)
  {
    localStorage.setItem('token', token);

  }
  public isLoggedIn()
  {
    let tokenStr=localStorage.getItem('token');
    if(tokenStr==undefined  || tokenStr=='' || tokenStr==null)
    {
      return false;
    }else{
      return true;
    }
  }
  public logout()
  {
    localStorage.removeItem('token');
    localStorage.removeItem('user');
    return true;

  }

  public getToken()
  {
    return localStorage.getItem('token');
  }

  public setUser(user:any)
  {
    localStorage.setItem('user',JSON.stringify(user));
  }
  public getUserName()
  {
    let user = this.getUser();
    return  user.username;
  }
  public getUser()
  {
    let userStr = localStorage.getItem('user');
    if(userStr != null){
      return JSON.parse(userStr);
    }else{
      this.logout();
      return null;
    }
  }
  public getUserRole()
  {
    let user= this.getUser();
    return user.authorities[0].authority
  }
  public getCurrentUser()
  {
    return this.httpClient.get(`${baseUrl}/auth/v1/actual-usuario`)
  }
}
