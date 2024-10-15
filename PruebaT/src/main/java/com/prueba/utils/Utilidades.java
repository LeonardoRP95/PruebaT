package com.prueba.utils;

import java.io.File;
import java.util.Random;
import org.openqa.selenium.*;
public class Utilidades {
	public static void scrollElemento(WebDriver driver, By locator)
			throws InterruptedException {
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			WebElement element = driver.findElement(locator);
			executor.executeScript("arguments[0].scrollIntoView();", element);
		} catch (Exception e) {
			throw new InterruptedException();
		}
	}
	public static String[][] generarDatosAleatorios(int filas, int columnas) {
		String[][] datos = new String[filas][columnas];
		Random random = new Random();
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				// Generar un valor aleatorio
				datos[i][j] = "Dato" + (i + 1) + "_" + (j + 1) + "_" + random.nextInt(100);
			}
		}
		return datos;
	}
	public static void eliminarArchivo(String rutaArchivo) {
		File archivo = new File(rutaArchivo);
		if (archivo.exists()) {
			if (archivo.delete()) {
			}
		}
	}
	public static boolean validarDescarga(String rutaArchivo) {
		File archivo = new File(rutaArchivo);
		if (archivo.exists()) {
			return true;
		}else {
			return false;
		}
	}
}
