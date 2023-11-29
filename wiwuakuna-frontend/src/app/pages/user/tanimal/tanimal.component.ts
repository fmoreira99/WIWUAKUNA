import { Component , OnInit, DoCheck } from '@angular/core';
import { AnimalService } from '../../../service/animal.service';
@Component({
  selector: 'app-tanimal',
  templateUrl: './tanimal.component.html',
  styleUrls: ['./tanimal.component.css']
})
export class TanimalComponent implements OnInit, DoCheck {
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
