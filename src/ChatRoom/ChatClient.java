package ChatRoom;

import java.net.Socket;
import javax.swing.JFrame;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

 
public class ChatClient {
    static Socket server;
    static String username;
    
    public static void main(String[] args) 
    {
        StartupWindow s = new StartupWindow();
        s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        s.setVisible(true);
        
    }
}

