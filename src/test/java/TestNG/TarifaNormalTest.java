package TestNG;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import java.time.LocalTime;
import Entidades.CDR;
import Entidades.LineaTelefonica;
import Entidades.Llamada;
import Planes.IPlan;
import Planes.PlanPostPago;
import Planes.PlanPrePago;
import Planes.PlanWow;
import Tarifas.ITarifaStrategy;

import Tarifas.TarifaNormal;
public class TarifaNormalTest {
	int numeroOrigen = 11111111;
	int numeroDestino = 88888888;
	IPlan planPrePago = new PlanPrePago();
	IPlan planPostPago = new PlanPostPago();
	IPlan planWow= new PlanWow();
	LocalTime horaInicioLlamada = LocalTime.parse("00:02:35");
	LocalTime Duracion1Minuto = LocalTime.parse("00:01:00");
	LocalTime Duracion2Minutos = LocalTime.parse("00:02:00");
	LocalTime Duracion10Minutos = LocalTime.parse("00:10:00");
	LocalTime Duracion1MinutoY10Segundos = LocalTime.parse("00:01:10");
	LocalTime Duracion2MinutosY30Segundos = LocalTime.parse("00:02:30");
	LocalTime Duracion10MinutosY55Segundos = LocalTime.parse("00:10:55");
	LineaTelefonica telefonoOrigen = new LineaTelefonica(numeroOrigen,null);
	LineaTelefonica telefonoDestino = new LineaTelefonica(numeroDestino,null);
	Llamada llamada = new Llamada() ;
	
	ITarifaStrategy tarifaNormal = new TarifaNormal();
	
	
	@Test
	void calcularTarifaHorarioNormal() {
		var CDR= new CDR (telefonoOrigen,telefonoDestino,horaInicioLlamada,Duracion1Minuto);
		
		planPrePago.aniadirTarifa(tarifaNormal);
		telefonoOrigen.aniadirPlan(planPrePago);
		llamada.aniadirCDR(CDR);
		
		assertEquals(llamada.calcularCosto(), 1.00f);

	}
	
	@Test
	void calcularTarifaHorarioNormal2() {
		var CDR= new CDR (telefonoOrigen,telefonoDestino,horaInicioLlamada,Duracion10Minutos);
		
		planPostPago.aniadirTarifa(tarifaNormal);
		telefonoOrigen.aniadirPlan(planPostPago);
		llamada.aniadirCDR(CDR);
		
		assertEquals(llamada.calcularCosto(),  10.00f);
	}
	
	@Test
	void calcularTarifaHorarioNormal3() {
		var CDR= new CDR (telefonoOrigen,telefonoDestino,horaInicioLlamada,Duracion2Minutos);
		
		planPostPago.aniadirTarifa(tarifaNormal);
		telefonoOrigen.aniadirPlan(planPostPago);
		llamada.aniadirCDR(CDR);
		
		assertEquals(llamada.calcularCosto(), 2.00f);
	}
	
	@Test
	void calcularTarifaHorarioNormal4() {
		var CDR= new CDR (telefonoOrigen,telefonoDestino,horaInicioLlamada,Duracion1MinutoY10Segundos);
		
		planPrePago.aniadirTarifa(tarifaNormal);
		telefonoOrigen.aniadirPlan(planPrePago);
		llamada.aniadirCDR(CDR);
		
		assertEquals(llamada.calcularCosto(), 1.17f);

	}
	
	@Test
	void calcularTarifaHorarioNormal5() {
		var CDR= new CDR (telefonoOrigen,telefonoDestino,horaInicioLlamada,Duracion10MinutosY55Segundos);
		
		planPostPago.aniadirTarifa(tarifaNormal);
		telefonoOrigen.aniadirPlan(planPostPago);
		llamada.aniadirCDR(CDR);
		
		assertEquals(llamada.calcularCosto(), 10.92f);
	}
	
	@Test
	void calcularTarifaHorarioNormal6() {
		var CDR= new CDR (telefonoOrigen,telefonoDestino,horaInicioLlamada,Duracion2MinutosY30Segundos);
		
		planPostPago.aniadirTarifa(tarifaNormal);
		telefonoOrigen.aniadirPlan(planPostPago);
		llamada.aniadirCDR(CDR);
		
		assertEquals(llamada.calcularCosto(), 2.50f);
	}
}
