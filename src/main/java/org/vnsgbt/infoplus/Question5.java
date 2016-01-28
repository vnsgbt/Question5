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

        if (args.length > 0 && Long.parseLong(args[0]) > 0) {
            timestamp = Long.parseLong(args[0]);
        }
        else {
            System.out.println("Input not found or invalid, using epoch ... ");
            timestamp = System.currentTimeMillis()/1000;
        }

        occurs = new DigitsInTimestamp(timestamp,0);

        System.out.println(
                "\nGetting showTimes of each nonzero digits counting from 1 to "
                        + timestamp);

        occurs.getOccurForAllDigits();
    }
}
