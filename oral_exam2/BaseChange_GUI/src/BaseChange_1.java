import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * BaseChange extends JFrame and uses Swing to set up the GUI
 */
public class BaseChange_1 extends JFrame {
    private JTextArea outputField; // where the output will be displayed
    private JTextField numberField, numberInput; // number Field & input
    private JTextField startBaseField, startBaseInput; // start base Field & input
    private JTextField endBaseField, endBaseInput; // end base Field & input
    private JTextField output; // to display output
    private int startBase, endBase, baseTenNum;
    private ArrayList<Integer> endBaseConversion;
    private String numberString;

    /**
     * constructor to set up the GUI which includes fields to ask the user for the start base,
     * number to convert and end base.
     */
    public BaseChange_1() {
        super("Inputs");
        setLayout(new FlowLayout());

        startBaseField = new JTextField("Enter start base (2 to 32): ");
        add(startBaseField); // add start base Field to JFrame
        startBaseField.setEditable(false); // disable editing

        // empty column for user to input start base
        startBaseInput = new JTextField(10);
        add(startBaseInput);

        numberField = new JTextField("Enter number: "); // create enterField
        add(numberField); // add number Field to JFrame
        numberField.setEditable(false); // disable editing

        // empty column for user to input number
        numberInput = new JTextField(10);
        add(numberInput);

        endBaseField = new JTextField("Enter end base (2 to 32): ");
        add(endBaseField); // add end base Field to JFrame
        endBaseField.setEditable(false); // disable editing

        // empty column for user to input end base
        endBaseInput = new JTextField(10);
        add(endBaseInput);


        outputField = new JTextArea("Answer: ");
        add(outputField); // add output Field to JFrame
        outputField.setEditable(false); // disable editing
        // outputField.setVisible(false);

        // register event handlers
        TextFieldHandler handler = new TextFieldHandler();
        numberInput.addActionListener(handler);
        startBaseInput.addActionListener(handler);
        endBaseInput.addActionListener(handler);

    }

