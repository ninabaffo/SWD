import java.util.HashMap;

/**
 *This class converts the english given phrase to morse code
 */
public class ConvertToMorseCode {
    private String phrase;
    private String convertedMorsePhrase;
    // Constructor sets phrase
    ConvertToMorseCode(String userPhrase) {
        this.phrase = userPhrase;
    }

    /**
     * Creates a HashMap for english to morse code.
     * Checks whether the phrase contains any unwanted characters.
     * If not, it prints out phrase in Morse Code
     */
    public void convertPhrase() {
        // creating a hashmap object called english2morse to create keys for the english letters
        // to go with their morse code value
        HashMap<String, String> english2morse = new HashMap<String, String>();
        english2morse.put("A", " *_ ");
        english2morse.put("B"," _*** ");
        english2morse.put("C"," _*_* ");
        english2morse.put("D"," _** ");
        english2morse.put("E", " * ");
        english2morse.put("F", " **_* ");
        english2morse.put("G"," __* ");
        english2morse.put("H", " **** ");
        english2morse.put("I", " ** ");
        english2morse.put("J", " *___ ");
        english2morse.put("K", " _*_ ");
        english2morse.put("L", " *_** ");
        english2morse.put("M", " __ ");
        english2morse.put("N", " _* ");
        english2morse.put("O", " ___ ");
        english2morse.put("P", " *__* ");
        english2morse.put("Q", " __*_ ");
        english2morse.put("R", " *_* ");
        english2morse.put("S", " *** ");
        english2morse.put("T", " _ ");
        english2morse.put("U", " **_ ");
        english2morse.put("V", " ***_ ");
        english2morse.put("W", " *__ ");
        english2morse.put("X", " _**_ ");
        english2morse.put("Y", " _*__ ");
        english2morse.put("Z", " __** ");
        english2morse.put("0", " _____ ");
        english2morse.put("1", " *____ ");
        english2morse.put("2", " **___ ");
        english2morse.put("3", " ***__ ");
        english2morse.put("4", " ****_ ");
        english2morse.put("5", " ***** ");
        english2morse.put("6", " _**** ");
        english2morse.put("7", " __*** ");
        english2morse.put("8", " ___** ");
        english2morse.put("9", " ____* ");

        char charArray[] = new char[phrase.length()];
        if (phrase.isEmpty()){
            String message = "Please enter a string that is not empty.";
            System.out.println(message);
        }
        else {
            phrase = phrase.toUpperCase();
            for (int i = 0; i < phrase.length(); i++) {
                phrase.getChars(i, phrase.length(), charArray, i);

                if (!Character.isLetterOrDigit(charArray[i]) && !Character.isWhitespace(charArray[i])){
                     String message2 = "Please enter a string with only letters, numbers, or spaces.";
                     System.out.println(message2);
                     return;
                }
                else {
                    String tempStr = "";
                    if (Character.isLetter(charArray[i])){
                        String str = String.valueOf(charArray[i]);
                        tempStr = english2morse.get(str);
                    }
                    else if (Character.isDigit(charArray[i])){
                        String str = String.valueOf(charArray[i]);
                        tempStr = english2morse.get(str);
                    }
                    else {
                        tempStr = "/";
                    }
                    convertedMorsePhrase += tempStr;
                }
            }
            System.out.println(convertedMorsePhrase);
        }
    }
}

