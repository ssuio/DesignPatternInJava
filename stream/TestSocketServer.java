package stream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TestSocketServer extends Thread{
	private ServerSocket serverSocket;
	private int port;
	private boolean running = false;
	
	public TestSocketServer(int port){
		this.port = port;
	}
	
	public void startServer(){
		try{
			if(serverSocket == null){
				serverSocket = new ServerSocket(this.port);
				this.start();
			}
			
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void stopServer(){
		this.running = false;
		this.interrupt();
	}
	
	@Override
	public void run(){
		running = true;
		while(running){
			try{
				System.out.println("Listening...");
				Socket socket = serverSocket.accept();
				RequestHandler  requestHandler = new RequestHandler(socket);
				requestHandler.start();
			}catch(IOException e){
				
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println("This is start");
		TestSocketServer testSockServer = new TestSocketServer(9999);
		testSockServer.startServer();
		
		try{
			Thread.sleep(15000);
		}catch(Exception e){
			
		}
		
		testSockServer.stopServer();
	}
}

class RequestHandler extends Thread{
	private Socket socket;
	public RequestHandler(Socket socket){
			this.socket = socket; 
	}
	
	@Override
	public void run(){
		try(
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			)
		{
			System.out.println("Received a connection!");
			
			
			out.println("Echo SSUIO Server!");
			out.flush();
			String line = in.readLine();
			while(line != null){
				if(line.matches(".*ABC")){
					System.out.println(line);
					out.println("SSUIO server : ABC recieved!");
				}
				else{
					System.out.println("NOT MATCH");
					out.println("SSUIO server : DON't KNOW");
					}
				out.flush();
				line = in.readLine();
			}
			System.out.println("Close connection");
		}catch(Exception e){
			
		}
	}
	
}
