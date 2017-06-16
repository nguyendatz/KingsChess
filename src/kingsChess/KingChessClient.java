package kingsChess;

import java.io.*;
import java.net.*;
import java.util.*;
public class KingChessClient {
    ArrayList<User> userList = new ArrayList(); // Chứa danh sách của các client đang kết nối.
    ObjectInputStream _Input;
    ObjectOutputStream _Output;
    
    public void addUser(User user)
    {
       userList.add(user);
    }
   
    public void ListenThread(){
         Thread IncomingReader = new Thread(new IncomingReader());
         IncomingReader.start();
}
    
    public class IncomingReader implements Runnable{
        @Override
        public void run(){
            Object message;
            try{
                message = _Input.readObject();
                User.setCurrent((User)message);
                MainFrame main  = new MainFrame();
                
                while((message = _Input.readObject())!=null)
                {
                    System.out.println(message);    // nhan ket qua tu server
                }
                System.out.println(message);
            }catch(Exception e){
                System.out.println("somehow got an error");
            }
        }
    }
    
    public class ClientStart implements Runnable{
        @Override
        public void run(){
            try{
                Socket myClient = new Socket("127.0.0.1", 3200);
                
                _Input = new ObjectInputStream(myClient.getInputStream());
                _Output = new ObjectOutputStream(myClient.getOutputStream());
                
                ListenThread();        
               
            }
            catch(Exception ex){
                System.out.println("Something was wrong!!!");
            }
            
            
        }
    
    }
    
    public static void main(String[] args) {
       KingChessClient kcc = new KingChessClient();
       KingChessClient.ClientStart cs = kcc.new ClientStart();
       Thread listener = new Thread (cs);
       listener.start();
    }
    
}
