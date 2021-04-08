/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udptime;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fedeg
 */
public class UDPServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DatagramSocket socket;
        DatagramPacket inpacket;
        DatagramPacket outpacket;
        int porta = 1033;
        String inmessaggio;
        String outmessaggio;
        byte[] buffer;
        Date data;
        try {
            socket = new DatagramSocket(porta);
            while(true) {
                System.out.println("Sono il server in ascolto sulla porta: "+ porta);
                buffer = new byte[256];
                inpacket = new DatagramPacket (buffer, buffer.length);
                socket.receive(inpacket);
                //Ottengo l'indirizzo del client con il metodo getAddress
                InetAddress indirizzoclient = inpacket.getAddress();
                //Porta client
                int portaclient = inpacket.getPort();
                //Data messaggio client
                inmessaggio = new String(inpacket.getData(),1,inpacket.getLength());
                System.out.println(indirizzoclient.getHostName());
                System.out.println("Il client è: "+indirizzoclient +" "+"nella porta: " +portaclient +" " +inmessaggio);
                socket.close();
            }
            
            
        } catch (SocketException ex) {
            Logger.getLogger(UDPServer.class.getName()).log(Level.SEVERE, null, ex);
            
        }
          catch (IOException ex) {
                    Logger.getLogger(UDPServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
