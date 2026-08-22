## Requirement: 
    - Basic understanding of java
    - Basic understanding of Operating system
        - Process 
        - Thread 
        - Memory 
        - basics of sockets

## What will you understand:
    - What is Blocking io, how it works and what is limitations of it.


## Brief of how web works:
    Client side Actions
        1. Client want to access google.com from broswer
        2. On request Browser creates one or more process or thread 
        3. Ask Os to create a TCP connection with client IP
        4. Os create Socket with TCP connection Object
        5. Browser ask OS to Data transfer 
        6. Os create TCP segment -> IP Packets -> ethername/wifi Frames and sends to NIC

    Server side Actions
        1. Server aceept the connection mean OS create a TCP connection object
        2. NIC receives the data
        3. Using DMA transfer this to OS Network stack
        4. Os Socket buffer receive data and transfer it to App server using JVM
        5. App server writes back some response using JVM 

![io-01.png](../images/io-01.png)
                
            



