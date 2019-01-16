package es.indra.ejercicio5;

public class Videojuego implements Entregable {
	private final static int HORASESTIMADAS = 10;
	public final static int MAYOR=1;
    public final static int MENOR=-1;
    public final static int IGUAL=0;
	private String titulo;
	private int horasEstimadas; 
	private boolean entregado;
	private String genero;
	private String compañia;

	public Videojuego() {
		// TODO Auto-generated constructor stub
	}

	public Videojuego(String titulo, int horasEstimadas) {
		super();
		this.titulo = titulo;
		this.horasEstimadas = horasEstimadas;
	}

	public Videojuego(String titulo, int horasEstimadas, String genero, String compañia) {
		super();
		this.titulo = titulo;
		this.horasEstimadas = horasEstimadas;
		this.genero = genero;
		this.compañia = compañia;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getHorasEstimadas() {
		return horasEstimadas;
	}

	public void setHorasEstimadas(int horasEstimadas) {
		this.horasEstimadas = horasEstimadas;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getCompañia() {
		return compañia;
	}

	public void setCompañia(String compañia) {
		this.compañia = compañia;
	}

	public static int getHorasestimadas() {
		return HORASESTIMADAS;
	}

	@Override
	public String toString() {
		return "El videojuego con mas horas es " + titulo + " con " + horasEstimadas + " horas de juego";
	}
	
	@Override
	public void entregar() {
		entregado = true;
		
	}

	@Override
	public void devolver() {
		entregado = false;
		
	}

	@Override
	public boolean isEntregado() {
		if(entregado) {
			return true;
		}
		return false;
	}

	@Override
	public int compareTo(Object a) {
		int estado=MENOR;
        Videojuego ref=(Videojuego)a;
        if (horasEstimadas>ref.getHorasEstimadas()){
            estado=MAYOR;
        } else if(horasEstimadas==ref.getHorasEstimadas()){
            estado=IGUAL;
        }
        return estado;
	}

}
