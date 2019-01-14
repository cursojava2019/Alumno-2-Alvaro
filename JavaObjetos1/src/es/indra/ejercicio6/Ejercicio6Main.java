package es.indra.ejercicio6;

public class Ejercicio6Main {

	public static void main(String[] args) {
		Libro l1=new Libro(1234567890, "Jaque al psicoanalista", "John Katzenbach", 440);
        Libro l2=new Libro(1357986420, "Amanece, que no es poco", "Jose Luis Cuerda", 312);
        
        System.out.println(l1.toString());
        System.out.println(l2.toString());
        
        if(l1.getNumeroPaginas()>l2.getNumeroPaginas()){
            System.out.println(l1.getTitulo()+" tiene más páginas que "+l2.getTitulo());
        }else{
            System.out.println(l2.getTitulo()+" tiene más páginas que "+l1.getTitulo());
        }

	}

}
