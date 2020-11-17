package Persistencia;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;

import org.apache.log4j.Logger;


import Entidades.CDR;
import Entidades.LineaTelefonica;
import Planes.PlanPostPago;
import Planes.PlanPrePago;
import Planes.PlanWow;
import Tarifas.TarifaNormal;
import Tarifas.TarifaAmigo;
import Tarifas.TarifaHorarios;

public class RegistrosSQL implements IRepositorio {
	
	private static final String TELEFONO = "Telefono";
	ArrayList <CDR> CDRs  = new ArrayList<CDR>();
	ArrayList <LineaTelefonica> usuarios  = new ArrayList<LineaTelefonica>();
	Connection conexion;
	int cantidadUsuarios=0;
	int cantidadCDRs=0;
	String CDRsPath = "C:\\Users\\Adrian\\eclipse-workspace\\ArquitecturaSoftware\\Persistencia\\Telefonia.db";
	String TelefonosPath = "C:\\Users\\Adrian\\eclipse-workspace\\ArquitecturaSoftware\\Persistencia\\Telefonos.db";
	Logger logger = Logger.getLogger(Class.class);
	
	public void connect(String Path){
		String filePath = Path;
		try {
			logger.debug("jdbc:sqlite:" + filePath);
			conexion = DriverManager.getConnection("jdbc:sqlite:" + filePath);
			logger.debug("Conectado");
		} catch (SQLException exception){
			logger.debug("No se Ha Podido Conectar a La Base De Datos\n" + exception.getMessage());
		}
	}
	
	public void close() {
		try {
			conexion.close();
		}catch (SQLException exception){
			logger.debug("No se Ha Podido Cerrar la Base De Datos\n" + exception.getMessage());
		}
	}
	
	@Override
	public ArrayList<CDR> obtenerCDRs() {
		return CDRs;
	}
	
	
	@Override
	public void leerCDRs() {
		connect(CDRsPath);
	
		try (	PreparedStatement st = conexion.prepareStatement("select * from cdr");
				ResultSet result = st.executeQuery();
				){
			
			while (result.next()) {
				var planPostPago = new PlanPostPago ();
				planPostPago.aniadirTarifa(new TarifaNormal() );
				var telfOrigen = new LineaTelefonica(Integer.parseInt(result.getString("telefonoOrigen")), planPostPago);
				logger.debug(telfOrigen.obtenerNumero());
				var telfDestino = new LineaTelefonica(Integer.parseInt(result.getString("telefonoDestino")), null);
				logger.debug(telfDestino.obtenerNumero());
				var HoraInicioLlamada = LocalTime.parse(result.getString("horaInicioLlamada"));
				logger.debug(HoraInicioLlamada);
				var DuracionLlamada = LocalTime.parse(result.getString("duracionLlamada"));
				logger.debug(DuracionLlamada);
				var fechaLlamada = result.getString("fechaLlamada");
				logger.debug(DuracionLlamada);
				cantidadCDRs++;
				cantidadUsuarios++;
				CDR temporal = new CDR(telfOrigen,telfDestino,HoraInicioLlamada,DuracionLlamada, fechaLlamada);
				
				CDRs.add(temporal);
			}
			
		} catch(SQLException exception){
			logger.debug(exception.getMessage());
		}
		close();
	}

	@Override
	public void mostrarCDRs() {
		for (CDR CDR: CDRs) {
			logger.debug(CDR.obtenerNumeroDelTelefonoOrigen() + " " +
		    				   CDR.obtenerNumeroDelTelefonoDestino() + " " +
		    				   CDR.obtenerHoraInicioLlamada() + " " +
		    				   CDR.obtenerDuracionLlamada());
		}
	}

	@Override
	public void cargarPlanATelefonos() {
		connect(CDRsPath);
		
		try (	PreparedStatement st = conexion.prepareStatement("select * from cdr");
				ResultSet result = st.executeQuery();
				){
			
			while (result.next()) {
				asignarPlan(result);
			}
			
		} catch(SQLException exception){
			logger.debug(exception.getMessage());
		}finally {
			close();
		}
		
		
	}

	
	public void asignarPlan(ResultSet result) throws NumberFormatException, SQLException {
		
		if("PlanPrePago".equals(result.getString("Plan")) ) {
			asignarPlanPrePago(result);
		}
		else if("PlanPostPago".equals(result.getString("Plan")) ) {
			asignarPlanPostPago(result);
		}
		else if("PlanWow".equals(result.getString("Plan"))) {
			asignarPlanWow(result);
		}
		
	}

	private void asignarPlanWow(ResultSet result) throws SQLException {
		for (CDR CDR: CDRs) {
		    if(String.valueOf(CDR.obtenerNumeroDelTelefonoOrigen()).equals(result.getString(TELEFONO))) {
		    	var tarifa = new TarifaAmigo();
		    	var plan = new PlanWow();
		    	tarifa.aniadirTelefonosAmigos(Integer.parseInt(result.getString("TelefonoAmigo")));
		    	plan.aniadirTarifa(tarifa);
		    	CDR.telefonoOrigen.aniadirPlan(plan);
		    }
		}
	}

	private void asignarPlanPostPago(ResultSet result) throws SQLException {
		for (CDR CDR: CDRs) {
		    if(String.valueOf(CDR.obtenerNumeroDelTelefonoOrigen()).equals(result.getString(TELEFONO))) {
		    	var tarifa = new TarifaNormal();
		    	var plan = new PlanPrePago();
		    	plan.aniadirTarifa(tarifa);
		    	CDR.telefonoOrigen.aniadirPlan(plan);
		    }
		}
	}

	private void asignarPlanPrePago(ResultSet result) throws SQLException {
		for (CDR CDR: CDRs) {
		    if(String.valueOf(CDR.obtenerNumeroDelTelefonoOrigen()).equals(result.getString(TELEFONO))) {
		    	var tarifa = new TarifaHorarios();
		    	var plan = new PlanPrePago();
		    	plan.aniadirTarifa(tarifa);
		    	CDR.telefonoOrigen.aniadirPlan(plan);
		    }
		}
	}

	@Override
	public void guardarCDRsCalculados(String fecha) {
		        
		        int indice = 1;
		   
	        try{
	        	connect(CDRsPath); 
	        	
	        	for (CDR CDR: CDRs) {
	        		
	        		logger.debug(CDR.obtenerCosto());
	        		  try(PreparedStatement posted = conexion.prepareStatement(
	  	            		"UPDATE cdr SET costo=" +CDR.obtenerCosto()+" WHERE id = " +indice);
	        				  ){
	        		  posted.executeUpdate();
	        		   indice = indice + 1;
	        		  }
	        		   
	    		}
	          
	        } catch(Exception e){
	        	logger.debug(e);
	        	}
	        finally {
	        	logger.debug("Insert Completed.");
	        }
	        close();

	}

	@Override
	public ArrayList<LineaTelefonica> obtenerUsuarios() {
		return usuarios;
	}

	@Override
	public int cantidadUsuarios() {
	
		return cantidadUsuarios;
	}

	@Override
	public int cantidadCDRs() {

		return cantidadCDRs;
	}

}
