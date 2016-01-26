package org.vnsgbt.infoplus;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by snguy on 1/25/2016.
 *
 */

public class DigitsInTimestampTest {

    private String showHost;
    private long timestamp;

    @Test(dataProvider = "provideNumbers")
    public void test(long number, int expected) {
        timestamp = number;
        DigitsInTimestamp test = new DigitsInTimestamp(expected);
        test.setTimestamp(number);
        Assert.assertEquals(test.getShowTimesOf(number),getOccurFromCounting(expected));
    }

    @DataProvider(name = "provideNumbers")
    public Object[][] provideData() {
        return new Object[][] {
                {199,1},
                {299,2},
                {399,3},
                {4999,4},
//                {9999,4000},
//                {99999,50000},
//                {999999,600000},
//                {9999999,7000000},
//                {99999999,80000000},
//                {106571, getOccurFromCounting(7)},
        };
    }

    @Test(dataProvider = "inputNineNumbers")
    public void testNineNumber(long number, int expected) {
        DigitsInTimestamp test = new DigitsInTimestamp(expected);
        Assert.assertEquals(test.getOccurByNineNumber(number),expected);
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

    public long getOccurFromCounting(int i) {
        showHost = String.valueOf(i);
        long showTimes = 0;
        for(int j = 1; j <= timestamp; j++){
            showTimes += getOccurFromString(String.valueOf((j)));
        }
        return showTimes;
    }

    private long getOccurFromString(String s) {
        long showTimes = 0;
        for (char c: s.toCharArray()) {
            if (showHost.contains(String.valueOf(c))){
                showTimes++;
            }
        }
        return showTimes;
    }
}
