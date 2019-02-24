import { Component, OnInit } from '@angular/core';
import { routerTransition } from '../../router.animations';
import { ProfesorService } from '../../shared/services/profesor.service';
import { Profesor } from 'src/app/shared/entities/profesor';
import { Router } from '@angular/router';

@Component({
  selector: 'app-profesores',
  templateUrl: './profesores.component.html',
  styleUrls: ['./profesores.component.scss'],
  animations: [routerTransition()]
})
export class ProfesoresComponent implements OnInit {

	profesores: Array<Profesor>;

  constructor(private profesorService: ProfesorService, private router: Router) {
  	profesorService.findAll().subscribe(data => {
      this.profesores = data;
    });
  }

  ngOnInit() {
  }

  irCrearProfesor() {
    this.router.navigate(['./profesores/crear']);
  }

  modificar(id: number) {
    this.router.navigate(['./profesores/modificar', id]);
  }

  eliminar(id: number) {
    if (confirm('¿Está seguro que desea borrar el profesor?')) {
      this.profesorService.delete(id).subscribe(data => {
        this.profesorService.findAll().subscribe(data => {
          this.profesores = data;
        });
      });
    }
  }

}
