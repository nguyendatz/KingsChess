package kingsChess;
import java.io.*;
import java.net.*;
import java.util.*;
import kingsChess.KingChessServer.ServerStart;

public class KingChessServer {

    //ArrayList<BufferedWriter>  clientTalking  = new ArrayList(); // danh sach client dang noi chuyen 
          ArrayList<ObjectOutputStream>  clientTalking  = new ArrayList(); // danh sach client dang noi chuyen 
                
    public void sayToPlayers(Object message){
       try{
        //for(BufferedWriter bw : clientTalking){
        for(ObjectOutputStream bw : clientTalking){
            bw.writeObject(message);
            //bw.newLine();
            bw.flush();
       
            }
       } catch(Exception e){
           System.out.println("Cant send message to clients");
       }
        
       
    }
    
    public class ClientHandler implements Runnable{
        //BufferedReader br;
        ObjectInputStream br;
        Socket myClient;
        //BufferedWriter bw;
        ObjectOutputStream bw;
        //public ClientHandler(Socket myClient, BufferedWriter bw)
        public ClientHandler(Socket myClient, ObjectOutputStream bw)
        {
            try{
                this.bw = bw;
                this.myClient = myClient;
                //br = new BufferedReader(new InputStreamReader(this.myClient.getInputStream()));
                br=new ObjectInputStream(this.myClient.getInputStream());
            }catch(Exception e){
                System.out.println("Error");
            }
        }

        @Override
        public void run(){
            Object message;
            try{
                sayToPlayers("Hello client");
                //while((message = br.readLine())!=null)
                while((message = br.readObject())!=null)
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
                
                    Cell.Init();
                    
                   while(clientTalking.size()<=2)
                   {
                    System.out.println("Waiting for players...");
                    Socket myClient = new Socket();
                    myClient = myServer.accept();   // waiting for clients    
                    ObjectInputStream _Input  =new ObjectInputStream(myClient.getInputStream());
                      System.out.println("123");
                    ObjectOutputStream _Output  = new ObjectOutputStream(myClient.getOutputStream());
                  
                    _Output.writeObject(User.getCurrent());
                   // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(myClient.getOutputStream()));
                  //  clientTalking.add(bw);  // luu giu luong dang nc voi client nao
                    clientTalking.add(_Output);  // luu giu luong dang nc voi client nao
                   // Thread listener = new Thread(new ClientHandler(myClient, bw));
                    Thread listener = new Thread(new ClientHandler(myClient, _Output));
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