    /**
     * private inner class for event handler TextFieldHandler gets the action performed. In this method
     * we check to see if the inputs are valid. If not, output a message telling the user to enter a different base.
     */
    private class TextFieldHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == startBaseInput) { // if user presses enter in start base field
                if (checkBase(event.getActionCommand())) {
                    setStartBase(event.getActionCommand());
                    JOptionPane.showMessageDialog(BaseChange_1.this, String.format(
                            "Start Base: %s", event.getActionCommand()));
                } else {
                    JOptionPane.showMessageDialog(BaseChange_1.this, String.format(
                            "Not a valid base input, please try again"));
                }
            }
            else if (event.getSource() == numberInput) { // if user presses enter in number field
                if (checkInputNum(event.getActionCommand())){ // check if valid number based on base
                    setNumber(event.getActionCommand()); // if it is valid, set the number
                    JOptionPane.showMessageDialog(BaseChange_1.this, String.format(
                            "Number: %s", event.getActionCommand()));
                }
                else {
                    JOptionPane.showMessageDialog(BaseChange_1.this, String.format(
                            "Not a valid number input for your start base, please try again"));
                }
            }
            else if (event.getSource() == endBaseInput) { // if user presses enter in end base field
                if (checkBase(event.getActionCommand())) { // check if valid base
                    setEndBase(event.getActionCommand()); // if it is valid, set the end base
                    JOptionPane.showMessageDialog(BaseChange_1.this, String.format(
                            "End Base: %s", event.getActionCommand()));
                } else { // if invalid base tell user to try again
                    JOptionPane.showMessageDialog(BaseChange_1.this, String.format(
                            "Not a valid base input, please try again"));
                }
            }
        }
    }

    /**
     * setNumber sets the number that is going to be converted
     * @param numberInput is the users inputted number
     */
    public void setNumber(String numberInput) {
        numberString = numberInput;
    }

    /**
     * setStartBase sets the start base inputted by the user
     * @param startBaseInput start base user input from GUI
     */
    public void setStartBase(String startBaseInput) {
        startBase = Integer.parseInt(startBaseInput);
    }

    /**
     * setEndBase sets the end base inputted by the user. This method also calls getDecimalConversion()
     * because after this point we have validated all three inputs.
     * @param endBaseInput end base user input from GUI
     */
    public void setEndBase(String endBaseInput) {
        endBase = Integer.parseInt(endBaseInput);
        getDecimalConversion(); // now that we validated all 3 inputs get the decimal conversion
    }

    /**
     * make sure that the inputted base is valid. user must enter base from 2 to 32, and base 29, 30 and 31 do not exist.
     * @param baseInput GUI inputted base
     * @return true if valid or false otherwise.
     */
    public boolean checkBase(String baseInput) {
        int baseInputted = Integer.parseInt(baseInput);
        if (baseInputted >=2 && baseInputted <= 32) {
            if (baseInputted == 29 || baseInputted == 30 || baseInputted == 31){ // invalid bases
                return false;
            }
            return true;
        }
        return false;
    }

    /**
     * checkInput num takes the inputNum as a String and checks make sure its in bits for bases 2, 8, 16 and 32.
     * @param inputNum inputted number in GUI
     * @return true if we made it through the loop and all the numbers are 0 or 1 for base 2, 8, 16 and  32 or false if not.
     * or returns true if any other base
     */
    public boolean checkInputNum(String inputNum){
        if (startBase == 2 || startBase == 8 || startBase == 16 || startBase == 32) { // if in base 2, 8, 16 or 32 the numbers need to be 0 or 1
            char[] numArray = inputNum.toCharArray(); // turn string into a char array to loop through it
            for (int i =0; i < numArray.length;){
                int tempNum = Integer.parseInt(String.valueOf(numArray[i])); // current integer value of numArray[i]
                if (tempNum == 1 || tempNum == 0){
                    i += 1;
                }
                else {
                    return false; // if tempNum is not 0 or 1 return false
                }
            }
            return true; // if we made it through the loop and they are all 0 or 1 return true
        }
        return true; // if its not base 2, 8, 16, or 32 return true
    }

    /**
     * getDecimalConversion converts any inputted number and base to the decimal version of that number. This makes
     * it easier to convert to whatever end base the user wants. Once baseTenNum is converted, call the method
     * end base conversion to get the final output.
     */
    public void getDecimalConversion(){
        if (startBase != 10){
            int amtOfNumbers = numberString.length(); // total amount of digits in the number inputted
            int digitPower = amtOfNumbers-1; // will be used to determine the power to raise the digit to
            double currentSum = 0;
            char[] numberArray = numberString.toCharArray(); // turn string into a char array to loop through it

            for (int i = 0; i < amtOfNumbers; i++) {
                // get the string value of the character at index i in the numberTemp string then parse to Integer
                int currentDigit = Integer.parseInt(String.valueOf(numberArray[i]));
                currentSum = (currentDigit * Math.pow(startBase, digitPower));
                digitPower -= 1;
                baseTenNum += currentSum;
            }

        }
        else {
            baseTenNum = Integer.parseInt(numberString);
        }
        getEndBaseConversion();
    }

    /**
     * getEndBaseConversion checks what base to convert to. If it is 10, return the baseTenNum. Else,
     * while the number is greater than 0, take the number and get the remainder of that number%endbase
     * then the set the numToConvert to numToConvert/endBase. Keep going until numToConvert is 0 and you will
     * have your converted number backwards. Traverse it and that will be the correct number.
     */
    public void getEndBaseConversion(){
        int numToConvert = baseTenNum; // numToConvert is what we'll use to compute conversion
        ArrayList<Integer> convertedNum = new ArrayList<>();

        if (endBase != 10){ // decimal to any base conversion thats not decimal
            int i = 0;
            while (numToConvert > 0){
                convertedNum.add(numToConvert % endBase);
                numToConvert = (numToConvert / endBase);
                i++;
            }
        }
        endBaseConversion = new ArrayList<>(convertedNum.size());
        // traverse the string to get the correct number
        int j = convertedNum.size()-1;

        while (j >= 0){
            endBaseConversion.add(convertedNum.get(j));
            j = j-1;
        }
        finalAnswer();
    }

    /**
     * finalAnswer outputs the converted number in the GUI
     */
    public void finalAnswer(){
        if (endBase == 10){
            outputField.append(String.valueOf(baseTenNum));
        }
        else {
            String str = "";
            int i = 0;
            while (endBaseConversion.size() > i){
                str += String.valueOf(endBaseConversion.get(i));
                i++;
            }
            outputField.append(str);
        }
    }
}

