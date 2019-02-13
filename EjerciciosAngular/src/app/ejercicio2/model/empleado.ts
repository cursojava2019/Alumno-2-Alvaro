export class Empleado {
  nombre: string;
  edad: number;
  sueldo: Array<number>;
  constructor(nombre: string, edad: number, sueldo: Array<number>) {
      this.nombre = nombre;
      this.edad = edad;
      this.sueldo = sueldo;
  }
}
