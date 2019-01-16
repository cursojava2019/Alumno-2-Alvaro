package es.indra.ejercicio5;

public class Serie implements Entregable {
	private final static int NUMEROTEMPORADAS = 3;
	public final static int MAYOR=1;
    public final static int MENOR=-1;
    public final static int IGUAL=0; 
	private String titulo;
	private int numeroTemporadas;
	private boolean entregado;
	private String genero;
	private String creador;

	public Serie() {
		// TODO Auto-generated constructor stub
	}

	public Serie(String titulo, String creador) {
		super();
		this.titulo = titulo;
		this.creador = creador;
	}

	public Serie(String titulo, int numeroTemporadas, String genero, String creador) {
		super();
		this.titulo = titulo;
		this.numeroTemporadas = numeroTemporadas;
		this.genero = genero;
		this.creador = creador;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getNumeroTemporadas() {
		return numeroTemporadas;
	}

	public void setNumeroTemporadas(int numeroTemporadas) {
		this.numeroTemporadas = numeroTemporadas;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getCreador() {
		return creador;
	}

	public void setCreador(String creador) {
		this.creador = creador;
	}

	public static int getNumerotemporadas() {
		return NUMEROTEMPORADAS;
	}

	@Override
	public String toString() {
		return "La serie con mas temporadas es "+ titulo + " con " + numeroTemporadas + " temporadas";
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
        Serie ref=(Serie)a;
        if (numeroTemporadas>ref.getNumeroTemporadas()){
            estado=MAYOR;
        } else if(numeroTemporadas==ref.getNumeroTemporadas()){
            estado=IGUAL;
        }
        return estado;
	}
}
