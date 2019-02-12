

export class Calculadora {
    total: number;

    constructor() {
      this.total = 0;
    }
    sumar( sumando: number ) {
      this.total += sumando;
    }
    restar(restando: number ) {
      this.total -= restando;
    }

    multiplica(fact: number) {
      this.total *= fact ;
    }

    dividir(divisor: number) {
      this.total /= divisor;
    }

    reiniciar() {
      this.total = 0;
    }

}
