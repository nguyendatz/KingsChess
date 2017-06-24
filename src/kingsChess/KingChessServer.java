package kingsChess;

import java.io.*;
import java.net.*;
import java.util.*;

import kingsChess.KingChessClient.IncomingReader;
import kingsChess.KingChessServer.ServerStart;

public class KingChessServer {

	static ArrayList<ObjectOutputStream> clientTalking = new ArrayList(); // danh sach
        public static ArrayList<User> userList = new ArrayList(); // Chứa danh sách của các client đang kết nối.
        boolean clientGoling = false;
        public void addUser(User user) {
		userList.add(user);
	}
	public static void sayToPlayers(DataTransfer message) {
		try {
                    
			for (ObjectOutputStream bw : clientTalking) {// gui den tat ca client trong server
				bw.writeObject(message);
				bw.flush();
			}
                     //   DataTransfer data = new DataTransfer(true);
                        
                        
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

				while ((message = br.readObject()) != null) {   // nhan du lieu tu client
					((DataTransfer)message).handleAction(true);
				}

			} catch (Exception e) {
                                System.out.println("Lost a connection");
                                clientTalking.remove(this.bw);
                                DataTransfer data = new DataTransfer("Other client disconnected, this game will be closed");
                                data.sendToClient();
				

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

					clientTalking.add(_Output); // luu giu luong dang nc voi client nao
                                        
                                        if (clientTalking.size() == 1){ 
                                            DataTransfer data = new DataTransfer(User.getCurrent());
                                            _Output.writeObject(data);  // gui ban co
                                            DataTransfer helloClient = new DataTransfer("Hello client Your name is Client1! \n Please wait for other player");
                                            helloClient.sendToClient();
                                        }
                                        
                                        if (clientTalking.size() == 2){
                                            
                                            DataTransfer data = new DataTransfer(User.getCurrent());
                                            _Output.writeObject(data);  // gui ban co
                                            DataTransfer startTheGame = new DataTransfer("Client2 has connected, the game will be started \n========================\n");
                                            clientTalking.get(0).writeObject(startTheGame);
                                            clientTalking.get(0).flush();
                                            DataTransfer startTheGame1 = new DataTransfer("Hello client! Your name is client2! \n The game will be started \n========================\n");
                                            clientTalking.get(1).writeObject(startTheGame1);
                                            clientTalking.get(1).flush();
                                        }
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
