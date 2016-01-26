package org.vnsgbt.infoplus;

/**
 * Created by snguy on 1/25/2016.
 *
 */

public class DigitsInTimestamp {
    private final long timestamp;
    private String showHost;

    public DigitsInTimestamp(long timestamp) {
       this.timestamp = timestamp;
    }

    public long getShowTimesOf(int i) {
        return getShowFromCounting(i);
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
