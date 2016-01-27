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
        test = new DigitsInTimestamp(1);
    }

    @Test(dataProvider = "provideNumbers")
    public void test(long number, int expected) {
        test.setTimestamp(number);
        test.setDigit(1);
        Assert.assertEquals(test.getShowTimesOf(number),getOccurFromCounting(expected));
    }

    @DataProvider(name = "provideNumbers")
    public Object[][] provideData() {
        return new Object[][] {
                {199,1},
                {299,2},
                {399,3},
                {4999,4},
                /*{9999,4000},
                {99999,50000},
                {999999,600000},
                {9999999,7000000},
                {99999999,80000000},
                {106571, getOccurFromCounting(7)},*/
        };
    }

    @Test(dataProvider = "inputNineNumbers")
    public void testNineNumber(long number, int expected) {
        DigitsInTimestamp test = new DigitsInTimestamp(expected);
        Assert.assertEquals(test.occurFromNines(number),expected);
    }

    @DataProvider(name = "inputNineNumbers")
    public Object[][] inputNineNumberData() {
        return new Object[][] {
                {1234,300},
                {31234,4000},
                {551234,50000},
                {6661234,600000},
                {77771234,7000000},
        };
    }

    @Test(dataProvider = "getNinesOutOfThis")
    public void ninesOf (long input, long expected) {

    }

    @DataProvider(name = "getNinesOutOfThis")
    public static Object[][] getNinesOutOfThis() {
        return new Object[][]{
                {1234,999},
                {31234,9999},
                {551234,99999},
                {6661234,999999},
                {77771234,9999999},
        };
    }

    public long getOccurFromCounting(int i) {
        test.setDigit(i);
        long showTimes = 0;
        for(int j = 1; j <= test.getTimestamp(); j++){
            showTimes += getOccurFromString(String.valueOf((j)));
        }
        return showTimes;
    }

    private long getOccurFromString(String s) {
        long showTimes = 0;
        for (char c: s.toCharArray()) {
            if (test.getDigit() == c){
                showTimes++;
            }
        }
        return showTimes;
    }
}
