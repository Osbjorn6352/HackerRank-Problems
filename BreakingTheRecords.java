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

class Result {

    /*
     * Complete the 'breakingRecords' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY scores as parameter.
     */

    public static List<Integer> breakingRecords(List<Integer> scores) {
        // Write your code here
        List<Integer> ans = new ArrayList<Integer>(); //initialize return value
        int min = scores.get(0);  //Set counters for min/max value
        int minCount = 0;         //Set counterger for times they've been updated
        int max = scores.get(0);
        int maxCount = 0;
        for (int i = 1; i < scores.size(); i++) { //start at 1 because 1<=n<=1000
            int scoreAtIndx = scores.get(i);
            if (scoreAtIndx < min) {
                min = scoreAtIndx;
                minCount++;         //update if needed
            } 
            else if (scoreAtIndx > max) {
                max = scoreAtIndx;
                maxCount++;         //update if needed
            }
        }
        ans.add(maxCount);
        ans.add(minCount); //update our return value
        return ans; 

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> scores = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.breakingRecords(scores);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
