import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ResponsablesComponent } from './responsables.component';
import { CrearResponsableComponent } from './crear-responsable/crear-responsable.component';
import { ModificarResponsableComponent } from './modificar-responsable/modificar-responsable.component';
import { ListadoComponent } from './listado/listado.component';

const routes: Routes = [
  {
      path: '',
      component: ResponsablesComponent
  },

  { path: 'crear', component: CrearResponsableComponent},
  { path: 'modificar/:idResponsable', component: ModificarResponsableComponent},
  { path: 'listado/:id', component: ListadoComponent}


];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ResponsablesRoutingModule { }
