import { Component, OnInit } from '@angular/core';
import { Producto } from '../ejercicio6/model/producto';
import { ProductoService } from '../ejercicio6/services/producto.service';


@Component({
  selector: 'app-ejercicio6',
  templateUrl: './ejercicio6.component.html',
  styleUrls: ['./ejercicio6.component.css'],
  providers: [ProductoService]
})
export class Ejercicio6Component implements OnInit {

  constructor(private articuloService: ProductoService) { }

  ngOnInit() {
  }

  crearProducto() {
    console.log('Creando producto...');

  }

  listarProductos() {
    return this.productoService.findAll();
  }

}
