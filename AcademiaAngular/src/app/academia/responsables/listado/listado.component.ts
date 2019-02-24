import { Alumno } from './../../../shared/entities/alumno';
import { Component, OnInit } from '@angular/core';
import { routerTransition } from '../../../router.animations';
import { ResponsableService } from '../../../shared/services/responsable.service';
import { Responsable } from 'src/app/shared/entities/responsable';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-listado',
  templateUrl: './listado.component.html',
  styleUrls: ['./listado.component.scss'],
  animations: [routerTransition()]
})
export class ListadoComponent implements OnInit {

    responsable: Responsable;

  constructor(private rutaActiva: ActivatedRoute, private responsableService: ResponsableService, private router: Router){}

  ngOnInit() {
    let id = this.rutaActiva.snapshot.params.id;
    this.responsableService.findById(id).subscribe(data => {
      this.responsable = data;
      console.log(this.responsable);
    });
  }
}
