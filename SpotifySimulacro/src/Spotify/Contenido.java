package Spotify;

import java.util.ArrayList;
import java.util.Random;

public class Contenido {
	static Random aleatorio = new Random();
	static LeerInt lectorInteger = new LeerInt();
	static LeerString lectorString = new LeerString();
	private int id;
	private ArrayList<Integer>registroIDS = new ArrayList();
	private String titulo;
	private int minutos;
	private String categoria;
	private int reproduciones;
	private boolean reproducionActiva;
	public int getMinutos() {
		return minutos;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}
	public boolean isReproducionActiva() {
		return reproducionActiva;
	}
	public void setReproducionActiva(boolean reproducionActiva) {
		this.reproducionActiva = reproducionActiva;
	}
	public void pedirDatos() {
		id = generarId();
		registroIDS.add(id);
		titulo = lectorString.lector("introduce el titulo");
		minutos = lectorInteger.lector("introduce los minutos");
		categoria = lectorString.lector("introduce una categoria");
		while(!(categoria.equalsIgnoreCase("musica") || categoria.equalsIgnoreCase("podcast") || categoria.equalsIgnoreCase("audiolibro") || categoria.equalsIgnoreCase("meditacion"))){
			categoria = lectorString.lector("introduce una categoria");
		}
		reproduciones = lectorInteger.lector("introduce las reproducciones");
		reproducionActiva = false;
	}
	private int generarId() {
		int candidatoID = 0;
		do {
		    candidatoID = aleatorio.nextInt(9000) + 1000;
		} while (registroIDS.contains(candidatoID));
		return candidatoID;
	}
	public String getCategoria() {
		return categoria;
	}
	@Override
	public String toString() {
		return "Contenido [ID=" + id + ", titulo=" + titulo + ", minutos=" + minutos + ", categoria=" + categoria
				+ ", reproduciones=" + reproduciones + ", reproducionActiva=" + reproducionActiva + "]";
	}

}
