package TestNG;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.testng.annotations.*;

import Planes.IPlan;
import Planes.PlanPostPago;

public class PlanPostPagoTest {
	
	@Test
	public void test() {
		IPlan planPostPago = new PlanPostPago();
		assertEquals("PlanPostPago", planPostPago.obtenerNombre());
	}

}
