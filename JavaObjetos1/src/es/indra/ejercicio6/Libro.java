package es.indra.ejercicio6;

public class Libro {
	private int ISBN;
	private String titulo;
	private String autor;
	private int numeroPaginas;

	public Libro(int aISBN, String aTitulo, String aAutor, int aNumeroPaginas){
	     
        ISBN=aISBN; 
        titulo=aTitulo;
        autor=aAutor;
        numeroPaginas=aNumeroPaginas;
     
    }
	public int getISBN() {
		return ISBN;
	}

	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setNumeroPaginas(int numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	@Override
	public String toString() {
		return "El libro "+titulo+" con ISBN " +ISBN+ " creado por el autor " +autor+ " tiene "+numeroPaginas+" páginas";
	}

}
