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
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author fedeg
 */
public class UDPClient {
    public static void main(String[] args) {
        // TODO code application logic here
        DatagramSocket socket;
        DatagramPacket inpacket;
        DatagramPacket outpacket;
        int porta = 1033;
        String inmessaggio;
        String outmessaggio;
        byte[] buffer;
        InetAddress nomeserver;
        try {
            nomeserver = InetAddress.getLocalHost();
            System.out.println("Sono il client");
            socket = new DatagramSocket();
            outmessaggio = "MC";
            outpacket = new DatagramPacket(outmessaggio.getBytes(), outmessaggio.length(), nomeserver, porta);
            socket.send(outpacket);
            
            
        } catch (UnknownHostException ex) {
            Logger.getLogger(UDPClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SocketException ex) {
                Logger.getLogger(UDPClient.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
            Logger.getLogger(UDPClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
