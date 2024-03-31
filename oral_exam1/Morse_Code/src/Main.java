// Name: Nina Baffo
// Date: 2/9/23
// Filename: Morse_Code
// Description: A program that reads an English-language phrase and converts it to morse code.
import java.util.HashMap;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // have user input phrase they want to convert
        String phrase1 = "Hi my name is nina";
        ConvertToMorseCode phrase2convert1 = new ConvertToMorseCode(phrase1);

        System.out.println("Phrase:" + phrase1);
        System.out.println("Correct Output: **** ** / __  _*__ / _*  *_  __  * / **  *** / _*  **  _*  *_ ");
        System.out.println("Actual Output: ");
        phrase2convert1.convertPhrase();

        String phrase2 = "My lucky number is 20 ";
        ConvertToMorseCode phrase2convert2 = new ConvertToMorseCode(phrase2);

        System.out.println("\nPhrase: " + phrase2);
        System.out.println("Correct Output: __  _*__  / *_**  **_  _*_*  _*_  _*__ / _*  **_  __  _***  *  *_* / ** *** / **___ _____ /");
        System.out.println("Actual Output: ");
        phrase2convert2.convertPhrase();

        String phrase3 = "My username is @Nina";
        ConvertToMorseCode phrase2convert3 = new ConvertToMorseCode(phrase3);
        System.out.println("\nPhrase: "+ phrase3);
        System.out.println("Correct Output: 'Please enter a string with only letters, numbers or spaces.");
        System.out.println("Actual Output: ");
        phrase2convert3.convertPhrase();

        String phrase4 = "*__* ** _* _*_ / ** *** / __ _*__ / **_* *_ ***_ ___ *_* ** _ * / _*_* ___ *_** ___ *_*";
        ConvertToEnglish phrase2convert4 = new ConvertToEnglish(phrase4);
        System.out.println("\nPhrase: "+ phrase4);
        System.out.println("Correct Output: Pink is my favorite color");
        System.out.println("Actual Output: ");
        phrase2convert4.convertMorsePhrase();

        String phrase5 = "** / *_ __ / **___ **___ / _*__ * *_ *_* *** / ___ *_** _**";
        ConvertToEnglish phrase2convert5 = new ConvertToEnglish(phrase5);
        System.out.println("\nPhrase: "+ phrase5);
        System.out.println("Correct Output: I am 22 years old");
        System.out.println("Actual Output: ");
        phrase2convert5.convertMorsePhrase();

        String phrase6 = "**** ** !";
        ConvertToEnglish phrase2convert6 = new ConvertToEnglish(phrase6);
        System.out.println("\nPhrase: " + phrase6);
        System.out.println("Correct Output: Please enter a valid morse code statement");
        System.out.println("Actual Output: ");
        phrase2convert6.convertMorsePhrase();
    }
}
