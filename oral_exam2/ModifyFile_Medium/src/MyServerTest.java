import javax.swing.*;
import java.io.*;
public class MyServerTest {
    public static void main (String[] args) throws IOException {
        MyServer application2 = new MyServer();
        application2.startServer();
        application2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
