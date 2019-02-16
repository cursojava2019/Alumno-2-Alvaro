import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AlumnosRoutingModule } from './alumnos-routing.module';
import { AlumnosComponent } from './alumnos.component';
import { PageHeaderModule } from '../../shared';
import { CrearAlumnoComponent } from './crear-alumno/crear-alumno.component';
import { ModicarAlumnoComponent } from './modicar-alumno/modicar-alumno.component';
import { FormularioAlumnoComponent } from './formulario-alumno/formulario-alumno.component';
import { ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [AlumnosComponent, CrearAlumnoComponent, ModicarAlumnoComponent, FormularioAlumnoComponent],
  imports: [
    CommonModule,
    AlumnosRoutingModule, PageHeaderModule, ReactiveFormsModule
  ]
})
export class AlumnosModule { }
