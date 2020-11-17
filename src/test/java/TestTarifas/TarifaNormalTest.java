package TestTarifas;

import org.testng.annotations.BeforeTest;
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
	int numeroOrigen;
	int numeroDestino;
	IPlan planPrePago;
	IPlan planPostPago;
	IPlan planWow;
	LocalTime horaInicioLlamada;
	LocalTime Duracion1Minuto;
	LocalTime Duracion2Minutos;
	LocalTime Duracion10Minutos;
	LocalTime Duracion10MinutosY55Segundos;
	LineaTelefonica telefonoOrigen;
	LineaTelefonica telefonoDestino;
	Llamada llamada;
	
	ITarifaStrategy tarifaNormal;
	
	@BeforeTest
	public void setup() {
		numeroOrigen = 11111111;
		numeroDestino = 88888888;
		planPrePago = new PlanPrePago();
		planPostPago = new PlanPostPago();
		planWow = new PlanWow();
		horaInicioLlamada = LocalTime.parse("00:02:35");
		Duracion1Minuto = LocalTime.parse("00:01:00");
		Duracion2Minutos = LocalTime.parse("00:02:00");
		Duracion10Minutos = LocalTime.parse("00:10:00");
		Duracion10MinutosY55Segundos = LocalTime.parse("00:10:55");
		telefonoOrigen = new LineaTelefonica(numeroOrigen,null);
		telefonoDestino = new LineaTelefonica(numeroDestino,null);
		llamada = new Llamada() ;
		
		tarifaNormal = new TarifaNormal();
	}
	
	@Test
	void test_CalcularTarifaHorarioNormal() {
		var CDR= new CDR (telefonoOrigen,telefonoDestino,horaInicioLlamada,Duracion1Minuto);
		
		planPrePago.aniadirTarifa(tarifaNormal);
		telefonoOrigen.aniadirPlan(planPrePago);
		llamada.aniadirCDR(CDR);
		
		assertEquals(llamada.calcularCosto(), 1.00f);

	}
	
	@Test
	void test_CalcularTarifaHorarioNormal2() {
		var CDR= new CDR (telefonoOrigen,telefonoDestino,horaInicioLlamada,Duracion10Minutos);
		
		planPostPago.aniadirTarifa(tarifaNormal);
		telefonoOrigen.aniadirPlan(planPostPago);
		llamada.aniadirCDR(CDR);
		
		assertEquals(llamada.calcularCosto(),  10.00f);
	}
	
	@Test
	void test_CalcularTarifaHorarioNormal3() {
		var CDR= new CDR (telefonoOrigen,telefonoDestino,horaInicioLlamada,Duracion2Minutos);
		
		planPostPago.aniadirTarifa(tarifaNormal);
		telefonoOrigen.aniadirPlan(planPostPago);
		llamada.aniadirCDR(CDR);
		
		assertEquals(llamada.calcularCosto(), 2.00f);
	}
	
	
	@Test
	void test_CalcularTarifaHorarioNormal4() {
		var CDR= new CDR (telefonoOrigen,telefonoDestino,horaInicioLlamada,Duracion10MinutosY55Segundos);
		
		planPostPago.aniadirTarifa(tarifaNormal);
		telefonoOrigen.aniadirPlan(planPostPago);
		llamada.aniadirCDR(CDR);
		
		assertEquals(llamada.calcularCosto(), 10.92f);
	}
	

}
