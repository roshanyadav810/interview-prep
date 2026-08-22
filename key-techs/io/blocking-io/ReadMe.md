# Blocking IO and it's limitations
    We will use Java for example

## Basics
    - Everything in linux is a file and whenever we open a file os provides file descriptor which
        is a integer through we can access (read/write) to file. 
    - Whenever OS accept a connection it create a TCP Socket which basically a file as well and 
        App receives FD for that socket
    - Java's Tradition way for handling file io is below machanism
        - InputStream - Abstarct claas. provides read method to Read data from file
        - InputStream
            │
            │ defines byte reading
            ▼
            SOURCE
            │
            ├── File - FileInputStream - To Read from File
            ├── Memory - ByteArrayInputStream - To Read from Memory like byte[]
            └── Pipe - PipedInputStream - inter thread communication
            
                    +
            
            DECORATOR
            │
            ├── Buffer - BufferedInputStream we can provide a buffer while reading so Application can read buffer size bytes in one go.
            └── Data interpretation - DataInputStream Read in java primitive data type like 

