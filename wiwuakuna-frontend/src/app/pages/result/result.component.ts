import { Component , OnInit, OnDestroy, DoCheck, OnChanges} from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { AnimalService } from './../../service/animal.service';

@Component({
  selector: 'app-result',
  templateUrl: './result.component.html',
  styleUrls: ['./result.component.css']
})
export class ResultComponent implements OnInit, OnDestroy , OnChanges {
  data: any;
  constructor(private animalService:AnimalService,private snack:MatSnackBar) { }
  ngOnChanges() :void
  {
    this.getDataAnimal();
    
  }
  ngOnInit(): void {
    this.getDataAnimal();
    localStorage.setItem("validador","true");

  }
  ngOnDestroy() {
    localStorage.setItem("validador", "false");
  }
  destroy()
  {
    
  }
  reactivate(){

  }
  getDataAnimal()
  {
    let animalBusacr=localStorage.getItem("busqueda")
    localStorage.getItem("")
    this.animalService.getBuscarAnimal(animalBusacr).subscribe(
      (data:any)=>{
        this.data = data;
      }
    )
    localStorage.removeItem("busqueda")
  }
}
