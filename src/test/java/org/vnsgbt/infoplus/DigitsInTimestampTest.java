package org.vnsgbt.infoplus;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by snguy on 1/25/2016.
 *
 */

public class DigitsInTimestampTest {

    private DigitsInTimestamp test;

    @BeforeClass
    public void setup () {
        test = new DigitsInTimestamp(999,9);
    }

    /**
     * This is so slow, but well, it's the moment of truth
     * *****************************************************/
    @Test(dataProvider = "digitInEpoch")
    public void testEpoch(int digit) {
        long number = System.currentTimeMillis()/1000;
        test.setTimestamp(number);
        test.setDigit(digit);
        Assert.assertEquals(test.getOccur(number),getOccurFromCounting(number));
    }

    @DataProvider(name = "digitInEpoch")
    public Object[][] provideDataEpoch() {
        return new Object[][] {
                {1,},
                {2,},
                {3,},
                {4,},
                {5,},
                {6,},
                {7,},
                {8,},
                {9,},
        };
    }

    @Test(dataProvider = "provideNumbers")
    public void test(long number, long expected) {
        test.setTimestamp(number);
        test.setDigit(7);
        Assert.assertEquals(test.getOccur(number),expected);
    }

    @DataProvider(name = "provideNumbers")
    public Object[][] provideData() {
        return new Object[][] {
                {123,getOccurFromCounting(123)},
                {4567,getOccurFromCounting(4567)},
                {89011,getOccurFromCounting(89011)},
                {121314,getOccurFromCounting(121314)},
        };
    }

    @Test(dataProvider = "inputNineNumbers")
    public void testNineNumber(long number, int expected) {
        test.setTimestamp(number);
        test.setDigit(7);
        Assert.assertEquals(test.occurFromNines(number),expected);
    }

    @DataProvider(name = "inputNineNumbers")
    public Object[][] inputNineNumberData() {
        return new Object[][] {
                {9,0},
                {1234,300},
                {31234,4000},
                {551234,50000},
                {6661234,600000},
                {77771234,7000000},
        };
    }

    @Test(dataProvider = "getOccurAllNinesOutOfThis")
    public void ninesOf (long input, long expected) {
        test.setDigit(7);
        Assert.assertEquals(test.getSumOfAllNineNumber(input),expected);
    }

    @DataProvider(name = "getOccurAllNinesOutOfThis")
    public static Object[][] getNinesOutOfThis() {
        return new Object[][]{
                {1,0},
                {1234,300},
                {31234,4000*3},
                {551234,50000*5},
                {6661234,600000*6},
                {77771234,7000000*7},
        };
    }

    @Test(dataProvider = "getOccurInFirstDigit")
    public void getOccurInFirstDigit (long input, long expected) {
        test.setDigit(3);
        Assert.assertEquals(test.getOccurInFirstDigit(input),expected);
    }

    @DataProvider(name = "getOccurInFirstDigit")
    public static Object[][] getOccurInFirstDigit() {
        return new Object[][]{
                {5,1},
                {9,1},
                {1234,0},
                {31234,1235},
                {551234,100000},
                {6661234,1000000},
                {77771234,10000000},
        };
    }

    @Test(dataProvider = "getOccurWithoutRemainder")
    public void getOccurWithoutRemainder (long input, long expected) {
        test.setDigit(1);
        Assert.assertEquals(test.getOccurWithoutRemainder(input),expected);
    }

    @DataProvider(name = "getOccurWithoutRemainder")
    public Object[][] getOccurWithoutRemainder() {
        return new Object[][]{
                {1000,getOccurFromCounting(1000)},
                {30000,getOccurFromCounting(30000)},
                {500000,getOccurFromCounting(500000)},
        };
    }

    /** Supporting methods for brute force result (very slow)
     *  *****************************************************/

    public long getOccurFromCounting(long input) {
        test.setTimestamp(input);
        long showTimes = 0;
        for(int j = 1; j <= test.getTimestamp(); j++){
            showTimes += getOccurFromString(String.valueOf((j)));
        }
        return showTimes;
    }

    private long getOccurFromString(String s) {
        long showTimes = 0;
        for (char c: s.toCharArray()) {
            if (test.getDigit() == Integer.parseInt(String.valueOf(c))){
                showTimes++;
            }
        }
        return showTimes;
    }
}
