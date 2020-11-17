package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;


import Persistencia.IRepositorio;
import Persistencia.RegistrosCSV;
import Persistencia.RegistrosSQL;


class TestPersistencia {

	IRepositorio repositorio;
	

	
	@Test
	void obtenerCantidadCDRsSQL() {
		repositorio= new RegistrosSQL();
		repositorio.leerCDRs();
	
		repositorio.cantidadUsuarios();
		assertEquals(3, repositorio.cantidadCDRs());
	}
	
	@Test
	void obtenerCantidadUsuariosSQL() {
		repositorio= new RegistrosSQL();
		repositorio.leerCDRs();
	
		repositorio.cantidadUsuarios();
		assertEquals(3, repositorio.cantidadUsuarios());
	}

}
