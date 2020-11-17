package TestEntidades;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Entidades.LineaTelefonica;
import Planes.IPlan;
import Planes.PlanPostPago;
import Planes.PlanPrePago;
import Planes.PlanWow;

public class LineaTelefonicaTest{
	int numeroTelefono;
	IPlan planPrePago;
	IPlan planPostPago;
	IPlan planWow;
	
	@BeforeTest
	public void setup() {
		numeroTelefono = 77556644;
		planPrePago = new PlanPrePago();
		planPostPago = new PlanPostPago();
		planWow= new PlanWow();
	}
	
	@Test
	void test_ObtenerNumeroTelefonico() {
		LineaTelefonica telefono = new LineaTelefonica(numeroTelefono, null);
		assertEquals(telefono.obtenerNumero(), numeroTelefono);
	}
	
	@Test
	void test_AniadirNumeroTelefonico() {
		LineaTelefonica telefono = new LineaTelefonica(numeroTelefono, null);
		telefono.aniadirNumero(7101000);
		assertEquals(telefono.obtenerNumero(), 7101000);
	}
	
	@Test
	void test_AniadirNombre() {
		LineaTelefonica telefono = new LineaTelefonica(numeroTelefono, null);
		telefono.aniadirNombre("Prueba");
		assertEquals(telefono.obtenerNombre(), "Prueba");
	}
	
	@Test
	void test_ObtenerNombreVacio() {
		LineaTelefonica telefono = new LineaTelefonica(numeroTelefono, null);
		assertEquals(telefono.obtenerNombre(), null);
	}
	
	@Test
	void test_ObtenerPlan() {
		LineaTelefonica telefono = new LineaTelefonica(numeroTelefono, null);
		telefono.aniadirPlan(planPostPago);
		assertEquals(telefono.obtenerPlanString(), "PlanPostPago");
	}
	
}