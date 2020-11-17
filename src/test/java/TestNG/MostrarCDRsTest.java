package TestNG;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;

import org.testng.annotations.*;

import Casosdeuso.MostrarCDRs;
import Entidades.CDR;
public class MostrarCDRsTest {
	
	@Test
	void obtenerCasoDeUso() {
		MostrarCDRs cargarUsuarios= new MostrarCDRs(new ArrayList<CDR>());
		assertEquals(cargarUsuarios.obtenerCasoDeUso(), "CasoDeUsoMostrarCDRs");
	}

}
