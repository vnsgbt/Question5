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
    public void test(long number, long expected) {
        timestamp = number;
        Assert.assertEquals(getShowFromCounting(2),expected);
    }

    @DataProvider(name = "provideNumbers")
    public Object[][] provideData() {
        return new Object[][] {
                {9,1},
                {99,20},
                {999,20+(100)+(20*9)},
                {9999,4000},
                {99999,50000},
                {999999,600000},
                {9999999,7000000},
                {99999999,80000000},
        };
    }

    public long getShowFromCounting(int i) {
        showHost = String.valueOf(i);
        long showTimes = 0;
        for(int j = 1; j <= timestamp; j++){
            showTimes += getShowFromString(String.valueOf((j)));
        }
        return showTimes;
    }

    private long getShowFromString(String s) {
        long showTimes = 0;
        for (char c: s.toCharArray()) {
            if (showHost.contains(String.valueOf(c))){
                showTimes++;
            }
        }
        return showTimes;
    }
}
