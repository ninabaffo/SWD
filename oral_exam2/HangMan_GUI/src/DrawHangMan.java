import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrawHangMan extends Application {
    private int hangmanNumber;
    private int guessesLeft = 12;
    private String incorrectGuesses = "";
    private String readOut = "";

    @FXML
    private AnchorPane anchorPane;

    // instance variables that refer to GUI components
    @FXML
    private Circle head = new Circle(205.0, 300.0, 10);
    @FXML
    private Line body = new Line(205.0, 290.0, 205.0, 220.0);
    @FXML
    private Line leftArm = new Line(205.0, 260.0, 190.0, 260.0);
    @FXML
    private Line rightArm = new Line(205.0, 260.0, 220.0, 260.0);
    @FXML
    private Line leftLeg = new Line(205.0, 290.0, 190.0, 260.0);
    @FXML
    private Line rightLeg = new Line(205.0, 290.0, 220.0, 310.0);

    public void start(Stage stage) {
        head.setStrokeWidth(5.0);
        Group root = new Group(head);
        Scene scene = new Scene(root, 600, 300);
        stage.setTitle("Hangman");
        stage.setScene(scene);
        stage.show();
    }

}