package TestNG;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

import Planes.IPlan;
import Planes.PlanWow;

public class PlanWowTest {
	
	@Test
	public void esPlanWow() {
		IPlan planWow = new PlanWow();
		assertEquals("PlanWow", planWow.obtenerNombre());
	}

}
