# Question5

By counting a number from 1 , we can notice that for every nine increments we have each nonzero digit occurs once.

With a simple iteration and string processing we can observe following pattern:

   9    => 1 occurrence of each nonzero digit
   99   => 20
   999  => 300
   9999 => 4000
   
Thus, let's assume this pattern as a formula to be automatic tested.
      
We shall proceed in this manner:

   - Every number greater than 9 can be rewritten in a form of 9s : 1234 = 999 + 1 + 234
   - By extracting the 9s number we then apply the above formula to get occurrence in this portion
   - We consider leading digit and the remaining portion as two additional computations for the occurrence
  
The rest of the story is in the details of the code.

To build and run with javac from directory src/main/java :

javac org/vnsgbt/infoplus/Question5.java

java -cp . org.vnsgbt.infoplus.Question5 [timestamp]

