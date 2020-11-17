package TestNG;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import Entidades.LineaTelefonica;
import Planes.IPlan;
import Planes.PlanPostPago;
import Planes.PlanPrePago;
import Planes.PlanWow;

public class TelefonoTest {
  
  private static final String NAME3 = "Gamal";
	private static final String NAME2 = "Andres";
	private static final String NAME1 = "Adrian";
	int numeroTelefono = 77556644;
	IPlan planPrePago = new PlanPrePago();
	IPlan planPostPago = new PlanPostPago();
	IPlan planWow= new PlanWow();

	
	
	@Test
	void obtenerNumeroTelefonico() {
		LineaTelefonica telefono = new LineaTelefonica(numeroTelefono,null);
		assertEquals(telefono.obtenerNumero(), numeroTelefono);
	}
	
	@Test
	void obtenerPlanPrePago() {
		LineaTelefonica telefono = new LineaTelefonica(numeroTelefono,planPrePago);
		assertEquals(telefono.obtenerPlan().obtenerNombre(), "PlanPrePago");
	}
	
	@Test
	void obtenerPlanPostPago() {
		LineaTelefonica telefono = new LineaTelefonica(numeroTelefono,planPostPago);
		assertEquals(telefono.obtenerPlan().obtenerNombre(), "PlanPostPago");
	}
	
	@Test
	void obtenerPlanWow() {
		LineaTelefonica telefono = new LineaTelefonica(numeroTelefono,planWow);
		assertEquals("PlanWow", telefono.obtenerPlan().obtenerNombre());
	}
	
	@Test
	void obtenerNombreAdrian() {
		LineaTelefonica telefono = new LineaTelefonica(numeroTelefono,planPrePago,NAME1);
		assertEquals(NAME1, telefono.obtenerNombre());
	}
	
	@Test
	void obtenerNombreAndres() {
		LineaTelefonica telefono = new LineaTelefonica(numeroTelefono,planPostPago, NAME2);
		assertEquals(NAME2, telefono.obtenerNombre());
	}
	
	@Test
	void obtenerNombreGamal() {
		LineaTelefonica telefono = new LineaTelefonica(numeroTelefono,planWow, NAME3);
		assertEquals(NAME3, telefono.obtenerNombre());
	}
	
	@Test
	void obtenerTodosLosDatos() {
		LineaTelefonica telefono = new LineaTelefonica(numeroTelefono,planPrePago, NAME1);
		assertEquals(numeroTelefono, telefono.obtenerNumero());
		assertEquals(NAME1, telefono.obtenerNombre());
		assertEquals("PlanPrePago", telefono.obtenerPlan().obtenerNombre());
	}
	@Test
	void obtenerTodosLosDatos2() {
		LineaTelefonica telefono = new LineaTelefonica(numeroTelefono,planPostPago, NAME2);
		assertEquals(numeroTelefono, telefono.obtenerNumero());
		assertEquals(NAME2, telefono.obtenerNombre());
		assertEquals("PlanPostPago", telefono.obtenerPlan().obtenerNombre());
	}
	@Test
	void obtenerTodosLosDatos3() {
		LineaTelefonica telefono = new LineaTelefonica(numeroTelefono,planWow, NAME3);
		assertEquals(numeroTelefono, telefono.obtenerNumero());
		assertEquals(NAME3, telefono.obtenerNombre());
		assertEquals("PlanWow", telefono.obtenerPlan().obtenerNombre());
	}

  
}
