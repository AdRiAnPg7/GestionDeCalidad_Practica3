package TestCasosDeUso;

import static org.testng.Assert.assertEquals;


import java.util.ArrayList;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Casosdeuso.IMostrarUsuarios;
import Casosdeuso.MostrarUsuarios;
import Entidades.LineaTelefonica;

public class MostrarUsuariosTest {
	IMostrarUsuarios mostrarUsuarios;
	LineaTelefonica linea1;
	LineaTelefonica linea2;
	int numero1;
	int numero2;
	ArrayList<LineaTelefonica> lista1;
	ArrayList<LineaTelefonica> lista2;
	String casoDeUso;
	
	@BeforeTest
	public void setup() {
		numero1 = 79338704;
		numero2 = 79396273;
		linea1 = new LineaTelefonica (numero1);
		linea2 = new LineaTelefonica (numero2);

		lista1 = new ArrayList<LineaTelefonica> ();
		lista1.add(linea1);
		lista1.add(linea2);
		lista2 = new ArrayList<LineaTelefonica> ();
		lista2.add(linea1);
		lista2.add(linea2);
		
		mostrarUsuarios = new MostrarUsuarios(lista1);
		casoDeUso = "CasoDeUsoMostrarUsuarios";
	}
	
	@Test
	public void test_ObtenerNombreCasoDeUso() {
		assertEquals(mostrarUsuarios.obtenerCasoDeUso(), casoDeUso);
	}
	
	@Test
	public void test_CargarUsuarios() {
		assertEquals(mostrarUsuarios.obtenerUsuarios(),lista2);
	}
}
