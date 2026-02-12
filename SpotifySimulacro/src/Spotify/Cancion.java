package Spotify;

public class Cancion extends Contenido{
	private String artista;
	private int streams;
	private int lanzamiento;
	public void pedirDatos(){
		super.pedirDatos();
		artista = lectorString.lector("introduce el artista");
		streams = lectorInteger.lector("introduce los streams",true);
		lanzamiento = lectorInteger.lector("pon la fecha de lanzamiento mayor que 1950 y menor o igual que 2025");
		while(lanzamiento < 1950 || lanzamiento > 2025) {
			lanzamiento = lectorInteger.lector("pon la fecha de lanzamiento (esta vez bien crack");
		}
	}
	@Override
	public String toString() {
		return super.toString() + "Cancion [artista=" + artista + ", streams=" + streams + ", lanzamiento=" + lanzamiento + "]";
	}
	
}
