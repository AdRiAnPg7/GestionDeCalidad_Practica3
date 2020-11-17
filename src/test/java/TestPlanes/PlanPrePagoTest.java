package TestPlanes;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;


import Planes.IPlan;
import Planes.PlanPrePago;

public class PlanPrePagoTest {
	IPlan planPrePago = new PlanPrePago();
	
	@Test
	public void test_ObtenerPlanPrePago() {
		assertEquals(planPrePago.obtenerNombre(), "PlanPrePago");
	}

}
