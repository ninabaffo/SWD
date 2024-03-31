import java.util.Scanner;

/**
 * public class Thanksgiving asks the user for a list of foods theyd like to eat then asks for the volume
 * and enjoyment of each and the capacity of their stomach. Then creates a new Food object to call the method
 * startLoop which starts the process of getting the optimal solution
 */
public class ThanksgivingClass {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // ask user for a list of food unit objects
        System.out.println("Enter a list of foods you'd like to eat from the list below separated by a comma");
        System.out.println("turkey, Pumpkin Pie, Mashed potatoes, Gravy, Stuffing, Cranberries, Casserole");

        String foodChoiceInput = input.nextLine();

        // split the foodChoiceInput string and put it into an array so food unit items are separated.
        String foodInputArray[] = foodChoiceInput.split(",");
        double volume[] = new double[foodInputArray.length];
        double enjoyment[] = new double[foodInputArray.length];

        // loop through array and ask the user the volume and enjoyment of each food iteam inputted
        for (int i = 0; i < foodInputArray.length; i++) {
            System.out.println("Enter the volume of " + foodInputArray[i] + " you'd like to consume.");
            double volInput = input.nextDouble();
            volume[i] = volInput;

            System.out.println("Enter the enjoyment of " + foodInputArray[i]);
            double enjoymentInput = input.nextDouble();
            enjoyment[i] = enjoymentInput;
        }

        System.out.println("Enter your stomach capacity: ");
        double capacity = input.nextDouble();

        FoodClass newFood = new FoodClass();
        newFood.startLoop(volume, enjoyment, capacity);

    }
}
