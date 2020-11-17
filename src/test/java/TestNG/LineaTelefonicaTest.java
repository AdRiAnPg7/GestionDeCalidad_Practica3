package TestNG;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import Entidades.LineaTelefonica;
import Planes.IPlan;
import Planes.PlanPostPago;
import Planes.PlanPrePago;
import Planes.PlanWow;

public class LineaTelefonicaTest{
	int numeroTelefono = 77556644;
	IPlan planPrePago = new PlanPrePago();
	IPlan planPostPago = new PlanPostPago();
	IPlan planWow= new PlanWow();
	
	@Test
	void obtenerNumeroTelefonico() {
		LineaTelefonica telefono = new LineaTelefonica(numeroTelefono, null);
		assertEquals(telefono.obtenerNumero(), numeroTelefono);
	}
	
	@Test
	void aniadirNumeroTelefonico() {
		LineaTelefonica telefono = new LineaTelefonica(numeroTelefono, null);
		telefono.aniadirNumero(7101000);
		assertEquals(telefono.obtenerNumero(), 7101000);
	}
	
	@Test
	void aniadirNombre() {
		LineaTelefonica telefono = new LineaTelefonica(numeroTelefono, null);
		telefono.aniadirNombre("Prueba");
		assertEquals(telefono.obtenerNombre(), "Prueba");
	}
	
	@Test
	void obtenerNombreVacio() {
		LineaTelefonica telefono = new LineaTelefonica(numeroTelefono, null);
		assertEquals(telefono.obtenerNombre(), null);
	}
	
	@Test
	void obtenerPlan() {
		LineaTelefonica telefono = new LineaTelefonica(numeroTelefono, null);
		telefono.aniadirPlan(planPostPago);
		assertEquals(telefono.obtenerPlanString(), "PlanPostPago");
	}
	
}