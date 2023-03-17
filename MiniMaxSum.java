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

class MiniMaxSum {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
    // Write your code here
    int min = arr.get(0);
    int max = arr.get(0);
    for (int i = 1; i < 5; i++) {
        int j = arr.get(i);
        if (j < min) min = j; //store the min value
        if (j > max) max = j; //store the max value
    }
    int minIndex = arr.indexOf(min); //store min and max index
    int maxIndex = arr.indexOf(max); //in case of duplicate values
    long minSum = 0; //avoid integer overflow
    long maxSum = 0; //avoid integer overflow
    for (int i = 0; i < 5; i++) {
        int j = arr.get(i);
        if (i != maxIndex) minSum += j;
        if (i != minIndex) maxSum += j;
    }
    
    System.out.format("%d %d", minSum, maxSum);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.miniMaxSum(arr);

        bufferedReader.close();
    }
}
