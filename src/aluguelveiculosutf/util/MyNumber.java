package aluguelveiculosutf.util;

import java.math.BigDecimal;

/**
 * Classe de terceiros adaptada.
 * @author Desconhecido.
 */
public class MyNumber {

	public static double parseDouble(Object valor) {
		double retorno = 0;
		try {
			retorno = Double.parseDouble(valor.toString());
		} catch (Exception e) {
			retorno = 0;
//			System.out.println("Erro ao converter Double.");
		}
		return retorno;
	}

	public static float parseFloat(Object valor) {
		float retorno = 0;
		try {
			retorno = Float.parseFloat(valor.toString());
		} catch (Exception e) {
			retorno = 0;
//			System.out.println("Erro ao converter Float.");
		}
		return retorno;
	}

	public static int parseInt(Object valor) {
		int retorno = 0;
		try {
			retorno = Integer.parseInt(valor.toString());
		} catch (Exception e) {
			retorno = 0;
//			System.out.println("Erro ao converter Int.");
		}
		return retorno;
	}

	public static long parseLong(Object valor) {
		long retorno = 0;
		try {
			retorno = Long.parseLong(valor.toString());
		} catch (Exception e) {
			retorno = 0;
//			System.out.println("Erro ao converter Long.");
		}
		return retorno;
	}

        public static String parseString(Object valor) {
		String retorno = "";
		try {
			retorno = valor.toString();
		} catch (Exception e) {
			retorno = "";
//			System.out.println("Erro ao converter String.");
		}
		return retorno;
	}

        public static BigDecimal parseBigDecimal(Object valor) {
		BigDecimal retorno = new BigDecimal(0);
		try {
                    retorno = new BigDecimal(valor.toString());
		} catch (Exception e) {
                        e.printStackTrace();
			retorno = new BigDecimal(0);
//			System.out.println("Erro ao converter BigDecimal.");
		}
		return retorno;
	}


}