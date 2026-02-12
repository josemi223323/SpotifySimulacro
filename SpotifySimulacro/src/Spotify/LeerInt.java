package Spotify;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class LeerInt {
	static BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

	public int lector(String frase) {
		while (true) {
			try {
				System.out.println(frase);
				int numero = Integer.parseInt(leer.readLine());
				return numero;

			} catch (NumberFormatException e) {
				System.err.println("Aviso: solo puedes introducir números enteros vuelve a introducir el numero.");
			} catch (IOException e) {
				System.err.println("Error de lectura. Inténtalo de nuevo.");
			} catch (Exception e3) {
				System.err.println("error introducelo de nuevo");
				e3.printStackTrace();

			}
		}
	}
	public int lector(String frase ,Boolean noNegativo) {
		while (true) {
			try {
				System.out.println(frase);
				int numero = Integer.parseInt(leer.readLine());
				while(noNegativo && numero < 0) {
					System.out.println("introduce otra vez el num hasta que sea positivo");
					numero = Integer.parseInt(leer.readLine());
				}
				return numero;

			} catch (NumberFormatException e) {
				System.err.println("Aviso: solo puedes introducir números enteros vuelve a introducir el numero.");
			} catch (IOException e) {
				System.err.println("Error de lectura. Inténtalo de nuevo.");
			} catch (Exception e3) {
				System.err.println("error introducelo de nuevo");
				e3.printStackTrace();

			}
		}
	}
}
