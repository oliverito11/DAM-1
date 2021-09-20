import java.io.*;
public class AccesoAleatorio {
	public static void main(String[] args) {
		File log = new File(args[0]);
		RandomAccessFile raf;
		try {
			raf = new RandomAccessFile(log, "r");
		} catch (FileNotFoundException e) {
			System.err.println("FileNotFound: " + e.getMessage());
		}
		
	}
}
