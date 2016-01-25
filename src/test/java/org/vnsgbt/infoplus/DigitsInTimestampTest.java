package org.vnsgbt.infoplus;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by snguy on 1/25/2016.
 *
 */

public class DigitsInTimestampTest {

    @Test(dataProvider = "provideNumbers")
    public void test(long number, long expected) {
        DigitsInTimestamp test = new DigitsInTimestamp(number);
        Assert.assertEquals(test.getShowTimesOf(1),expected);
    }

    @DataProvider(name = "provideNumbers")
    public Object[][] provideData() {
        return new Object[][] {
                {1,1},
                {20,12}
        };
    }
}
