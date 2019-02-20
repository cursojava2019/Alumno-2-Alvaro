import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProfesoresRoutingModule } from './profesores-routing.module';
import { ProfesoresComponent } from './profesores.component';
import { PageHeaderModule } from '../../shared';
import { CrearProfesorComponent } from './crear-profesor/crear-profesor.component';
import { ModificarProfesorComponent } from './modificar-profesor/modificar-profesor.component';
import { FormularioProfesorComponent } from './formulario-profesor/formulario-profesor.component';
import { ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [ProfesoresComponent, CrearProfesorComponent, ModificarProfesorComponent, FormularioProfesorComponent],
  imports: [
    CommonModule,
    ProfesoresRoutingModule, PageHeaderModule, ReactiveFormsModule
  ]
})
export class ProfesoresModule { }
