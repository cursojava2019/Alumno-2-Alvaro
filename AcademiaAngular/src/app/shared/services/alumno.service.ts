import { Injectable } from '@angular/core';
import { MapType } from '@angular/compiler';
import { Alumno } from '../entities/alumno';

@Injectable({
  providedIn: 'root'
})
export class AlumnoService {
  listado: Array<Alumno>;
  constructor() {
    this.listado = new Array<Alumno>();
    this.listado.push(
      new Alumno(0, 'David', 'Tello', 'Sanchez', 'dvdtello@gmail.com', new Date(), null, '75108883Z', 'Muy Listo', false, '953440000')
    );
    this.listado.push(
      new Alumno(1, 'Pepe', 'Tello', 'Ruiz', 'dvdxxxx@gmail.com', new Date(), null, '75118883Z', 'Muy Listo', false, '953441000')
    );
  }

  findAll() {
    return this.listado;
  }

  findById(index: number) {
    return this.listado[index];
  }
  create(a: Alumno) {
    this.listado.push(a);
  }
  delete(index: number) {
    return this.listado.splice(index, 1);
  }
}
