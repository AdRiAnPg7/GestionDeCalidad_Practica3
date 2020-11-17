package TestPlanes;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

import Planes.IPlan;
import Planes.PlanPostPago;

public class PlanPostPagoTest {
	IPlan planPostPago = new PlanPostPago();
	
	@Test
	public void test_ObtenerPlanPostPago() {
		assertEquals(planPostPago.obtenerNombre(), "PlanPostPago");
	}
	

}
