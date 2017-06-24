package kingsChess;

import java.io.*;
import java.net.*;
import java.util.*;

public class KingChessClient {
	ArrayList<User> userList = new ArrayList(); // Chứa danh sách của các
												// client đang kết nối.
	static ObjectInputStream _Input;
	static ObjectOutputStream _Output;

	public void addUser(User user) {
		userList.add(user);
	}

	public void ListenThread() {
		Thread IncomingReader = new Thread(new IncomingReader());
		IncomingReader.start();
	}

	public class IncomingReader implements Runnable {
		@Override
		public void run() {
			Object message;
			try {
				while ((message = _Input.readObject()) != null) {
					((DataTransfer)message).handleAction(); // nhan ket qua tu server
				}
			} catch (Exception e) {
				System.out.println("somehow got an error");
			}
		}
	}
	
	public static void sayToServer(DataTransfer data)
	{
		try {
			_Output.writeObject(data);
			_Output.flush();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public class ClientStart implements Runnable {
		@Override
		public void run() {
			try {
				Socket myClient = new Socket("127.0.0.1", 3200);

				_Input = new ObjectInputStream(myClient.getInputStream());
				_Output = new ObjectOutputStream(myClient.getOutputStream());

				ListenThread();

			} catch (Exception ex) {
				System.out.println("Something was wrong!!!");
			}

		}

	}

	public static void main(String[] args) {
		KingChessClient kcc = new KingChessClient();
		KingChessClient.ClientStart cs = kcc.new ClientStart();
		Thread listener = new Thread(cs);
		listener.start();
	}
	
}
