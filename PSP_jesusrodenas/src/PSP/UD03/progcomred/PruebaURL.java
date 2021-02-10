/**
 * 
 */
package PSP.UD03.progcomred;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author JESUS
 *
 */
public class PruebaURL {
	public static void main(String[] args) {
		URL url;
		try {
			System.out.println("Constructor simple para una URL:");
			url = new URL("http://docs.oracle.com/");
			visualizar(url);
			System.out.println("Otro constructor simple para una URL:");
			url = new URL("http://localhost/PFC/gest/cli_gestion,php?S=3");
			visualizar(url);
			System.out.println("Const. para protocolo +URL +directorio:");
			url = new URL("http", "docs.oracle.com", "/javase/7");
			visualizar(url);
			System.out.println("Constructor para protocolo + URL + puerto + directorio:");
			url = new URL("http", "docs.oracle.com", 80, "/javase/7");
			visualizar(url);
			System.out.println("Constructor para un objeto URL y un directorio:");
			URL urlBase = new URL("http://docs.oracle.com/");
			url = new URL(urlBase, "/javase/7/docs/api/java/net/URL.html");
			visualizar(url);
			URL urlConecta = new URL("http://elaltozano.es/");
			conecta(urlConecta);
		} catch (MalformedURLException e) {
			System.out.println(e);
		}

	}

	private static void visualizar(URL url) {
		System.out.println("\tURL completa: " + url.toString());
		System.out.println("\tgetProtocol(): " + url.getProtocol());
		System.out.println("\tgetHost(): " + url.getHost());
		System.out.println("\tgetPort(): " + url.getPort());
		System.out.println("\tgetFile() : " + url.getFile());
		System.out.println("\tgetUserInfo (): " + url.getUserInfo());
		System.out.println("\tgetPath(): " + url.getPath());
		System.out.println("\tgetAuthority(): " + url.getAuthority());
		System.out.println("\tgetQuery(): " + url.getQuery());
		System.out.println("=================================================");

	} //

	public static void conecta(URL url) {
		BufferedReader in;
		try {
			InputStream inputStream = url.openStream();
			in = new BufferedReader(new InputStreamReader(inputStream));
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				System.out.println(inputLine);				
			}
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
