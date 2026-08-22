package io.example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
    /*
     * blocking server which accept the connection and handovers to
     * another thread which completes the requests
     */
        try{
            final int PORT = 5001;
            // This ask Os to create a socket in listening state with given port
            ServerSocket socket = new ServerSocket(PORT);

            System.out.println("Server started at port : "+PORT);

            while (true){
                // Whenever a client tries to connection OS complete TCP 3 way
                // handshake then provide connection client through accept()
                // Server process keep waiting here till new connection comes
                Socket newConn = socket.accept();
                System.out.println("new connection with address : "+newConn.getRemoteSocketAddress());
                new Thread(()->{
                    try {
                        // We handover new connection to another thread which waits until data comes
                        handleConn(newConn);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
    private static void handleConn(Socket conn) throws IOException {
        try( InputStream in = conn.getInputStream()){
            int data;
            // Thread waiting for incoming data
            while ((data = in.read()) != -1) {

                System.out.println(
                        Thread.currentThread().getName()
                                + " received: "
                                + (char) data
                );
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            System.out.println("closing conn : "+conn.getRemoteSocketAddress());
            conn.close();
        }
    }
}