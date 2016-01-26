package org.vnsgbt.infoplus;

/**
 * Hello world!
 *
 */
public class Question5
{
    public static void main( String[] args )
    {
        DigitsInTimestamp occurs;
        long timestamp;

        if (args.length > 0 && Long.getLong(args[0]) != null) {
            timestamp = Integer.getInteger(args[0]);
            occurs = new DigitsInTimestamp(1);
        }
        else {
            timestamp = 99;//System.currentTimeMillis()/1000;
            occurs = new DigitsInTimestamp(1);
        }

        timestamp = 99;

        System.out.println("\nCounting occurrence of each nonzero digits from 1 to "
                + timestamp + " \n");

        for (int i = 1; i <= 9; i++){
            long result = occurs.getOccurFromCounting(i);
            System.out.println(i + " shows up " + result + " times");
        }
    }
}
