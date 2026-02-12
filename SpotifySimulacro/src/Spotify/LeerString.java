package Spotify;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LeerString {
	static BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

	public String lector(String frase) {
		while (true) {
			try {
				System.out.println(frase);
				String texto = leer.readLine();
				return texto;

			} catch (IOException e) {
				System.err.println("Error de lectura. Inténtalo de nuevo.");
			} catch (Exception e3) {
				System.err.println("error introducelo de nuevo");
				e3.printStackTrace();
			}
		}
	}
}
