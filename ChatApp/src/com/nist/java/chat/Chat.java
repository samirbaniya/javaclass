package com.nist.java.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Chat {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("192.168.1.1",8000);
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter writer = new PrintWriter(socket.getOutputStream(),true);
			
			BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
			
			String serverMessage;
			String clientMessage;
			
			while(true) {
				System.out.println("Client:");
				
				clientMessage = consoleReader.readLine();
				
				writer.println(clientMessage);
				
				if(clientMessage.equals("bye")) {
					break;
				}
			}
			reader.close();
			writer.close();
			consoleReader.close();
			socket.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	

}
