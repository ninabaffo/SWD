import javax.swing.*;
import java.io.IOException;
public class MyClientTest {
    public static void main(String[] args) throws IOException {

        MyClient application = new MyClient("127.0.0.1"); // create client application
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
