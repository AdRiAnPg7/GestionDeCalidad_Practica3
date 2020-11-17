package TestPersistencia;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Persistencia.RegistrosSQL;

public class RegistrosSQLTest {

	RegistrosSQL registrosSQL;
	String CDRsPath;
	String TelefonosPath;
	String fecha;
	String errorPath;
	int cantidadCDRs;
	int cantidadUsuarios;
	@BeforeTest 
	public void setup() {
		registrosSQL = new RegistrosSQL();
		CDRsPath = "C:\\Users\\Adrian\\eclipse-workspace\\ArquitecturaSoftware\\Persistencia\\Telefonia.db";
		TelefonosPath = "C:\\Users\\Adrian\\eclipse-workspace\\ArquitecturaSoftware\\Persistencia\\Telefonos.db";
		fecha = "01/01/2020";
		errorPath = "XYZ";
		cantidadCDRs = 3;
		cantidadUsuarios = 3;
	}
	
	@Test
	public void test_ConnectToCDRsDB() {
		registrosSQL.connect(CDRsPath);
	}
	
	@Test
	public void test_ConnectToTelefonossDB() {
		registrosSQL.connect(TelefonosPath);
	}
	
	@Test
	public void test_ErrorConnectToTelefonossDB() {
		registrosSQL.connect(errorPath);
		registrosSQL.close();
	}
	@Test
	public void test_DisconnectFromDB() {
		registrosSQL.close();
	}
	
	@Test
	public void test_LeerCDRs() {
		registrosSQL.leerCDRs();
	}
	
	@Test (dependsOnMethods = {"test_LeerCDRs"})
	public void test_CargarPlanATelefonos() {
		registrosSQL.cargarPlanATelefonos();
	}
	
	@Test (dependsOnMethods = {"test_LeerCDRs", "test_CargarPlanATelefonos"})
	public void test_GuardarCDRsCalculados() {
		registrosSQL.guardarCDRsCalculados(fecha);
	}
	
	@Test (dependsOnMethods = {"test_LeerCDRs"})
	public void test_MostrarCDRs() {
		registrosSQL.mostrarCDRs();
	}
	
	@Test (dependsOnMethods = {"test_LeerCDRs"})
	public void test_CantidadCDRs() {
		assertEquals(registrosSQL.cantidadCDRs(), cantidadCDRs);
	}
	
	@Test (dependsOnMethods = {"test_LeerCDRs"})
	public void test_CantidadUsuarios() {
		assertEquals(registrosSQL.cantidadUsuarios(), cantidadUsuarios);
	}

	@Test (dependsOnMethods = {"test_LeerCDRs"})
	public void test_ObtenerCDRs() {
		registrosSQL.obtenerCDRs();
	}
	
	@Test (dependsOnMethods = {"test_LeerCDRs"})
	public void test_ObtenerUsuarios() {
		registrosSQL.obtenerUsuarios();
	}
	
}
