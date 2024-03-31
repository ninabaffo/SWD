import javafx.stage.Stage;
import javax.swing.*;
import static javafx.application.Application.launch;
public class HangmanMain {
    public static void main (String[] args){
        CreateHangman hangMan = new CreateHangman(); // create baseChange
        hangMan.setSize(700, 300);
        hangMan.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        hangMan.setVisible(true);
        launch(args);
    }
}