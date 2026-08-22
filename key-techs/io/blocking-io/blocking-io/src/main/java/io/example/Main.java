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
            ServerSocket socket = new ServerSocket(PORT);

            System.out.println("Server started at port : "+PORT);

            while (true){
                Socket newConn = socket.accept();
                System.out.println("new connection with address : "+newConn.getRemoteSocketAddress());
                new Thread(()->{
                    try {
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