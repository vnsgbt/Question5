package org.vnsgbt.infoplus;

/**
 * Created by snguy on 1/25/2016.
 *
 */

public class DigitsInTimestamp {

    private long timestamp;
    private int digit;

    public DigitsInTimestamp(long timestamp, int digit) {
        this.timestamp = timestamp;
        this.digit = digit;
    }

    public int getDigit() {
        return digit;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setDigit(int digit) {
        this.digit = digit;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public void getOccurForAllDigits(){
        for (int i = 1; i < 10; i++){
            digit = i;
            long showTimes = getOccur(timestamp);
            System.out.println("\n " + digit + " => " + showTimes + " times.");
        }
    }

    public long getOccur(long i) {
        return getOccurInFirstDigit(i)
                + getSumOfAllNineNumber(i)
                + getOccurInRemaining(i);
    }

    private long getOccurInRemaining(long input) {
        String remainderString = String.valueOf(input).substring(1);
        if (remainderString.length() < 1) {
            return 0;
        }
        return getOccur(Long.parseLong(remainderString));
    }

    /**
     * @param input: the number to be computed, ex: 777
     * @return the occurrence of digit from counting all multiple of 9s number
     *
     * ex: 777 => 9s number is 99 => total of (7 * 99)
     */
    protected long getSumOfAllNineNumber (long input) {
        int leadingDigit = Integer.parseInt(String.valueOf(input).substring(0,1));
        return occurFromNines(input) * leadingDigit;
    }

    /** Nines numbers are in the form of 9(9*) and one digit less than input
     *  9 -> 1
     *  99 -> 20
     *  999 -> 300
     *  ...
     *  **********************************************************************/
    protected long occurFromNines(long input) {
        String remainder = String.valueOf(input).substring(1);
        if (remainder.isEmpty()) return 0;
        long nineNumberSize = remainder.length();
        return (long) (nineNumberSize * Math.pow(10,nineNumberSize-1));
    }

    /** 4044 => 999 => 44 is the above number
     *  44 = input - ((999 + 1) * first digit)
     *  ********************************************************/
    protected long getOccurInFirstDigit(long input) {
        String inputString = String.valueOf(input);

        if (inputString.length() == 1) {
            return getDigit() <= input ? 1 : 0;
        }

        int firstDigit = Integer.parseInt(inputString.substring(0,1));
        String remainder = inputString.substring(1);
        if (firstDigit == digit) {
            return Long.parseLong(remainder) + 1;
        }
        else if (digit < firstDigit){
            return (long) Math.pow(10,remainder.length());
        }
        return 0;
    }

    /** 4404 => 4000 is the input without remainder
     * ***********************************************/
    public long getOccurWithoutRemainder(long input) {
        return getOccurInFirstDigit(input)
                + getSumOfAllNineNumber(input);
    }
}
