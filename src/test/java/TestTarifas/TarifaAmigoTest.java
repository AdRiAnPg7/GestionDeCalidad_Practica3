package TestTarifas;

import static org.testng.Assert.assertEquals;
import java.time.LocalTime;
import org.testng.annotations.Test;
import Entidades.CDR;
import Entidades.LineaTelefonica;
import Entidades.Llamada;
import Planes.IPlan;
import Planes.PlanPostPago;
import Planes.PlanPrePago;
import Planes.PlanWow;
import Tarifas.TarifaAmigo;

public class TarifaAmigoTest {
	int numeroOrigen = 11111111;
	int numeroDestino = 88888888;
	LocalTime Duracion1Minuto = LocalTime.parse("00:01:00");
	LocalTime Duracion2Minutos = LocalTime.parse("00:02:00");
	LocalTime Duracion10Minutos = LocalTime.parse("00:10:00");
	LocalTime Duracion1MinutoY10Segundos = LocalTime.parse("00:01:10");
	LocalTime Duracion2MinutosY30Segundos = LocalTime.parse("00:02:30");
	LocalTime Duracion10MinutosY55Segundos = LocalTime.parse("00:10:55");
	LocalTime horaInicioLlamada = LocalTime.parse("00:02:35");
	LineaTelefonica telefonoOrigen = new LineaTelefonica(numeroOrigen,null);
	LineaTelefonica telefonoDestino = new LineaTelefonica(numeroDestino,null);
	Llamada llamada = new Llamada() ;
	IPlan planPrePago = new PlanPrePago();
	IPlan planPostPago = new PlanPostPago();
	IPlan planWow= new PlanWow();
	
	TarifaAmigo tarifaAmigo = new TarifaAmigo();
	
	int numeroAmigo1 = 10101010;
	int numeroAmigo2 = 22222222;
	int numeroAmigo3 = 33333333;
	int numeroAmigo4 = 44444444;
	int numeroAmigo5 = 55555555;
	
	LineaTelefonica telefonoAmigo1 = new LineaTelefonica(numeroAmigo1,null);	
	LineaTelefonica telefonoAmigo2 = new LineaTelefonica(numeroAmigo2,null);	
	LineaTelefonica telefonoAmigo3 = new LineaTelefonica(numeroAmigo3,null);	
	LineaTelefonica telefonoAmigo4 = new LineaTelefonica(numeroAmigo4,null);	
		

	@Test
	void test_CalcularTarifaAmigo() {
		TarifaAmigo tarifaAmigo = new TarifaAmigo();
		var CDR= new CDR (telefonoOrigen,telefonoAmigo1,horaInicioLlamada,Duracion1Minuto);
		
		tarifaAmigo.aniadirTelefonosAmigos(numeroAmigo1);
		planPrePago.aniadirTarifa(tarifaAmigo);
		
		telefonoOrigen.aniadirPlan(planPrePago);
		llamada.aniadirCDR(CDR);
		
		assertEquals(llamada.calcularCosto(), 0.00f);
	}
	
	@Test
	void test_CalcularTarifaAmigo2() {
		TarifaAmigo tarifaAmigo = new TarifaAmigo();
		var CDR= new CDR (telefonoOrigen,telefonoAmigo2,horaInicioLlamada,Duracion1Minuto);
		
		tarifaAmigo.aniadirTelefonosAmigos(numeroAmigo2);
		planPostPago.aniadirTarifa(tarifaAmigo);
		
		telefonoOrigen.aniadirPlan(	planPostPago);
		llamada.aniadirCDR(CDR);
		
		assertEquals(llamada.calcularCosto(), 0.00f);
	}
	
	@Test
	void test_CalcularTarifaAmigo3() {
		TarifaAmigo tarifaAmigo = new TarifaAmigo();
		var CDR= new CDR (telefonoOrigen,telefonoAmigo3,horaInicioLlamada,Duracion1Minuto);
		
		tarifaAmigo.aniadirTelefonosAmigos(numeroAmigo3);
		planWow.aniadirTarifa(tarifaAmigo);
		
		telefonoOrigen.aniadirPlan(	planWow);
		llamada.aniadirCDR(CDR);
		
		assertEquals(llamada.calcularCosto(), 0.00f);
	}
	
	@Test
	void test_CalcularTarifaAmigo4() {
		TarifaAmigo tarifaAmigo = new TarifaAmigo();
		var CDR= new CDR (telefonoOrigen,telefonoDestino,horaInicioLlamada,Duracion1Minuto);
		
		tarifaAmigo.aniadirTelefonosAmigos(numeroAmigo1);
		planPrePago.aniadirTarifa(tarifaAmigo);
		
		telefonoOrigen.aniadirPlan(planPrePago);
		llamada.aniadirCDR(CDR);
		
		assertEquals(llamada.calcularCosto(), 0.99f);
	}
	
	@Test
	void test_CalcularTarifaAmigo5() {
		TarifaAmigo tarifaAmigo = new TarifaAmigo();
		var CDR= new CDR (telefonoOrigen,telefonoDestino,horaInicioLlamada,Duracion1Minuto);
		
		tarifaAmigo.aniadirTelefonosAmigos(numeroAmigo2);
		planPostPago.aniadirTarifa(tarifaAmigo);
		
		telefonoOrigen.aniadirPlan(	planPostPago);
		llamada.aniadirCDR(CDR);
		
		assertEquals(llamada.calcularCosto(),  0.99f);
	}
	
