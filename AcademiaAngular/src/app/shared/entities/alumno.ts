import { Responsable } from './responsable';

export class Alumno {
 public responsable: Responsable;
  constructor(
    public id: number,
    public nombre: string,
    public apellido1: string,
    public apellido2: string,
    public correo: string,
    public fechaAlta: Date,
    public fechaBaja: Date,
    public nif: string,
    public observaciones: string,
    public repetidor: boolean,
    public telefono: string,
    public idResponsable: number) {

  }
}
