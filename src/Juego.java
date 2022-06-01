import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Juego {
	public static void main(String[] args) {

		BufferedReader lector = null;
		try {
			lector = new BufferedReader(new FileReader("personajes.in"));

		} catch (IOException e) {
			System.err.println(e);
		} finally {
			try {
                lector.close();
			} catch (Exception e) {
				System.err.println(e);
			}
		}
	}
}
