package TestCasosDeUso;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import Casosdeuso.CargarUsuarios;
import Casosdeuso.ICargarUsuarios;
import Persistencia.RegistrosCSV;

public class CargarUsuariosTest {
	ICargarUsuarios cargarUsuarios;
	String casoDeUso;
	
	@BeforeTest
	public void setup() {
		cargarUsuarios = new CargarUsuarios(new RegistrosCSV());
		casoDeUso = "CasoDeUsoCargarUsuarios";
	}
	
	@Test
	public void test_ObtenerNombreCasoDeUso() {
		assertEquals(cargarUsuarios.obtenerCasoDeUso(), casoDeUso);
	}
	
	@Test
	public void test_CargarUsuarios() {
		cargarUsuarios.cargarUsuarios();
	}
}
