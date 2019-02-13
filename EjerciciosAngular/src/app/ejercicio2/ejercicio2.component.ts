import { Component, OnInit } from '@angular/core';
import { Empleado } from './model/empleado';
@Component({
  selector: 'app-ejercicio2',
  templateUrl: './ejercicio2.component.html',
  styleUrls: ['./ejercicio2.component.css']
})
export class Ejercicio2Component implements OnInit {
empleado: Empleado;
sueldo = [1600, 1700, 1900];

constructor() {
  this.empleado = new Empleado('Rodriguez Pablo', 40 , this.sueldo);
}


  ngOnInit() {
  }

}
