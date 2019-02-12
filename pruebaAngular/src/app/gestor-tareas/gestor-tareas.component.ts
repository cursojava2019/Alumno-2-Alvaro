import { Component, OnInit } from '@angular/core';
import { Task } from '../model/task';

@Component({
  selector: 'app-gestor-tareas',
  templateUrl: './gestor-tareas.component.html',
  styleUrls: ['./gestor-tareas.component.css']
})
export class GestorTareasComponent implements OnInit {
listado: Array<Task>;
tareaEntrada: string;

constructor() {
  this.listado = new Array<Task>();
}
  ngOnInit() {
  }

  crearTarea() {
    console.log( 'Entrada crear Tarea' );
    if ( this.tareaEntrada !== '' ) {
      const tarea: Task = new Task(false , this.tareaEntrada);
      this.listado.push(tarea);
      console.log(tarea);
      this.tareaEntrada= '';
    }

  }

}
