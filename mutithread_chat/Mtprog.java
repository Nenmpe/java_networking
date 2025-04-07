package mutithread_chat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Mtprog implements Runnable{
    public Socket client;
    
    public Mtprog(Socket client) {
        this.client = client;
    }
    @Override
    public void run(){
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
            BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
            BufferedReader bw1 = new BufferedReader(new InputStreamReader(System.in));
            String toClient, fromClient = "";
            while(true){
                fromClient = br.readLine();
                if(fromClient.equalsIgnoreCase("quit")){
                    break;
                }
                System.out.println("Client: " + fromClient);
                toClient = bw1.readLine();
                bw.write(toClient + "\n");
                bw.flush();     
            }
        } catch (IOException ie) {
            System.out.println("I/O Exception: " + ie.getMessage());           
        }
    }
}
