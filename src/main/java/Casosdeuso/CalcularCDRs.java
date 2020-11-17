package Casosdeuso;

import Persistencia.IRepositorio;

public class CalcularCDRs implements ICalcularCDRs {
	private IRepositorio repositorio;
	String nombre;
	
	public CalcularCDRs( IRepositorio repositorio) {
		this.repositorio = repositorio;
		this.nombre="CasoDeUsoCalcularCDRs";
	}

	@Override
	public void calcularCosto(String fecha) {
		repositorio.guardarCDRsCalculados(fecha);
	}
	
	public String obtenerCasoDeUso() {
		return nombre;
	}
	
	
}
