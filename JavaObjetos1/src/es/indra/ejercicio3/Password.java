package es.indra.ejercicio3;

public class Password {
	private final static int LONGITUD = 8;
	private int longitud;
	private String contrasena; 
	
	public Password() {
		this(LONGITUD);
	}
	
	public Password(int longitud) {
		super();
		this.longitud = longitud;
		contrasena = generarPassword();
	}

	public int getLongitud() {
		return longitud;
	}

	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}

	public String getContrasena() {
		return contrasena;
	}
	
	public boolean esFuerte(){
        int contadorMayusculas=0, contadorMinusculas=0, contadorNumeros=0;
	    for(int i=0; i < contrasena.length(); i++) {           
	        char caracter=contrasena.charAt(i);
	        int ascii=(int)caracter;    
	        
	        if(ascii>=65 && ascii<=90){
	            contadorMayusculas++;
	        }else if(ascii>=97 && ascii<=122){
	            contadorMinusculas++;
	        }else if(ascii>=48 && ascii<=57){
	            contadorNumeros++;
	        }
	    }
    
	    if(contadorMayusculas>=2 && contadorMinusculas>=1 && contadorNumeros>=5){    
	        return true;
	    }else{
	        return false;
	    }
	}
	
	public String generarPassword() {
		contrasena = "";
		for (int i = 0; i < this.longitud; i++) {

			switch ((int) (Math.random() * 3)) {
			case 0:
				contrasena += (char) (Math.random() * 26 + 'A');
				break;
			case 1:
				contrasena += (char) (Math.random() * 26 + 'a');
				break;
			case 2:
				contrasena += (char) (Math.random() * 10 + '0');
				break;
			}
		}
		return contrasena;
	}
}
