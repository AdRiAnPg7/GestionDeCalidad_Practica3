package TestPlanes;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

import Planes.IPlan;
import Planes.PlanWow;

public class PlanWowTest {
	IPlan planWow = new PlanWow();
	
	@Test
	public void test_ObtenerPlanPlanWow() {
		assertEquals("PlanWow", planWow.obtenerNombre());
	}

}
