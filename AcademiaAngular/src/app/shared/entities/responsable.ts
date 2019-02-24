import { Alumno } from './alumno';

export class Responsable {
  constructor(
    public id: number,
	  public nombre: string,
	  public apellido1: string,
	  public apellido2: string,
	  public correo: string,
	  public nif: string,
    public telefono: string,
    public alumnos: Array<Alumno>) {
	}

}
