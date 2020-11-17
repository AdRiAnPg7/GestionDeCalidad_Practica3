package TestNG;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.testng.annotations.*;

import Casosdeuso.MostrarCDRs;
import Entidades.CDR;
public class MostrarCDRsTest {
	
	@Test
	void obtenerCasoDeUso() {
		MostrarCDRs cargarUsuarios= new MostrarCDRs(new ArrayList<CDR>());
		assertEquals("CasoDeUsoMostrarCDRs", cargarUsuarios.obtenerCasoDeUso());
	}

}
