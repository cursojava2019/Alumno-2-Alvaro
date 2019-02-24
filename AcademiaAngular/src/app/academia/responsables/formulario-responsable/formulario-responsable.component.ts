import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Responsable } from 'src/app/shared/entities/responsable';

@Component({
  selector: 'app-formulario-responsable',
  templateUrl: './formulario-responsable.component.html',
  styleUrls: ['./formulario-responsable.component.scss']
})
export class FormularioResponsableComponent implements OnInit {

	miFormulario: FormGroup;

  @Input()
  modificar = false;

  @Input()
  responsableModificar: Responsable;

  @Output()
  modificado = new EventEmitter<Responsable>();

  constructor(private fb: FormBuilder) { }

  ngOnInit() {
  	this.miFormulario = this.fb.group({
      id : this.fb.control(''),
      nombre : this.fb.control('', [Validators.required, Validators.minLength(3)]),
      apellido1 : this.fb.control('', [Validators.required, Validators.minLength(3)]),
      apellido2 : this.fb.control('', [Validators.required, Validators.minLength(3)]),
      nif : this.fb.control('', [Validators.required, Validators.minLength(9), Validators.maxLength(9)]),
      telefono : this.fb.control('', [Validators.required, Validators.maxLength(9)]),
      correo : this.fb.control('', [Validators.required, Validators.email])
    });

    if (this.modificar === true) {
      console.log('patch ' + this.responsableModificar);
      this.miFormulario.patchValue (this.responsableModificar);
    }
  }

  guardarCambios() {
    if (this.modificar === false) {
      const responsableForm: Responsable = this.miFormulario.value;
      this.modificado.next(responsableForm);
   } else {
    const responsableForm: Responsable = this.miFormulario.value;

     this.modificado.next(responsableForm);
   }

  }

}
