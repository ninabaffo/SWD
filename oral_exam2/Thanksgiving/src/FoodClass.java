
/**
 * public class Food computes the optimized solution with the foods for the user
 */
public class FoodClass{
    public double E, C;
    public double enjoymentTemp;
    public double[] volumeArray, enjoymentArray;

    /**
     * before computing, we first loop through the items inputted to 'optimizeWeights'. If any of the inputted items
     * share the same volume, check which one has the greater enjoyment. Set the one with less enjoyment to 0 so that
     * when computing the answer that one is skipped.
     * @param volArray array with the volume of each item
     * @param eArray array with the enjoyment of each item
     */
    public void optimizeWeights(double[] volArray, double[] eArray) {
        for (int j = 0; j < volArray.length; j++) {
            for (int k = 1; k < volArray.length; k++) {
                if (volArray[j] == volArray[k]) {
                    if (eArray[j] > eArray[k]) {
                        volArray[k] = 0;
                        eArray[k] = 0;
                    } else if (eArray[j] < eArray[k]) {
                        volArray[j] = 0;
                        eArray[j] = 0;
                    }
                }
            }
        }
    }

    // check to make sure that there is at least one volume input that is less than capacity

    /**
     * isPossible takes the volume array and the capacity and makes sure that there is atleast 1 volume that is
     * greater than or equal to the capacity and returns true. If there is not, the user cannot eat anything
     * and this should return false.
     * @param volInput array of volumes
     * @param cap capacity of stomach
     * @return true or false
     */
    public boolean isPossible(double[] volInput, double cap) {
        for (int i = 0; i < volInput.length; i++) {
            if (cap >= volInput[i]) {
                return true;
            }
        }
        return false;
    }
    /**
     * startLoop will set the volume and enjoyment arrays inputted and calls isPossible to check if it is possible.
     * then it will call optimize weights and start the loop. This will loop over all the elements in both arrays and
     * finds a solution for the amt of foods starting at each index i. if the returned enjoyment temp in getSolution
     * is greater than the current enjoyment (E) which is the last enjoyment that was calculated, set E enjoymentTemp.
     * @param vArray volume array
     * @param eArray enjoyment array
     * @param capacity stomach capacity
     * @return returns the best solution for enjoyment after the loop is over
     */
    public double startLoop(double[] vArray, double[] eArray, double capacity){
        volumeArray = vArray;
        enjoymentArray = eArray;
        E = 0;
        if (isPossible(volumeArray, capacity)){
            optimizeWeights(volumeArray, eArray);

            for (int i = 0; i < volumeArray.length; i++){
                getSolution(volumeArray.length, i, capacity);
                if (enjoymentTemp > E && !(capacity<0)){
                    E = enjoymentTemp;
                }
                enjoymentTemp = 0;
            }
        }
        else {
            System.out.println("Optimal Enjoyment: 0");
            return 0;
        }
        System.out.println("Optimal Enjoyment: " + E);
        return E;
    }

    /**
     * getSolution is a recursive method with base case if capacity=0, return enjoyment, or if the index
     * is out of bounds return to the start index of the array. Else if volume=1 and capacity != 1, go to the next index
     * because more can be consumed. Else, get the current volume and enjoyment and divide the volume by the capacity to find
     * how many of those you can consume. Get the corresponding enjoyment and add it to enjoymentTemp,
     * update the capacity left over and increment the index.
     * @param n number of elements in the volume and enjoyment arrays
     * @param currentIndex current index of arrays
     * @param capacity current capacity left
     * @return either returns the enjoyment E if there is no capacity left in the stomach or calls the method again.
     */
    public double getSolution(int n, int currentIndex, double capacity){
        double currentVolume, currentEnjoyment, newCapacity;

        if (capacity == 0) {
            return E;
        }
        else if (currentIndex == n) {
            return getSolution(n, 0, capacity);
        }
        else if (volumeArray[currentIndex] == 1 && capacity != 1){
            return getSolution(n, currentIndex+1, capacity);
        }
        else {
            currentVolume = volumeArray[currentIndex];
            currentEnjoyment = enjoymentArray[currentIndex];
            int amtToConsume = (int)(capacity/currentVolume);

            double enjoymentTotal = (amtToConsume*currentEnjoyment);
            enjoymentTemp = enjoymentTemp + enjoymentTotal;
            newCapacity = capacity - (amtToConsume*currentVolume);

        }
        return getSolution(n, currentIndex+1, newCapacity);
    }

}
