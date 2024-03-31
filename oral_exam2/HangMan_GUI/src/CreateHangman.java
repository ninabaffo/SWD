import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import java.util.Arrays;
import java.util.Scanner;

import static javafx.application.Application.launch;

public class CreateHangman extends JFrame {
    private JTextField guessField, userGuess; // users guess & Field
    private JTextField wordField, wordInput; // users input for the word & field
    private JTextArea outputArea, numLeftArea, readoutArea, incorrectField; // where the outputs will be displayed
    private int numGuessesLeft = 10;
    public String[] wordChoice, readoutArray;
    public String letterGuessed, incorrectGuesses, correctGuesses;

    /**
     * createHangman constructor sets up the GUI to enter the word and guesses
     */
    public CreateHangman() {
        super("Hangman");
        setLayout(new FlowLayout());

        // a place to enter the word to be guessed
        wordField = new JTextField("Enter word to use in the game: ");
        add(wordField); // add wordField to JFrame
        wordField.setEditable(false); // disable editing

        // empty column for user to input word
        wordInput = new JTextField(10);
        add(wordInput);

        // a place for user enter a letter to guess
        guessField = new JTextField("Enter letter to guess: ");
        add(guessField);
        guessField.setEditable(false);
        guessField.setVisible(false);

        // empty column for user to input guess
        userGuess = new JTextField(3);
        add(userGuess);
        userGuess.setVisible(false);

        // display number of guesses left
        numLeftArea = new JTextArea();
        add(numLeftArea);
        numLeftArea.setEditable(false);
        numLeftArea.setVisible(false);

        // display incorrect guesses so far
        incorrectField = new JTextArea("Incorrect guesses: ");
        add(incorrectField);
        incorrectField.setEditable(false);
        incorrectField.setVisible(false);

        // display readout
        readoutArea = new JTextArea();
        add(readoutArea);
        readoutArea.setEditable(false);

        // add handlers
        TextFieldHandler handler = new TextFieldHandler();
        wordInput.addActionListener(handler);
        userGuess.addActionListener(handler);

    }

    /**
     * private inner class textFieldHandler handles events when user enters a word for the game, letter for the guess,
     * and when the game is over because there are no guesses left
     */
    private class TextFieldHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == wordInput) { // if user presses enter in wordField
                numLeftArea.setText("Number of guesses left: " + numGuessesLeft); // display guesses left
                setWordChoice(event.getActionCommand()); // set the word

            } else if (event.getSource() == userGuess) { // if user presses enter in guessField
                if (numGuessesLeft > 0) { // if user has not run out of guesses yet
                    numLeftArea.setText("Number of guesses left: " + numGuessesLeft); // display number of guesses left
                    checkGuess(event.getActionCommand()); // call check guess to check if it was in the word or not
                    numGuessesLeft = numGuessesLeft - 1; // subtract 1 from the number of guesses user has left
                } else { // else if they have no guesses left
                    numLeftArea.setText("No guesses left, game over );");
                    guessField.setVisible(false); // take away the guessField
                    userGuess.setVisible(false);
                }
            }
        }
    }

    /**
     * setWordChoice sets the inputted String to the word choice the user has to guess. It also initializes the "readout"
     * array with the amount of letters in the word inputted.
     * @param wordInputted users word choice for the game
     */
    public void setWordChoice(String wordInputted) {
        // set the word the user is going to be guessing in an array so we can individually access elements
        wordChoice = new String[wordInputted.length()];
        readoutArray = new String[wordInputted.length()];
        wordField.setVisible(false); // set to false so user cant see the inputted word
        wordInput.setVisible(false);
        int i = 0;

        // set the readout array to "_" equal the amt of characters in the word and put the word into an array
        while (i < wordInputted.length()) {
            wordChoice[i] = String.valueOf(wordInputted.charAt(i));
            readoutArray[i] = "_";
            i++;
        }
        readoutArea.setText("Correct guesses: " + Arrays.toString(readoutArray)); // display readout
        guessField.setVisible(true);
        userGuess.setVisible(true);
        numLeftArea.setVisible(true);
        incorrectField.setVisible(true);
    }

    /**
     * checkGuess takes a string input and checks if that letter is in the word choice. if it is, the readout array will
     * fill the spot with the letter and if not it will be added to the incorrect field for incorrect letters
     * @param input is the letter guessed by the user
     */
    public void checkGuess(String input) {
        letterGuessed = input; // set the input to letter the user guessed
        String tempStr = "";
        int i = 0;
        int count = 0;
        while (i < wordChoice.length) {
            if (letterGuessed.equals(wordChoice[i])) {
                readoutArray[i] = letterGuessed;
                count += 1; // if we guessed the letter correctly increment count to for the incorrect field
            }
            i++;
        }
        if (count == 0) {
            // append it to the incorrect letters guessed
            incorrectField.append(letterGuessed);
        }

        readoutArea.setText("Correct guesses: " + Arrays.toString(readoutArray));

    }
}
