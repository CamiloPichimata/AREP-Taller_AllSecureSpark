package co.edu.escuelaing.AllSecureSpark;

import static spark.Spark.*; 

public class SparkWebHello { 
	public static void main(String[] args) {
		secure(getKeystore(), "123456", null, null);
		port(getPort());
		get("/hello", (req, res) -> "Hello World"); 
	}
	
	static int getPort() {
		if (System.getenv("PORT") != null) {
			return Integer.parseInt(System.getenv("PORT"));
		}
		return 5000;
	}
	
	static String getKeystore() {
		if (System.getenv("KEYSTORE") != null) {
			return System.getenv("keystore");
		}
		return "keystores/ecikeystore.p12";
	}
}

