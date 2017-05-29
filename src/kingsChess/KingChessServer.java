package kingsChess;
import java.io.*;
import java.net.*;
import java.util.*;
import kingsChess.KingChessServer.ServerStart;

public class KingChessServer {

    ArrayList<BufferedWriter>  clientTalking  = new ArrayList(); // danh sach client dang noi chuyen 
    public void sayToPlayers(String message){
       try{
        for(BufferedWriter bw : clientTalking){
            bw.write(message);
            bw.newLine();
            bw.flush();
       
            }
       } catch(Exception e){
           System.out.println("Cant send message to clients");
       }
        
       
    }
    
    public class ClientHandler implements Runnable{
        BufferedReader br;
        Socket myClient;
        BufferedWriter bw;
        public ClientHandler(Socket myClient, BufferedWriter bw)
        {
            try{
                this.bw = bw;
                this.myClient = myClient;
                br = new BufferedReader(new InputStreamReader(this.myClient.getInputStream()));
                
            }catch(Exception e){
                System.out.println("Error");
            }
        }

        @Override
        public void run(){
            String message;
            try{
                sayToPlayers("Hello client");
                while((message = br.readLine())!=null)
                {
                   // System.out.println(message);
                    sayToPlayers(message);
                }
                
                
            }catch(Exception e){
                System.out.println("Lost a connection");
            
            }
        
        
        }
    
    }

    public class ServerStart implements Runnable{
        @Override
        public void run(){
            try{
                ServerSocket myServer = new ServerSocket(3200);
                
                   while(clientTalking.size()<=2)
                   {
                    System.out.println("Waiting for players...");
                    Socket myClient = new Socket();
                    myClient = myServer.accept();   // waiting for clients                  
                    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(myClient.getOutputStream()));
                    clientTalking.add(bw);  // luu giu luong dang nc voi client nao
                    Thread listener = new Thread(new ClientHandler(myClient, bw));
                    listener.start();
                    
                    System.out.println("Got connection");
            }
            }catch(Exception e){
                System.out.println("Cant connect with clients");         
            }
            
        }
    
    }
  
    
    public static void main(String[] args){
        KingChessServer ksc = new KingChessServer();
        KingChessServer.ServerStart st = ksc.new ServerStart();
        Thread listener = new Thread(st);
        listener.start();
    }
    
}
