import { Component , OnInit, DoCheck , Renderer2} from '@angular/core';
import { AnimalService } from '../../../service/animal.service';
@Component({
  selector: 'app-tanimal',
  templateUrl: './tanimal.component.html',
  styleUrls: ['./tanimal.component.css']
})
export class TanimalComponent implements OnInit, DoCheck {
  animal:any = null;
  constructor( private animalService: AnimalService, private renderer: Renderer2) { }
  ngDoCheck(): void{

  }
  ngOnInit(): void {
    this.getAnimalByUsername()
  }
  getAnimalByUsername()
  {
    this.animalService.getAnimalByUser().subscribe((data:any)=>{
      this.animal = data;
      console.log(data)
      console.log(this.animal)
    })
  }
  renderEstado(estado:number) {
    switch (estado) {
      case 0:
        return `<td class="color_vendido" >
        <img width="25" height="25" src="https://img.icons8.com/flat-round/64/self-destruct-button--v1.png" alt="self-destruct-button--v1"/>
        </td>`;
      case 1:
        return `<td class="color_vendido">
        <img width="25" height="25" src="https://img.icons8.com/fluency/48/veterinarian-male.png" alt="veterinarian-male"/>
        </td>`;
      case 2:
        return `<td class="color_vendido" >
        <img width="25" height="25" src="https://img.icons8.com/fluency/48/money.png" alt="money"/>
        </td>`;
      case 3:
        return `
        <td class="color_vendido" >
        <img width="25" height="25" src="https://img.icons8.com/color/48/flying-stork-with-bundle.png" alt="flying-stork-with-bundle"/>
        </td>`;
      
      case 4:
          return `<td class="color_vendido">
          <img width="25" height="25" src="https://img.icons8.com/papercut/60/sale--v3.png" alt="sale--v3"/>
          </td>`;
      default:
        return `<td class="color_vendido">
        <img width="25" height="25" src="https://img.icons8.com/parakeet/48/task.png" alt="task"/>
        </td>`;
    }
  }
 
}
