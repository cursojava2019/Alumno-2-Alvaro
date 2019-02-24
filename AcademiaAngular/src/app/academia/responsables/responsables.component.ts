import { Component, OnInit } from '@angular/core';
import { routerTransition } from '../../router.animations';
import { ResponsableService } from '../../shared/services/responsable.service';
import { Responsable } from 'src/app/shared/entities/responsable';
import { Router } from '@angular/router';

@Component({
  selector: 'app-responsables',
  templateUrl: './responsables.component.html',
  styleUrls: ['./responsables.component.scss'],
  animations: [routerTransition()]
})
export class ResponsablesComponent implements OnInit {

  responsables: Array<Responsable>;

  constructor(private responsableService: ResponsableService, private router: Router) {
    responsableService.findAll().subscribe(data => {
      this.responsables = data;
    });
  }

  ngOnInit() {
  }

  irCrearResponsable() {
    this.router.navigate(['./responsables/crear']);
  }

  modificar(id: number) {
    this.router.navigate(['./responsables/modificar', id]);
  }

  eliminar(id: number) {
    if (confirm('¿Está seguro que desea borrar el responsable?')) {
      this.responsableService.delete(id).subscribe(data => {
        this.responsableService.findAll().subscribe(data => {
          this.responsables = data;
        });
      });

    }
  }

  listado(id: number) {
    this.router.navigate(['./responsables/listado', id]);
  }

}
