import { Component, OnInit } from '@angular/core';
import { routerTransition } from '../../router.animations';
import { AlumnoService } from '../../shared/services/alumno.service';
import { Alumno } from 'src/app/shared/entities/alumno';
import { Router } from '@angular/router';
import { ResponsableService } from 'src/app/shared/services/responsable.service';


@Component({
  selector: 'app-alumnos',
  templateUrl: './alumnos.component.html',
  styleUrls: ['./alumnos.component.scss'],
  animations: [routerTransition()]
})
export class AlumnosComponent implements OnInit {

  alumnos: Array<Alumno>;

  constructor(private alumnoService: AlumnoService, private responsableService: ResponsableService , private router: Router) {
    alumnoService.findAll().subscribe(data => {


      console.log(data);
      for (const i of  data) {
        if (i['responsableAlumno'] != null) {
        this.responsableService.findById(i['responsableAlumno']).subscribe(respo => {
          i.responsable = respo;
          console.log(respo);
          i.idResponsable = i['responsableAlumno'];
        });

      }
    }
      this.alumnos = data;
      console.log(data);
    });
  }

  ngOnInit() {
  }

  irCrearAlumno() {
    this.router.navigate(['./alumnos/crear']);
  }

  modificar(id: number) {
    this.router.navigate(['./alumnos/modificar', id]);
  }

  eliminar(id: number) {
    if (confirm('¿Está seguro que desea borrar el alumno?')) {
      this.alumnoService.delete(id).subscribe(data => {
        this.alumnoService.findAll().subscribe(data => {
          this.alumnos = data;
        });
      });

    }
  }

}
