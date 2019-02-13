import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MiComponenteComponent } from './mi-componente/mi-componente.component';
import { Micomponente2Component } from './micomponente2/micomponente2.component';
import { GestorTareasComponent } from './gestor-tareas/gestor-tareas.component';
import { TareaComponent } from './gestor-tareas/tarea/tarea.component';

@NgModule({
  declarations: [
    AppComponent,
    MiComponenteComponent,
    Micomponente2Component,
    GestorTareasComponent,
    TareaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
