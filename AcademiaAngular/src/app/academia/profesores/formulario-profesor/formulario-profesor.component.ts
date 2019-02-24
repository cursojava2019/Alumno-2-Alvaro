import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Profesor } from 'src/app/shared/entities/profesor';

@Component({
  selector: 'app-formulario-profesor',
  templateUrl: './formulario-profesor.component.html',
  styleUrls: ['./formulario-profesor.component.scss']
})
export class FormularioProfesorComponent implements OnInit {

	miFormulario: FormGroup;

  @Input()
  modificar = false;

  @Input()
  profesorModificar: Profesor;

  @Output()
  modificado = new EventEmitter<Profesor>();

  constructor(private fb: FormBuilder) {}

  ngOnInit() {
    this.miFormulario = this.fb.group({
      id: this.fb.control(''),
      nombre : this.fb.control('', [Validators.required, Validators.minLength(3)]),
      apellido1 : this.fb.control('', [Validators.required, Validators.minLength(3)]),
      apellido2 : this.fb.control('', [Validators.required, Validators.minLength(3)]),
      nif : this.fb.control('', [Validators.required, Validators.minLength(9), Validators.maxLength(9)]),
      telefono : this.fb.control('', [Validators.required, Validators.maxLength(9)]),
      correo : this.fb.control('', [Validators.required, Validators.email]),
      titulacion : this.fb.control('', [Validators.required, Validators.minLength(3)]),
    });

    if (this.modificar === true) {
      console.log('patch ' + this.profesorModificar);
      this.miFormulario.patchValue (this.profesorModificar);
    }
  }

  guardarCambios() {
    if (this.modificar === false) {
      const profesorForm: Profesor = this.miFormulario.value;
      this.modificado.next(profesorForm);
    } else {
      const profesorForm: Profesor = this.miFormulario.value;
      this.modificado.next(profesorForm);
    }
  }

}
