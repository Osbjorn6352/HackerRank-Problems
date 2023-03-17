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

class TimeConversion.java {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
  
     * The function accepts STRING s as parameter.
     */
    public static String timeConversion(String s) {
        String res;
        String sub = s.substring(0, 2);
        if (s.charAt(8) == 'A' && sub.equals("12")) {
            String zeroed = "00";
            String minsSecs = s.substring(2,8);
            res = zeroed.concat(minsSecs);
            return res; 
        }
        else if (s.charAt(8) == 'A') 
            return s.substring(0,8);
            
        else if (s.charAt(8) == 'P' && sub.equals("12"))
            return s.substring(0,8);
            
        else {
            String hour = String.valueOf(Integer.valueOf(sub) + 12);
            res = hour.concat(s.substring(2,8));
            return res;
        }
    }
}
  public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
  } 
}
