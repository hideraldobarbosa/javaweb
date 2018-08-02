package br.com.agabsistemas.CalculosMatematicos;

public class Calculos {
	private static int resultado;
		
	public static int metodoSoma(int num1, int num2){
		resultado = num1+num2;
				 
		return resultado;
	}
		
			 public static int metodoResta(int num1, int num2){
				 resultado = num1-num2;
				 
				 return resultado;
			 }

			 public static int metodoMultiplica(int num1, int num2){
				 resultado = num1*num2;
				 
				 return resultado;
			 }

}
