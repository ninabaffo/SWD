// Name: Nina Baffo
// FileName: MetricConversion
// Description: An application to assist the user with metric conversions.
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
            System.out.print("Metric to English Length Conversion Tests \n");
            String firstConversion = "How many inches are in 5 millimeters ?";
            System.out.println(firstConversion);
            System.out.println("Correct answer: There are 0.19685 inches in 5 millimeters");
            Metric2English obj2Convert1 = new Metric2English(firstConversion);
            System.out.println("Actual answer: ");
            obj2Convert1.convertUnits();

            String secondConversion = "\nHow many feet are in 8 meters ?";
            System.out.println(secondConversion);
            System.out.println("Correct answer: There are 26.24 feet in 8 meters");
            Metric2English obj2Convert2 = new Metric2English(secondConversion);
            System.out.println("Actual answer: ");
            obj2Convert2.convertUnits();

            String thirdConversion = "\nHow many miles are in 10 kilometers ?";
            System.out.println(thirdConversion);
            System.out.println("Correct answer: There are 6.214 miles in 10 kilometers");
            Metric2English obj2Convert3 = new Metric2English(thirdConversion);
            System.out.println("Actual answer: ");
            obj2Convert3.convertUnits();

            System.out.println("\nMetric to English Mass Conversion Tests\n");
            String fourthConversion = "How many ounces are in 26 grams ?";
            System.out.println(fourthConversion);
            System.out.println("Correct answer: There are 0.917 ounces in 26 grams");
            Metric2English obj2Convert4 = new Metric2English(fourthConversion);
            System.out.println("Actual answer: ");
            obj2Convert4.convertUnits();

            String fifthConversion = "\nHow many pounds are in 30 kilograms ?";
            System.out.println(fifthConversion);
            System.out.println("Correct answer: There are 66 pounds in 30 kilograms");
            Metric2English obj2Convert5 = new Metric2English(fifthConversion);
            System.out.println("Actual answer: ");
            obj2Convert5.convertUnits();

            System.out.println("\nMetric to English Volume Conversion Tests\n");
            String sixthConversion = "How many pints are in 15 milliliters ?";
            System.out.println(sixthConversion);
            System.out.println("Correct answer: There are 0.0317 pints in 15 milliliters");
            Metric2English obj2Convert6 = new Metric2English(sixthConversion);
            System.out.println("Actual answer: ");
            obj2Convert6.convertUnits();

            String seventhConversion = "\nHow many gallons are in 25 liters ?";
            System.out.println(seventhConversion);
            System.out.println("Correct answer: There are 6.6043 gallons in 25 liters");
            Metric2English obj2Convert7 = new Metric2English(seventhConversion);
            System.out.println("Actual answer: ");
            obj2Convert7.convertUnits();

            String eighthConversion = "\nHow many quarts are in 5 liters ?";
            System.out.println(eighthConversion);
            System.out.println("Correct answer: There are 5.283 quarts in 5 liters");
            Metric2English obj2Convert8 = new Metric2English(eighthConversion);
            System.out.println("Actual answer: ");
            obj2Convert8.convertUnits();

            System.out.println("\nEnglish to Metric Length Conversion Tests\n");
            String ninthConversion = "\nHow many meters are in 4 miles ?";
            System.out.println(ninthConversion);
            System.out.println("Correct answer: There are 6437.38 meters in 4 miles");
            English2Metric obj2Convert9 = new English2Metric(ninthConversion);
            System.out.println("Actual answer: ");
            obj2Convert9.convertToUnits();

            String tenthConversion = "\nHow many kilometers are in 900 inches ?";
            System.out.println(tenthConversion);
            System.out.println("Correct answer: There are 0.02286 kilometers in 900 inches");
            English2Metric obj2Convert10 = new English2Metric(tenthConversion);
            System.out.println("Actual answer: ");
            obj2Convert10.convertToUnits();

            String eleventhConversion = "\nHow many millimeters are in 5 feet ?";
            System.out.println(eleventhConversion);
            System.out.println("Correct answer: There are 1524 millimeters in 5 feet");
            English2Metric obj2Convert11 = new English2Metric(eleventhConversion);
            System.out.println("Actual answer: ");
            obj2Convert11.convertToUnits();

            System.out.println("\nEnglish to Metric Mass Conversion Tests\n");
            String twelvethConversion = "\nHow many kilograms are in 8 pounds ?";
            System.out.println(twelvethConversion);
            System.out.println("Correct answer: There are 3.6287 kilograms in 8 pounds");
            English2Metric obj2Convert12 = new English2Metric(twelvethConversion);
            System.out.println("Actual answer: ");
            obj2Convert12.convertToUnits();

            String thirteenthConversion = "\nHow many tons are in 15 ounces ?";
            System.out.println(thirteenthConversion);
            System.out.println("Correct answer: There are .000418 tons in 15 ounces");
            English2Metric obj2Convert13 = new English2Metric(thirteenthConversion);
            System.out.println("Actual answer: ");
            obj2Convert13.convertToUnits();

            System.out.println("\nEnglish to Metric Volume Conversion Tests\n");
            String fourteenthConversion = "\nHow many liters are in 16 gallons ?";
            System.out.println(fourteenthConversion);
            System.out.println("Correct answer: There are 60.566 liters in 16 gallons");
            English2Metric obj2Convert14 = new English2Metric(fourteenthConversion);
            System.out.println("Actual answer: ");
            obj2Convert14.convertToUnits();

            String fifteenthConversion = "\nHow many milliliters are in 23 pints ?";
            System.out.println(fifteenthConversion);
            System.out.println("Correct answer: There are 13070 milliliters in 23 pints");
            English2Metric obj2Convert15 = new English2Metric(fifteenthConversion);
            System.out.println("Actual answer: ");
            obj2Convert15.convertToUnits();

            String sixteenthConversion = "\nHow many liters are in 30 quarts ?";
            System.out.println(sixteenthConversion);
            System.out.println("Correct answer: There are 28.3906 liters in 30 quarts");
            English2Metric obj2Convert16 = new English2Metric(sixteenthConversion);
            System.out.println("Actual answer: ");
            obj2Convert16.convertToUnits();

            String eighteenthConversion = "\nHow many liters are in 20 pounds ?";
            System.out.println(eighteenthConversion);
            System.out.println("Correct answer: Invalid Conversion ");
            English2Metric obj2Convert18 = new English2Metric(eighteenthConversion);
            System.out.println("Actual answer: ");
            obj2Convert18.convertToUnits();
        }
    }