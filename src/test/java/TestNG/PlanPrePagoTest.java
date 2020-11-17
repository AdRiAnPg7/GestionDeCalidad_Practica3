package TestNG;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;


import Planes.IPlan;
import Planes.PlanPrePago;

public class PlanPrePagoTest {
	
	@Test
	public void esPrePago() {
		IPlan planPrePago = new PlanPrePago();
		assertEquals(planPrePago.obtenerNombre(), "PlanPrePago");
	}

}
