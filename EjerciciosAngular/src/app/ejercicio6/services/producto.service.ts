import { Injectable } from '@angular/core';
import { Producto } from '../model/producto';

@Injectable({
  providedIn: 'root'
})
export class ProductoService {
  private listado = Array<Producto>();
  constructor() {
    this.listado.push(new Producto(1, 'Azucar', 3));
  }
}
