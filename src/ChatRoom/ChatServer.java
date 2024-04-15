package ChatRoom;


import java.io.*;
import java.net.*;
import java.util.*;


public class ChatServer {
    
    static ArrayList<ProcessClient> users;
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        users = new ArrayList<ProcessClient>();
        Scanner input = new Scanner(System.in);
        
        try{
            ServerSocket ss = new ServerSocket(5190);
            while(true){
                
                Socket sock = ss.accept();
                ProcessClient temp = new ProcessClient(sock);
                users.add(temp);
                temp.start();
                System.out.println("200: Authentication Successful");
                
            }
        }
        catch(IOException e){
        	System.out.println("500: Authentication Failed");
        }
    }    
    
    
    static void sender(String username, String text) {
        for(int i = 0; i < users.size(); i++) {
            try {
                ProcessClient user = users.get(i);
                if(user.sock.isClosed()) {
                    users.remove(i);
                    i--;
                }
                else {
                    PrintStream ps = new PrintStream(user.sock.getOutputStream());
                    ps.println(username + ": " + text);
                }
            }
            catch (IOException e) {
                //System.out.println("error in sender");
            }
        }
    }
    
    static class ProcessClient extends Thread{
        String username;
        Socket sock;
        ProcessClient(Socket newSock){sock=newSock;}
        public void run(){
            try{
                //System.out.println(sock.getInetAddress().getHostAddress()+" connected");
                Scanner sin = new Scanner(sock.getInputStream());
                //PrintStream sout = new PrintStream(sock.getOutputStream());
                username = sin.nextLine();
                String message = "";
                while (true){
                    if(sin.hasNext()) {
                        String nextLine = sin.nextLine();
                        //sout.println(username + ": " + line);
                        //System.out.println("Inside the if for reaching end of line");
                        sender(username, nextLine);
                    }
                }
            }
            
            catch(IOException e){
                //System.out.println(sock.getInetAddress().getHostAddress()+" disconnected");}
            }
        }
    }
}