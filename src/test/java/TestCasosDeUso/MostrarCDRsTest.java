package TestCasosDeUso;

import static org.testng.Assert.assertEquals;

import java.time.LocalTime;
import java.util.ArrayList;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import Casosdeuso.IMostrarCDRs;
import Casosdeuso.MostrarCDRs;
import Entidades.CDR;
import Entidades.LineaTelefonica;


public class MostrarCDRsTest {
	IMostrarCDRs mostrarCDRs;
	LineaTelefonica lineaOrigen;
	LineaTelefonica lineaDestino;
	int numero1;
	int numero2;
	CDR cdr;
	LocalTime horaInicial = LocalTime.parse("10:10:00");
	LocalTime duracionLlamada = LocalTime.parse("00:10:00");
	ArrayList<CDR> CDRs;
	ArrayList<CDR> CDRs2;
	String casoDeUso;
	
	@BeforeTest
	public void setup() {
		numero1 = 79338704;
		numero2 = 79396273;
		lineaOrigen = new LineaTelefonica (numero1);
		lineaDestino = new LineaTelefonica (numero2);
		cdr = new CDR(lineaOrigen, lineaDestino, horaInicial, duracionLlamada );
		CDRs = new ArrayList<CDR> ();
		CDRs.add(cdr);
		CDRs2 = new ArrayList<CDR> ();
		CDRs2.add(cdr);

		mostrarCDRs = new MostrarCDRs(CDRs);
		casoDeUso = "CasoDeUsoMostrarCDRs";
	}
	
	@Test
	public void test_ObtenerNombreCasoDeUso() {
		assertEquals(mostrarCDRs.obtenerCasoDeUso(), casoDeUso);
	}
	
	@Test
	public void test_obtenerCDRs() {
		assertEquals(mostrarCDRs.obtenerCDRs(),CDRs2);
	}
}
