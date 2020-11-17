package TestPersistencia;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Persistencia.RegistrosSQL;

public class RegistrosSQLTest {

	RegistrosSQL registrosSQL;
	String CDRsPath;
	String TelefonosPath;
	String fecha;
	String errorPath;
	
	@BeforeTest 
	public void setup() {
		registrosSQL = new RegistrosSQL();
		CDRsPath = "C:\\Users\\Adrian\\eclipse-workspace\\ArquitecturaSoftware\\Persistencia\\Telefonia.db";
		TelefonosPath = "C:\\Users\\Adrian\\eclipse-workspace\\ArquitecturaSoftware\\Persistencia\\Telefonos.db";
		fecha = "01/01/2020";
		errorPath = "XYZ";
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
	public void test_ErroronnectToTelefonossDB() {
		registrosSQL.connect(errorPath);
		registrosSQL.close();
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
	
	
	
}