	@Test
	void test_CalcularTarifaAmigo6() {
		TarifaAmigo tarifaAmigo = new TarifaAmigo();
		var CDR= new CDR (telefonoOrigen,telefonoDestino,horaInicioLlamada,Duracion1Minuto);
		
		tarifaAmigo.aniadirTelefonosAmigos(numeroAmigo3);
		planWow.aniadirTarifa(tarifaAmigo);
		
		telefonoOrigen.aniadirPlan(	planWow);
		llamada.aniadirCDR(CDR);
		
		assertEquals(llamada.calcularCosto(), 0.99f);
	}
	
	@Test
	void test_CalcularTarifaAmigo7() {
		TarifaAmigo tarifaAmigo = new TarifaAmigo();
		var CDR= new CDR (telefonoOrigen,telefonoDestino,horaInicioLlamada,Duracion2Minutos);
		
		tarifaAmigo.aniadirTelefonosAmigos(numeroAmigo1);
		planPrePago.aniadirTarifa(tarifaAmigo);
		
		telefonoOrigen.aniadirPlan(planPrePago);
		llamada.aniadirCDR(CDR);
		
		assertEquals(llamada.calcularCosto(), 1.98f);
	}
	
	@Test
	void test_CalcularTarifaAmigo8() {
		TarifaAmigo tarifaAmigo = new TarifaAmigo();
		var CDR= new CDR (telefonoOrigen,telefonoDestino,horaInicioLlamada,Duracion10Minutos);
		
		tarifaAmigo.aniadirTelefonosAmigos(numeroAmigo2);
		planPostPago.aniadirTarifa(tarifaAmigo);
		
		telefonoOrigen.aniadirPlan(	planPostPago);
		llamada.aniadirCDR(CDR);
		
		assertEquals(llamada.calcularCosto(),  9.90f);
	}
	
	@Test
	void test_CalcularTarifaAmigo9() {
		TarifaAmigo tarifaAmigo = new TarifaAmigo();		
		var CDR= new CDR (telefonoOrigen,telefonoDestino,horaInicioLlamada,Duracion1MinutoY10Segundos);
		
		tarifaAmigo.aniadirTelefonosAmigos(numeroAmigo3);
		planWow.aniadirTarifa(tarifaAmigo);
		
		telefonoOrigen.aniadirPlan(	planWow);
		llamada.aniadirCDR(CDR);
		
		assertEquals(llamada.calcularCosto(), 1.15f);
	}
	
	@Test
	void test_CalcularTarifaAmigo10() {
		TarifaAmigo tarifaAmigo = new TarifaAmigo();
		var CDR= new CDR (telefonoOrigen,telefonoDestino,horaInicioLlamada,Duracion2MinutosY30Segundos);
		
		tarifaAmigo.aniadirTelefonosAmigos(numeroAmigo3);
		planWow.aniadirTarifa(tarifaAmigo);
		
		telefonoOrigen.aniadirPlan(	planWow);
		llamada.aniadirCDR(CDR);
		System.out.println(llamada.toString());
		assertEquals(llamada.calcularCosto(), 2.47f);
	}
	@Test
	void test_CalcularTarifaAmigo11() {
		TarifaAmigo tarifaAmigo = new TarifaAmigo();
		var CDR= new CDR (telefonoOrigen,telefonoDestino,horaInicioLlamada,Duracion10MinutosY55Segundos);
		
		tarifaAmigo.aniadirTelefonosAmigos(numeroAmigo3);
		planWow.aniadirTarifa(tarifaAmigo);
		
		telefonoOrigen.aniadirPlan(	planWow);
		llamada.aniadirCDR(CDR);
	
		assertEquals(llamada.calcularCosto(),  10.81f);
	}
	
	@Test(description = "Añadiremos 4 Amigos")
	void test_CalcularTarifaAmigo4Amigos() {
		TarifaAmigo tarifaAmigo = new TarifaAmigo();
		var CDR= new CDR (telefonoOrigen,telefonoDestino,horaInicioLlamada,Duracion10MinutosY55Segundos);
		
		tarifaAmigo.aniadirTelefonosAmigos(numeroAmigo3);
		tarifaAmigo.aniadirTelefonosAmigos(numeroAmigo1);
		tarifaAmigo.aniadirTelefonosAmigos(numeroAmigo2);
		tarifaAmigo.aniadirTelefonosAmigos(numeroAmigo4);
		
		planWow.aniadirTarifa(tarifaAmigo);
		
		telefonoOrigen.aniadirPlan(	planWow);
		llamada.aniadirCDR(CDR);
	
		assertEquals(llamada.calcularCosto(),  10.81f);
	}
	
	@Test(description = "Añadiremos 5 Amigos")
	void test_CalcularTarifaAmigo5Amigos() {
		TarifaAmigo tarifaAmigo = new TarifaAmigo();
		var CDR= new CDR (telefonoOrigen,telefonoDestino,horaInicioLlamada,Duracion10MinutosY55Segundos);
		
		tarifaAmigo.aniadirTelefonosAmigos(numeroAmigo3);
		tarifaAmigo.aniadirTelefonosAmigos(numeroAmigo1);
		tarifaAmigo.aniadirTelefonosAmigos(numeroAmigo2);
		tarifaAmigo.aniadirTelefonosAmigos(numeroAmigo4);
		tarifaAmigo.aniadirTelefonosAmigos(numeroAmigo5);
		planWow.aniadirTarifa(tarifaAmigo);
		
		telefonoOrigen.aniadirPlan(	planWow);
		llamada.aniadirCDR(CDR);
	
		assertEquals(llamada.calcularCosto(),  10.81f);
	}
}
