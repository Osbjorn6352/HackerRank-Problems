import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class SparseArrays {

    /*
     * Complete the 'matchingStrings' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY strings
     *  2. STRING_ARRAY queries
     */

    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
        // Write your code here
        int inpLen = strings.size();
        int queLen = queries.size();
        List<Integer> ans = new ArrayList<Integer>(queLen); //set capacity
        for (int i = 0; i < queLen; i ++) {                 //populate with zeroes
            ans.add(0);
        }
        for (int i = 0; i < queLen; i++) {
            Integer elCount = 0;
            String query = queries.get(i);
            for (int j = 0; j < inpLen; j ++) {
                if (strings.get(j).equals(query))
                    elCount++;                         //number of times the string appears in input
            }
            ans.set(i, elCount);
        }
        return ans;
    }

}
