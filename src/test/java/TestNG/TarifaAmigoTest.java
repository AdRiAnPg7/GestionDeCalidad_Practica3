package TestNG;

import static org.testng.Assert.assertEquals;

import java.time.LocalTime;

import org.testng.annotations.Test;

import org.testng.annotations.*;
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
	
	LineaTelefonica telefonoAmigo1 = new LineaTelefonica(numeroAmigo1,null);	
	LineaTelefonica telefonoAmigo2 = new LineaTelefonica(numeroAmigo2,null);	
	LineaTelefonica telefonoAmigo3 = new LineaTelefonica(numeroAmigo3,null);	
	LineaTelefonica telefonoAmigo4 = new LineaTelefonica(numeroAmigo4,null);	
	
	@BeforeSuite
    public void suiteSetup1() {
        System.out.println("testClass1.suiteSetup1: before suite");
    }
	

	@Test
	void calcularTarifaAmigo() {
		TarifaAmigo tarifaAmigo = new TarifaAmigo();
		var CDR= new CDR (telefonoOrigen,telefonoAmigo1,horaInicioLlamada,Duracion1Minuto);
		
		tarifaAmigo.aniadirTelefonosAmigos(numeroAmigo1);
		planPrePago.aniadirTarifa(tarifaAmigo);
		
		telefonoOrigen.aniadirPlan(planPrePago);
		llamada.aniadirCDR(CDR);
		
		assertEquals( 0.00f, llamada.calcularCosto());
		
		telefonoOrigen.aniadirPlan(null);
		CDR = null;
		llamada.aniadirCDR(null);
		
	}
	
	@Test
	void calcularTarifaAmigo2() {
		TarifaAmigo tarifaAmigo = new TarifaAmigo();
		var CDR= new CDR (telefonoOrigen,telefonoAmigo2,horaInicioLlamada,Duracion1Minuto);
		
		tarifaAmigo.aniadirTelefonosAmigos(numeroAmigo2);
		planPostPago.aniadirTarifa(tarifaAmigo);
		
		telefonoOrigen.aniadirPlan(	planPostPago);
		llamada.aniadirCDR(CDR);
		
		assertEquals( 0.00f, llamada.calcularCosto());
	}
	
	@Test
	void calcularTarifaAmigo3() {
		TarifaAmigo tarifaAmigo = new TarifaAmigo();
		var CDR= new CDR (telefonoOrigen,telefonoAmigo3,horaInicioLlamada,Duracion1Minuto);
		
		tarifaAmigo.aniadirTelefonosAmigos(numeroAmigo3);
		planWow.aniadirTarifa(tarifaAmigo);
		
		telefonoOrigen.aniadirPlan(	planWow);
		llamada.aniadirCDR(CDR);
		
		assertEquals( 0.00f, llamada.calcularCosto());
	}
	
	@Test
	void calcularTarifaAmigo4() {
		TarifaAmigo tarifaAmigo = new TarifaAmigo();
		var CDR= new CDR (telefonoOrigen,telefonoDestino,horaInicioLlamada,Duracion1Minuto);
		
		tarifaAmigo.aniadirTelefonosAmigos(numeroAmigo1);
		planPrePago.aniadirTarifa(tarifaAmigo);
		
		telefonoOrigen.aniadirPlan(planPrePago);
		llamada.aniadirCDR(CDR);
		
		assertEquals( 0.99f, llamada.calcularCosto());
	}
	
	@Test
	void calcularTarifaAmigo5() {
		TarifaAmigo tarifaAmigo = new TarifaAmigo();
		var CDR= new CDR (telefonoOrigen,telefonoDestino,horaInicioLlamada,Duracion1Minuto);
		
		tarifaAmigo.aniadirTelefonosAmigos(numeroAmigo2);
		planPostPago.aniadirTarifa(tarifaAmigo);
		
		telefonoOrigen.aniadirPlan(	planPostPago);
		llamada.aniadirCDR(CDR);
		
		assertEquals( 0.99f, llamada.calcularCosto());
	}
	
	@Test
	void calcularTarifaAmigo6() {
		TarifaAmigo tarifaAmigo = new TarifaAmigo();
		var CDR= new CDR (telefonoOrigen,telefonoDestino,horaInicioLlamada,Duracion1Minuto);
		
		tarifaAmigo.aniadirTelefonosAmigos(numeroAmigo3);
		planWow.aniadirTarifa(tarifaAmigo);
		
		telefonoOrigen.aniadirPlan(	planWow);
		llamada.aniadirCDR(CDR);
		
		assertEquals( 0.99f, llamada.calcularCosto());
	}
	
	@Test
	void calcularTarifaAmigo7() {
		TarifaAmigo tarifaAmigo = new TarifaAmigo();
		var CDR= new CDR (telefonoOrigen,telefonoDestino,horaInicioLlamada,Duracion2Minutos);
		
		tarifaAmigo.aniadirTelefonosAmigos(numeroAmigo1);
		planPrePago.aniadirTarifa(tarifaAmigo);
		
		telefonoOrigen.aniadirPlan(planPrePago);
		llamada.aniadirCDR(CDR);
		
		assertEquals( 1.98f, llamada.calcularCosto());
	}
	
	@Test
	void calcularTarifaAmigo8() {
		TarifaAmigo tarifaAmigo = new TarifaAmigo();
		var CDR= new CDR (telefonoOrigen,telefonoDestino,horaInicioLlamada,Duracion10Minutos);
		
		tarifaAmigo.aniadirTelefonosAmigos(numeroAmigo2);
		planPostPago.aniadirTarifa(tarifaAmigo);
		
		telefonoOrigen.aniadirPlan(	planPostPago);
		llamada.aniadirCDR(CDR);
		
		assertEquals( 9.90f, llamada.calcularCosto());
	}
	
	@Test
	void calcularTarifaAmigo9() {
		TarifaAmigo tarifaAmigo = new TarifaAmigo();		
		var CDR= new CDR (telefonoOrigen,telefonoDestino,horaInicioLlamada,Duracion1MinutoY10Segundos);
		
		tarifaAmigo.aniadirTelefonosAmigos(numeroAmigo3);
		planWow.aniadirTarifa(tarifaAmigo);
		
		telefonoOrigen.aniadirPlan(	planWow);
		llamada.aniadirCDR(CDR);
		
		assertEquals( 1.15f, llamada.calcularCosto());
	}
	
	@Test
	void calcularTarifaAmigo10() {
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
	void calcularTarifaAmigo11() {
		TarifaAmigo tarifaAmigo = new TarifaAmigo();
		var CDR= new CDR (telefonoOrigen,telefonoDestino,horaInicioLlamada,Duracion10MinutosY55Segundos);
		
		tarifaAmigo.aniadirTelefonosAmigos(numeroAmigo3);
		planWow.aniadirTarifa(tarifaAmigo);
		
		telefonoOrigen.aniadirPlan(	planWow);
		llamada.aniadirCDR(CDR);
	
		assertEquals( 10.81f, llamada.calcularCosto());
	}
}
