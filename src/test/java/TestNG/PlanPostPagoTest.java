package TestNG;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

import Planes.IPlan;
import Planes.PlanPostPago;

public class PlanPostPagoTest {
	
	@Test
	public void esPostPago() {
		IPlan planPostPago = new PlanPostPago();
		assertEquals(planPostPago.obtenerNombre(), "PlanPostPago");
	}
	

}
