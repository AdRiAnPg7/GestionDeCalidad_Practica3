package Test;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import Casosdeuso.*;
import Persistencia.RegistrosSQL;


class TestCalcularCosto {

	
	@Test
	void obtenerCasoDeUso() {
		CalcularCDRs calcularCDRs= new CalcularCDRs(new RegistrosSQL());
		assertEquals("CasoDeUSoCalcularCDRs", calcularCDRs.obtenerCasoDeUso());
	}
}
