package es.indra.ejercicio5;

public class Ejercicio5Main {

	public static void main(String[] args) {
		Serie listaSeries[] = new Serie[5];
		Videojuego listaVideojuegos[] = new Videojuego[5];
		
		listaSeries[0]=new Serie();
        listaSeries[1]=new Serie("Los Simpsons", 25, "Humor", "Matt Groening");
        listaSeries[2]=new Serie("Padre de familia", 12 ,"Humor", "Seth MacFarlane");
        listaSeries[3]=new Serie("Fariña", 1, "Suspense", "A3");
        listaSeries[4]=new Serie("House of Cards", 4 ,"Thriller", "Seth MacFarlane");
        
        listaVideojuegos[0]=new Videojuego();
        listaVideojuegos[1]=new Videojuego("Euro Truck Simulator 2", 0, "Simulación", "SCS Software");
        listaVideojuegos[2]=new Videojuego("Fortnite", 0, "Multijugador", "Epic Games");
        listaVideojuegos[3]=new Videojuego("American Truck Simulator", 0, "Simulación", "SCS Software");
        listaVideojuegos[4]=new Videojuego("DiRT 4", 30, "Conduccion", "Codemasters");
        
        listaSeries[1].entregar();
        listaSeries[3].entregar();
        listaSeries[4].entregar();
        
        listaVideojuegos[1].entregar();
        listaVideojuegos[2].entregar();
        
        int entregados=0;
        
        for(int i=0;i<listaSeries.length;i++){
            if(listaSeries[i].isEntregado()){
                entregados+=1;
                listaSeries[i].devolver();
  
            }
            if(listaVideojuegos[i].isEntregado()){
                entregados+=1;
                listaVideojuegos[i].devolver();
            }
        }
  
        System.out.println("Hay "+entregados+" articulos entregados");

        Serie serieMayor=listaSeries[0];
        Videojuego videojuegoMayor=listaVideojuegos[0];

        for(int i=1;i<listaSeries.length;i++){
            if(listaSeries[i].compareTo(serieMayor)==Serie.MAYOR){
                serieMayor=listaSeries[i];
            }
            if(listaVideojuegos[i].compareTo(videojuegoMayor)==Videojuego.MAYOR){
                videojuegoMayor=listaVideojuegos[i];
            }
  
        }
        System.out.println(videojuegoMayor);
        System.out.println(serieMayor);
	}

}
