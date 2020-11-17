package TestEntidades;

import static org.testng.Assert.assertEquals;

import java.time.LocalTime;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Entidades.CDR;
import Entidades.LineaTelefonica;

public class CDRTest {
	CDR cdr;
	LineaTelefonica linea1;
	LineaTelefonica linea2;
	int telefono1;
	int telefono2;
	String fecha;
	LocalTime time = LocalTime.parse("00:01:00");
	
	@BeforeTest
	public void setup() {
		cdr = new CDR (null, null, null, null);
		telefono1 = 77889911;
		telefono2 = 66887722;
		fecha = "11/11/2020";
		linea1 = new LineaTelefonica(telefono1);
		linea2 = new LineaTelefonica(telefono2);
	}
	
	@Test
	void test_AniadirTelefonoOrigen() {
		cdr.aniadirTelefonoOrigen(linea1);
		assertEquals(cdr.obtenerTelefonoOrigen(),linea1);
	}
	
	@Test
	void test_AniadirTelefonoDestino() {
		cdr.aniadirTelefonoDestino(linea2);
		assertEquals(cdr.obtenerTelefonoDestino(),linea2);
	}
	
	@Test
	void test_AniadirHoraInicioLlamada() {
		cdr.aniadirHoraInicioLlamada(time);
		assertEquals(cdr.obtenerHoraInicioLlamada(),time);
	}
	
	@Test
	void test_AniadirFecha() {
		cdr.aniadirFecha(fecha);
		assertEquals(cdr.obtenerFecha(),fecha);
	}
	
	@Test
	void test_AniadirDuracionLlamada() {
		cdr.aniadirDuracionLlamada(time);
		assertEquals(cdr.obtenerDuracionLlamada(),time);
	}
}
