package io.example;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        /*
        Non blocking server which does not wait to accept the connection
        also does wait for incoming data on connection and removes both waiting problems

         * */

        final int PORT = 5002;

        // This is similar to ServerSocket ss =new ServerSocket()   we ask os to create a socket in listening mode
        // which is blocking means it waits for incoming connection
        try(ServerSocketChannel ssc = ServerSocketChannel.open()){

            // Binding a address to socket
            ssc.bind(new InetSocketAddress(PORT));

            // Make it non blocking
            ssc.configureBlocking(false);

            Selector selector = Selector.open();

            ssc.register(
                    selector,
                    SelectionKey.OP_ACCEPT
            );

            System.out.println(
                    "server is running to PORT :"+PORT
            );

            while (true) {
                // Blocking return only after one channel is available for the io
                selector.select();

                Iterator<SelectionKey> selectionKeyIterator = selector.selectedKeys().iterator();

                while (selectionKeyIterator.hasNext()){

                    SelectionKey key = selectionKeyIterator.next();
                    selectionKeyIterator.remove();

                    if(key.isAcceptable()){
                        ServerSocketChannel ssChannel = (ServerSocketChannel) key.channel();
                        SocketChannel client  = ssChannel.accept();

                        client.configureBlocking(false);

                        client.register(
                           selector
                          ,SelectionKey.OP_READ
                        );

                        System.out.println(
                                "Client connected: "
                                        + client.getRemoteAddress()
                        );

                    } else if (key.isReadable()) {
                        SocketChannel client =
                                (SocketChannel) key.channel();

                        ByteBuffer buffer =
                                ByteBuffer.allocate(1024);

                        int bytesRead =
                                client.read(buffer);

                        if (bytesRead == -1) {
                            client.close();
                            continue;
                        }

                        buffer.flip();

                        while (buffer.hasRemaining()) {
                            System.out.print(
                                    (char) buffer.get()
                            );
                        }
                    }

                }


            }

        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}