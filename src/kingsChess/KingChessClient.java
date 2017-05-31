package kingsChess;

import java.io.*;
import java.net.*;
import java.util.*;
public class KingChessClient {
    ArrayList<User> userList = new ArrayList(); // Chứa danh sách của các client đang kết nối.
    BufferedReader br;
    BufferedWriter bw;
    BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
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
            String message;
            try{
                
                while((message = br.readLine())!=null){
                    System.out.println(message);
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
            String send;
            try{
                Socket myClient = new Socket("127.0.0.1", 3200);
                br = new BufferedReader(new InputStreamReader(myClient.getInputStream()));
                bw = new BufferedWriter(new OutputStreamWriter(myClient.getOutputStream()));
                
                
                ListenThread();
                
                MainFrame main  = new MainFrame();
               while((send = br1.readLine())!=null){
                   bw.write(send);
                   bw.newLine();
                   bw.flush();
               }
                       
               
            }
            catch(Exception ex){
                System.out.println("Something was wrong!!!");
            }
            
            
        }
    
    }
    
    public static void main(String[] args) {
       KingChessClient kcc = new KingChessClient();
       Cell.Init();
       KingChessClient.ClientStart cs = kcc.new ClientStart();
       Thread listener = new Thread (cs);
       listener.start();
    }
    
}
