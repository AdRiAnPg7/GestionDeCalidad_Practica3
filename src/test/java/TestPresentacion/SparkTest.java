package TestPresentacion;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Presentacion.IPresentacion;
import Presentacion.Spark;

public class SparkTest {
	IPresentacion spark;
	String object;
	@BeforeTest
	public void setup() {
		spark = new Spark ();
		object = new String();
	}
	
	@Test
	public void test_IniciarPresentacion() {
		spark.iniciarPresentacion();
	}
	
	@Test
	public void testGet() {
		spark.getClass();
	}
}
