package org.vnsgbt.infoplus;

/**
 * Created by snguy on 1/25/2016.
 *
 */

public class DigitsInTimestamp {
    private long timestamp;
    private String showHost;

    public DigitsInTimestamp(int showHost) {
        this.showHost = String.valueOf(showHost);
    }

    public long getShowTimesOf(long i) {
//        return getOccurFromCounting(i);
        return getOccurWithOptimalAlgo(i);
    }

    private long getOccurWithOptimalAlgo(long i) {
        timestamp = i;
        long occurs = getOccurInFirstDigit(timestamp);
        occurs += getOccurByNineNumber(timestamp);
        occurs += getOccurByRemainingNumber(timestamp);
        return occurs;
    }

    private long getOccurByRemainingNumber(long input) {
        String remainder = String.valueOf(input).substring(1);
        return remainder.isEmpty() ? 0 : getOccurWithOptimalAlgo(Long.parseLong(remainder));
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

    /** Nines numbers are in the form of 9(9*) and one digit less than input
     *  9 -> 1
     *  99 -> 20
     *  999 -> 300
     *  ...
     *  **********************************************************************/
    protected long getOccurByNineNumber(long input) {
        String remainder = String.valueOf(input).substring(1);
        if (remainder.isEmpty()) return 0;
        long nineNumberSize = remainder.length();
        long occur = (long) (nineNumberSize * Math.pow(10,nineNumberSize-1));
        return occur;
    }

    /** 4044 => 999 => 44 is the above number
     *  44 = input - ((999 + 1) * first digit)
     *  ********************************************************/
    protected long getOccurInFirstDigit(long input) {
        int firstDigit = Integer.parseInt(String.valueOf(input).substring(0,1));
        if (Integer.parseInt(showHost) == firstDigit) {
            long nineNumberSize = String.valueOf(input).substring(1).length();
            long nineNumber = (long) (Math.pow(10,nineNumberSize) - 1);
            return input - ((nineNumber + 1) * firstDigit) + 1;
        }
        return 0;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
