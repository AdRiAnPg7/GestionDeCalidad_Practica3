package TestNG;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.testng.annotations.*;

import Planes.IPlan;
import Planes.PlanWow;

public class PlanWowTest {
	
	@Test
	public void esPlanWow() {
		IPlan planWow = new PlanWow();
		assertEquals("PlanWow", planWow.obtenerNombre());
	}

}
