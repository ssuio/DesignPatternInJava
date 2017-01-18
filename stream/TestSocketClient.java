package stream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TestSocketClient {
	public static void main(String[] args) {
		try(	
				Socket sock = new Socket("localhost",9999);
				PrintStream out = new PrintStream(sock.getOutputStream());
				BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			) {
			
			
			String line = null;
			Scanner scanner = new Scanner(System.in);
			while((line = in.readLine()) != null){
				
				System.out.println(line);
				
				String input = scanner.nextLine();
				out.println("Client:" + input);
				out.flush();
				//line = in.readLine();
				
				
			}
			
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
