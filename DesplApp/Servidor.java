/*
 * Author: Christian Maceira
 */
package desplApp;

import java.io.*;
import java.net.*;

public class Servidor {
            static final int PUERTO = 5000;
            public Servidor(){
            try{
                System.out.println("Inicializando SERVIDOR");
                ServerSocket socketServidor = new ServerSocket(PUERTO);
                System.out.println("Escucho el puerto " + PUERTO);
                System.out.println("Esperando conexiones de clientes...");
                for(int numeroCliente = 0; numeroCliente < 3; numeroCliente ++){
                    Socket socketCliente = socketServidor.accept();
                    System.out.println("Sirvo al cliente " + numeroCliente + " en el puerto de comunicaciones " + socketCliente.getPort());
                    OutputStream mensajeParaCliente = socketCliente.getOutputStream();
                    DataOutputStream flujoSecuencial = new DataOutputStream(mensajeParaCliente);
                    flujoSecuencial.writeUTF("Bienvenido cliente " + numeroCliente + ".\nEl puerto de escucha es el " + socketCliente.getLocalPort() + " y el puerto de comunicaciones bidireccional es " + socketCliente.getPort());
                    socketCliente.close();
                }
                System.out.println("Demasiados clientes por hoy");
                System.out.println("Solamente puedo atender a 3 clientes");
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
        public static void main(String[] args) {
            Servidor miServidor = new Servidor();
        }
}
