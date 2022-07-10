package models;

public class TipoPelicula{
	private Integer id;
	private Integer formato;
	private String idioma;
	private boolean subtitulada;
	public TipoPelicula(String idioma,Boolean subtitulada) {
		this.idioma=idioma;
		this.subtitulada=subtitulada;
	}
	public TipoPelicula(Integer id,Integer formato, String idioma, boolean subtitulada) {
		super();
		this.id=id;
		this.formato = formato;
		this.idioma = idioma;
		this.subtitulada = subtitulada;
	}
	

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getFormato() {
		return formato;
	}

	public void setFormato(Integer formato) {
		this.formato = formato;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public boolean isSubtitulada() {
		return subtitulada;
	}

	public void setSubtitulada(boolean subtitulada) {
		this.subtitulada = subtitulada;
	}
}
