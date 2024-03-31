import org.junit.jupiter.api.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
public class ThxGivingJunitTests {
    private FoodClass myFood = new FoodClass();
    private double[] vArray1, vArray2, vArray3, vArray4, vArray5, vArray6, vArray7, vArray8, vArray9,vArray10, vArray11,
            vArray12, vArray13, vArray14, vArray15;
    private double[] eArray1, eArray2, eArray3, eArray4, eArray5, eArray6, eArray7, eArray8, eArray9,eArray10, eArray11,
            eArray12, eArray13, eArray14, eArray15;
    int currentIndex;
    @Test
    void isPossible() {
        assertTrue(myFood.isPossible(new double[]{3, 2, 4, 10, 2, 7, 12}, 20));
        assertTrue(myFood.isPossible(new double[]{3, 2, 4, 1, 2, 10, 15}, 41));
        assertTrue(myFood.isPossible(new double[]{3, 4, 1, 2, 1, 2, 3}, 7));
        assertTrue(myFood.isPossible(new double[]{3, 4, 1, 2, 1, 2, 3}, 9));
        assertFalse(myFood.isPossible(new double[]{6, 7, 8, 9, 10, 11, 12}, 5));
        assertFalse(myFood.isPossible(new double[]{8, 9, 10, 11, 5, 4, 4}, 3));
        assertTrue(myFood.isPossible(new double[]{5, 10, 15, 20, 25, 30, 35}, 10));
        assertTrue(myFood.isPossible(new double[]{8, 9, 6, 10, 3, 1, 3}, 4));
        assertTrue(myFood.isPossible(new double[]{6, 7, 8, 8, 1, 9, 10}, 35));
        assertFalse(myFood.isPossible(new double[]{10, 9, 8, 7, 6, 5, 5}, 4));
        assertTrue(myFood.isPossible(new double[]{8, 8, 10, 3, 1, 7, 6}, 4));
        assertFalse(myFood.isPossible(new double[]{8, 9, 10, 11, 12, 22, 15}, 5));
        assertTrue(myFood.isPossible(new double[]{20, 10, 1, 10, 2, 6, 5}, 25));
        assertTrue(myFood.isPossible(new double[]{10, 9, 1, 2, 3, 4, 5}, 50));
        assertTrue(myFood.isPossible(new double[]{5, 9, 6, 7, 6, 5, 6}, 5));
    }

    @Test
    void startLoop(){
        vArray1 = new double[]{3, 2, 4, 10, 2, 7, 12};
        eArray1 = new double[]{4, 2, 5, 10, 3, 5, 17};
        assertEquals(30, myFood.startLoop(vArray1, eArray1, 20));

        vArray2 = new double[]{3, 2, 4, 1, 2, 10, 15};
        eArray2 = new double[]{4, 2, 5, 1, 3, 14, 24};
        assertEquals(63, myFood.startLoop(vArray2, eArray2, 41));

        vArray3 = new double[]{3, 4, 1, 2, 1, 2, 3};
        eArray3 = new double[]{5, 12, 1, 5, 1, 2, 3};
        assertEquals(18, myFood.startLoop(vArray3, eArray3, 7));

        vArray4 = new double[]{3, 4, 1, 2, 1, 2, 3};
        eArray4 = new double[]{6, 9, 0.5, 4, 1, 2, 3};
        assertEquals(19, myFood.startLoop(vArray4, eArray4, 9));

        vArray5 = new double[]{6, 7, 8, 9, 10, 11, 12};
        eArray5 = new double[]{7, 8, 9, 10, 11, 12, 13};
        assertEquals(0, myFood.startLoop(vArray5, eArray5, 5));

        vArray6 = new double[]{8, 9, 10, 11, 5, 4, 4};
        eArray6 = new double[]{1, 1, 1, 1, 1, 1, 1};
        assertEquals(0, myFood.startLoop(vArray6, eArray6, 3));

        vArray7 = new double[]{5, 10, 15, 20, 25, 30, 35};
        eArray7 = new double[]{10, 2, 8, 9, 23, 12, 20};
        assertEquals(20, myFood.startLoop(vArray7, eArray7, 10));

        vArray8 = new double[]{8, 9, 6, 10, 3, 1, 3};
        eArray8 = new double[]{10, 1, 8, 9, 10, 4, 1};
        assertEquals(14, myFood.startLoop(vArray8, eArray8, 4));

        vArray9 = new double[]{8, 7, 8, 8, 10, 9, 10};
        eArray9 = new double[]{8, 6, 3, 4, 5, 10, 15};
        assertEquals(0, myFood.startLoop(vArray9, eArray9, 6));

        vArray10 = new double[]{10, 9, 8, 7, 6, 5, 5};
        eArray10 = new double[]{3, 4, 2, 2, 1, 5, 10};
        assertEquals(0, myFood.startLoop(vArray10, eArray10, 4));

        vArray11 = new double[]{8, 8, 10, 3, 1, 7, 6};
        eArray11 = new double[]{10, 7, 5, 8, 2, 8, 9};
        assertEquals(10, myFood.startLoop(vArray11, eArray11, 4));

        vArray12 = new double[]{8, 9, 10, 11, 12, 22, 15};
        eArray12 = new double[]{9, 10, 8, 15, 4, 8, 9};
        assertEquals(0, myFood.startLoop(vArray12, eArray12, 5));

        vArray13 = new double[]{20, 10, 1, 10, 2, 6, 5};
        eArray13 = new double[]{16, 8, 5, 9, 10, 2, 3};
        assertEquals(125, myFood.startLoop(vArray13, eArray13, 25));

        vArray14 = new double[]{10, 9, 5, 2, 3, 4, 5};
        eArray14 = new double[]{10, 2, 3, 4, 5, 2, 1};
        assertEquals(0, myFood.startLoop(vArray14, eArray14, 1));

        vArray15 = new double[]{5, 9, 6, 7, 6, 5, 6};
        eArray15 = new double[]{4, 8, 2, 6, 9, 25, 5};
        assertEquals(25, myFood.startLoop(vArray15, eArray15, 5));
    }
}

