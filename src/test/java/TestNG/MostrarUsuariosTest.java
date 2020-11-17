package TestNG;

import static org.testng.Assert.assertEquals;
import java.util.ArrayList;

import org.testng.annotations.*;

import Casosdeuso.MostrarUsuarios;
import Entidades.LineaTelefonica;
public class MostrarUsuariosTest {
	
	@Test
	void obtenerCasoDeUso() {
		MostrarUsuarios cargarUsuarios= new MostrarUsuarios(new ArrayList<LineaTelefonica>());
		assertEquals(cargarUsuarios.obtenerCasoDeUso(), "CasoDeUsoMostrarUsuarios");
	}

}
