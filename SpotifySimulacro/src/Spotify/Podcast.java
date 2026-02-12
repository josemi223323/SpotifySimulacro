package Spotify;

public class Podcast extends Contenido{
	private String presentador;
	private int episodio;
	private boolean transcripcion;
	@Override
	public void pedirDatos() {
		super.pedirDatos();
		presentador = lectorString.lector("introduce el presentador");
		episodio = lectorInteger.lector("pon el episodio del podcast",true);
		transcripcion = false;
	}
	@Override
	public String toString() {
		return super.toString() + "Podcast [presentador=" + presentador + ", episodio=" + episodio + ", transcripcion=" + transcripcion
				+ "]";
	}
	
}
