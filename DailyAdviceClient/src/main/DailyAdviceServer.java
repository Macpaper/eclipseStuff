package main;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class DailyAdviceServer {

	String[] adviceList = {"Take smaller bites", 
			"Go take a walk outside. Whenever you don't feel as sick, but you should probably go out anyway.",
			"probably meditate", "Do at least one hour of coding", "do some yoga", 
			"activate cold turkey", "there's a lot of shit to do, maybe you should rest instead"};
	
	public void go() {
		try {
			ServerSocket serverSock = new ServerSocket(4242);
			
			while(true) {
				Socket sock = serverSock.accept();
				
				PrintWriter writer = new PrintWriter(sock.getOutputStream());
				String advice = getAdvice();
				writer.println(advice);
				writer.close();
				System.out.println(advice);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	private String getAdvice() {
		int random = (int) (Math.random() * adviceList.length);
		return adviceList[random];
	}
	
	public static void main(String[] args) {
		DailyAdviceServer server = new DailyAdviceServer();
		server.go();
	}

}
