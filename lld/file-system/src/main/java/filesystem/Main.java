package filesystem;

public class Main {
    public static void main(String[] args) {
        FileSystem fs = new FileSystem();

        fs.createFolder("/" , "home");
        fs.createFolder("home" , "roshan");
        fs.createFolder("home" , "yadav");
        fs.createFolder("home" , "test");

        fs.createFile("/" , "hm.txt");

        fs.list("home");



    }
}