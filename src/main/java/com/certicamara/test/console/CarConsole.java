package com.certicamara.test.console;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.certicamara.test.bussiness.RemoteControl;
import com.certicamara.test.exception.CommandParseException;

public class CarConsole {

	static boolean stop = false;

	private static RemoteControl control;

	public static void main(String[] args) throws Exception {

		int x = 0;
		int y = 0;
		String input = null;
		control = new RemoteControl();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("************ Controlador de Vehículo *************");

		do {
			System.out.println("Ingrese el # de filas (Solo # Enteros): ");
			input = reader.readLine();
			try {
				x = Integer.parseInt(input);
				stop = true;
			} catch (Exception e) {
				System.out.println("Debe ingresar solo valores numericos");
			}
		} while (stop == false);

		do {
			System.out.println("Ingrese el # de Columnas (Solo # Enteros): ");
			input = reader.readLine();
			try {
				y = Integer.parseInt(input);
				stop = true;
			} catch (Exception e) {
				System.out.println("Debe ingresar solo valores numericos");
			}
		} while (stop == false);

		control.initializeSurface(x, y);

		do {
			System.out.println("Ingrese la lista de comandos ([0-99],[A-Z]): ");
			input = reader.readLine();

			if (input == null || input.equals(""))
				throw new CommandParseException();

			System.out.println("\nLista de movimientos: ");
			System.out.println(control.moveVehicle(input));

		} while (stop == false);

	}

}
