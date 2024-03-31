import javax.swing.*;

/**
 * main method to create an instance of the BaseChange class and initialize the window
 */
public class BaseChange_Test {
    public static void main (String[] args) {
            BaseChange_1 baseChange = new BaseChange_1(); // create baseChange
            baseChange.setSize(700, 300);
            baseChange.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            baseChange.setVisible(true);
    }
}
