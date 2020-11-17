package TestCasosDeUso;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Casosdeuso.ITarifarCDRs;
import Casosdeuso.TarifarCDRs;
import Persistencia.RegistrosCSV;

public class TarifarCDRsTest {
	ITarifarCDRs tarifarCDRs;
	String casoDeUso;
	String  fecha;
	@BeforeTest
	public void setup() {
		tarifarCDRs = new TarifarCDRs(new RegistrosCSV());
		casoDeUso = "CasoDeUsoTarifarCDRs";
		fecha = "Ayer";
	}
	
	@Test
	public void test_ObtenerNombreCasoDeUso() {
		assertEquals(tarifarCDRs.obtenerCasoDeUso(), casoDeUso);
	}
	
	@Test
	public void test_CalcularCosto() {
		tarifarCDRs.calcularCosto(fecha);
	}
}
