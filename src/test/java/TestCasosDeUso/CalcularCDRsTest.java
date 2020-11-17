package TestCasosDeUso;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Casosdeuso.CalcularCDRs;
import Casosdeuso.ICalcularCDRs;
import Persistencia.RegistrosCSV;

public class CalcularCDRsTest {
	
	ICalcularCDRs calcularCosto;
	String casoDeUso;
	String  fecha;
	@BeforeTest
	public void setup() {
		calcularCosto = new CalcularCDRs(new RegistrosCSV());
		casoDeUso = "CasoDeUsoCalcularCDRs";
		fecha = "Hoy";
	}
	
	@Test
	public void test_ObtenerNombreCasoDeUso() {
		assertEquals(calcularCosto.obtenerCasoDeUso(), casoDeUso);
	}
	
	@Test
	public void test_CalcularCostos() {
		calcularCosto.calcularCosto(fecha);
	}
}
