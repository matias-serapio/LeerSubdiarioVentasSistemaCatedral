import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.fusesource.jansi.AnsiConsole;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	public static void main(String[] args) {

		AnsiConsole.systemInstall();

		Scanner scanner = new Scanner(System.in);

		System.out.println("Seleccione una opción:");
		System.out.println("1. Utilizar un único punto de venta");
		System.out.println("2. Utilizar múltiples puntos de venta");

		int opcion = scanner.nextInt();
		scanner.nextLine(); // Consume newline

		System.out.println("Ingrese la ruta del archivo Excel:");
		String filePath = "subdiarioventas.xlsx";
		// String filePath = scanner.nextLine();

		switch (opcion) {
		case 1:
			procesarArchivoExcel(filePath);
			break;
		case 2:
			procesarArchivoExcelMultiplesPuntosDeVenta(filePath);
			break;
		default:
			System.out.println("Opción no válida");
			break;
		}

		scanner.close();
	}

	private static void procesarArchivoExcel(String filePath) {
		// Aquí va tu código original sin modificaciones.

		// Declaraciones Total Neto Gravado
		double totalFacturaAResponsableInscriptoPositivos = 0.0;
		double totalFacturaAResponsableInscriptoNegativos = 0.0;
		double totalFacturaAResponsableInscripto = 0.0;
		double totalFacturaAExentosNoAlcanzadosPositivos = 0.0;
		double totalFacturaAExentosNoAlcanzadosNegativos = 0.0;
		double totalFacturaAExentosNoAlcanzados = 0.0;
		double totalFacturaAMonotributistaPositivos = 0.0;
		double totalFacturaAMonotributistaNegativos = 0.0;
		double totalFacturaAMonotributista = 0.0;
		double totalFacturaAPositivos = 0.0;
		double totalFacturaANegativos = 0.0;
		double totalFacturaA = 0.0;
		double totalFacturaBConsumidorFinalPositivos = 0.0;
		double totalFacturaBConsumidorFinalNegativos = 0.0;
		double totalFacturaBConsumidorFinal = 0.0;
		double totalFacturaBMonotributistaPositivos = 0.0;
		double totalFacturaBMonotributistaNegativos = 0.0;
		double totalFacturaBMonotributista = 0.0;
		double totalFacturaBExentosNoAlcanzadosPositivos = 0.0;
		double totalFacturaBExentosNoAlcanzadosNegativos = 0.0;
		double totalFacturaBExentosNoAlcanzados = 0.0;
		double totalFacturaBPositivos = 0.0;
		double totalFacturaBNegativos = 0.0;
		double totalFacturaB = 0.0;
		double totalFacturaZ_A_Positivos = 0.0;
		double totalFacturaZ_A_Negativos = 0.0;
		double totalFacturaZ_A = 0.0;
		double totalFacturaZ_B_Positivos = 0.0;
		double totalFacturaZ_B_Negativos = 0.0;
		double totalFacturaZ_B = 0.0;
		double totalFacturaZPositivos = 0.0;
		double totalFacturaZNegativos = 0.0;
		double totalFacturaZ = 0.0;
		double totalFacturaAPositivosFacturaZ_A_Positivos = 0.0;
		double totalFacturaANegativosFacturaZ_A_Negativos = 0.0;
		double totalFacturaAFacturaZ_A = 0.0;
		double totalFacturaBPositivosFacturaZ_B_Positivos = 0.0;
		double totalFacturaBNegativosFacturaZ_B_Negativos = 0.0;
		double totalFacturaBFacturaZ_B = 0.0;
		double totalFacturaZ_A_Positivos_Monotributistas = 0.0;
		double totalFacturaZ_B_Positivos_Monotributistas = 0.0;
		double totalFacturaZ_B_Positivos_ConsumidoresFinales = 0.0;
		double totalFacturaZ_A_Positivos_ExentosNoAlcanzados = 0.0;
		double totalFacturaZ_B_Positivos_ExentosNoAlcanzados = 0.0;
		double totalFacturaZ_A_Positivos_ResponsableInscripto = 0.0;

		double totalFacturaZ_A_Negativos_Monotributistas = 0.0;
		double totalFacturaZ_A_Negativos_ResponsableInscripto = 0.0;
		double totalFacturaZ_A_Negativos_ExentosNoAlcanzados = 0.0;
		double totalFacturaZ_B_Negativos_Monotributistas = 0.0;
		double totalFacturaZ_B_Negativos_ExentosNoAlcanzados = 0.0;
		double totalFacturaZ_B_Negativos_ConsumidoresFinales = 0.0;

		// Declaraciones Total Iva
		double totalFacturaAResponsableInscriptoPositivosIva = 0.0;
		double totalFacturaAResponsableInscriptoNegativosIva = 0.0;
		double totalFacturaAResponsableInscriptoIva = 0.0;
		double totalFacturaAExentosNoAlcanzadosPositivosIva = 0.0;
		double totalFacturaAExentosNoAlcanzadosNegativosIva = 0.0;
		double totalFacturaAExentosNoAlcanzadosIva = 0.0;
		double totalFacturaAMonotributistaPositivosIva = 0.0;
		double totalFacturaAMonotributistaNegativosIva = 0.0;
		double totalFacturaAMonotributistaIva = 0.0;
		double totalFacturaAPositivosIva = 0.0;
		double totalFacturaANegativosIva = 0.0;
		double totalFacturaAIva = 0.0;
		double totalFacturaBConsumidorFinalPositivosIva = 0.0;
		double totalFacturaBConsumidorFinalNegativosIva = 0.0;
		double totalFacturaBConsumidorFinalIva = 0.0;
		double totalFacturaBMonotributistaPositivosIva = 0.0;
		double totalFacturaBMonotributistaNegativosIva = 0.0;
		double totalFacturaBMonotributistaIva = 0.0;
		double totalFacturaBExentosNoAlcanzadosPositivosIva = 0.0;
		double totalFacturaBExentosNoAlcanzadosNegativosIva = 0.0;
		double totalFacturaBExentosNoAlcanzadosIva = 0.0;
		double totalFacturaBPositivosIva = 0.0;
		double totalFacturaBNegativosIva = 0.0;
		double totalFacturaBIva = 0.0;
		double totalFacturaZ_A_PositivosIva = 0.0;
		double totalFacturaZ_A_NegativosIva = 0.0;
		double totalFacturaZ_A_Iva = 0.0;
		double totalFacturaZ_B_PositivosIva = 0.0;
		double totalFacturaZ_B_NegativosIva = 0.0;
		double totalFacturaZ_B_Iva = 0.0;
		double totalFacturaZPositivosIva = 0.0;
		double totalFacturaZNegativosIva = 0.0;
		double totalFacturaZIva = 0.0;
		double totalFacturaAPositivosFacturaZ_A_PositivosIva = 0.0;
		double totalFacturaANegativosFacturaZ_A_NegativosIva = 0.0;
		double totalFacturaAFacturaZ_AIva = 0.0;
		double totalFacturaBPositivosFacturaZ_B_PositivosIva = 0.0;
		double totalFacturaBNegativosFacturaZ_B_NegativosIva = 0.0;
		double totalFacturaBFacturaZ_BIva = 0.0;
		double totalFacturaZ_A_Positivos_MonotributistasIva = 0.0;
		double totalFacturaZ_B_Positivos_MonotributistasIva = 0.0;
		double totalFacturaZ_B_Positivos_ConsumidoresFinalesIva = 0.0;
		double totalFacturaZ_A_Positivos_ExentosNoAlcanzadosIva = 0.0;
		double totalFacturaZ_B_Positivos_ExentosNoAlcanzadosIva = 0.0;
		double totalFacturaZ_A_Positivos_ResponsableInscriptoIva = 0.0;

		double totalFacturaZ_A_Negativos_MonotributistasIva = 0.0;
		double totalFacturaZ_A_Negativos_ResponsableInscriptoIva = 0.0;
		double totalFacturaZ_A_Negativos_ExentosNoAlcanzadosIva = 0.0;
		double totalFacturaZ_B_Negativos_MonotributistasIva = 0.0;
		double totalFacturaZ_B_Negativos_ConsumidoresFinalesIva = 0.0;
		double totalFacturaZ_B_Negativos_ExentosNoAlcanzadosIva = 0.0;

		// Declaraciones Neto Gravado 21%
		double totalFacturaAResponsableInscriptoPositivos21 = 0.0;
		double totalFacturaAResponsableInscriptoNegativos21 = 0.0;
		double totalFacturaAResponsableInscripto21 = 0.0;
		double totalFacturaAExentosNoAlcanzadosPositivos21 = 0.0;
		double totalFacturaAExentosNoAlcanzadosNegativos21 = 0.0;
		double totalFacturaAExentosNoAlcanzados21 = 0.0;
		double totalFacturaAMonotributistaPositivos21 = 0.0;
		double totalFacturaAMonotributistaNegativos21 = 0.0;
		double totalFacturaAMonotributista21 = 0.0;
		double totalFacturaAPositivos21 = 0.0;
		double totalFacturaANegativos21 = 0.0;
		double totalFacturaA21 = 0.0;
		double totalFacturaBConsumidorFinalPositivos21 = 0.0;
		double totalFacturaBConsumidorFinalNegativos21 = 0.0;
		double totalFacturaBConsumidorFinal21 = 0.0;
		double totalFacturaBMonotributistaPositivos21 = 0.0;
		double totalFacturaBMonotributistaNegativos21 = 0.0;
		double totalFacturaBMonotributista21 = 0.0;
		double totalFacturaBExentosNoAlcanzadosPositivos21 = 0.0;
		double totalFacturaBExentosNoAlcanzadosNegativos21 = 0.0;
		double totalFacturaBExentosNoAlcanzados21 = 0.0;
		double totalFacturaBPositivos21 = 0.0;
		double totalFacturaBNegativos21 = 0.0;
		double totalFacturaB21 = 0.0;
		double totalFacturaZ_A_Positivos21 = 0.0;
		double totalFacturaZ_A_Negativos21 = 0.0;
		double totalFacturaZ_A21 = 0.0;
		double totalFacturaZ_B_Positivos21 = 0.0;
		double totalFacturaZ_B_Negativos21 = 0.0;
		double totalFacturaZ_B21 = 0.0;
		double totalFacturaZPositivos21 = 0.0;
		double totalFacturaZNegativos21 = 0.0;
		double totalFacturaZ21 = 0.0;
		double totalFacturaAPositivosFacturaZ_A_Positivos21 = 0.0;
		double totalFacturaANegativosFacturaZ_A_Negativos21 = 0.0;
		double totalFacturaAFacturaZ_A21 = 0.0;
		double totalFacturaBPositivosFacturaZ_B_Positivos21 = 0.0;
		double totalFacturaBNegativosFacturaZ_B_Negativos21 = 0.0;
		double totalFacturaBFacturaZ_B21 = 0.0;
		double totalFacturaZ_A_Positivos_Monotributistas21 = 0.0;
		double totalFacturaZ_B_Positivos_Monotributistas21 = 0.0;
		double totalFacturaZ_B_Positivos_ConsumidoresFinales21 = 0.0;
		double totalFacturaZ_A_Positivos_ExentosNoAlcanzados21 = 0.0;
		double totalFacturaZ_B_Positivos_ExentosNoAlcanzados21 = 0.0;
		double totalFacturaZ_A_Positivos_ResponsableInscripto21 = 0.0;

		double totalFacturaZ_A_Negativos_Monotributistas21 = 0.0;
		double totalFacturaZ_A_Negativos_ResponsableInscripto21 = 0.0;
		double totalFacturaZ_A_Negativos_ExentosNoAlcanzados21 = 0.0;
		double totalFacturaZ_B_Negativos_Monotributistas21 = 0.0;
		double totalFacturaZ_B_Negativos_ExentosNoAlcanzados21 = 0.0;
		double totalFacturaZ_B_Negativos_ConsumidoresFinales21 = 0.0;

		// Declaraciones Iva 21%
		double totalFacturaAResponsableInscriptoPositivosIva21 = 0.0;
		double totalFacturaAResponsableInscriptoNegativosIva21 = 0.0;
		double totalFacturaAResponsableInscriptoIva21 = 0.0;
		double totalFacturaAExentosNoAlcanzadosPositivosIva21 = 0.0;
		double totalFacturaAExentosNoAlcanzadosNegativosIva21 = 0.0;
		double totalFacturaAExentosNoAlcanzadosIva21 = 0.0;
		double totalFacturaAMonotributistaPositivosIva21 = 0.0;
		double totalFacturaAMonotributistaNegativosIva21 = 0.0;
		double totalFacturaAMonotributistaIva21 = 0.0;
		double totalFacturaAPositivosIva21 = 0.0;
		double totalFacturaANegativosIva21 = 0.0;
		double totalFacturaAIva21 = 0.0;
		double totalFacturaBConsumidorFinalPositivosIva21 = 0.0;
		double totalFacturaBConsumidorFinalNegativosIva21 = 0.0;
		double totalFacturaBConsumidorFinalIva21 = 0.0;
		double totalFacturaBMonotributistaPositivosIva21 = 0.0;
		double totalFacturaBMonotributistaNegativosIva21 = 0.0;
		double totalFacturaBMonotributistaIva21 = 0.0;
		double totalFacturaBExentosNoAlcanzadosPositivosIva21 = 0.0;
		double totalFacturaBExentosNoAlcanzadosNegativosIva21 = 0.0;
		double totalFacturaBExentosNoAlcanzadosIva21 = 0.0;
		double totalFacturaBPositivosIva21 = 0.0;
		double totalFacturaBNegativosIva21 = 0.0;
		double totalFacturaBIva21 = 0.0;
		double totalFacturaZ_A_PositivosIva21 = 0.0;
		double totalFacturaZ_A_NegativosIva21 = 0.0;
		double totalFacturaZ_A_Iva21 = 0.0;
		double totalFacturaZ_B_PositivosIva21 = 0.0;
		double totalFacturaZ_B_NegativosIva21 = 0.0;
		double totalFacturaZ_B_Iva21 = 0.0;
		double totalFacturaZPositivosIva21 = 0.0;
		double totalFacturaZNegativosIva21 = 0.0;
		double totalFacturaZIva21 = 0.0;
		double totalFacturaAPositivosFacturaZ_A_PositivosIva21 = 0.0;
		double totalFacturaANegativosFacturaZ_A_NegativosIva21 = 0.0;
		double totalFacturaAFacturaZ_AIva21 = 0.0;
		double totalFacturaBPositivosFacturaZ_B_PositivosIva21 = 0.0;
		double totalFacturaBNegativosFacturaZ_B_NegativosIva21 = 0.0;
		double totalFacturaBFacturaZ_BIva21 = 0.0;
		double totalFacturaZ_A_Positivos_MonotributistasIva21 = 0.0;
		double totalFacturaZ_B_Positivos_MonotributistasIva21 = 0.0;
		double totalFacturaZ_B_Positivos_ConsumidoresFinalesIva21 = 0.0;
		double totalFacturaZ_A_Positivos_ExentosNoAlcanzadosIva21 = 0.0;
		double totalFacturaZ_B_Positivos_ExentosNoAlcanzadosIva21 = 0.0;
		double totalFacturaZ_A_Positivos_ResponsableInscriptoIva21 = 0.0;

		double totalFacturaZ_A_Negativos_MonotributistasIva21 = 0.0;
		double totalFacturaZ_A_Negativos_ResponsableInscriptoIva21 = 0.0;
		double totalFacturaZ_A_Negativos_ExentosNoAlcanzadosIva21 = 0.0;
		double totalFacturaZ_B_Negativos_MonotributistasIva21 = 0.0;
		double totalFacturaZ_B_Negativos_ExentosNoAlcanzadosIva21 = 0.0;
		double totalFacturaZ_B_Negativos_ConsumidoresFinalesIva21 = 0.0;

		// Declaraciones Neto Gravado 10,5%
		double totalFacturaAResponsableInscriptoPositivos10_5 = 0.0;
		double totalFacturaAResponsableInscriptoNegativos10_5 = 0.0;
		double totalFacturaAResponsableInscripto10_5 = 0.0;
		double totalFacturaAExentosNoAlcanzadosPositivos10_5 = 0.0;
		double totalFacturaAExentosNoAlcanzadosNegativos10_5 = 0.0;
		double totalFacturaAExentosNoAlcanzados10_5 = 0.0;
		double totalFacturaAMonotributistaPositivos10_5 = 0.0;
		double totalFacturaAMonotributistaNegativos10_5 = 0.0;
		double totalFacturaAMonotributista10_5 = 0.0;
		double totalFacturaAPositivos10_5 = 0.0;
		double totalFacturaANegativos10_5 = 0.0;
		double totalFacturaA10_5 = 0.0;
		double totalFacturaBConsumidorFinalPositivos10_5 = 0.0;
		double totalFacturaBConsumidorFinalNegativos10_5 = 0.0;
		double totalFacturaBConsumidorFinal10_5 = 0.0;
		double totalFacturaBMonotributistaPositivos10_5 = 0.0;
		double totalFacturaBMonotributistaNegativos10_5 = 0.0;
		double totalFacturaBMonotributista10_5 = 0.0;
		double totalFacturaBExentosNoAlcanzadosPositivos10_5 = 0.0;
		double totalFacturaBExentosNoAlcanzadosNegativos10_5 = 0.0;
		double totalFacturaBExentosNoAlcanzados10_5 = 0.0;
		double totalFacturaBPositivos10_5 = 0.0;
		double totalFacturaBNegativos10_5 = 0.0;
		double totalFacturaB10_5 = 0.0;
		double totalFacturaZ_A_Positivos10_5 = 0.0;
		double totalFacturaZ_A_Negativos10_5 = 0.0;
		double totalFacturaZ_A10_5 = 0.0;
		double totalFacturaZ_B_Positivos10_5 = 0.0;
		double totalFacturaZ_B_Negativos10_5 = 0.0;
		double totalFacturaZ_B10_5 = 0.0;
		double totalFacturaZPositivos10_5 = 0.0;
		double totalFacturaZNegativos10_5 = 0.0;
		double totalFacturaZ10_5 = 0.0;
		double totalFacturaAPositivosFacturaZ_A_Positivos10_5 = 0.0;
		double totalFacturaANegativosFacturaZ_A_Negativos10_5 = 0.0;
		double totalFacturaAFacturaZ_A10_5 = 0.0;
		double totalFacturaBPositivosFacturaZ_B_Positivos10_5 = 0.0;
		double totalFacturaBNegativosFacturaZ_B_Negativos10_5 = 0.0;
		double totalFacturaBFacturaZ_B10_5 = 0.0;
		double totalFacturaZ_A_Positivos_Monotributistas10_5 = 0.0;
		double totalFacturaZ_B_Positivos_Monotributistas10_5 = 0.0;
		double totalFacturaZ_B_Positivos_ConsumidoresFinales10_5 = 0.0;
		double totalFacturaZ_A_Positivos_ExentosNoAlcanzados10_5 = 0.0;
		double totalFacturaZ_B_Positivos_ExentosNoAlcanzados10_5 = 0.0;
		double totalFacturaZ_A_Positivos_ResponsableInscripto10_5 = 0.0;

		double totalFacturaZ_A_Negativos_Monotributistas10_5 = 0.0;
		double totalFacturaZ_A_Negativos_ResponsableInscripto10_5 = 0.0;
		double totalFacturaZ_A_Negativos_ExentosNoAlcanzados10_5 = 0.0;
		double totalFacturaZ_B_Negativos_Monotributistas10_5 = 0.0;
		double totalFacturaZ_B_Negativos_ExentosNoAlcanzados10_5 = 0.0;
		double totalFacturaZ_B_Negativos_ConsumidoresFinales10_5 = 0.0;

		// Declaraciones Iva 10,5%
		double totalFacturaAResponsableInscriptoPositivosIva10_5 = 0.0;
		double totalFacturaAResponsableInscriptoNegativosIva10_5 = 0.0;
		double totalFacturaAResponsableInscriptoIva10_5 = 0.0;
		double totalFacturaAExentosNoAlcanzadosPositivosIva10_5 = 0.0;
		double totalFacturaAExentosNoAlcanzadosNegativosIva10_5 = 0.0;
		double totalFacturaAExentosNoAlcanzadosIva10_5 = 0.0;
		double totalFacturaAMonotributistaPositivosIva10_5 = 0.0;
		double totalFacturaAMonotributistaNegativosIva10_5 = 0.0;
		double totalFacturaAMonotributistaIva10_5 = 0.0;
		double totalFacturaAPositivosIva10_5 = 0.0;
		double totalFacturaANegativosIva10_5 = 0.0;
		double totalFacturaAIva10_5 = 0.0;
		double totalFacturaBConsumidorFinalPositivosIva10_5 = 0.0;
		double totalFacturaBConsumidorFinalNegativosIva10_5 = 0.0;
		double totalFacturaBConsumidorFinalIva10_5 = 0.0;
		double totalFacturaBMonotributistaPositivosIva10_5 = 0.0;
		double totalFacturaBMonotributistaNegativosIva10_5 = 0.0;
		double totalFacturaBMonotributistaIva10_5 = 0.0;
		double totalFacturaBExentosNoAlcanzadosPositivosIva10_5 = 0.0;
		double totalFacturaBExentosNoAlcanzadosNegativosIva10_5 = 0.0;
		double totalFacturaBExentosNoAlcanzadosIva10_5 = 0.0;
		double totalFacturaBPositivosIva10_5 = 0.0;
		double totalFacturaBNegativosIva10_5 = 0.0;
		double totalFacturaBIva10_5 = 0.0;
		double totalFacturaZ_A_PositivosIva10_5 = 0.0;
		double totalFacturaZ_A_NegativosIva10_5 = 0.0;
		double totalFacturaZ_A_Iva10_5 = 0.0;
		double totalFacturaZ_B_PositivosIva10_5 = 0.0;
		double totalFacturaZ_B_NegativosIva10_5 = 0.0;
		double totalFacturaZ_B_Iva10_5 = 0.0;
		double totalFacturaZPositivosIva10_5 = 0.0;
		double totalFacturaZNegativosIva10_5 = 0.0;
		double totalFacturaZIva10_5 = 0.0;
		double totalFacturaAPositivosFacturaZ_A_PositivosIva10_5 = 0.0;
		double totalFacturaANegativosFacturaZ_A_NegativosIva10_5 = 0.0;
		double totalFacturaAFacturaZ_AIva10_5 = 0.0;
		double totalFacturaBPositivosFacturaZ_B_PositivosIva10_5 = 0.0;
		double totalFacturaBNegativosFacturaZ_B_NegativosIva10_5 = 0.0;
		double totalFacturaBFacturaZ_BIva10_5 = 0.0;
		double totalFacturaZ_A_Positivos_MonotributistasIva10_5 = 0.0;
		double totalFacturaZ_B_Positivos_MonotributistasIva10_5 = 0.0;
		double totalFacturaZ_B_Positivos_ConsumidoresFinalesIva10_5 = 0.0;
		double totalFacturaZ_A_Positivos_ExentosNoAlcanzadosIva10_5 = 0.0;
		double totalFacturaZ_B_Positivos_ExentosNoAlcanzadosIva10_5 = 0.0;
		double totalFacturaZ_A_Positivos_ResponsableInscriptoIva10_5 = 0.0;

		double totalFacturaZ_A_Negativos_MonotributistasIva10_5 = 0.0;
		double totalFacturaZ_A_Negativos_ResponsableInscriptoIva10_5 = 0.0;
		double totalFacturaZ_A_Negativos_ExentosNoAlcanzadosIva10_5 = 0.0;
		double totalFacturaZ_B_Negativos_MonotributistasIva10_5 = 0.0;
		double totalFacturaZ_B_Negativos_ExentosNoAlcanzadosIva10_5 = 0.0;
		double totalFacturaZ_B_Negativos_ConsumidoresFinalesIva10_5 = 0.0;

		// Declaraciones Neto Gravado 27%
		double totalFacturaAResponsableInscriptoPositivos27 = 0.0;
		double totalFacturaAResponsableInscriptoNegativos27 = 0.0;
		double totalFacturaAResponsableInscripto27 = 0.0;
		double totalFacturaAExentosNoAlcanzadosPositivos27 = 0.0;
		double totalFacturaAExentosNoAlcanzadosNegativos27 = 0.0;
		double totalFacturaAExentosNoAlcanzados27 = 0.0;
		double totalFacturaAMonotributistaPositivos27 = 0.0;
		double totalFacturaAMonotributistaNegativos27 = 0.0;
		double totalFacturaAMonotributista27 = 0.0;
		double totalFacturaAPositivos27 = 0.0;
		double totalFacturaANegativos27 = 0.0;
		double totalFacturaA27 = 0.0;
		double totalFacturaBConsumidorFinalPositivos27 = 0.0;
		double totalFacturaBConsumidorFinalNegativos27 = 0.0;
		double totalFacturaBConsumidorFinal27 = 0.0;
		double totalFacturaBMonotributistaPositivos27 = 0.0;
		double totalFacturaBMonotributistaNegativos27 = 0.0;
		double totalFacturaBMonotributista27 = 0.0;
		double totalFacturaBExentosNoAlcanzadosPositivos27 = 0.0;
		double totalFacturaBExentosNoAlcanzadosNegativos27 = 0.0;
		double totalFacturaBExentosNoAlcanzados27 = 0.0;
		double totalFacturaBPositivos27 = 0.0;
		double totalFacturaBNegativos27 = 0.0;
		double totalFacturaB27 = 0.0;
		double totalFacturaZ_A_Positivos27 = 0.0;
		double totalFacturaZ_A_Negativos27 = 0.0;
		double totalFacturaZ_A27 = 0.0;
		double totalFacturaZ_B_Positivos27 = 0.0;
		double totalFacturaZ_B_Negativos27 = 0.0;
		double totalFacturaZ_B27 = 0.0;
		double totalFacturaZPositivos27 = 0.0;
		double totalFacturaZNegativos27 = 0.0;
		double totalFacturaZ27 = 0.0;
		double totalFacturaAPositivosFacturaZ_A_Positivos27 = 0.0;
		double totalFacturaANegativosFacturaZ_A_Negativos27 = 0.0;
		double totalFacturaAFacturaZ_A27 = 0.0;
		double totalFacturaBPositivosFacturaZ_B_Positivos27 = 0.0;
		double totalFacturaBNegativosFacturaZ_B_Negativos27 = 0.0;
		double totalFacturaBFacturaZ_B27 = 0.0;
		double totalFacturaZ_A_Positivos_Monotributistas27 = 0.0;
		double totalFacturaZ_B_Positivos_Monotributistas27 = 0.0;
		double totalFacturaZ_B_Positivos_ConsumidoresFinales27 = 0.0;
		double totalFacturaZ_A_Positivos_ExentosNoAlcanzados27 = 0.0;
		double totalFacturaZ_B_Positivos_ExentosNoAlcanzados27 = 0.0;
		double totalFacturaZ_A_Positivos_ResponsableInscripto27 = 0.0;

		double totalFacturaZ_A_Negativos_Monotributistas27 = 0.0;
		double totalFacturaZ_A_Negativos_ResponsableInscripto27 = 0.0;
		double totalFacturaZ_A_Negativos_ExentosNoAlcanzados27 = 0.0;
		double totalFacturaZ_B_Negativos_Monotributistas27 = 0.0;
		double totalFacturaZ_B_Negativos_ExentosNoAlcanzados27 = 0.0;
		double totalFacturaZ_B_Negativos_ConsumidoresFinales27 = 0.0;

		// Declaraciones Iva 27%
		double totalFacturaAResponsableInscriptoPositivosIva27 = 0.0;
		double totalFacturaAResponsableInscriptoNegativosIva27 = 0.0;
		double totalFacturaAResponsableInscriptoIva27 = 0.0;
		double totalFacturaAExentosNoAlcanzadosPositivosIva27 = 0.0;
		double totalFacturaAExentosNoAlcanzadosNegativosIva27 = 0.0;
		double totalFacturaAExentosNoAlcanzadosIva27 = 0.0;
		double totalFacturaAMonotributistaPositivosIva27 = 0.0;
		double totalFacturaAMonotributistaNegativosIva27 = 0.0;
		double totalFacturaAMonotributistaIva27 = 0.0;
		double totalFacturaAPositivosIva27 = 0.0;
		double totalFacturaANegativosIva27 = 0.0;
		double totalFacturaAIva27 = 0.0;
		double totalFacturaBConsumidorFinalPositivosIva27 = 0.0;
		double totalFacturaBConsumidorFinalNegativosIva27 = 0.0;
		double totalFacturaBConsumidorFinalIva27 = 0.0;
		double totalFacturaBMonotributistaPositivosIva27 = 0.0;
		double totalFacturaBMonotributistaNegativosIva27 = 0.0;
		double totalFacturaBMonotributistaIva27 = 0.0;
		double totalFacturaBExentosNoAlcanzadosPositivosIva27 = 0.0;
		double totalFacturaBExentosNoAlcanzadosNegativosIva27 = 0.0;
		double totalFacturaBExentosNoAlcanzadosIva27 = 0.0;
		double totalFacturaBPositivosIva27 = 0.0;
		double totalFacturaBNegativosIva27 = 0.0;
		double totalFacturaBIva27 = 0.0;
		double totalFacturaZ_A_PositivosIva27 = 0.0;
		double totalFacturaZ_A_NegativosIva27 = 0.0;
		double totalFacturaZ_A_Iva27 = 0.0;
		double totalFacturaZ_B_PositivosIva27 = 0.0;
		double totalFacturaZ_B_NegativosIva27 = 0.0;
		double totalFacturaZ_B_Iva27 = 0.0;
		double totalFacturaZPositivosIva27 = 0.0;
		double totalFacturaZNegativosIva27 = 0.0;
		double totalFacturaZIva27 = 0.0;
		double totalFacturaAPositivosFacturaZ_A_PositivosIva27 = 0.0;
		double totalFacturaANegativosFacturaZ_A_NegativosIva27 = 0.0;
		double totalFacturaAFacturaZ_AIva27 = 0.0;
		double totalFacturaBPositivosFacturaZ_B_PositivosIva27 = 0.0;
		double totalFacturaBNegativosFacturaZ_B_NegativosIva27 = 0.0;
		double totalFacturaBFacturaZ_BIva27 = 0.0;
		double totalFacturaZ_A_Positivos_MonotributistasIva27 = 0.0;
		double totalFacturaZ_B_Positivos_MonotributistasIva27 = 0.0;
		double totalFacturaZ_B_Positivos_ConsumidoresFinalesIva27 = 0.0;
		double totalFacturaZ_A_Positivos_ExentosNoAlcanzadosIva27 = 0.0;
		double totalFacturaZ_B_Positivos_ExentosNoAlcanzadosIva27 = 0.0;
		double totalFacturaZ_A_Positivos_ResponsableInscriptoIva27 = 0.0;

		double totalFacturaZ_A_Negativos_MonotributistasIva27 = 0.0;
		double totalFacturaZ_A_Negativos_ResponsableInscriptoIva27 = 0.0;
		double totalFacturaZ_A_Negativos_ExentosNoAlcanzadosIva27 = 0.0;
		double totalFacturaZ_B_Negativos_MonotributistasIva27 = 0.0;
		double totalFacturaZ_B_Negativos_ExentosNoAlcanzadosIva27 = 0.0;
		double totalFacturaZ_B_Negativos_ConsumidoresFinalesIva27 = 0.0;

		// He encapsulado el código en este método para mantener la lógica separada.
		try (FileInputStream fis = new FileInputStream(filePath); Workbook workbook = new XSSFWorkbook(fis)) {
			Sheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.iterator();
			rowIterator.next(); // Skip first header row
			rowIterator.next(); // Skip second header row

			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				Cell totalNetoGravadoCell = row.getCell(28);
				Cell totalNetoGravado21Cell = row.getCell(12);
				Cell totalNetoGravado10_5Cell = row.getCell(13);
				Cell totalNetoGravado27Cell = row.getCell(14);
				Cell totalIva21Cell = row.getCell(17);
				Cell totalIva10_5Cell = row.getCell(18);
				Cell totalIva27Cell = row.getCell(19);
				Cell letraCell = row.getCell(3);
				Cell numeroClienteCell = row.getCell(10);
				Cell razonSocialCell = row.getCell(8);
				Cell tipoDocumentoCell = row.getCell(9);
				Cell totalIvaCell = row.getCell(29);
				Cell codigoIvaCell = row.getCell(11);
				Cell exentoCell = row.getCell(22);
				Cell nroComprobanteCell = row.getCell(5);
				boolean requiereRevision = false;

				if (totalNetoGravadoCell != null) {
					double totalNetoGravado;
					double totalIva;
					double totalNetoGravado21;
					double totalNetoGravado10_5;
					double totalNetoGravado27;
					double totalIva21;
					double totalIva10_5;
					double totalIva27;
					double nroComprobante;

					try {
						if (nroComprobanteCell.getCellType() == CellType.NUMERIC) {
							nroComprobante = nroComprobanteCell.getNumericCellValue();
						} else if (nroComprobanteCell.getCellType() == CellType.STRING) {
							nroComprobante = Double
									.parseDouble(nroComprobanteCell.getStringCellValue().replace(",", ""));
						} else {
							System.out.println("La celda no contiene un valor numérico: " + totalNetoGravadoCell);
							continue;
						}
						if (totalNetoGravadoCell.getCellType() == CellType.NUMERIC) {
							totalNetoGravado = totalNetoGravadoCell.getNumericCellValue();
						} else if (totalNetoGravadoCell.getCellType() == CellType.STRING) {
							totalNetoGravado = Double
									.parseDouble(totalNetoGravadoCell.getStringCellValue().replace(",", ""));
						} else {
							System.out.println("La celda no contiene un valor numérico: " + totalNetoGravadoCell);
							continue;
						}
						if (totalIvaCell.getCellType() == CellType.NUMERIC) {
							totalIva = totalIvaCell.getNumericCellValue();
						} else if (totalIvaCell.getCellType() == CellType.STRING) {
							totalIva = Double.parseDouble(totalIvaCell.getStringCellValue().replace(",", ""));
						} else {
							System.out.println("La celda no contiene un valor numérico: " + totalIvaCell);
							continue;
						}
						if (totalNetoGravado21Cell.getCellType() == CellType.NUMERIC) {
							totalNetoGravado21 = totalNetoGravado21Cell.getNumericCellValue();
						} else if (totalNetoGravado21Cell.getCellType() == CellType.STRING) {
							totalNetoGravado21 = Double
									.parseDouble(totalNetoGravado21Cell.getStringCellValue().replace(",", ""));
						} else {
							System.out.println("La celda no contiene un valor numérico: " + totalNetoGravado21Cell);
							continue;
						}
						if (totalIva21Cell.getCellType() == CellType.NUMERIC) {
							totalIva21 = totalIva21Cell.getNumericCellValue();
						} else if (totalIva21Cell.getCellType() == CellType.STRING) {
							totalIva21 = Double.parseDouble(totalIva21Cell.getStringCellValue().replace(",", ""));
						} else {
							System.out.println("La celda no contiene un valor numérico: " + totalIva21Cell);
							continue;
						}
						if (totalNetoGravado10_5Cell.getCellType() == CellType.NUMERIC) {
							totalNetoGravado10_5 = totalNetoGravado10_5Cell.getNumericCellValue();
						} else if (totalNetoGravado10_5Cell.getCellType() == CellType.STRING) {
							totalNetoGravado10_5 = Double
									.parseDouble(totalNetoGravado10_5Cell.getStringCellValue().replace(",", ""));
						} else {
							System.out.println("La celda no contiene un valor numérico: " + totalNetoGravado10_5Cell);
							continue;
						}
						if (totalIva10_5Cell.getCellType() == CellType.NUMERIC) {
							totalIva10_5 = totalIva10_5Cell.getNumericCellValue();
						} else if (totalIva10_5Cell.getCellType() == CellType.STRING) {
							totalIva10_5 = Double.parseDouble(totalIva10_5Cell.getStringCellValue().replace(",", ""));
						} else {
							System.out.println("La celda no contiene un valor numérico: " + totalIva10_5Cell);
							continue;
						}

						if (totalNetoGravado27Cell.getCellType() == CellType.NUMERIC) {
							totalNetoGravado27 = totalNetoGravado27Cell.getNumericCellValue();
						} else if (totalNetoGravado27Cell.getCellType() == CellType.STRING) {
							totalNetoGravado27 = Double
									.parseDouble(totalNetoGravado27Cell.getStringCellValue().replace(",", ""));
						} else {
							System.out.println("La celda no contiene un valor numérico: " + totalNetoGravado27Cell);
							continue;
						}
						if (totalIva27Cell.getCellType() == CellType.NUMERIC) {
							totalIva27 = totalIva27Cell.getNumericCellValue();
						} else if (totalIva27Cell.getCellType() == CellType.STRING) {
							totalIva27 = Double.parseDouble(totalIva27Cell.getStringCellValue().replace(",", ""));
						} else {
							System.out.println("La celda no contiene un valor numérico: " + totalIva27Cell);
							continue;
						}
					} catch (NumberFormatException e) {
						System.out.println("Error al convertir el valor: " + totalNetoGravadoCell);
						continue;
					}

					String formattedTotalNetoGravado = String.format("%.2f", totalNetoGravado);
					String formattedTotalIva = String.format("%.2f", totalIva);
					String formattednroComprobante = String.format("%.0f", nroComprobante);
					if (letraCell != null && letraCell.getCellType() == CellType.STRING) {
						String letra = letraCell.getStringCellValue();
						String numeroCliente = numeroClienteCell != null
								&& numeroClienteCell.getCellType() == CellType.STRING
										? numeroClienteCell.getStringCellValue()
										: "";
						String razonSocial = razonSocialCell != null && razonSocialCell.getCellType() == CellType.STRING
								? razonSocialCell.getStringCellValue()
								: "";
						String tipoDocumento = tipoDocumentoCell != null
								&& tipoDocumentoCell.getCellType() == CellType.STRING
										? tipoDocumentoCell.getStringCellValue()
										: "";
						String codigoIva = codigoIvaCell != null && codigoIvaCell.getCellType() == CellType.STRING
								? codigoIvaCell.getStringCellValue()
								: "";
						String exento = exentoCell != null && exentoCell.getCellType() == CellType.STRING
								? exentoCell.getStringCellValue()
								: "";

						if (totalNetoGravado < 0) {
							System.out.println("N° Comprobante: " + formattednroComprobante.replace(".", ",")
									+ " Nota de Crédito: " + formattedTotalNetoGravado.replace(".", ",") + " - IVA: "
									+ formattedTotalIva.replace(".", ","));
						} else {
							System.out.println("N° Comprobante: " + formattednroComprobante.replace(".", ",")
									+ " Factura Positiva: " + formattedTotalNetoGravado.replace(".", ",") + " - IVA: "
									+ formattedTotalIva.replace(".", ","));
						}

						// Aquí debes incluir todo el bloque de lógica que ya tenías
						// ...
						if (letra.equalsIgnoreCase("A")) {
							if (numeroCliente.startsWith("2")) {
								System.out.println("Factura " + letra + " - Monotributista: "
										+ formattedTotalNetoGravado.replace(".", ",") + " - IVA: "
										+ formattedTotalIva.replace(".", ",") + "\n");
								if (totalNetoGravado > 0) {
									totalFacturaAMonotributistaPositivos += totalNetoGravado;
									totalFacturaAMonotributistaPositivosIva += totalIva;
									totalFacturaAMonotributistaPositivos21 += totalNetoGravado21;
									totalFacturaAMonotributistaPositivosIva21 += totalIva21;
									totalFacturaAMonotributistaPositivos10_5 += totalNetoGravado10_5;
									totalFacturaAMonotributistaPositivosIva10_5 += totalIva10_5;
									totalFacturaAMonotributistaPositivos27 += totalNetoGravado27;
									totalFacturaAMonotributistaPositivosIva27 += totalIva27;

									totalFacturaAPositivosFacturaZ_A_Positivos += totalNetoGravado;
									totalFacturaAPositivosFacturaZ_A_PositivosIva += totalIva;
									totalFacturaAPositivosFacturaZ_A_Positivos21 += totalNetoGravado21;
									totalFacturaAPositivosFacturaZ_A_PositivosIva21 += totalIva21;
									totalFacturaAPositivosFacturaZ_A_Positivos10_5 += totalNetoGravado10_5;
									totalFacturaAPositivosFacturaZ_A_PositivosIva10_5 += totalIva10_5;
									totalFacturaAPositivosFacturaZ_A_Positivos27 += totalNetoGravado27;
									totalFacturaAPositivosFacturaZ_A_PositivosIva27 += totalIva27;

								} else if (totalNetoGravado < 0) {
									totalFacturaAMonotributistaNegativos += totalNetoGravado;
									totalFacturaAMonotributistaNegativosIva += totalIva;
									totalFacturaAMonotributistaNegativos21 += totalNetoGravado21;
									totalFacturaAMonotributistaNegativosIva21 += totalIva21;
									totalFacturaAMonotributistaNegativos10_5 += totalNetoGravado10_5;
									totalFacturaAMonotributistaNegativosIva10_5 += totalIva10_5;
									totalFacturaAMonotributistaNegativos27 += totalNetoGravado27;
									totalFacturaAMonotributistaNegativosIva27 += totalIva27;

									totalFacturaANegativosFacturaZ_A_Negativos += totalNetoGravado;
									totalFacturaANegativosFacturaZ_A_NegativosIva += totalIva;
									totalFacturaANegativosFacturaZ_A_Negativos21 += totalNetoGravado21;
									totalFacturaANegativosFacturaZ_A_NegativosIva21 += totalIva21;
									totalFacturaANegativosFacturaZ_A_Negativos10_5 += totalNetoGravado10_5;
									totalFacturaANegativosFacturaZ_A_NegativosIva10_5 += totalIva10_5;
									totalFacturaANegativosFacturaZ_A_Negativos27 += totalNetoGravado27;
									totalFacturaANegativosFacturaZ_A_NegativosIva27 += totalIva27;

								}
								totalFacturaAMonotributista += totalNetoGravado;
								totalFacturaAMonotributistaIva += totalIva;
								totalFacturaAMonotributista21 += totalNetoGravado21;
								totalFacturaAMonotributistaIva21 += totalIva21;
								totalFacturaAMonotributista10_5 += totalNetoGravado10_5;
								totalFacturaAMonotributistaIva10_5 += totalIva10_5;
								totalFacturaAMonotributista27 += totalNetoGravado27;
								totalFacturaAMonotributistaIva27 += totalIva27;
							} else if (numeroCliente.startsWith("3") || codigoIva.equalsIgnoreCase("RI")) {
								System.out.println("Factura " + letra + " - Responsable Inscripto (RI): "
										+ formattedTotalNetoGravado.replace(".", ",") + " - IVA: "
										+ formattedTotalIva.replace(".", ",") + "\n");
								if (totalNetoGravado > 0) {
									totalFacturaAResponsableInscriptoPositivos += totalNetoGravado;
									totalFacturaAResponsableInscriptoPositivosIva += totalIva;
									totalFacturaAResponsableInscriptoPositivos21 += totalNetoGravado21;
									totalFacturaAResponsableInscriptoPositivosIva21 += totalIva21;
									totalFacturaAResponsableInscriptoPositivos10_5 += totalNetoGravado10_5;
									totalFacturaAResponsableInscriptoPositivosIva10_5 += totalIva10_5;
									totalFacturaAResponsableInscriptoPositivos27 += totalNetoGravado27;
									totalFacturaAResponsableInscriptoPositivosIva27 += totalIva27;

									totalFacturaAPositivosFacturaZ_A_Positivos += totalNetoGravado;
									totalFacturaAPositivosFacturaZ_A_PositivosIva += totalIva;
									totalFacturaAPositivosFacturaZ_A_Positivos21 += totalNetoGravado21;
									totalFacturaAPositivosFacturaZ_A_PositivosIva21 += totalIva21;
									totalFacturaAPositivosFacturaZ_A_Positivos10_5 += totalNetoGravado10_5;
									totalFacturaAPositivosFacturaZ_A_PositivosIva10_5 += totalIva10_5;
									totalFacturaAPositivosFacturaZ_A_Positivos27 += totalNetoGravado27;
									totalFacturaAPositivosFacturaZ_A_PositivosIva27 += totalIva27;

								} else if (totalNetoGravado < 0) {
									totalFacturaAResponsableInscriptoNegativos += totalNetoGravado;
									totalFacturaAResponsableInscriptoNegativosIva += totalIva;
									totalFacturaAResponsableInscriptoNegativos21 += totalNetoGravado21;
									totalFacturaAResponsableInscriptoNegativosIva21 += totalIva21;
									totalFacturaAResponsableInscriptoNegativos10_5 += totalNetoGravado10_5;
									totalFacturaAResponsableInscriptoNegativosIva10_5 += totalIva10_5;
									totalFacturaAResponsableInscriptoNegativos27 += totalNetoGravado27;
									totalFacturaAResponsableInscriptoNegativosIva27 += totalIva27;

									totalFacturaANegativosFacturaZ_A_Negativos += totalNetoGravado;
									totalFacturaANegativosFacturaZ_A_NegativosIva += totalIva;
									totalFacturaANegativosFacturaZ_A_Negativos21 += totalNetoGravado21;
									totalFacturaANegativosFacturaZ_A_NegativosIva21 += totalIva21;
									totalFacturaANegativosFacturaZ_A_Negativos10_5 += totalNetoGravado10_5;
									totalFacturaANegativosFacturaZ_A_NegativosIva10_5 += totalIva10_5;
									totalFacturaANegativosFacturaZ_A_Negativos27 += totalNetoGravado27;
									totalFacturaANegativosFacturaZ_A_NegativosIva27 += totalIva27;

								}
								totalFacturaAResponsableInscripto += totalNetoGravado;
								totalFacturaAResponsableInscriptoIva += totalIva;
								totalFacturaAResponsableInscripto21 += totalNetoGravado21;
								totalFacturaAResponsableInscriptoIva21 += totalIva21;
								totalFacturaAResponsableInscripto10_5 += totalNetoGravado10_5;
								totalFacturaAResponsableInscriptoIva10_5 += totalIva10_5;
								totalFacturaAResponsableInscripto27 += totalNetoGravado27;
								totalFacturaAResponsableInscriptoIva27 += totalIva27;
							} else if (codigoIva.equalsIgnoreCase("NCA") || exento.startsWith("0") != false) {
								System.out.println("Factura " + letra + " - Exentos, no Alcanzados, no Gravados: "
										+ formattedTotalNetoGravado.replace(".", ",") + " - IVA: "
										+ formattedTotalIva.replace(".", ",") + "\n");
								if (totalNetoGravado > 0) {
									totalFacturaAExentosNoAlcanzadosPositivos += totalNetoGravado;
									totalFacturaAExentosNoAlcanzadosPositivosIva += totalIva;
									totalFacturaAExentosNoAlcanzadosPositivos21 += totalNetoGravado21;
									totalFacturaAExentosNoAlcanzadosPositivosIva21 += totalIva21;
									totalFacturaAExentosNoAlcanzadosPositivos10_5 += totalNetoGravado10_5;
									totalFacturaAExentosNoAlcanzadosPositivosIva10_5 += totalIva10_5;
									totalFacturaAExentosNoAlcanzadosPositivos27 += totalNetoGravado27;
									totalFacturaAExentosNoAlcanzadosPositivosIva27 += totalIva27;

									totalFacturaAPositivosFacturaZ_A_Positivos += totalNetoGravado;
									totalFacturaAPositivosFacturaZ_A_PositivosIva += totalIva;
									totalFacturaAPositivosFacturaZ_A_Positivos21 += totalNetoGravado21;
									totalFacturaAPositivosFacturaZ_A_PositivosIva21 += totalIva21;
									totalFacturaAPositivosFacturaZ_A_Positivos10_5 += totalNetoGravado10_5;
									totalFacturaAPositivosFacturaZ_A_PositivosIva10_5 += totalIva10_5;
									totalFacturaAPositivosFacturaZ_A_Positivos27 += totalNetoGravado27;
									totalFacturaAPositivosFacturaZ_A_PositivosIva27 += totalIva27;

								} else if (totalNetoGravado < 0) {
									totalFacturaAExentosNoAlcanzadosNegativos += totalNetoGravado;
									totalFacturaAExentosNoAlcanzadosNegativosIva += totalIva;
									totalFacturaAExentosNoAlcanzadosNegativos21 += totalNetoGravado21;
									totalFacturaAExentosNoAlcanzadosNegativosIva21 += totalIva21;
									totalFacturaAExentosNoAlcanzadosNegativos10_5 += totalNetoGravado10_5;
									totalFacturaAExentosNoAlcanzadosNegativosIva10_5 += totalIva10_5;
									totalFacturaAExentosNoAlcanzadosNegativos27 += totalNetoGravado27;
									totalFacturaAExentosNoAlcanzadosNegativosIva27 += totalIva27;

									totalFacturaANegativosFacturaZ_A_Negativos += totalNetoGravado;
									totalFacturaANegativosFacturaZ_A_NegativosIva += totalIva;
									totalFacturaANegativosFacturaZ_A_Negativos21 += totalNetoGravado21;
									totalFacturaANegativosFacturaZ_A_NegativosIva21 += totalIva21;
									totalFacturaANegativosFacturaZ_A_Negativos10_5 += totalNetoGravado10_5;
									totalFacturaANegativosFacturaZ_A_NegativosIva10_5 += totalIva10_5;
									totalFacturaANegativosFacturaZ_A_Negativos27 += totalNetoGravado27;
									totalFacturaANegativosFacturaZ_A_NegativosIva27 += totalIva27;

								}
								totalFacturaAExentosNoAlcanzados += totalNetoGravado;
								totalFacturaAExentosNoAlcanzadosIva += totalIva;
								totalFacturaAExentosNoAlcanzados21 += totalNetoGravado21;
								totalFacturaAExentosNoAlcanzadosIva21 += totalIva21;
								totalFacturaAExentosNoAlcanzados10_5 += totalNetoGravado10_5;
								totalFacturaAExentosNoAlcanzadosIva10_5 += totalIva10_5;
								totalFacturaAExentosNoAlcanzados27 += totalNetoGravado27;
								totalFacturaAExentosNoAlcanzadosIva27 += totalIva27;
							}
							if (totalNetoGravado > 0) {
								totalFacturaAPositivos += totalNetoGravado;
								totalFacturaAPositivosIva += totalIva;
								totalFacturaAPositivos21 += totalNetoGravado21;
								totalFacturaAPositivosIva21 += totalIva21;
								totalFacturaAPositivos10_5 += totalNetoGravado10_5;
								totalFacturaAPositivosIva10_5 += totalIva10_5;
								totalFacturaAPositivos27 += totalNetoGravado27;
								totalFacturaAPositivosIva27 += totalIva27;

							} else if (totalNetoGravado < 0) {
								totalFacturaANegativos += totalNetoGravado;
								totalFacturaANegativosIva += totalIva;
								totalFacturaANegativos21 += totalNetoGravado21;
								totalFacturaANegativosIva21 += totalIva21;
								totalFacturaANegativos10_5 += totalNetoGravado10_5;
								totalFacturaANegativosIva10_5 += totalIva10_5;
								totalFacturaANegativos27 += totalNetoGravado27;
								totalFacturaANegativosIva27 += totalIva27;

							}
							totalFacturaA += totalNetoGravado;
							totalFacturaAIva += totalIva;
							totalFacturaA21 += totalNetoGravado21;
							totalFacturaAIva21 += totalIva21;
							totalFacturaA10_5 += totalNetoGravado10_5;
							totalFacturaAIva10_5 += totalIva10_5;
							totalFacturaA27 += totalNetoGravado27;
							totalFacturaAIva27 += totalIva27;

							totalFacturaAFacturaZ_A += totalNetoGravado;
							totalFacturaAFacturaZ_AIva += totalIva;
							totalFacturaAFacturaZ_A21 += totalNetoGravado21;
							totalFacturaAFacturaZ_AIva21 += totalIva21;
							totalFacturaAFacturaZ_A10_5 += totalNetoGravado10_5;
							totalFacturaAFacturaZ_AIva10_5 += totalIva10_5;
							totalFacturaAFacturaZ_A27 += totalNetoGravado27;
							totalFacturaAFacturaZ_AIva27 += totalIva27;

						} else if (letra.equalsIgnoreCase("B")) {
							if (numeroCliente.startsWith("2")) {
								System.out.println("Factura " + letra + " - Monotributista: "
										+ formattedTotalNetoGravado.replace(".", ",") + " - IVA: "
										+ formattedTotalIva.replace(".", ",") + "\n");
								if (totalNetoGravado > 0) {
									totalFacturaBMonotributistaPositivos += totalNetoGravado;
									totalFacturaBMonotributistaPositivosIva += totalIva;
									totalFacturaBMonotributistaPositivos21 += totalNetoGravado21;
									totalFacturaBMonotributistaPositivosIva21 += totalIva21;
									totalFacturaBMonotributistaPositivos10_5 += totalNetoGravado10_5;
									totalFacturaBMonotributistaPositivosIva10_5 += totalIva10_5;
									totalFacturaBMonotributistaPositivos27 += totalNetoGravado27;
									totalFacturaBMonotributistaPositivosIva27 += totalIva27;

									totalFacturaBPositivosFacturaZ_B_Positivos += totalNetoGravado;
									totalFacturaBPositivosFacturaZ_B_PositivosIva += totalIva;
									totalFacturaBPositivosFacturaZ_B_Positivos21 += totalNetoGravado21;
									totalFacturaBPositivosFacturaZ_B_PositivosIva21 += totalIva21;
									totalFacturaBPositivosFacturaZ_B_Positivos10_5 += totalNetoGravado10_5;
									totalFacturaBPositivosFacturaZ_B_PositivosIva10_5 += totalIva10_5;
									totalFacturaBPositivosFacturaZ_B_Positivos27 += totalNetoGravado27;
									totalFacturaBPositivosFacturaZ_B_PositivosIva27 += totalIva27;

								} else if (totalNetoGravado < 0) {
									totalFacturaBMonotributistaNegativos += totalNetoGravado;
									totalFacturaBMonotributistaNegativosIva += totalIva;
									totalFacturaBMonotributistaNegativos21 += totalNetoGravado21;
									totalFacturaBMonotributistaNegativosIva21 += totalIva21;
									totalFacturaBMonotributistaNegativos10_5 += totalNetoGravado10_5;
									totalFacturaBMonotributistaNegativosIva10_5 += totalIva10_5;
									totalFacturaBMonotributistaNegativos27 += totalNetoGravado27;
									totalFacturaBMonotributistaNegativosIva27 += totalIva27;

									totalFacturaBNegativosFacturaZ_B_Negativos += totalNetoGravado;
									totalFacturaBNegativosFacturaZ_B_NegativosIva += totalIva;
									totalFacturaBNegativosFacturaZ_B_Negativos21 += totalNetoGravado21;
									totalFacturaBNegativosFacturaZ_B_NegativosIva21 += totalIva21;
									totalFacturaBNegativosFacturaZ_B_Negativos10_5 += totalNetoGravado10_5;
									totalFacturaBNegativosFacturaZ_B_NegativosIva10_5 += totalIva10_5;
									totalFacturaBNegativosFacturaZ_B_Negativos27 += totalNetoGravado27;
									totalFacturaBNegativosFacturaZ_B_NegativosIva27 += totalIva27;
								}
								totalFacturaBMonotributista += totalNetoGravado;
								totalFacturaBMonotributistaIva += totalIva;
								totalFacturaBMonotributista21 += totalNetoGravado21;
								totalFacturaBMonotributistaIva21 += totalIva21;
								totalFacturaBMonotributista10_5 += totalNetoGravado10_5;
								totalFacturaBMonotributistaIva10_5 += totalIva10_5;
								totalFacturaBMonotributista27 += totalNetoGravado27;
								totalFacturaBMonotributistaIva27 += totalIva27;
							} else if (numeroCliente.startsWith("3") || codigoIva.equalsIgnoreCase("NCA")
									|| exento.startsWith("0") != false) {
								System.out.println("Factura " + letra + " - Exentos, no Alcanzados, no Gravados: "
										+ formattedTotalNetoGravado.replace(".", ",") + " - IVA: "
										+ formattedTotalIva.replace(".", ",") + "\n");
								if (totalNetoGravado > 0) {
									totalFacturaBExentosNoAlcanzadosPositivos += totalNetoGravado;
									totalFacturaBExentosNoAlcanzadosPositivosIva += totalIva;
									totalFacturaBExentosNoAlcanzadosPositivos21 += totalNetoGravado21;
									totalFacturaBExentosNoAlcanzadosPositivosIva21 += totalIva21;
									totalFacturaBExentosNoAlcanzadosPositivos10_5 += totalNetoGravado10_5;
									totalFacturaBExentosNoAlcanzadosPositivosIva10_5 += totalIva10_5;
									totalFacturaBExentosNoAlcanzadosPositivos27 += totalNetoGravado27;
									totalFacturaBExentosNoAlcanzadosPositivosIva27 += totalIva27;

									totalFacturaBPositivosFacturaZ_B_Positivos += totalNetoGravado;
									totalFacturaBPositivosFacturaZ_B_PositivosIva += totalIva;
									totalFacturaBPositivosFacturaZ_B_Positivos21 += totalNetoGravado21;
									totalFacturaBPositivosFacturaZ_B_PositivosIva21 += totalIva21;
									totalFacturaBPositivosFacturaZ_B_Positivos10_5 += totalNetoGravado10_5;
									totalFacturaBPositivosFacturaZ_B_PositivosIva10_5 += totalIva10_5;
									totalFacturaBPositivosFacturaZ_B_Positivos27 += totalNetoGravado27;
									totalFacturaBPositivosFacturaZ_B_PositivosIva27 += totalIva27;

								} else if (totalNetoGravado < 0) {
									totalFacturaBExentosNoAlcanzadosNegativos += totalNetoGravado;
									totalFacturaBExentosNoAlcanzadosNegativosIva += totalIva;
									totalFacturaBExentosNoAlcanzadosNegativos21 += totalNetoGravado21;
									totalFacturaBExentosNoAlcanzadosNegativosIva21 += totalIva21;
									totalFacturaBExentosNoAlcanzadosNegativos10_5 += totalNetoGravado10_5;
									totalFacturaBExentosNoAlcanzadosNegativosIva10_5 += totalIva10_5;
									totalFacturaBExentosNoAlcanzadosNegativos27 += totalNetoGravado27;
									totalFacturaBExentosNoAlcanzadosNegativosIva27 += totalIva27;

									totalFacturaBNegativosFacturaZ_B_Negativos += totalNetoGravado;
									totalFacturaBNegativosFacturaZ_B_NegativosIva += totalIva;
									totalFacturaBNegativosFacturaZ_B_Negativos21 += totalNetoGravado21;
									totalFacturaBNegativosFacturaZ_B_NegativosIva21 += totalIva21;
									totalFacturaBNegativosFacturaZ_B_Negativos10_5 += totalNetoGravado10_5;
									totalFacturaBNegativosFacturaZ_B_NegativosIva10_5 += totalIva10_5;
									totalFacturaBNegativosFacturaZ_B_Negativos27 += totalNetoGravado27;
									totalFacturaBNegativosFacturaZ_B_NegativosIva27 += totalIva27;
								}
								totalFacturaBExentosNoAlcanzados += totalNetoGravado;
								totalFacturaBExentosNoAlcanzadosIva += totalIva;
								totalFacturaBExentosNoAlcanzados21 += totalNetoGravado21;
								totalFacturaBExentosNoAlcanzadosIva21 += totalIva21;
								totalFacturaBExentosNoAlcanzados10_5 += totalNetoGravado10_5;
								totalFacturaBExentosNoAlcanzadosIva10_5 += totalIva10_5;
								totalFacturaBExentosNoAlcanzados27 += totalNetoGravado27;
								totalFacturaBExentosNoAlcanzadosIva27 += totalIva27;
							} else if (numeroCliente.startsWith("0") || numeroCliente.isEmpty()
									|| razonSocial.equalsIgnoreCase("Consumidor Final")
									|| codigoIva.equalsIgnoreCase("CF")) {
								System.out.println("Factura " + letra + " - Consumidor Final: "
										+ formattedTotalNetoGravado.replace(".", ",") + " - IVA: "
										+ formattedTotalIva.replace(".", ",") + "\n");
								if (totalNetoGravado > 0) {
									totalFacturaBConsumidorFinalPositivos += totalNetoGravado;
									totalFacturaBConsumidorFinalPositivosIva += totalIva;
									totalFacturaBConsumidorFinalPositivos21 += totalNetoGravado21;
									totalFacturaBConsumidorFinalPositivosIva21 += totalIva21;
									totalFacturaBConsumidorFinalPositivos10_5 += totalNetoGravado10_5;
									totalFacturaBConsumidorFinalPositivosIva10_5 += totalIva10_5;
									totalFacturaBConsumidorFinalPositivos27 += totalNetoGravado27;
									totalFacturaBConsumidorFinalPositivosIva27 += totalIva27;

									totalFacturaBPositivosFacturaZ_B_Positivos += totalNetoGravado;
									totalFacturaBPositivosFacturaZ_B_PositivosIva += totalIva;
									totalFacturaBPositivosFacturaZ_B_Positivos21 += totalNetoGravado21;
									totalFacturaBPositivosFacturaZ_B_PositivosIva21 += totalIva21;
									totalFacturaBPositivosFacturaZ_B_Positivos10_5 += totalNetoGravado10_5;
									totalFacturaBPositivosFacturaZ_B_PositivosIva10_5 += totalIva10_5;
									totalFacturaBPositivosFacturaZ_B_Positivos27 += totalNetoGravado27;
									totalFacturaBPositivosFacturaZ_B_PositivosIva27 += totalIva27;

								} else if (totalNetoGravado < 0) {
									totalFacturaBConsumidorFinalNegativos += totalNetoGravado;
									totalFacturaBConsumidorFinalNegativosIva += totalIva;
									totalFacturaBConsumidorFinalNegativos21 += totalNetoGravado21;
									totalFacturaBConsumidorFinalNegativosIva21 += totalIva21;
									totalFacturaBConsumidorFinalNegativos10_5 += totalNetoGravado10_5;
									totalFacturaBConsumidorFinalNegativosIva10_5 += totalIva10_5;
									totalFacturaBConsumidorFinalNegativos27 += totalNetoGravado27;
									totalFacturaBConsumidorFinalNegativosIva27 += totalIva27;

									totalFacturaBNegativosFacturaZ_B_Negativos += totalNetoGravado;
									totalFacturaBNegativosFacturaZ_B_NegativosIva += totalIva;
									totalFacturaBNegativosFacturaZ_B_Negativos21 += totalNetoGravado21;
									totalFacturaBNegativosFacturaZ_B_NegativosIva21 += totalIva21;
									totalFacturaBNegativosFacturaZ_B_Negativos10_5 += totalNetoGravado10_5;
									totalFacturaBNegativosFacturaZ_B_NegativosIva10_5 += totalIva10_5;
									totalFacturaBNegativosFacturaZ_B_Negativos27 += totalNetoGravado27;
									totalFacturaBNegativosFacturaZ_B_NegativosIva27 += totalIva27;
								}
								totalFacturaBConsumidorFinal += totalNetoGravado;
								totalFacturaBConsumidorFinalIva += totalIva;
								totalFacturaBConsumidorFinal21 += totalNetoGravado21;
								totalFacturaBConsumidorFinalIva21 += totalIva21;
								totalFacturaBConsumidorFinal10_5 += totalNetoGravado10_5;
								totalFacturaBConsumidorFinalIva10_5 += totalIva10_5;
								totalFacturaBConsumidorFinal27 += totalNetoGravado27;
								totalFacturaBConsumidorFinalIva27 += totalIva27;
							}
							if (totalNetoGravado > 0) {
								totalFacturaBPositivos += totalNetoGravado;
								totalFacturaBPositivosIva += totalIva;
								totalFacturaBPositivos21 += totalNetoGravado21;
								totalFacturaBPositivosIva21 += totalIva21;
								totalFacturaBPositivos10_5 += totalNetoGravado10_5;
								totalFacturaBPositivosIva10_5 += totalIva10_5;
								totalFacturaBPositivos27 += totalNetoGravado27;
								totalFacturaBPositivosIva27 += totalIva27;

							} else if (totalNetoGravado < 0) {
								totalFacturaBNegativos += totalNetoGravado;
								totalFacturaBNegativosIva += totalIva;
								totalFacturaBNegativos21 += totalNetoGravado21;
								totalFacturaBNegativosIva21 += totalIva21;
								totalFacturaBNegativos10_5 += totalNetoGravado10_5;
								totalFacturaBNegativosIva10_5 += totalIva10_5;
								totalFacturaBNegativos27 += totalNetoGravado27;
								totalFacturaBNegativosIva27 += totalIva27;
							}
							totalFacturaB += totalNetoGravado;
							totalFacturaBIva += totalIva;
							totalFacturaB21 += totalNetoGravado21;
							totalFacturaBIva21 += totalIva21;
							totalFacturaB10_5 += totalNetoGravado10_5;
							totalFacturaBIva10_5 += totalIva10_5;
							totalFacturaB27 += totalNetoGravado27;
							totalFacturaBIva27 += totalIva27;

							totalFacturaBFacturaZ_B += totalNetoGravado;
							totalFacturaBFacturaZ_BIva += totalIva;
							totalFacturaBFacturaZ_B21 += totalNetoGravado21;
							totalFacturaBFacturaZ_BIva21 += totalIva21;
							totalFacturaBFacturaZ_B10_5 += totalNetoGravado10_5;
							totalFacturaBFacturaZ_BIva10_5 += totalIva10_5;
							totalFacturaBFacturaZ_B27 += totalNetoGravado27;
							totalFacturaBFacturaZ_BIva27 += totalIva27;

						} else if (letra.equalsIgnoreCase("Z")) {

							totalFacturaZ += totalNetoGravado;
							totalFacturaZIva += totalIva;
							totalFacturaZ21 += totalNetoGravado21;
							totalFacturaZIva21 += totalIva21;
							totalFacturaZ10_5 += totalNetoGravado10_5;
							totalFacturaZIva10_5 += totalIva10_5;
							totalFacturaZ27 += totalNetoGravado27;
							totalFacturaZIva27 += totalIva27;
							if (totalNetoGravado > 0) {
								totalFacturaZPositivos += totalNetoGravado;
								totalFacturaZPositivosIva += totalIva;
								totalFacturaZPositivos21 += totalNetoGravado21;
								totalFacturaZPositivosIva21 += totalIva21;
								totalFacturaZPositivos10_5 += totalNetoGravado10_5;
								totalFacturaZPositivosIva10_5 += totalIva10_5;
								totalFacturaZPositivos27 += totalNetoGravado27;
								totalFacturaZPositivosIva27 += totalIva27;
							} else if (totalNetoGravado < 0) {
								totalFacturaZNegativos += totalNetoGravado;
								totalFacturaZNegativosIva += totalIva;
								totalFacturaZNegativos21 += totalNetoGravado21;
								totalFacturaZNegativosIva21 += totalIva21;
								totalFacturaZNegativos10_5 += totalNetoGravado10_5;
								totalFacturaZNegativosIva10_5 += totalIva10_5;
								totalFacturaZNegativos27 += totalNetoGravado27;
								totalFacturaZNegativosIva27 += totalIva27;
							}
							if (numeroCliente.startsWith("2")) {
								System.out.println("Factura " + letra + " - Monotributista: "
										+ formattedTotalNetoGravado.replace(".", ",") + " - IVA: "
										+ formattedTotalIva.replace(".", ",") + "\n");
								totalFacturaZ_A += totalNetoGravado;
								totalFacturaZ_A_Iva += totalIva;
								totalFacturaZ_A21 += totalNetoGravado21;
								totalFacturaZ_A_Iva21 += totalIva21;
								totalFacturaZ_A10_5 += totalNetoGravado10_5;
								totalFacturaZ_A_Iva10_5 += totalIva10_5;
								totalFacturaZ_A27 += totalNetoGravado27;
								totalFacturaZ_A_Iva27 += totalIva27;

								if (totalNetoGravado > 0) {
									totalFacturaZ_A_Positivos += totalNetoGravado;
									totalFacturaZ_A_PositivosIva += totalIva;
									totalFacturaZ_A_Positivos21 += totalNetoGravado21;
									totalFacturaZ_A_PositivosIva21 += totalIva21;
									totalFacturaZ_A_Positivos10_5 += totalNetoGravado10_5;
									totalFacturaZ_A_PositivosIva10_5 += totalIva10_5;
									totalFacturaZ_A_Positivos27 += totalNetoGravado27;
									totalFacturaZ_A_PositivosIva27 += totalIva27;

									totalFacturaAPositivosFacturaZ_A_Positivos += totalNetoGravado;
									totalFacturaAPositivosFacturaZ_A_PositivosIva += totalIva;
									totalFacturaAPositivosFacturaZ_A_Positivos21 += totalNetoGravado21;
									totalFacturaAPositivosFacturaZ_A_PositivosIva21 += totalIva21;
									totalFacturaAPositivosFacturaZ_A_Positivos10_5 += totalNetoGravado10_5;
									totalFacturaAPositivosFacturaZ_A_PositivosIva10_5 += totalIva10_5;
									totalFacturaAPositivosFacturaZ_A_Positivos27 += totalNetoGravado27;
									totalFacturaAPositivosFacturaZ_A_PositivosIva27 += totalIva27;

									totalFacturaZ_A_Positivos_Monotributistas += totalNetoGravado;
									totalFacturaZ_A_Positivos_MonotributistasIva += totalIva;
									totalFacturaZ_A_Positivos_Monotributistas21 += totalNetoGravado21;
									totalFacturaZ_A_Positivos_MonotributistasIva21 += totalIva21;
									totalFacturaZ_A_Positivos_Monotributistas10_5 += totalNetoGravado10_5;
									totalFacturaZ_A_Positivos_MonotributistasIva10_5 += totalIva10_5;
									totalFacturaZ_A_Positivos_Monotributistas27 += totalNetoGravado27;
									totalFacturaZ_A_Positivos_MonotributistasIva27 += totalIva27;

								} else if (totalNetoGravado < 0) {
									totalFacturaZ_A_Negativos += totalNetoGravado;
									totalFacturaZ_A_NegativosIva += totalIva;
									totalFacturaZ_A_Negativos21 += totalNetoGravado21;
									totalFacturaZ_A_NegativosIva21 += totalIva21;
									totalFacturaZ_A_Negativos10_5 += totalNetoGravado10_5;
									totalFacturaZ_A_NegativosIva10_5 += totalIva10_5;
									totalFacturaZ_A_Negativos27 += totalNetoGravado27;
									totalFacturaZ_A_NegativosIva27 += totalIva27;

									totalFacturaANegativosFacturaZ_A_Negativos += totalNetoGravado;
									totalFacturaANegativosFacturaZ_A_NegativosIva += totalIva;
									totalFacturaANegativosFacturaZ_A_Negativos21 += totalNetoGravado21;
									totalFacturaANegativosFacturaZ_A_NegativosIva21 += totalIva21;
									totalFacturaANegativosFacturaZ_A_Negativos10_5 += totalNetoGravado10_5;
									totalFacturaANegativosFacturaZ_A_NegativosIva10_5 += totalIva10_5;
									totalFacturaANegativosFacturaZ_A_Negativos27 += totalNetoGravado27;
									totalFacturaANegativosFacturaZ_A_NegativosIva27 += totalIva27;

									totalFacturaZ_A_Negativos_Monotributistas += totalNetoGravado;
									totalFacturaZ_A_Negativos_MonotributistasIva += totalIva;
									totalFacturaZ_A_Negativos_Monotributistas21 += totalNetoGravado21;
									totalFacturaZ_A_Negativos_MonotributistasIva21 += totalIva21;
									totalFacturaZ_A_Negativos_Monotributistas10_5 += totalNetoGravado10_5;
									totalFacturaZ_A_Negativos_MonotributistasIva10_5 += totalIva10_5;
									totalFacturaZ_A_Negativos_Monotributistas27 += totalNetoGravado27;
									totalFacturaZ_A_Negativos_MonotributistasIva27 += totalIva27;

								}
								totalFacturaAFacturaZ_A += totalNetoGravado;
								totalFacturaAFacturaZ_AIva += totalIva;
								totalFacturaAFacturaZ_A21 += totalNetoGravado21;
								totalFacturaAFacturaZ_AIva21 += totalIva21;
								totalFacturaAFacturaZ_A10_5 += totalNetoGravado10_5;
								totalFacturaAFacturaZ_AIva10_5 += totalIva10_5;
								totalFacturaAFacturaZ_A27 += totalNetoGravado27;
								totalFacturaAFacturaZ_AIva27 += totalIva27;

							} else if (numeroCliente.startsWith("3") || codigoIva.equalsIgnoreCase("RI")) {
								System.out.println("Factura " + letra + " - Responsable Inscripto (RI): "
										+ formattedTotalNetoGravado.replace(".", ",") + " - IVA: "
										+ formattedTotalIva.replace(".", ",") + "\n");
								totalFacturaZ_A += totalNetoGravado;
								totalFacturaZ_A_Iva += totalIva;
								totalFacturaZ_A21 += totalNetoGravado21;
								totalFacturaZ_A_Iva21 += totalIva21;
								totalFacturaZ_A10_5 += totalNetoGravado10_5;
								totalFacturaZ_A_Iva10_5 += totalIva10_5;
								totalFacturaZ_A27 += totalNetoGravado27;
								totalFacturaZ_A_Iva27 += totalIva27;
								if (totalNetoGravado > 0) {
									totalFacturaZ_A_Positivos += totalNetoGravado;
									totalFacturaZ_A_PositivosIva += totalIva;
									totalFacturaZ_A_Positivos21 += totalNetoGravado21;
									totalFacturaZ_A_PositivosIva21 += totalIva21;
									totalFacturaZ_A_Positivos10_5 += totalNetoGravado10_5;
									totalFacturaZ_A_PositivosIva10_5 += totalIva10_5;
									totalFacturaZ_A_Positivos27 += totalNetoGravado27;
									totalFacturaZ_A_PositivosIva27 += totalIva27;

									totalFacturaAPositivosFacturaZ_A_Positivos += totalNetoGravado;
									totalFacturaAPositivosFacturaZ_A_PositivosIva += totalIva;
									totalFacturaAPositivosFacturaZ_A_Positivos21 += totalNetoGravado21;
									totalFacturaAPositivosFacturaZ_A_PositivosIva21 += totalIva21;
									totalFacturaAPositivosFacturaZ_A_Positivos10_5 += totalNetoGravado10_5;
									totalFacturaAPositivosFacturaZ_A_PositivosIva10_5 += totalIva10_5;
									totalFacturaAPositivosFacturaZ_A_Positivos27 += totalNetoGravado27;
									totalFacturaAPositivosFacturaZ_A_PositivosIva27 += totalIva27;

									totalFacturaZ_A_Positivos_ResponsableInscripto += totalNetoGravado;
									totalFacturaZ_A_Positivos_ResponsableInscriptoIva += totalIva;
									totalFacturaZ_A_Positivos_ResponsableInscripto21 += totalNetoGravado21;
									totalFacturaZ_A_Positivos_ResponsableInscriptoIva21 += totalIva21;
									totalFacturaZ_A_Positivos_ResponsableInscripto10_5 += totalNetoGravado10_5;
									totalFacturaZ_A_Positivos_ResponsableInscriptoIva10_5 += totalIva10_5;
									totalFacturaZ_A_Positivos_ResponsableInscripto27 += totalNetoGravado27;
									totalFacturaZ_A_Positivos_ResponsableInscriptoIva27 += totalIva27;

								} else if (totalNetoGravado < 0) {
									totalFacturaZ_A_Negativos += totalNetoGravado;
									totalFacturaZ_A_NegativosIva += totalIva;
									totalFacturaZ_A_Negativos21 += totalNetoGravado21;
									totalFacturaZ_A_NegativosIva21 += totalIva21;
									totalFacturaZ_A_Negativos10_5 += totalNetoGravado10_5;
									totalFacturaZ_A_NegativosIva10_5 += totalIva10_5;
									totalFacturaZ_A_Negativos27 += totalNetoGravado27;
									totalFacturaZ_A_NegativosIva27 += totalIva27;

									totalFacturaANegativosFacturaZ_A_Negativos += totalNetoGravado;
									totalFacturaANegativosFacturaZ_A_NegativosIva += totalIva;
									totalFacturaANegativosFacturaZ_A_Negativos21 += totalNetoGravado21;
									totalFacturaANegativosFacturaZ_A_NegativosIva21 += totalIva21;
									totalFacturaANegativosFacturaZ_A_Negativos10_5 += totalNetoGravado10_5;
									totalFacturaANegativosFacturaZ_A_NegativosIva10_5 += totalIva10_5;
									totalFacturaANegativosFacturaZ_A_Negativos27 += totalNetoGravado27;
									totalFacturaANegativosFacturaZ_A_NegativosIva27 += totalIva27;

									totalFacturaZ_A_Negativos_ResponsableInscripto += totalNetoGravado;
									totalFacturaZ_A_Negativos_ResponsableInscriptoIva += totalIva;
									totalFacturaZ_A_Negativos_ResponsableInscripto21 += totalNetoGravado21;
									totalFacturaZ_A_Negativos_ResponsableInscriptoIva21 += totalIva21;
									totalFacturaZ_A_Negativos_ResponsableInscripto10_5 += totalNetoGravado10_5;
									totalFacturaZ_A_Negativos_ResponsableInscriptoIva10_5 += totalIva10_5;
									totalFacturaZ_A_Negativos_ResponsableInscripto27 += totalNetoGravado27;
									totalFacturaZ_A_Negativos_ResponsableInscriptoIva27 += totalIva27;

								}
								totalFacturaAFacturaZ_A += totalNetoGravado;
								totalFacturaAFacturaZ_AIva += totalIva;
								totalFacturaAFacturaZ_A21 += totalNetoGravado21;
								totalFacturaAFacturaZ_AIva21 += totalIva21;
								totalFacturaAFacturaZ_A10_5 += totalNetoGravado10_5;
								totalFacturaAFacturaZ_AIva10_5 += totalIva10_5;
								totalFacturaAFacturaZ_A27 += totalNetoGravado27;
								totalFacturaAFacturaZ_AIva27 += totalIva27;

							} else if (numeroCliente.startsWith("0") || numeroCliente.isEmpty()
									|| razonSocial.equalsIgnoreCase("Consumidor Final")
									|| codigoIva.equalsIgnoreCase("CF")) {
								System.out.println("Factura " + letra + " - Consumidor Final: "
										+ formattedTotalNetoGravado.replace(".", ",") + " - IVA: "
										+ formattedTotalIva.replace(".", ",") + "\n");
								totalFacturaZ_B += totalNetoGravado;
								totalFacturaZ_B_Iva += totalIva;
								totalFacturaZ_B21 += totalNetoGravado21;
								totalFacturaZ_B_Iva21 += totalIva21;
								totalFacturaZ_B10_5 += totalNetoGravado10_5;
								totalFacturaZ_B_Iva10_5 += totalIva10_5;
								totalFacturaZ_B27 += totalNetoGravado27;
								totalFacturaZ_B_Iva27 += totalIva27;
								if (totalNetoGravado > 0) {
									totalFacturaZ_B_Positivos += totalNetoGravado;
									totalFacturaZ_B_PositivosIva += totalIva;
									totalFacturaZ_B_Positivos21 += totalNetoGravado21;
									totalFacturaZ_B_PositivosIva21 += totalIva21;
									totalFacturaZ_B_Positivos10_5 += totalNetoGravado10_5;
									totalFacturaZ_B_PositivosIva10_5 += totalIva10_5;
									totalFacturaZ_B_Positivos27 += totalNetoGravado27;
									totalFacturaZ_B_PositivosIva27 += totalIva27;

									totalFacturaBPositivosFacturaZ_B_Positivos += totalNetoGravado;
									totalFacturaBPositivosFacturaZ_B_PositivosIva += totalIva;
									totalFacturaBPositivosFacturaZ_B_Positivos21 += totalNetoGravado21;
									totalFacturaBPositivosFacturaZ_B_PositivosIva21 += totalIva21;
									totalFacturaBPositivosFacturaZ_B_Positivos10_5 += totalNetoGravado10_5;
									totalFacturaBPositivosFacturaZ_B_PositivosIva10_5 += totalIva10_5;
									totalFacturaBPositivosFacturaZ_B_Positivos27 += totalNetoGravado27;
									totalFacturaBPositivosFacturaZ_B_PositivosIva27 += totalIva27;

									totalFacturaZ_B_Positivos_ConsumidoresFinales += totalNetoGravado;
									totalFacturaZ_B_Positivos_ConsumidoresFinalesIva += totalIva;
									totalFacturaZ_B_Positivos_ConsumidoresFinales21 += totalNetoGravado21;
									totalFacturaZ_B_Positivos_ConsumidoresFinalesIva21 += totalIva21;
									totalFacturaZ_B_Positivos_ConsumidoresFinales10_5 += totalNetoGravado10_5;
									totalFacturaZ_B_Positivos_ConsumidoresFinalesIva10_5 += totalIva10_5;
									totalFacturaZ_B_Positivos_ConsumidoresFinales27 += totalNetoGravado27;
									totalFacturaZ_B_Positivos_ConsumidoresFinalesIva27 += totalIva27;

								} else if (totalNetoGravado < 0) {
									totalFacturaZ_B_Negativos += totalNetoGravado;
									totalFacturaZ_B_NegativosIva += totalIva;
									totalFacturaZ_B_Negativos21 += totalNetoGravado21;
									totalFacturaZ_B_NegativosIva21 += totalIva21;
									totalFacturaZ_B_Negativos10_5 += totalNetoGravado10_5;
									totalFacturaZ_B_NegativosIva10_5 += totalIva10_5;
									totalFacturaZ_B_Negativos27 += totalNetoGravado27;
									totalFacturaZ_B_NegativosIva27 += totalIva27;

									totalFacturaBNegativosFacturaZ_B_Negativos += totalNetoGravado;
									totalFacturaBNegativosFacturaZ_B_NegativosIva += totalIva;
									totalFacturaBNegativosFacturaZ_B_Negativos21 += totalNetoGravado21;
									totalFacturaBNegativosFacturaZ_B_NegativosIva21 += totalIva21;
									totalFacturaBNegativosFacturaZ_B_Negativos10_5 += totalNetoGravado10_5;
									totalFacturaBNegativosFacturaZ_B_NegativosIva10_5 += totalIva10_5;
									totalFacturaBNegativosFacturaZ_B_Negativos27 += totalNetoGravado27;
									totalFacturaBNegativosFacturaZ_B_NegativosIva27 += totalIva27;

									totalFacturaZ_B_Negativos_ConsumidoresFinales += totalNetoGravado;
									totalFacturaZ_B_Negativos_ConsumidoresFinalesIva += totalIva;
									totalFacturaZ_B_Negativos_ConsumidoresFinales21 += totalNetoGravado21;
									totalFacturaZ_B_Negativos_ConsumidoresFinalesIva21 += totalIva21;
									totalFacturaZ_B_Negativos_ConsumidoresFinales10_5 += totalNetoGravado10_5;
									totalFacturaZ_B_Negativos_ConsumidoresFinalesIva10_5 += totalIva10_5;
									totalFacturaZ_B_Negativos_ConsumidoresFinales27 += totalNetoGravado27;
									totalFacturaZ_B_Negativos_ConsumidoresFinalesIva27 += totalIva27;

								}
								totalFacturaBFacturaZ_B += totalNetoGravado;
								totalFacturaBFacturaZ_BIva += totalIva;
								totalFacturaBFacturaZ_B21 += totalNetoGravado21;
								totalFacturaBFacturaZ_BIva21 += totalIva21;
								totalFacturaBFacturaZ_B10_5 += totalNetoGravado10_5;
								totalFacturaBFacturaZ_BIva10_5 += totalIva10_5;
								totalFacturaBFacturaZ_B27 += totalNetoGravado27;
								totalFacturaBFacturaZ_BIva27 += totalIva27;

							} else {
								System.out.println("Factura " + letra + " - Exentos, no Alcanzados, no Gravados: "
										+ formattedTotalNetoGravado.replace(".", ",") + " - IVA: "
										+ formattedTotalIva.replace(".", ",") + "\n");
								totalFacturaZ_B += totalNetoGravado;
								totalFacturaZ_B_Iva += totalIva;
								totalFacturaZ_B21 += totalNetoGravado21;
								totalFacturaZ_B_Iva21 += totalIva21;
								totalFacturaZ_B10_5 += totalNetoGravado10_5;
								totalFacturaZ_B_Iva10_5 += totalIva10_5;
								totalFacturaZ_B27 += totalNetoGravado27;
								totalFacturaZ_B_Iva27 += totalIva27;

								if (totalNetoGravado > 0) {
									totalFacturaZ_B_Positivos += totalNetoGravado;
									totalFacturaZ_B_PositivosIva += totalIva;
									totalFacturaZ_B_Positivos21 += totalNetoGravado21;
									totalFacturaZ_B_PositivosIva21 += totalIva21;
									totalFacturaZ_B_Positivos10_5 += totalNetoGravado10_5;
									totalFacturaZ_B_PositivosIva10_5 += totalIva10_5;
									totalFacturaZ_B_Positivos27 += totalNetoGravado27;
									totalFacturaZ_B_PositivosIva27 += totalIva27;

									totalFacturaBPositivosFacturaZ_B_Positivos += totalNetoGravado;
									totalFacturaBPositivosFacturaZ_B_PositivosIva += totalIva;
									totalFacturaBPositivosFacturaZ_B_Positivos21 += totalNetoGravado21;
									totalFacturaBPositivosFacturaZ_B_PositivosIva21 += totalIva21;
									totalFacturaBPositivosFacturaZ_B_Positivos10_5 += totalNetoGravado10_5;
									totalFacturaBPositivosFacturaZ_B_PositivosIva10_5 += totalIva10_5;
									totalFacturaBPositivosFacturaZ_B_Positivos27 += totalNetoGravado27;
									totalFacturaBPositivosFacturaZ_B_PositivosIva27 += totalIva27;

									totalFacturaZ_B_Positivos_ExentosNoAlcanzados += totalNetoGravado;
									totalFacturaZ_B_Positivos_ExentosNoAlcanzadosIva += totalIva;
									totalFacturaZ_B_Positivos_ExentosNoAlcanzados21 += totalNetoGravado21;
									totalFacturaZ_B_Positivos_ExentosNoAlcanzadosIva21 += totalIva21;
									totalFacturaZ_B_Positivos_ExentosNoAlcanzados10_5 += totalNetoGravado10_5;
									totalFacturaZ_B_Positivos_ExentosNoAlcanzadosIva10_5 += totalIva10_5;
									totalFacturaZ_B_Positivos_ExentosNoAlcanzados27 += totalNetoGravado27;
									totalFacturaZ_B_Positivos_ExentosNoAlcanzadosIva27 += totalIva27;

								} else if (totalNetoGravado < 0) {
									totalFacturaZ_B_Negativos += totalNetoGravado;
									totalFacturaZ_B_NegativosIva += totalIva;
									totalFacturaZ_B_Negativos21 += totalNetoGravado21;
									totalFacturaZ_B_NegativosIva21 += totalIva21;
									totalFacturaZ_B_Negativos10_5 += totalNetoGravado10_5;
									totalFacturaZ_B_NegativosIva10_5 += totalIva10_5;
									totalFacturaZ_B_Negativos27 += totalNetoGravado27;
									totalFacturaZ_B_NegativosIva27 += totalIva27;

									totalFacturaBNegativosFacturaZ_B_Negativos += totalNetoGravado;
									totalFacturaBNegativosFacturaZ_B_NegativosIva += totalIva;
									totalFacturaBNegativosFacturaZ_B_Negativos21 += totalNetoGravado21;
									totalFacturaBNegativosFacturaZ_B_NegativosIva21 += totalIva21;
									totalFacturaBNegativosFacturaZ_B_Negativos10_5 += totalNetoGravado10_5;
									totalFacturaBNegativosFacturaZ_B_NegativosIva10_5 += totalIva10_5;
									totalFacturaBNegativosFacturaZ_B_Negativos27 += totalNetoGravado27;
									totalFacturaBNegativosFacturaZ_B_NegativosIva27 += totalIva27;

									totalFacturaZ_B_Negativos_ExentosNoAlcanzados += totalNetoGravado;
									totalFacturaZ_B_Negativos_ExentosNoAlcanzadosIva += totalIva;
									totalFacturaZ_B_Negativos_ExentosNoAlcanzados21 += totalNetoGravado21;
									totalFacturaZ_B_Negativos_ExentosNoAlcanzadosIva21 += totalIva21;
									totalFacturaZ_B_Negativos_ExentosNoAlcanzados10_5 += totalNetoGravado10_5;
									totalFacturaZ_B_Negativos_ExentosNoAlcanzadosIva10_5 += totalIva10_5;
									totalFacturaZ_B_Negativos_ExentosNoAlcanzados27 += totalNetoGravado27;
									totalFacturaZ_B_Negativos_ExentosNoAlcanzadosIva27 += totalIva27;

								}
								totalFacturaBFacturaZ_B += totalNetoGravado;
								totalFacturaBFacturaZ_BIva += totalIva;
								totalFacturaBFacturaZ_B21 += totalNetoGravado21;
								totalFacturaBFacturaZ_BIva21 += totalIva21;
								totalFacturaBFacturaZ_B10_5 += totalNetoGravado10_5;
								totalFacturaBFacturaZ_BIva10_5 += totalIva10_5;
								totalFacturaBFacturaZ_B27 += totalNetoGravado27;
								totalFacturaBFacturaZ_BIva27 += totalIva27;

							}

						} else {
							System.out.println("Factura " + letra + " - No clasificada: "
									+ formattedTotalNetoGravado.replace(".", ","));
							requiereRevision = true;
						}

						if (requiereRevision) {
							System.out.println("Requiere revisión: " + letra + " - " + razonSocial + " - "
									+ tipoDocumento + " - " + numeroCliente);
						}
					}
				}
			}

			String formattedTotalFacturaAResponsableInscriptoPositivos21 = String
					.format("%.2f", totalFacturaAResponsableInscriptoPositivos21).replace(".", ",");
			String formattedTotalFacturaAResponsableInscriptoNegativos21 = String
					.format("%.2f", totalFacturaAResponsableInscriptoNegativos21).replace(".", ",");
			String formattedTotalFacturaAResponsableInscripto21 = String
					.format("%.2f", totalFacturaAResponsableInscripto21).replace(".", ",");
			String formattedTotalFacturaAMonotributistaPositivos21 = String
					.format("%.2f", totalFacturaAMonotributistaPositivos21).replace(".", ",");
			String formattedTotalFacturaAMonotributistaNegativos21 = String
					.format("%.2f", totalFacturaAMonotributistaNegativos21).replace(".", ",");
			String formattedTotalFacturaAMonotributista21 = String.format("%.2f", totalFacturaAMonotributista21)
					.replace(".", ",");
			String formattedTotalFacturaAExentosNoAlcanzadosPositivos21 = String
					.format("%.2f", totalFacturaAExentosNoAlcanzadosPositivos21).replace(".", ",");
			String formattedTotalFacturaAExentosNoAlcanzadosNegativos21 = String
					.format("%.2f", totalFacturaAExentosNoAlcanzadosNegativos21).replace(".", ",");
			String formattedTotalFacturaAExentosNoAlcanzados21 = String
					.format("%.2f", totalFacturaAExentosNoAlcanzados21).replace(".", ",");
			String formattedTotalFacturaAPositivos21 = String.format("%.2f", totalFacturaAPositivos21).replace(".",
					",");
			String formattedTotalFacturaANegativos21 = String.format("%.2f", totalFacturaANegativos21).replace(".",
					",");
			String formattedTotalFacturaA21 = String.format("%.2f", totalFacturaA21).replace(".", ",");

			String formattedTotalFacturaBConsumidorFinalPositivos21 = String
					.format("%.2f", totalFacturaBConsumidorFinalPositivos21).replace(".", ",");
			String formattedTotalFacturaBConsumidorFinalNegativos21 = String
					.format("%.2f", totalFacturaBConsumidorFinalNegativos21).replace(".", ",");
			String formattedTotalFacturaBConsumidorFinal21 = String.format("%.2f", totalFacturaBConsumidorFinal21)
					.replace(".", ",");
			String formattedTotalFacturaBMonotributistaPositivos21 = String
					.format("%.2f", totalFacturaBMonotributistaPositivos21).replace(".", ",");
			String formattedTotalFacturaBMonotributistaNegativos21 = String
					.format("%.2f", totalFacturaBMonotributistaNegativos21).replace(".", ",");
			String formattedTotalFacturaBMonotributista21 = String.format("%.2f", totalFacturaBMonotributista21)
					.replace(".", ",");
			String formattedTotalFacturaBExentosNoAlcanzadosPositivos21 = String
					.format("%.2f", totalFacturaBExentosNoAlcanzadosPositivos21).replace(".", ",");
			String formattedTotalFacturaBExentosNoAlcanzadosNegativos21 = String
					.format("%.2f", totalFacturaBExentosNoAlcanzadosNegativos21).replace(".", ",");
			String formattedTotalFacturaBExentosNoAlcanzados21 = String
					.format("%.2f", totalFacturaBExentosNoAlcanzados21).replace(".", ",");
			String formattedTotalFacturaBPositivos21 = String.format("%.2f", totalFacturaBPositivos21).replace(".",
					",");
			String formattedTotalFacturaBNegativos21 = String.format("%.2f", totalFacturaBNegativos21).replace(".",
					",");
			String formattedTotalFacturaB21 = String.format("%.2f", totalFacturaB21).replace(".", ",");

			String formattedTotalFacturaZ_A_Positivos21 = String.format("%.2f", totalFacturaZ_A_Positivos21)
					.replace(".", ",");
			String formattedTotalFacturaZ_A_Negativos21 = String.format("%.2f", totalFacturaZ_A_Negativos21)
					.replace(".", ",");
			String formattedTotalFacturaZ_A21 = String.format("%.2f", totalFacturaZ_A21).replace(".", ",");
			String formattedTotalFacturaZ_B_Positivos21 = String.format("%.2f", totalFacturaZ_B_Positivos21)
					.replace(".", ",");
			String formattedTotalFacturaZ_B_Negativos21 = String.format("%.2f", totalFacturaZ_B_Negativos21)
					.replace(".", ",");
			String formattedTotalFacturaZ_B21 = String.format("%.2f", totalFacturaZ_B21).replace(".", ",");
			String formattedTotalFacturaZPositivos21 = String.format("%.2f", totalFacturaZPositivos21).replace(".",
					",");
			String formattedTotalFacturaZNegativos21 = String.format("%.2f", totalFacturaZNegativos21).replace(".",
					",");
			String formattedTotalFacturaZ21 = String.format("%.2f", totalFacturaZ21).replace(".", ",");

			String formattedTotalFacturaAPositivosFacturaZ_A_Positivos21 = String
					.format("%.2f", totalFacturaAPositivosFacturaZ_A_Positivos21).replace(".", ",");
			String formattedTotalFacturaANegativosFacturaZ_A_Negativos21 = String
					.format("%.2f", totalFacturaANegativosFacturaZ_A_Negativos21).replace(".", ",");
			String formattedTotalFacturaAFacturaZ_A21 = String.format("%.2f", totalFacturaAFacturaZ_A21).replace(".",
					",");
			String formattedTotalFacturaBPositivosFacturaZ_B_Positivos21 = String
					.format("%.2f", totalFacturaBPositivosFacturaZ_B_Positivos21).replace(".", ",");
			String formattedTotalFacturaBNegativosFacturaZ_B_Negativos21 = String
					.format("%.2f", totalFacturaBNegativosFacturaZ_B_Negativos21).replace(".", ",");
			String formattedTotalFacturaBFacturaZ_B21 = String.format("%.2f", totalFacturaBFacturaZ_B21).replace(".",
					",");

			String formattedTotalFacturaZ_A_Positivos_Monotributistas21 = String
					.format("%.2f", totalFacturaZ_A_Positivos_Monotributistas21).replace(".", ",");
			String formattedTotalFacturaZ_B_Positivos_Monotributistas21 = String
					.format("%.2f", totalFacturaZ_B_Positivos_Monotributistas21).replace(".", ",");
			String formattedTotalFacturaZ_B_Positivos_ConsumidoresFinales21 = String
					.format("%.2f", totalFacturaZ_B_Positivos_ConsumidoresFinales21).replace(".", ",");
			String formattedTotalFacturaZ_A_Positivos_ExentosNoAlcanzados21 = String
					.format("%.2f", totalFacturaZ_A_Positivos_ExentosNoAlcanzados21).replace(".", ",");
			String formattedTotalFacturaZ_B_Positivos_ExentosNoAlcanzados21 = String
					.format("%.2f", totalFacturaZ_B_Positivos_ExentosNoAlcanzados21).replace(".", ",");
			String formattedTotalFacturaZ_A_Positivos_ResponsableInscripto21 = String
					.format("%.2f", totalFacturaZ_A_Positivos_ResponsableInscripto21).replace(".", ",");

			String formattedTotalFacturaZ_A_Negativos_Monotributistas21 = String
					.format("%.2f", totalFacturaZ_A_Negativos_Monotributistas21).replace(".", ",");
			String formattedTotalFacturaZ_B_Negativos_Monotributistas21 = String
					.format("%.2f", totalFacturaZ_B_Negativos_Monotributistas21).replace(".", ",");
			String formattedTotalFacturaZ_B_Negativos_ConsumidoresFinales21 = String
					.format("%.2f", totalFacturaZ_B_Negativos_ConsumidoresFinales21).replace(".", ",");
			String formattedTotalFacturaZ_A_Negativos_ExentosNoAlcanzados21 = String
					.format("%.2f", totalFacturaZ_A_Negativos_ExentosNoAlcanzados21).replace(".", ",");
			String formattedTotalFacturaZ_B_Negativos_ExentosNoAlcanzados21 = String
					.format("%.2f", totalFacturaZ_B_Negativos_ExentosNoAlcanzados21).replace(".", ",");
			String formattedTotalFacturaZ_A_Negativos_ResponsableInscripto21 = String
					.format("%.2f", totalFacturaZ_A_Negativos_ResponsableInscripto21).replace(".", ",");

			String formattedOpRi21 = String.format("%.2f",
					totalFacturaAResponsableInscriptoPositivos21 + totalFacturaZ_A_Positivos_ResponsableInscripto21)
					.replace(".", ",");
			String formattedOpCfExentos21 = String.format("%.2f",
					totalFacturaZ_B_Positivos_ConsumidoresFinales21 + totalFacturaZ_A_Positivos_ExentosNoAlcanzados21
							+ totalFacturaZ_B_Positivos_ExentosNoAlcanzados21
							+ totalFacturaAExentosNoAlcanzadosPositivos21 + totalFacturaBConsumidorFinalPositivos21
							+ totalFacturaBExentosNoAlcanzadosPositivos21)
					.replace(".", ",");
			String formattedOpMon21 = String
					.format("%.2f",
							totalFacturaZ_A_Positivos_Monotributistas21 + totalFacturaZ_B_Positivos_Monotributistas21
									+ totalFacturaAMonotributistaPositivos21 + totalFacturaBMonotributistaPositivos21)
					.replace(".", ",");

			String formattedOpRiCredito21 = String.format("%.2f",
					totalFacturaAResponsableInscriptoNegativos21 + totalFacturaZ_A_Negativos_ResponsableInscripto21)
					.replace(".", ",");

			String formattedOpCfExentosMonCredito21 = String.format("%.2f",
					totalFacturaZ_B_Negativos_ConsumidoresFinales21 + totalFacturaZ_A_Negativos_ExentosNoAlcanzados21
							+ totalFacturaZ_B_Negativos_ExentosNoAlcanzados21
							+ totalFacturaAExentosNoAlcanzadosNegativos21 + totalFacturaBConsumidorFinalNegativos21
							+ totalFacturaBExentosNoAlcanzadosNegativos21 + totalFacturaZ_A_Negativos_Monotributistas21
							+ totalFacturaZ_B_Negativos_Monotributistas21 + totalFacturaAMonotributistaNegativos21
							+ totalFacturaBMonotributistaNegativos21)
					.replace(".", ",");

			String formattedTotalFacturaAResponsableInscriptoPositivosIva21 = String
					.format("%.2f", totalFacturaAResponsableInscriptoPositivosIva21).replace(".", ",");
			String formattedTotalFacturaAResponsableInscriptoNegativosIva21 = String
					.format("%.2f", totalFacturaAResponsableInscriptoNegativosIva21).replace(".", ",");
			String formattedTotalFacturaAResponsableInscriptoIva21 = String
					.format("%.2f", totalFacturaAResponsableInscriptoIva21).replace(".", ",");
			String formattedTotalFacturaAMonotributistaPositivosIva21 = String
					.format("%.2f", totalFacturaAMonotributistaPositivosIva21).replace(".", ",");
			String formattedTotalFacturaAMonotributistaNegativosIva21 = String
					.format("%.2f", totalFacturaAMonotributistaNegativosIva21).replace(".", ",");
			String formattedTotalFacturaAMonotributistaIva21 = String.format("%.2f", totalFacturaAMonotributistaIva21)
					.replace(".", ",");
			String formattedTotalFacturaAExentosNoAlcanzadosPositivosIva21 = String
					.format("%.2f", totalFacturaAExentosNoAlcanzadosPositivosIva21).replace(".", ",");
			String formattedTotalFacturaAExentosNoAlcanzadosNegativosIva21 = String
					.format("%.2f", totalFacturaAExentosNoAlcanzadosNegativosIva21).replace(".", ",");
			String formattedTotalFacturaAExentosNoAlcanzadosIva21 = String
					.format("%.2f", totalFacturaAExentosNoAlcanzadosIva21).replace(".", ",");
			String formattedTotalFacturaAPositivosIva21 = String.format("%.2f", totalFacturaAPositivosIva21)
					.replace(".", ",");
			String formattedTotalFacturaANegativosIva21 = String.format("%.2f", totalFacturaANegativosIva21)
					.replace(".", ",");
			String formattedTotalFacturaAIva21 = String.format("%.2f", totalFacturaAIva21).replace(".", ",");

			String formattedTotalFacturaBConsumidorFinalPositivosIva21 = String
					.format("%.2f", totalFacturaBConsumidorFinalPositivosIva21).replace(".", ",");
			String formattedTotalFacturaBConsumidorFinalNegativosIva21 = String
					.format("%.2f", totalFacturaBConsumidorFinalNegativosIva21).replace(".", ",");
			String formattedTotalFacturaBConsumidorFinalIva21 = String.format("%.2f", totalFacturaBConsumidorFinalIva21)
					.replace(".", ",");
			String formattedTotalFacturaBMonotributistaPositivosIva21 = String
					.format("%.2f", totalFacturaBMonotributistaPositivosIva21).replace(".", ",");
			String formattedTotalFacturaBMonotributistaNegativosIva21 = String
					.format("%.2f", totalFacturaBMonotributistaNegativosIva21).replace(".", ",");
			String formattedTotalFacturaBMonotributistaIva21 = String.format("%.2f", totalFacturaBMonotributistaIva21)
					.replace(".", ",");
			String formattedTotalFacturaBExentosNoAlcanzadosPositivosIva21 = String
					.format("%.2f", totalFacturaBExentosNoAlcanzadosPositivosIva21).replace(".", ",");
			String formattedTotalFacturaBExentosNoAlcanzadosNegativosIva21 = String
					.format("%.2f", totalFacturaBExentosNoAlcanzadosNegativosIva21).replace(".", ",");
			String formattedTotalFacturaBExentosNoAlcanzadosIva21 = String
					.format("%.2f", totalFacturaBExentosNoAlcanzadosIva21).replace(".", ",");
			String formattedTotalFacturaBPositivosIva21 = String.format("%.2f", totalFacturaBPositivosIva21)
					.replace(".", ",");
			String formattedTotalFacturaBNegativosIva21 = String.format("%.2f", totalFacturaBNegativosIva21)
					.replace(".", ",");
			String formattedTotalFacturaBIva21 = String.format("%.2f", totalFacturaBIva21).replace(".", ",");

			String formattedTotalFacturaZ_A_PositivosIva21 = String.format("%.2f", totalFacturaZ_A_PositivosIva21)
					.replace(".", ",");
			String formattedTotalFacturaZ_A_NegativosIva21 = String.format("%.2f", totalFacturaZ_A_NegativosIva21)
					.replace(".", ",");
			String formattedTotalFacturaZ_AIva21 = String.format("%.2f", totalFacturaZ_A_Iva21).replace(".", ",");
			String formattedTotalFacturaZ_B_PositivosIva21 = String.format("%.2f", totalFacturaZ_B_PositivosIva21)
					.replace(".", ",");
			String formattedTotalFacturaZ_B_NegativosIva21 = String.format("%.2f", totalFacturaZ_B_NegativosIva21)
					.replace(".", ",");
			String formattedTotalFacturaZ_BIva21 = String.format("%.2f", totalFacturaZ_B_Iva21).replace(".", ",");
			String formattedTotalFacturaZPositivosIva21 = String.format("%.2f", totalFacturaZPositivosIva21)
					.replace(".", ",");
			String formattedTotalFacturaZNegativosIva21 = String.format("%.2f", totalFacturaZNegativosIva21)
					.replace(".", ",");
			String formattedTotalFacturaZIva21 = String.format("%.2f", totalFacturaZIva21).replace(".", ",");

			String formattedTotalFacturaAPositivosFacturaZ_A_PositivosIva21 = String
					.format("%.2f", totalFacturaAPositivosFacturaZ_A_PositivosIva21).replace(".", ",");
			String formattedTotalFacturaANegativosFacturaZ_A_NegativosIva21 = String
					.format("%.2f", totalFacturaANegativosFacturaZ_A_NegativosIva21).replace(".", ",");
			String formattedTotalFacturaAFacturaZ_AIva21 = String.format("%.2f", totalFacturaAFacturaZ_AIva21)
					.replace(".", ",");
			String formattedTotalFacturaBPositivosFacturaZ_B_PositivosIva21 = String
					.format("%.2f", totalFacturaBPositivosFacturaZ_B_PositivosIva21).replace(".", ",");
			String formattedTotalFacturaBNegativosFacturaZ_B_NegativosIva21 = String
					.format("%.2f", totalFacturaBNegativosFacturaZ_B_NegativosIva21).replace(".", ",");
			String formattedTotalFacturaBFacturaZ_BIva21 = String.format("%.2f", totalFacturaBFacturaZ_BIva21)
					.replace(".", ",");

			String formattedTotalFacturaZ_A_Positivos_MonotributistasIva21 = String
					.format("%.2f", totalFacturaZ_A_Positivos_MonotributistasIva21).replace(".", ",");
			String formattedTotalFacturaZ_B_Positivos_MonotributistasIva21 = String
					.format("%.2f", totalFacturaZ_B_Positivos_MonotributistasIva21).replace(".", ",");
			String formattedTotalFacturaZ_B_Positivos_ConsumidoresFinalesIva21 = String
					.format("%.2f", totalFacturaZ_B_Positivos_ConsumidoresFinalesIva21).replace(".", ",");
			String formattedTotalFacturaZ_A_Positivos_ExentosNoAlcanzadosIva21 = String
					.format("%.2f", totalFacturaZ_A_Positivos_ExentosNoAlcanzadosIva21).replace(".", ",");
			String formattedTotalFacturaZ_B_Positivos_ExentosNoAlcanzadosIva21 = String
					.format("%.2f", totalFacturaZ_B_Positivos_ExentosNoAlcanzadosIva21).replace(".", ",");
			String formattedTotalFacturaZ_A_Positivos_ResponsableInscriptoIva21 = String
					.format("%.2f", totalFacturaZ_A_Positivos_ResponsableInscriptoIva21).replace(".", ",");

			String formattedTotalFacturaZ_A_Negativos_MonotributistasIva21 = String
					.format("%.2f", totalFacturaZ_A_Negativos_MonotributistasIva21).replace(".", ",");
			String formattedTotalFacturaZ_B_Negativos_MonotributistasIva21 = String
					.format("%.2f", totalFacturaZ_B_Negativos_MonotributistasIva21).replace(".", ",");
			String formattedTotalFacturaZ_B_Negativos_ConsumidoresFinalesIva21 = String
					.format("%.2f", totalFacturaZ_B_Negativos_ConsumidoresFinalesIva21).replace(".", ",");
			String formattedTotalFacturaZ_A_Negativos_ExentosNoAlcanzadosIva21 = String
					.format("%.2f", totalFacturaZ_A_Negativos_ExentosNoAlcanzadosIva21).replace(".", ",");
			String formattedTotalFacturaZ_B_Negativos_ExentosNoAlcanzadosIva21 = String
					.format("%.2f", totalFacturaZ_B_Negativos_ExentosNoAlcanzadosIva21).replace(".", ",");
			String formattedTotalFacturaZ_A_Negativos_ResponsableInscriptoIva21 = String
					.format("%.2f", totalFacturaZ_A_Negativos_ResponsableInscriptoIva21).replace(".", ",");

			String formattedOpRiIva21 = String.format("%.2f", totalFacturaAResponsableInscriptoPositivosIva21
					+ totalFacturaZ_A_Positivos_ResponsableInscriptoIva21).replace(".", ",");
			String formattedOpCfExentosIva21 = String.format("%.2f", totalFacturaZ_B_Positivos_ConsumidoresFinalesIva21
					+ totalFacturaZ_A_Positivos_ExentosNoAlcanzadosIva21
					+ totalFacturaZ_B_Positivos_ExentosNoAlcanzadosIva21
					+ totalFacturaAExentosNoAlcanzadosPositivosIva21 + totalFacturaBConsumidorFinalPositivosIva21
					+ totalFacturaBExentosNoAlcanzadosPositivosIva21).replace(".", ",");
			String formattedOpMonIva21 = String.format("%.2f",
					totalFacturaZ_A_Positivos_MonotributistasIva21 + totalFacturaZ_B_Positivos_MonotributistasIva21
							+ totalFacturaAMonotributistaPositivosIva21 + totalFacturaBMonotributistaPositivosIva21)
					.replace(".", ",");

			String formattedOpRiCreditoIva21 = String.format("%.2f", totalFacturaAResponsableInscriptoNegativosIva21
					+ totalFacturaZ_A_Negativos_ResponsableInscriptoIva21).replace(".", ",");

			String formattedOpCfExentosMonCreditoIva21 = String.format("%.2f",
					totalFacturaZ_B_Negativos_ConsumidoresFinalesIva21
							+ totalFacturaZ_A_Negativos_ExentosNoAlcanzadosIva21
							+ totalFacturaZ_B_Negativos_ExentosNoAlcanzadosIva21
							+ totalFacturaAExentosNoAlcanzadosNegativosIva21
							+ totalFacturaBConsumidorFinalNegativosIva21
							+ totalFacturaBExentosNoAlcanzadosNegativosIva21
							+ totalFacturaZ_A_Negativos_MonotributistasIva21
							+ totalFacturaZ_B_Negativos_MonotributistasIva21 + totalFacturaAMonotributistaNegativosIva21
							+ totalFacturaBMonotributistaNegativosIva21)
					.replace(".", ",");

			// Mostrar los resultados formateados
			System.out.println("\nTotales acumulados Neto Gravado con IVA 21:");

			System.out.println("\nFacturas A 21");

			System.out.println("Total Factura A Responsable Inscripto (RI) Positivos 21: "
					+ formattedTotalFacturaAResponsableInscriptoPositivos21 + " \tIVA\t "
					+ formattedTotalFacturaAResponsableInscriptoPositivosIva21);
			System.out.println("Total Factura A Responsable Inscripto (RI) Negativos 21: "
					+ formattedTotalFacturaAResponsableInscriptoNegativos21 + " \tIVA\t "
					+ formattedTotalFacturaAResponsableInscriptoNegativosIva21);
			System.out.println(
					"Total Factura A Responsable Inscripto (RI) 21: " + formattedTotalFacturaAResponsableInscripto21
							+ " \tIVA\t " + formattedTotalFacturaAResponsableInscriptoIva21);
			System.out.println(
					"Total Factura A Monotributista Positivos 21: " + formattedTotalFacturaAMonotributistaPositivos21
							+ " \tIVA\t " + formattedTotalFacturaAMonotributistaPositivosIva21);
			System.out.println(
					"Total Factura A Monotributista Negativos 21: " + formattedTotalFacturaAMonotributistaNegativos21
							+ " \tIVA\t " + formattedTotalFacturaAMonotributistaNegativosIva21);
			System.out.println("Total Factura A Monotributista 21: " + formattedTotalFacturaAMonotributista21
					+ " \tIVA\t " + formattedTotalFacturaAMonotributistaIva21);
			System.out.println("Total Factura A Exentos No Alcanzados Positivos 21: "
					+ formattedTotalFacturaAExentosNoAlcanzadosPositivos21 + " \tIVA\t "
					+ formattedTotalFacturaAExentosNoAlcanzadosPositivosIva21);
			System.out.println("Total Factura A Exentos No Alcanzados Negativos 21: "
					+ formattedTotalFacturaAExentosNoAlcanzadosNegativos21 + " \tIVA\t "
					+ formattedTotalFacturaAExentosNoAlcanzadosNegativosIva21);
			System.out
					.println("Total Factura A Exentos No Alcanzados 21: " + formattedTotalFacturaAExentosNoAlcanzados21
							+ " \tIVA\t " + formattedTotalFacturaAExentosNoAlcanzadosIva21);
			System.out.println("Total Factura A Positivos (sin Facturas Z positivas) 21: "
					+ formattedTotalFacturaAPositivos21 + " \tIVA\t " + formattedTotalFacturaAPositivosIva21);
			System.out.println("Total Factura A Negativos (sin Facturas Z negativas) 21: "
					+ formattedTotalFacturaANegativos21 + " \tIVA\t " + formattedTotalFacturaANegativosIva21);
			System.out.println("Total Factura A (sin Facturas Z) 21: " + formattedTotalFacturaA21 + " \tIVA\t "
					+ formattedTotalFacturaAIva21);

			System.out.println("\nFacturas B 21");

			System.out.println(
					"Total Factura B Consumidor Final Positivos 21: " + formattedTotalFacturaBConsumidorFinalPositivos21
							+ " \tIVA\t " + formattedTotalFacturaBConsumidorFinalPositivosIva21);
			System.out.println(
					"Total Factura B Consumidor Final Negativos 21: " + formattedTotalFacturaBConsumidorFinalNegativos21
							+ " \tIVA\t " + formattedTotalFacturaBConsumidorFinalNegativosIva21);
			System.out.println("Total Factura B Consumidor Final 21: " + formattedTotalFacturaBConsumidorFinal21
					+ " \tIVA\t " + formattedTotalFacturaBConsumidorFinalIva21);
			System.out.println(
					"Total Factura B Monotributista Positivos 21: " + formattedTotalFacturaBMonotributistaPositivos21
							+ " \tIVA\t " + formattedTotalFacturaBMonotributistaPositivosIva21);
			System.out.println(
					"Total Factura B Monotributista Negativos 21: " + formattedTotalFacturaBMonotributistaNegativos21
							+ " \tIVA\t " + formattedTotalFacturaBMonotributistaNegativosIva21);
			System.out.println("Total Factura B Monotributista 21: " + formattedTotalFacturaBMonotributista21
					+ " \tIVA\t " + formattedTotalFacturaBMonotributistaIva21);
			System.out.println("Total Factura B Exentos No Alcanzados Positivos 21: "
					+ formattedTotalFacturaBExentosNoAlcanzadosPositivos21 + " \tIVA\t "
					+ formattedTotalFacturaBExentosNoAlcanzadosPositivosIva21);
			System.out.println("Total Factura B Exentos No Alcanzados Negativos 21: "
					+ formattedTotalFacturaBExentosNoAlcanzadosNegativos21 + " \tIVA\t "
					+ formattedTotalFacturaBExentosNoAlcanzadosNegativosIva21);
			System.out
					.println("Total Factura B Exentos No Alcanzados 21: " + formattedTotalFacturaBExentosNoAlcanzados21
							+ " \tIVA\t " + formattedTotalFacturaBExentosNoAlcanzadosIva21);
			System.out.println("Total Factura B Positivos (sin Facturas Z positivas) 21: "
					+ formattedTotalFacturaBPositivos21 + " \tIVA\t " + formattedTotalFacturaBPositivosIva21);
			System.out.println("Total Factura B Negativos (sin Facturas Z negativas) 21: "
					+ formattedTotalFacturaBNegativos21 + " \tIVA\t " + formattedTotalFacturaBNegativosIva21);
			System.out.println("Total Factura B (sin facturas Z) 21: " + formattedTotalFacturaB21 + " \tIVA\t "
					+ formattedTotalFacturaBIva21);

			System.out.println("\nFacturas Z 21");

			System.out.println("Total Factura Z Que Son Factura A Positivo 21: " + formattedTotalFacturaZ_A_Positivos21
					+ " \tIVA\t " + formattedTotalFacturaZ_A_PositivosIva21);
			System.out.println("Total Factura Z Que Son Factura A Negativos 21: " + formattedTotalFacturaZ_A_Negativos21
					+ " \tIVA\t " + formattedTotalFacturaZ_A_NegativosIva21);
			System.out.println("Total Factura Z Que Son Factura A 21: " + formattedTotalFacturaZ_A21 + " \tIVA\t "
					+ formattedTotalFacturaZ_AIva21);
			System.out.println("Total Factura Z Que Son Factura B Positivos 21: " + formattedTotalFacturaZ_B_Positivos21
					+ " \tIVA\t " + formattedTotalFacturaZ_B_PositivosIva21);
			System.out.println("Total Factura Z Que Son Factura B Negativos 21: " + formattedTotalFacturaZ_B_Negativos21
					+ " \tIVA\t " + formattedTotalFacturaZ_B_NegativosIva21);
			System.out.println("Total Factura Z Que Son Factura B 21: " + formattedTotalFacturaZ_B21 + " \tIVA\t "
					+ formattedTotalFacturaZ_BIva21);
			System.out.println("Total Factura Z Positivos 21: " + formattedTotalFacturaZPositivos21 + " \tIVA\t "
					+ formattedTotalFacturaZPositivosIva21);
			System.out.println("Total Factura Z Negativos 21: " + formattedTotalFacturaZNegativos21 + " \tIVA\t "
					+ formattedTotalFacturaZNegativosIva21);
			System.out.println(
					"Total Factura Z 21: " + formattedTotalFacturaZ21 + " \tIVA\t " + formattedTotalFacturaZIva21);

			System.out.println("Total Factura A Positivos (con Facturas Z que son A Positivos) 21: "
					+ formattedTotalFacturaAPositivosFacturaZ_A_Positivos21 + " \tIVA\t "
					+ formattedTotalFacturaAPositivosFacturaZ_A_PositivosIva21);
			System.out.println("Total Factura A Negativos (con Facturas Z que son A Negativos) 21: "
					+ formattedTotalFacturaANegativosFacturaZ_A_Negativos21 + " \tIVA\t "
					+ formattedTotalFacturaANegativosFacturaZ_A_NegativosIva21);
			System.out.println("Total Factura A (con Facturas Z que son A) 21: " + formattedTotalFacturaAFacturaZ_A21
					+ " \tIVA\t " + formattedTotalFacturaAFacturaZ_AIva21);

			System.out.println("Total Factura B Positivos (con Facturas Z que son B Positivos) 21: "
					+ formattedTotalFacturaBPositivosFacturaZ_B_Positivos21 + " \tIVA\t "
					+ formattedTotalFacturaBPositivosFacturaZ_B_PositivosIva21);
			System.out.println("Total Factura B Negativos (con Facturas Z que son B Negativos) 21: "
					+ formattedTotalFacturaBNegativosFacturaZ_B_Negativos21 + " \tIVA\t "
					+ formattedTotalFacturaBNegativosFacturaZ_B_NegativosIva21);
			System.out.println("Total Factura B (con Facturas Z que son B) 21: " + formattedTotalFacturaBFacturaZ_B21
					+ " \tIVA\t " + formattedTotalFacturaBFacturaZ_BIva21);

			System.out.println("Total Factura Z Que Son Factura A Positivos Responsable Inscripto 21 : "
					+ formattedTotalFacturaZ_A_Positivos_ResponsableInscripto21 + " \tIVA\t "
					+ formattedTotalFacturaZ_A_Positivos_ResponsableInscriptoIva21);
			System.out.println("Operaciones con responsables Inscriptos) 21: " + formattedOpRi21 + " \tIVA\t "
					+ formattedOpRiIva21);

			System.out.println("Total Factura Z Que Son Factura A Positivos Monotributistas 21: "
					+ formattedTotalFacturaZ_A_Positivos_Monotributistas21 + " \tIVA\t "
					+ formattedTotalFacturaZ_A_Positivos_MonotributistasIva21);
			System.out.println("Total Factura Z Que Son Factura B Positivos Monotributistas 21: "
					+ formattedTotalFacturaZ_B_Positivos_Monotributistas21 + " \tIVA\t "
					+ formattedTotalFacturaZ_B_Positivos_MonotributistasIva21);

			System.out.println("Total Factura Z Que son Factura B Positivos Consumidores Finales 21: "
					+ formattedTotalFacturaZ_B_Positivos_ConsumidoresFinales21 + " \tIVA\t "
					+ formattedTotalFacturaZ_B_Positivos_ConsumidoresFinalesIva21);

			System.out.println("Total Factura Z Que Son Factura A Positivos Exentos No Alcanzados 21: "
					+ formattedTotalFacturaZ_A_Positivos_ExentosNoAlcanzados21 + " \tIVA\t "
					+ formattedTotalFacturaZ_A_Positivos_ExentosNoAlcanzadosIva21);

			System.out.println("Total Factura Z Que son Factura B Positivos Exentos No Alcanzados 21: "
					+ formattedTotalFacturaZ_B_Positivos_ExentosNoAlcanzados21 + " \tIVA\t "
					+ formattedTotalFacturaZ_B_Positivos_ExentosNoAlcanzadosIva21);

			System.out.println("Operaciones con CF y EXENTOS NO ALCANZADOS 21: " + formattedOpCfExentos21 + " \tIVA\t "
					+ formattedOpCfExentosIva21);
			System.out.println("Operaciones con MON 21: " + formattedOpMon21 + " \tIVA\t " + formattedOpMonIva21);

			System.out.println("Total Factura Z Que Son Factura A Negativos Responsable Inscripto 21: "
					+ formattedTotalFacturaZ_A_Negativos_ResponsableInscripto21 + " \tIVA\t "
					+ formattedTotalFacturaZ_A_Negativos_ResponsableInscriptoIva21);

			System.out.println("Operaciones con responsables Inscriptos (Crédito) 21: " + formattedOpRiCredito21
					+ " \tIVA\t " + formattedOpRiCreditoIva21);

			System.out.println("Total Factura Z Que Son Factura A Negativos Monotributistas 21: "
					+ formattedTotalFacturaZ_A_Negativos_Monotributistas21 + " \tIVA\t "
					+ formattedTotalFacturaZ_A_Negativos_MonotributistasIva21);
			System.out.println("Total Factura Z Que Son Factura B Negativos Monotributistas 21: "
					+ formattedTotalFacturaZ_B_Negativos_Monotributistas21 + " \tIVA\t "
					+ formattedTotalFacturaZ_B_Negativos_MonotributistasIva21);

			System.out.println("Total Factura Z Que son Factura B Negativos Consumidores Finales 21: "
					+ formattedTotalFacturaZ_B_Negativos_ConsumidoresFinales21 + " \tIVA\t "
					+ formattedTotalFacturaZ_B_Negativos_ConsumidoresFinalesIva21);

			System.out.println("Total Factura Z Que Son Factura A Negativos Exentos No Alcanzados 21: "
					+ formattedTotalFacturaZ_A_Negativos_ExentosNoAlcanzados21 + " \tIVA\t "
					+ formattedTotalFacturaZ_A_Negativos_ExentosNoAlcanzadosIva21);

			System.out.println("Total Factura Z Que son Factura B Negativos Exentos No Alcanzados 21: "
					+ formattedTotalFacturaZ_B_Negativos_ExentosNoAlcanzados21 + " \tIVA\t "
					+ formattedTotalFacturaZ_B_Negativos_ExentosNoAlcanzadosIva21);

			System.out.println("Operaciones con CF, MON y EXENTOS NO ALCANZADOS (Crédito) 21: "
					+ formattedOpCfExentosMonCredito21 + " \tIVA\t " + formattedOpCfExentosMonCreditoIva21);

			String formattedTotalFacturaAResponsableInscriptoPositivos10_5 = String
					.format("%.2f", totalFacturaAResponsableInscriptoPositivos10_5).replace(".", ",");
			String formattedTotalFacturaAResponsableInscriptoNegativos10_5 = String
					.format("%.2f", totalFacturaAResponsableInscriptoNegativos10_5).replace(".", ",");
			String formattedTotalFacturaAResponsableInscripto10_5 = String
					.format("%.2f", totalFacturaAResponsableInscripto10_5).replace(".", ",");
			String formattedTotalFacturaAMonotributistaPositivos10_5 = String
					.format("%.2f", totalFacturaAMonotributistaPositivos10_5).replace(".", ",");
			String formattedTotalFacturaAMonotributistaNegativos10_5 = String
					.format("%.2f", totalFacturaAMonotributistaNegativos10_5).replace(".", ",");
			String formattedTotalFacturaAMonotributista10_5 = String.format("%.2f", totalFacturaAMonotributista10_5)
					.replace(".", ",");
			String formattedTotalFacturaAExentosNoAlcanzadosPositivos10_5 = String
					.format("%.2f", totalFacturaAExentosNoAlcanzadosPositivos10_5).replace(".", ",");
			String formattedTotalFacturaAExentosNoAlcanzadosNegativos10_5 = String
					.format("%.2f", totalFacturaAExentosNoAlcanzadosNegativos10_5).replace(".", ",");
			String formattedTotalFacturaAExentosNoAlcanzados10_5 = String
					.format("%.2f", totalFacturaAExentosNoAlcanzados10_5).replace(".", ",");
			String formattedTotalFacturaAPositivos10_5 = String.format("%.2f", totalFacturaAPositivos10_5).replace(".",
					",");
			String formattedTotalFacturaANegativos10_5 = String.format("%.2f", totalFacturaANegativos10_5).replace(".",
					",");
			String formattedTotalFacturaA10_5 = String.format("%.2f", totalFacturaA10_5).replace(".", ",");

			String formattedTotalFacturaBConsumidorFinalPositivos10_5 = String
					.format("%.2f", totalFacturaBConsumidorFinalPositivos10_5).replace(".", ",");
			String formattedTotalFacturaBConsumidorFinalNegativos10_5 = String
					.format("%.2f", totalFacturaBConsumidorFinalNegativos10_5).replace(".", ",");
			String formattedTotalFacturaBConsumidorFinal10_5 = String.format("%.2f", totalFacturaBConsumidorFinal10_5)
					.replace(".", ",");
			String formattedTotalFacturaBMonotributistaPositivos10_5 = String
					.format("%.2f", totalFacturaBMonotributistaPositivos10_5).replace(".", ",");
			String formattedTotalFacturaBMonotributistaNegativos10_5 = String
					.format("%.2f", totalFacturaBMonotributistaNegativos10_5).replace(".", ",");
			String formattedTotalFacturaBMonotributista10_5 = String.format("%.2f", totalFacturaBMonotributista10_5)
					.replace(".", ",");
			String formattedTotalFacturaBExentosNoAlcanzadosPositivos10_5 = String
					.format("%.2f", totalFacturaBExentosNoAlcanzadosPositivos10_5).replace(".", ",");
			String formattedTotalFacturaBExentosNoAlcanzadosNegativos10_5 = String
					.format("%.2f", totalFacturaBExentosNoAlcanzadosNegativos10_5).replace(".", ",");
			String formattedTotalFacturaBExentosNoAlcanzados10_5 = String
					.format("%.2f", totalFacturaBExentosNoAlcanzados10_5).replace(".", ",");
			String formattedTotalFacturaBPositivos10_5 = String.format("%.2f", totalFacturaBPositivos10_5).replace(".",
					",");
			String formattedTotalFacturaBNegativos10_5 = String.format("%.2f", totalFacturaBNegativos10_5).replace(".",
					",");
			String formattedTotalFacturaB10_5 = String.format("%.2f", totalFacturaB10_5).replace(".", ",");

			String formattedTotalFacturaZ_A_Positivos10_5 = String.format("%.2f", totalFacturaZ_A_Positivos10_5)
					.replace(".", ",");
			String formattedTotalFacturaZ_A_Negativos10_5 = String.format("%.2f", totalFacturaZ_A_Negativos10_5)
					.replace(".", ",");
			String formattedTotalFacturaZ_A10_5 = String.format("%.2f", totalFacturaZ_A10_5).replace(".", ",");
			String formattedTotalFacturaZ_B_Positivos10_5 = String.format("%.2f", totalFacturaZ_B_Positivos10_5)
					.replace(".", ",");
			String formattedTotalFacturaZ_B_Negativos10_5 = String.format("%.2f", totalFacturaZ_B_Negativos10_5)
					.replace(".", ",");
			String formattedTotalFacturaZ_B10_5 = String.format("%.2f", totalFacturaZ_B10_5).replace(".", ",");
			String formattedTotalFacturaZPositivos10_5 = String.format("%.2f", totalFacturaZPositivos10_5).replace(".",
					",");
			String formattedTotalFacturaZNegativos10_5 = String.format("%.2f", totalFacturaZNegativos10_5).replace(".",
					",");
			String formattedTotalFacturaZ10_5 = String.format("%.2f", totalFacturaZ10_5).replace(".", ",");

			String formattedTotalFacturaAPositivosFacturaZ_A_Positivos10_5 = String
					.format("%.2f", totalFacturaAPositivosFacturaZ_A_Positivos10_5).replace(".", ",");
			String formattedTotalFacturaANegativosFacturaZ_A_Negativos10_5 = String
					.format("%.2f", totalFacturaANegativosFacturaZ_A_Negativos10_5).replace(".", ",");
			String formattedTotalFacturaAFacturaZ_A10_5 = String.format("%.2f", totalFacturaAFacturaZ_A10_5)
					.replace(".", ",");
			String formattedTotalFacturaBPositivosFacturaZ_B_Positivos10_5 = String
					.format("%.2f", totalFacturaBPositivosFacturaZ_B_Positivos10_5).replace(".", ",");
			String formattedTotalFacturaBNegativosFacturaZ_B_Negativos10_5 = String
					.format("%.2f", totalFacturaBNegativosFacturaZ_B_Negativos10_5).replace(".", ",");
			String formattedTotalFacturaBFacturaZ_B10_5 = String.format("%.2f", totalFacturaBFacturaZ_B10_5)
					.replace(".", ",");

			String formattedTotalFacturaZ_A_Positivos_Monotributistas10_5 = String
					.format("%.2f", totalFacturaZ_A_Positivos_Monotributistas10_5).replace(".", ",");
			String formattedTotalFacturaZ_B_Positivos_Monotributistas10_5 = String
					.format("%.2f", totalFacturaZ_B_Positivos_Monotributistas10_5).replace(".", ",");
			String formattedTotalFacturaZ_B_Positivos_ConsumidoresFinales10_5 = String
					.format("%.2f", totalFacturaZ_B_Positivos_ConsumidoresFinales10_5).replace(".", ",");
			String formattedTotalFacturaZ_A_Positivos_ExentosNoAlcanzados10_5 = String
					.format("%.2f", totalFacturaZ_A_Positivos_ExentosNoAlcanzados10_5).replace(".", ",");
			String formattedTotalFacturaZ_B_Positivos_ExentosNoAlcanzados10_5 = String
					.format("%.2f", totalFacturaZ_B_Positivos_ExentosNoAlcanzados10_5).replace(".", ",");
			String formattedTotalFacturaZ_A_Positivos_ResponsableInscripto10_5 = String
					.format("%.2f", totalFacturaZ_A_Positivos_ResponsableInscripto10_5).replace(".", ",");

			String formattedTotalFacturaZ_A_Negativos_Monotributistas10_5 = String
					.format("%.2f", totalFacturaZ_A_Negativos_Monotributistas10_5).replace(".", ",");
			String formattedTotalFacturaZ_B_Negativos_Monotributistas10_5 = String
					.format("%.2f", totalFacturaZ_B_Negativos_Monotributistas10_5).replace(".", ",");
			String formattedTotalFacturaZ_B_Negativos_ConsumidoresFinales10_5 = String
					.format("%.2f", totalFacturaZ_B_Negativos_ConsumidoresFinales10_5).replace(".", ",");
			String formattedTotalFacturaZ_A_Negativos_ExentosNoAlcanzados10_5 = String
					.format("%.2f", totalFacturaZ_A_Negativos_ExentosNoAlcanzados10_5).replace(".", ",");
			String formattedTotalFacturaZ_B_Negativos_ExentosNoAlcanzados10_5 = String
					.format("%.2f", totalFacturaZ_B_Negativos_ExentosNoAlcanzados10_5).replace(".", ",");
			String formattedTotalFacturaZ_A_Negativos_ResponsableInscripto10_5 = String
					.format("%.2f", totalFacturaZ_A_Negativos_ResponsableInscripto10_5).replace(".", ",");

			String formattedOpRi10_5 = String.format("%.2f",
					totalFacturaAResponsableInscriptoPositivos10_5 + totalFacturaZ_A_Positivos_ResponsableInscripto10_5)
					.replace(".", ",");
			String formattedOpCfExentos10_5 = String.format("%.2f", totalFacturaZ_B_Positivos_ConsumidoresFinales10_5
					+ totalFacturaZ_A_Positivos_ExentosNoAlcanzados10_5
					+ totalFacturaZ_B_Positivos_ExentosNoAlcanzados10_5 + totalFacturaAExentosNoAlcanzadosPositivos10_5
					+ totalFacturaBConsumidorFinalPositivos10_5 + totalFacturaBExentosNoAlcanzadosPositivos10_5)
					.replace(".", ",");
			String formattedOpMon10_5 = String.format("%.2f",
					totalFacturaZ_A_Positivos_Monotributistas10_5 + totalFacturaZ_B_Positivos_Monotributistas10_5
							+ totalFacturaAMonotributistaPositivos10_5 + totalFacturaBMonotributistaPositivos10_5)
					.replace(".", ",");

			String formattedOpRiCredito10_5 = String.format("%.2f",
					totalFacturaAResponsableInscriptoNegativos10_5 + totalFacturaZ_A_Negativos_ResponsableInscripto10_5)
					.replace(".", ",");

			String formattedOpCfExentosMonCredito10_5 = String.format("%.2f",
					totalFacturaZ_B_Negativos_ConsumidoresFinales10_5
							+ totalFacturaZ_A_Negativos_ExentosNoAlcanzados10_5
							+ totalFacturaZ_B_Negativos_ExentosNoAlcanzados10_5
							+ totalFacturaAExentosNoAlcanzadosNegativos10_5 + totalFacturaBConsumidorFinalNegativos10_5
							+ totalFacturaBExentosNoAlcanzadosNegativos10_5
							+ totalFacturaZ_A_Negativos_Monotributistas10_5
							+ totalFacturaZ_B_Negativos_Monotributistas10_5 + totalFacturaAMonotributistaNegativos10_5
							+ totalFacturaBMonotributistaNegativos10_5)
					.replace(".", ",");

			String formattedTotalFacturaAResponsableInscriptoPositivosIva10_5 = String
					.format("%.2f", totalFacturaAResponsableInscriptoPositivosIva10_5).replace(".", ",");
			String formattedTotalFacturaAResponsableInscriptoNegativosIva10_5 = String
					.format("%.2f", totalFacturaAResponsableInscriptoNegativosIva10_5).replace(".", ",");
			String formattedTotalFacturaAResponsableInscriptoIva10_5 = String
					.format("%.2f", totalFacturaAResponsableInscriptoIva10_5).replace(".", ",");
			String formattedTotalFacturaAMonotributistaPositivosIva10_5 = String
					.format("%.2f", totalFacturaAMonotributistaPositivosIva10_5).replace(".", ",");
			String formattedTotalFacturaAMonotributistaNegativosIva10_5 = String
					.format("%.2f", totalFacturaAMonotributistaNegativosIva10_5).replace(".", ",");
			String formattedTotalFacturaAMonotributistaIva10_5 = String
					.format("%.2f", totalFacturaAMonotributistaIva10_5).replace(".", ",");
			String formattedTotalFacturaAExentosNoAlcanzadosPositivosIva10_5 = String
					.format("%.2f", totalFacturaAExentosNoAlcanzadosPositivosIva10_5).replace(".", ",");
			String formattedTotalFacturaAExentosNoAlcanzadosNegativosIva10_5 = String
					.format("%.2f", totalFacturaAExentosNoAlcanzadosNegativosIva10_5).replace(".", ",");
			String formattedTotalFacturaAExentosNoAlcanzadosIva10_5 = String
					.format("%.2f", totalFacturaAExentosNoAlcanzadosIva10_5).replace(".", ",");
			String formattedTotalFacturaAPositivosIva10_5 = String.format("%.2f", totalFacturaAPositivosIva10_5)
					.replace(".", ",");
			String formattedTotalFacturaANegativosIva10_5 = String.format("%.2f", totalFacturaANegativosIva10_5)
					.replace(".", ",");
			String formattedTotalFacturaAIva10_5 = String.format("%.2f", totalFacturaAIva10_5).replace(".", ",");

			String formattedTotalFacturaBConsumidorFinalPositivosIva10_5 = String
					.format("%.2f", totalFacturaBConsumidorFinalPositivosIva10_5).replace(".", ",");
			String formattedTotalFacturaBConsumidorFinalNegativosIva10_5 = String
					.format("%.2f", totalFacturaBConsumidorFinalNegativosIva10_5).replace(".", ",");
			String formattedTotalFacturaBConsumidorFinalIva10_5 = String
					.format("%.2f", totalFacturaBConsumidorFinalIva10_5).replace(".", ",");
			String formattedTotalFacturaBMonotributistaPositivosIva10_5 = String
					.format("%.2f", totalFacturaBMonotributistaPositivosIva10_5).replace(".", ",");
			String formattedTotalFacturaBMonotributistaNegativosIva10_5 = String
					.format("%.2f", totalFacturaBMonotributistaNegativosIva10_5).replace(".", ",");
			String formattedTotalFacturaBMonotributistaIva10_5 = String
					.format("%.2f", totalFacturaBMonotributistaIva10_5).replace(".", ",");
			String formattedTotalFacturaBExentosNoAlcanzadosPositivosIva10_5 = String
					.format("%.2f", totalFacturaBExentosNoAlcanzadosPositivosIva10_5).replace(".", ",");
			String formattedTotalFacturaBExentosNoAlcanzadosNegativosIva10_5 = String
					.format("%.2f", totalFacturaBExentosNoAlcanzadosNegativosIva10_5).replace(".", ",");
			String formattedTotalFacturaBExentosNoAlcanzadosIva10_5 = String
					.format("%.2f", totalFacturaBExentosNoAlcanzadosIva10_5).replace(".", ",");
			String formattedTotalFacturaBPositivosIva10_5 = String.format("%.2f", totalFacturaBPositivosIva10_5)
					.replace(".", ",");
			String formattedTotalFacturaBNegativosIva10_5 = String.format("%.2f", totalFacturaBNegativosIva10_5)
					.replace(".", ",");
			String formattedTotalFacturaBIva10_5 = String.format("%.2f", totalFacturaBIva10_5).replace(".", ",");

			String formattedTotalFacturaZ_A_PositivosIva10_5 = String.format("%.2f", totalFacturaZ_A_PositivosIva10_5)
					.replace(".", ",");
			String formattedTotalFacturaZ_A_NegativosIva10_5 = String.format("%.2f", totalFacturaZ_A_NegativosIva10_5)
					.replace(".", ",");
			String formattedTotalFacturaZ_AIva10_5 = String.format("%.2f", totalFacturaZ_A_Iva10_5).replace(".", ",");
			String formattedTotalFacturaZ_B_PositivosIva10_5 = String.format("%.2f", totalFacturaZ_B_PositivosIva10_5)
					.replace(".", ",");
			String formattedTotalFacturaZ_B_NegativosIva10_5 = String.format("%.2f", totalFacturaZ_B_NegativosIva10_5)
					.replace(".", ",");
			String formattedTotalFacturaZ_BIva10_5 = String.format("%.2f", totalFacturaZ_B_Iva10_5).replace(".", ",");
			String formattedTotalFacturaZPositivosIva10_5 = String.format("%.2f", totalFacturaZPositivosIva10_5)
					.replace(".", ",");
			String formattedTotalFacturaZNegativosIva10_5 = String.format("%.2f", totalFacturaZNegativosIva10_5)
					.replace(".", ",");
			String formattedTotalFacturaZIva10_5 = String.format("%.2f", totalFacturaZIva10_5).replace(".", ",");

			String formattedTotalFacturaAPositivosFacturaZ_A_PositivosIva10_5 = String
					.format("%.2f", totalFacturaAPositivosFacturaZ_A_PositivosIva10_5).replace(".", ",");
			String formattedTotalFacturaANegativosFacturaZ_A_NegativosIva10_5 = String
					.format("%.2f", totalFacturaANegativosFacturaZ_A_NegativosIva10_5).replace(".", ",");
			String formattedTotalFacturaAFacturaZ_AIva10_5 = String.format("%.2f", totalFacturaAFacturaZ_AIva10_5)
					.replace(".", ",");
			String formattedTotalFacturaBPositivosFacturaZ_B_PositivosIva10_5 = String
					.format("%.2f", totalFacturaBPositivosFacturaZ_B_PositivosIva10_5).replace(".", ",");
			String formattedTotalFacturaBNegativosFacturaZ_B_NegativosIva10_5 = String
					.format("%.2f", totalFacturaBNegativosFacturaZ_B_NegativosIva10_5).replace(".", ",");
			String formattedTotalFacturaBFacturaZ_BIva10_5 = String.format("%.2f", totalFacturaBFacturaZ_BIva10_5)
					.replace(".", ",");

			String formattedTotalFacturaZ_A_Positivos_MonotributistasIva10_5 = String
					.format("%.2f", totalFacturaZ_A_Positivos_MonotributistasIva10_5).replace(".", ",");
			String formattedTotalFacturaZ_B_Positivos_MonotributistasIva10_5 = String
					.format("%.2f", totalFacturaZ_B_Positivos_MonotributistasIva10_5).replace(".", ",");
			String formattedTotalFacturaZ_B_Positivos_ConsumidoresFinalesIva10_5 = String
					.format("%.2f", totalFacturaZ_B_Positivos_ConsumidoresFinalesIva10_5).replace(".", ",");
			String formattedTotalFacturaZ_A_Positivos_ExentosNoAlcanzadosIva10_5 = String
					.format("%.2f", totalFacturaZ_A_Positivos_ExentosNoAlcanzadosIva10_5).replace(".", ",");
			String formattedTotalFacturaZ_B_Positivos_ExentosNoAlcanzadosIva10_5 = String
					.format("%.2f", totalFacturaZ_B_Positivos_ExentosNoAlcanzadosIva10_5).replace(".", ",");
			String formattedTotalFacturaZ_A_Positivos_ResponsableInscriptoIva10_5 = String
					.format("%.2f", totalFacturaZ_A_Positivos_ResponsableInscriptoIva10_5).replace(".", ",");

			String formattedTotalFacturaZ_A_Negativos_MonotributistasIva10_5 = String
					.format("%.2f", totalFacturaZ_A_Negativos_MonotributistasIva10_5).replace(".", ",");
			String formattedTotalFacturaZ_B_Negativos_MonotributistasIva10_5 = String
					.format("%.2f", totalFacturaZ_B_Negativos_MonotributistasIva10_5).replace(".", ",");
			String formattedTotalFacturaZ_B_Negativos_ConsumidoresFinalesIva10_5 = String
					.format("%.2f", totalFacturaZ_B_Negativos_ConsumidoresFinalesIva10_5).replace(".", ",");
			String formattedTotalFacturaZ_A_Negativos_ExentosNoAlcanzadosIva10_5 = String
					.format("%.2f", totalFacturaZ_A_Negativos_ExentosNoAlcanzadosIva10_5).replace(".", ",");
			String formattedTotalFacturaZ_B_Negativos_ExentosNoAlcanzadosIva10_5 = String
					.format("%.2f", totalFacturaZ_B_Negativos_ExentosNoAlcanzadosIva10_5).replace(".", ",");
			String formattedTotalFacturaZ_A_Negativos_ResponsableInscriptoIva10_5 = String
					.format("%.2f", totalFacturaZ_A_Negativos_ResponsableInscriptoIva10_5).replace(".", ",");

			String formattedOpRiIva10_5 = String.format("%.2f", totalFacturaAResponsableInscriptoPositivosIva10_5
					+ totalFacturaZ_A_Positivos_ResponsableInscriptoIva10_5).replace(".", ",");
			String formattedOpCfExentosIva10_5 = String.format("%.2f",
					totalFacturaZ_B_Positivos_ConsumidoresFinalesIva10_5
							+ totalFacturaZ_A_Positivos_ExentosNoAlcanzadosIva10_5
							+ totalFacturaZ_B_Positivos_ExentosNoAlcanzadosIva10_5
							+ totalFacturaAExentosNoAlcanzadosPositivosIva10_5
							+ totalFacturaBConsumidorFinalPositivosIva10_5
							+ totalFacturaBExentosNoAlcanzadosPositivos10_5)
					.replace(".", ",");
			String formattedOpMonIva10_5 = String.format("%.2f",
					totalFacturaZ_A_Positivos_MonotributistasIva10_5 + totalFacturaZ_B_Positivos_MonotributistasIva10_5
							+ totalFacturaAMonotributistaPositivosIva10_5 + totalFacturaBMonotributistaPositivosIva10_5)
					.replace(".", ",");

			String formattedOpRiCreditoIva10_5 = String.format("%.2f", totalFacturaAResponsableInscriptoNegativosIva10_5
					+ totalFacturaZ_A_Negativos_ResponsableInscriptoIva10_5).replace(".", ",");

			String formattedOpCfExentosMonCreditoIva10_5 = String
					.format("%.2f", totalFacturaZ_B_Negativos_ConsumidoresFinalesIva10_5
							+ totalFacturaZ_A_Negativos_ExentosNoAlcanzadosIva10_5
							+ totalFacturaZ_B_Negativos_ExentosNoAlcanzadosIva10_5
							+ totalFacturaAExentosNoAlcanzadosNegativosIva10_5
							+ totalFacturaBConsumidorFinalNegativosIva10_5
							+ totalFacturaBExentosNoAlcanzadosNegativosIva10_5
							+ totalFacturaZ_A_Negativos_MonotributistasIva10_5
							+ totalFacturaZ_B_Negativos_MonotributistasIva10_5
							+ totalFacturaAMonotributistaNegativosIva10_5 + totalFacturaBMonotributistaNegativosIva10_5)
					.replace(".", ",");

			// Mostrar los resultados formateados
			System.out.println("\nTotales acumulados Neto Gravado con IVA 10,5:");

			System.out.println("\nFacturas A 10,5");

			System.out.println("Total Factura A Responsable Inscripto (RI) Positivos 10,5: "
					+ formattedTotalFacturaAResponsableInscriptoPositivos10_5 + " \tIVA\t "
					+ formattedTotalFacturaAResponsableInscriptoPositivosIva10_5);
			System.out.println("Total Factura A Responsable Inscripto (RI) Negativos 10,5: "
					+ formattedTotalFacturaAResponsableInscriptoNegativos10_5 + " \tIVA\t "
					+ formattedTotalFacturaAResponsableInscriptoNegativosIva10_5);
			System.out.println(
					"Total Factura A Responsable Inscripto (RI) 10,5: " + formattedTotalFacturaAResponsableInscripto10_5
							+ " \tIVA\t " + formattedTotalFacturaAResponsableInscriptoIva10_5);
			System.out.println("Total Factura A Monotributista Positivos 10,5: "
					+ formattedTotalFacturaAMonotributistaPositivos10_5 + " \tIVA\t "
					+ formattedTotalFacturaAMonotributistaPositivosIva10_5);
			System.out.println("Total Factura A Monotributista Negativos 10,5: "
					+ formattedTotalFacturaAMonotributistaNegativos10_5 + " \tIVA\t "
					+ formattedTotalFacturaAMonotributistaNegativosIva10_5);
			System.out.println("Total Factura A Monotributista 10,5: " + formattedTotalFacturaAMonotributista10_5
					+ " \tIVA\t " + formattedTotalFacturaAMonotributistaIva10_5);
			System.out.println("Total Factura A Exentos No Alcanzados Positivos 10,5: "
					+ formattedTotalFacturaAExentosNoAlcanzadosPositivos10_5 + " \tIVA\t "
					+ formattedTotalFacturaAExentosNoAlcanzadosPositivosIva10_5);
			System.out.println("Total Factura A Exentos No Alcanzados Negativos 10,5: "
					+ formattedTotalFacturaAExentosNoAlcanzadosNegativos10_5 + " \tIVA\t "
					+ formattedTotalFacturaAExentosNoAlcanzadosNegativosIva10_5);
			System.out.println(
					"Total Factura A Exentos No Alcanzados 10,5: " + formattedTotalFacturaAExentosNoAlcanzados10_5
							+ " \tIVA\t " + formattedTotalFacturaAExentosNoAlcanzadosIva10_5);
			System.out.println("Total Factura A Positivos (sin Facturas Z positivas) 10,5: "
					+ formattedTotalFacturaAPositivos10_5 + " \tIVA\t " + formattedTotalFacturaAPositivosIva10_5);
			System.out.println("Total Factura A Negativos (sin Facturas Z negativas) 10,5: "
					+ formattedTotalFacturaANegativos10_5 + " \tIVA\t " + formattedTotalFacturaANegativosIva10_5);
			System.out.println("Total Factura A (sin Facturas Z) 10,5: " + formattedTotalFacturaA10_5 + " \tIVA\t "
					+ formattedTotalFacturaAIva10_5);

			System.out.println("\nFacturas B 10,5");

			System.out.println("Total Factura B Consumidor Final Positivos 10,5: "
					+ formattedTotalFacturaBConsumidorFinalPositivos10_5 + " \tIVA\t "
					+ formattedTotalFacturaBConsumidorFinalPositivosIva10_5);
			System.out.println("Total Factura B Consumidor Final Negativos 10,5: "
					+ formattedTotalFacturaBConsumidorFinalNegativos10_5 + " \tIVA\t "
					+ formattedTotalFacturaBConsumidorFinalNegativosIva10_5);
			System.out.println("Total Factura B Consumidor Final 10,5: " + formattedTotalFacturaBConsumidorFinal10_5
					+ " \tIVA\t " + formattedTotalFacturaBConsumidorFinalIva10_5);
			System.out.println("Total Factura B Monotributista Positivos 10,5: "
					+ formattedTotalFacturaBMonotributistaPositivos10_5 + " \tIVA\t "
					+ formattedTotalFacturaBMonotributistaPositivosIva10_5);
			System.out.println("Total Factura B Monotributista Negativos 10,5: "
					+ formattedTotalFacturaBMonotributistaNegativos10_5 + " \tIVA\t "
					+ formattedTotalFacturaBMonotributistaNegativosIva10_5);
			System.out.println("Total Factura B Monotributista 10,5: " + formattedTotalFacturaBMonotributista10_5
					+ " \tIVA\t " + formattedTotalFacturaBMonotributistaIva10_5);
			System.out.println("Total Factura B Exentos No Alcanzados Positivos 10,5: "
					+ formattedTotalFacturaBExentosNoAlcanzadosPositivos10_5 + " \tIVA\t "
					+ formattedTotalFacturaBExentosNoAlcanzadosPositivosIva10_5);
			System.out.println("Total Factura B Exentos No Alcanzados Negativos 10,5: "
					+ formattedTotalFacturaBExentosNoAlcanzadosNegativos10_5 + " \tIVA\t "
					+ formattedTotalFacturaBExentosNoAlcanzadosNegativosIva10_5);
			System.out.println(
					"Total Factura B Exentos No Alcanzados 10,5: " + formattedTotalFacturaBExentosNoAlcanzados10_5
							+ " \tIVA\t " + formattedTotalFacturaBExentosNoAlcanzadosIva10_5);
			System.out.println("Total Factura B Positivos (sin Facturas Z positivas) 10,5: "
					+ formattedTotalFacturaBPositivos10_5 + " \tIVA\t " + formattedTotalFacturaBPositivosIva10_5);
			System.out.println("Total Factura B Negativos (sin Facturas Z negativas) 10,5: "
					+ formattedTotalFacturaBNegativos10_5 + " \tIVA\t " + formattedTotalFacturaBNegativosIva10_5);
			System.out.println("Total Factura B (sin facturas Z) 10,5: " + formattedTotalFacturaB10_5 + " \tIVA\t "
					+ formattedTotalFacturaBIva10_5);

			System.out.println("\nFacturas Z 10,5");

			System.out.println("Total Factura Z Que Son Factura A Positivos 10,5: "
					+ formattedTotalFacturaZ_A_Positivos10_5 + " \tIVA\t " + formattedTotalFacturaZ_A_PositivosIva10_5);
			System.out.println("Total Factura Z Que Son Factura A Negativos 10,5S: "
					+ formattedTotalFacturaZ_A_Negativos10_5 + " \tIVA\t " + formattedTotalFacturaZ_A_NegativosIva10_5);
			System.out.println("Total Factura Z Que Son Factura A 10,5: " + formattedTotalFacturaZ_A10_5 + " \tIVA\t "
					+ formattedTotalFacturaZ_AIva10_5);
			System.out.println("Total Factura Z Que Son Factura B Positivos 10,5: "
					+ formattedTotalFacturaZ_B_Positivos10_5 + " \tIVA\t " + formattedTotalFacturaZ_B_PositivosIva10_5);
			System.out.println("Total Factura Z Que Son Factura B Negativos 10,5: "
					+ formattedTotalFacturaZ_B_Negativos10_5 + " \tIVA\t " + formattedTotalFacturaZ_B_NegativosIva10_5);
			System.out.println("Total Factura Z Que Son Factura B 10,5: " + formattedTotalFacturaZ_B10_5 + " \tIVA\t "
					+ formattedTotalFacturaZ_BIva10_5);
			System.out.println("Total Factura Z Positivos 10,5: " + formattedTotalFacturaZPositivos10_5 + " \tIVA\t "
					+ formattedTotalFacturaZPositivosIva10_5);
			System.out.println("Total Factura Z Negativos 10,5: " + formattedTotalFacturaZNegativos10_5 + " \tIVA\t "
					+ formattedTotalFacturaZNegativosIva10_5);
			System.out.println("Total Factura Z  10,5: " + formattedTotalFacturaZ10_5 + " \tIVA\t "
					+ formattedTotalFacturaZIva10_5);

			System.out.println("Total Factura A Positivos (con Facturas Z que son A Positivos)  10,5: "
					+ formattedTotalFacturaAPositivosFacturaZ_A_Positivos10_5 + " \tIVA\t "
					+ formattedTotalFacturaAPositivosFacturaZ_A_PositivosIva10_5);
			System.out.println("Total Factura A Negativos (con Facturas Z que son A Negativos)  10,5: "
					+ formattedTotalFacturaANegativosFacturaZ_A_Negativos10_5 + " \tIVA\t "
					+ formattedTotalFacturaANegativosFacturaZ_A_NegativosIva10_5);
			System.out.println("Total Factura A (con Facturas Z que son A) 10,5: "
					+ formattedTotalFacturaAFacturaZ_A10_5 + " \tIVA\t " + formattedTotalFacturaAFacturaZ_AIva10_5);

			System.out.println("Total Factura B Positivos (con Facturas Z que son B Positivos) 10,5: "
					+ formattedTotalFacturaBPositivosFacturaZ_B_Positivos10_5 + " \tIVA\t "
					+ formattedTotalFacturaBPositivosFacturaZ_B_PositivosIva10_5);
			System.out.println("Total Factura B Negativos (con Facturas Z que son B Negativos) 10,5: "
					+ formattedTotalFacturaBNegativosFacturaZ_B_Negativos10_5 + " \tIVA\t "
					+ formattedTotalFacturaBNegativosFacturaZ_B_NegativosIva10_5);
			System.out.println("Total Factura B (con Facturas Z que son B) 10,5: "
					+ formattedTotalFacturaBFacturaZ_B10_5 + " \tIVA\t " + formattedTotalFacturaBFacturaZ_BIva10_5);

			System.out.println("Total Factura Z Que Son Factura A Positivos Responsable Inscripto 10,5: "
					+ formattedTotalFacturaZ_A_Positivos_ResponsableInscripto10_5 + " \tIVA\t "
					+ formattedTotalFacturaZ_A_Positivos_ResponsableInscriptoIva10_5);
			System.out.println("Operaciones con responsables Inscriptos) 10,5: " + formattedOpRi10_5 + " \tIVA\t "
					+ formattedOpRiIva10_5);

			System.out.println("Total Factura Z Que Son Factura A Positivos Monotributistas 10,5: "
					+ formattedTotalFacturaZ_A_Positivos_Monotributistas10_5 + " \tIVA\t "
					+ formattedTotalFacturaZ_A_Positivos_MonotributistasIva10_5);
			System.out.println("Total Factura Z Que Son Factura B Positivos Monotributistas 10,5: "
					+ formattedTotalFacturaZ_B_Positivos_Monotributistas10_5 + " \tIVA\t "
					+ formattedTotalFacturaZ_B_Positivos_MonotributistasIva10_5);

			System.out.println("Total Factura Z Que son Factura B Positivos Consumidores Finales 10,5: "
					+ formattedTotalFacturaZ_B_Positivos_ConsumidoresFinales10_5 + " \tIVA\t "
					+ formattedTotalFacturaZ_B_Positivos_ConsumidoresFinalesIva10_5);

			System.out.println("Total Factura Z Que Son Factura A Positivos Exentos No Alcanzados 10,5: "
					+ formattedTotalFacturaZ_A_Positivos_ExentosNoAlcanzados10_5 + " \tIVA\t "
					+ formattedTotalFacturaZ_A_Positivos_ExentosNoAlcanzadosIva10_5);

			System.out.println("Total Factura Z Que son Factura B Positivos Exentos No Alcanzados 10,5: "
					+ formattedTotalFacturaZ_B_Positivos_ExentosNoAlcanzados10_5 + " \tIVA\t "
					+ formattedTotalFacturaZ_B_Positivos_ExentosNoAlcanzadosIva10_5);

			System.out.println("Operaciones con CF y EXENTOS NO ALCANZADOS 10,5: " + formattedOpCfExentos10_5
					+ " \tIVA\t " + formattedOpCfExentosIva10_5);
			System.out.println("Operaciones con MON 10,5: " + formattedOpMon10_5 + " \tIVA\t " + formattedOpMonIva10_5);

			System.out.println("Total Factura Z Que Son Factura A Negativos Responsable Inscripto 10,5: "
					+ formattedTotalFacturaZ_A_Negativos_ResponsableInscripto10_5 + " \tIVA\t "
					+ formattedTotalFacturaZ_A_Negativos_ResponsableInscriptoIva10_5);

			System.out.println("Operaciones con responsables Inscriptos (Crédito) 10,5: " + formattedOpRiCredito10_5
					+ " \tIVA\t " + formattedOpRiCreditoIva10_5);

			System.out.println("Total Factura Z Que Son Factura A Negativos Monotributistas 10,5: "
					+ formattedTotalFacturaZ_A_Negativos_Monotributistas10_5 + " \tIVA\t "
					+ formattedTotalFacturaZ_A_Negativos_MonotributistasIva10_5);
			System.out.println("Total Factura Z Que Son Factura B Negativos Monotributistas 10,5: "
					+ formattedTotalFacturaZ_B_Negativos_Monotributistas10_5 + " \tIVA\t "
					+ formattedTotalFacturaZ_B_Negativos_MonotributistasIva10_5);

			System.out.println("Total Factura Z Que son Factura B Negativos Consumidores Finales 10,5: "
					+ formattedTotalFacturaZ_B_Negativos_ConsumidoresFinales10_5 + " \tIVA\t "
					+ formattedTotalFacturaZ_B_Negativos_ConsumidoresFinalesIva10_5);

			System.out.println("Total Factura Z Que Son Factura A Negativos Exentos No Alcanzados 10,5: "
					+ formattedTotalFacturaZ_A_Negativos_ExentosNoAlcanzados10_5 + " \tIVA\t "
					+ formattedTotalFacturaZ_A_Negativos_ExentosNoAlcanzadosIva10_5);

			System.out.println("Total Factura Z Que son Factura B Negativos Exentos No Alcanzados 10,5: "
					+ formattedTotalFacturaZ_B_Negativos_ExentosNoAlcanzados10_5 + " \tIVA\t "
					+ formattedTotalFacturaZ_B_Negativos_ExentosNoAlcanzadosIva10_5);

			System.out.println("Operaciones con CF, MON y EXENTOS NO ALCANZADOS (Crédito) 10,5: "
					+ formattedOpCfExentosMonCredito10_5 + " \tIVA\t " + formattedOpCfExentosMonCreditoIva10_5);

			String formattedTotalFacturaAResponsableInscriptoPositivos27 = String
					.format("%.2f", totalFacturaAResponsableInscriptoPositivos27).replace(".", ",");
			String formattedTotalFacturaAResponsableInscriptoNegativos27 = String
					.format("%.2f", totalFacturaAResponsableInscriptoNegativos27).replace(".", ",");
			String formattedTotalFacturaAResponsableInscripto27 = String
					.format("%.2f", totalFacturaAResponsableInscripto27).replace(".", ",");
			String formattedTotalFacturaAMonotributistaPositivos27 = String
					.format("%.2f", totalFacturaAMonotributistaPositivos27).replace(".", ",");
			String formattedTotalFacturaAMonotributistaNegativos27 = String
					.format("%.2f", totalFacturaAMonotributistaNegativos27).replace(".", ",");
			String formattedTotalFacturaAMonotributista27 = String.format("%.2f", totalFacturaAMonotributista27)
					.replace(".", ",");
			String formattedTotalFacturaAExentosNoAlcanzadosPositivos27 = String
					.format("%.2f", totalFacturaAExentosNoAlcanzadosPositivos27).replace(".", ",");
			String formattedTotalFacturaAExentosNoAlcanzadosNegativos27 = String
					.format("%.2f", totalFacturaAExentosNoAlcanzadosNegativos27).replace(".", ",");
			String formattedTotalFacturaAExentosNoAlcanzados27 = String
					.format("%.2f", totalFacturaAExentosNoAlcanzados27).replace(".", ",");
			String formattedTotalFacturaAPositivos27 = String.format("%.2f", totalFacturaAPositivos27).replace(".",
					",");
			String formattedTotalFacturaANegativos27 = String.format("%.2f", totalFacturaANegativos27).replace(".",
					",");
			String formattedTotalFacturaA27 = String.format("%.2f", totalFacturaA27).replace(".", ",");

			String formattedTotalFacturaBConsumidorFinalPositivos27 = String
					.format("%.2f", totalFacturaBConsumidorFinalPositivos27).replace(".", ",");
			String formattedTotalFacturaBConsumidorFinalNegativos27 = String
					.format("%.2f", totalFacturaBConsumidorFinalNegativos27).replace(".", ",");
			String formattedTotalFacturaBConsumidorFinal27 = String.format("%.2f", totalFacturaBConsumidorFinal27)
					.replace(".", ",");
			String formattedTotalFacturaBMonotributistaPositivos27 = String
					.format("%.2f", totalFacturaBMonotributistaPositivos27).replace(".", ",");
			String formattedTotalFacturaBMonotributistaNegativos27 = String
					.format("%.2f", totalFacturaBMonotributistaNegativos27).replace(".", ",");
			String formattedTotalFacturaBMonotributista27 = String.format("%.2f", totalFacturaBMonotributista27)
					.replace(".", ",");
			String formattedTotalFacturaBExentosNoAlcanzadosPositivos27 = String
					.format("%.2f", totalFacturaBExentosNoAlcanzadosPositivos27).replace(".", ",");
			String formattedTotalFacturaBExentosNoAlcanzadosNegativos27 = String
					.format("%.2f", totalFacturaBExentosNoAlcanzadosNegativos27).replace(".", ",");
			String formattedTotalFacturaBExentosNoAlcanzados27 = String
					.format("%.2f", totalFacturaBExentosNoAlcanzados27).replace(".", ",");
			String formattedTotalFacturaBPositivos27 = String.format("%.2f", totalFacturaBPositivos27).replace(".",
					",");
			String formattedTotalFacturaBNegativos27 = String.format("%.2f", totalFacturaBNegativos27).replace(".",
					",");
			String formattedTotalFacturaB27 = String.format("%.2f", totalFacturaB27).replace(".", ",");

			String formattedTotalFacturaZ_A_Positivos27 = String.format("%.2f", totalFacturaZ_A_Positivos27)
					.replace(".", ",");
			String formattedTotalFacturaZ_A_Negativos27 = String.format("%.2f", totalFacturaZ_A_Negativos27)
					.replace(".", ",");
			String formattedTotalFacturaZ_A27 = String.format("%.2f", totalFacturaZ_A27).replace(".", ",");
			String formattedTotalFacturaZ_B_Positivos27 = String.format("%.2f", totalFacturaZ_B_Positivos27)
					.replace(".", ",");
			String formattedTotalFacturaZ_B_Negativos27 = String.format("%.2f", totalFacturaZ_B_Negativos27)
					.replace(".", ",");
			String formattedTotalFacturaZ_B27 = String.format("%.2f", totalFacturaZ_B27).replace(".", ",");
			String formattedTotalFacturaZPositivos27 = String.format("%.2f", totalFacturaZPositivos27).replace(".",
					",");
			String formattedTotalFacturaZNegativos27 = String.format("%.2f", totalFacturaZNegativos27).replace(".",
					",");
			String formattedTotalFacturaZ27 = String.format("%.2f", totalFacturaZ27).replace(".", ",");

			String formattedTotalFacturaAPositivosFacturaZ_A_Positivos27 = String
					.format("%.2f", totalFacturaAPositivosFacturaZ_A_Positivos27).replace(".", ",");
			String formattedTotalFacturaANegativosFacturaZ_A_Negativos27 = String
					.format("%.2f", totalFacturaANegativosFacturaZ_A_Negativos27).replace(".", ",");
			String formattedTotalFacturaAFacturaZ_A27 = String.format("%.2f", totalFacturaAFacturaZ_A27).replace(".",
					",");
			String formattedTotalFacturaBPositivosFacturaZ_B_Positivos27 = String
					.format("%.2f", totalFacturaBPositivosFacturaZ_B_Positivos27).replace(".", ",");
			String formattedTotalFacturaBNegativosFacturaZ_B_Negativos27 = String
					.format("%.2f", totalFacturaBNegativosFacturaZ_B_Negativos27).replace(".", ",");
			String formattedTotalFacturaBFacturaZ_B27 = String.format("%.2f", totalFacturaBFacturaZ_B27).replace(".",
					",");

			String formattedTotalFacturaZ_A_Positivos_Monotributistas27 = String
					.format("%.2f", totalFacturaZ_A_Positivos_Monotributistas27).replace(".", ",");
			String formattedTotalFacturaZ_B_Positivos_Monotributistas27 = String
					.format("%.2f", totalFacturaZ_B_Positivos_Monotributistas27).replace(".", ",");
			String formattedTotalFacturaZ_B_Positivos_ConsumidoresFinales27 = String
					.format("%.2f", totalFacturaZ_B_Positivos_ConsumidoresFinales27).replace(".", ",");
			String formattedTotalFacturaZ_A_Positivos_ExentosNoAlcanzados27 = String
					.format("%.2f", totalFacturaZ_A_Positivos_ExentosNoAlcanzados27).replace(".", ",");
			String formattedTotalFacturaZ_B_Positivos_ExentosNoAlcanzados27 = String
					.format("%.2f", totalFacturaZ_B_Positivos_ExentosNoAlcanzados27).replace(".", ",");
			String formattedTotalFacturaZ_A_Positivos_ResponsableInscripto27 = String
					.format("%.2f", totalFacturaZ_A_Positivos_ResponsableInscripto27).replace(".", ",");

			String formattedTotalFacturaZ_A_Negativos_Monotributistas27 = String
					.format("%.2f", totalFacturaZ_A_Negativos_Monotributistas27).replace(".", ",");
			String formattedTotalFacturaZ_B_Negativos_Monotributistas27 = String
					.format("%.2f", totalFacturaZ_B_Negativos_Monotributistas27).replace(".", ",");
			String formattedTotalFacturaZ_B_Negativos_ConsumidoresFinales27 = String
					.format("%.2f", totalFacturaZ_B_Negativos_ConsumidoresFinales27).replace(".", ",");
			String formattedTotalFacturaZ_A_Negativos_ExentosNoAlcanzados27 = String
					.format("%.2f", totalFacturaZ_A_Negativos_ExentosNoAlcanzados27).replace(".", ",");
			String formattedTotalFacturaZ_B_Negativos_ExentosNoAlcanzados27 = String
					.format("%.2f", totalFacturaZ_B_Negativos_ExentosNoAlcanzados27).replace(".", ",");
			String formattedTotalFacturaZ_A_Negativos_ResponsableInscripto27 = String
					.format("%.2f", totalFacturaZ_A_Negativos_ResponsableInscripto27).replace(".", ",");

			String formattedOpRi27 = String.format("%.2f",
					totalFacturaAResponsableInscriptoPositivos27 + totalFacturaZ_A_Positivos_ResponsableInscripto27)
					.replace(".", ",");
			String formattedOpCfExentos27 = String.format("%.2f",
					totalFacturaZ_B_Positivos_ConsumidoresFinales27 + totalFacturaZ_A_Positivos_ExentosNoAlcanzados27
							+ totalFacturaZ_B_Positivos_ExentosNoAlcanzados27
							+ totalFacturaAExentosNoAlcanzadosPositivos27 + totalFacturaBConsumidorFinalPositivos27
							+ totalFacturaBExentosNoAlcanzadosPositivos27)
					.replace(".", ",");
			String formattedOpMon27 = String
					.format("%.2f",
							totalFacturaZ_A_Positivos_Monotributistas27 + totalFacturaZ_B_Positivos_Monotributistas27
									+ totalFacturaAMonotributistaPositivos27 + totalFacturaBMonotributistaPositivos27)
					.replace(".", ",");

			String formattedOpRiCredito27 = String.format("%.2f",
					totalFacturaAResponsableInscriptoNegativos27 + totalFacturaZ_A_Negativos_ResponsableInscripto27)
					.replace(".", ",");

			String formattedOpCfExentosMonCredito27 = String.format("%.2f",
					totalFacturaZ_B_Negativos_ConsumidoresFinales27 + totalFacturaZ_A_Negativos_ExentosNoAlcanzados27
							+ totalFacturaZ_B_Negativos_ExentosNoAlcanzados27
							+ totalFacturaAExentosNoAlcanzadosNegativos27 + totalFacturaBConsumidorFinalNegativos27
							+ totalFacturaBExentosNoAlcanzadosNegativos27 + totalFacturaZ_A_Negativos_Monotributistas27
							+ totalFacturaZ_B_Negativos_Monotributistas27 + totalFacturaAMonotributistaNegativos27
							+ totalFacturaBMonotributistaNegativos27)
					.replace(".", ",");

			String formattedTotalFacturaAResponsableInscriptoPositivosIva27 = String
					.format("%.2f", totalFacturaAResponsableInscriptoPositivosIva27).replace(".", ",");
			String formattedTotalFacturaAResponsableInscriptoNegativosIva27 = String
					.format("%.2f", totalFacturaAResponsableInscriptoNegativosIva27).replace(".", ",");
			String formattedTotalFacturaAResponsableInscriptoIva27 = String
					.format("%.2f", totalFacturaAResponsableInscriptoIva27).replace(".", ",");
			String formattedTotalFacturaAMonotributistaPositivosIva27 = String
					.format("%.2f", totalFacturaAMonotributistaPositivosIva27).replace(".", ",");
			String formattedTotalFacturaAMonotributistaNegativosIva27 = String
					.format("%.2f", totalFacturaAMonotributistaNegativosIva27).replace(".", ",");
			String formattedTotalFacturaAMonotributistaIva27 = String.format("%.2f", totalFacturaAMonotributistaIva27)
					.replace(".", ",");
			String formattedTotalFacturaAExentosNoAlcanzadosPositivosIva27 = String
					.format("%.2f", totalFacturaAExentosNoAlcanzadosPositivosIva27).replace(".", ",");
			String formattedTotalFacturaAExentosNoAlcanzadosNegativosIva27 = String
					.format("%.2f", totalFacturaAExentosNoAlcanzadosNegativosIva27).replace(".", ",");
			String formattedTotalFacturaAExentosNoAlcanzadosIva27 = String
					.format("%.2f", totalFacturaAExentosNoAlcanzadosIva27).replace(".", ",");
			String formattedTotalFacturaAPositivosIva27 = String.format("%.2f", totalFacturaAPositivosIva27)
					.replace(".", ",");
			String formattedTotalFacturaANegativosIva27 = String.format("%.2f", totalFacturaANegativosIva27)
					.replace(".", ",");
			String formattedTotalFacturaAIva27 = String.format("%.2f", totalFacturaAIva27).replace(".", ",");

			String formattedTotalFacturaBConsumidorFinalPositivosIva27 = String
					.format("%.2f", totalFacturaBConsumidorFinalPositivosIva27).replace(".", ",");
			String formattedTotalFacturaBConsumidorFinalNegativosIva27 = String
					.format("%.2f", totalFacturaBConsumidorFinalNegativosIva27).replace(".", ",");
			String formattedTotalFacturaBConsumidorFinalIva27 = String.format("%.2f", totalFacturaBConsumidorFinalIva27)
					.replace(".", ",");
			String formattedTotalFacturaBMonotributistaPositivosIva27 = String
					.format("%.2f", totalFacturaBMonotributistaPositivosIva27).replace(".", ",");
			String formattedTotalFacturaBMonotributistaNegativosIva27 = String
					.format("%.2f", totalFacturaBMonotributistaNegativosIva27).replace(".", ",");
			String formattedTotalFacturaBMonotributistaIva27 = String.format("%.2f", totalFacturaBMonotributistaIva27)
					.replace(".", ",");
			String formattedTotalFacturaBExentosNoAlcanzadosPositivosIva27 = String
					.format("%.2f", totalFacturaBExentosNoAlcanzadosPositivosIva27).replace(".", ",");
			String formattedTotalFacturaBExentosNoAlcanzadosNegativosIva27 = String
					.format("%.2f", totalFacturaBExentosNoAlcanzadosNegativosIva27).replace(".", ",");
			String formattedTotalFacturaBExentosNoAlcanzadosIva27 = String
					.format("%.2f", totalFacturaBExentosNoAlcanzadosIva27).replace(".", ",");
			String formattedTotalFacturaBPositivosIva27 = String.format("%.2f", totalFacturaBPositivosIva27)
					.replace(".", ",");
			String formattedTotalFacturaBNegativosIva27 = String.format("%.2f", totalFacturaBNegativosIva27)
					.replace(".", ",");
			String formattedTotalFacturaBIva27 = String.format("%.2f", totalFacturaBIva27).replace(".", ",");

			String formattedTotalFacturaZ_A_PositivosIva27 = String.format("%.2f", totalFacturaZ_A_PositivosIva27)
					.replace(".", ",");
			String formattedTotalFacturaZ_A_NegativosIva27 = String.format("%.2f", totalFacturaZ_A_NegativosIva27)
					.replace(".", ",");
			String formattedTotalFacturaZ_AIva27 = String.format("%.2f", totalFacturaZ_A_Iva27).replace(".", ",");
			String formattedTotalFacturaZ_B_PositivosIva27 = String.format("%.2f", totalFacturaZ_B_PositivosIva27)
					.replace(".", ",");
			String formattedTotalFacturaZ_B_NegativosIva27 = String.format("%.2f", totalFacturaZ_B_NegativosIva27)
					.replace(".", ",");
			String formattedTotalFacturaZ_BIva27 = String.format("%.2f", totalFacturaZ_B_Iva27).replace(".", ",");
			String formattedTotalFacturaZPositivosIva27 = String.format("%.2f", totalFacturaZPositivosIva27)
					.replace(".", ",");
			String formattedTotalFacturaZNegativosIva27 = String.format("%.2f", totalFacturaZNegativosIva27)
					.replace(".", ",");
			String formattedTotalFacturaZIva27 = String.format("%.2f", totalFacturaZIva27).replace(".", ",");

			String formattedTotalFacturaAPositivosFacturaZ_A_PositivosIva27 = String
					.format("%.2f", totalFacturaAPositivosFacturaZ_A_PositivosIva27).replace(".", ",");
			String formattedTotalFacturaANegativosFacturaZ_A_NegativosIva27 = String
					.format("%.2f", totalFacturaANegativosFacturaZ_A_NegativosIva27).replace(".", ",");
			String formattedTotalFacturaAFacturaZ_AIva27 = String.format("%.2f", totalFacturaAFacturaZ_AIva27)
					.replace(".", ",");
			String formattedTotalFacturaBPositivosFacturaZ_B_PositivosIva27 = String
					.format("%.2f", totalFacturaBPositivosFacturaZ_B_PositivosIva27).replace(".", ",");
			String formattedTotalFacturaBNegativosFacturaZ_B_NegativosIva27 = String
					.format("%.2f", totalFacturaBNegativosFacturaZ_B_NegativosIva27).replace(".", ",");
			String formattedTotalFacturaBFacturaZ_BIva27 = String.format("%.2f", totalFacturaBFacturaZ_BIva27)
					.replace(".", ",");

			String formattedTotalFacturaZ_A_Positivos_MonotributistasIva27 = String
					.format("%.2f", totalFacturaZ_A_Positivos_MonotributistasIva27).replace(".", ",");
			String formattedTotalFacturaZ_B_Positivos_MonotributistasIva27 = String
					.format("%.2f", totalFacturaZ_B_Positivos_MonotributistasIva27).replace(".", ",");
			String formattedTotalFacturaZ_B_Positivos_ConsumidoresFinalesIva27 = String
					.format("%.2f", totalFacturaZ_B_Positivos_ConsumidoresFinalesIva27).replace(".", ",");
			String formattedTotalFacturaZ_A_Positivos_ExentosNoAlcanzadosIva27 = String
					.format("%.2f", totalFacturaZ_A_Positivos_ExentosNoAlcanzadosIva27).replace(".", ",");
			String formattedTotalFacturaZ_B_Positivos_ExentosNoAlcanzadosIva27 = String
					.format("%.2f", totalFacturaZ_B_Positivos_ExentosNoAlcanzadosIva27).replace(".", ",");
			String formattedTotalFacturaZ_A_Positivos_ResponsableInscriptoIva27 = String
					.format("%.2f", totalFacturaZ_A_Positivos_ResponsableInscriptoIva27).replace(".", ",");

			String formattedTotalFacturaZ_A_Negativos_MonotributistasIva27 = String
					.format("%.2f", totalFacturaZ_A_Negativos_MonotributistasIva27).replace(".", ",");
			String formattedTotalFacturaZ_B_Negativos_MonotributistasIva27 = String
					.format("%.2f", totalFacturaZ_B_Negativos_MonotributistasIva27).replace(".", ",");
			String formattedTotalFacturaZ_B_Negativos_ConsumidoresFinalesIva27 = String
					.format("%.2f", totalFacturaZ_B_Negativos_ConsumidoresFinalesIva27).replace(".", ",");
			String formattedTotalFacturaZ_A_Negativos_ExentosNoAlcanzadosIva27 = String
					.format("%.2f", totalFacturaZ_A_Negativos_ExentosNoAlcanzadosIva27).replace(".", ",");
			String formattedTotalFacturaZ_B_Negativos_ExentosNoAlcanzadosIva27 = String
					.format("%.2f", totalFacturaZ_B_Negativos_ExentosNoAlcanzadosIva27).replace(".", ",");
			String formattedTotalFacturaZ_A_Negativos_ResponsableInscriptoIva27 = String
					.format("%.2f", totalFacturaZ_A_Negativos_ResponsableInscriptoIva27).replace(".", ",");

			String formattedOpRiIva27 = String.format("%.2f", totalFacturaAResponsableInscriptoPositivosIva27
					+ totalFacturaZ_A_Positivos_ResponsableInscriptoIva27).replace(".", ",");
			String formattedOpCfExentosIva27 = String.format("%.2f", totalFacturaZ_B_Positivos_ConsumidoresFinalesIva27
					+ totalFacturaZ_A_Positivos_ExentosNoAlcanzadosIva27
					+ totalFacturaZ_B_Positivos_ExentosNoAlcanzadosIva27
					+ totalFacturaAExentosNoAlcanzadosPositivosIva27 + totalFacturaBConsumidorFinalPositivosIva27
					+ totalFacturaBExentosNoAlcanzadosPositivosIva27).replace(".", ",");
			String formattedOpMonIva27 = String.format("%.2f",
					totalFacturaZ_A_Positivos_MonotributistasIva27 + totalFacturaZ_B_Positivos_MonotributistasIva27
							+ totalFacturaAMonotributistaPositivosIva27 + totalFacturaBMonotributistaPositivosIva27)
					.replace(".", ",");

			String formattedOpRiCreditoIva27 = String.format("%.2f", totalFacturaAResponsableInscriptoNegativosIva27
					+ totalFacturaZ_A_Negativos_ResponsableInscriptoIva27).replace(".", ",");

			String formattedOpCfExentosMonCreditoIva27 = String.format("%.2f",
					totalFacturaZ_B_Negativos_ConsumidoresFinalesIva27
							+ totalFacturaZ_A_Negativos_ExentosNoAlcanzadosIva27
							+ totalFacturaZ_B_Negativos_ExentosNoAlcanzadosIva27
							+ totalFacturaAExentosNoAlcanzadosNegativosIva27
							+ totalFacturaBConsumidorFinalNegativosIva27
							+ totalFacturaBExentosNoAlcanzadosNegativosIva27
							+ totalFacturaZ_A_Negativos_MonotributistasIva27
							+ totalFacturaZ_B_Negativos_MonotributistasIva27 + totalFacturaAMonotributistaNegativosIva27
							+ totalFacturaBMonotributistaNegativosIva27)
					.replace(".", ",");

			// Mostrar los resultados formateados
			System.out.println("\nTotales acumulados Neto Gravado con IVA 27:");

			System.out.println("\nFacturas A 27");

			System.out.println("Total Factura A Responsable Inscripto (RI) Positivos 27: "
					+ formattedTotalFacturaAResponsableInscriptoPositivos27 + " \tIVA\t "
					+ formattedTotalFacturaAResponsableInscriptoPositivosIva27);
			System.out.println("Total Factura A Responsable Inscripto (RI) Negativos 27: "
					+ formattedTotalFacturaAResponsableInscriptoNegativos27 + " \tIVA\t "
					+ formattedTotalFacturaAResponsableInscriptoNegativosIva27);
			System.out.println(
					"Total Factura A Responsable Inscripto (RI) 27: " + formattedTotalFacturaAResponsableInscripto27
							+ " \tIVA\t " + formattedTotalFacturaAResponsableInscriptoIva27);
			System.out.println(
					"Total Factura A Monotributista Positivos 27: " + formattedTotalFacturaAMonotributistaPositivos27
							+ " \tIVA\t " + formattedTotalFacturaAMonotributistaPositivosIva27);
			System.out.println(
					"Total Factura A Monotributista Negativos 27: " + formattedTotalFacturaAMonotributistaNegativos27
							+ " \tIVA\t " + formattedTotalFacturaAMonotributistaNegativosIva27);
			System.out.println("Total Factura A Monotributista 27: " + formattedTotalFacturaAMonotributista27
					+ " \tIVA\t " + formattedTotalFacturaAMonotributistaIva27);
			System.out.println("Total Factura A Exentos No Alcanzados Positivos 27: "
					+ formattedTotalFacturaAExentosNoAlcanzadosPositivos27 + " \tIVA\t "
					+ formattedTotalFacturaAExentosNoAlcanzadosPositivosIva27);
			System.out.println("Total Factura A Exentos No Alcanzados Negativos 27: "
					+ formattedTotalFacturaAExentosNoAlcanzadosNegativos27 + " \tIVA\t "
					+ formattedTotalFacturaAExentosNoAlcanzadosNegativosIva27);
			System.out
					.println("Total Factura A Exentos No Alcanzados 27: " + formattedTotalFacturaAExentosNoAlcanzados27
							+ " \tIVA\t " + formattedTotalFacturaAExentosNoAlcanzadosIva27);
			System.out.println("Total Factura A Positivos (sin Facturas Z positivas) 27: "
					+ formattedTotalFacturaAPositivos27 + " \tIVA\t " + formattedTotalFacturaAPositivosIva27);
			System.out.println("Total Factura A Negativos (sin Facturas Z negativas) 27: "
					+ formattedTotalFacturaANegativos27 + " \tIVA\t " + formattedTotalFacturaANegativosIva27);
			System.out.println("Total Factura A (sin Facturas Z) 27: " + formattedTotalFacturaA27 + " \tIVA\t "
					+ formattedTotalFacturaAIva27);

			System.out.println("\nFacturas B 27");

			System.out.println(
					"Total Factura B Consumidor Final Positivos 27: " + formattedTotalFacturaBConsumidorFinalPositivos27
							+ " \tIVA\t " + formattedTotalFacturaBConsumidorFinalPositivosIva27);
			System.out.println(
					"Total Factura B Consumidor Final Negativos 27: " + formattedTotalFacturaBConsumidorFinalNegativos27
							+ " \tIVA\t " + formattedTotalFacturaBConsumidorFinalNegativosIva27);
			System.out.println("Total Factura B Consumidor Final 27: " + formattedTotalFacturaBConsumidorFinal27
					+ " \tIVA\t " + formattedTotalFacturaBConsumidorFinalIva27);
			System.out.println(
					"Total Factura B Monotributista Positivos 27: " + formattedTotalFacturaBMonotributistaPositivos27
							+ " \tIVA\t " + formattedTotalFacturaBMonotributistaPositivosIva27);
			System.out.println(
					"Total Factura B Monotributista Negativos 27: " + formattedTotalFacturaBMonotributistaNegativos27
							+ " \tIVA\t " + formattedTotalFacturaBMonotributistaNegativosIva27);
			System.out.println("Total Factura B Monotributista 27: " + formattedTotalFacturaBMonotributista27
					+ " \tIVA\t " + formattedTotalFacturaBMonotributistaIva27);
			System.out.println("Total Factura B Exentos No Alcanzados Positivos 27: "
					+ formattedTotalFacturaBExentosNoAlcanzadosPositivos27 + " \tIVA\t "
					+ formattedTotalFacturaBExentosNoAlcanzadosPositivosIva27);
			System.out.println("Total Factura B Exentos No Alcanzados Negativos 27: "
					+ formattedTotalFacturaBExentosNoAlcanzadosNegativos27 + " \tIVA\t "
					+ formattedTotalFacturaBExentosNoAlcanzadosNegativosIva27);
			System.out
					.println("Total Factura B Exentos No Alcanzados 27: " + formattedTotalFacturaBExentosNoAlcanzados27
							+ " \tIVA\t " + formattedTotalFacturaBExentosNoAlcanzadosIva27);
			System.out.println("Total Factura B Positivos (sin Facturas Z positivas) 27: "
					+ formattedTotalFacturaBPositivos27 + " \tIVA\t " + formattedTotalFacturaBPositivosIva27);
			System.out.println("Total Factura B Negativos (sin Facturas Z negativas) 27: "
					+ formattedTotalFacturaBNegativos27 + " \tIVA\t " + formattedTotalFacturaBNegativosIva27);
			System.out.println("Total Factura B (sin facturas Z) 27: " + formattedTotalFacturaB27 + " \tIVA\t "
					+ formattedTotalFacturaBIva27);

			System.out.println("\nFacturas Z 27");

			System.out.println("Total Factura Z Que Son Factura A Positivos 27: " + formattedTotalFacturaZ_A_Positivos27
					+ " \tIVA\t " + formattedTotalFacturaZ_A_PositivosIva27);
			System.out.println("Total Factura Z Que Son Factura A Negativos 27: " + formattedTotalFacturaZ_A_Negativos27
					+ " \tIVA\t " + formattedTotalFacturaZ_A_NegativosIva27);
			System.out.println("Total Factura Z Que Son Factura A 27: " + formattedTotalFacturaZ_A27 + " \tIVA\t "
					+ formattedTotalFacturaZ_AIva27);
			System.out.println("Total Factura Z Que Son Factura B Positivos 27: " + formattedTotalFacturaZ_B_Positivos27
					+ " \tIVA\t " + formattedTotalFacturaZ_B_PositivosIva27);
			System.out.println("Total Factura Z Que Son Factura B Negativos 27: " + formattedTotalFacturaZ_B_Negativos27
					+ " \tIVA\t " + formattedTotalFacturaZ_B_NegativosIva27);
			System.out.println("Total Factura Z Que Son Factura B 27: " + formattedTotalFacturaZ_B27 + " \tIVA\t "
					+ formattedTotalFacturaZ_BIva27);
			System.out.println("Total Factura Z Positivos 27: " + formattedTotalFacturaZPositivos27 + " \tIVA\t "
					+ formattedTotalFacturaZPositivosIva27);
			System.out.println("Total Factura Z Negativos 27: " + formattedTotalFacturaZNegativos27 + " \tIVA\t "
					+ formattedTotalFacturaZNegativosIva27);
			System.out.println(
					"Total Factura Z 27: " + formattedTotalFacturaZ27 + " \tIVA\t " + formattedTotalFacturaZIva27);

			System.out.println("Total Factura A Positivos (con Facturas Z que son A Positivos) 27: "
					+ formattedTotalFacturaAPositivosFacturaZ_A_Positivos27 + " \tIVA\t "
					+ formattedTotalFacturaAPositivosFacturaZ_A_PositivosIva27);
			System.out.println("Total Factura A Negativos (con Facturas Z que son A Negativos) 27: "
					+ formattedTotalFacturaANegativosFacturaZ_A_Negativos27 + " \tIVA\t "
					+ formattedTotalFacturaANegativosFacturaZ_A_NegativosIva27);
			System.out.println("Total Factura A (con Facturas Z que son A) 27: " + formattedTotalFacturaAFacturaZ_A27
					+ " \tIVA\t " + formattedTotalFacturaAFacturaZ_AIva27);

			System.out.println("Total Factura B Positivos (con Facturas Z que son B Positivos) 27: "
					+ formattedTotalFacturaBPositivosFacturaZ_B_Positivos27 + " \tIVA\t "
					+ formattedTotalFacturaBPositivosFacturaZ_B_PositivosIva27);
			System.out.println("Total Factura B Negativos (con Facturas Z que son B Negativos) 27: "
					+ formattedTotalFacturaBNegativosFacturaZ_B_Negativos27 + " \tIVA\t "
					+ formattedTotalFacturaBNegativosFacturaZ_B_NegativosIva27);
			System.out.println("Total Factura B (con Facturas Z que son B) 27: " + formattedTotalFacturaBFacturaZ_B27
					+ " \tIVA\t " + formattedTotalFacturaBFacturaZ_BIva27);

			System.out.println("Total Factura Z Que Son Factura A Positivos Responsable Inscripto 27: "
					+ formattedTotalFacturaZ_A_Positivos_ResponsableInscripto27 + " \tIVA\t "
					+ formattedTotalFacturaZ_A_Positivos_ResponsableInscriptoIva27);
			System.out.println("Operaciones con responsables Inscriptos) 27: " + formattedOpRi27 + " \tIVA\t "
					+ formattedOpRiIva27);

			System.out.println("Total Factura Z Que Son Factura A Positivos Monotributistas 27: "
					+ formattedTotalFacturaZ_A_Positivos_Monotributistas27 + " \tIVA\t "
					+ formattedTotalFacturaZ_A_Positivos_MonotributistasIva27);
			System.out.println("Total Factura Z Que Son Factura B Positivos Monotributistas 27: "
					+ formattedTotalFacturaZ_B_Positivos_Monotributistas27 + " \tIVA\t "
					+ formattedTotalFacturaZ_B_Positivos_MonotributistasIva27);

			System.out.println("Total Factura Z Que son Factura B Positivos Consumidores Finales 27: "
					+ formattedTotalFacturaZ_B_Positivos_ConsumidoresFinales27 + " \tIVA\t "
					+ formattedTotalFacturaZ_B_Positivos_ConsumidoresFinalesIva27);

			System.out.println("Total Factura Z Que Son Factura A Positivos Exentos No Alcanzados 27: "
					+ formattedTotalFacturaZ_A_Positivos_ExentosNoAlcanzados27 + " \tIVA\t "
					+ formattedTotalFacturaZ_A_Positivos_ExentosNoAlcanzadosIva27);

			System.out.println("Total Factura Z Que son Factura B Positivos Exentos No Alcanzados 27: "
					+ formattedTotalFacturaZ_B_Positivos_ExentosNoAlcanzados27 + " \tIVA\t "
					+ formattedTotalFacturaZ_B_Positivos_ExentosNoAlcanzadosIva27);

			System.out.println("Operaciones con CF y EXENTOS NO ALCANZADOS 27: " + formattedOpCfExentos27 + " \tIVA\t "
					+ formattedOpCfExentosIva27);
			System.out.println("Operaciones con MON 27: " + formattedOpMon27 + " \tIVA\t " + formattedOpMonIva27);

			System.out.println("Total Factura Z Que Son Factura A Negativos Responsable Inscripto 27: "
					+ formattedTotalFacturaZ_A_Negativos_ResponsableInscripto27 + " \tIVA\t "
					+ formattedTotalFacturaZ_A_Negativos_ResponsableInscriptoIva27);

			System.out.println("Operaciones con responsables Inscriptos (Crédito) 27: " + formattedOpRiCredito27
					+ " \tIVA\t " + formattedOpRiCreditoIva27);

			System.out.println("Total Factura Z Que Son Factura A Negativos Monotributistas 27: "
					+ formattedTotalFacturaZ_A_Negativos_Monotributistas27 + " \tIVA\t "
					+ formattedTotalFacturaZ_A_Negativos_MonotributistasIva27);
			System.out.println("Total Factura Z Que Son Factura B Negativos Monotributistas 27: "
					+ formattedTotalFacturaZ_B_Negativos_Monotributistas27 + " \tIVA\t "
					+ formattedTotalFacturaZ_B_Negativos_MonotributistasIva27);

			System.out.println("Total Factura Z Que son Factura B Negativos Consumidores Finales 27: "
					+ formattedTotalFacturaZ_B_Negativos_ConsumidoresFinales27 + " \tIVA\t "
					+ formattedTotalFacturaZ_B_Negativos_ConsumidoresFinalesIva27);

			System.out.println("Total Factura Z Que Son Factura A Negativos Exentos No Alcanzados 27: "
					+ formattedTotalFacturaZ_A_Negativos_ExentosNoAlcanzados27 + " \tIVA\t "
					+ formattedTotalFacturaZ_A_Negativos_ExentosNoAlcanzadosIva27);

			System.out.println("Total Factura Z Que son Factura B Negativos Exentos No Alcanzados 27: "
					+ formattedTotalFacturaZ_B_Negativos_ExentosNoAlcanzados27 + " \tIVA\t "
					+ formattedTotalFacturaZ_B_Negativos_ExentosNoAlcanzadosIva27);

			System.out.println("Operaciones con CF, MON y EXENTOS NO ALCANZADOS (Crédito) 27: "
					+ formattedOpCfExentosMonCredito27 + " \tIVA\t " + formattedOpCfExentosMonCreditoIva27);

			// Formatear los resultados

			String formattedTotalFacturaAResponsableInscriptoPositivos = String
					.format("%.2f", totalFacturaAResponsableInscriptoPositivos).replace(".", ",");
			String formattedTotalFacturaAResponsableInscriptoNegativos = String
					.format("%.2f", totalFacturaAResponsableInscriptoNegativos).replace(".", ",");
			String formattedTotalFacturaAResponsableInscripto = String.format("%.2f", totalFacturaAResponsableInscripto)
					.replace(".", ",");
			String formattedTotalFacturaAMonotributistaPositivos = String
					.format("%.2f", totalFacturaAMonotributistaPositivos).replace(".", ",");
			String formattedTotalFacturaAMonotributistaNegativos = String
					.format("%.2f", totalFacturaAMonotributistaNegativos).replace(".", ",");
			String formattedTotalFacturaAMonotributista = String.format("%.2f", totalFacturaAMonotributista)
					.replace(".", ",");
			String formattedTotalFacturaAExentosNoAlcanzadosPositivos = String
					.format("%.2f", totalFacturaAExentosNoAlcanzadosPositivos).replace(".", ",");
			String formattedTotalFacturaAExentosNoAlcanzadosNegativos = String
					.format("%.2f", totalFacturaAExentosNoAlcanzadosNegativos).replace(".", ",");
			String formattedTotalFacturaAExentosNoAlcanzados = String.format("%.2f", totalFacturaAExentosNoAlcanzados)
					.replace(".", ",");
			String formattedTotalFacturaAPositivos = String.format("%.2f", totalFacturaAPositivos).replace(".", ",");
			String formattedTotalFacturaANegativos = String.format("%.2f", totalFacturaANegativos).replace(".", ",");
			String formattedTotalFacturaA = String.format("%.2f", totalFacturaA).replace(".", ",");

			String formattedTotalFacturaBConsumidorFinalPositivos = String
					.format("%.2f", totalFacturaBConsumidorFinalPositivos).replace(".", ",");
			String formattedTotalFacturaBConsumidorFinalNegativos = String
					.format("%.2f", totalFacturaBConsumidorFinalNegativos).replace(".", ",");
			String formattedTotalFacturaBConsumidorFinal = String.format("%.2f", totalFacturaBConsumidorFinal)
					.replace(".", ",");
			String formattedTotalFacturaBMonotributistaPositivos = String
					.format("%.2f", totalFacturaBMonotributistaPositivos).replace(".", ",");
			String formattedTotalFacturaBMonotributistaNegativos = String
					.format("%.2f", totalFacturaBMonotributistaNegativos).replace(".", ",");
			String formattedTotalFacturaBMonotributista = String.format("%.2f", totalFacturaBMonotributista)
					.replace(".", ",");
			String formattedTotalFacturaBExentosNoAlcanzadosPositivos = String
					.format("%.2f", totalFacturaBExentosNoAlcanzadosPositivos).replace(".", ",");
			String formattedTotalFacturaBExentosNoAlcanzadosNegativos = String
					.format("%.2f", totalFacturaBExentosNoAlcanzadosNegativos).replace(".", ",");
			String formattedTotalFacturaBExentosNoAlcanzados = String.format("%.2f", totalFacturaBExentosNoAlcanzados)
					.replace(".", ",");
			String formattedTotalFacturaBPositivos = String.format("%.2f", totalFacturaBPositivos).replace(".", ",");
			String formattedTotalFacturaBNegativos = String.format("%.2f", totalFacturaBNegativos).replace(".", ",");
			String formattedTotalFacturaB = String.format("%.2f", totalFacturaB).replace(".", ",");

			String formattedTotalFacturaZ_A_Positivos = String.format("%.2f", totalFacturaZ_A_Positivos).replace(".",
					",");
			String formattedTotalFacturaZ_A_Negativos = String.format("%.2f", totalFacturaZ_A_Negativos).replace(".",
					",");
			String formattedTotalFacturaZ_A = String.format("%.2f", totalFacturaZ_A).replace(".", ",");
			String formattedTotalFacturaZ_B_Positivos = String.format("%.2f", totalFacturaZ_B_Positivos).replace(".",
					",");
			String formattedTotalFacturaZ_B_Negativos = String.format("%.2f", totalFacturaZ_B_Negativos).replace(".",
					",");
			String formattedTotalFacturaZ_B = String.format("%.2f", totalFacturaZ_B).replace(".", ",");
			String formattedTotalFacturaZPositivos = String.format("%.2f", totalFacturaZPositivos).replace(".", ",");
			String formattedTotalFacturaZNegativos = String.format("%.2f", totalFacturaZNegativos).replace(".", ",");
			String formattedTotalFacturaZ = String.format("%.2f", totalFacturaZ).replace(".", ",");

			String formattedTotalFacturaAPositivosFacturaZ_A_Positivos = String
					.format("%.2f", totalFacturaAPositivosFacturaZ_A_Positivos).replace(".", ",");
			String formattedTotalFacturaANegativosFacturaZ_A_Negativos = String
					.format("%.2f", totalFacturaANegativosFacturaZ_A_Negativos).replace(".", ",");
			String formattedTotalFacturaAFacturaZ_A = String.format("%.2f", totalFacturaAFacturaZ_A).replace(".", ",");
			String formattedTotalFacturaBPositivosFacturaZ_B_Positivos = String
					.format("%.2f", totalFacturaBPositivosFacturaZ_B_Positivos).replace(".", ",");
			String formattedTotalFacturaBNegativosFacturaZ_B_Negativos = String
					.format("%.2f", totalFacturaBNegativosFacturaZ_B_Negativos).replace(".", ",");
			String formattedTotalFacturaBFacturaZ_B = String.format("%.2f", totalFacturaBFacturaZ_B).replace(".", ",");

			String formattedTotalFacturaZ_A_Positivos_Monotributistas = String
					.format("%.2f", totalFacturaZ_A_Positivos_Monotributistas).replace(".", ",");
			String formattedTotalFacturaZ_B_Positivos_Monotributistas = String
					.format("%.2f", totalFacturaZ_B_Positivos_Monotributistas).replace(".", ",");
			String formattedTotalFacturaZ_B_Positivos_ConsumidoresFinales = String
					.format("%.2f", totalFacturaZ_B_Positivos_ConsumidoresFinales).replace(".", ",");
			String formattedTotalFacturaZ_A_Positivos_ExentosNoAlcanzados = String
					.format("%.2f", totalFacturaZ_A_Positivos_ExentosNoAlcanzados).replace(".", ",");
			String formattedTotalFacturaZ_B_Positivos_ExentosNoAlcanzados = String
					.format("%.2f", totalFacturaZ_B_Positivos_ExentosNoAlcanzados).replace(".", ",");
			String formattedTotalFacturaZ_A_Positivos_ResponsableInscripto = String
					.format("%.2f", totalFacturaZ_A_Positivos_ResponsableInscripto).replace(".", ",");

			String formattedTotalFacturaZ_A_Negativos_Monotributistas = String
					.format("%.2f", totalFacturaZ_A_Negativos_Monotributistas).replace(".", ",");
			String formattedTotalFacturaZ_B_Negativos_Monotributistas = String
					.format("%.2f", totalFacturaZ_B_Negativos_Monotributistas).replace(".", ",");
			String formattedTotalFacturaZ_B_Negativos_ConsumidoresFinales = String
					.format("%.2f", totalFacturaZ_B_Negativos_ConsumidoresFinales).replace(".", ",");
			String formattedTotalFacturaZ_A_Negativos_ExentosNoAlcanzados = String
					.format("%.2f", totalFacturaZ_A_Negativos_ExentosNoAlcanzados).replace(".", ",");
			String formattedTotalFacturaZ_B_Negativos_ExentosNoAlcanzados = String
					.format("%.2f", totalFacturaZ_B_Negativos_ExentosNoAlcanzados).replace(".", ",");
			String formattedTotalFacturaZ_A_Negativos_ResponsableInscripto = String
					.format("%.2f", totalFacturaZ_A_Negativos_ResponsableInscripto).replace(".", ",");

			String formattedOpRi = String
					.format("%.2f",
							totalFacturaAResponsableInscriptoPositivos + totalFacturaZ_A_Positivos_ResponsableInscripto)
					.replace(".", ",");
			String formattedOpCfExentos = String.format("%.2f",
					totalFacturaZ_B_Positivos_ConsumidoresFinales + totalFacturaZ_A_Positivos_ExentosNoAlcanzados
							+ totalFacturaZ_B_Positivos_ExentosNoAlcanzados + totalFacturaAExentosNoAlcanzadosPositivos
							+ totalFacturaBConsumidorFinalPositivos + totalFacturaBExentosNoAlcanzadosPositivos)
					.replace(".", ",");
			String formattedOpMon = String
					.format("%.2f",
							totalFacturaZ_A_Positivos_Monotributistas + totalFacturaZ_B_Positivos_Monotributistas
									+ totalFacturaAMonotributistaPositivos + totalFacturaBMonotributistaPositivos)
					.replace(".", ",");

			String formattedOpRiCredito = String
					.format("%.2f",
							totalFacturaAResponsableInscriptoNegativos + totalFacturaZ_A_Negativos_ResponsableInscripto)
					.replace(".", ",");

			String formattedOpCfExentosMonCredito = String.format("%.2f",
					totalFacturaZ_B_Negativos_ConsumidoresFinales + totalFacturaZ_A_Negativos_ExentosNoAlcanzados
							+ totalFacturaZ_B_Negativos_ExentosNoAlcanzados + totalFacturaAExentosNoAlcanzadosNegativos
							+ totalFacturaBConsumidorFinalNegativos + totalFacturaBExentosNoAlcanzadosNegativos
							+ totalFacturaZ_A_Negativos_Monotributistas + totalFacturaZ_B_Negativos_Monotributistas
							+ totalFacturaAMonotributistaNegativos + totalFacturaBMonotributistaNegativos)
					.replace(".", ",");

			String formattedtotalFacturaZAB_ABPositivos = String
					.format("%.2f",
							totalFacturaAPositivosFacturaZ_A_Positivos + totalFacturaBPositivosFacturaZ_B_Positivos)
					.replace(".", ",");
			String formattedtotalFacturaZAB_ABNegativos = String
					.format("%.2f",
							totalFacturaANegativosFacturaZ_A_Negativos + totalFacturaBNegativosFacturaZ_B_Negativos)
					.replace(".", ",");
			String formattedtotalFacturaZAB_AB = String
					.format("%.2f", totalFacturaAFacturaZ_A + totalFacturaBFacturaZ_B).replace(".", ",");

			String formattedTotalFacturaAResponsableInscriptoPositivosIva = String
					.format("%.2f", totalFacturaAResponsableInscriptoPositivosIva).replace(".", ",");
			String formattedTotalFacturaAResponsableInscriptoNegativosIva = String
					.format("%.2f", totalFacturaAResponsableInscriptoNegativosIva).replace(".", ",");
			String formattedTotalFacturaAResponsableInscriptoIva = String
					.format("%.2f", totalFacturaAResponsableInscriptoIva).replace(".", ",");
			String formattedTotalFacturaAMonotributistaPositivosIva = String
					.format("%.2f", totalFacturaAMonotributistaPositivosIva).replace(".", ",");
			String formattedTotalFacturaAMonotributistaNegativosIva = String
					.format("%.2f", totalFacturaAMonotributistaNegativosIva).replace(".", ",");
			String formattedTotalFacturaAMonotributistaIva = String.format("%.2f", totalFacturaAMonotributistaIva)
					.replace(".", ",");
			String formattedTotalFacturaAExentosNoAlcanzadosPositivosIva = String
					.format("%.2f", totalFacturaAExentosNoAlcanzadosPositivosIva).replace(".", ",");
			String formattedTotalFacturaAExentosNoAlcanzadosNegativosIva = String
					.format("%.2f", totalFacturaAExentosNoAlcanzadosNegativosIva).replace(".", ",");
			String formattedTotalFacturaAExentosNoAlcanzadosIva = String
					.format("%.2f", totalFacturaAExentosNoAlcanzadosIva).replace(".", ",");
			String formattedTotalFacturaAPositivosIva = String.format("%.2f", totalFacturaAPositivosIva).replace(".",
					",");
			String formattedTotalFacturaANegativosIva = String.format("%.2f", totalFacturaANegativosIva).replace(".",
					",");
			String formattedTotalFacturaAIva = String.format("%.2f", totalFacturaAIva).replace(".", ",");

			String formattedTotalFacturaBConsumidorFinalPositivosIva = String
					.format("%.2f", totalFacturaBConsumidorFinalPositivosIva).replace(".", ",");
			String formattedTotalFacturaBConsumidorFinalNegativosIva = String
					.format("%.2f", totalFacturaBConsumidorFinalNegativosIva).replace(".", ",");
			String formattedTotalFacturaBConsumidorFinalIva = String.format("%.2f", totalFacturaBConsumidorFinalIva)
					.replace(".", ",");
			String formattedTotalFacturaBMonotributistaPositivosIva = String
					.format("%.2f", totalFacturaBMonotributistaPositivosIva).replace(".", ",");
			String formattedTotalFacturaBMonotributistaNegativosIva = String
					.format("%.2f", totalFacturaBMonotributistaNegativosIva).replace(".", ",");
			String formattedTotalFacturaBMonotributistaIva = String.format("%.2f", totalFacturaBMonotributistaIva)
					.replace(".", ",");
			String formattedTotalFacturaBExentosNoAlcanzadosPositivosIva = String
					.format("%.2f", totalFacturaBExentosNoAlcanzadosPositivosIva).replace(".", ",");
			String formattedTotalFacturaBExentosNoAlcanzadosNegativosIva = String
					.format("%.2f", totalFacturaBExentosNoAlcanzadosNegativosIva).replace(".", ",");
			String formattedTotalFacturaBExentosNoAlcanzadosIva = String
					.format("%.2f", totalFacturaBExentosNoAlcanzadosIva).replace(".", ",");
			String formattedTotalFacturaBPositivosIva = String.format("%.2f", totalFacturaBPositivosIva).replace(".",
					",");
			String formattedTotalFacturaBNegativosIva = String.format("%.2f", totalFacturaBNegativosIva).replace(".",
					",");
			String formattedTotalFacturaBIva = String.format("%.2f", totalFacturaBIva).replace(".", ",");

			String formattedTotalFacturaZ_A_PositivosIva = String.format("%.2f", totalFacturaZ_A_PositivosIva)
					.replace(".", ",");
			String formattedTotalFacturaZ_A_NegativosIva = String.format("%.2f", totalFacturaZ_A_NegativosIva)
					.replace(".", ",");
			String formattedTotalFacturaZ_AIva = String.format("%.2f", totalFacturaZ_A_Iva).replace(".", ",");
			String formattedTotalFacturaZ_B_PositivosIva = String.format("%.2f", totalFacturaZ_B_PositivosIva)
					.replace(".", ",");
			String formattedTotalFacturaZ_B_NegativosIva = String.format("%.2f", totalFacturaZ_B_NegativosIva)
					.replace(".", ",");
			String formattedTotalFacturaZ_BIva = String.format("%.2f", totalFacturaZ_B_Iva).replace(".", ",");
			String formattedTotalFacturaZPositivosIva = String.format("%.2f", totalFacturaZPositivosIva).replace(".",
					",");
			String formattedTotalFacturaZNegativosIva = String.format("%.2f", totalFacturaZNegativosIva).replace(".",
					",");
			String formattedTotalFacturaZIva = String.format("%.2f", totalFacturaZIva).replace(".", ",");

			String formattedTotalFacturaAPositivosFacturaZ_A_PositivosIva = String
					.format("%.2f", totalFacturaAPositivosFacturaZ_A_PositivosIva).replace(".", ",");
			String formattedTotalFacturaANegativosFacturaZ_A_NegativosIva = String
					.format("%.2f", totalFacturaANegativosFacturaZ_A_NegativosIva).replace(".", ",");
			String formattedTotalFacturaAFacturaZ_AIva = String.format("%.2f", totalFacturaAFacturaZ_AIva).replace(".",
					",");
			String formattedTotalFacturaBPositivosFacturaZ_B_PositivosIva = String
					.format("%.2f", totalFacturaBPositivosFacturaZ_B_PositivosIva).replace(".", ",");
			String formattedTotalFacturaBNegativosFacturaZ_B_NegativosIva = String
					.format("%.2f", totalFacturaBNegativosFacturaZ_B_NegativosIva).replace(".", ",");
			String formattedTotalFacturaBFacturaZ_BIva = String.format("%.2f", totalFacturaBFacturaZ_BIva).replace(".",
					",");

			String formattedTotalFacturaZ_A_Positivos_MonotributistasIva = String
					.format("%.2f", totalFacturaZ_A_Positivos_MonotributistasIva).replace(".", ",");
			String formattedTotalFacturaZ_B_Positivos_MonotributistasIva = String
					.format("%.2f", totalFacturaZ_B_Positivos_MonotributistasIva).replace(".", ",");
			String formattedTotalFacturaZ_B_Positivos_ConsumidoresFinalesIva = String
					.format("%.2f", totalFacturaZ_B_Positivos_ConsumidoresFinalesIva).replace(".", ",");
			String formattedTotalFacturaZ_A_Positivos_ExentosNoAlcanzadosIva = String
					.format("%.2f", totalFacturaZ_A_Positivos_ExentosNoAlcanzadosIva).replace(".", ",");
			String formattedTotalFacturaZ_B_Positivos_ExentosNoAlcanzadosIva = String
					.format("%.2f", totalFacturaZ_B_Positivos_ExentosNoAlcanzadosIva).replace(".", ",");
			String formattedTotalFacturaZ_A_Positivos_ResponsableInscriptoIva = String
					.format("%.2f", totalFacturaZ_A_Positivos_ResponsableInscriptoIva).replace(".", ",");

			String formattedTotalFacturaZ_A_Negativos_MonotributistasIva = String
					.format("%.2f", totalFacturaZ_A_Negativos_MonotributistasIva).replace(".", ",");
			String formattedTotalFacturaZ_B_Negativos_MonotributistasIva = String
					.format("%.2f", totalFacturaZ_B_Negativos_MonotributistasIva).replace(".", ",");
			String formattedTotalFacturaZ_B_Negativos_ConsumidoresFinalesIva = String
					.format("%.2f", totalFacturaZ_B_Negativos_ConsumidoresFinalesIva).replace(".", ",");
			String formattedTotalFacturaZ_A_Negativos_ExentosNoAlcanzadosIva = String
					.format("%.2f", totalFacturaZ_A_Negativos_ExentosNoAlcanzadosIva).replace(".", ",");
			String formattedTotalFacturaZ_B_Negativos_ExentosNoAlcanzadosIva = String
					.format("%.2f", totalFacturaZ_B_Negativos_ExentosNoAlcanzadosIva).replace(".", ",");
			String formattedTotalFacturaZ_A_Negativos_ResponsableInscriptoIva = String
					.format("%.2f", totalFacturaZ_A_Negativos_ResponsableInscriptoIva).replace(".", ",");

			String formattedOpRiIva = String.format("%.2f",
					totalFacturaAResponsableInscriptoPositivosIva + totalFacturaZ_A_Positivos_ResponsableInscriptoIva)
					.replace(".", ",");
			String formattedOpCfExentosIva = String.format("%.2f",
					totalFacturaZ_B_Positivos_ConsumidoresFinalesIva + totalFacturaZ_A_Positivos_ExentosNoAlcanzadosIva
							+ totalFacturaZ_B_Positivos_ExentosNoAlcanzadosIva
							+ totalFacturaAExentosNoAlcanzadosPositivosIva + totalFacturaBConsumidorFinalPositivosIva
							+ totalFacturaBExentosNoAlcanzadosPositivosIva)
					.replace(".", ",");
			String formattedOpMonIva = String
					.format("%.2f",
							totalFacturaZ_A_Positivos_MonotributistasIva + totalFacturaZ_B_Positivos_MonotributistasIva
									+ totalFacturaAMonotributistaPositivosIva + totalFacturaBMonotributistaPositivosIva)
					.replace(".", ",");

			String formattedOpRiCreditoIva = String.format("%.2f",
					totalFacturaAResponsableInscriptoNegativosIva + totalFacturaZ_A_Negativos_ResponsableInscriptoIva)
					.replace(".", ",");

			String formattedOpCfExentosMonCreditoIva = String.format("%.2f",
					totalFacturaZ_B_Negativos_ConsumidoresFinalesIva + totalFacturaZ_A_Negativos_ExentosNoAlcanzadosIva
							+ totalFacturaZ_B_Negativos_ExentosNoAlcanzadosIva
							+ totalFacturaAExentosNoAlcanzadosNegativosIva + totalFacturaBConsumidorFinalNegativosIva
							+ totalFacturaBExentosNoAlcanzadosNegativosIva
							+ totalFacturaZ_A_Negativos_MonotributistasIva
							+ totalFacturaZ_B_Negativos_MonotributistasIva + totalFacturaAMonotributistaNegativosIva
							+ totalFacturaBMonotributistaNegativosIva)
					.replace(".", ",");

			String formattedtotalFacturaZAB_ABPositivosIva = String.format("%.2f",
					totalFacturaAPositivosFacturaZ_A_PositivosIva + totalFacturaBPositivosFacturaZ_B_PositivosIva)
					.replace(".", ",");
			String formattedtotalFacturaZAB_ABNegativosIva = String.format("%.2f",
					totalFacturaANegativosFacturaZ_A_NegativosIva + totalFacturaBNegativosFacturaZ_B_NegativosIva)
					.replace(".", ",");
			String formattedtotalFacturaZAB_ABIva = String
					.format("%.2f", totalFacturaAFacturaZ_AIva + totalFacturaBFacturaZ_BIva).replace(".", ",");

			// Mostrar los resultados formateados
			System.out.println("\nTotales acumulados Neto Gravado con IVA:");

			System.out.println("\nFacturas A");

			System.out.println("Total Factura A Responsable Inscripto (RI) Positivos: "
					+ formattedTotalFacturaAResponsableInscriptoPositivos + " \tIVA\t "
					+ formattedTotalFacturaAResponsableInscriptoPositivosIva);
			System.out.println("Total Factura A Responsable Inscripto (RI) Negativos: "
					+ formattedTotalFacturaAResponsableInscriptoNegativos + " \tIVA\t "
					+ formattedTotalFacturaAResponsableInscriptoNegativosIva);
			System.out
					.println("Total Factura A Responsable Inscripto (RI): " + formattedTotalFacturaAResponsableInscripto
							+ " \tIVA\t " + formattedTotalFacturaAResponsableInscriptoIva);
			System.out.println(
					"Total Factura A Monotributista Positivos: " + formattedTotalFacturaAMonotributistaPositivos
							+ " \tIVA\t " + formattedTotalFacturaAMonotributistaPositivosIva);
			System.out.println(
					"Total Factura A Monotributista Negativos: " + formattedTotalFacturaAMonotributistaNegativos
							+ " \tIVA\t " + formattedTotalFacturaAMonotributistaNegativosIva);
			System.out.println("Total Factura A Monotributista: " + formattedTotalFacturaAMonotributista + " \tIVA\t "
					+ formattedTotalFacturaAMonotributistaIva);
			System.out.println("Total Factura A Exentos No Alcanzados Positivos: "
					+ formattedTotalFacturaAExentosNoAlcanzadosPositivos + " \tIVA\t "
					+ formattedTotalFacturaAExentosNoAlcanzadosPositivosIva);
			System.out.println("Total Factura A Exentos No Alcanzados Negativos: "
					+ formattedTotalFacturaAExentosNoAlcanzadosNegativos + " \tIVA\t "
					+ formattedTotalFacturaAExentosNoAlcanzadosNegativosIva);
			System.out.println("Total Factura A Exentos No Alcanzados: " + formattedTotalFacturaAExentosNoAlcanzados
					+ " \tIVA\t " + formattedTotalFacturaAExentosNoAlcanzadosIva);
			System.out.println("Total Factura A Positivos (sin Facturas Z positivas): "
					+ formattedTotalFacturaAPositivos + " \tIVA\t " + formattedTotalFacturaAPositivosIva);
			System.out.println("Total Factura A Negativos (sin Facturas Z negativas): "
					+ formattedTotalFacturaANegativos + " \tIVA\t " + formattedTotalFacturaANegativosIva);
			System.out.println("Total Factura A (sin Facturas Z): " + formattedTotalFacturaA + " \tIVA\t "
					+ formattedTotalFacturaAIva);

			System.out.println("\nFacturas B");

			System.out.println(
					"Total Factura B Consumidor Final Positivos: " + formattedTotalFacturaBConsumidorFinalPositivos
							+ " \tIVA\t " + formattedTotalFacturaBConsumidorFinalPositivosIva);
			System.out.println(
					"Total Factura B Consumidor Final Negativos: " + formattedTotalFacturaBConsumidorFinalNegativos
							+ " \tIVA\t " + formattedTotalFacturaBConsumidorFinalNegativosIva);
			System.out.println("Total Factura B Consumidor Final: " + formattedTotalFacturaBConsumidorFinal
					+ " \tIVA\t " + formattedTotalFacturaBConsumidorFinalIva);
			System.out.println(
					"Total Factura B Monotributista Positivos: " + formattedTotalFacturaBMonotributistaPositivos
							+ " \tIVA\t " + formattedTotalFacturaBMonotributistaPositivosIva);
			System.out.println(
					"Total Factura B Monotributista Negativos: " + formattedTotalFacturaBMonotributistaNegativos
							+ " \tIVA\t " + formattedTotalFacturaBMonotributistaNegativosIva);
			System.out.println("Total Factura B Monotributista: " + formattedTotalFacturaBMonotributista + " \tIVA\t "
					+ formattedTotalFacturaBMonotributistaIva);
			System.out.println("Total Factura B Exentos No Alcanzados Positivos: "
					+ formattedTotalFacturaBExentosNoAlcanzadosPositivos + " \tIVA\t "
					+ formattedTotalFacturaBExentosNoAlcanzadosPositivosIva);
			System.out.println("Total Factura B Exentos No Alcanzados Negativos: "
					+ formattedTotalFacturaBExentosNoAlcanzadosNegativos + " \tIVA\t "
					+ formattedTotalFacturaBExentosNoAlcanzadosNegativosIva);
			System.out.println("Total Factura B Exentos No Alcanzados: " + formattedTotalFacturaBExentosNoAlcanzados
					+ " \tIVA\t " + formattedTotalFacturaBExentosNoAlcanzadosIva);
			System.out.println("Total Factura B Positivos (sin Facturas Z positivas): "
					+ formattedTotalFacturaBPositivos + " \tIVA\t " + formattedTotalFacturaBPositivosIva);
			System.out.println("Total Factura B Negativos (sin Facturas Z negativas): "
					+ formattedTotalFacturaBNegativos + " \tIVA\t " + formattedTotalFacturaBNegativosIva);
			System.out.println("Total Factura B (sin facturas Z): " + formattedTotalFacturaB + " \tIVA\t "
					+ formattedTotalFacturaBIva);

			System.out.println("\nFacturas Z");

			System.out.println("Total Factura Z Que Son Factura A Positivos: " + formattedTotalFacturaZ_A_Positivos
					+ " \tIVA\t " + formattedTotalFacturaZ_A_PositivosIva);
			System.out.println("Total Factura Z Que Son Factura A Negativos: " + formattedTotalFacturaZ_A_Negativos
					+ " \tIVA\t " + formattedTotalFacturaZ_A_NegativosIva);
			System.out.println("Total Factura Z Que Son Factura A: " + formattedTotalFacturaZ_A + " \tIVA\t "
					+ formattedTotalFacturaZ_AIva);
			System.out.println("Total Factura Z Que Son Factura B Positivos: " + formattedTotalFacturaZ_B_Positivos
					+ " \tIVA\t " + formattedTotalFacturaZ_B_PositivosIva);
			System.out.println("Total Factura Z Que Son Factura B Negativos: " + formattedTotalFacturaZ_B_Negativos
					+ " \tIVA\t " + formattedTotalFacturaZ_B_NegativosIva);
			System.out.println("Total Factura Z Que Son Factura B: " + formattedTotalFacturaZ_B + " \tIVA\t "
					+ formattedTotalFacturaZ_BIva);
			System.out.println("Total Factura Z Positivos: " + formattedTotalFacturaZPositivos + " \tIVA\t "
					+ formattedTotalFacturaZPositivosIva);
			System.out.println("Total Factura Z Negativos: " + formattedTotalFacturaZNegativos + " \tIVA\t "
					+ formattedTotalFacturaZNegativosIva);
			System.out.println("Total Factura Z: " + formattedTotalFacturaZ + " \tIVA\t " + formattedTotalFacturaZIva);

			System.out.println("Total Factura A Positivos (con Facturas Z que son A Positivos): "
					+ formattedTotalFacturaAPositivosFacturaZ_A_Positivos + " \tIVA\t "
					+ formattedTotalFacturaAPositivosFacturaZ_A_PositivosIva);
			System.out.println("Total Factura A Negativos (con Facturas Z que son A Negativos): "
					+ formattedTotalFacturaANegativosFacturaZ_A_Negativos + " \tIVA\t "
					+ formattedTotalFacturaANegativosFacturaZ_A_NegativosIva);
			System.out.println("Total Factura A (con Facturas Z que son A): " + formattedTotalFacturaAFacturaZ_A
					+ " \tIVA\t " + formattedTotalFacturaAFacturaZ_AIva);

			System.out.println("Total Factura B Positivos (con Facturas Z que son B Positivos): "
					+ formattedTotalFacturaBPositivosFacturaZ_B_Positivos + " \tIVA\t "
					+ formattedTotalFacturaBPositivosFacturaZ_B_PositivosIva);
			System.out.println("Total Factura B Negativos (con Facturas Z que son B Negativos): "
					+ formattedTotalFacturaBNegativosFacturaZ_B_Negativos + " \tIVA\t "
					+ formattedTotalFacturaBNegativosFacturaZ_B_NegativosIva);
			System.out.println("Total Factura B (con Facturas Z que son B): " + formattedTotalFacturaBFacturaZ_B
					+ " \tIVA\t " + formattedTotalFacturaBFacturaZ_BIva);

			System.out.println("Total Factura Z Que Son Factura A Positivos Responsable Inscripto : "
					+ formattedTotalFacturaZ_A_Positivos_ResponsableInscripto + " \tIVA\t "
					+ formattedTotalFacturaZ_A_Positivos_ResponsableInscriptoIva);
			System.out.println(
					"Operaciones con responsables Inscriptos): " + formattedOpRi + " \tIVA\t " + formattedOpRiIva);

			System.out.println("Total Factura Z Que Son Factura A Positivos Monotributistas: "
					+ formattedTotalFacturaZ_A_Positivos_Monotributistas + " \tIVA\t "
					+ formattedTotalFacturaZ_A_Positivos_MonotributistasIva);
			System.out.println("Total Factura Z Que Son Factura B Positivos Monotributistas: "
					+ formattedTotalFacturaZ_B_Positivos_Monotributistas + " \tIVA\t "
					+ formattedTotalFacturaZ_B_Positivos_MonotributistasIva);

			System.out.println("Total Factura Z Que son Factura B Positivos Consumidores Finales: "
					+ formattedTotalFacturaZ_B_Positivos_ConsumidoresFinales + " \tIVA\t "
					+ formattedTotalFacturaZ_B_Positivos_ConsumidoresFinalesIva);

			System.out.println("Total Factura Z Que Son Factura A Positivos Exentos No Alcanzados: "
					+ formattedTotalFacturaZ_A_Positivos_ExentosNoAlcanzados + " \tIVA\t "
					+ formattedTotalFacturaZ_A_Positivos_ExentosNoAlcanzadosIva);

			System.out.println("Total Factura Z Que son Factura B Positivos Exentos No Alcanzados: "
					+ formattedTotalFacturaZ_B_Positivos_ExentosNoAlcanzados + " \tIVA\t "
					+ formattedTotalFacturaZ_B_Positivos_ExentosNoAlcanzadosIva);

			System.out.println("Operaciones con CF y EXENTOS NO ALCANZADOS: " + formattedOpCfExentos + " \tIVA\t "
					+ formattedOpCfExentosIva);
			System.out.println("Operaciones con MON: " + formattedOpMon + " \tIVA\t " + formattedOpMonIva);

			System.out.println("Total Factura Z Que Son Factura A Negativos Responsable Inscripto : "
					+ formattedTotalFacturaZ_A_Negativos_ResponsableInscripto + " \tIVA\t "
					+ formattedTotalFacturaZ_A_Negativos_ResponsableInscriptoIva);

			System.out.println("Operaciones con responsables Inscriptos (Crédito): " + formattedOpRiCredito
					+ " \tIVA\t " + formattedOpRiCreditoIva);

			System.out.println("Total Factura Z Que Son Factura A Negativos Monotributistas: "
					+ formattedTotalFacturaZ_A_Negativos_Monotributistas + " \tIVA\t "
					+ formattedTotalFacturaZ_A_Negativos_MonotributistasIva);
			System.out.println("Total Factura Z Que Son Factura B Negativos Monotributistas: "
					+ formattedTotalFacturaZ_B_Negativos_Monotributistas + " \tIVA\t "
					+ formattedTotalFacturaZ_B_Negativos_MonotributistasIva);

			System.out.println("Total Factura Z Que son Factura B Negativos Consumidores Finales: "
					+ formattedTotalFacturaZ_B_Negativos_ConsumidoresFinales + " \tIVA\t "
					+ formattedTotalFacturaZ_B_Negativos_ConsumidoresFinalesIva);

			System.out.println("Total Factura Z Que Son Factura A Negativos Exentos No Alcanzados: "
					+ formattedTotalFacturaZ_A_Negativos_ExentosNoAlcanzados + " \tIVA\t "
					+ formattedTotalFacturaZ_A_Negativos_ExentosNoAlcanzadosIva);

			System.out.println("Total Factura Z Que son Factura B Negativos Exentos No Alcanzados: "
					+ formattedTotalFacturaZ_B_Negativos_ExentosNoAlcanzados + " \tIVA\t "
					+ formattedTotalFacturaZ_B_Negativos_ExentosNoAlcanzadosIva);

			System.out.println("Operaciones con CF, MON y EXENTOS NO ALCANZADOS (Crédito): "
					+ formattedOpCfExentosMonCredito + " \tIVA\t " + formattedOpCfExentosMonCreditoIva);

			System.out.println("Total Facturas A, B y Z (que son A y B) Positivos: "
					+ formattedtotalFacturaZAB_ABPositivos + " \tIVA\t " + formattedtotalFacturaZAB_ABPositivosIva);
			System.out.println("Total Facturas A, B y Z (que son A y B) Negativos: "
					+ formattedtotalFacturaZAB_ABNegativos + " \tIVA\t " + formattedtotalFacturaZAB_ABNegativosIva);
			System.out.println("Total Facturas A, B y Z (que son A y B): " + formattedtotalFacturaZAB_AB + " \tIVA\t "
					+ formattedtotalFacturaZAB_ABIva);

			System.out.println("Factura Procesada");
			Scanner lector = new Scanner(System.in);
			String n = lector.nextLine();
			lector.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void procesarArchivoExcelMultiplesPuntosDeVenta(String filePath) {
		try (FileInputStream fis = new FileInputStream(filePath); Workbook workbook = new XSSFWorkbook(fis)) {
			Sheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.iterator();
			rowIterator.next(); // Skip first header row
			rowIterator.next(); // Skip second header row

			Map<Integer, List<Row>> puntosDeVentaRows = new HashMap<>();

			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				Cell puntoDeVentaCell = row.getCell(4);

				if (puntoDeVentaCell != null && puntoDeVentaCell.getCellType() == CellType.NUMERIC) {
					int puntoDeVenta = (int) puntoDeVentaCell.getNumericCellValue();
					puntosDeVentaRows.computeIfAbsent(puntoDeVenta, k -> new ArrayList<>()).add(row);
				}
			}

			for (Map.Entry<Integer, List<Row>> entry : puntosDeVentaRows.entrySet()) {
				int puntoDeVenta = entry.getKey();
				List<Row> rows = entry.getValue();

				System.out.println(ANSI_PURPLE + "\nProcesando punto de venta: " + puntoDeVenta + "\n" + ANSI_RESET);

				procesarRowsPuntoDeVenta(rows, puntoDeVenta);

			}
			Scanner lector = new Scanner(System.in);
			String n = lector.nextLine();
			lector.close();

		} catch (Exception e) {
			System.out.println("Ocurrió un error al leer el archivo: " + e.getMessage());

		}
	}

	private static void procesarRowsPuntoDeVenta(List<Row> rows, int puntoDeVenta) {

		// Declaraciones Total Neto Gravado
		double totalFacturaAResponsableInscriptoPositivos = 0.0;
		double totalFacturaAResponsableInscriptoNegativos = 0.0;
		double totalFacturaAResponsableInscripto = 0.0;
		double totalFacturaAExentosNoAlcanzadosPositivos = 0.0;
		double totalFacturaAExentosNoAlcanzadosNegativos = 0.0;
		double totalFacturaAExentosNoAlcanzados = 0.0;
		double totalFacturaAMonotributistaPositivos = 0.0;
		double totalFacturaAMonotributistaNegativos = 0.0;
		double totalFacturaAMonotributista = 0.0;
		double totalFacturaAPositivos = 0.0;
		double totalFacturaANegativos = 0.0;
		double totalFacturaA = 0.0;
		double totalFacturaBConsumidorFinalPositivos = 0.0;
		double totalFacturaBConsumidorFinalNegativos = 0.0;
		double totalFacturaBConsumidorFinal = 0.0;
		double totalFacturaBMonotributistaPositivos = 0.0;
		double totalFacturaBMonotributistaNegativos = 0.0;
		double totalFacturaBMonotributista = 0.0;
		double totalFacturaBExentosNoAlcanzadosPositivos = 0.0;
		double totalFacturaBExentosNoAlcanzadosNegativos = 0.0;
		double totalFacturaBExentosNoAlcanzados = 0.0;
		double totalFacturaBPositivos = 0.0;
		double totalFacturaBNegativos = 0.0;
		double totalFacturaB = 0.0;
		double totalFacturaZ_A_Positivos = 0.0;
		double totalFacturaZ_A_Negativos = 0.0;
		double totalFacturaZ_A = 0.0;
		double totalFacturaZ_B_Positivos = 0.0;
		double totalFacturaZ_B_Negativos = 0.0;
		double totalFacturaZ_B = 0.0;
		double totalFacturaZPositivos = 0.0;
		double totalFacturaZNegativos = 0.0;
		double totalFacturaZ = 0.0;
		double totalFacturaAPositivosFacturaZ_A_Positivos = 0.0;
		double totalFacturaANegativosFacturaZ_A_Negativos = 0.0;
		double totalFacturaAFacturaZ_A = 0.0;
		double totalFacturaBPositivosFacturaZ_B_Positivos = 0.0;
		double totalFacturaBNegativosFacturaZ_B_Negativos = 0.0;
		double totalFacturaBFacturaZ_B = 0.0;
		double totalFacturaZ_A_Positivos_Monotributistas = 0.0;
		double totalFacturaZ_B_Positivos_Monotributistas = 0.0;
		double totalFacturaZ_B_Positivos_ConsumidoresFinales = 0.0;
		double totalFacturaZ_A_Positivos_ExentosNoAlcanzados = 0.0;
		double totalFacturaZ_B_Positivos_ExentosNoAlcanzados = 0.0;
		double totalFacturaZ_A_Positivos_ResponsableInscripto = 0.0;

		double totalFacturaZ_A_Negativos_Monotributistas = 0.0;
		double totalFacturaZ_A_Negativos_ResponsableInscripto = 0.0;
		double totalFacturaZ_A_Negativos_ExentosNoAlcanzados = 0.0;
		double totalFacturaZ_B_Negativos_Monotributistas = 0.0;
		double totalFacturaZ_B_Negativos_ExentosNoAlcanzados = 0.0;
		double totalFacturaZ_B_Negativos_ConsumidoresFinales = 0.0;

		// Declaraciones Total Iva
		double totalFacturaAResponsableInscriptoPositivosIva = 0.0;
		double totalFacturaAResponsableInscriptoNegativosIva = 0.0;
		double totalFacturaAResponsableInscriptoIva = 0.0;
		double totalFacturaAExentosNoAlcanzadosPositivosIva = 0.0;
		double totalFacturaAExentosNoAlcanzadosNegativosIva = 0.0;
		double totalFacturaAExentosNoAlcanzadosIva = 0.0;
		double totalFacturaAMonotributistaPositivosIva = 0.0;
		double totalFacturaAMonotributistaNegativosIva = 0.0;
		double totalFacturaAMonotributistaIva = 0.0;
		double totalFacturaAPositivosIva = 0.0;
		double totalFacturaANegativosIva = 0.0;
		double totalFacturaAIva = 0.0;
		double totalFacturaBConsumidorFinalPositivosIva = 0.0;
		double totalFacturaBConsumidorFinalNegativosIva = 0.0;
		double totalFacturaBConsumidorFinalIva = 0.0;
		double totalFacturaBMonotributistaPositivosIva = 0.0;
		double totalFacturaBMonotributistaNegativosIva = 0.0;
		double totalFacturaBMonotributistaIva = 0.0;
		double totalFacturaBExentosNoAlcanzadosPositivosIva = 0.0;
		double totalFacturaBExentosNoAlcanzadosNegativosIva = 0.0;
		double totalFacturaBExentosNoAlcanzadosIva = 0.0;
		double totalFacturaBPositivosIva = 0.0;
		double totalFacturaBNegativosIva = 0.0;
		double totalFacturaBIva = 0.0;
		double totalFacturaZ_A_PositivosIva = 0.0;
		double totalFacturaZ_A_NegativosIva = 0.0;
		double totalFacturaZ_A_Iva = 0.0;
		double totalFacturaZ_B_PositivosIva = 0.0;
		double totalFacturaZ_B_NegativosIva = 0.0;
		double totalFacturaZ_B_Iva = 0.0;
		double totalFacturaZPositivosIva = 0.0;
		double totalFacturaZNegativosIva = 0.0;
		double totalFacturaZIva = 0.0;
		double totalFacturaAPositivosFacturaZ_A_PositivosIva = 0.0;
		double totalFacturaANegativosFacturaZ_A_NegativosIva = 0.0;
		double totalFacturaAFacturaZ_AIva = 0.0;
		double totalFacturaBPositivosFacturaZ_B_PositivosIva = 0.0;
		double totalFacturaBNegativosFacturaZ_B_NegativosIva = 0.0;
		double totalFacturaBFacturaZ_BIva = 0.0;
		double totalFacturaZ_A_Positivos_MonotributistasIva = 0.0;
		double totalFacturaZ_B_Positivos_MonotributistasIva = 0.0;
		double totalFacturaZ_B_Positivos_ConsumidoresFinalesIva = 0.0;
		double totalFacturaZ_A_Positivos_ExentosNoAlcanzadosIva = 0.0;
		double totalFacturaZ_B_Positivos_ExentosNoAlcanzadosIva = 0.0;
		double totalFacturaZ_A_Positivos_ResponsableInscriptoIva = 0.0;

		double totalFacturaZ_A_Negativos_MonotributistasIva = 0.0;
		double totalFacturaZ_A_Negativos_ResponsableInscriptoIva = 0.0;
		double totalFacturaZ_A_Negativos_ExentosNoAlcanzadosIva = 0.0;
		double totalFacturaZ_B_Negativos_MonotributistasIva = 0.0;
		double totalFacturaZ_B_Negativos_ConsumidoresFinalesIva = 0.0;
		double totalFacturaZ_B_Negativos_ExentosNoAlcanzadosIva = 0.0;

		// Declaraciones Neto Gravado 21%
		double totalFacturaAResponsableInscriptoPositivos21 = 0.0;
		double totalFacturaAResponsableInscriptoNegativos21 = 0.0;
		double totalFacturaAResponsableInscripto21 = 0.0;
		double totalFacturaAExentosNoAlcanzadosPositivos21 = 0.0;
		double totalFacturaAExentosNoAlcanzadosNegativos21 = 0.0;
		double totalFacturaAExentosNoAlcanzados21 = 0.0;
		double totalFacturaAMonotributistaPositivos21 = 0.0;
		double totalFacturaAMonotributistaNegativos21 = 0.0;
		double totalFacturaAMonotributista21 = 0.0;
		double totalFacturaAPositivos21 = 0.0;
		double totalFacturaANegativos21 = 0.0;
		double totalFacturaA21 = 0.0;
		double totalFacturaBConsumidorFinalPositivos21 = 0.0;
		double totalFacturaBConsumidorFinalNegativos21 = 0.0;
		double totalFacturaBConsumidorFinal21 = 0.0;
		double totalFacturaBMonotributistaPositivos21 = 0.0;
		double totalFacturaBMonotributistaNegativos21 = 0.0;
		double totalFacturaBMonotributista21 = 0.0;
		double totalFacturaBExentosNoAlcanzadosPositivos21 = 0.0;
		double totalFacturaBExentosNoAlcanzadosNegativos21 = 0.0;
		double totalFacturaBExentosNoAlcanzados21 = 0.0;
		double totalFacturaBPositivos21 = 0.0;
		double totalFacturaBNegativos21 = 0.0;
		double totalFacturaB21 = 0.0;
		double totalFacturaZ_A_Positivos21 = 0.0;
		double totalFacturaZ_A_Negativos21 = 0.0;
		double totalFacturaZ_A21 = 0.0;
		double totalFacturaZ_B_Positivos21 = 0.0;
		double totalFacturaZ_B_Negativos21 = 0.0;
		double totalFacturaZ_B21 = 0.0;
		double totalFacturaZPositivos21 = 0.0;
		double totalFacturaZNegativos21 = 0.0;
		double totalFacturaZ21 = 0.0;
		double totalFacturaAPositivosFacturaZ_A_Positivos21 = 0.0;
		double totalFacturaANegativosFacturaZ_A_Negativos21 = 0.0;
		double totalFacturaAFacturaZ_A21 = 0.0;
		double totalFacturaBPositivosFacturaZ_B_Positivos21 = 0.0;
		double totalFacturaBNegativosFacturaZ_B_Negativos21 = 0.0;
		double totalFacturaBFacturaZ_B21 = 0.0;
		double totalFacturaZ_A_Positivos_Monotributistas21 = 0.0;
		double totalFacturaZ_B_Positivos_Monotributistas21 = 0.0;
		double totalFacturaZ_B_Positivos_ConsumidoresFinales21 = 0.0;
		double totalFacturaZ_A_Positivos_ExentosNoAlcanzados21 = 0.0;
		double totalFacturaZ_B_Positivos_ExentosNoAlcanzados21 = 0.0;
		double totalFacturaZ_A_Positivos_ResponsableInscripto21 = 0.0;

		double totalFacturaZ_A_Negativos_Monotributistas21 = 0.0;
		double totalFacturaZ_A_Negativos_ResponsableInscripto21 = 0.0;
		double totalFacturaZ_A_Negativos_ExentosNoAlcanzados21 = 0.0;
		double totalFacturaZ_B_Negativos_Monotributistas21 = 0.0;
		double totalFacturaZ_B_Negativos_ExentosNoAlcanzados21 = 0.0;
		double totalFacturaZ_B_Negativos_ConsumidoresFinales21 = 0.0;

		// Declaraciones Iva 21%
		double totalFacturaAResponsableInscriptoPositivosIva21 = 0.0;
		double totalFacturaAResponsableInscriptoNegativosIva21 = 0.0;
		double totalFacturaAResponsableInscriptoIva21 = 0.0;
		double totalFacturaAExentosNoAlcanzadosPositivosIva21 = 0.0;
		double totalFacturaAExentosNoAlcanzadosNegativosIva21 = 0.0;
		double totalFacturaAExentosNoAlcanzadosIva21 = 0.0;
		double totalFacturaAMonotributistaPositivosIva21 = 0.0;
		double totalFacturaAMonotributistaNegativosIva21 = 0.0;
		double totalFacturaAMonotributistaIva21 = 0.0;
		double totalFacturaAPositivosIva21 = 0.0;
		double totalFacturaANegativosIva21 = 0.0;
		double totalFacturaAIva21 = 0.0;
		double totalFacturaBConsumidorFinalPositivosIva21 = 0.0;
		double totalFacturaBConsumidorFinalNegativosIva21 = 0.0;
		double totalFacturaBConsumidorFinalIva21 = 0.0;
		double totalFacturaBMonotributistaPositivosIva21 = 0.0;
		double totalFacturaBMonotributistaNegativosIva21 = 0.0;
		double totalFacturaBMonotributistaIva21 = 0.0;
		double totalFacturaBExentosNoAlcanzadosPositivosIva21 = 0.0;
		double totalFacturaBExentosNoAlcanzadosNegativosIva21 = 0.0;
		double totalFacturaBExentosNoAlcanzadosIva21 = 0.0;
		double totalFacturaBPositivosIva21 = 0.0;
		double totalFacturaBNegativosIva21 = 0.0;
		double totalFacturaBIva21 = 0.0;
		double totalFacturaZ_A_PositivosIva21 = 0.0;
		double totalFacturaZ_A_NegativosIva21 = 0.0;
		double totalFacturaZ_A_Iva21 = 0.0;
		double totalFacturaZ_B_PositivosIva21 = 0.0;
		double totalFacturaZ_B_NegativosIva21 = 0.0;
		double totalFacturaZ_B_Iva21 = 0.0;
		double totalFacturaZPositivosIva21 = 0.0;
		double totalFacturaZNegativosIva21 = 0.0;
		double totalFacturaZIva21 = 0.0;
		double totalFacturaAPositivosFacturaZ_A_PositivosIva21 = 0.0;
		double totalFacturaANegativosFacturaZ_A_NegativosIva21 = 0.0;
		double totalFacturaAFacturaZ_AIva21 = 0.0;
		double totalFacturaBPositivosFacturaZ_B_PositivosIva21 = 0.0;
		double totalFacturaBNegativosFacturaZ_B_NegativosIva21 = 0.0;
		double totalFacturaBFacturaZ_BIva21 = 0.0;
		double totalFacturaZ_A_Positivos_MonotributistasIva21 = 0.0;
		double totalFacturaZ_B_Positivos_MonotributistasIva21 = 0.0;
		double totalFacturaZ_B_Positivos_ConsumidoresFinalesIva21 = 0.0;
		double totalFacturaZ_A_Positivos_ExentosNoAlcanzadosIva21 = 0.0;
		double totalFacturaZ_B_Positivos_ExentosNoAlcanzadosIva21 = 0.0;
		double totalFacturaZ_A_Positivos_ResponsableInscriptoIva21 = 0.0;

		double totalFacturaZ_A_Negativos_MonotributistasIva21 = 0.0;
		double totalFacturaZ_A_Negativos_ResponsableInscriptoIva21 = 0.0;
		double totalFacturaZ_A_Negativos_ExentosNoAlcanzadosIva21 = 0.0;
		double totalFacturaZ_B_Negativos_MonotributistasIva21 = 0.0;
		double totalFacturaZ_B_Negativos_ExentosNoAlcanzadosIva21 = 0.0;
		double totalFacturaZ_B_Negativos_ConsumidoresFinalesIva21 = 0.0;

		// Declaraciones Neto Gravado 10,5%
		double totalFacturaAResponsableInscriptoPositivos10_5 = 0.0;
		double totalFacturaAResponsableInscriptoNegativos10_5 = 0.0;
		double totalFacturaAResponsableInscripto10_5 = 0.0;
		double totalFacturaAExentosNoAlcanzadosPositivos10_5 = 0.0;
		double totalFacturaAExentosNoAlcanzadosNegativos10_5 = 0.0;
		double totalFacturaAExentosNoAlcanzados10_5 = 0.0;
		double totalFacturaAMonotributistaPositivos10_5 = 0.0;
		double totalFacturaAMonotributistaNegativos10_5 = 0.0;
		double totalFacturaAMonotributista10_5 = 0.0;
		double totalFacturaAPositivos10_5 = 0.0;
		double totalFacturaANegativos10_5 = 0.0;
		double totalFacturaA10_5 = 0.0;
		double totalFacturaBConsumidorFinalPositivos10_5 = 0.0;
		double totalFacturaBConsumidorFinalNegativos10_5 = 0.0;
		double totalFacturaBConsumidorFinal10_5 = 0.0;
		double totalFacturaBMonotributistaPositivos10_5 = 0.0;
		double totalFacturaBMonotributistaNegativos10_5 = 0.0;
		double totalFacturaBMonotributista10_5 = 0.0;
		double totalFacturaBExentosNoAlcanzadosPositivos10_5 = 0.0;
		double totalFacturaBExentosNoAlcanzadosNegativos10_5 = 0.0;
		double totalFacturaBExentosNoAlcanzados10_5 = 0.0;
		double totalFacturaBPositivos10_5 = 0.0;
		double totalFacturaBNegativos10_5 = 0.0;
		double totalFacturaB10_5 = 0.0;
		double totalFacturaZ_A_Positivos10_5 = 0.0;
		double totalFacturaZ_A_Negativos10_5 = 0.0;
		double totalFacturaZ_A10_5 = 0.0;
		double totalFacturaZ_B_Positivos10_5 = 0.0;
		double totalFacturaZ_B_Negativos10_5 = 0.0;
		double totalFacturaZ_B10_5 = 0.0;
		double totalFacturaZPositivos10_5 = 0.0;
		double totalFacturaZNegativos10_5 = 0.0;
		double totalFacturaZ10_5 = 0.0;
		double totalFacturaAPositivosFacturaZ_A_Positivos10_5 = 0.0;
		double totalFacturaANegativosFacturaZ_A_Negativos10_5 = 0.0;
		double totalFacturaAFacturaZ_A10_5 = 0.0;
		double totalFacturaBPositivosFacturaZ_B_Positivos10_5 = 0.0;
		double totalFacturaBNegativosFacturaZ_B_Negativos10_5 = 0.0;
		double totalFacturaBFacturaZ_B10_5 = 0.0;
		double totalFacturaZ_A_Positivos_Monotributistas10_5 = 0.0;
		double totalFacturaZ_B_Positivos_Monotributistas10_5 = 0.0;
		double totalFacturaZ_B_Positivos_ConsumidoresFinales10_5 = 0.0;
		double totalFacturaZ_A_Positivos_ExentosNoAlcanzados10_5 = 0.0;
		double totalFacturaZ_B_Positivos_ExentosNoAlcanzados10_5 = 0.0;
		double totalFacturaZ_A_Positivos_ResponsableInscripto10_5 = 0.0;

		double totalFacturaZ_A_Negativos_Monotributistas10_5 = 0.0;
		double totalFacturaZ_A_Negativos_ResponsableInscripto10_5 = 0.0;
		double totalFacturaZ_A_Negativos_ExentosNoAlcanzados10_5 = 0.0;
		double totalFacturaZ_B_Negativos_Monotributistas10_5 = 0.0;
		double totalFacturaZ_B_Negativos_ExentosNoAlcanzados10_5 = 0.0;
		double totalFacturaZ_B_Negativos_ConsumidoresFinales10_5 = 0.0;

		// Declaraciones Iva 10,5%
		double totalFacturaAResponsableInscriptoPositivosIva10_5 = 0.0;
		double totalFacturaAResponsableInscriptoNegativosIva10_5 = 0.0;
		double totalFacturaAResponsableInscriptoIva10_5 = 0.0;
		double totalFacturaAExentosNoAlcanzadosPositivosIva10_5 = 0.0;
		double totalFacturaAExentosNoAlcanzadosNegativosIva10_5 = 0.0;
		double totalFacturaAExentosNoAlcanzadosIva10_5 = 0.0;
		double totalFacturaAMonotributistaPositivosIva10_5 = 0.0;
		double totalFacturaAMonotributistaNegativosIva10_5 = 0.0;
		double totalFacturaAMonotributistaIva10_5 = 0.0;
		double totalFacturaAPositivosIva10_5 = 0.0;
		double totalFacturaANegativosIva10_5 = 0.0;
		double totalFacturaAIva10_5 = 0.0;
		double totalFacturaBConsumidorFinalPositivosIva10_5 = 0.0;
		double totalFacturaBConsumidorFinalNegativosIva10_5 = 0.0;
		double totalFacturaBConsumidorFinalIva10_5 = 0.0;
		double totalFacturaBMonotributistaPositivosIva10_5 = 0.0;
		double totalFacturaBMonotributistaNegativosIva10_5 = 0.0;
		double totalFacturaBMonotributistaIva10_5 = 0.0;
		double totalFacturaBExentosNoAlcanzadosPositivosIva10_5 = 0.0;
		double totalFacturaBExentosNoAlcanzadosNegativosIva10_5 = 0.0;
		double totalFacturaBExentosNoAlcanzadosIva10_5 = 0.0;
		double totalFacturaBPositivosIva10_5 = 0.0;
		double totalFacturaBNegativosIva10_5 = 0.0;
		double totalFacturaBIva10_5 = 0.0;
		double totalFacturaZ_A_PositivosIva10_5 = 0.0;
		double totalFacturaZ_A_NegativosIva10_5 = 0.0;
		double totalFacturaZ_A_Iva10_5 = 0.0;
		double totalFacturaZ_B_PositivosIva10_5 = 0.0;
		double totalFacturaZ_B_NegativosIva10_5 = 0.0;
		double totalFacturaZ_B_Iva10_5 = 0.0;
		double totalFacturaZPositivosIva10_5 = 0.0;
		double totalFacturaZNegativosIva10_5 = 0.0;
		double totalFacturaZIva10_5 = 0.0;
		double totalFacturaAPositivosFacturaZ_A_PositivosIva10_5 = 0.0;
		double totalFacturaANegativosFacturaZ_A_NegativosIva10_5 = 0.0;
		double totalFacturaAFacturaZ_AIva10_5 = 0.0;
		double totalFacturaBPositivosFacturaZ_B_PositivosIva10_5 = 0.0;
		double totalFacturaBNegativosFacturaZ_B_NegativosIva10_5 = 0.0;
		double totalFacturaBFacturaZ_BIva10_5 = 0.0;
		double totalFacturaZ_A_Positivos_MonotributistasIva10_5 = 0.0;
		double totalFacturaZ_B_Positivos_MonotributistasIva10_5 = 0.0;
		double totalFacturaZ_B_Positivos_ConsumidoresFinalesIva10_5 = 0.0;
		double totalFacturaZ_A_Positivos_ExentosNoAlcanzadosIva10_5 = 0.0;
		double totalFacturaZ_B_Positivos_ExentosNoAlcanzadosIva10_5 = 0.0;
		double totalFacturaZ_A_Positivos_ResponsableInscriptoIva10_5 = 0.0;

		double totalFacturaZ_A_Negativos_MonotributistasIva10_5 = 0.0;
		double totalFacturaZ_A_Negativos_ResponsableInscriptoIva10_5 = 0.0;
		double totalFacturaZ_A_Negativos_ExentosNoAlcanzadosIva10_5 = 0.0;
		double totalFacturaZ_B_Negativos_MonotributistasIva10_5 = 0.0;
		double totalFacturaZ_B_Negativos_ExentosNoAlcanzadosIva10_5 = 0.0;
		double totalFacturaZ_B_Negativos_ConsumidoresFinalesIva10_5 = 0.0;

		// Declaraciones Neto Gravado 27%
		double totalFacturaAResponsableInscriptoPositivos27 = 0.0;
		double totalFacturaAResponsableInscriptoNegativos27 = 0.0;
		double totalFacturaAResponsableInscripto27 = 0.0;
		double totalFacturaAExentosNoAlcanzadosPositivos27 = 0.0;
		double totalFacturaAExentosNoAlcanzadosNegativos27 = 0.0;
		double totalFacturaAExentosNoAlcanzados27 = 0.0;
		double totalFacturaAMonotributistaPositivos27 = 0.0;
		double totalFacturaAMonotributistaNegativos27 = 0.0;
		double totalFacturaAMonotributista27 = 0.0;
		double totalFacturaAPositivos27 = 0.0;
		double totalFacturaANegativos27 = 0.0;
		double totalFacturaA27 = 0.0;
		double totalFacturaBConsumidorFinalPositivos27 = 0.0;
		double totalFacturaBConsumidorFinalNegativos27 = 0.0;
		double totalFacturaBConsumidorFinal27 = 0.0;
		double totalFacturaBMonotributistaPositivos27 = 0.0;
		double totalFacturaBMonotributistaNegativos27 = 0.0;
		double totalFacturaBMonotributista27 = 0.0;
		double totalFacturaBExentosNoAlcanzadosPositivos27 = 0.0;
		double totalFacturaBExentosNoAlcanzadosNegativos27 = 0.0;
		double totalFacturaBExentosNoAlcanzados27 = 0.0;
		double totalFacturaBPositivos27 = 0.0;
		double totalFacturaBNegativos27 = 0.0;
		double totalFacturaB27 = 0.0;
		double totalFacturaZ_A_Positivos27 = 0.0;
		double totalFacturaZ_A_Negativos27 = 0.0;
		double totalFacturaZ_A27 = 0.0;
		double totalFacturaZ_B_Positivos27 = 0.0;
		double totalFacturaZ_B_Negativos27 = 0.0;
		double totalFacturaZ_B27 = 0.0;
		double totalFacturaZPositivos27 = 0.0;
		double totalFacturaZNegativos27 = 0.0;
		double totalFacturaZ27 = 0.0;
		double totalFacturaAPositivosFacturaZ_A_Positivos27 = 0.0;
		double totalFacturaANegativosFacturaZ_A_Negativos27 = 0.0;
		double totalFacturaAFacturaZ_A27 = 0.0;
		double totalFacturaBPositivosFacturaZ_B_Positivos27 = 0.0;
		double totalFacturaBNegativosFacturaZ_B_Negativos27 = 0.0;
		double totalFacturaBFacturaZ_B27 = 0.0;
		double totalFacturaZ_A_Positivos_Monotributistas27 = 0.0;
		double totalFacturaZ_B_Positivos_Monotributistas27 = 0.0;
		double totalFacturaZ_B_Positivos_ConsumidoresFinales27 = 0.0;
		double totalFacturaZ_A_Positivos_ExentosNoAlcanzados27 = 0.0;
		double totalFacturaZ_B_Positivos_ExentosNoAlcanzados27 = 0.0;
		double totalFacturaZ_A_Positivos_ResponsableInscripto27 = 0.0;

		double totalFacturaZ_A_Negativos_Monotributistas27 = 0.0;
		double totalFacturaZ_A_Negativos_ResponsableInscripto27 = 0.0;
		double totalFacturaZ_A_Negativos_ExentosNoAlcanzados27 = 0.0;
		double totalFacturaZ_B_Negativos_Monotributistas27 = 0.0;
		double totalFacturaZ_B_Negativos_ExentosNoAlcanzados27 = 0.0;
		double totalFacturaZ_B_Negativos_ConsumidoresFinales27 = 0.0;

		// Declaraciones Iva 27%
		double totalFacturaAResponsableInscriptoPositivosIva27 = 0.0;
		double totalFacturaAResponsableInscriptoNegativosIva27 = 0.0;
		double totalFacturaAResponsableInscriptoIva27 = 0.0;
		double totalFacturaAExentosNoAlcanzadosPositivosIva27 = 0.0;
		double totalFacturaAExentosNoAlcanzadosNegativosIva27 = 0.0;
		double totalFacturaAExentosNoAlcanzadosIva27 = 0.0;
		double totalFacturaAMonotributistaPositivosIva27 = 0.0;
		double totalFacturaAMonotributistaNegativosIva27 = 0.0;
		double totalFacturaAMonotributistaIva27 = 0.0;
		double totalFacturaAPositivosIva27 = 0.0;
		double totalFacturaANegativosIva27 = 0.0;
		double totalFacturaAIva27 = 0.0;
		double totalFacturaBConsumidorFinalPositivosIva27 = 0.0;
		double totalFacturaBConsumidorFinalNegativosIva27 = 0.0;
		double totalFacturaBConsumidorFinalIva27 = 0.0;
		double totalFacturaBMonotributistaPositivosIva27 = 0.0;
		double totalFacturaBMonotributistaNegativosIva27 = 0.0;
		double totalFacturaBMonotributistaIva27 = 0.0;
		double totalFacturaBExentosNoAlcanzadosPositivosIva27 = 0.0;
		double totalFacturaBExentosNoAlcanzadosNegativosIva27 = 0.0;
		double totalFacturaBExentosNoAlcanzadosIva27 = 0.0;
		double totalFacturaBPositivosIva27 = 0.0;
		double totalFacturaBNegativosIva27 = 0.0;
		double totalFacturaBIva27 = 0.0;
		double totalFacturaZ_A_PositivosIva27 = 0.0;
		double totalFacturaZ_A_NegativosIva27 = 0.0;
		double totalFacturaZ_A_Iva27 = 0.0;
		double totalFacturaZ_B_PositivosIva27 = 0.0;
		double totalFacturaZ_B_NegativosIva27 = 0.0;
		double totalFacturaZ_B_Iva27 = 0.0;
		double totalFacturaZPositivosIva27 = 0.0;
		double totalFacturaZNegativosIva27 = 0.0;
		double totalFacturaZIva27 = 0.0;
		double totalFacturaAPositivosFacturaZ_A_PositivosIva27 = 0.0;
		double totalFacturaANegativosFacturaZ_A_NegativosIva27 = 0.0;
		double totalFacturaAFacturaZ_AIva27 = 0.0;
		double totalFacturaBPositivosFacturaZ_B_PositivosIva27 = 0.0;
		double totalFacturaBNegativosFacturaZ_B_NegativosIva27 = 0.0;
		double totalFacturaBFacturaZ_BIva27 = 0.0;
		double totalFacturaZ_A_Positivos_MonotributistasIva27 = 0.0;
		double totalFacturaZ_B_Positivos_MonotributistasIva27 = 0.0;
		double totalFacturaZ_B_Positivos_ConsumidoresFinalesIva27 = 0.0;
		double totalFacturaZ_A_Positivos_ExentosNoAlcanzadosIva27 = 0.0;
		double totalFacturaZ_B_Positivos_ExentosNoAlcanzadosIva27 = 0.0;
		double totalFacturaZ_A_Positivos_ResponsableInscriptoIva27 = 0.0;

		double totalFacturaZ_A_Negativos_MonotributistasIva27 = 0.0;
		double totalFacturaZ_A_Negativos_ResponsableInscriptoIva27 = 0.0;
		double totalFacturaZ_A_Negativos_ExentosNoAlcanzadosIva27 = 0.0;
		double totalFacturaZ_B_Negativos_MonotributistasIva27 = 0.0;
		double totalFacturaZ_B_Negativos_ExentosNoAlcanzadosIva27 = 0.0;
		double totalFacturaZ_B_Negativos_ConsumidoresFinalesIva27 = 0.0;

		Iterator<Row> rowIterator = rows.iterator();
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			Cell totalNetoGravadoCell = row.getCell(28);
			Cell totalNetoGravado21Cell = row.getCell(12);
			Cell totalNetoGravado10_5Cell = row.getCell(13);
			Cell totalNetoGravado27Cell = row.getCell(14);
			Cell totalIva21Cell = row.getCell(17);
			Cell totalIva10_5Cell = row.getCell(18);
			Cell totalIva27Cell = row.getCell(19);
			Cell letraCell = row.getCell(3);
			Cell numeroClienteCell = row.getCell(10);
			Cell razonSocialCell = row.getCell(8);
			Cell tipoDocumentoCell = row.getCell(9);
			Cell totalIvaCell = row.getCell(29);
			Cell codigoIvaCell = row.getCell(11);
			Cell exentoCell = row.getCell(22);
			Cell nroComprobanteCell = row.getCell(5);
			boolean requiereRevision = false;

			if (totalNetoGravadoCell != null) {
				double totalNetoGravado;
				double totalIva;
				double totalNetoGravado21;
				double totalNetoGravado10_5;
				double totalNetoGravado27;
				double totalIva21;
				double totalIva10_5;
				double totalIva27;
				double nroComprobante;

				try {
					if (nroComprobanteCell.getCellType() == CellType.NUMERIC) {
						nroComprobante = nroComprobanteCell.getNumericCellValue();
					} else if (nroComprobanteCell.getCellType() == CellType.STRING) {
						nroComprobante = Double.parseDouble(nroComprobanteCell.getStringCellValue().replace(",", ""));
					} else {
						System.out.println("La celda no contiene un valor numérico: " + totalNetoGravadoCell);
						continue;
					}
					if (totalNetoGravadoCell.getCellType() == CellType.NUMERIC) {
						totalNetoGravado = totalNetoGravadoCell.getNumericCellValue();
					} else if (totalNetoGravadoCell.getCellType() == CellType.STRING) {
						totalNetoGravado = Double
								.parseDouble(totalNetoGravadoCell.getStringCellValue().replace(",", ""));
					} else {
						System.out.println("La celda no contiene un valor numérico: " + totalNetoGravadoCell);
						continue;
					}
					if (totalIvaCell.getCellType() == CellType.NUMERIC) {
						totalIva = totalIvaCell.getNumericCellValue();
					} else if (totalIvaCell.getCellType() == CellType.STRING) {
						totalIva = Double.parseDouble(totalIvaCell.getStringCellValue().replace(",", ""));
					} else {
						System.out.println("La celda no contiene un valor numérico: " + totalIvaCell);
						continue;
					}
					if (totalNetoGravado21Cell.getCellType() == CellType.NUMERIC) {
						totalNetoGravado21 = totalNetoGravado21Cell.getNumericCellValue();
					} else if (totalNetoGravado21Cell.getCellType() == CellType.STRING) {
						totalNetoGravado21 = Double
								.parseDouble(totalNetoGravado21Cell.getStringCellValue().replace(",", ""));
					} else {
						System.out.println("La celda no contiene un valor numérico: " + totalNetoGravado21Cell);
						continue;
					}
					if (totalIva21Cell.getCellType() == CellType.NUMERIC) {
						totalIva21 = totalIva21Cell.getNumericCellValue();
					} else if (totalIva21Cell.getCellType() == CellType.STRING) {
						totalIva21 = Double.parseDouble(totalIva21Cell.getStringCellValue().replace(",", ""));
					} else {
						System.out.println("La celda no contiene un valor numérico: " + totalIva21Cell);
						continue;
					}
					if (totalNetoGravado10_5Cell.getCellType() == CellType.NUMERIC) {
						totalNetoGravado10_5 = totalNetoGravado10_5Cell.getNumericCellValue();
					} else if (totalNetoGravado10_5Cell.getCellType() == CellType.STRING) {
						totalNetoGravado10_5 = Double
								.parseDouble(totalNetoGravado10_5Cell.getStringCellValue().replace(",", ""));
					} else {
						System.out.println("La celda no contiene un valor numérico: " + totalNetoGravado10_5Cell);
						continue;
					}
					if (totalIva10_5Cell.getCellType() == CellType.NUMERIC) {
						totalIva10_5 = totalIva10_5Cell.getNumericCellValue();
					} else if (totalIva10_5Cell.getCellType() == CellType.STRING) {
						totalIva10_5 = Double.parseDouble(totalIva10_5Cell.getStringCellValue().replace(",", ""));
					} else {
						System.out.println("La celda no contiene un valor numérico: " + totalIva10_5Cell);
						continue;
					}

					if (totalNetoGravado27Cell.getCellType() == CellType.NUMERIC) {
						totalNetoGravado27 = totalNetoGravado27Cell.getNumericCellValue();
					} else if (totalNetoGravado27Cell.getCellType() == CellType.STRING) {
						totalNetoGravado27 = Double
								.parseDouble(totalNetoGravado27Cell.getStringCellValue().replace(",", ""));
					} else {
						System.out.println("La celda no contiene un valor numérico: " + totalNetoGravado27Cell);
						continue;
					}
					if (totalIva27Cell.getCellType() == CellType.NUMERIC) {
						totalIva27 = totalIva27Cell.getNumericCellValue();
					} else if (totalIva27Cell.getCellType() == CellType.STRING) {
						totalIva27 = Double.parseDouble(totalIva27Cell.getStringCellValue().replace(",", ""));
					} else {
						System.out.println("La celda no contiene un valor numérico: " + totalIva27Cell);
						continue;
					}

				} catch (NumberFormatException e) {
					System.out.println("Error al convertir el valor: " + totalNetoGravadoCell);
					continue;
				}

				String formattedTotalNetoGravado = String.format("%.2f", totalNetoGravado);
				String formattedTotalIva = String.format("%.2f", totalIva);
				String formattednroComprobante = String.format("%.0f", nroComprobante);
				if (letraCell != null && letraCell.getCellType() == CellType.STRING) {
					String letra = letraCell.getStringCellValue();
					String numeroCliente = numeroClienteCell != null
							&& numeroClienteCell.getCellType() == CellType.STRING
									? numeroClienteCell.getStringCellValue()
									: "";
					String razonSocial = razonSocialCell != null && razonSocialCell.getCellType() == CellType.STRING
							? razonSocialCell.getStringCellValue()
							: "";
					String tipoDocumento = tipoDocumentoCell != null
							&& tipoDocumentoCell.getCellType() == CellType.STRING
									? tipoDocumentoCell.getStringCellValue()
									: "";
					String codigoIva = codigoIvaCell != null && codigoIvaCell.getCellType() == CellType.STRING
							? codigoIvaCell.getStringCellValue()
							: "";
					String exento = exentoCell != null && exentoCell.getCellType() == CellType.STRING
							? exentoCell.getStringCellValue()
							: "";

					if (totalNetoGravado < 0) {
						System.out.println("N° Comprobante: " + formattednroComprobante.replace(".", ",")
								+ " Nota de Crédito: " + formattedTotalNetoGravado.replace(".", ",") + " - IVA: "
								+ formattedTotalIva.replace(".", ","));
					} else {
						System.out.println("N° Comprobante: " + formattednroComprobante.replace(".", ",")
								+ " Factura Positiva: " + formattedTotalNetoGravado.replace(".", ",") + " - IVA: "
								+ formattedTotalIva.replace(".", ","));
					}

					// Aquí debes incluir todo el bloque de lógica que ya tenías
					// ...

					if (letra.equalsIgnoreCase("A")) {
						if (numeroCliente.startsWith("2")) {
							System.out.println("Factura " + letra + " - Monotributista: "
									+ formattedTotalNetoGravado.replace(".", ",") + " - IVA: "
									+ formattedTotalIva.replace(".", ",") + "\n");
							if (totalNetoGravado > 0) {
								totalFacturaAMonotributistaPositivos += totalNetoGravado;
								totalFacturaAMonotributistaPositivosIva += totalIva;
								totalFacturaAMonotributistaPositivos21 += totalNetoGravado21;
								totalFacturaAMonotributistaPositivosIva21 += totalIva21;
								totalFacturaAMonotributistaPositivos10_5 += totalNetoGravado10_5;
								totalFacturaAMonotributistaPositivosIva10_5 += totalIva10_5;
								totalFacturaAMonotributistaPositivos27 += totalNetoGravado27;
								totalFacturaAMonotributistaPositivosIva27 += totalIva27;

								totalFacturaAPositivosFacturaZ_A_Positivos += totalNetoGravado;
								totalFacturaAPositivosFacturaZ_A_PositivosIva += totalIva;
								totalFacturaAPositivosFacturaZ_A_Positivos21 += totalNetoGravado21;
								totalFacturaAPositivosFacturaZ_A_PositivosIva21 += totalIva21;
								totalFacturaAPositivosFacturaZ_A_Positivos10_5 += totalNetoGravado10_5;
								totalFacturaAPositivosFacturaZ_A_PositivosIva10_5 += totalIva10_5;
								totalFacturaAPositivosFacturaZ_A_Positivos27 += totalNetoGravado27;
								totalFacturaAPositivosFacturaZ_A_PositivosIva27 += totalIva27;

							} else if (totalNetoGravado < 0) {
								totalFacturaAMonotributistaNegativos += totalNetoGravado;
								totalFacturaAMonotributistaNegativosIva += totalIva;
								totalFacturaAMonotributistaNegativos21 += totalNetoGravado21;
								totalFacturaAMonotributistaNegativosIva21 += totalIva21;
								totalFacturaAMonotributistaNegativos10_5 += totalNetoGravado10_5;
								totalFacturaAMonotributistaNegativosIva10_5 += totalIva10_5;
								totalFacturaAMonotributistaNegativos27 += totalNetoGravado27;
								totalFacturaAMonotributistaNegativosIva27 += totalIva27;

								totalFacturaANegativosFacturaZ_A_Negativos += totalNetoGravado;
								totalFacturaANegativosFacturaZ_A_NegativosIva += totalIva;
								totalFacturaANegativosFacturaZ_A_Negativos21 += totalNetoGravado21;
								totalFacturaANegativosFacturaZ_A_NegativosIva21 += totalIva21;
								totalFacturaANegativosFacturaZ_A_Negativos10_5 += totalNetoGravado10_5;
								totalFacturaANegativosFacturaZ_A_NegativosIva10_5 += totalIva10_5;
								totalFacturaANegativosFacturaZ_A_Negativos27 += totalNetoGravado27;
								totalFacturaANegativosFacturaZ_A_NegativosIva27 += totalIva27;

							}
							totalFacturaAMonotributista += totalNetoGravado;
							totalFacturaAMonotributistaIva += totalIva;
							totalFacturaAMonotributista21 += totalNetoGravado21;
							totalFacturaAMonotributistaIva21 += totalIva21;
							totalFacturaAMonotributista10_5 += totalNetoGravado10_5;
							totalFacturaAMonotributistaIva10_5 += totalIva10_5;
							totalFacturaAMonotributista27 += totalNetoGravado27;
							totalFacturaAMonotributistaIva27 += totalIva27;
						} else if (numeroCliente.startsWith("3") || codigoIva.equalsIgnoreCase("RI")) {
							System.out.println("Factura " + letra + " - Responsable Inscripto (RI): "
									+ formattedTotalNetoGravado.replace(".", ",") + " - IVA: "
									+ formattedTotalIva.replace(".", ",") + "\n");
							if (totalNetoGravado > 0) {
								totalFacturaAResponsableInscriptoPositivos += totalNetoGravado;
								totalFacturaAResponsableInscriptoPositivosIva += totalIva;
								totalFacturaAResponsableInscriptoPositivos21 += totalNetoGravado21;
								totalFacturaAResponsableInscriptoPositivosIva21 += totalIva21;
								totalFacturaAResponsableInscriptoPositivos10_5 += totalNetoGravado10_5;
								totalFacturaAResponsableInscriptoPositivosIva10_5 += totalIva10_5;
								totalFacturaAResponsableInscriptoPositivos27 += totalNetoGravado27;
								totalFacturaAResponsableInscriptoPositivosIva27 += totalIva27;

								totalFacturaAPositivosFacturaZ_A_Positivos += totalNetoGravado;
								totalFacturaAPositivosFacturaZ_A_PositivosIva += totalIva;
								totalFacturaAPositivosFacturaZ_A_Positivos21 += totalNetoGravado21;
								totalFacturaAPositivosFacturaZ_A_PositivosIva21 += totalIva21;
								totalFacturaAPositivosFacturaZ_A_Positivos10_5 += totalNetoGravado10_5;
								totalFacturaAPositivosFacturaZ_A_PositivosIva10_5 += totalIva10_5;
								totalFacturaAPositivosFacturaZ_A_Positivos27 += totalNetoGravado27;
								totalFacturaAPositivosFacturaZ_A_PositivosIva27 += totalIva27;

							} else if (totalNetoGravado < 0) {
								totalFacturaAResponsableInscriptoNegativos += totalNetoGravado;
								totalFacturaAResponsableInscriptoNegativosIva += totalIva;
								totalFacturaAResponsableInscriptoNegativos21 += totalNetoGravado21;
								totalFacturaAResponsableInscriptoNegativosIva21 += totalIva21;
								totalFacturaAResponsableInscriptoNegativos10_5 += totalNetoGravado10_5;
								totalFacturaAResponsableInscriptoNegativosIva10_5 += totalIva10_5;
								totalFacturaAResponsableInscriptoNegativos27 += totalNetoGravado27;
								totalFacturaAResponsableInscriptoNegativosIva27 += totalIva27;

								totalFacturaANegativosFacturaZ_A_Negativos += totalNetoGravado;
								totalFacturaANegativosFacturaZ_A_NegativosIva += totalIva;
								totalFacturaANegativosFacturaZ_A_Negativos21 += totalNetoGravado21;
								totalFacturaANegativosFacturaZ_A_NegativosIva21 += totalIva21;
								totalFacturaANegativosFacturaZ_A_Negativos10_5 += totalNetoGravado10_5;
								totalFacturaANegativosFacturaZ_A_NegativosIva10_5 += totalIva10_5;
								totalFacturaANegativosFacturaZ_A_Negativos27 += totalNetoGravado27;
								totalFacturaANegativosFacturaZ_A_NegativosIva27 += totalIva27;

							}
							totalFacturaAResponsableInscripto += totalNetoGravado;
							totalFacturaAResponsableInscriptoIva += totalIva;
							totalFacturaAResponsableInscripto21 += totalNetoGravado21;
							totalFacturaAResponsableInscriptoIva21 += totalIva21;
							totalFacturaAResponsableInscripto10_5 += totalNetoGravado10_5;
							totalFacturaAResponsableInscriptoIva10_5 += totalIva10_5;
							totalFacturaAResponsableInscripto27 += totalNetoGravado27;
							totalFacturaAResponsableInscriptoIva27 += totalIva27;
						} else if (codigoIva.equalsIgnoreCase("NCA") || exento.startsWith("0") != false) {
							System.out.println("Factura " + letra + " - Exentos, no Alcanzados, no Gravados: "
									+ formattedTotalNetoGravado.replace(".", ",") + " - IVA: "
									+ formattedTotalIva.replace(".", ",") + "\n");
							if (totalNetoGravado > 0) {
								totalFacturaAExentosNoAlcanzadosPositivos += totalNetoGravado;
								totalFacturaAExentosNoAlcanzadosPositivosIva += totalIva;
								totalFacturaAExentosNoAlcanzadosPositivos21 += totalNetoGravado21;
								totalFacturaAExentosNoAlcanzadosPositivosIva21 += totalIva21;
								totalFacturaAExentosNoAlcanzadosPositivos10_5 += totalNetoGravado10_5;
								totalFacturaAExentosNoAlcanzadosPositivosIva10_5 += totalIva10_5;
								totalFacturaAExentosNoAlcanzadosPositivos27 += totalNetoGravado27;
								totalFacturaAExentosNoAlcanzadosPositivosIva27 += totalIva27;

								totalFacturaAPositivosFacturaZ_A_Positivos += totalNetoGravado;
								totalFacturaAPositivosFacturaZ_A_PositivosIva += totalIva;
								totalFacturaAPositivosFacturaZ_A_Positivos21 += totalNetoGravado21;
								totalFacturaAPositivosFacturaZ_A_PositivosIva21 += totalIva21;
								totalFacturaAPositivosFacturaZ_A_Positivos10_5 += totalNetoGravado10_5;
								totalFacturaAPositivosFacturaZ_A_PositivosIva10_5 += totalIva10_5;
								totalFacturaAPositivosFacturaZ_A_Positivos27 += totalNetoGravado27;
								totalFacturaAPositivosFacturaZ_A_PositivosIva27 += totalIva27;

							} else if (totalNetoGravado < 0) {
								totalFacturaAExentosNoAlcanzadosNegativos += totalNetoGravado;
								totalFacturaAExentosNoAlcanzadosNegativosIva += totalIva;
								totalFacturaAExentosNoAlcanzadosNegativos21 += totalNetoGravado21;
								totalFacturaAExentosNoAlcanzadosNegativosIva21 += totalIva21;
								totalFacturaAExentosNoAlcanzadosNegativos10_5 += totalNetoGravado10_5;
								totalFacturaAExentosNoAlcanzadosNegativosIva10_5 += totalIva10_5;
								totalFacturaAExentosNoAlcanzadosNegativos27 += totalNetoGravado27;
								totalFacturaAExentosNoAlcanzadosNegativosIva27 += totalIva27;

								totalFacturaANegativosFacturaZ_A_Negativos += totalNetoGravado;
								totalFacturaANegativosFacturaZ_A_NegativosIva += totalIva;
								totalFacturaANegativosFacturaZ_A_Negativos21 += totalNetoGravado21;
								totalFacturaANegativosFacturaZ_A_NegativosIva21 += totalIva21;
								totalFacturaANegativosFacturaZ_A_Negativos10_5 += totalNetoGravado10_5;
								totalFacturaANegativosFacturaZ_A_NegativosIva10_5 += totalIva10_5;
								totalFacturaANegativosFacturaZ_A_Negativos27 += totalNetoGravado27;
								totalFacturaANegativosFacturaZ_A_NegativosIva27 += totalIva27;

							}
							totalFacturaAExentosNoAlcanzados += totalNetoGravado;
							totalFacturaAExentosNoAlcanzadosIva += totalIva;
							totalFacturaAExentosNoAlcanzados21 += totalNetoGravado21;
							totalFacturaAExentosNoAlcanzadosIva21 += totalIva21;
							totalFacturaAExentosNoAlcanzados10_5 += totalNetoGravado10_5;
							totalFacturaAExentosNoAlcanzadosIva10_5 += totalIva10_5;
							totalFacturaAExentosNoAlcanzados27 += totalNetoGravado27;
							totalFacturaAExentosNoAlcanzadosIva27 += totalIva27;
						}
						if (totalNetoGravado > 0) {
							totalFacturaAPositivos += totalNetoGravado;
							totalFacturaAPositivosIva += totalIva;
							totalFacturaAPositivos21 += totalNetoGravado21;
							totalFacturaAPositivosIva21 += totalIva21;
							totalFacturaAPositivos10_5 += totalNetoGravado10_5;
							totalFacturaAPositivosIva10_5 += totalIva10_5;
							totalFacturaAPositivos27 += totalNetoGravado27;
							totalFacturaAPositivosIva27 += totalIva27;

						} else if (totalNetoGravado < 0) {
							totalFacturaANegativos += totalNetoGravado;
							totalFacturaANegativosIva += totalIva;
							totalFacturaANegativos21 += totalNetoGravado21;
							totalFacturaANegativosIva21 += totalIva21;
							totalFacturaANegativos10_5 += totalNetoGravado10_5;
							totalFacturaANegativosIva10_5 += totalIva10_5;
							totalFacturaANegativos27 += totalNetoGravado27;
							totalFacturaANegativosIva27 += totalIva27;

						}
						totalFacturaA += totalNetoGravado;
						totalFacturaAIva += totalIva;
						totalFacturaA21 += totalNetoGravado21;
						totalFacturaAIva21 += totalIva21;
						totalFacturaA10_5 += totalNetoGravado10_5;
						totalFacturaAIva10_5 += totalIva10_5;
						totalFacturaA27 += totalNetoGravado27;
						totalFacturaAIva27 += totalIva27;

						totalFacturaAFacturaZ_A += totalNetoGravado;
						totalFacturaAFacturaZ_AIva += totalIva;
						totalFacturaAFacturaZ_A21 += totalNetoGravado21;
						totalFacturaAFacturaZ_AIva21 += totalIva21;
						totalFacturaAFacturaZ_A10_5 += totalNetoGravado10_5;
						totalFacturaAFacturaZ_AIva10_5 += totalIva10_5;
						totalFacturaAFacturaZ_A27 += totalNetoGravado27;
						totalFacturaAFacturaZ_AIva27 += totalIva27;

					} else if (letra.equalsIgnoreCase("B")) {
						if (numeroCliente.startsWith("2")) {
							System.out.println("Factura " + letra + " - Monotributista: "
									+ formattedTotalNetoGravado.replace(".", ",") + " - IVA: "
									+ formattedTotalIva.replace(".", ",") + "\n");
							if (totalNetoGravado > 0) {
								totalFacturaBMonotributistaPositivos += totalNetoGravado;
								totalFacturaBMonotributistaPositivosIva += totalIva;
								totalFacturaBMonotributistaPositivos21 += totalNetoGravado21;
								totalFacturaBMonotributistaPositivosIva21 += totalIva21;
								totalFacturaBMonotributistaPositivos10_5 += totalNetoGravado10_5;
								totalFacturaBMonotributistaPositivosIva10_5 += totalIva10_5;
								totalFacturaBMonotributistaPositivos27 += totalNetoGravado27;
								totalFacturaBMonotributistaPositivosIva27 += totalIva27;

								totalFacturaBPositivosFacturaZ_B_Positivos += totalNetoGravado;
								totalFacturaBPositivosFacturaZ_B_PositivosIva += totalIva;
								totalFacturaBPositivosFacturaZ_B_Positivos21 += totalNetoGravado21;
								totalFacturaBPositivosFacturaZ_B_PositivosIva21 += totalIva21;
								totalFacturaBPositivosFacturaZ_B_Positivos10_5 += totalNetoGravado10_5;
								totalFacturaBPositivosFacturaZ_B_PositivosIva10_5 += totalIva10_5;
								totalFacturaBPositivosFacturaZ_B_Positivos27 += totalNetoGravado27;
								totalFacturaBPositivosFacturaZ_B_PositivosIva27 += totalIva27;

							} else if (totalNetoGravado < 0) {
								totalFacturaBMonotributistaNegativos += totalNetoGravado;
								totalFacturaBMonotributistaNegativosIva += totalIva;
								totalFacturaBMonotributistaNegativos21 += totalNetoGravado21;
								totalFacturaBMonotributistaNegativosIva21 += totalIva21;
								totalFacturaBMonotributistaNegativos10_5 += totalNetoGravado10_5;
								totalFacturaBMonotributistaNegativosIva10_5 += totalIva10_5;
								totalFacturaBMonotributistaNegativos27 += totalNetoGravado27;
								totalFacturaBMonotributistaNegativosIva27 += totalIva27;

								totalFacturaBNegativosFacturaZ_B_Negativos += totalNetoGravado;
								totalFacturaBNegativosFacturaZ_B_NegativosIva += totalIva;
								totalFacturaBNegativosFacturaZ_B_Negativos21 += totalNetoGravado21;
								totalFacturaBNegativosFacturaZ_B_NegativosIva21 += totalIva21;
								totalFacturaBNegativosFacturaZ_B_Negativos10_5 += totalNetoGravado10_5;
								totalFacturaBNegativosFacturaZ_B_NegativosIva10_5 += totalIva10_5;
								totalFacturaBNegativosFacturaZ_B_Negativos27 += totalNetoGravado27;
								totalFacturaBNegativosFacturaZ_B_NegativosIva27 += totalIva27;
							}
							totalFacturaBMonotributista += totalNetoGravado;
							totalFacturaBMonotributistaIva += totalIva;
							totalFacturaBMonotributista21 += totalNetoGravado21;
							totalFacturaBMonotributistaIva21 += totalIva21;
							totalFacturaBMonotributista10_5 += totalNetoGravado10_5;
							totalFacturaBMonotributistaIva10_5 += totalIva10_5;
							totalFacturaBMonotributista27 += totalNetoGravado27;
							totalFacturaBMonotributistaIva27 += totalIva27;
						} else if (numeroCliente.startsWith("3") || codigoIva.equalsIgnoreCase("NCA")
								|| exento.startsWith("0") != false) {
							System.out.println("Factura " + letra + " - Exentos, no Alcanzados, no Gravados: "
									+ formattedTotalNetoGravado.replace(".", ",") + " - IVA: "
									+ formattedTotalIva.replace(".", ",") + "\n");
							if (totalNetoGravado > 0) {
								totalFacturaBExentosNoAlcanzadosPositivos += totalNetoGravado;
								totalFacturaBExentosNoAlcanzadosPositivosIva += totalIva;
								totalFacturaBExentosNoAlcanzadosPositivos21 += totalNetoGravado21;
								totalFacturaBExentosNoAlcanzadosPositivosIva21 += totalIva21;
								totalFacturaBExentosNoAlcanzadosPositivos10_5 += totalNetoGravado10_5;
								totalFacturaBExentosNoAlcanzadosPositivosIva10_5 += totalIva10_5;
								totalFacturaBExentosNoAlcanzadosPositivos27 += totalNetoGravado27;
								totalFacturaBExentosNoAlcanzadosPositivosIva27 += totalIva27;

								totalFacturaBPositivosFacturaZ_B_Positivos += totalNetoGravado;
								totalFacturaBPositivosFacturaZ_B_PositivosIva += totalIva;
								totalFacturaBPositivosFacturaZ_B_Positivos21 += totalNetoGravado21;
								totalFacturaBPositivosFacturaZ_B_PositivosIva21 += totalIva21;
								totalFacturaBPositivosFacturaZ_B_Positivos10_5 += totalNetoGravado10_5;
								totalFacturaBPositivosFacturaZ_B_PositivosIva10_5 += totalIva10_5;
								totalFacturaBPositivosFacturaZ_B_Positivos27 += totalNetoGravado27;
								totalFacturaBPositivosFacturaZ_B_PositivosIva27 += totalIva27;

							} else if (totalNetoGravado < 0) {
								totalFacturaBExentosNoAlcanzadosNegativos += totalNetoGravado;
								totalFacturaBExentosNoAlcanzadosNegativosIva += totalIva;
								totalFacturaBExentosNoAlcanzadosNegativos21 += totalNetoGravado21;
								totalFacturaBExentosNoAlcanzadosNegativosIva21 += totalIva21;
								totalFacturaBExentosNoAlcanzadosNegativos10_5 += totalNetoGravado10_5;
								totalFacturaBExentosNoAlcanzadosNegativosIva10_5 += totalIva10_5;
								totalFacturaBExentosNoAlcanzadosNegativos27 += totalNetoGravado27;
								totalFacturaBExentosNoAlcanzadosNegativosIva27 += totalIva27;

								totalFacturaBNegativosFacturaZ_B_Negativos += totalNetoGravado;
								totalFacturaBNegativosFacturaZ_B_NegativosIva += totalIva;
								totalFacturaBNegativosFacturaZ_B_Negativos21 += totalNetoGravado21;
								totalFacturaBNegativosFacturaZ_B_NegativosIva21 += totalIva21;
								totalFacturaBNegativosFacturaZ_B_Negativos10_5 += totalNetoGravado10_5;
								totalFacturaBNegativosFacturaZ_B_NegativosIva10_5 += totalIva10_5;
								totalFacturaBNegativosFacturaZ_B_Negativos27 += totalNetoGravado27;
								totalFacturaBNegativosFacturaZ_B_NegativosIva27 += totalIva27;
							}
							totalFacturaBExentosNoAlcanzados += totalNetoGravado;
							totalFacturaBExentosNoAlcanzadosIva += totalIva;
							totalFacturaBExentosNoAlcanzados21 += totalNetoGravado21;
							totalFacturaBExentosNoAlcanzadosIva21 += totalIva21;
							totalFacturaBExentosNoAlcanzados10_5 += totalNetoGravado10_5;
							totalFacturaBExentosNoAlcanzadosIva10_5 += totalIva10_5;
							totalFacturaBExentosNoAlcanzados27 += totalNetoGravado27;
							totalFacturaBExentosNoAlcanzadosIva27 += totalIva27;
						} else if (numeroCliente.startsWith("0") || numeroCliente.isEmpty()
								|| razonSocial.equalsIgnoreCase("Consumidor Final")
								|| codigoIva.equalsIgnoreCase("CF")) {
							System.out.println("Factura " + letra + " - Consumidor Final: "
									+ formattedTotalNetoGravado.replace(".", ",") + " - IVA: "
									+ formattedTotalIva.replace(".", ",") + "\n");
							if (totalNetoGravado > 0) {
								totalFacturaBConsumidorFinalPositivos += totalNetoGravado;
								totalFacturaBConsumidorFinalPositivosIva += totalIva;
								totalFacturaBConsumidorFinalPositivos21 += totalNetoGravado21;
								totalFacturaBConsumidorFinalPositivosIva21 += totalIva21;
								totalFacturaBConsumidorFinalPositivos10_5 += totalNetoGravado10_5;
								totalFacturaBConsumidorFinalPositivosIva10_5 += totalIva10_5;
								totalFacturaBConsumidorFinalPositivos27 += totalNetoGravado27;
								totalFacturaBConsumidorFinalPositivosIva27 += totalIva27;

								totalFacturaBPositivosFacturaZ_B_Positivos += totalNetoGravado;
								totalFacturaBPositivosFacturaZ_B_PositivosIva += totalIva;
								totalFacturaBPositivosFacturaZ_B_Positivos21 += totalNetoGravado21;
								totalFacturaBPositivosFacturaZ_B_PositivosIva21 += totalIva21;
								totalFacturaBPositivosFacturaZ_B_Positivos10_5 += totalNetoGravado10_5;
								totalFacturaBPositivosFacturaZ_B_PositivosIva10_5 += totalIva10_5;
								totalFacturaBPositivosFacturaZ_B_Positivos27 += totalNetoGravado27;
								totalFacturaBPositivosFacturaZ_B_PositivosIva27 += totalIva27;

							} else if (totalNetoGravado < 0) {
								totalFacturaBConsumidorFinalNegativos += totalNetoGravado;
								totalFacturaBConsumidorFinalNegativosIva += totalIva;
								totalFacturaBConsumidorFinalNegativos21 += totalNetoGravado21;
								totalFacturaBConsumidorFinalNegativosIva21 += totalIva21;
								totalFacturaBConsumidorFinalNegativos10_5 += totalNetoGravado10_5;
								totalFacturaBConsumidorFinalNegativosIva10_5 += totalIva10_5;
								totalFacturaBConsumidorFinalNegativos27 += totalNetoGravado27;
								totalFacturaBConsumidorFinalNegativosIva27 += totalIva27;

								totalFacturaBNegativosFacturaZ_B_Negativos += totalNetoGravado;
								totalFacturaBNegativosFacturaZ_B_NegativosIva += totalIva;
								totalFacturaBNegativosFacturaZ_B_Negativos21 += totalNetoGravado21;
								totalFacturaBNegativosFacturaZ_B_NegativosIva21 += totalIva21;
								totalFacturaBNegativosFacturaZ_B_Negativos10_5 += totalNetoGravado10_5;
								totalFacturaBNegativosFacturaZ_B_NegativosIva10_5 += totalIva10_5;
								totalFacturaBNegativosFacturaZ_B_Negativos27 += totalNetoGravado27;
								totalFacturaBNegativosFacturaZ_B_NegativosIva27 += totalIva27;
							}
							totalFacturaBConsumidorFinal += totalNetoGravado;
							totalFacturaBConsumidorFinalIva += totalIva;
							totalFacturaBConsumidorFinal21 += totalNetoGravado21;
							totalFacturaBConsumidorFinalIva21 += totalIva21;
							totalFacturaBConsumidorFinal10_5 += totalNetoGravado10_5;
							totalFacturaBConsumidorFinalIva10_5 += totalIva10_5;
							totalFacturaBConsumidorFinal27 += totalNetoGravado27;
							totalFacturaBConsumidorFinalIva27 += totalIva27;
						}
						if (totalNetoGravado > 0) {
							totalFacturaBPositivos += totalNetoGravado;
							totalFacturaBPositivosIva += totalIva;
							totalFacturaBPositivos21 += totalNetoGravado21;
							totalFacturaBPositivosIva21 += totalIva21;
							totalFacturaBPositivos10_5 += totalNetoGravado10_5;
							totalFacturaBPositivosIva10_5 += totalIva10_5;
							totalFacturaBPositivos27 += totalNetoGravado27;
							totalFacturaBPositivosIva27 += totalIva27;

						} else if (totalNetoGravado < 0) {
							totalFacturaBNegativos += totalNetoGravado;
							totalFacturaBNegativosIva += totalIva;
							totalFacturaBNegativos21 += totalNetoGravado21;
							totalFacturaBNegativosIva21 += totalIva21;
							totalFacturaBNegativos10_5 += totalNetoGravado10_5;
							totalFacturaBNegativosIva10_5 += totalIva10_5;
							totalFacturaBNegativos27 += totalNetoGravado27;
							totalFacturaBNegativosIva27 += totalIva27;
						}
						totalFacturaB += totalNetoGravado;
						totalFacturaBIva += totalIva;
						totalFacturaB21 += totalNetoGravado21;
						totalFacturaBIva21 += totalIva21;
						totalFacturaB10_5 += totalNetoGravado10_5;
						totalFacturaBIva10_5 += totalIva10_5;
						totalFacturaB27 += totalNetoGravado27;
						totalFacturaBIva27 += totalIva27;

						totalFacturaBFacturaZ_B += totalNetoGravado;
						totalFacturaBFacturaZ_BIva += totalIva;
						totalFacturaBFacturaZ_B21 += totalNetoGravado21;
						totalFacturaBFacturaZ_BIva21 += totalIva21;
						totalFacturaBFacturaZ_B10_5 += totalNetoGravado10_5;
						totalFacturaBFacturaZ_BIva10_5 += totalIva10_5;
						totalFacturaBFacturaZ_B27 += totalNetoGravado27;
						totalFacturaBFacturaZ_BIva27 += totalIva27;

					} else if (letra.equalsIgnoreCase("Z")) {

						totalFacturaZ += totalNetoGravado;
						totalFacturaZIva += totalIva;
						totalFacturaZ21 += totalNetoGravado21;
						totalFacturaZIva21 += totalIva21;
						totalFacturaZ10_5 += totalNetoGravado10_5;
						totalFacturaZIva10_5 += totalIva10_5;
						totalFacturaZ27 += totalNetoGravado27;
						totalFacturaZIva27 += totalIva27;
						if (totalNetoGravado > 0) {
							totalFacturaZPositivos += totalNetoGravado;
							totalFacturaZPositivosIva += totalIva;
							totalFacturaZPositivos21 += totalNetoGravado21;
							totalFacturaZPositivosIva21 += totalIva21;
							totalFacturaZPositivos10_5 += totalNetoGravado10_5;
							totalFacturaZPositivosIva10_5 += totalIva10_5;
							totalFacturaZPositivos27 += totalNetoGravado27;
							totalFacturaZPositivosIva27 += totalIva27;
						} else if (totalNetoGravado < 0) {
							totalFacturaZNegativos += totalNetoGravado;
							totalFacturaZNegativosIva += totalIva;
							totalFacturaZNegativos21 += totalNetoGravado21;
							totalFacturaZNegativosIva21 += totalIva21;
							totalFacturaZNegativos10_5 += totalNetoGravado10_5;
							totalFacturaZNegativosIva10_5 += totalIva10_5;
							totalFacturaZNegativos27 += totalNetoGravado27;
							totalFacturaZNegativosIva27 += totalIva27;
						}
						if (numeroCliente.startsWith("2")) {
							System.out.println("Factura " + letra + " - Monotributista: "
									+ formattedTotalNetoGravado.replace(".", ",") + " - IVA: "
									+ formattedTotalIva.replace(".", ",") + "\n");
							totalFacturaZ_A += totalNetoGravado;
							totalFacturaZ_A_Iva += totalIva;
							totalFacturaZ_A21 += totalNetoGravado21;
							totalFacturaZ_A_Iva21 += totalIva21;
							totalFacturaZ_A10_5 += totalNetoGravado10_5;
							totalFacturaZ_A_Iva10_5 += totalIva10_5;
							totalFacturaZ_A27 += totalNetoGravado27;
							totalFacturaZ_A_Iva27 += totalIva27;

							if (totalNetoGravado > 0) {
								totalFacturaZ_A_Positivos += totalNetoGravado;
								totalFacturaZ_A_PositivosIva += totalIva;
								totalFacturaZ_A_Positivos21 += totalNetoGravado21;
								totalFacturaZ_A_PositivosIva21 += totalIva21;
								totalFacturaZ_A_Positivos10_5 += totalNetoGravado10_5;
								totalFacturaZ_A_PositivosIva10_5 += totalIva10_5;
								totalFacturaZ_A_Positivos27 += totalNetoGravado27;
								totalFacturaZ_A_PositivosIva27 += totalIva27;

								totalFacturaAPositivosFacturaZ_A_Positivos += totalNetoGravado;
								totalFacturaAPositivosFacturaZ_A_PositivosIva += totalIva;
								totalFacturaAPositivosFacturaZ_A_Positivos21 += totalNetoGravado21;
								totalFacturaAPositivosFacturaZ_A_PositivosIva21 += totalIva21;
								totalFacturaAPositivosFacturaZ_A_Positivos10_5 += totalNetoGravado10_5;
								totalFacturaAPositivosFacturaZ_A_PositivosIva10_5 += totalIva10_5;
								totalFacturaAPositivosFacturaZ_A_Positivos27 += totalNetoGravado27;
								totalFacturaAPositivosFacturaZ_A_PositivosIva27 += totalIva27;

								totalFacturaZ_A_Positivos_Monotributistas += totalNetoGravado;
								totalFacturaZ_A_Positivos_MonotributistasIva += totalIva;
								totalFacturaZ_A_Positivos_Monotributistas21 += totalNetoGravado21;
								totalFacturaZ_A_Positivos_MonotributistasIva21 += totalIva21;
								totalFacturaZ_A_Positivos_Monotributistas10_5 += totalNetoGravado10_5;
								totalFacturaZ_A_Positivos_MonotributistasIva10_5 += totalIva10_5;
								totalFacturaZ_A_Positivos_Monotributistas27 += totalNetoGravado27;
								totalFacturaZ_A_Positivos_MonotributistasIva27 += totalIva27;

							} else if (totalNetoGravado < 0) {
								totalFacturaZ_A_Negativos += totalNetoGravado;
								totalFacturaZ_A_NegativosIva += totalIva;
								totalFacturaZ_A_Negativos21 += totalNetoGravado21;
								totalFacturaZ_A_NegativosIva21 += totalIva21;
								totalFacturaZ_A_Negativos10_5 += totalNetoGravado10_5;
								totalFacturaZ_A_NegativosIva10_5 += totalIva10_5;
								totalFacturaZ_A_Negativos27 += totalNetoGravado27;
								totalFacturaZ_A_NegativosIva27 += totalIva27;

								totalFacturaANegativosFacturaZ_A_Negativos += totalNetoGravado;
								totalFacturaANegativosFacturaZ_A_NegativosIva += totalIva;
								totalFacturaANegativosFacturaZ_A_Negativos21 += totalNetoGravado21;
								totalFacturaANegativosFacturaZ_A_NegativosIva21 += totalIva21;
								totalFacturaANegativosFacturaZ_A_Negativos10_5 += totalNetoGravado10_5;
								totalFacturaANegativosFacturaZ_A_NegativosIva10_5 += totalIva10_5;
								totalFacturaANegativosFacturaZ_A_Negativos27 += totalNetoGravado27;
								totalFacturaANegativosFacturaZ_A_NegativosIva27 += totalIva27;

								totalFacturaZ_A_Negativos_Monotributistas += totalNetoGravado;
								totalFacturaZ_A_Negativos_MonotributistasIva += totalIva;
								totalFacturaZ_A_Negativos_Monotributistas21 += totalNetoGravado21;
								totalFacturaZ_A_Negativos_MonotributistasIva21 += totalIva21;
								totalFacturaZ_A_Negativos_Monotributistas10_5 += totalNetoGravado10_5;
								totalFacturaZ_A_Negativos_MonotributistasIva10_5 += totalIva10_5;
								totalFacturaZ_A_Negativos_Monotributistas27 += totalNetoGravado27;
								totalFacturaZ_A_Negativos_MonotributistasIva27 += totalIva27;

							}
							totalFacturaAFacturaZ_A += totalNetoGravado;
							totalFacturaAFacturaZ_AIva += totalIva;
							totalFacturaAFacturaZ_A21 += totalNetoGravado21;
							totalFacturaAFacturaZ_AIva21 += totalIva21;
							totalFacturaAFacturaZ_A10_5 += totalNetoGravado10_5;
							totalFacturaAFacturaZ_AIva10_5 += totalIva10_5;
							totalFacturaAFacturaZ_A27 += totalNetoGravado27;
							totalFacturaAFacturaZ_AIva27 += totalIva27;

						} else if (numeroCliente.startsWith("3") || codigoIva.equalsIgnoreCase("RI")) {
							System.out.println("Factura " + letra + " - Responsable Inscripto (RI): "
									+ formattedTotalNetoGravado.replace(".", ",") + " - IVA: "
									+ formattedTotalIva.replace(".", ",") + "\n");
							totalFacturaZ_A += totalNetoGravado;
							totalFacturaZ_A_Iva += totalIva;
							totalFacturaZ_A21 += totalNetoGravado21;
							totalFacturaZ_A_Iva21 += totalIva21;
							totalFacturaZ_A10_5 += totalNetoGravado10_5;
							totalFacturaZ_A_Iva10_5 += totalIva10_5;
							totalFacturaZ_A27 += totalNetoGravado27;
							totalFacturaZ_A_Iva27 += totalIva27;
							if (totalNetoGravado > 0) {
								totalFacturaZ_A_Positivos += totalNetoGravado;
								totalFacturaZ_A_PositivosIva += totalIva;
								totalFacturaZ_A_Positivos21 += totalNetoGravado21;
								totalFacturaZ_A_PositivosIva21 += totalIva21;
								totalFacturaZ_A_Positivos10_5 += totalNetoGravado10_5;
								totalFacturaZ_A_PositivosIva10_5 += totalIva10_5;
								totalFacturaZ_A_Positivos27 += totalNetoGravado27;
								totalFacturaZ_A_PositivosIva27 += totalIva27;

								totalFacturaAPositivosFacturaZ_A_Positivos += totalNetoGravado;
								totalFacturaAPositivosFacturaZ_A_PositivosIva += totalIva;
								totalFacturaAPositivosFacturaZ_A_Positivos21 += totalNetoGravado21;
								totalFacturaAPositivosFacturaZ_A_PositivosIva21 += totalIva21;
								totalFacturaAPositivosFacturaZ_A_Positivos10_5 += totalNetoGravado10_5;
								totalFacturaAPositivosFacturaZ_A_PositivosIva10_5 += totalIva10_5;
								totalFacturaAPositivosFacturaZ_A_Positivos27 += totalNetoGravado27;
								totalFacturaAPositivosFacturaZ_A_PositivosIva27 += totalIva27;

								totalFacturaZ_A_Positivos_ResponsableInscripto += totalNetoGravado;
								totalFacturaZ_A_Positivos_ResponsableInscriptoIva += totalIva;
								totalFacturaZ_A_Positivos_ResponsableInscripto21 += totalNetoGravado21;
								totalFacturaZ_A_Positivos_ResponsableInscriptoIva21 += totalIva21;
								totalFacturaZ_A_Positivos_ResponsableInscripto10_5 += totalNetoGravado10_5;
								totalFacturaZ_A_Positivos_ResponsableInscriptoIva10_5 += totalIva10_5;
								totalFacturaZ_A_Positivos_ResponsableInscripto27 += totalNetoGravado27;
								totalFacturaZ_A_Positivos_ResponsableInscriptoIva27 += totalIva27;

							} else if (totalNetoGravado < 0) {
								totalFacturaZ_A_Negativos += totalNetoGravado;
								totalFacturaZ_A_NegativosIva += totalIva;
								totalFacturaZ_A_Negativos21 += totalNetoGravado21;
								totalFacturaZ_A_NegativosIva21 += totalIva21;
								totalFacturaZ_A_Negativos10_5 += totalNetoGravado10_5;
								totalFacturaZ_A_NegativosIva10_5 += totalIva10_5;
								totalFacturaZ_A_Negativos27 += totalNetoGravado27;
								totalFacturaZ_A_NegativosIva27 += totalIva27;

								totalFacturaANegativosFacturaZ_A_Negativos += totalNetoGravado;
								totalFacturaANegativosFacturaZ_A_NegativosIva += totalIva;
								totalFacturaANegativosFacturaZ_A_Negativos21 += totalNetoGravado21;
								totalFacturaANegativosFacturaZ_A_NegativosIva21 += totalIva21;
								totalFacturaANegativosFacturaZ_A_Negativos10_5 += totalNetoGravado10_5;
								totalFacturaANegativosFacturaZ_A_NegativosIva10_5 += totalIva10_5;
								totalFacturaANegativosFacturaZ_A_Negativos27 += totalNetoGravado27;
								totalFacturaANegativosFacturaZ_A_NegativosIva27 += totalIva27;

								totalFacturaZ_A_Negativos_ResponsableInscripto += totalNetoGravado;
								totalFacturaZ_A_Negativos_ResponsableInscriptoIva += totalIva;
								totalFacturaZ_A_Negativos_ResponsableInscripto21 += totalNetoGravado21;
								totalFacturaZ_A_Negativos_ResponsableInscriptoIva21 += totalIva21;
								totalFacturaZ_A_Negativos_ResponsableInscripto10_5 += totalNetoGravado10_5;
								totalFacturaZ_A_Negativos_ResponsableInscriptoIva10_5 += totalIva10_5;
								totalFacturaZ_A_Negativos_ResponsableInscripto27 += totalNetoGravado27;
								totalFacturaZ_A_Negativos_ResponsableInscriptoIva27 += totalIva27;

							}
							totalFacturaAFacturaZ_A += totalNetoGravado;
							totalFacturaAFacturaZ_AIva += totalIva;
							totalFacturaAFacturaZ_A21 += totalNetoGravado21;
							totalFacturaAFacturaZ_AIva21 += totalIva21;
							totalFacturaAFacturaZ_A10_5 += totalNetoGravado10_5;
							totalFacturaAFacturaZ_AIva10_5 += totalIva10_5;
							totalFacturaAFacturaZ_A27 += totalNetoGravado27;
							totalFacturaAFacturaZ_AIva27 += totalIva27;

						} else if (numeroCliente.startsWith("0") || numeroCliente.isEmpty()
								|| razonSocial.equalsIgnoreCase("Consumidor Final")
								|| codigoIva.equalsIgnoreCase("CF")) {
							System.out.println("Factura " + letra + " - Consumidor Final: "
									+ formattedTotalNetoGravado.replace(".", ",") + " - IVA: "
									+ formattedTotalIva.replace(".", ",") + "\n");
							totalFacturaZ_B += totalNetoGravado;
							totalFacturaZ_B_Iva += totalIva;
							totalFacturaZ_B21 += totalNetoGravado21;
							totalFacturaZ_B_Iva21 += totalIva21;
							totalFacturaZ_B10_5 += totalNetoGravado10_5;
							totalFacturaZ_B_Iva10_5 += totalIva10_5;
							totalFacturaZ_B27 += totalNetoGravado27;
							totalFacturaZ_B_Iva27 += totalIva27;
							if (totalNetoGravado > 0) {
								totalFacturaZ_B_Positivos += totalNetoGravado;
								totalFacturaZ_B_PositivosIva += totalIva;
								totalFacturaZ_B_Positivos21 += totalNetoGravado21;
								totalFacturaZ_B_PositivosIva21 += totalIva21;
								totalFacturaZ_B_Positivos10_5 += totalNetoGravado10_5;
								totalFacturaZ_B_PositivosIva10_5 += totalIva10_5;
								totalFacturaZ_B_Positivos27 += totalNetoGravado27;
								totalFacturaZ_B_PositivosIva27 += totalIva27;

								totalFacturaBPositivosFacturaZ_B_Positivos += totalNetoGravado;
								totalFacturaBPositivosFacturaZ_B_PositivosIva += totalIva;
								totalFacturaBPositivosFacturaZ_B_Positivos21 += totalNetoGravado21;
								totalFacturaBPositivosFacturaZ_B_PositivosIva21 += totalIva21;
								totalFacturaBPositivosFacturaZ_B_Positivos10_5 += totalNetoGravado10_5;
								totalFacturaBPositivosFacturaZ_B_PositivosIva10_5 += totalIva10_5;
								totalFacturaBPositivosFacturaZ_B_Positivos27 += totalNetoGravado27;
								totalFacturaBPositivosFacturaZ_B_PositivosIva27 += totalIva27;

								totalFacturaZ_B_Positivos_ConsumidoresFinales += totalNetoGravado;
								totalFacturaZ_B_Positivos_ConsumidoresFinalesIva += totalIva;
								totalFacturaZ_B_Positivos_ConsumidoresFinales21 += totalNetoGravado21;
								totalFacturaZ_B_Positivos_ConsumidoresFinalesIva21 += totalIva21;
								totalFacturaZ_B_Positivos_ConsumidoresFinales10_5 += totalNetoGravado10_5;
								totalFacturaZ_B_Positivos_ConsumidoresFinalesIva10_5 += totalIva10_5;
								totalFacturaZ_B_Positivos_ConsumidoresFinales27 += totalNetoGravado27;
								totalFacturaZ_B_Positivos_ConsumidoresFinalesIva27 += totalIva27;

							} else if (totalNetoGravado < 0) {
								totalFacturaZ_B_Negativos += totalNetoGravado;
								totalFacturaZ_B_NegativosIva += totalIva;
								totalFacturaZ_B_Negativos21 += totalNetoGravado21;
								totalFacturaZ_B_NegativosIva21 += totalIva21;
								totalFacturaZ_B_Negativos10_5 += totalNetoGravado10_5;
								totalFacturaZ_B_NegativosIva10_5 += totalIva10_5;
								totalFacturaZ_B_Negativos27 += totalNetoGravado27;
								totalFacturaZ_B_NegativosIva27 += totalIva27;

								totalFacturaBNegativosFacturaZ_B_Negativos += totalNetoGravado;
								totalFacturaBNegativosFacturaZ_B_NegativosIva += totalIva;
								totalFacturaBNegativosFacturaZ_B_Negativos21 += totalNetoGravado21;
								totalFacturaBNegativosFacturaZ_B_NegativosIva21 += totalIva21;
								totalFacturaBNegativosFacturaZ_B_Negativos10_5 += totalNetoGravado10_5;
								totalFacturaBNegativosFacturaZ_B_NegativosIva10_5 += totalIva10_5;
								totalFacturaBNegativosFacturaZ_B_Negativos27 += totalNetoGravado27;
								totalFacturaBNegativosFacturaZ_B_NegativosIva27 += totalIva27;

								totalFacturaZ_B_Negativos_ConsumidoresFinales += totalNetoGravado;
								totalFacturaZ_B_Negativos_ConsumidoresFinalesIva += totalIva;
								totalFacturaZ_B_Negativos_ConsumidoresFinales21 += totalNetoGravado21;
								totalFacturaZ_B_Negativos_ConsumidoresFinalesIva21 += totalIva21;
								totalFacturaZ_B_Negativos_ConsumidoresFinales10_5 += totalNetoGravado10_5;
								totalFacturaZ_B_Negativos_ConsumidoresFinalesIva10_5 += totalIva10_5;
								totalFacturaZ_B_Negativos_ConsumidoresFinales27 += totalNetoGravado27;
								totalFacturaZ_B_Negativos_ConsumidoresFinalesIva27 += totalIva27;

							}
							totalFacturaBFacturaZ_B += totalNetoGravado;
							totalFacturaBFacturaZ_BIva += totalIva;
							totalFacturaBFacturaZ_B21 += totalNetoGravado21;
							totalFacturaBFacturaZ_BIva21 += totalIva21;
							totalFacturaBFacturaZ_B10_5 += totalNetoGravado10_5;
							totalFacturaBFacturaZ_BIva10_5 += totalIva10_5;
							totalFacturaBFacturaZ_B27 += totalNetoGravado27;
							totalFacturaBFacturaZ_BIva27 += totalIva27;

						} else {
							System.out.println("Factura " + letra + " - Exentos, no Alcanzados, no Gravados: "
									+ formattedTotalNetoGravado.replace(".", ",") + " - IVA: "
									+ formattedTotalIva.replace(".", ",") + "\n");
							totalFacturaZ_B += totalNetoGravado;
							totalFacturaZ_B_Iva += totalIva;
							totalFacturaZ_B21 += totalNetoGravado21;
							totalFacturaZ_B_Iva21 += totalIva21;
							totalFacturaZ_B10_5 += totalNetoGravado10_5;
							totalFacturaZ_B_Iva10_5 += totalIva10_5;
							totalFacturaZ_B27 += totalNetoGravado27;
							totalFacturaZ_B_Iva27 += totalIva27;

							if (totalNetoGravado > 0) {
								totalFacturaZ_B_Positivos += totalNetoGravado;
								totalFacturaZ_B_PositivosIva += totalIva;
								totalFacturaZ_B_Positivos21 += totalNetoGravado21;
								totalFacturaZ_B_PositivosIva21 += totalIva21;
								totalFacturaZ_B_Positivos10_5 += totalNetoGravado10_5;
								totalFacturaZ_B_PositivosIva10_5 += totalIva10_5;
								totalFacturaZ_B_Positivos27 += totalNetoGravado27;
								totalFacturaZ_B_PositivosIva27 += totalIva27;

								totalFacturaBPositivosFacturaZ_B_Positivos += totalNetoGravado;
								totalFacturaBPositivosFacturaZ_B_PositivosIva += totalIva;
								totalFacturaBPositivosFacturaZ_B_Positivos21 += totalNetoGravado21;
								totalFacturaBPositivosFacturaZ_B_PositivosIva21 += totalIva21;
								totalFacturaBPositivosFacturaZ_B_Positivos10_5 += totalNetoGravado10_5;
								totalFacturaBPositivosFacturaZ_B_PositivosIva10_5 += totalIva10_5;
								totalFacturaBPositivosFacturaZ_B_Positivos27 += totalNetoGravado27;
								totalFacturaBPositivosFacturaZ_B_PositivosIva27 += totalIva27;

								totalFacturaZ_B_Positivos_ExentosNoAlcanzados += totalNetoGravado;
								totalFacturaZ_B_Positivos_ExentosNoAlcanzadosIva += totalIva;
								totalFacturaZ_B_Positivos_ExentosNoAlcanzados21 += totalNetoGravado21;
								totalFacturaZ_B_Positivos_ExentosNoAlcanzadosIva21 += totalIva21;
								totalFacturaZ_B_Positivos_ExentosNoAlcanzados10_5 += totalNetoGravado10_5;
								totalFacturaZ_B_Positivos_ExentosNoAlcanzadosIva10_5 += totalIva10_5;
								totalFacturaZ_B_Positivos_ExentosNoAlcanzados27 += totalNetoGravado27;
								totalFacturaZ_B_Positivos_ExentosNoAlcanzadosIva27 += totalIva27;

							} else if (totalNetoGravado < 0) {
								totalFacturaZ_B_Negativos += totalNetoGravado;
								totalFacturaZ_B_NegativosIva += totalIva;
								totalFacturaZ_B_Negativos21 += totalNetoGravado21;
								totalFacturaZ_B_NegativosIva21 += totalIva21;
								totalFacturaZ_B_Negativos10_5 += totalNetoGravado10_5;
								totalFacturaZ_B_NegativosIva10_5 += totalIva10_5;
								totalFacturaZ_B_Negativos27 += totalNetoGravado27;
								totalFacturaZ_B_NegativosIva27 += totalIva27;

								totalFacturaBNegativosFacturaZ_B_Negativos += totalNetoGravado;
								totalFacturaBNegativosFacturaZ_B_NegativosIva += totalIva;
								totalFacturaBNegativosFacturaZ_B_Negativos21 += totalNetoGravado21;
								totalFacturaBNegativosFacturaZ_B_NegativosIva21 += totalIva21;
								totalFacturaBNegativosFacturaZ_B_Negativos10_5 += totalNetoGravado10_5;
								totalFacturaBNegativosFacturaZ_B_NegativosIva10_5 += totalIva10_5;
								totalFacturaBNegativosFacturaZ_B_Negativos27 += totalNetoGravado27;
								totalFacturaBNegativosFacturaZ_B_NegativosIva27 += totalIva27;

								totalFacturaZ_B_Negativos_ExentosNoAlcanzados += totalNetoGravado;
								totalFacturaZ_B_Negativos_ExentosNoAlcanzadosIva += totalIva;
								totalFacturaZ_B_Negativos_ExentosNoAlcanzados21 += totalNetoGravado21;
								totalFacturaZ_B_Negativos_ExentosNoAlcanzadosIva21 += totalIva21;
								totalFacturaZ_B_Negativos_ExentosNoAlcanzados10_5 += totalNetoGravado10_5;
								totalFacturaZ_B_Negativos_ExentosNoAlcanzadosIva10_5 += totalIva10_5;
								totalFacturaZ_B_Negativos_ExentosNoAlcanzados27 += totalNetoGravado27;
								totalFacturaZ_B_Negativos_ExentosNoAlcanzadosIva27 += totalIva27;

							}
							totalFacturaBFacturaZ_B += totalNetoGravado;
							totalFacturaBFacturaZ_BIva += totalIva;
							totalFacturaBFacturaZ_B21 += totalNetoGravado21;
							totalFacturaBFacturaZ_BIva21 += totalIva21;
							totalFacturaBFacturaZ_B10_5 += totalNetoGravado10_5;
							totalFacturaBFacturaZ_BIva10_5 += totalIva10_5;
							totalFacturaBFacturaZ_B27 += totalNetoGravado27;
							totalFacturaBFacturaZ_BIva27 += totalIva27;

						}

					} else {
						System.out.println("Factura " + letra + " - No clasificada: "
								+ formattedTotalNetoGravado.replace(".", ","));
						requiereRevision = true;
					}

					if (requiereRevision) {
						System.out.println("Requiere revisión: " + letra + " - " + razonSocial + " - " + tipoDocumento
								+ " - " + numeroCliente);
					}
				}
			}
		}

		String formattedTotalFacturaAResponsableInscriptoPositivos21 = String
				.format("%.2f", totalFacturaAResponsableInscriptoPositivos21).replace(".", ",");
		String formattedTotalFacturaAResponsableInscriptoNegativos21 = String
				.format("%.2f", totalFacturaAResponsableInscriptoNegativos21).replace(".", ",");
		String formattedTotalFacturaAResponsableInscripto21 = String.format("%.2f", totalFacturaAResponsableInscripto21)
				.replace(".", ",");
		String formattedTotalFacturaAMonotributistaPositivos21 = String
				.format("%.2f", totalFacturaAMonotributistaPositivos21).replace(".", ",");
		String formattedTotalFacturaAMonotributistaNegativos21 = String
				.format("%.2f", totalFacturaAMonotributistaNegativos21).replace(".", ",");
		String formattedTotalFacturaAMonotributista21 = String.format("%.2f", totalFacturaAMonotributista21)
				.replace(".", ",");
		String formattedTotalFacturaAExentosNoAlcanzadosPositivos21 = String
				.format("%.2f", totalFacturaAExentosNoAlcanzadosPositivos21).replace(".", ",");
		String formattedTotalFacturaAExentosNoAlcanzadosNegativos21 = String
				.format("%.2f", totalFacturaAExentosNoAlcanzadosNegativos21).replace(".", ",");
		String formattedTotalFacturaAExentosNoAlcanzados21 = String.format("%.2f", totalFacturaAExentosNoAlcanzados21)
				.replace(".", ",");
		String formattedTotalFacturaAPositivos21 = String.format("%.2f", totalFacturaAPositivos21).replace(".", ",");
		String formattedTotalFacturaANegativos21 = String.format("%.2f", totalFacturaANegativos21).replace(".", ",");
		String formattedTotalFacturaA21 = String.format("%.2f", totalFacturaA21).replace(".", ",");

		String formattedTotalFacturaBConsumidorFinalPositivos21 = String
				.format("%.2f", totalFacturaBConsumidorFinalPositivos21).replace(".", ",");
		String formattedTotalFacturaBConsumidorFinalNegativos21 = String
				.format("%.2f", totalFacturaBConsumidorFinalNegativos21).replace(".", ",");
		String formattedTotalFacturaBConsumidorFinal21 = String.format("%.2f", totalFacturaBConsumidorFinal21)
				.replace(".", ",");
		String formattedTotalFacturaBMonotributistaPositivos21 = String
				.format("%.2f", totalFacturaBMonotributistaPositivos21).replace(".", ",");
		String formattedTotalFacturaBMonotributistaNegativos21 = String
				.format("%.2f", totalFacturaBMonotributistaNegativos21).replace(".", ",");
		String formattedTotalFacturaBMonotributista21 = String.format("%.2f", totalFacturaBMonotributista21)
				.replace(".", ",");
		String formattedTotalFacturaBExentosNoAlcanzadosPositivos21 = String
				.format("%.2f", totalFacturaBExentosNoAlcanzadosPositivos21).replace(".", ",");
		String formattedTotalFacturaBExentosNoAlcanzadosNegativos21 = String
				.format("%.2f", totalFacturaBExentosNoAlcanzadosNegativos21).replace(".", ",");
		String formattedTotalFacturaBExentosNoAlcanzados21 = String.format("%.2f", totalFacturaBExentosNoAlcanzados21)
				.replace(".", ",");
		String formattedTotalFacturaBPositivos21 = String.format("%.2f", totalFacturaBPositivos21).replace(".", ",");
		String formattedTotalFacturaBNegativos21 = String.format("%.2f", totalFacturaBNegativos21).replace(".", ",");
		String formattedTotalFacturaB21 = String.format("%.2f", totalFacturaB21).replace(".", ",");

		String formattedTotalFacturaZ_A_Positivos21 = String.format("%.2f", totalFacturaZ_A_Positivos21).replace(".",
				",");
		String formattedTotalFacturaZ_A_Negativos21 = String.format("%.2f", totalFacturaZ_A_Negativos21).replace(".",
				",");
		String formattedTotalFacturaZ_A21 = String.format("%.2f", totalFacturaZ_A21).replace(".", ",");
		String formattedTotalFacturaZ_B_Positivos21 = String.format("%.2f", totalFacturaZ_B_Positivos21).replace(".",
				",");
		String formattedTotalFacturaZ_B_Negativos21 = String.format("%.2f", totalFacturaZ_B_Negativos21).replace(".",
				",");
		String formattedTotalFacturaZ_B21 = String.format("%.2f", totalFacturaZ_B21).replace(".", ",");
		String formattedTotalFacturaZPositivos21 = String.format("%.2f", totalFacturaZPositivos21).replace(".", ",");
		String formattedTotalFacturaZNegativos21 = String.format("%.2f", totalFacturaZNegativos21).replace(".", ",");
		String formattedTotalFacturaZ21 = String.format("%.2f", totalFacturaZ21).replace(".", ",");

		String formattedTotalFacturaAPositivosFacturaZ_A_Positivos21 = String
				.format("%.2f", totalFacturaAPositivosFacturaZ_A_Positivos21).replace(".", ",");
		String formattedTotalFacturaANegativosFacturaZ_A_Negativos21 = String
				.format("%.2f", totalFacturaANegativosFacturaZ_A_Negativos21).replace(".", ",");
		String formattedTotalFacturaAFacturaZ_A21 = String.format("%.2f", totalFacturaAFacturaZ_A21).replace(".", ",");
		String formattedTotalFacturaBPositivosFacturaZ_B_Positivos21 = String
				.format("%.2f", totalFacturaBPositivosFacturaZ_B_Positivos21).replace(".", ",");
		String formattedTotalFacturaBNegativosFacturaZ_B_Negativos21 = String
				.format("%.2f", totalFacturaBNegativosFacturaZ_B_Negativos21).replace(".", ",");
		String formattedTotalFacturaBFacturaZ_B21 = String.format("%.2f", totalFacturaBFacturaZ_B21).replace(".", ",");

		String formattedTotalFacturaZ_A_Positivos_Monotributistas21 = String
				.format("%.2f", totalFacturaZ_A_Positivos_Monotributistas21).replace(".", ",");
		String formattedTotalFacturaZ_B_Positivos_Monotributistas21 = String
				.format("%.2f", totalFacturaZ_B_Positivos_Monotributistas21).replace(".", ",");
		String formattedTotalFacturaZ_B_Positivos_ConsumidoresFinales21 = String
				.format("%.2f", totalFacturaZ_B_Positivos_ConsumidoresFinales21).replace(".", ",");
		String formattedTotalFacturaZ_A_Positivos_ExentosNoAlcanzados21 = String
				.format("%.2f", totalFacturaZ_A_Positivos_ExentosNoAlcanzados21).replace(".", ",");
		String formattedTotalFacturaZ_B_Positivos_ExentosNoAlcanzados21 = String
				.format("%.2f", totalFacturaZ_B_Positivos_ExentosNoAlcanzados21).replace(".", ",");
		String formattedTotalFacturaZ_A_Positivos_ResponsableInscripto21 = String
				.format("%.2f", totalFacturaZ_A_Positivos_ResponsableInscripto21).replace(".", ",");

		String formattedTotalFacturaZ_A_Negativos_Monotributistas21 = String
				.format("%.2f", totalFacturaZ_A_Negativos_Monotributistas21).replace(".", ",");
		String formattedTotalFacturaZ_B_Negativos_Monotributistas21 = String
				.format("%.2f", totalFacturaZ_B_Negativos_Monotributistas21).replace(".", ",");
		String formattedTotalFacturaZ_B_Negativos_ConsumidoresFinales21 = String
				.format("%.2f", totalFacturaZ_B_Negativos_ConsumidoresFinales21).replace(".", ",");
		String formattedTotalFacturaZ_A_Negativos_ExentosNoAlcanzados21 = String
				.format("%.2f", totalFacturaZ_A_Negativos_ExentosNoAlcanzados21).replace(".", ",");
		String formattedTotalFacturaZ_B_Negativos_ExentosNoAlcanzados21 = String
				.format("%.2f", totalFacturaZ_B_Negativos_ExentosNoAlcanzados21).replace(".", ",");
		String formattedTotalFacturaZ_A_Negativos_ResponsableInscripto21 = String
				.format("%.2f", totalFacturaZ_A_Negativos_ResponsableInscripto21).replace(".", ",");

		String formattedOpRi21 = String
				.format("%.2f",
						totalFacturaAResponsableInscriptoPositivos21 + totalFacturaZ_A_Positivos_ResponsableInscripto21)
				.replace(".", ",");
		String formattedOpCfExentos21 = String.format("%.2f",
				totalFacturaZ_B_Positivos_ConsumidoresFinales21 + totalFacturaZ_A_Positivos_ExentosNoAlcanzados21
						+ totalFacturaZ_B_Positivos_ExentosNoAlcanzados21 + totalFacturaAExentosNoAlcanzadosPositivos21
						+ totalFacturaBConsumidorFinalPositivos21 + totalFacturaBExentosNoAlcanzadosPositivos21)
				.replace(".", ",");
		String formattedOpMon21 = String
				.format("%.2f",
						totalFacturaZ_A_Positivos_Monotributistas21 + totalFacturaZ_B_Positivos_Monotributistas21
								+ totalFacturaAMonotributistaPositivos21 + totalFacturaBMonotributistaPositivos21)
				.replace(".", ",");

		String formattedOpRiCredito21 = String
				.format("%.2f",
						totalFacturaAResponsableInscriptoNegativos21 + totalFacturaZ_A_Negativos_ResponsableInscripto21)
				.replace(".", ",");

		String formattedOpCfExentosMonCredito21 = String.format("%.2f",
				totalFacturaZ_B_Negativos_ConsumidoresFinales21 + totalFacturaZ_A_Negativos_ExentosNoAlcanzados21
						+ totalFacturaZ_B_Negativos_ExentosNoAlcanzados21 + totalFacturaAExentosNoAlcanzadosNegativos21
						+ totalFacturaBConsumidorFinalNegativos21 + totalFacturaBExentosNoAlcanzadosNegativos21
						+ totalFacturaZ_A_Negativos_Monotributistas21 + totalFacturaZ_B_Negativos_Monotributistas21
						+ totalFacturaAMonotributistaNegativos21 + totalFacturaBMonotributistaNegativos21)
				.replace(".", ",");

		String formattedTotalFacturaAResponsableInscriptoPositivosIva21 = String
				.format("%.2f", totalFacturaAResponsableInscriptoPositivosIva21).replace(".", ",");
		String formattedTotalFacturaAResponsableInscriptoNegativosIva21 = String
				.format("%.2f", totalFacturaAResponsableInscriptoNegativosIva21).replace(".", ",");
		String formattedTotalFacturaAResponsableInscriptoIva21 = String
				.format("%.2f", totalFacturaAResponsableInscriptoIva21).replace(".", ",");
		String formattedTotalFacturaAMonotributistaPositivosIva21 = String
				.format("%.2f", totalFacturaAMonotributistaPositivosIva21).replace(".", ",");
		String formattedTotalFacturaAMonotributistaNegativosIva21 = String
				.format("%.2f", totalFacturaAMonotributistaNegativosIva21).replace(".", ",");
		String formattedTotalFacturaAMonotributistaIva21 = String.format("%.2f", totalFacturaAMonotributistaIva21)
				.replace(".", ",");
		String formattedTotalFacturaAExentosNoAlcanzadosPositivosIva21 = String
				.format("%.2f", totalFacturaAExentosNoAlcanzadosPositivosIva21).replace(".", ",");
		String formattedTotalFacturaAExentosNoAlcanzadosNegativosIva21 = String
				.format("%.2f", totalFacturaAExentosNoAlcanzadosNegativosIva21).replace(".", ",");
		String formattedTotalFacturaAExentosNoAlcanzadosIva21 = String
				.format("%.2f", totalFacturaAExentosNoAlcanzadosIva21).replace(".", ",");
		String formattedTotalFacturaAPositivosIva21 = String.format("%.2f", totalFacturaAPositivosIva21).replace(".",
				",");
		String formattedTotalFacturaANegativosIva21 = String.format("%.2f", totalFacturaANegativosIva21).replace(".",
				",");
		String formattedTotalFacturaAIva21 = String.format("%.2f", totalFacturaAIva21).replace(".", ",");

		String formattedTotalFacturaBConsumidorFinalPositivosIva21 = String
				.format("%.2f", totalFacturaBConsumidorFinalPositivosIva21).replace(".", ",");
		String formattedTotalFacturaBConsumidorFinalNegativosIva21 = String
				.format("%.2f", totalFacturaBConsumidorFinalNegativosIva21).replace(".", ",");
		String formattedTotalFacturaBConsumidorFinalIva21 = String.format("%.2f", totalFacturaBConsumidorFinalIva21)
				.replace(".", ",");
		String formattedTotalFacturaBMonotributistaPositivosIva21 = String
				.format("%.2f", totalFacturaBMonotributistaPositivosIva21).replace(".", ",");
		String formattedTotalFacturaBMonotributistaNegativosIva21 = String
				.format("%.2f", totalFacturaBMonotributistaNegativosIva21).replace(".", ",");
		String formattedTotalFacturaBMonotributistaIva21 = String.format("%.2f", totalFacturaBMonotributistaIva21)
				.replace(".", ",");
		String formattedTotalFacturaBExentosNoAlcanzadosPositivosIva21 = String
				.format("%.2f", totalFacturaBExentosNoAlcanzadosPositivosIva21).replace(".", ",");
		String formattedTotalFacturaBExentosNoAlcanzadosNegativosIva21 = String
				.format("%.2f", totalFacturaBExentosNoAlcanzadosNegativosIva21).replace(".", ",");
		String formattedTotalFacturaBExentosNoAlcanzadosIva21 = String
				.format("%.2f", totalFacturaBExentosNoAlcanzadosIva21).replace(".", ",");
		String formattedTotalFacturaBPositivosIva21 = String.format("%.2f", totalFacturaBPositivosIva21).replace(".",
				",");
		String formattedTotalFacturaBNegativosIva21 = String.format("%.2f", totalFacturaBNegativosIva21).replace(".",
				",");
		String formattedTotalFacturaBIva21 = String.format("%.2f", totalFacturaBIva21).replace(".", ",");

		String formattedTotalFacturaZ_A_PositivosIva21 = String.format("%.2f", totalFacturaZ_A_PositivosIva21)
				.replace(".", ",");
		String formattedTotalFacturaZ_A_NegativosIva21 = String.format("%.2f", totalFacturaZ_A_NegativosIva21)
				.replace(".", ",");
		String formattedTotalFacturaZ_AIva21 = String.format("%.2f", totalFacturaZ_A_Iva21).replace(".", ",");
		String formattedTotalFacturaZ_B_PositivosIva21 = String.format("%.2f", totalFacturaZ_B_PositivosIva21)
				.replace(".", ",");
		String formattedTotalFacturaZ_B_NegativosIva21 = String.format("%.2f", totalFacturaZ_B_NegativosIva21)
				.replace(".", ",");
		String formattedTotalFacturaZ_BIva21 = String.format("%.2f", totalFacturaZ_B_Iva21).replace(".", ",");
		String formattedTotalFacturaZPositivosIva21 = String.format("%.2f", totalFacturaZPositivosIva21).replace(".",
				",");
		String formattedTotalFacturaZNegativosIva21 = String.format("%.2f", totalFacturaZNegativosIva21).replace(".",
				",");
		String formattedTotalFacturaZIva21 = String.format("%.2f", totalFacturaZIva21).replace(".", ",");

		String formattedTotalFacturaAPositivosFacturaZ_A_PositivosIva21 = String
				.format("%.2f", totalFacturaAPositivosFacturaZ_A_PositivosIva21).replace(".", ",");
		String formattedTotalFacturaANegativosFacturaZ_A_NegativosIva21 = String
				.format("%.2f", totalFacturaANegativosFacturaZ_A_NegativosIva21).replace(".", ",");
		String formattedTotalFacturaAFacturaZ_AIva21 = String.format("%.2f", totalFacturaAFacturaZ_AIva21).replace(".",
				",");
		String formattedTotalFacturaBPositivosFacturaZ_B_PositivosIva21 = String
				.format("%.2f", totalFacturaBPositivosFacturaZ_B_PositivosIva21).replace(".", ",");
		String formattedTotalFacturaBNegativosFacturaZ_B_NegativosIva21 = String
				.format("%.2f", totalFacturaBNegativosFacturaZ_B_NegativosIva21).replace(".", ",");
		String formattedTotalFacturaBFacturaZ_BIva21 = String.format("%.2f", totalFacturaBFacturaZ_BIva21).replace(".",
				",");

		String formattedTotalFacturaZ_A_Positivos_MonotributistasIva21 = String
				.format("%.2f", totalFacturaZ_A_Positivos_MonotributistasIva21).replace(".", ",");
		String formattedTotalFacturaZ_B_Positivos_MonotributistasIva21 = String
				.format("%.2f", totalFacturaZ_B_Positivos_MonotributistasIva21).replace(".", ",");
		String formattedTotalFacturaZ_B_Positivos_ConsumidoresFinalesIva21 = String
				.format("%.2f", totalFacturaZ_B_Positivos_ConsumidoresFinalesIva21).replace(".", ",");
		String formattedTotalFacturaZ_A_Positivos_ExentosNoAlcanzadosIva21 = String
				.format("%.2f", totalFacturaZ_A_Positivos_ExentosNoAlcanzadosIva21).replace(".", ",");
		String formattedTotalFacturaZ_B_Positivos_ExentosNoAlcanzadosIva21 = String
				.format("%.2f", totalFacturaZ_B_Positivos_ExentosNoAlcanzadosIva21).replace(".", ",");
		String formattedTotalFacturaZ_A_Positivos_ResponsableInscriptoIva21 = String
				.format("%.2f", totalFacturaZ_A_Positivos_ResponsableInscriptoIva21).replace(".", ",");

		String formattedTotalFacturaZ_A_Negativos_MonotributistasIva21 = String
				.format("%.2f", totalFacturaZ_A_Negativos_MonotributistasIva21).replace(".", ",");
		String formattedTotalFacturaZ_B_Negativos_MonotributistasIva21 = String
				.format("%.2f", totalFacturaZ_B_Negativos_MonotributistasIva21).replace(".", ",");
		String formattedTotalFacturaZ_B_Negativos_ConsumidoresFinalesIva21 = String
				.format("%.2f", totalFacturaZ_B_Negativos_ConsumidoresFinalesIva21).replace(".", ",");
		String formattedTotalFacturaZ_A_Negativos_ExentosNoAlcanzadosIva21 = String
				.format("%.2f", totalFacturaZ_A_Negativos_ExentosNoAlcanzadosIva21).replace(".", ",");
		String formattedTotalFacturaZ_B_Negativos_ExentosNoAlcanzadosIva21 = String
				.format("%.2f", totalFacturaZ_B_Negativos_ExentosNoAlcanzadosIva21).replace(".", ",");
		String formattedTotalFacturaZ_A_Negativos_ResponsableInscriptoIva21 = String
				.format("%.2f", totalFacturaZ_A_Negativos_ResponsableInscriptoIva21).replace(".", ",");

		String formattedOpRiIva21 = String.format("%.2f",
				totalFacturaAResponsableInscriptoPositivosIva21 + totalFacturaZ_A_Positivos_ResponsableInscriptoIva21)
				.replace(".", ",");
		String formattedOpCfExentosIva21 = String.format("%.2f",
				totalFacturaZ_B_Positivos_ConsumidoresFinalesIva21 + totalFacturaZ_A_Positivos_ExentosNoAlcanzadosIva21
						+ totalFacturaZ_B_Positivos_ExentosNoAlcanzadosIva21
						+ totalFacturaAExentosNoAlcanzadosPositivosIva21 + totalFacturaBConsumidorFinalPositivosIva21
						+ totalFacturaBExentosNoAlcanzadosPositivosIva21)
				.replace(".", ",");
		String formattedOpMonIva21 = String
				.format("%.2f",
						totalFacturaZ_A_Positivos_MonotributistasIva21 + totalFacturaZ_B_Positivos_MonotributistasIva21
								+ totalFacturaAMonotributistaPositivosIva21 + totalFacturaBMonotributistaPositivosIva21)
				.replace(".", ",");

		String formattedOpRiCreditoIva21 = String.format("%.2f",
				totalFacturaAResponsableInscriptoNegativosIva21 + totalFacturaZ_A_Negativos_ResponsableInscriptoIva21)
				.replace(".", ",");

		String formattedOpCfExentosMonCreditoIva21 = String.format("%.2f",
				totalFacturaZ_B_Negativos_ConsumidoresFinalesIva21 + totalFacturaZ_A_Negativos_ExentosNoAlcanzadosIva21
						+ totalFacturaZ_B_Negativos_ExentosNoAlcanzadosIva21
						+ totalFacturaAExentosNoAlcanzadosNegativosIva21 + totalFacturaBConsumidorFinalNegativosIva21
						+ totalFacturaBExentosNoAlcanzadosNegativosIva21
						+ totalFacturaZ_A_Negativos_MonotributistasIva21
						+ totalFacturaZ_B_Negativos_MonotributistasIva21 + totalFacturaAMonotributistaNegativosIva21
						+ totalFacturaBMonotributistaNegativosIva21)
				.replace(".", ",");

		// Mostrar los resultados formateados
		System.out.println(ANSI_RED + "\nPunto de venta: " + puntoDeVenta + ANSI_RESET);

		System.out.println("\nTotales acumulados Neto Gravado con IVA 21:");

		System.out.println("\nFacturas A 21");

		System.out.println("Total Factura A Responsable Inscripto (RI) Positivos 21: "
				+ formattedTotalFacturaAResponsableInscriptoPositivos21 + " \tIVA\t "
				+ formattedTotalFacturaAResponsableInscriptoPositivosIva21);
		System.out.println("Total Factura A Responsable Inscripto (RI) Negativos 21: "
				+ formattedTotalFacturaAResponsableInscriptoNegativos21 + " \tIVA\t "
				+ formattedTotalFacturaAResponsableInscriptoNegativosIva21);
		System.out.println(
				"Total Factura A Responsable Inscripto (RI) 21: " + formattedTotalFacturaAResponsableInscripto21
						+ " \tIVA\t " + formattedTotalFacturaAResponsableInscriptoIva21);
		System.out.println(
				"Total Factura A Monotributista Positivos 21: " + formattedTotalFacturaAMonotributistaPositivos21
						+ " \tIVA\t " + formattedTotalFacturaAMonotributistaPositivosIva21);
		System.out.println(
				"Total Factura A Monotributista Negativos 21: " + formattedTotalFacturaAMonotributistaNegativos21
						+ " \tIVA\t " + formattedTotalFacturaAMonotributistaNegativosIva21);
		System.out.println("Total Factura A Monotributista 21: " + formattedTotalFacturaAMonotributista21 + " \tIVA\t "
				+ formattedTotalFacturaAMonotributistaIva21);
		System.out.println("Total Factura A Exentos No Alcanzados Positivos 21: "
				+ formattedTotalFacturaAExentosNoAlcanzadosPositivos21 + " \tIVA\t "
				+ formattedTotalFacturaAExentosNoAlcanzadosPositivosIva21);
		System.out.println("Total Factura A Exentos No Alcanzados Negativos 21: "
				+ formattedTotalFacturaAExentosNoAlcanzadosNegativos21 + " \tIVA\t "
				+ formattedTotalFacturaAExentosNoAlcanzadosNegativosIva21);
		System.out.println("Total Factura A Exentos No Alcanzados 21: " + formattedTotalFacturaAExentosNoAlcanzados21
				+ " \tIVA\t " + formattedTotalFacturaAExentosNoAlcanzadosIva21);
		System.out.println("Total Factura A Positivos (sin Facturas Z positivas) 21: "
				+ formattedTotalFacturaAPositivos21 + " \tIVA\t " + formattedTotalFacturaAPositivosIva21);
		System.out.println("Total Factura A Negativos (sin Facturas Z negativas) 21: "
				+ formattedTotalFacturaANegativos21 + " \tIVA\t " + formattedTotalFacturaANegativosIva21);
		System.out.println("Total Factura A (sin Facturas Z) 21: " + formattedTotalFacturaA21 + " \tIVA\t "
				+ formattedTotalFacturaAIva21);

		System.out.println("\nFacturas B 21");

		System.out.println(
				"Total Factura B Consumidor Final Positivos 21: " + formattedTotalFacturaBConsumidorFinalPositivos21
						+ " \tIVA\t " + formattedTotalFacturaBConsumidorFinalPositivosIva21);
		System.out.println(
				"Total Factura B Consumidor Final Negativos 21: " + formattedTotalFacturaBConsumidorFinalNegativos21
						+ " \tIVA\t " + formattedTotalFacturaBConsumidorFinalNegativosIva21);
		System.out.println("Total Factura B Consumidor Final 21: " + formattedTotalFacturaBConsumidorFinal21
				+ " \tIVA\t " + formattedTotalFacturaBConsumidorFinalIva21);
		System.out.println(
				"Total Factura B Monotributista Positivos 21: " + formattedTotalFacturaBMonotributistaPositivos21
						+ " \tIVA\t " + formattedTotalFacturaBMonotributistaPositivosIva21);
		System.out.println(
				"Total Factura B Monotributista Negativos 21: " + formattedTotalFacturaBMonotributistaNegativos21
						+ " \tIVA\t " + formattedTotalFacturaBMonotributistaNegativosIva21);
		System.out.println("Total Factura B Monotributista 21: " + formattedTotalFacturaBMonotributista21 + " \tIVA\t "
				+ formattedTotalFacturaBMonotributistaIva21);
		System.out.println("Total Factura B Exentos No Alcanzados Positivos 21: "
				+ formattedTotalFacturaBExentosNoAlcanzadosPositivos21 + " \tIVA\t "
				+ formattedTotalFacturaBExentosNoAlcanzadosPositivosIva21);
		System.out.println("Total Factura B Exentos No Alcanzados Negativos 21: "
				+ formattedTotalFacturaBExentosNoAlcanzadosNegativos21 + " \tIVA\t "
				+ formattedTotalFacturaBExentosNoAlcanzadosNegativosIva21);
		System.out.println("Total Factura B Exentos No Alcanzados 21: " + formattedTotalFacturaBExentosNoAlcanzados21
				+ " \tIVA\t " + formattedTotalFacturaBExentosNoAlcanzadosIva21);
		System.out.println("Total Factura B Positivos (sin Facturas Z positivas) 21: "
				+ formattedTotalFacturaBPositivos21 + " \tIVA\t " + formattedTotalFacturaBPositivosIva21);
		System.out.println("Total Factura B Negativos (sin Facturas Z negativas) 21: "
				+ formattedTotalFacturaBNegativos21 + " \tIVA\t " + formattedTotalFacturaBNegativosIva21);
		System.out.println("Total Factura B (sin facturas Z) 21: " + formattedTotalFacturaB21 + " \tIVA\t "
				+ formattedTotalFacturaBIva21);

		System.out.println("\nFacturas Z 21");

		System.out.println("Total Factura Z Que Son Factura A Positivo 21: " + formattedTotalFacturaZ_A_Positivos21
				+ " \tIVA\t " + formattedTotalFacturaZ_A_PositivosIva21);
		System.out.println("Total Factura Z Que Son Factura A Negativos 21: " + formattedTotalFacturaZ_A_Negativos21
				+ " \tIVA\t " + formattedTotalFacturaZ_A_NegativosIva21);
		System.out.println("Total Factura Z Que Son Factura A 21: " + formattedTotalFacturaZ_A21 + " \tIVA\t "
				+ formattedTotalFacturaZ_AIva21);
		System.out.println("Total Factura Z Que Son Factura B Positivos 21: " + formattedTotalFacturaZ_B_Positivos21
				+ " \tIVA\t " + formattedTotalFacturaZ_B_PositivosIva21);
		System.out.println("Total Factura Z Que Son Factura B Negativos 21: " + formattedTotalFacturaZ_B_Negativos21
				+ " \tIVA\t " + formattedTotalFacturaZ_B_NegativosIva21);
		System.out.println("Total Factura Z Que Son Factura B 21: " + formattedTotalFacturaZ_B21 + " \tIVA\t "
				+ formattedTotalFacturaZ_BIva21);
		System.out.println("Total Factura Z Positivos 21: " + formattedTotalFacturaZPositivos21 + " \tIVA\t "
				+ formattedTotalFacturaZPositivosIva21);
		System.out.println("Total Factura Z Negativos 21: " + formattedTotalFacturaZNegativos21 + " \tIVA\t "
				+ formattedTotalFacturaZNegativosIva21);
		System.out
				.println("Total Factura Z 21: " + formattedTotalFacturaZ21 + " \tIVA\t " + formattedTotalFacturaZIva21);

		System.out.println("Total Factura A Positivos (con Facturas Z que son A Positivos) 21: "
				+ formattedTotalFacturaAPositivosFacturaZ_A_Positivos21 + " \tIVA\t "
				+ formattedTotalFacturaAPositivosFacturaZ_A_PositivosIva21);
		System.out.println("Total Factura A Negativos (con Facturas Z que son A Negativos) 21: "
				+ formattedTotalFacturaANegativosFacturaZ_A_Negativos21 + " \tIVA\t "
				+ formattedTotalFacturaANegativosFacturaZ_A_NegativosIva21);
		System.out.println("Total Factura A (con Facturas Z que son A) 21: " + formattedTotalFacturaAFacturaZ_A21
				+ " \tIVA\t " + formattedTotalFacturaAFacturaZ_AIva21);

		System.out.println("Total Factura B Positivos (con Facturas Z que son B Positivos) 21: "
				+ formattedTotalFacturaBPositivosFacturaZ_B_Positivos21 + " \tIVA\t "
				+ formattedTotalFacturaBPositivosFacturaZ_B_PositivosIva21);
		System.out.println("Total Factura B Negativos (con Facturas Z que son B Negativos) 21: "
				+ formattedTotalFacturaBNegativosFacturaZ_B_Negativos21 + " \tIVA\t "
				+ formattedTotalFacturaBNegativosFacturaZ_B_NegativosIva21);
		System.out.println("Total Factura B (con Facturas Z que son B) 21: " + formattedTotalFacturaBFacturaZ_B21
				+ " \tIVA\t " + formattedTotalFacturaBFacturaZ_BIva21);

		System.out.println("Total Factura Z Que Son Factura A Positivos Responsable Inscripto 21 : "
				+ formattedTotalFacturaZ_A_Positivos_ResponsableInscripto21 + " \tIVA\t "
				+ formattedTotalFacturaZ_A_Positivos_ResponsableInscriptoIva21);
		System.out.println(
				"Operaciones con responsables Inscriptos) 21: " + formattedOpRi21 + " \tIVA\t " + formattedOpRiIva21);

		System.out.println("Total Factura Z Que Son Factura A Positivos Monotributistas 21: "
				+ formattedTotalFacturaZ_A_Positivos_Monotributistas21 + " \tIVA\t "
				+ formattedTotalFacturaZ_A_Positivos_MonotributistasIva21);
		System.out.println("Total Factura Z Que Son Factura B Positivos Monotributistas 21: "
				+ formattedTotalFacturaZ_B_Positivos_Monotributistas21 + " \tIVA\t "
				+ formattedTotalFacturaZ_B_Positivos_MonotributistasIva21);

		System.out.println("Total Factura Z Que son Factura B Positivos Consumidores Finales 21: "
				+ formattedTotalFacturaZ_B_Positivos_ConsumidoresFinales21 + " \tIVA\t "
				+ formattedTotalFacturaZ_B_Positivos_ConsumidoresFinalesIva21);

		System.out.println("Total Factura Z Que Son Factura A Positivos Exentos No Alcanzados 21: "
				+ formattedTotalFacturaZ_A_Positivos_ExentosNoAlcanzados21 + " \tIVA\t "
				+ formattedTotalFacturaZ_A_Positivos_ExentosNoAlcanzadosIva21);

		System.out.println("Total Factura Z Que son Factura B Positivos Exentos No Alcanzados 21: "
				+ formattedTotalFacturaZ_B_Positivos_ExentosNoAlcanzados21 + " \tIVA\t "
				+ formattedTotalFacturaZ_B_Positivos_ExentosNoAlcanzadosIva21);

		System.out.println("Operaciones con CF y EXENTOS NO ALCANZADOS 21: " + formattedOpCfExentos21 + " \tIVA\t "
				+ formattedOpCfExentosIva21);
		System.out.println("Operaciones con MON 21: " + formattedOpMon21 + " \tIVA\t " + formattedOpMonIva21);

		System.out.println("Total Factura Z Que Son Factura A Negativos Responsable Inscripto 21: "
				+ formattedTotalFacturaZ_A_Negativos_ResponsableInscripto21 + " \tIVA\t "
				+ formattedTotalFacturaZ_A_Negativos_ResponsableInscriptoIva21);

		System.out.println("Operaciones con responsables Inscriptos (Crédito) 21: " + formattedOpRiCredito21
				+ " \tIVA\t " + formattedOpRiCreditoIva21);

		System.out.println("Total Factura Z Que Son Factura A Negativos Monotributistas 21: "
				+ formattedTotalFacturaZ_A_Negativos_Monotributistas21 + " \tIVA\t "
				+ formattedTotalFacturaZ_A_Negativos_MonotributistasIva21);
		System.out.println("Total Factura Z Que Son Factura B Negativos Monotributistas 21: "
				+ formattedTotalFacturaZ_B_Negativos_Monotributistas21 + " \tIVA\t "
				+ formattedTotalFacturaZ_B_Negativos_MonotributistasIva21);

		System.out.println("Total Factura Z Que son Factura B Negativos Consumidores Finales 21: "
				+ formattedTotalFacturaZ_B_Negativos_ConsumidoresFinales21 + " \tIVA\t "
				+ formattedTotalFacturaZ_B_Negativos_ConsumidoresFinalesIva21);

		System.out.println("Total Factura Z Que Son Factura A Negativos Exentos No Alcanzados 21: "
				+ formattedTotalFacturaZ_A_Negativos_ExentosNoAlcanzados21 + " \tIVA\t "
				+ formattedTotalFacturaZ_A_Negativos_ExentosNoAlcanzadosIva21);

		System.out.println("Total Factura Z Que son Factura B Negativos Exentos No Alcanzados 21: "
				+ formattedTotalFacturaZ_B_Negativos_ExentosNoAlcanzados21 + " \tIVA\t "
				+ formattedTotalFacturaZ_B_Negativos_ExentosNoAlcanzadosIva21);

		System.out.println("Operaciones con CF, MON y EXENTOS NO ALCANZADOS (Crédito) 21: "
				+ formattedOpCfExentosMonCredito21 + " \tIVA\t " + formattedOpCfExentosMonCreditoIva21);

		String formattedTotalFacturaAResponsableInscriptoPositivos10_5 = String
				.format("%.2f", totalFacturaAResponsableInscriptoPositivos10_5).replace(".", ",");
		String formattedTotalFacturaAResponsableInscriptoNegativos10_5 = String
				.format("%.2f", totalFacturaAResponsableInscriptoNegativos10_5).replace(".", ",");
		String formattedTotalFacturaAResponsableInscripto10_5 = String
				.format("%.2f", totalFacturaAResponsableInscripto10_5).replace(".", ",");
		String formattedTotalFacturaAMonotributistaPositivos10_5 = String
				.format("%.2f", totalFacturaAMonotributistaPositivos10_5).replace(".", ",");
		String formattedTotalFacturaAMonotributistaNegativos10_5 = String
				.format("%.2f", totalFacturaAMonotributistaNegativos10_5).replace(".", ",");
		String formattedTotalFacturaAMonotributista10_5 = String.format("%.2f", totalFacturaAMonotributista10_5)
				.replace(".", ",");
		String formattedTotalFacturaAExentosNoAlcanzadosPositivos10_5 = String
				.format("%.2f", totalFacturaAExentosNoAlcanzadosPositivos10_5).replace(".", ",");
		String formattedTotalFacturaAExentosNoAlcanzadosNegativos10_5 = String
				.format("%.2f", totalFacturaAExentosNoAlcanzadosNegativos10_5).replace(".", ",");
		String formattedTotalFacturaAExentosNoAlcanzados10_5 = String
				.format("%.2f", totalFacturaAExentosNoAlcanzados10_5).replace(".", ",");
		String formattedTotalFacturaAPositivos10_5 = String.format("%.2f", totalFacturaAPositivos10_5).replace(".",
				",");
		String formattedTotalFacturaANegativos10_5 = String.format("%.2f", totalFacturaANegativos10_5).replace(".",
				",");
		String formattedTotalFacturaA10_5 = String.format("%.2f", totalFacturaA10_5).replace(".", ",");

		String formattedTotalFacturaBConsumidorFinalPositivos10_5 = String
				.format("%.2f", totalFacturaBConsumidorFinalPositivos10_5).replace(".", ",");
		String formattedTotalFacturaBConsumidorFinalNegativos10_5 = String
				.format("%.2f", totalFacturaBConsumidorFinalNegativos10_5).replace(".", ",");
		String formattedTotalFacturaBConsumidorFinal10_5 = String.format("%.2f", totalFacturaBConsumidorFinal10_5)
				.replace(".", ",");
		String formattedTotalFacturaBMonotributistaPositivos10_5 = String
				.format("%.2f", totalFacturaBMonotributistaPositivos10_5).replace(".", ",");
		String formattedTotalFacturaBMonotributistaNegativos10_5 = String
				.format("%.2f", totalFacturaBMonotributistaNegativos10_5).replace(".", ",");
		String formattedTotalFacturaBMonotributista10_5 = String.format("%.2f", totalFacturaBMonotributista10_5)
				.replace(".", ",");
		String formattedTotalFacturaBExentosNoAlcanzadosPositivos10_5 = String
				.format("%.2f", totalFacturaBExentosNoAlcanzadosPositivos10_5).replace(".", ",");
		String formattedTotalFacturaBExentosNoAlcanzadosNegativos10_5 = String
				.format("%.2f", totalFacturaBExentosNoAlcanzadosNegativos10_5).replace(".", ",");
		String formattedTotalFacturaBExentosNoAlcanzados10_5 = String
				.format("%.2f", totalFacturaBExentosNoAlcanzados10_5).replace(".", ",");
		String formattedTotalFacturaBPositivos10_5 = String.format("%.2f", totalFacturaBPositivos10_5).replace(".",
				",");
		String formattedTotalFacturaBNegativos10_5 = String.format("%.2f", totalFacturaBNegativos10_5).replace(".",
				",");
		String formattedTotalFacturaB10_5 = String.format("%.2f", totalFacturaB10_5).replace(".", ",");

		String formattedTotalFacturaZ_A_Positivos10_5 = String.format("%.2f", totalFacturaZ_A_Positivos10_5)
				.replace(".", ",");
		String formattedTotalFacturaZ_A_Negativos10_5 = String.format("%.2f", totalFacturaZ_A_Negativos10_5)
				.replace(".", ",");
		String formattedTotalFacturaZ_A10_5 = String.format("%.2f", totalFacturaZ_A10_5).replace(".", ",");
		String formattedTotalFacturaZ_B_Positivos10_5 = String.format("%.2f", totalFacturaZ_B_Positivos10_5)
				.replace(".", ",");
		String formattedTotalFacturaZ_B_Negativos10_5 = String.format("%.2f", totalFacturaZ_B_Negativos10_5)
				.replace(".", ",");
		String formattedTotalFacturaZ_B10_5 = String.format("%.2f", totalFacturaZ_B10_5).replace(".", ",");
		String formattedTotalFacturaZPositivos10_5 = String.format("%.2f", totalFacturaZPositivos10_5).replace(".",
				",");
		String formattedTotalFacturaZNegativos10_5 = String.format("%.2f", totalFacturaZNegativos10_5).replace(".",
				",");
		String formattedTotalFacturaZ10_5 = String.format("%.2f", totalFacturaZ10_5).replace(".", ",");

		String formattedTotalFacturaAPositivosFacturaZ_A_Positivos10_5 = String
				.format("%.2f", totalFacturaAPositivosFacturaZ_A_Positivos10_5).replace(".", ",");
		String formattedTotalFacturaANegativosFacturaZ_A_Negativos10_5 = String
				.format("%.2f", totalFacturaANegativosFacturaZ_A_Negativos10_5).replace(".", ",");
		String formattedTotalFacturaAFacturaZ_A10_5 = String.format("%.2f", totalFacturaAFacturaZ_A10_5).replace(".",
				",");
		String formattedTotalFacturaBPositivosFacturaZ_B_Positivos10_5 = String
				.format("%.2f", totalFacturaBPositivosFacturaZ_B_Positivos10_5).replace(".", ",");
		String formattedTotalFacturaBNegativosFacturaZ_B_Negativos10_5 = String
				.format("%.2f", totalFacturaBNegativosFacturaZ_B_Negativos10_5).replace(".", ",");
		String formattedTotalFacturaBFacturaZ_B10_5 = String.format("%.2f", totalFacturaBFacturaZ_B10_5).replace(".",
				",");

		String formattedTotalFacturaZ_A_Positivos_Monotributistas10_5 = String
				.format("%.2f", totalFacturaZ_A_Positivos_Monotributistas10_5).replace(".", ",");
		String formattedTotalFacturaZ_B_Positivos_Monotributistas10_5 = String
				.format("%.2f", totalFacturaZ_B_Positivos_Monotributistas10_5).replace(".", ",");
		String formattedTotalFacturaZ_B_Positivos_ConsumidoresFinales10_5 = String
				.format("%.2f", totalFacturaZ_B_Positivos_ConsumidoresFinales10_5).replace(".", ",");
		String formattedTotalFacturaZ_A_Positivos_ExentosNoAlcanzados10_5 = String
				.format("%.2f", totalFacturaZ_A_Positivos_ExentosNoAlcanzados10_5).replace(".", ",");
		String formattedTotalFacturaZ_B_Positivos_ExentosNoAlcanzados10_5 = String
				.format("%.2f", totalFacturaZ_B_Positivos_ExentosNoAlcanzados10_5).replace(".", ",");
		String formattedTotalFacturaZ_A_Positivos_ResponsableInscripto10_5 = String
				.format("%.2f", totalFacturaZ_A_Positivos_ResponsableInscripto10_5).replace(".", ",");

		String formattedTotalFacturaZ_A_Negativos_Monotributistas10_5 = String
				.format("%.2f", totalFacturaZ_A_Negativos_Monotributistas10_5).replace(".", ",");
		String formattedTotalFacturaZ_B_Negativos_Monotributistas10_5 = String
				.format("%.2f", totalFacturaZ_B_Negativos_Monotributistas10_5).replace(".", ",");
		String formattedTotalFacturaZ_B_Negativos_ConsumidoresFinales10_5 = String
				.format("%.2f", totalFacturaZ_B_Negativos_ConsumidoresFinales10_5).replace(".", ",");
		String formattedTotalFacturaZ_A_Negativos_ExentosNoAlcanzados10_5 = String
				.format("%.2f", totalFacturaZ_A_Negativos_ExentosNoAlcanzados10_5).replace(".", ",");
		String formattedTotalFacturaZ_B_Negativos_ExentosNoAlcanzados10_5 = String
				.format("%.2f", totalFacturaZ_B_Negativos_ExentosNoAlcanzados10_5).replace(".", ",");
		String formattedTotalFacturaZ_A_Negativos_ResponsableInscripto10_5 = String
				.format("%.2f", totalFacturaZ_A_Negativos_ResponsableInscripto10_5).replace(".", ",");

		String formattedOpRi10_5 = String.format("%.2f",
				totalFacturaAResponsableInscriptoPositivos10_5 + totalFacturaZ_A_Positivos_ResponsableInscripto10_5)
				.replace(".", ",");
		String formattedOpCfExentos10_5 = String.format("%.2f",
				totalFacturaZ_B_Positivos_ConsumidoresFinales10_5 + totalFacturaZ_A_Positivos_ExentosNoAlcanzados10_5
						+ totalFacturaZ_B_Positivos_ExentosNoAlcanzados10_5
						+ totalFacturaAExentosNoAlcanzadosPositivos10_5 + totalFacturaBConsumidorFinalPositivos10_5
						+ totalFacturaBExentosNoAlcanzadosPositivos10_5)
				.replace(".", ",");
		String formattedOpMon10_5 = String
				.format("%.2f",
						totalFacturaZ_A_Positivos_Monotributistas10_5 + totalFacturaZ_B_Positivos_Monotributistas10_5
								+ totalFacturaAMonotributistaPositivos10_5 + totalFacturaBMonotributistaPositivos10_5)
				.replace(".", ",");

		String formattedOpRiCredito10_5 = String.format("%.2f",
				totalFacturaAResponsableInscriptoNegativos10_5 + totalFacturaZ_A_Negativos_ResponsableInscripto10_5)
				.replace(".", ",");

		String formattedOpCfExentosMonCredito10_5 = String.format("%.2f",
				totalFacturaZ_B_Negativos_ConsumidoresFinales10_5 + totalFacturaZ_A_Negativos_ExentosNoAlcanzados10_5
						+ totalFacturaZ_B_Negativos_ExentosNoAlcanzados10_5
						+ totalFacturaAExentosNoAlcanzadosNegativos10_5 + totalFacturaBConsumidorFinalNegativos10_5
						+ totalFacturaBExentosNoAlcanzadosNegativos10_5 + totalFacturaZ_A_Negativos_Monotributistas10_5
						+ totalFacturaZ_B_Negativos_Monotributistas10_5 + totalFacturaAMonotributistaNegativos10_5
						+ totalFacturaBMonotributistaNegativos10_5)
				.replace(".", ",");

		String formattedTotalFacturaAResponsableInscriptoPositivosIva10_5 = String
				.format("%.2f", totalFacturaAResponsableInscriptoPositivosIva10_5).replace(".", ",");
		String formattedTotalFacturaAResponsableInscriptoNegativosIva10_5 = String
				.format("%.2f", totalFacturaAResponsableInscriptoNegativosIva10_5).replace(".", ",");
		String formattedTotalFacturaAResponsableInscriptoIva10_5 = String
				.format("%.2f", totalFacturaAResponsableInscriptoIva10_5).replace(".", ",");
		String formattedTotalFacturaAMonotributistaPositivosIva10_5 = String
				.format("%.2f", totalFacturaAMonotributistaPositivosIva10_5).replace(".", ",");
		String formattedTotalFacturaAMonotributistaNegativosIva10_5 = String
				.format("%.2f", totalFacturaAMonotributistaNegativosIva10_5).replace(".", ",");
		String formattedTotalFacturaAMonotributistaIva10_5 = String.format("%.2f", totalFacturaAMonotributistaIva10_5)
				.replace(".", ",");
		String formattedTotalFacturaAExentosNoAlcanzadosPositivosIva10_5 = String
				.format("%.2f", totalFacturaAExentosNoAlcanzadosPositivosIva10_5).replace(".", ",");
		String formattedTotalFacturaAExentosNoAlcanzadosNegativosIva10_5 = String
				.format("%.2f", totalFacturaAExentosNoAlcanzadosNegativosIva10_5).replace(".", ",");
		String formattedTotalFacturaAExentosNoAlcanzadosIva10_5 = String
				.format("%.2f", totalFacturaAExentosNoAlcanzadosIva10_5).replace(".", ",");
		String formattedTotalFacturaAPositivosIva10_5 = String.format("%.2f", totalFacturaAPositivosIva10_5)
				.replace(".", ",");
		String formattedTotalFacturaANegativosIva10_5 = String.format("%.2f", totalFacturaANegativosIva10_5)
				.replace(".", ",");
		String formattedTotalFacturaAIva10_5 = String.format("%.2f", totalFacturaAIva10_5).replace(".", ",");

		String formattedTotalFacturaBConsumidorFinalPositivosIva10_5 = String
				.format("%.2f", totalFacturaBConsumidorFinalPositivosIva10_5).replace(".", ",");
		String formattedTotalFacturaBConsumidorFinalNegativosIva10_5 = String
				.format("%.2f", totalFacturaBConsumidorFinalNegativosIva10_5).replace(".", ",");
		String formattedTotalFacturaBConsumidorFinalIva10_5 = String.format("%.2f", totalFacturaBConsumidorFinalIva10_5)
				.replace(".", ",");
		String formattedTotalFacturaBMonotributistaPositivosIva10_5 = String
				.format("%.2f", totalFacturaBMonotributistaPositivosIva10_5).replace(".", ",");
		String formattedTotalFacturaBMonotributistaNegativosIva10_5 = String
				.format("%.2f", totalFacturaBMonotributistaNegativosIva10_5).replace(".", ",");
		String formattedTotalFacturaBMonotributistaIva10_5 = String.format("%.2f", totalFacturaBMonotributistaIva10_5)
				.replace(".", ",");
		String formattedTotalFacturaBExentosNoAlcanzadosPositivosIva10_5 = String
				.format("%.2f", totalFacturaBExentosNoAlcanzadosPositivosIva10_5).replace(".", ",");
		String formattedTotalFacturaBExentosNoAlcanzadosNegativosIva10_5 = String
				.format("%.2f", totalFacturaBExentosNoAlcanzadosNegativosIva10_5).replace(".", ",");
		String formattedTotalFacturaBExentosNoAlcanzadosIva10_5 = String
				.format("%.2f", totalFacturaBExentosNoAlcanzadosIva10_5).replace(".", ",");
		String formattedTotalFacturaBPositivosIva10_5 = String.format("%.2f", totalFacturaBPositivosIva10_5)
				.replace(".", ",");
		String formattedTotalFacturaBNegativosIva10_5 = String.format("%.2f", totalFacturaBNegativosIva10_5)
				.replace(".", ",");
		String formattedTotalFacturaBIva10_5 = String.format("%.2f", totalFacturaBIva10_5).replace(".", ",");

		String formattedTotalFacturaZ_A_PositivosIva10_5 = String.format("%.2f", totalFacturaZ_A_PositivosIva10_5)
				.replace(".", ",");
		String formattedTotalFacturaZ_A_NegativosIva10_5 = String.format("%.2f", totalFacturaZ_A_NegativosIva10_5)
				.replace(".", ",");
		String formattedTotalFacturaZ_AIva10_5 = String.format("%.2f", totalFacturaZ_A_Iva10_5).replace(".", ",");
		String formattedTotalFacturaZ_B_PositivosIva10_5 = String.format("%.2f", totalFacturaZ_B_PositivosIva10_5)
				.replace(".", ",");
		String formattedTotalFacturaZ_B_NegativosIva10_5 = String.format("%.2f", totalFacturaZ_B_NegativosIva10_5)
				.replace(".", ",");
		String formattedTotalFacturaZ_BIva10_5 = String.format("%.2f", totalFacturaZ_B_Iva10_5).replace(".", ",");
		String formattedTotalFacturaZPositivosIva10_5 = String.format("%.2f", totalFacturaZPositivosIva10_5)
				.replace(".", ",");
		String formattedTotalFacturaZNegativosIva10_5 = String.format("%.2f", totalFacturaZNegativosIva10_5)
				.replace(".", ",");
		String formattedTotalFacturaZIva10_5 = String.format("%.2f", totalFacturaZIva10_5).replace(".", ",");

		String formattedTotalFacturaAPositivosFacturaZ_A_PositivosIva10_5 = String
				.format("%.2f", totalFacturaAPositivosFacturaZ_A_PositivosIva10_5).replace(".", ",");
		String formattedTotalFacturaANegativosFacturaZ_A_NegativosIva10_5 = String
				.format("%.2f", totalFacturaANegativosFacturaZ_A_NegativosIva10_5).replace(".", ",");
		String formattedTotalFacturaAFacturaZ_AIva10_5 = String.format("%.2f", totalFacturaAFacturaZ_AIva10_5)
				.replace(".", ",");
		String formattedTotalFacturaBPositivosFacturaZ_B_PositivosIva10_5 = String
				.format("%.2f", totalFacturaBPositivosFacturaZ_B_PositivosIva10_5).replace(".", ",");
		String formattedTotalFacturaBNegativosFacturaZ_B_NegativosIva10_5 = String
				.format("%.2f", totalFacturaBNegativosFacturaZ_B_NegativosIva10_5).replace(".", ",");
		String formattedTotalFacturaBFacturaZ_BIva10_5 = String.format("%.2f", totalFacturaBFacturaZ_BIva10_5)
				.replace(".", ",");

		String formattedTotalFacturaZ_A_Positivos_MonotributistasIva10_5 = String
				.format("%.2f", totalFacturaZ_A_Positivos_MonotributistasIva10_5).replace(".", ",");
		String formattedTotalFacturaZ_B_Positivos_MonotributistasIva10_5 = String
				.format("%.2f", totalFacturaZ_B_Positivos_MonotributistasIva10_5).replace(".", ",");
		String formattedTotalFacturaZ_B_Positivos_ConsumidoresFinalesIva10_5 = String
				.format("%.2f", totalFacturaZ_B_Positivos_ConsumidoresFinalesIva10_5).replace(".", ",");
		String formattedTotalFacturaZ_A_Positivos_ExentosNoAlcanzadosIva10_5 = String
				.format("%.2f", totalFacturaZ_A_Positivos_ExentosNoAlcanzadosIva10_5).replace(".", ",");
		String formattedTotalFacturaZ_B_Positivos_ExentosNoAlcanzadosIva10_5 = String
				.format("%.2f", totalFacturaZ_B_Positivos_ExentosNoAlcanzadosIva10_5).replace(".", ",");
		String formattedTotalFacturaZ_A_Positivos_ResponsableInscriptoIva10_5 = String
				.format("%.2f", totalFacturaZ_A_Positivos_ResponsableInscriptoIva10_5).replace(".", ",");

		String formattedTotalFacturaZ_A_Negativos_MonotributistasIva10_5 = String
				.format("%.2f", totalFacturaZ_A_Negativos_MonotributistasIva10_5).replace(".", ",");
		String formattedTotalFacturaZ_B_Negativos_MonotributistasIva10_5 = String
				.format("%.2f", totalFacturaZ_B_Negativos_MonotributistasIva10_5).replace(".", ",");
		String formattedTotalFacturaZ_B_Negativos_ConsumidoresFinalesIva10_5 = String
				.format("%.2f", totalFacturaZ_B_Negativos_ConsumidoresFinalesIva10_5).replace(".", ",");
		String formattedTotalFacturaZ_A_Negativos_ExentosNoAlcanzadosIva10_5 = String
				.format("%.2f", totalFacturaZ_A_Negativos_ExentosNoAlcanzadosIva10_5).replace(".", ",");
		String formattedTotalFacturaZ_B_Negativos_ExentosNoAlcanzadosIva10_5 = String
				.format("%.2f", totalFacturaZ_B_Negativos_ExentosNoAlcanzadosIva10_5).replace(".", ",");
		String formattedTotalFacturaZ_A_Negativos_ResponsableInscriptoIva10_5 = String
				.format("%.2f", totalFacturaZ_A_Negativos_ResponsableInscriptoIva10_5).replace(".", ",");

		String formattedOpRiIva10_5 = String.format("%.2f", totalFacturaAResponsableInscriptoPositivosIva10_5
				+ totalFacturaZ_A_Positivos_ResponsableInscriptoIva10_5).replace(".", ",");
		String formattedOpCfExentosIva10_5 = String
				.format("%.2f", totalFacturaZ_B_Positivos_ConsumidoresFinalesIva10_5
						+ totalFacturaZ_A_Positivos_ExentosNoAlcanzadosIva10_5
						+ totalFacturaZ_B_Positivos_ExentosNoAlcanzadosIva10_5
						+ totalFacturaAExentosNoAlcanzadosPositivosIva10_5
						+ totalFacturaBConsumidorFinalPositivosIva10_5 + totalFacturaBExentosNoAlcanzadosPositivos10_5)
				.replace(".", ",");
		String formattedOpMonIva10_5 = String.format("%.2f",
				totalFacturaZ_A_Positivos_MonotributistasIva10_5 + totalFacturaZ_B_Positivos_MonotributistasIva10_5
						+ totalFacturaAMonotributistaPositivosIva10_5 + totalFacturaBMonotributistaPositivosIva10_5)
				.replace(".", ",");

		String formattedOpRiCreditoIva10_5 = String.format("%.2f", totalFacturaAResponsableInscriptoNegativosIva10_5
				+ totalFacturaZ_A_Negativos_ResponsableInscriptoIva10_5).replace(".", ",");

		String formattedOpCfExentosMonCreditoIva10_5 = String.format("%.2f",
				totalFacturaZ_B_Negativos_ConsumidoresFinalesIva10_5
						+ totalFacturaZ_A_Negativos_ExentosNoAlcanzadosIva10_5
						+ totalFacturaZ_B_Negativos_ExentosNoAlcanzadosIva10_5
						+ totalFacturaAExentosNoAlcanzadosNegativosIva10_5
						+ totalFacturaBConsumidorFinalNegativosIva10_5
						+ totalFacturaBExentosNoAlcanzadosNegativosIva10_5
						+ totalFacturaZ_A_Negativos_MonotributistasIva10_5
						+ totalFacturaZ_B_Negativos_MonotributistasIva10_5 + totalFacturaAMonotributistaNegativosIva10_5
						+ totalFacturaBMonotributistaNegativosIva10_5)
				.replace(".", ",");

		// Mostrar los resultados formateados

		System.out.println(ANSI_CYAN + "\nPunto de venta: " + puntoDeVenta + ANSI_RESET);

		System.out.println("\nTotales acumulados Neto Gravado con IVA 10,5:");

		System.out.println("\nFacturas A 10,5");

		System.out.println("Total Factura A Responsable Inscripto (RI) Positivos 10,5: "
				+ formattedTotalFacturaAResponsableInscriptoPositivos10_5 + " \tIVA\t "
				+ formattedTotalFacturaAResponsableInscriptoPositivosIva10_5);
		System.out.println("Total Factura A Responsable Inscripto (RI) Negativos 10,5: "
				+ formattedTotalFacturaAResponsableInscriptoNegativos10_5 + " \tIVA\t "
				+ formattedTotalFacturaAResponsableInscriptoNegativosIva10_5);
		System.out.println(
				"Total Factura A Responsable Inscripto (RI) 10,5: " + formattedTotalFacturaAResponsableInscripto10_5
						+ " \tIVA\t " + formattedTotalFacturaAResponsableInscriptoIva10_5);
		System.out.println(
				"Total Factura A Monotributista Positivos 10,5: " + formattedTotalFacturaAMonotributistaPositivos10_5
						+ " \tIVA\t " + formattedTotalFacturaAMonotributistaPositivosIva10_5);
		System.out.println(
				"Total Factura A Monotributista Negativos 10,5: " + formattedTotalFacturaAMonotributistaNegativos10_5
						+ " \tIVA\t " + formattedTotalFacturaAMonotributistaNegativosIva10_5);
		System.out.println("Total Factura A Monotributista 10,5: " + formattedTotalFacturaAMonotributista10_5
				+ " \tIVA\t " + formattedTotalFacturaAMonotributistaIva10_5);
		System.out.println("Total Factura A Exentos No Alcanzados Positivos 10,5: "
				+ formattedTotalFacturaAExentosNoAlcanzadosPositivos10_5 + " \tIVA\t "
				+ formattedTotalFacturaAExentosNoAlcanzadosPositivosIva10_5);
		System.out.println("Total Factura A Exentos No Alcanzados Negativos 10,5: "
				+ formattedTotalFacturaAExentosNoAlcanzadosNegativos10_5 + " \tIVA\t "
				+ formattedTotalFacturaAExentosNoAlcanzadosNegativosIva10_5);
		System.out
				.println("Total Factura A Exentos No Alcanzados 10,5: " + formattedTotalFacturaAExentosNoAlcanzados10_5
						+ " \tIVA\t " + formattedTotalFacturaAExentosNoAlcanzadosIva10_5);
		System.out.println("Total Factura A Positivos (sin Facturas Z positivas) 10,5: "
				+ formattedTotalFacturaAPositivos10_5 + " \tIVA\t " + formattedTotalFacturaAPositivosIva10_5);
		System.out.println("Total Factura A Negativos (sin Facturas Z negativas) 10,5: "
				+ formattedTotalFacturaANegativos10_5 + " \tIVA\t " + formattedTotalFacturaANegativosIva10_5);
		System.out.println("Total Factura A (sin Facturas Z) 10,5: " + formattedTotalFacturaA10_5 + " \tIVA\t "
				+ formattedTotalFacturaAIva10_5);

		System.out.println("\nFacturas B 10,5");

		System.out.println(
				"Total Factura B Consumidor Final Positivos 10,5: " + formattedTotalFacturaBConsumidorFinalPositivos10_5
						+ " \tIVA\t " + formattedTotalFacturaBConsumidorFinalPositivosIva10_5);
		System.out.println(
				"Total Factura B Consumidor Final Negativos 10,5: " + formattedTotalFacturaBConsumidorFinalNegativos10_5
						+ " \tIVA\t " + formattedTotalFacturaBConsumidorFinalNegativosIva10_5);
		System.out.println("Total Factura B Consumidor Final 10,5: " + formattedTotalFacturaBConsumidorFinal10_5
				+ " \tIVA\t " + formattedTotalFacturaBConsumidorFinalIva10_5);
		System.out.println(
				"Total Factura B Monotributista Positivos 10,5: " + formattedTotalFacturaBMonotributistaPositivos10_5
						+ " \tIVA\t " + formattedTotalFacturaBMonotributistaPositivosIva10_5);
		System.out.println(
				"Total Factura B Monotributista Negativos 10,5: " + formattedTotalFacturaBMonotributistaNegativos10_5
						+ " \tIVA\t " + formattedTotalFacturaBMonotributistaNegativosIva10_5);
		System.out.println("Total Factura B Monotributista 10,5: " + formattedTotalFacturaBMonotributista10_5
				+ " \tIVA\t " + formattedTotalFacturaBMonotributistaIva10_5);
		System.out.println("Total Factura B Exentos No Alcanzados Positivos 10,5: "
				+ formattedTotalFacturaBExentosNoAlcanzadosPositivos10_5 + " \tIVA\t "
				+ formattedTotalFacturaBExentosNoAlcanzadosPositivosIva10_5);
		System.out.println("Total Factura B Exentos No Alcanzados Negativos 10,5: "
				+ formattedTotalFacturaBExentosNoAlcanzadosNegativos10_5 + " \tIVA\t "
				+ formattedTotalFacturaBExentosNoAlcanzadosNegativosIva10_5);
		System.out
				.println("Total Factura B Exentos No Alcanzados 10,5: " + formattedTotalFacturaBExentosNoAlcanzados10_5
						+ " \tIVA\t " + formattedTotalFacturaBExentosNoAlcanzadosIva10_5);
		System.out.println("Total Factura B Positivos (sin Facturas Z positivas) 10,5: "
				+ formattedTotalFacturaBPositivos10_5 + " \tIVA\t " + formattedTotalFacturaBPositivosIva10_5);
		System.out.println("Total Factura B Negativos (sin Facturas Z negativas) 10,5: "
				+ formattedTotalFacturaBNegativos10_5 + " \tIVA\t " + formattedTotalFacturaBNegativosIva10_5);
		System.out.println("Total Factura B (sin facturas Z) 10,5: " + formattedTotalFacturaB10_5 + " \tIVA\t "
				+ formattedTotalFacturaBIva10_5);

		System.out.println("\nFacturas Z 10,5");

		System.out.println("Total Factura Z Que Son Factura A Positivos 10,5: " + formattedTotalFacturaZ_A_Positivos10_5
				+ " \tIVA\t " + formattedTotalFacturaZ_A_PositivosIva10_5);
		System.out.println("Total Factura Z Que Son Factura A Negativos 10,5S: "
				+ formattedTotalFacturaZ_A_Negativos10_5 + " \tIVA\t " + formattedTotalFacturaZ_A_NegativosIva10_5);
		System.out.println("Total Factura Z Que Son Factura A 10,5: " + formattedTotalFacturaZ_A10_5 + " \tIVA\t "
				+ formattedTotalFacturaZ_AIva10_5);
		System.out.println("Total Factura Z Que Son Factura B Positivos 10,5: " + formattedTotalFacturaZ_B_Positivos10_5
				+ " \tIVA\t " + formattedTotalFacturaZ_B_PositivosIva10_5);
		System.out.println("Total Factura Z Que Son Factura B Negativos 10,5: " + formattedTotalFacturaZ_B_Negativos10_5
				+ " \tIVA\t " + formattedTotalFacturaZ_B_NegativosIva10_5);
		System.out.println("Total Factura Z Que Son Factura B 10,5: " + formattedTotalFacturaZ_B10_5 + " \tIVA\t "
				+ formattedTotalFacturaZ_BIva10_5);
		System.out.println("Total Factura Z Positivos 10,5: " + formattedTotalFacturaZPositivos10_5 + " \tIVA\t "
				+ formattedTotalFacturaZPositivosIva10_5);
		System.out.println("Total Factura Z Negativos 10,5: " + formattedTotalFacturaZNegativos10_5 + " \tIVA\t "
				+ formattedTotalFacturaZNegativosIva10_5);
		System.out.println(
				"Total Factura Z  10,5: " + formattedTotalFacturaZ10_5 + " \tIVA\t " + formattedTotalFacturaZIva10_5);

		System.out.println("Total Factura A Positivos (con Facturas Z que son A Positivos)  10,5: "
				+ formattedTotalFacturaAPositivosFacturaZ_A_Positivos10_5 + " \tIVA\t "
				+ formattedTotalFacturaAPositivosFacturaZ_A_PositivosIva10_5);
		System.out.println("Total Factura A Negativos (con Facturas Z que son A Negativos)  10,5: "
				+ formattedTotalFacturaANegativosFacturaZ_A_Negativos10_5 + " \tIVA\t "
				+ formattedTotalFacturaANegativosFacturaZ_A_NegativosIva10_5);
		System.out.println("Total Factura A (con Facturas Z que son A) 10,5: " + formattedTotalFacturaAFacturaZ_A10_5
				+ " \tIVA\t " + formattedTotalFacturaAFacturaZ_AIva10_5);

		System.out.println("Total Factura B Positivos (con Facturas Z que son B Positivos) 10,5: "
				+ formattedTotalFacturaBPositivosFacturaZ_B_Positivos10_5 + " \tIVA\t "
				+ formattedTotalFacturaBPositivosFacturaZ_B_PositivosIva10_5);
		System.out.println("Total Factura B Negativos (con Facturas Z que son B Negativos) 10,5: "
				+ formattedTotalFacturaBNegativosFacturaZ_B_Negativos10_5 + " \tIVA\t "
				+ formattedTotalFacturaBNegativosFacturaZ_B_NegativosIva10_5);
		System.out.println("Total Factura B (con Facturas Z que son B) 10,5: " + formattedTotalFacturaBFacturaZ_B10_5
				+ " \tIVA\t " + formattedTotalFacturaBFacturaZ_BIva10_5);

		System.out.println("Total Factura Z Que Son Factura A Positivos Responsable Inscripto 10,5: "
				+ formattedTotalFacturaZ_A_Positivos_ResponsableInscripto10_5 + " \tIVA\t "
				+ formattedTotalFacturaZ_A_Positivos_ResponsableInscriptoIva10_5);
		System.out.println("Operaciones con responsables Inscriptos) 10,5: " + formattedOpRi10_5 + " \tIVA\t "
				+ formattedOpRiIva10_5);

		System.out.println("Total Factura Z Que Son Factura A Positivos Monotributistas 10,5: "
				+ formattedTotalFacturaZ_A_Positivos_Monotributistas10_5 + " \tIVA\t "
				+ formattedTotalFacturaZ_A_Positivos_MonotributistasIva10_5);
		System.out.println("Total Factura Z Que Son Factura B Positivos Monotributistas 10,5: "
				+ formattedTotalFacturaZ_B_Positivos_Monotributistas10_5 + " \tIVA\t "
				+ formattedTotalFacturaZ_B_Positivos_MonotributistasIva10_5);

		System.out.println("Total Factura Z Que son Factura B Positivos Consumidores Finales 10,5: "
				+ formattedTotalFacturaZ_B_Positivos_ConsumidoresFinales10_5 + " \tIVA\t "
				+ formattedTotalFacturaZ_B_Positivos_ConsumidoresFinalesIva10_5);

		System.out.println("Total Factura Z Que Son Factura A Positivos Exentos No Alcanzados 10,5: "
				+ formattedTotalFacturaZ_A_Positivos_ExentosNoAlcanzados10_5 + " \tIVA\t "
				+ formattedTotalFacturaZ_A_Positivos_ExentosNoAlcanzadosIva10_5);

		System.out.println("Total Factura Z Que son Factura B Positivos Exentos No Alcanzados 10,5: "
				+ formattedTotalFacturaZ_B_Positivos_ExentosNoAlcanzados10_5 + " \tIVA\t "
				+ formattedTotalFacturaZ_B_Positivos_ExentosNoAlcanzadosIva10_5);

		System.out.println("Operaciones con CF y EXENTOS NO ALCANZADOS 10,5: " + formattedOpCfExentos10_5 + " \tIVA\t "
				+ formattedOpCfExentosIva10_5);
		System.out.println("Operaciones con MON 10,5: " + formattedOpMon10_5 + " \tIVA\t " + formattedOpMonIva10_5);

		System.out.println("Total Factura Z Que Son Factura A Negativos Responsable Inscripto 10,5: "
				+ formattedTotalFacturaZ_A_Negativos_ResponsableInscripto10_5 + " \tIVA\t "
				+ formattedTotalFacturaZ_A_Negativos_ResponsableInscriptoIva10_5);

		System.out.println("Operaciones con responsables Inscriptos (Crédito) 10,5: " + formattedOpRiCredito10_5
				+ " \tIVA\t " + formattedOpRiCreditoIva10_5);

		System.out.println("Total Factura Z Que Son Factura A Negativos Monotributistas 10,5: "
				+ formattedTotalFacturaZ_A_Negativos_Monotributistas10_5 + " \tIVA\t "
				+ formattedTotalFacturaZ_A_Negativos_MonotributistasIva10_5);
		System.out.println("Total Factura Z Que Son Factura B Negativos Monotributistas 10,5: "
				+ formattedTotalFacturaZ_B_Negativos_Monotributistas10_5 + " \tIVA\t "
				+ formattedTotalFacturaZ_B_Negativos_MonotributistasIva10_5);

		System.out.println("Total Factura Z Que son Factura B Negativos Consumidores Finales 10,5: "
				+ formattedTotalFacturaZ_B_Negativos_ConsumidoresFinales10_5 + " \tIVA\t "
				+ formattedTotalFacturaZ_B_Negativos_ConsumidoresFinalesIva10_5);

		System.out.println("Total Factura Z Que Son Factura A Negativos Exentos No Alcanzados 10,5: "
				+ formattedTotalFacturaZ_A_Negativos_ExentosNoAlcanzados10_5 + " \tIVA\t "
				+ formattedTotalFacturaZ_A_Negativos_ExentosNoAlcanzadosIva10_5);

		System.out.println("Total Factura Z Que son Factura B Negativos Exentos No Alcanzados 10,5: "
				+ formattedTotalFacturaZ_B_Negativos_ExentosNoAlcanzados10_5 + " \tIVA\t "
				+ formattedTotalFacturaZ_B_Negativos_ExentosNoAlcanzadosIva10_5);

		System.out.println("Operaciones con CF, MON y EXENTOS NO ALCANZADOS (Crédito) 10,5: "
				+ formattedOpCfExentosMonCredito10_5 + " \tIVA\t " + formattedOpCfExentosMonCreditoIva10_5);

		String formattedTotalFacturaAResponsableInscriptoPositivos27 = String
				.format("%.2f", totalFacturaAResponsableInscriptoPositivos27).replace(".", ",");
		String formattedTotalFacturaAResponsableInscriptoNegativos27 = String
				.format("%.2f", totalFacturaAResponsableInscriptoNegativos27).replace(".", ",");
		String formattedTotalFacturaAResponsableInscripto27 = String.format("%.2f", totalFacturaAResponsableInscripto27)
				.replace(".", ",");
		String formattedTotalFacturaAMonotributistaPositivos27 = String
				.format("%.2f", totalFacturaAMonotributistaPositivos27).replace(".", ",");
		String formattedTotalFacturaAMonotributistaNegativos27 = String
				.format("%.2f", totalFacturaAMonotributistaNegativos27).replace(".", ",");
		String formattedTotalFacturaAMonotributista27 = String.format("%.2f", totalFacturaAMonotributista27)
				.replace(".", ",");
		String formattedTotalFacturaAExentosNoAlcanzadosPositivos27 = String
				.format("%.2f", totalFacturaAExentosNoAlcanzadosPositivos27).replace(".", ",");
		String formattedTotalFacturaAExentosNoAlcanzadosNegativos27 = String
				.format("%.2f", totalFacturaAExentosNoAlcanzadosNegativos27).replace(".", ",");
		String formattedTotalFacturaAExentosNoAlcanzados27 = String.format("%.2f", totalFacturaAExentosNoAlcanzados27)
				.replace(".", ",");
		String formattedTotalFacturaAPositivos27 = String.format("%.2f", totalFacturaAPositivos27).replace(".", ",");
		String formattedTotalFacturaANegativos27 = String.format("%.2f", totalFacturaANegativos27).replace(".", ",");
		String formattedTotalFacturaA27 = String.format("%.2f", totalFacturaA27).replace(".", ",");

		String formattedTotalFacturaBConsumidorFinalPositivos27 = String
				.format("%.2f", totalFacturaBConsumidorFinalPositivos27).replace(".", ",");
		String formattedTotalFacturaBConsumidorFinalNegativos27 = String
				.format("%.2f", totalFacturaBConsumidorFinalNegativos27).replace(".", ",");
		String formattedTotalFacturaBConsumidorFinal27 = String.format("%.2f", totalFacturaBConsumidorFinal27)
				.replace(".", ",");
		String formattedTotalFacturaBMonotributistaPositivos27 = String
				.format("%.2f", totalFacturaBMonotributistaPositivos27).replace(".", ",");
		String formattedTotalFacturaBMonotributistaNegativos27 = String
				.format("%.2f", totalFacturaBMonotributistaNegativos27).replace(".", ",");
		String formattedTotalFacturaBMonotributista27 = String.format("%.2f", totalFacturaBMonotributista27)
				.replace(".", ",");
		String formattedTotalFacturaBExentosNoAlcanzadosPositivos27 = String
				.format("%.2f", totalFacturaBExentosNoAlcanzadosPositivos27).replace(".", ",");
		String formattedTotalFacturaBExentosNoAlcanzadosNegativos27 = String
				.format("%.2f", totalFacturaBExentosNoAlcanzadosNegativos27).replace(".", ",");
		String formattedTotalFacturaBExentosNoAlcanzados27 = String.format("%.2f", totalFacturaBExentosNoAlcanzados27)
				.replace(".", ",");
		String formattedTotalFacturaBPositivos27 = String.format("%.2f", totalFacturaBPositivos27).replace(".", ",");
		String formattedTotalFacturaBNegativos27 = String.format("%.2f", totalFacturaBNegativos27).replace(".", ",");
		String formattedTotalFacturaB27 = String.format("%.2f", totalFacturaB27).replace(".", ",");

		String formattedTotalFacturaZ_A_Positivos27 = String.format("%.2f", totalFacturaZ_A_Positivos27).replace(".",
				",");
		String formattedTotalFacturaZ_A_Negativos27 = String.format("%.2f", totalFacturaZ_A_Negativos27).replace(".",
				",");
		String formattedTotalFacturaZ_A27 = String.format("%.2f", totalFacturaZ_A27).replace(".", ",");
		String formattedTotalFacturaZ_B_Positivos27 = String.format("%.2f", totalFacturaZ_B_Positivos27).replace(".",
				",");
		String formattedTotalFacturaZ_B_Negativos27 = String.format("%.2f", totalFacturaZ_B_Negativos27).replace(".",
				",");
		String formattedTotalFacturaZ_B27 = String.format("%.2f", totalFacturaZ_B27).replace(".", ",");
		String formattedTotalFacturaZPositivos27 = String.format("%.2f", totalFacturaZPositivos27).replace(".", ",");
		String formattedTotalFacturaZNegativos27 = String.format("%.2f", totalFacturaZNegativos27).replace(".", ",");
		String formattedTotalFacturaZ27 = String.format("%.2f", totalFacturaZ27).replace(".", ",");

		String formattedTotalFacturaAPositivosFacturaZ_A_Positivos27 = String
				.format("%.2f", totalFacturaAPositivosFacturaZ_A_Positivos27).replace(".", ",");
		String formattedTotalFacturaANegativosFacturaZ_A_Negativos27 = String
				.format("%.2f", totalFacturaANegativosFacturaZ_A_Negativos27).replace(".", ",");
		String formattedTotalFacturaAFacturaZ_A27 = String.format("%.2f", totalFacturaAFacturaZ_A27).replace(".", ",");
		String formattedTotalFacturaBPositivosFacturaZ_B_Positivos27 = String
				.format("%.2f", totalFacturaBPositivosFacturaZ_B_Positivos27).replace(".", ",");
		String formattedTotalFacturaBNegativosFacturaZ_B_Negativos27 = String
				.format("%.2f", totalFacturaBNegativosFacturaZ_B_Negativos27).replace(".", ",");
		String formattedTotalFacturaBFacturaZ_B27 = String.format("%.2f", totalFacturaBFacturaZ_B27).replace(".", ",");

		String formattedTotalFacturaZ_A_Positivos_Monotributistas27 = String
				.format("%.2f", totalFacturaZ_A_Positivos_Monotributistas27).replace(".", ",");
		String formattedTotalFacturaZ_B_Positivos_Monotributistas27 = String
				.format("%.2f", totalFacturaZ_B_Positivos_Monotributistas27).replace(".", ",");
		String formattedTotalFacturaZ_B_Positivos_ConsumidoresFinales27 = String
				.format("%.2f", totalFacturaZ_B_Positivos_ConsumidoresFinales27).replace(".", ",");
		String formattedTotalFacturaZ_A_Positivos_ExentosNoAlcanzados27 = String
				.format("%.2f", totalFacturaZ_A_Positivos_ExentosNoAlcanzados27).replace(".", ",");
		String formattedTotalFacturaZ_B_Positivos_ExentosNoAlcanzados27 = String
				.format("%.2f", totalFacturaZ_B_Positivos_ExentosNoAlcanzados27).replace(".", ",");
		String formattedTotalFacturaZ_A_Positivos_ResponsableInscripto27 = String
				.format("%.2f", totalFacturaZ_A_Positivos_ResponsableInscripto27).replace(".", ",");

		String formattedTotalFacturaZ_A_Negativos_Monotributistas27 = String
				.format("%.2f", totalFacturaZ_A_Negativos_Monotributistas27).replace(".", ",");
		String formattedTotalFacturaZ_B_Negativos_Monotributistas27 = String
				.format("%.2f", totalFacturaZ_B_Negativos_Monotributistas27).replace(".", ",");
		String formattedTotalFacturaZ_B_Negativos_ConsumidoresFinales27 = String
				.format("%.2f", totalFacturaZ_B_Negativos_ConsumidoresFinales27).replace(".", ",");
		String formattedTotalFacturaZ_A_Negativos_ExentosNoAlcanzados27 = String
				.format("%.2f", totalFacturaZ_A_Negativos_ExentosNoAlcanzados27).replace(".", ",");
		String formattedTotalFacturaZ_B_Negativos_ExentosNoAlcanzados27 = String
				.format("%.2f", totalFacturaZ_B_Negativos_ExentosNoAlcanzados27).replace(".", ",");
		String formattedTotalFacturaZ_A_Negativos_ResponsableInscripto27 = String
				.format("%.2f", totalFacturaZ_A_Negativos_ResponsableInscripto27).replace(".", ",");

		String formattedOpRi27 = String
				.format("%.2f",
						totalFacturaAResponsableInscriptoPositivos27 + totalFacturaZ_A_Positivos_ResponsableInscripto27)
				.replace(".", ",");
		String formattedOpCfExentos27 = String.format("%.2f",
				totalFacturaZ_B_Positivos_ConsumidoresFinales27 + totalFacturaZ_A_Positivos_ExentosNoAlcanzados27
						+ totalFacturaZ_B_Positivos_ExentosNoAlcanzados27 + totalFacturaAExentosNoAlcanzadosPositivos27
						+ totalFacturaBConsumidorFinalPositivos27 + totalFacturaBExentosNoAlcanzadosPositivos27)
				.replace(".", ",");
		String formattedOpMon27 = String
				.format("%.2f",
						totalFacturaZ_A_Positivos_Monotributistas27 + totalFacturaZ_B_Positivos_Monotributistas27
								+ totalFacturaAMonotributistaPositivos27 + totalFacturaBMonotributistaPositivos27)
				.replace(".", ",");

		String formattedOpRiCredito27 = String
				.format("%.2f",
						totalFacturaAResponsableInscriptoNegativos27 + totalFacturaZ_A_Negativos_ResponsableInscripto27)
				.replace(".", ",");

		String formattedOpCfExentosMonCredito27 = String.format("%.2f",
				totalFacturaZ_B_Negativos_ConsumidoresFinales27 + totalFacturaZ_A_Negativos_ExentosNoAlcanzados27
						+ totalFacturaZ_B_Negativos_ExentosNoAlcanzados27 + totalFacturaAExentosNoAlcanzadosNegativos27
						+ totalFacturaBConsumidorFinalNegativos27 + totalFacturaBExentosNoAlcanzadosNegativos27
						+ totalFacturaZ_A_Negativos_Monotributistas27 + totalFacturaZ_B_Negativos_Monotributistas27
						+ totalFacturaAMonotributistaNegativos27 + totalFacturaBMonotributistaNegativos27)
				.replace(".", ",");

		String formattedTotalFacturaAResponsableInscriptoPositivosIva27 = String
				.format("%.2f", totalFacturaAResponsableInscriptoPositivosIva27).replace(".", ",");
		String formattedTotalFacturaAResponsableInscriptoNegativosIva27 = String
				.format("%.2f", totalFacturaAResponsableInscriptoNegativosIva27).replace(".", ",");
		String formattedTotalFacturaAResponsableInscriptoIva27 = String
				.format("%.2f", totalFacturaAResponsableInscriptoIva27).replace(".", ",");
		String formattedTotalFacturaAMonotributistaPositivosIva27 = String
				.format("%.2f", totalFacturaAMonotributistaPositivosIva27).replace(".", ",");
		String formattedTotalFacturaAMonotributistaNegativosIva27 = String
				.format("%.2f", totalFacturaAMonotributistaNegativosIva27).replace(".", ",");
		String formattedTotalFacturaAMonotributistaIva27 = String.format("%.2f", totalFacturaAMonotributistaIva27)
				.replace(".", ",");
		String formattedTotalFacturaAExentosNoAlcanzadosPositivosIva27 = String
				.format("%.2f", totalFacturaAExentosNoAlcanzadosPositivosIva27).replace(".", ",");
		String formattedTotalFacturaAExentosNoAlcanzadosNegativosIva27 = String
				.format("%.2f", totalFacturaAExentosNoAlcanzadosNegativosIva27).replace(".", ",");
		String formattedTotalFacturaAExentosNoAlcanzadosIva27 = String
				.format("%.2f", totalFacturaAExentosNoAlcanzadosIva27).replace(".", ",");
		String formattedTotalFacturaAPositivosIva27 = String.format("%.2f", totalFacturaAPositivosIva27).replace(".",
				",");
		String formattedTotalFacturaANegativosIva27 = String.format("%.2f", totalFacturaANegativosIva27).replace(".",
				",");
		String formattedTotalFacturaAIva27 = String.format("%.2f", totalFacturaAIva27).replace(".", ",");

		String formattedTotalFacturaBConsumidorFinalPositivosIva27 = String
				.format("%.2f", totalFacturaBConsumidorFinalPositivosIva27).replace(".", ",");
		String formattedTotalFacturaBConsumidorFinalNegativosIva27 = String
				.format("%.2f", totalFacturaBConsumidorFinalNegativosIva27).replace(".", ",");
		String formattedTotalFacturaBConsumidorFinalIva27 = String.format("%.2f", totalFacturaBConsumidorFinalIva27)
				.replace(".", ",");
		String formattedTotalFacturaBMonotributistaPositivosIva27 = String
				.format("%.2f", totalFacturaBMonotributistaPositivosIva27).replace(".", ",");
		String formattedTotalFacturaBMonotributistaNegativosIva27 = String
				.format("%.2f", totalFacturaBMonotributistaNegativosIva27).replace(".", ",");
		String formattedTotalFacturaBMonotributistaIva27 = String.format("%.2f", totalFacturaBMonotributistaIva27)
				.replace(".", ",");
		String formattedTotalFacturaBExentosNoAlcanzadosPositivosIva27 = String
				.format("%.2f", totalFacturaBExentosNoAlcanzadosPositivosIva27).replace(".", ",");
		String formattedTotalFacturaBExentosNoAlcanzadosNegativosIva27 = String
				.format("%.2f", totalFacturaBExentosNoAlcanzadosNegativosIva27).replace(".", ",");
		String formattedTotalFacturaBExentosNoAlcanzadosIva27 = String
				.format("%.2f", totalFacturaBExentosNoAlcanzadosIva27).replace(".", ",");
		String formattedTotalFacturaBPositivosIva27 = String.format("%.2f", totalFacturaBPositivosIva27).replace(".",
				",");
		String formattedTotalFacturaBNegativosIva27 = String.format("%.2f", totalFacturaBNegativosIva27).replace(".",
				",");
		String formattedTotalFacturaBIva27 = String.format("%.2f", totalFacturaBIva27).replace(".", ",");

		String formattedTotalFacturaZ_A_PositivosIva27 = String.format("%.2f", totalFacturaZ_A_PositivosIva27)
				.replace(".", ",");
		String formattedTotalFacturaZ_A_NegativosIva27 = String.format("%.2f", totalFacturaZ_A_NegativosIva27)
				.replace(".", ",");
		String formattedTotalFacturaZ_AIva27 = String.format("%.2f", totalFacturaZ_A_Iva27).replace(".", ",");
		String formattedTotalFacturaZ_B_PositivosIva27 = String.format("%.2f", totalFacturaZ_B_PositivosIva27)
				.replace(".", ",");
		String formattedTotalFacturaZ_B_NegativosIva27 = String.format("%.2f", totalFacturaZ_B_NegativosIva27)
				.replace(".", ",");
		String formattedTotalFacturaZ_BIva27 = String.format("%.2f", totalFacturaZ_B_Iva27).replace(".", ",");
		String formattedTotalFacturaZPositivosIva27 = String.format("%.2f", totalFacturaZPositivosIva27).replace(".",
				",");
		String formattedTotalFacturaZNegativosIva27 = String.format("%.2f", totalFacturaZNegativosIva27).replace(".",
				",");
		String formattedTotalFacturaZIva27 = String.format("%.2f", totalFacturaZIva27).replace(".", ",");

		String formattedTotalFacturaAPositivosFacturaZ_A_PositivosIva27 = String
				.format("%.2f", totalFacturaAPositivosFacturaZ_A_PositivosIva27).replace(".", ",");
		String formattedTotalFacturaANegativosFacturaZ_A_NegativosIva27 = String
				.format("%.2f", totalFacturaANegativosFacturaZ_A_NegativosIva27).replace(".", ",");
		String formattedTotalFacturaAFacturaZ_AIva27 = String.format("%.2f", totalFacturaAFacturaZ_AIva27).replace(".",
				",");
		String formattedTotalFacturaBPositivosFacturaZ_B_PositivosIva27 = String
				.format("%.2f", totalFacturaBPositivosFacturaZ_B_PositivosIva27).replace(".", ",");
		String formattedTotalFacturaBNegativosFacturaZ_B_NegativosIva27 = String
				.format("%.2f", totalFacturaBNegativosFacturaZ_B_NegativosIva27).replace(".", ",");
		String formattedTotalFacturaBFacturaZ_BIva27 = String.format("%.2f", totalFacturaBFacturaZ_BIva27).replace(".",
				",");

		String formattedTotalFacturaZ_A_Positivos_MonotributistasIva27 = String
				.format("%.2f", totalFacturaZ_A_Positivos_MonotributistasIva27).replace(".", ",");
		String formattedTotalFacturaZ_B_Positivos_MonotributistasIva27 = String
				.format("%.2f", totalFacturaZ_B_Positivos_MonotributistasIva27).replace(".", ",");
		String formattedTotalFacturaZ_B_Positivos_ConsumidoresFinalesIva27 = String
				.format("%.2f", totalFacturaZ_B_Positivos_ConsumidoresFinalesIva27).replace(".", ",");
		String formattedTotalFacturaZ_A_Positivos_ExentosNoAlcanzadosIva27 = String
				.format("%.2f", totalFacturaZ_A_Positivos_ExentosNoAlcanzadosIva27).replace(".", ",");
		String formattedTotalFacturaZ_B_Positivos_ExentosNoAlcanzadosIva27 = String
				.format("%.2f", totalFacturaZ_B_Positivos_ExentosNoAlcanzadosIva27).replace(".", ",");
		String formattedTotalFacturaZ_A_Positivos_ResponsableInscriptoIva27 = String
				.format("%.2f", totalFacturaZ_A_Positivos_ResponsableInscriptoIva27).replace(".", ",");

		String formattedTotalFacturaZ_A_Negativos_MonotributistasIva27 = String
				.format("%.2f", totalFacturaZ_A_Negativos_MonotributistasIva27).replace(".", ",");
		String formattedTotalFacturaZ_B_Negativos_MonotributistasIva27 = String
				.format("%.2f", totalFacturaZ_B_Negativos_MonotributistasIva27).replace(".", ",");
		String formattedTotalFacturaZ_B_Negativos_ConsumidoresFinalesIva27 = String
				.format("%.2f", totalFacturaZ_B_Negativos_ConsumidoresFinalesIva27).replace(".", ",");
		String formattedTotalFacturaZ_A_Negativos_ExentosNoAlcanzadosIva27 = String
				.format("%.2f", totalFacturaZ_A_Negativos_ExentosNoAlcanzadosIva27).replace(".", ",");
		String formattedTotalFacturaZ_B_Negativos_ExentosNoAlcanzadosIva27 = String
				.format("%.2f", totalFacturaZ_B_Negativos_ExentosNoAlcanzadosIva27).replace(".", ",");
		String formattedTotalFacturaZ_A_Negativos_ResponsableInscriptoIva27 = String
				.format("%.2f", totalFacturaZ_A_Negativos_ResponsableInscriptoIva27).replace(".", ",");

		String formattedOpRiIva27 = String.format("%.2f",
				totalFacturaAResponsableInscriptoPositivosIva27 + totalFacturaZ_A_Positivos_ResponsableInscriptoIva27)
				.replace(".", ",");
		String formattedOpCfExentosIva27 = String.format("%.2f",
				totalFacturaZ_B_Positivos_ConsumidoresFinalesIva27 + totalFacturaZ_A_Positivos_ExentosNoAlcanzadosIva27
						+ totalFacturaZ_B_Positivos_ExentosNoAlcanzadosIva27
						+ totalFacturaAExentosNoAlcanzadosPositivosIva27 + totalFacturaBConsumidorFinalPositivosIva27
						+ totalFacturaBExentosNoAlcanzadosPositivosIva27)
				.replace(".", ",");
		String formattedOpMonIva27 = String
				.format("%.2f",
						totalFacturaZ_A_Positivos_MonotributistasIva27 + totalFacturaZ_B_Positivos_MonotributistasIva27
								+ totalFacturaAMonotributistaPositivosIva27 + totalFacturaBMonotributistaPositivosIva27)
				.replace(".", ",");

		String formattedOpRiCreditoIva27 = String.format("%.2f",
				totalFacturaAResponsableInscriptoNegativosIva27 + totalFacturaZ_A_Negativos_ResponsableInscriptoIva27)
				.replace(".", ",");

		String formattedOpCfExentosMonCreditoIva27 = String.format("%.2f",
				totalFacturaZ_B_Negativos_ConsumidoresFinalesIva27 + totalFacturaZ_A_Negativos_ExentosNoAlcanzadosIva27
						+ totalFacturaZ_B_Negativos_ExentosNoAlcanzadosIva27
						+ totalFacturaAExentosNoAlcanzadosNegativosIva27 + totalFacturaBConsumidorFinalNegativosIva27
						+ totalFacturaBExentosNoAlcanzadosNegativosIva27
						+ totalFacturaZ_A_Negativos_MonotributistasIva27
						+ totalFacturaZ_B_Negativos_MonotributistasIva27 + totalFacturaAMonotributistaNegativosIva27
						+ totalFacturaBMonotributistaNegativosIva27)
				.replace(".", ",");

		// Mostrar los resultados formateados

		System.out.println(ANSI_GREEN + "\nPunto de venta: " + puntoDeVenta + ANSI_RESET);

		System.out.println("\nTotales acumulados Neto Gravado con IVA 27:");

		System.out.println("\nFacturas A 27");

		System.out.println("Total Factura A Responsable Inscripto (RI) Positivos 27: "
				+ formattedTotalFacturaAResponsableInscriptoPositivos27 + " \tIVA\t "
				+ formattedTotalFacturaAResponsableInscriptoPositivosIva27);
		System.out.println("Total Factura A Responsable Inscripto (RI) Negativos 27: "
				+ formattedTotalFacturaAResponsableInscriptoNegativos27 + " \tIVA\t "
				+ formattedTotalFacturaAResponsableInscriptoNegativosIva27);
		System.out.println(
				"Total Factura A Responsable Inscripto (RI) 27: " + formattedTotalFacturaAResponsableInscripto27
						+ " \tIVA\t " + formattedTotalFacturaAResponsableInscriptoIva27);
		System.out.println(
				"Total Factura A Monotributista Positivos 27: " + formattedTotalFacturaAMonotributistaPositivos27
						+ " \tIVA\t " + formattedTotalFacturaAMonotributistaPositivosIva27);
		System.out.println(
				"Total Factura A Monotributista Negativos 27: " + formattedTotalFacturaAMonotributistaNegativos27
						+ " \tIVA\t " + formattedTotalFacturaAMonotributistaNegativosIva27);
		System.out.println("Total Factura A Monotributista 27: " + formattedTotalFacturaAMonotributista27 + " \tIVA\t "
				+ formattedTotalFacturaAMonotributistaIva27);
		System.out.println("Total Factura A Exentos No Alcanzados Positivos 27: "
				+ formattedTotalFacturaAExentosNoAlcanzadosPositivos27 + " \tIVA\t "
				+ formattedTotalFacturaAExentosNoAlcanzadosPositivosIva27);
		System.out.println("Total Factura A Exentos No Alcanzados Negativos 27: "
				+ formattedTotalFacturaAExentosNoAlcanzadosNegativos27 + " \tIVA\t "
				+ formattedTotalFacturaAExentosNoAlcanzadosNegativosIva27);
		System.out.println("Total Factura A Exentos No Alcanzados 27: " + formattedTotalFacturaAExentosNoAlcanzados27
				+ " \tIVA\t " + formattedTotalFacturaAExentosNoAlcanzadosIva27);
		System.out.println("Total Factura A Positivos (sin Facturas Z positivas) 27: "
				+ formattedTotalFacturaAPositivos27 + " \tIVA\t " + formattedTotalFacturaAPositivosIva27);
		System.out.println("Total Factura A Negativos (sin Facturas Z negativas) 27: "
				+ formattedTotalFacturaANegativos27 + " \tIVA\t " + formattedTotalFacturaANegativosIva27);
		System.out.println("Total Factura A (sin Facturas Z) 27: " + formattedTotalFacturaA27 + " \tIVA\t "
				+ formattedTotalFacturaAIva27);

		System.out.println("\nFacturas B 27");

		System.out.println(
				"Total Factura B Consumidor Final Positivos 27: " + formattedTotalFacturaBConsumidorFinalPositivos27
						+ " \tIVA\t " + formattedTotalFacturaBConsumidorFinalPositivosIva27);
		System.out.println(
				"Total Factura B Consumidor Final Negativos 27: " + formattedTotalFacturaBConsumidorFinalNegativos27
						+ " \tIVA\t " + formattedTotalFacturaBConsumidorFinalNegativosIva27);
		System.out.println("Total Factura B Consumidor Final 27: " + formattedTotalFacturaBConsumidorFinal27
				+ " \tIVA\t " + formattedTotalFacturaBConsumidorFinalIva27);
		System.out.println(
				"Total Factura B Monotributista Positivos 27: " + formattedTotalFacturaBMonotributistaPositivos27
						+ " \tIVA\t " + formattedTotalFacturaBMonotributistaPositivosIva27);
		System.out.println(
				"Total Factura B Monotributista Negativos 27: " + formattedTotalFacturaBMonotributistaNegativos27
						+ " \tIVA\t " + formattedTotalFacturaBMonotributistaNegativosIva27);
		System.out.println("Total Factura B Monotributista 27: " + formattedTotalFacturaBMonotributista27 + " \tIVA\t "
				+ formattedTotalFacturaBMonotributistaIva27);
		System.out.println("Total Factura B Exentos No Alcanzados Positivos 27: "
				+ formattedTotalFacturaBExentosNoAlcanzadosPositivos27 + " \tIVA\t "
				+ formattedTotalFacturaBExentosNoAlcanzadosPositivosIva27);
		System.out.println("Total Factura B Exentos No Alcanzados Negativos 27: "
				+ formattedTotalFacturaBExentosNoAlcanzadosNegativos27 + " \tIVA\t "
				+ formattedTotalFacturaBExentosNoAlcanzadosNegativosIva27);
		System.out.println("Total Factura B Exentos No Alcanzados 27: " + formattedTotalFacturaBExentosNoAlcanzados27
				+ " \tIVA\t " + formattedTotalFacturaBExentosNoAlcanzadosIva27);
		System.out.println("Total Factura B Positivos (sin Facturas Z positivas) 27: "
				+ formattedTotalFacturaBPositivos27 + " \tIVA\t " + formattedTotalFacturaBPositivosIva27);
		System.out.println("Total Factura B Negativos (sin Facturas Z negativas) 27: "
				+ formattedTotalFacturaBNegativos27 + " \tIVA\t " + formattedTotalFacturaBNegativosIva27);
		System.out.println("Total Factura B (sin facturas Z) 27: " + formattedTotalFacturaB27 + " \tIVA\t "
				+ formattedTotalFacturaBIva27);

		System.out.println("\nFacturas Z 27");

		System.out.println("Total Factura Z Que Son Factura A Positivos 27: " + formattedTotalFacturaZ_A_Positivos27
				+ " \tIVA\t " + formattedTotalFacturaZ_A_PositivosIva27);
		System.out.println("Total Factura Z Que Son Factura A Negativos 27: " + formattedTotalFacturaZ_A_Negativos27
				+ " \tIVA\t " + formattedTotalFacturaZ_A_NegativosIva27);
		System.out.println("Total Factura Z Que Son Factura A 27: " + formattedTotalFacturaZ_A27 + " \tIVA\t "
				+ formattedTotalFacturaZ_AIva27);
		System.out.println("Total Factura Z Que Son Factura B Positivos 27: " + formattedTotalFacturaZ_B_Positivos27
				+ " \tIVA\t " + formattedTotalFacturaZ_B_PositivosIva27);
		System.out.println("Total Factura Z Que Son Factura B Negativos 27: " + formattedTotalFacturaZ_B_Negativos27
				+ " \tIVA\t " + formattedTotalFacturaZ_B_NegativosIva27);
		System.out.println("Total Factura Z Que Son Factura B 27: " + formattedTotalFacturaZ_B27 + " \tIVA\t "
				+ formattedTotalFacturaZ_BIva27);
		System.out.println("Total Factura Z Positivos 27: " + formattedTotalFacturaZPositivos27 + " \tIVA\t "
				+ formattedTotalFacturaZPositivosIva27);
		System.out.println("Total Factura Z Negativos 27: " + formattedTotalFacturaZNegativos27 + " \tIVA\t "
				+ formattedTotalFacturaZNegativosIva27);
		System.out
				.println("Total Factura Z 27: " + formattedTotalFacturaZ27 + " \tIVA\t " + formattedTotalFacturaZIva27);

		System.out.println("Total Factura A Positivos (con Facturas Z que son A Positivos) 27: "
				+ formattedTotalFacturaAPositivosFacturaZ_A_Positivos27 + " \tIVA\t "
				+ formattedTotalFacturaAPositivosFacturaZ_A_PositivosIva27);
		System.out.println("Total Factura A Negativos (con Facturas Z que son A Negativos) 27: "
				+ formattedTotalFacturaANegativosFacturaZ_A_Negativos27 + " \tIVA\t "
				+ formattedTotalFacturaANegativosFacturaZ_A_NegativosIva27);
		System.out.println("Total Factura A (con Facturas Z que son A) 27: " + formattedTotalFacturaAFacturaZ_A27
				+ " \tIVA\t " + formattedTotalFacturaAFacturaZ_AIva27);

		System.out.println("Total Factura B Positivos (con Facturas Z que son B Positivos) 27: "
				+ formattedTotalFacturaBPositivosFacturaZ_B_Positivos27 + " \tIVA\t "
				+ formattedTotalFacturaBPositivosFacturaZ_B_PositivosIva27);
		System.out.println("Total Factura B Negativos (con Facturas Z que son B Negativos) 27: "
				+ formattedTotalFacturaBNegativosFacturaZ_B_Negativos27 + " \tIVA\t "
				+ formattedTotalFacturaBNegativosFacturaZ_B_NegativosIva27);
		System.out.println("Total Factura B (con Facturas Z que son B) 27: " + formattedTotalFacturaBFacturaZ_B27
				+ " \tIVA\t " + formattedTotalFacturaBFacturaZ_BIva27);

		System.out.println("Total Factura Z Que Son Factura A Positivos Responsable Inscripto 27: "
				+ formattedTotalFacturaZ_A_Positivos_ResponsableInscripto27 + " \tIVA\t "
				+ formattedTotalFacturaZ_A_Positivos_ResponsableInscriptoIva27);
		System.out.println(
				"Operaciones con responsables Inscriptos) 27: " + formattedOpRi27 + " \tIVA\t " + formattedOpRiIva27);

		System.out.println("Total Factura Z Que Son Factura A Positivos Monotributistas 27: "
				+ formattedTotalFacturaZ_A_Positivos_Monotributistas27 + " \tIVA\t "
				+ formattedTotalFacturaZ_A_Positivos_MonotributistasIva27);
		System.out.println("Total Factura Z Que Son Factura B Positivos Monotributistas 27: "
				+ formattedTotalFacturaZ_B_Positivos_Monotributistas27 + " \tIVA\t "
				+ formattedTotalFacturaZ_B_Positivos_MonotributistasIva27);

		System.out.println("Total Factura Z Que son Factura B Positivos Consumidores Finales 27: "
				+ formattedTotalFacturaZ_B_Positivos_ConsumidoresFinales27 + " \tIVA\t "
				+ formattedTotalFacturaZ_B_Positivos_ConsumidoresFinalesIva27);

		System.out.println("Total Factura Z Que Son Factura A Positivos Exentos No Alcanzados 27: "
				+ formattedTotalFacturaZ_A_Positivos_ExentosNoAlcanzados27 + " \tIVA\t "
				+ formattedTotalFacturaZ_A_Positivos_ExentosNoAlcanzadosIva27);

		System.out.println("Total Factura Z Que son Factura B Positivos Exentos No Alcanzados 27: "
				+ formattedTotalFacturaZ_B_Positivos_ExentosNoAlcanzados27 + " \tIVA\t "
				+ formattedTotalFacturaZ_B_Positivos_ExentosNoAlcanzadosIva27);

		System.out.println("Operaciones con CF y EXENTOS NO ALCANZADOS 27: " + formattedOpCfExentos27 + " \tIVA\t "
				+ formattedOpCfExentosIva27);
		System.out.println("Operaciones con MON 27: " + formattedOpMon27 + " \tIVA\t " + formattedOpMonIva27);

		System.out.println("Total Factura Z Que Son Factura A Negativos Responsable Inscripto 27: "
				+ formattedTotalFacturaZ_A_Negativos_ResponsableInscripto27 + " \tIVA\t "
				+ formattedTotalFacturaZ_A_Negativos_ResponsableInscriptoIva27);

		System.out.println("Operaciones con responsables Inscriptos (Crédito) 27: " + formattedOpRiCredito27
				+ " \tIVA\t " + formattedOpRiCreditoIva27);

		System.out.println("Total Factura Z Que Son Factura A Negativos Monotributistas 27: "
				+ formattedTotalFacturaZ_A_Negativos_Monotributistas27 + " \tIVA\t "
				+ formattedTotalFacturaZ_A_Negativos_MonotributistasIva27);
		System.out.println("Total Factura Z Que Son Factura B Negativos Monotributistas 27: "
				+ formattedTotalFacturaZ_B_Negativos_Monotributistas27 + " \tIVA\t "
				+ formattedTotalFacturaZ_B_Negativos_MonotributistasIva27);

		System.out.println("Total Factura Z Que son Factura B Negativos Consumidores Finales 27: "
				+ formattedTotalFacturaZ_B_Negativos_ConsumidoresFinales27 + " \tIVA\t "
				+ formattedTotalFacturaZ_B_Negativos_ConsumidoresFinalesIva27);

		System.out.println("Total Factura Z Que Son Factura A Negativos Exentos No Alcanzados 27: "
				+ formattedTotalFacturaZ_A_Negativos_ExentosNoAlcanzados27 + " \tIVA\t "
				+ formattedTotalFacturaZ_A_Negativos_ExentosNoAlcanzadosIva27);

		System.out.println("Total Factura Z Que son Factura B Negativos Exentos No Alcanzados 27: "
				+ formattedTotalFacturaZ_B_Negativos_ExentosNoAlcanzados27 + " \tIVA\t "
				+ formattedTotalFacturaZ_B_Negativos_ExentosNoAlcanzadosIva27);

		System.out.println("Operaciones con CF, MON y EXENTOS NO ALCANZADOS (Crédito) 27: "
				+ formattedOpCfExentosMonCredito27 + " \tIVA\t " + formattedOpCfExentosMonCreditoIva27);

		// Formatear los resultados

		String formattedTotalFacturaAResponsableInscriptoPositivos = String
				.format("%.2f", totalFacturaAResponsableInscriptoPositivos).replace(".", ",");
		String formattedTotalFacturaAResponsableInscriptoNegativos = String
				.format("%.2f", totalFacturaAResponsableInscriptoNegativos).replace(".", ",");
		String formattedTotalFacturaAResponsableInscripto = String.format("%.2f", totalFacturaAResponsableInscripto)
				.replace(".", ",");
		String formattedTotalFacturaAMonotributistaPositivos = String
				.format("%.2f", totalFacturaAMonotributistaPositivos).replace(".", ",");
		String formattedTotalFacturaAMonotributistaNegativos = String
				.format("%.2f", totalFacturaAMonotributistaNegativos).replace(".", ",");
		String formattedTotalFacturaAMonotributista = String.format("%.2f", totalFacturaAMonotributista).replace(".",
				",");
		String formattedTotalFacturaAExentosNoAlcanzadosPositivos = String
				.format("%.2f", totalFacturaAExentosNoAlcanzadosPositivos).replace(".", ",");
		String formattedTotalFacturaAExentosNoAlcanzadosNegativos = String
				.format("%.2f", totalFacturaAExentosNoAlcanzadosNegativos).replace(".", ",");
		String formattedTotalFacturaAExentosNoAlcanzados = String.format("%.2f", totalFacturaAExentosNoAlcanzados)
				.replace(".", ",");
		String formattedTotalFacturaAPositivos = String.format("%.2f", totalFacturaAPositivos).replace(".", ",");
		String formattedTotalFacturaANegativos = String.format("%.2f", totalFacturaANegativos).replace(".", ",");
		String formattedTotalFacturaA = String.format("%.2f", totalFacturaA).replace(".", ",");

		String formattedTotalFacturaBConsumidorFinalPositivos = String
				.format("%.2f", totalFacturaBConsumidorFinalPositivos).replace(".", ",");
		String formattedTotalFacturaBConsumidorFinalNegativos = String
				.format("%.2f", totalFacturaBConsumidorFinalNegativos).replace(".", ",");
		String formattedTotalFacturaBConsumidorFinal = String.format("%.2f", totalFacturaBConsumidorFinal).replace(".",
				",");
		String formattedTotalFacturaBMonotributistaPositivos = String
				.format("%.2f", totalFacturaBMonotributistaPositivos).replace(".", ",");
		String formattedTotalFacturaBMonotributistaNegativos = String
				.format("%.2f", totalFacturaBMonotributistaNegativos).replace(".", ",");
		String formattedTotalFacturaBMonotributista = String.format("%.2f", totalFacturaBMonotributista).replace(".",
				",");
		String formattedTotalFacturaBExentosNoAlcanzadosPositivos = String
				.format("%.2f", totalFacturaBExentosNoAlcanzadosPositivos).replace(".", ",");
		String formattedTotalFacturaBExentosNoAlcanzadosNegativos = String
				.format("%.2f", totalFacturaBExentosNoAlcanzadosNegativos).replace(".", ",");
		String formattedTotalFacturaBExentosNoAlcanzados = String.format("%.2f", totalFacturaBExentosNoAlcanzados)
				.replace(".", ",");
		String formattedTotalFacturaBPositivos = String.format("%.2f", totalFacturaBPositivos).replace(".", ",");
		String formattedTotalFacturaBNegativos = String.format("%.2f", totalFacturaBNegativos).replace(".", ",");
		String formattedTotalFacturaB = String.format("%.2f", totalFacturaB).replace(".", ",");

		String formattedTotalFacturaZ_A_Positivos = String.format("%.2f", totalFacturaZ_A_Positivos).replace(".", ",");
		String formattedTotalFacturaZ_A_Negativos = String.format("%.2f", totalFacturaZ_A_Negativos).replace(".", ",");
		String formattedTotalFacturaZ_A = String.format("%.2f", totalFacturaZ_A).replace(".", ",");
		String formattedTotalFacturaZ_B_Positivos = String.format("%.2f", totalFacturaZ_B_Positivos).replace(".", ",");
		String formattedTotalFacturaZ_B_Negativos = String.format("%.2f", totalFacturaZ_B_Negativos).replace(".", ",");
		String formattedTotalFacturaZ_B = String.format("%.2f", totalFacturaZ_B).replace(".", ",");
		String formattedTotalFacturaZPositivos = String.format("%.2f", totalFacturaZPositivos).replace(".", ",");
		String formattedTotalFacturaZNegativos = String.format("%.2f", totalFacturaZNegativos).replace(".", ",");
		String formattedTotalFacturaZ = String.format("%.2f", totalFacturaZ).replace(".", ",");

		String formattedTotalFacturaAPositivosFacturaZ_A_Positivos = String
				.format("%.2f", totalFacturaAPositivosFacturaZ_A_Positivos).replace(".", ",");
		String formattedTotalFacturaANegativosFacturaZ_A_Negativos = String
				.format("%.2f", totalFacturaANegativosFacturaZ_A_Negativos).replace(".", ",");
		String formattedTotalFacturaAFacturaZ_A = String.format("%.2f", totalFacturaAFacturaZ_A).replace(".", ",");
		String formattedTotalFacturaBPositivosFacturaZ_B_Positivos = String
				.format("%.2f", totalFacturaBPositivosFacturaZ_B_Positivos).replace(".", ",");
		String formattedTotalFacturaBNegativosFacturaZ_B_Negativos = String
				.format("%.2f", totalFacturaBNegativosFacturaZ_B_Negativos).replace(".", ",");
		String formattedTotalFacturaBFacturaZ_B = String.format("%.2f", totalFacturaBFacturaZ_B).replace(".", ",");

		String formattedTotalFacturaZ_A_Positivos_Monotributistas = String
				.format("%.2f", totalFacturaZ_A_Positivos_Monotributistas).replace(".", ",");
		String formattedTotalFacturaZ_B_Positivos_Monotributistas = String
				.format("%.2f", totalFacturaZ_B_Positivos_Monotributistas).replace(".", ",");
		String formattedTotalFacturaZ_B_Positivos_ConsumidoresFinales = String
				.format("%.2f", totalFacturaZ_B_Positivos_ConsumidoresFinales).replace(".", ",");
		String formattedTotalFacturaZ_A_Positivos_ExentosNoAlcanzados = String
				.format("%.2f", totalFacturaZ_A_Positivos_ExentosNoAlcanzados).replace(".", ",");
		String formattedTotalFacturaZ_B_Positivos_ExentosNoAlcanzados = String
				.format("%.2f", totalFacturaZ_B_Positivos_ExentosNoAlcanzados).replace(".", ",");
		String formattedTotalFacturaZ_A_Positivos_ResponsableInscripto = String
				.format("%.2f", totalFacturaZ_A_Positivos_ResponsableInscripto).replace(".", ",");

		String formattedTotalFacturaZ_A_Negativos_Monotributistas = String
				.format("%.2f", totalFacturaZ_A_Negativos_Monotributistas).replace(".", ",");
		String formattedTotalFacturaZ_B_Negativos_Monotributistas = String
				.format("%.2f", totalFacturaZ_B_Negativos_Monotributistas).replace(".", ",");
		String formattedTotalFacturaZ_B_Negativos_ConsumidoresFinales = String
				.format("%.2f", totalFacturaZ_B_Negativos_ConsumidoresFinales).replace(".", ",");
		String formattedTotalFacturaZ_A_Negativos_ExentosNoAlcanzados = String
				.format("%.2f", totalFacturaZ_A_Negativos_ExentosNoAlcanzados).replace(".", ",");
		String formattedTotalFacturaZ_B_Negativos_ExentosNoAlcanzados = String
				.format("%.2f", totalFacturaZ_B_Negativos_ExentosNoAlcanzados).replace(".", ",");
		String formattedTotalFacturaZ_A_Negativos_ResponsableInscripto = String
				.format("%.2f", totalFacturaZ_A_Negativos_ResponsableInscripto).replace(".", ",");

		String formattedOpRi = String
				.format("%.2f",
						totalFacturaAResponsableInscriptoPositivos + totalFacturaZ_A_Positivos_ResponsableInscripto)
				.replace(".", ",");
		String formattedOpCfExentos = String.format("%.2f",
				totalFacturaZ_B_Positivos_ConsumidoresFinales + totalFacturaZ_A_Positivos_ExentosNoAlcanzados
						+ totalFacturaZ_B_Positivos_ExentosNoAlcanzados + totalFacturaAExentosNoAlcanzadosPositivos
						+ totalFacturaBConsumidorFinalPositivos + totalFacturaBExentosNoAlcanzadosPositivos)
				.replace(".", ",");
		String formattedOpMon = String
				.format("%.2f",
						totalFacturaZ_A_Positivos_Monotributistas + totalFacturaZ_B_Positivos_Monotributistas
								+ totalFacturaAMonotributistaPositivos + totalFacturaBMonotributistaPositivos)
				.replace(".", ",");

		String formattedOpRiCredito = String
				.format("%.2f",
						totalFacturaAResponsableInscriptoNegativos + totalFacturaZ_A_Negativos_ResponsableInscripto)
				.replace(".", ",");

		String formattedOpCfExentosMonCredito = String.format("%.2f",
				totalFacturaZ_B_Negativos_ConsumidoresFinales + totalFacturaZ_A_Negativos_ExentosNoAlcanzados
						+ totalFacturaZ_B_Negativos_ExentosNoAlcanzados + totalFacturaAExentosNoAlcanzadosNegativos
						+ totalFacturaBConsumidorFinalNegativos + totalFacturaBExentosNoAlcanzadosNegativos
						+ totalFacturaZ_A_Negativos_Monotributistas + totalFacturaZ_B_Negativos_Monotributistas
						+ totalFacturaAMonotributistaNegativos + totalFacturaBMonotributistaNegativos)
				.replace(".", ",");

		String formattedtotalFacturaZAB_ABPositivos = String
				.format("%.2f", totalFacturaAPositivosFacturaZ_A_Positivos + totalFacturaBPositivosFacturaZ_B_Positivos)
				.replace(".", ",");
		String formattedtotalFacturaZAB_ABNegativos = String
				.format("%.2f", totalFacturaANegativosFacturaZ_A_Negativos + totalFacturaBNegativosFacturaZ_B_Negativos)
				.replace(".", ",");
		String formattedtotalFacturaZAB_AB = String.format("%.2f", totalFacturaAFacturaZ_A + totalFacturaBFacturaZ_B)
				.replace(".", ",");

		String formattedTotalFacturaAResponsableInscriptoPositivosIva = String
				.format("%.2f", totalFacturaAResponsableInscriptoPositivosIva).replace(".", ",");
		String formattedTotalFacturaAResponsableInscriptoNegativosIva = String
				.format("%.2f", totalFacturaAResponsableInscriptoNegativosIva).replace(".", ",");
		String formattedTotalFacturaAResponsableInscriptoIva = String
				.format("%.2f", totalFacturaAResponsableInscriptoIva).replace(".", ",");
		String formattedTotalFacturaAMonotributistaPositivosIva = String
				.format("%.2f", totalFacturaAMonotributistaPositivosIva).replace(".", ",");
		String formattedTotalFacturaAMonotributistaNegativosIva = String
				.format("%.2f", totalFacturaAMonotributistaNegativosIva).replace(".", ",");
		String formattedTotalFacturaAMonotributistaIva = String.format("%.2f", totalFacturaAMonotributistaIva)
				.replace(".", ",");
		String formattedTotalFacturaAExentosNoAlcanzadosPositivosIva = String
				.format("%.2f", totalFacturaAExentosNoAlcanzadosPositivosIva).replace(".", ",");
		String formattedTotalFacturaAExentosNoAlcanzadosNegativosIva = String
				.format("%.2f", totalFacturaAExentosNoAlcanzadosNegativosIva).replace(".", ",");
		String formattedTotalFacturaAExentosNoAlcanzadosIva = String.format("%.2f", totalFacturaAExentosNoAlcanzadosIva)
				.replace(".", ",");
		String formattedTotalFacturaAPositivosIva = String.format("%.2f", totalFacturaAPositivosIva).replace(".", ",");
		String formattedTotalFacturaANegativosIva = String.format("%.2f", totalFacturaANegativosIva).replace(".", ",");
		String formattedTotalFacturaAIva = String.format("%.2f", totalFacturaAIva).replace(".", ",");

		String formattedTotalFacturaBConsumidorFinalPositivosIva = String
				.format("%.2f", totalFacturaBConsumidorFinalPositivosIva).replace(".", ",");
		String formattedTotalFacturaBConsumidorFinalNegativosIva = String
				.format("%.2f", totalFacturaBConsumidorFinalNegativosIva).replace(".", ",");
		String formattedTotalFacturaBConsumidorFinalIva = String.format("%.2f", totalFacturaBConsumidorFinalIva)
				.replace(".", ",");
		String formattedTotalFacturaBMonotributistaPositivosIva = String
				.format("%.2f", totalFacturaBMonotributistaPositivosIva).replace(".", ",");
		String formattedTotalFacturaBMonotributistaNegativosIva = String
				.format("%.2f", totalFacturaBMonotributistaNegativosIva).replace(".", ",");
		String formattedTotalFacturaBMonotributistaIva = String.format("%.2f", totalFacturaBMonotributistaIva)
				.replace(".", ",");
		String formattedTotalFacturaBExentosNoAlcanzadosPositivosIva = String
				.format("%.2f", totalFacturaBExentosNoAlcanzadosPositivosIva).replace(".", ",");
		String formattedTotalFacturaBExentosNoAlcanzadosNegativosIva = String
				.format("%.2f", totalFacturaBExentosNoAlcanzadosNegativosIva).replace(".", ",");
		String formattedTotalFacturaBExentosNoAlcanzadosIva = String.format("%.2f", totalFacturaBExentosNoAlcanzadosIva)
				.replace(".", ",");
		String formattedTotalFacturaBPositivosIva = String.format("%.2f", totalFacturaBPositivosIva).replace(".", ",");
		String formattedTotalFacturaBNegativosIva = String.format("%.2f", totalFacturaBNegativosIva).replace(".", ",");
		String formattedTotalFacturaBIva = String.format("%.2f", totalFacturaBIva).replace(".", ",");

		String formattedTotalFacturaZ_A_PositivosIva = String.format("%.2f", totalFacturaZ_A_PositivosIva).replace(".",
				",");
		String formattedTotalFacturaZ_A_NegativosIva = String.format("%.2f", totalFacturaZ_A_NegativosIva).replace(".",
				",");
		String formattedTotalFacturaZ_AIva = String.format("%.2f", totalFacturaZ_A_Iva).replace(".", ",");
		String formattedTotalFacturaZ_B_PositivosIva = String.format("%.2f", totalFacturaZ_B_PositivosIva).replace(".",
				",");
		String formattedTotalFacturaZ_B_NegativosIva = String.format("%.2f", totalFacturaZ_B_NegativosIva).replace(".",
				",");
		String formattedTotalFacturaZ_BIva = String.format("%.2f", totalFacturaZ_B_Iva).replace(".", ",");
		String formattedTotalFacturaZPositivosIva = String.format("%.2f", totalFacturaZPositivosIva).replace(".", ",");
		String formattedTotalFacturaZNegativosIva = String.format("%.2f", totalFacturaZNegativosIva).replace(".", ",");
		String formattedTotalFacturaZIva = String.format("%.2f", totalFacturaZIva).replace(".", ",");

		String formattedTotalFacturaAPositivosFacturaZ_A_PositivosIva = String
				.format("%.2f", totalFacturaAPositivosFacturaZ_A_PositivosIva).replace(".", ",");
		String formattedTotalFacturaANegativosFacturaZ_A_NegativosIva = String
				.format("%.2f", totalFacturaANegativosFacturaZ_A_NegativosIva).replace(".", ",");
		String formattedTotalFacturaAFacturaZ_AIva = String.format("%.2f", totalFacturaAFacturaZ_AIva).replace(".",
				",");
		String formattedTotalFacturaBPositivosFacturaZ_B_PositivosIva = String
				.format("%.2f", totalFacturaBPositivosFacturaZ_B_PositivosIva).replace(".", ",");
		String formattedTotalFacturaBNegativosFacturaZ_B_NegativosIva = String
				.format("%.2f", totalFacturaBNegativosFacturaZ_B_NegativosIva).replace(".", ",");
		String formattedTotalFacturaBFacturaZ_BIva = String.format("%.2f", totalFacturaBFacturaZ_BIva).replace(".",
				",");

		String formattedTotalFacturaZ_A_Positivos_MonotributistasIva = String
				.format("%.2f", totalFacturaZ_A_Positivos_MonotributistasIva).replace(".", ",");
		String formattedTotalFacturaZ_B_Positivos_MonotributistasIva = String
				.format("%.2f", totalFacturaZ_B_Positivos_MonotributistasIva).replace(".", ",");
		String formattedTotalFacturaZ_B_Positivos_ConsumidoresFinalesIva = String
				.format("%.2f", totalFacturaZ_B_Positivos_ConsumidoresFinalesIva).replace(".", ",");
		String formattedTotalFacturaZ_A_Positivos_ExentosNoAlcanzadosIva = String
				.format("%.2f", totalFacturaZ_A_Positivos_ExentosNoAlcanzadosIva).replace(".", ",");
		String formattedTotalFacturaZ_B_Positivos_ExentosNoAlcanzadosIva = String
				.format("%.2f", totalFacturaZ_B_Positivos_ExentosNoAlcanzadosIva).replace(".", ",");
		String formattedTotalFacturaZ_A_Positivos_ResponsableInscriptoIva = String
				.format("%.2f", totalFacturaZ_A_Positivos_ResponsableInscriptoIva).replace(".", ",");

		String formattedTotalFacturaZ_A_Negativos_MonotributistasIva = String
				.format("%.2f", totalFacturaZ_A_Negativos_MonotributistasIva).replace(".", ",");
		String formattedTotalFacturaZ_B_Negativos_MonotributistasIva = String
				.format("%.2f", totalFacturaZ_B_Negativos_MonotributistasIva).replace(".", ",");
		String formattedTotalFacturaZ_B_Negativos_ConsumidoresFinalesIva = String
				.format("%.2f", totalFacturaZ_B_Negativos_ConsumidoresFinalesIva).replace(".", ",");
		String formattedTotalFacturaZ_A_Negativos_ExentosNoAlcanzadosIva = String
				.format("%.2f", totalFacturaZ_A_Negativos_ExentosNoAlcanzadosIva).replace(".", ",");
		String formattedTotalFacturaZ_B_Negativos_ExentosNoAlcanzadosIva = String
				.format("%.2f", totalFacturaZ_B_Negativos_ExentosNoAlcanzadosIva).replace(".", ",");
		String formattedTotalFacturaZ_A_Negativos_ResponsableInscriptoIva = String
				.format("%.2f", totalFacturaZ_A_Negativos_ResponsableInscriptoIva).replace(".", ",");

		String formattedOpRiIva = String.format("%.2f",
				totalFacturaAResponsableInscriptoPositivosIva + totalFacturaZ_A_Positivos_ResponsableInscriptoIva)
				.replace(".", ",");
		String formattedOpCfExentosIva = String.format("%.2f",
				totalFacturaZ_B_Positivos_ConsumidoresFinalesIva + totalFacturaZ_A_Positivos_ExentosNoAlcanzadosIva
						+ totalFacturaZ_B_Positivos_ExentosNoAlcanzadosIva
						+ totalFacturaAExentosNoAlcanzadosPositivosIva + totalFacturaBConsumidorFinalPositivosIva
						+ totalFacturaBExentosNoAlcanzadosPositivosIva)
				.replace(".", ",");
		String formattedOpMonIva = String
				.format("%.2f",
						totalFacturaZ_A_Positivos_MonotributistasIva + totalFacturaZ_B_Positivos_MonotributistasIva
								+ totalFacturaAMonotributistaPositivosIva + totalFacturaBMonotributistaPositivosIva)
				.replace(".", ",");

		String formattedOpRiCreditoIva = String.format("%.2f",
				totalFacturaAResponsableInscriptoNegativosIva + totalFacturaZ_A_Negativos_ResponsableInscriptoIva)
				.replace(".", ",");

		String formattedOpCfExentosMonCreditoIva = String.format("%.2f",
				totalFacturaZ_B_Negativos_ConsumidoresFinalesIva + totalFacturaZ_A_Negativos_ExentosNoAlcanzadosIva
						+ totalFacturaZ_B_Negativos_ExentosNoAlcanzadosIva
						+ totalFacturaAExentosNoAlcanzadosNegativosIva + totalFacturaBConsumidorFinalNegativosIva
						+ totalFacturaBExentosNoAlcanzadosNegativosIva + totalFacturaZ_A_Negativos_MonotributistasIva
						+ totalFacturaZ_B_Negativos_MonotributistasIva + totalFacturaAMonotributistaNegativosIva
						+ totalFacturaBMonotributistaNegativosIva)
				.replace(".", ",");
		String formattedtotalFacturaZAB_ABPositivosIva = String
				.format("%.2f",
						totalFacturaAPositivosFacturaZ_A_PositivosIva + totalFacturaBPositivosFacturaZ_B_PositivosIva)
				.replace(".", ",");
		String formattedtotalFacturaZAB_ABNegativosIva = String
				.format("%.2f",
						totalFacturaANegativosFacturaZ_A_NegativosIva + totalFacturaBNegativosFacturaZ_B_NegativosIva)
				.replace(".", ",");
		String formattedtotalFacturaZAB_ABIva = String
				.format("%.2f", totalFacturaAFacturaZ_AIva + totalFacturaBFacturaZ_BIva).replace(".", ",");

		// Mostrar los resultados formateados

		System.out.println(ANSI_YELLOW + "\nPunto de venta: " + puntoDeVenta + ANSI_RESET);

		System.out.println("\nTotales acumulados Neto Gravado con IVA:");

		System.out.println("\nFacturas A");

		System.out.println("Total Factura A Responsable Inscripto (RI) Positivos: "
				+ formattedTotalFacturaAResponsableInscriptoPositivos + " \tIVA\t "
				+ formattedTotalFacturaAResponsableInscriptoPositivosIva);
		System.out.println("Total Factura A Responsable Inscripto (RI) Negativos: "
				+ formattedTotalFacturaAResponsableInscriptoNegativos + " \tIVA\t "
				+ formattedTotalFacturaAResponsableInscriptoNegativosIva);
		System.out.println("Total Factura A Responsable Inscripto (RI): " + formattedTotalFacturaAResponsableInscripto
				+ " \tIVA\t " + formattedTotalFacturaAResponsableInscriptoIva);
		System.out.println("Total Factura A Monotributista Positivos: " + formattedTotalFacturaAMonotributistaPositivos
				+ " \tIVA\t " + formattedTotalFacturaAMonotributistaPositivosIva);
		System.out.println("Total Factura A Monotributista Negativos: " + formattedTotalFacturaAMonotributistaNegativos
				+ " \tIVA\t " + formattedTotalFacturaAMonotributistaNegativosIva);
		System.out.println("Total Factura A Monotributista: " + formattedTotalFacturaAMonotributista + " \tIVA\t "
				+ formattedTotalFacturaAMonotributistaIva);
		System.out.println(
				"Total Factura A Exentos No Alcanzados Positivos: " + formattedTotalFacturaAExentosNoAlcanzadosPositivos
						+ " \tIVA\t " + formattedTotalFacturaAExentosNoAlcanzadosPositivosIva);
		System.out.println(
				"Total Factura A Exentos No Alcanzados Negativos: " + formattedTotalFacturaAExentosNoAlcanzadosNegativos
						+ " \tIVA\t " + formattedTotalFacturaAExentosNoAlcanzadosNegativosIva);
		System.out.println("Total Factura A Exentos No Alcanzados: " + formattedTotalFacturaAExentosNoAlcanzados
				+ " \tIVA\t " + formattedTotalFacturaAExentosNoAlcanzadosIva);
		System.out.println("Total Factura A Positivos (sin Facturas Z positivas): " + formattedTotalFacturaAPositivos
				+ " \tIVA\t " + formattedTotalFacturaAPositivosIva);
		System.out.println("Total Factura A Negativos (sin Facturas Z negativas): " + formattedTotalFacturaANegativos
				+ " \tIVA\t " + formattedTotalFacturaANegativosIva);
		System.out.println("Total Factura A (sin Facturas Z): " + formattedTotalFacturaA + " \tIVA\t "
				+ formattedTotalFacturaAIva);

		System.out.println("\nFacturas B");

		System.out
				.println("Total Factura B Consumidor Final Positivos: " + formattedTotalFacturaBConsumidorFinalPositivos
						+ " \tIVA\t " + formattedTotalFacturaBConsumidorFinalPositivosIva);
		System.out
				.println("Total Factura B Consumidor Final Negativos: " + formattedTotalFacturaBConsumidorFinalNegativos
						+ " \tIVA\t " + formattedTotalFacturaBConsumidorFinalNegativosIva);
		System.out.println("Total Factura B Consumidor Final: " + formattedTotalFacturaBConsumidorFinal + " \tIVA\t "
				+ formattedTotalFacturaBConsumidorFinalIva);
		System.out.println("Total Factura B Monotributista Positivos: " + formattedTotalFacturaBMonotributistaPositivos
				+ " \tIVA\t " + formattedTotalFacturaBMonotributistaPositivosIva);
		System.out.println("Total Factura B Monotributista Negativos: " + formattedTotalFacturaBMonotributistaNegativos
				+ " \tIVA\t " + formattedTotalFacturaBMonotributistaNegativosIva);
		System.out.println("Total Factura B Monotributista: " + formattedTotalFacturaBMonotributista + " \tIVA\t "
				+ formattedTotalFacturaBMonotributistaIva);
		System.out.println(
				"Total Factura B Exentos No Alcanzados Positivos: " + formattedTotalFacturaBExentosNoAlcanzadosPositivos
						+ " \tIVA\t " + formattedTotalFacturaBExentosNoAlcanzadosPositivosIva);
		System.out.println(
				"Total Factura B Exentos No Alcanzados Negativos: " + formattedTotalFacturaBExentosNoAlcanzadosNegativos
						+ " \tIVA\t " + formattedTotalFacturaBExentosNoAlcanzadosNegativosIva);
		System.out.println("Total Factura B Exentos No Alcanzados: " + formattedTotalFacturaBExentosNoAlcanzados
				+ " \tIVA\t " + formattedTotalFacturaBExentosNoAlcanzadosIva);
		System.out.println("Total Factura B Positivos (sin Facturas Z positivas): " + formattedTotalFacturaBPositivos
				+ " \tIVA\t " + formattedTotalFacturaBPositivosIva);
		System.out.println("Total Factura B Negativos (sin Facturas Z negativas): " + formattedTotalFacturaBNegativos
				+ " \tIVA\t " + formattedTotalFacturaBNegativosIva);
		System.out.println("Total Factura B (sin facturas Z): " + formattedTotalFacturaB + " \tIVA\t "
				+ formattedTotalFacturaBIva);

		System.out.println("\nFacturas Z");

		System.out.println("Total Factura Z Que Son Factura A Positivos: " + formattedTotalFacturaZ_A_Positivos
				+ " \tIVA\t " + formattedTotalFacturaZ_A_PositivosIva);
		System.out.println("Total Factura Z Que Son Factura A Negativos: " + formattedTotalFacturaZ_A_Negativos
				+ " \tIVA\t " + formattedTotalFacturaZ_A_NegativosIva);
		System.out.println("Total Factura Z Que Son Factura A: " + formattedTotalFacturaZ_A + " \tIVA\t "
				+ formattedTotalFacturaZ_AIva);
		System.out.println("Total Factura Z Que Son Factura B Positivos: " + formattedTotalFacturaZ_B_Positivos
				+ " \tIVA\t " + formattedTotalFacturaZ_B_PositivosIva);
		System.out.println("Total Factura Z Que Son Factura B Negativos: " + formattedTotalFacturaZ_B_Negativos
				+ " \tIVA\t " + formattedTotalFacturaZ_B_NegativosIva);
		System.out.println("Total Factura Z Que Son Factura B: " + formattedTotalFacturaZ_B + " \tIVA\t "
				+ formattedTotalFacturaZ_BIva);
		System.out.println("Total Factura Z Positivos: " + formattedTotalFacturaZPositivos + " \tIVA\t "
				+ formattedTotalFacturaZPositivosIva);
		System.out.println("Total Factura Z Negativos: " + formattedTotalFacturaZNegativos + " \tIVA\t "
				+ formattedTotalFacturaZNegativosIva);
		System.out.println("Total Factura Z: " + formattedTotalFacturaZ + " \tIVA\t " + formattedTotalFacturaZIva);

		System.out.println("Total Factura A Positivos (con Facturas Z que son A Positivos): "
				+ formattedTotalFacturaAPositivosFacturaZ_A_Positivos + " \tIVA\t "
				+ formattedTotalFacturaAPositivosFacturaZ_A_PositivosIva);
		System.out.println("Total Factura A Negativos (con Facturas Z que son A Negativos): "
				+ formattedTotalFacturaANegativosFacturaZ_A_Negativos + " \tIVA\t "
				+ formattedTotalFacturaANegativosFacturaZ_A_NegativosIva);
		System.out.println("Total Factura A (con Facturas Z que son A): " + formattedTotalFacturaAFacturaZ_A
				+ " \tIVA\t " + formattedTotalFacturaAFacturaZ_AIva);

		System.out.println("Total Factura B Positivos (con Facturas Z que son B Positivos): "
				+ formattedTotalFacturaBPositivosFacturaZ_B_Positivos + " \tIVA\t "
				+ formattedTotalFacturaBPositivosFacturaZ_B_PositivosIva);
		System.out.println("Total Factura B Negativos (con Facturas Z que son B Negativos): "
				+ formattedTotalFacturaBNegativosFacturaZ_B_Negativos + " \tIVA\t "
				+ formattedTotalFacturaBNegativosFacturaZ_B_NegativosIva);
		System.out.println("Total Factura B (con Facturas Z que son B): " + formattedTotalFacturaBFacturaZ_B
				+ " \tIVA\t " + formattedTotalFacturaBFacturaZ_BIva);

		System.out.println("Total Factura Z Que Son Factura A Positivos Responsable Inscripto : "
				+ formattedTotalFacturaZ_A_Positivos_ResponsableInscripto + " \tIVA\t "
				+ formattedTotalFacturaZ_A_Positivos_ResponsableInscriptoIva);
		System.out
				.println("Operaciones con responsables Inscriptos: " + formattedOpRi + " \tIVA\t " + formattedOpRiIva);

		System.out.println("Total Factura Z Que Son Factura A Positivos Monotributistas: "
				+ formattedTotalFacturaZ_A_Positivos_Monotributistas + " \tIVA\t "
				+ formattedTotalFacturaZ_A_Positivos_MonotributistasIva);
		System.out.println("Total Factura Z Que Son Factura B Positivos Monotributistas: "
				+ formattedTotalFacturaZ_B_Positivos_Monotributistas + " \tIVA\t "
				+ formattedTotalFacturaZ_B_Positivos_MonotributistasIva);

		System.out.println("Total Factura Z Que son Factura B Positivos Consumidores Finales: "
				+ formattedTotalFacturaZ_B_Positivos_ConsumidoresFinales + " \tIVA\t "
				+ formattedTotalFacturaZ_B_Positivos_ConsumidoresFinalesIva);

		System.out.println("Total Factura Z Que Son Factura A Positivos Exentos No Alcanzados: "
				+ formattedTotalFacturaZ_A_Positivos_ExentosNoAlcanzados + " \tIVA\t "
				+ formattedTotalFacturaZ_A_Positivos_ExentosNoAlcanzadosIva);

		System.out.println("Total Factura Z Que son Factura B Positivos Exentos No Alcanzados: "
				+ formattedTotalFacturaZ_B_Positivos_ExentosNoAlcanzados + " \tIVA\t "
				+ formattedTotalFacturaZ_B_Positivos_ExentosNoAlcanzadosIva);

		System.out.println("Operaciones con CF y EXENTOS NO ALCANZADOS: " + formattedOpCfExentos + " \tIVA\t "
				+ formattedOpCfExentosIva);
		System.out.println("Operaciones con MON: " + formattedOpMon + " \tIVA\t " + formattedOpMonIva);

		System.out.println("Total Factura Z Que Son Factura A Negativos Responsable Inscripto : "
				+ formattedTotalFacturaZ_A_Negativos_ResponsableInscripto + " \tIVA\t "
				+ formattedTotalFacturaZ_A_Negativos_ResponsableInscriptoIva);

		System.out.println("Operaciones con responsables Inscriptos (Crédito): " + formattedOpRiCredito + " \tIVA\t "
				+ formattedOpRiCreditoIva);

		System.out.println("Total Factura Z Que Son Factura A Negativos Monotributistas: "
				+ formattedTotalFacturaZ_A_Negativos_Monotributistas + " \tIVA\t "
				+ formattedTotalFacturaZ_A_Negativos_MonotributistasIva);
		System.out.println("Total Factura Z Que Son Factura B Negativos Monotributistas: "
				+ formattedTotalFacturaZ_B_Negativos_Monotributistas + " \tIVA\t "
				+ formattedTotalFacturaZ_B_Negativos_MonotributistasIva);

		System.out.println("Total Factura Z Que son Factura B Negativos Consumidores Finales: "
				+ formattedTotalFacturaZ_B_Negativos_ConsumidoresFinales + " \tIVA\t "
				+ formattedTotalFacturaZ_B_Negativos_ConsumidoresFinalesIva);

		System.out.println("Total Factura Z Que Son Factura A Negativos Exentos No Alcanzados: "
				+ formattedTotalFacturaZ_A_Negativos_ExentosNoAlcanzados + " \tIVA\t "
				+ formattedTotalFacturaZ_A_Negativos_ExentosNoAlcanzadosIva);

		System.out.println("Total Factura Z Que son Factura B Negativos Exentos No Alcanzados: "
				+ formattedTotalFacturaZ_B_Negativos_ExentosNoAlcanzados + " \tIVA\t "
				+ formattedTotalFacturaZ_B_Negativos_ExentosNoAlcanzadosIva);

		System.out.println("Operaciones con CF, MON y EXENTOS NO ALCANZADOS (Crédito): "
				+ formattedOpCfExentosMonCredito + " \tIVA\t " + formattedOpCfExentosMonCreditoIva);

		System.out.println("Total Facturas A, B y Z (que son A y B) Positivos: " + formattedtotalFacturaZAB_ABPositivos
				+ " \tIVA\t " + formattedtotalFacturaZAB_ABPositivosIva);
		System.out.println("Total Facturas A, B y Z (que son A y B) Negativos: " + formattedtotalFacturaZAB_ABNegativos
				+ " \tIVA\t " + formattedtotalFacturaZAB_ABNegativosIva);
		System.out.println("Total Facturas A, B y Z (que son A y B): " + formattedtotalFacturaZAB_AB + " \tIVA\t "
				+ formattedtotalFacturaZAB_ABIva);

		System.out.println("Factura Procesada");

	}

}

/*
 * ACLARACIONES: (1) Este codigo requiere formatear en el excel todas las
 * columnas. Además, hay que cambiarle le formato con el texto en columnas de
 * ancho fijo y delimitador A TODAS LAS COLUMNAS. De ancho fijo a los numeros y
 * delimitador a los textos. (2) En ventas suele aparecer Total neto gravado en
 * la columna AC En compras suele aparecer Total neto gravado en la columna AD.
 * Se recomienda quitar la columna Percepciones municipales si es que no lleva
 * nada o modificar el codigo un valor para que tome dicha columna. De igual
 * manera, se vera alguna forma de optimizar el codigo.(3) Otro detalle es que
 * Monotributista Factura B y Exentos no Alcanzados Factura A no llegarán a
 * tener validación porque la anterior tiene la misma condición. Estan ahi a
 * modo de referencia. Por lo tanto siempre daran cero. Se recomienda revisarlos
 * en el subdiario y corroborar que tengan valor. (4) Subtotal marca el final de
 * la lectura de registros. Se lo denomino Subtotal o Revisar porque en teoría
 * el subtotal no cumple ninguna condición. Ahora si aparece más de una vez
 * además de que está en el final, es porque algún registro presenta algún caso
 * inesperado y requiera tratamiento. IMPORTANTE: SE RECOMIENDA FORMATEAR A
 * TODAS LAS COLUMNAS DEL LIBRO. NOTA: Aplicar ancho fijo a las columnas que al
 * menos tengan un registro compuesto por un número, letra o palabra. Aplicar
 * delimitador a las columnas que al menos tengan un registro compuesto por dos
 * o más palabras.
 * 
 */
