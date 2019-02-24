import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ResponsablesRoutingModule } from './responsables-routing.module';
import { ResponsablesComponent } from './responsables.component';
import { PageHeaderModule } from '../../shared';
import { CrearResponsableComponent } from './crear-responsable/crear-responsable.component';
import { FormularioResponsableComponent } from './formulario-responsable/formulario-responsable.component';
import { ModificarResponsableComponent } from './modificar-responsable/modificar-responsable.component';
import { ReactiveFormsModule } from '@angular/forms';
import { ListadoComponent } from './listado/listado.component';

@NgModule({
  declarations: [ResponsablesComponent, CrearResponsableComponent, FormularioResponsableComponent, ModificarResponsableComponent, ListadoComponent],
  imports: [
    CommonModule,
    ResponsablesRoutingModule,
    PageHeaderModule,
    ReactiveFormsModule
  ]
})
export class ResponsablesModule { }
