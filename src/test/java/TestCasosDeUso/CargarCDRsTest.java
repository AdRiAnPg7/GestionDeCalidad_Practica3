package TestCasosDeUso;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import Casosdeuso.CargarCDRs;
import Casosdeuso.ICargarCDRs;
import Persistencia.RegistrosCSV;

public class CargarCDRsTest {
	ICargarCDRs cargarCDRs;
	String casoDeUso;
	
	@BeforeTest
	public void setup() {
		cargarCDRs = new CargarCDRs(new RegistrosCSV());
		casoDeUso = "CasoDeUsoCargarCDRs";
	}
	
	@Test
	public void test_ObtenerNombreCasoDeUso() {
		assertEquals(cargarCDRs.obtenerCasoDeUso(), casoDeUso);
	}
	
	@Test
	public void test_CargarCDRs() {
		cargarCDRs.cargarCDRs();
	}
}
