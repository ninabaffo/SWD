import java.util.HashMap;

/**
 * The class to convert a morse code phrase into english.
 */
public class ConvertToEnglish {
    private String userPhrase;
    private String morseToEnglishPhrase;
    // Constructor sets phrase
    ConvertToEnglish(String userMorsePhrase) { this.userPhrase = userMorsePhrase; }

    /**
     * Creates a HashMap for morse code and english phrases.
     * Checks for any unwanted characters.
     * If not, prints out the english phrase.
     */
    public void convertMorsePhrase() {
        // creating a hashmap object called morse2english to create keys for the morse code
        // to go with their English letter.
        HashMap<String, String> morse2english = new HashMap<String, String>();
        morse2english.put("*_", "A");
        morse2english.put("_***", "B");
        morse2english.put("_*_*", "C" );
        morse2english.put("_**", "D" );
        morse2english.put("*", "E");
        morse2english.put( "**_*", "F");
        morse2english.put("__*", "G" );
        morse2english.put("****", "H");
        morse2english.put("**", "I");
        morse2english.put("*___", "J");
        morse2english.put("_*_", "K");
        morse2english.put("*_**", "L");
        morse2english.put("__", "M");
        morse2english.put("_*", "N");
        morse2english.put("___", "O");
        morse2english.put("*__*", "P");
        morse2english.put("__*_", "Q");
        morse2english.put( "*_*", "R");
        morse2english.put( "***", "S");
        morse2english.put( "_", "T");
        morse2english.put("**_", "U");
        morse2english.put("***_", "V");
        morse2english.put("*__", "W");
        morse2english.put("_**_", "X");
        morse2english.put("_*__", "Y");
        morse2english.put("__**", "Z");
        morse2english.put("_____", "0");
        morse2english.put("*____", "1");
        morse2english.put("**___", "2");
        morse2english.put("***__", "3");
        morse2english.put("****_", "4");
        morse2english.put("*****", "5");
        morse2english.put("_****", "6");
        morse2english.put("__***", "7");
        morse2english.put("___**", "8");
        morse2english.put("____*", "9");

        String strArray[] = userPhrase.split(" ");

        if (userPhrase.isEmpty()){
            System.out.println("Please enter a string that is not empty.");
        }
        else {
            String tempStr2 = "";
            for (int i = 0; i < strArray.length; i++) {
                if (morse2english.containsKey(strArray[i])){
                    tempStr2 = morse2english.get(strArray[i]);
                }
                else if (strArray[i].equals("/") || strArray[i].equals(" ")){
                    tempStr2 = " ";
                }
                else {
                    System.out.println("Please enter a valid morse code statement.");
                    return;
                }
                morseToEnglishPhrase += tempStr2;
            }
    }
        System.out.println(morseToEnglishPhrase);
}
}

