package kingsChess;

import java.io.*;
import java.net.*;
import java.util.*;

import kingsChess.KingChessClient.IncomingReader;
import kingsChess.KingChessServer.ServerStart;

public class KingChessServer {

	static ArrayList<ObjectOutputStream> clientTalking = new ArrayList(); // danh sach
																	// client
																	// dang noi
																	// chuyen

	public static void sayToPlayers(DataTransfer message) {
		try {
			for (ObjectOutputStream bw : clientTalking) {
				bw.writeObject(message);
				bw.flush();

			}
		} catch (Exception e) {
			System.out.println("Cant send message to clients");
		}
	}

	public class ClientHandler implements Runnable {
		ObjectInputStream br;
		Socket myClient;
		ObjectOutputStream bw;

		public ClientHandler(Socket myClient, ObjectOutputStream bw) {
			try {
				this.bw = bw;
				this.myClient = myClient;
				br = new ObjectInputStream(this.myClient.getInputStream());
			} catch (Exception e) {
				System.out.println("Error");
			}
		}

		@Override
		public void run() {
			Object message;
			try {
				DataTransfer data = new DataTransfer("Hello client");
				data.sendToClient();
				
				while ((message = br.readObject()) != null) {
					((DataTransfer)message).handleAction(true);
				}

			} catch (Exception e) {
				System.out.println("Lost a connection");

			}
		}
	}

	public class ServerStart implements Runnable {
		@Override
		public void run() {
			try {
				ServerSocket myServer = new ServerSocket(3200);

				Cell.Init();

				while (clientTalking.size() <= 2) {
					System.out.println("Waiting for players...");
					Socket myClient = new Socket();
					myClient = myServer.accept(); // waiting for clients
					ObjectOutputStream _Output = new ObjectOutputStream(myClient.getOutputStream());
					
					DataTransfer data = new DataTransfer(User.getCurrent());
					_Output.writeObject(data);
					clientTalking.add(_Output); // luu giu luong dang nc voi
												// client nao
					Thread listener = new Thread(new ClientHandler(myClient, _Output));										
					listener.start();

					System.out.println("Got connection");
				}
			} catch (Exception e) {
				System.out.println("Cant connect with clients");
			}

		}

	}

	public static void main(String[] args) {
		KingChessServer ksc = new KingChessServer();
		KingChessServer.ServerStart st = ksc.new ServerStart();
		Thread listener = new Thread(st);
		listener.start();
	}

}
