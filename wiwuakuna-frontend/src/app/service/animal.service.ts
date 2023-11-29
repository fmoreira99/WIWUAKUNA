import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import baseUrl from './helper';
@Injectable({
  providedIn: 'root'
})
export class AnimalService {
  constructor(private httpClient: HttpClient) { }
  public getAnimal(word:string )
  {
    if(word===null || word==undefined || word==='')
    {
      localStorage.getItem("busqueda");
    }
    return this.httpClient.get(`${baseUrl}/animal/v1/search?name=${word}`)
  }
  public getBuscarAnimal(animal:any)
  {
    
    
    return this.httpClient.get(`${baseUrl}/animal/v1/search?name=${animal}`)
  }
  
}
