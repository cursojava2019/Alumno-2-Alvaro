import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MiComponenteComponent } from './mi-componente/mi-componente.component';

const routes: Routes = [
  { path: '', component: MiComponenteComponent },
    { path: 'path2', component: MiComponenteComponent },
    { path: 'path3', component: MiComponenteComponent },
    { path: 'path4', component: MiComponenteComponent },
    { path: '**', component: MiComponenteComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
