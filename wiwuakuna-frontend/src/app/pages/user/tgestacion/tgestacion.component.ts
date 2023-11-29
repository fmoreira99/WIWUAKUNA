import { Component , OnInit, DoCheck } from '@angular/core';
import { AnimalService } from '../../../service/animal.service';

@Component({
  selector: 'app-tgestacion',
  templateUrl: './tgestacion.component.html',
  styleUrls: ['./tgestacion.component.css']
})
export class TgestacionComponent  implements OnInit, DoCheck {
  animal:any = null;
  constructor( private animalService: AnimalService) { }
  ngDoCheck(): void{
    this.getAnimalByUsername()
  }
  ngOnInit(): void {
    this.getAnimalByUsername()
  }
  getAnimalByUsername()
  {
    this.animalService.getAnimalByUser().subscribe((data:any)=>{
      this.animal = data;
    })
  }
}
