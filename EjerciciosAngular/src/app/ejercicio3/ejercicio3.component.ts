import { Component, OnInit } from '@angular/core';
import { Numeros } from './model/numeros';

@Component({
  selector: 'app-ejercicio3',
  templateUrl: './ejercicio3.component.html',
  styleUrls: ['./ejercicio3.component.css']
})
export class Ejercicio3Component implements OnInit {
  numeros: Numeros;
  number = [3, 5, 4];

constructor() {
  this.numeros = new Numeros(this.number);
}

  ngOnInit() {

  }

}
