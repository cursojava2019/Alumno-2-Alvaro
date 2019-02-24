import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Responsable } from 'src/app/shared/entities/responsable';
import { ResponsableService } from 'src/app/shared/services/responsable.service';
import { routerTransition } from 'src/app/router.animations';

@Component({
  selector: 'app-modificar-responsable',
  templateUrl: './modificar-responsable.component.html',
  styleUrls: ['./modificar-responsable.component.scss'],
  animations: [routerTransition()]
})
export class ModificarResponsableComponent implements OnInit {

	responsableActual: Responsable;

  constructor(private rutaActiva: ActivatedRoute, private responsableService: ResponsableService, private router: Router) { }

  ngOnInit() {
  	let id = this.rutaActiva.snapshot.params.idResponsable;
    this.responsableService.findById(id).subscribe(data => {
      this.responsableActual = data;
      console.log(this.responsableActual);
    });
  }

  modificar(r: Responsable) {
    this.responsableService.modificar(r).subscribe(data => {
      this.router.navigate(['responsables']);
    });
  }

}
