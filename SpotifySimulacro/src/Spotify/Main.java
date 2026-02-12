package Spotify;

import java.util.ArrayList;

public class Main {
	static LeerInt lectorInteger = new LeerInt();
	static LeerString lectorString = new LeerString();
	static ArrayList<Contenido>contenidos = new ArrayList();
	static int contadorPlayList = 0;
	public static void main(String[] args) {
		boolean seguir = true;
		
		while(seguir) {
			int opcion = lectorInteger.lector("introduce una opcion case 1/2/3/4/5",true);
			switch(opcion) {
				case 1:
					añadirContenidos();
					break;
				case 2:
					mostrarContenidoCategoria();
					break;
				case 3:
					aniadirAPlaylist();
					break;
				case 4:
					estadisticasPerfil();
					break;
				case 5:
					seguir = false;
					System.out.println("adios");
			}
		}

	}
	private static void estadisticasPerfil() {
		int contadorCanciones = 0;
		int contadorPodcast = 0;
		int contadorPodcastRareza = 0;
		int contadorMusica = 0;
		int contadorAudioLibro = 0;
		int contadorMeditacion = 0;
		for(Contenido contenido : contenidos) {
			if(contenido instanceof Cancion) {
				contadorCanciones++;
			}else {
				contadorPodcast++;
			}
			if(contenido.getCategoria().equalsIgnoreCase("podcast")) {
				contadorPodcastRareza++;
				
			}else if(contenido.getCategoria().equalsIgnoreCase("musica")) {
				contadorMusica++;
				
			}else if(contenido.getCategoria().equalsIgnoreCase("audiolibro")) {
				contadorAudioLibro++;
				
			}else if(contenido.getCategoria().equalsIgnoreCase("meditacion")) {
				contadorMeditacion++;
			}
			
		}
		int contadorMinutos = 0;
		for(Contenido contenido : contenidos) {
				contadorMinutos += contenido.getMinutos();
	
		}
			System.out.println("Elementos en la playList: " + contadorPlayList);
			System.out.println("Cantidad de minuto totales: " + contadorMinutos + " minutos");
		    System.out.println("Número de canciones: " + contadorCanciones);
		    System.out.println("Número de podcasts: " + contadorPodcast);
		    System.out.println("Número de podcasts (categoría): " + contadorPodcastRareza);
		    System.out.println("Número de música: " + contadorMusica);
		    System.out.println("Número de audiolibros: " + contadorAudioLibro);
		    System.out.println("Número de meditaciones: " + contadorMeditacion);
		
	}
	private static void aniadirAPlaylist() {
		String cancionBuscada = lectorString.lector("introduce la cancion que buscas para meter en la playlist");
		for(Contenido contenido : contenidos) {
			if(!contenido.isReproducionActiva() && contenido.getTitulo().equalsIgnoreCase(cancionBuscada)) {
				contenido.setReproducionActiva(true);
				contadorPlayList ++;
				System.out.println("la cancion dura: " + contenido.getMinutos());
				System.out.println("Elementos en la playList: " + contadorPlayList);
			}
		}
		
	}
	private static void mostrarContenidoCategoria() {
		String categoriaBuscada = lectorString.lector("introduce una categoria buscada");
		while(!(categoriaBuscada.equalsIgnoreCase("musica") || categoriaBuscada.equalsIgnoreCase("podcast") || categoriaBuscada.equalsIgnoreCase("audiolibro") || categoriaBuscada.equalsIgnoreCase("meditacion"))){
			categoriaBuscada = lectorString.lector("introduce una categoria buscada");
		}
		for(Contenido contenido : contenidos) {
			if(contenido.getCategoria().equalsIgnoreCase(categoriaBuscada)) {
				System.out.println(contenido.toString());
			}
		}
		
	}
	private static void añadirContenidos() {
		int contenidosAniadir = lectorInteger.lector("introduce el numero de contenidos a añadir",true);
		for(int i=0;i<contenidosAniadir;i++) {
			String tipoContenido = lectorString.lector("introduce el tipo del contenido a añadir podcast/cancion");
			while(!(tipoContenido.equalsIgnoreCase("podcast") || tipoContenido.equalsIgnoreCase("cancion"))) {
				tipoContenido = lectorString.lector("introduce el tipo del contenido a añadir podcast/cancion");
			}
			if(tipoContenido.equalsIgnoreCase("podcast")) {
				contenidos.add(new Podcast());
				contenidos.get(contenidos.size()-1).pedirDatos();
			}else if(tipoContenido.equals("cancion")) {
				contenidos.add(new Cancion());
				contenidos.get(contenidos.size()-1).pedirDatos();
			}
		}
		
	}

}
