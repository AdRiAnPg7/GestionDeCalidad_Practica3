package Tarifas;
import java.util.ArrayList;

import Entidades.CDR;

public class TarifaAmigo implements ITarifaStrategy {
	
	private static final int LIMITE_DE_AMIGOS = 4;

	float tarifaBsMinuto = 0.99f;
	
	ArrayList<Integer> numerosAmigos = new ArrayList <Integer>();
	int cantidadNumerosAmigos = 0;

	public float calcularTarifa(CDR CDR) {
		if (numerosAmigos.contains(CDR.obtenerNumeroDelTelefonoDestino())) 
			tarifaBsMinuto = 0.00f;
		
		return tarifaBsMinuto;
	}
	

	public void aniadirTelefonosAmigos(int nuevoAmigo) {
		if(cantidadNumerosAmigos < LIMITE_DE_AMIGOS) {
			numerosAmigos.add(nuevoAmigo);
			cantidadNumerosAmigos++;
		}	
	}

}
