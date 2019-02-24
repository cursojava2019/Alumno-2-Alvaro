import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Alumno } from 'src/app/shared/entities/alumno';
import { ResponsableService } from 'src/app/shared/services/responsable.service';
import { Responsable } from 'src/app/shared/entities/responsable';


@Component({
  selector: 'app-formulario-alumno',
  templateUrl: './formulario-alumno.component.html',
  styleUrls: ['./formulario-alumno.component.scss']
})
export class FormularioAlumnoComponent implements OnInit {
  miFormulario: FormGroup;

  listadoResponsables: Array<Responsable>;

  @Input()
  modificar = false;

  @Input()
  alumnoModificar: Alumno;

  @Output()
  modificado = new EventEmitter<Alumno>();


  constructor(private fb: FormBuilder, private responsableService: ResponsableService) {}

  ngOnInit() {
    this.miFormulario = this.fb.group({
      id : this.fb.control(''),
      nombre : this.fb.control('', [Validators.required, Validators.minLength(3)]),
      apellido1 : this.fb.control('', [Validators.required, Validators.minLength(3)]),
      apellido2 : this.fb.control('', [Validators.required, Validators.minLength(3)]),
      nif : this.fb.control('', [Validators.required, Validators.minLength(9), Validators.maxLength(9)]),
      telefono : this.fb.control('', [Validators.required, Validators.maxLength(9)]),
      correo : this.fb.control('', [Validators.required, Validators.email]),
      repetidor : this.fb.control(false),
      idResponsable : this.fb.control(''),
      observaciones : this.fb.control(''),
      fechaAlta : this.fb.control('', [])

    });

    this.responsableService.findAll().subscribe(data => {
      this.listadoResponsables = data;
    });

    if (this.modificar === true) {
      console.log('patch ' + this.alumnoModificar);
      this.miFormulario.patchValue (this.alumnoModificar);
    }
  }

  guardarCambios() {
    if (this.modificar === false) {
      const alumnoForm: Alumno = this.miFormulario.value;
      alumnoForm.fechaAlta = new Date();
      this.modificado.next(alumnoForm);
   } else {
    const alumnoForm: Alumno = this.miFormulario.value;

     this.modificado.next(alumnoForm);
   }

  }

}
