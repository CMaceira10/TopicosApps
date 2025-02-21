/*
 * Author: Christian Maceira
 */
package desplApp;

import java.io.*;
import java.net.*;

public class Cliente {
    static final String HOST = "localhost";
    static final int PUERTO = 5000;
    public Cliente() {
    try{
        System.out.println("Inicilaizando Cliente");
        Socket socketCliente = new Socket(HOST, PUERTO);
        InputStream mensajeDelServidor = socketCliente.getInputStream();
        DataInputStream flujoSecuencial = new DataInputStream(mensajeDelServidor);
        System.out.println(flujoSecuencial.readUTF());
        socketCliente.close();
    }
    catch(Exception e){
        System.out.println("Error en el cliente " + e.getMessage());
    }
    }
    public static void main(String[] args) {
        Cliente nuevoCliente = new Cliente();
    }
}
