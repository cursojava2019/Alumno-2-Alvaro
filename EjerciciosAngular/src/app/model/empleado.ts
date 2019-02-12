export class Empleado {
  nombre: string;
  edad: number;
  mayorEdad: boolean;

  constructor(nombre: string, edad: number, mayorEdad: boolean ) {
    this.nombre = nombre;
    this.edad = edad;
    this.mayorEdad = mayorEdad;
  }

  esMayorEdad() {
    if (this.edad <= 18) {
      this.mayorEdad = false;
    } else {
      this.mayorEdad = true;
    }
  }
}
