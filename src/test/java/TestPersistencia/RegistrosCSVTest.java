package TestPersistencia;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Persistencia.RegistrosCSV;

public class RegistrosCSVTest {
	RegistrosCSV registrosCSV;
	String fecha;
	int cantidadCDRs;
	int cantidadUsuarios;
	@BeforeTest 
	public void setup() {
		registrosCSV = new RegistrosCSV();
		fecha = "asdasd";
		cantidadCDRs = 5;
		cantidadUsuarios = 4;
	}
	
	
	@Test
	public void test_LeerCDRs() {
		registrosCSV.leerCDRs();
	}
	
	@Test (dependsOnMethods = {"test_LeerCDRs"})
	public void test_CargarPlanATelefonos() {
		registrosCSV.cargarPlanATelefonos();
	}
	
	
	@Test (dependsOnMethods = {"test_LeerCDRs","test_CargarPlanATelefonos"})
	public void test_GuardarCDRsCalculados() {
		registrosCSV.guardarCDRsCalculados(fecha);
	}
	
	@Test (dependsOnMethods = {"test_LeerCDRs"})
	public void test_MostrarCDRs() {
		registrosCSV.mostrarCDRs();
	}
	
	@Test (dependsOnMethods = {"test_LeerCDRs"})
	public void test_CantidadCDRs() {
		assertEquals(registrosCSV.cantidadCDRs(), cantidadCDRs);
	}
	

	
	@Test (dependsOnMethods = {"test_LeerCDRs","test_GuardarCDRsCalculados"})
	public void test_CantidadUsuarios() {
		assertEquals(registrosCSV.cantidadUsuarios(), cantidadUsuarios);
	}

	@Test (dependsOnMethods = {"test_LeerCDRs"})
	public void test_ObtenerCDRs() {
		registrosCSV.obtenerCDRs();
	}
	
	@Test (dependsOnMethods = {"test_LeerCDRs"})
	public void test_ObtenerUsuarios() {
		registrosCSV.obtenerUsuarios();
	}
}
