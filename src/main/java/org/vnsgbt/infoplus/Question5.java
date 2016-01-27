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
        }
        else {
            timestamp = System.currentTimeMillis()/1000;
        }

        occurs = new DigitsInTimestamp(timestamp,0);

        System.out.println("\nCounting occurrence of each nonzero digits from 1 to "
                + timestamp + " \n");
    }
}
