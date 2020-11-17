package TestEntidades;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Entidades.LineaTelefonica;
import Planes.IPlan;
import Planes.PlanPostPago;
import Planes.PlanPrePago;
import Planes.PlanWow;

public class LlamadaTest {
  
	String NAME3;
	String NAME2;
	String NAME1;
	int numeroTelefono;
	IPlan planPrePago;
	IPlan planPostPago;
	IPlan planWow;
	
	@BeforeTest
	public void setup() {
		NAME3 = "Gamal";
		NAME2 = "Andres";
		NAME1 = "Adrian";
		numeroTelefono = 77556644;
		planPrePago = new PlanPrePago();
		planPostPago = new PlanPostPago();
		planWow= new PlanWow();
	}

	
	
	@Test
	void test_ObtenerNumeroTelefonico() {
		LineaTelefonica telefono = new LineaTelefonica(numeroTelefono,null);
		assertEquals(telefono.obtenerNumero(), numeroTelefono);
	}
	
	@Test
	void test_ObtenerPlanPrePago() {
		LineaTelefonica telefono = new LineaTelefonica(numeroTelefono,planPrePago);
		assertEquals(telefono.obtenerPlan().obtenerNombre(), "PlanPrePago");
	}
	
	@Test
	void test_ObtenerPlanPostPago() {
		LineaTelefonica telefono = new LineaTelefonica(numeroTelefono,planPostPago);
		assertEquals(telefono.obtenerPlan().obtenerNombre(), "PlanPostPago");
	}
	
	@Test
	void test_ObtenerPlanWow() {
		LineaTelefonica telefono = new LineaTelefonica(numeroTelefono,planWow);
		assertEquals("PlanWow", telefono.obtenerPlan().obtenerNombre());
	}
	
	@Test
	void test_ObtenerNombreAdrian() {
		LineaTelefonica telefono = new LineaTelefonica(numeroTelefono,planPrePago,NAME1);
		assertEquals(NAME1, telefono.obtenerNombre());
	}
	
	@Test
	void test_ObtenerNombreAndres() {
		LineaTelefonica telefono = new LineaTelefonica(numeroTelefono,planPostPago, NAME2);
		assertEquals(NAME2, telefono.obtenerNombre());
	}
	
	@Test
	void test_ObtenerNombreGamal() {
		LineaTelefonica telefono = new LineaTelefonica(numeroTelefono,planWow, NAME3);
		assertEquals(NAME3, telefono.obtenerNombre());
	}
	
	@Test
	void test_ObtenerTodosLosDatos() {
		LineaTelefonica telefono = new LineaTelefonica(numeroTelefono,planPrePago, NAME1);
		assertEquals(numeroTelefono, telefono.obtenerNumero());
		assertEquals(NAME1, telefono.obtenerNombre());
		assertEquals("PlanPrePago", telefono.obtenerPlan().obtenerNombre());
	}
	@Test
	void test_ObtenerTodosLosDatos2() {
		LineaTelefonica telefono = new LineaTelefonica(numeroTelefono,planPostPago, NAME2);
		assertEquals(numeroTelefono, telefono.obtenerNumero());
		assertEquals(NAME2, telefono.obtenerNombre());
		assertEquals("PlanPostPago", telefono.obtenerPlan().obtenerNombre());
	}
	@Test
	void test_ObtenerTodosLosDatos3() {
		LineaTelefonica telefono = new LineaTelefonica(numeroTelefono,planWow, NAME3);
		assertEquals(numeroTelefono, telefono.obtenerNumero());
		assertEquals(NAME3, telefono.obtenerNombre());
		assertEquals("PlanWow", telefono.obtenerPlan().obtenerNombre());
	}

  
}
