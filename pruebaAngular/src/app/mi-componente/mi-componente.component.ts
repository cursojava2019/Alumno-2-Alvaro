import { Component, OnInit } from '@angular/core';
import { Calculadora } from '../model/calculadora';

@Component({
  selector: 'app-mi-componente',
  templateUrl: './mi-componente.component.html',
  styleUrls: ['./mi-componente.component.css']
})
export class MiComponenteComponent implements OnInit {
  nombre = 'Paco';
  calculadora: Calculadora;
  nombreEntrada = '';
  textoIntroduccion = 'Introduzca un nombre...';
  constructor() {
    this.calculadora = new Calculadora();
  }
  ngOnInit() {
  }
  cambiarNombre( nuevoNombre: string) {
    this.nombre = nuevoNombre;
  }

  cambiarNombreEntrada() {
    this.nombre = this.nombreEntrada;
  }


}
