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
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
    // Declare variables
    int n = arr.size();
    long minValue = arr.get(0);
    int minIndex = 0;
    long maxValue = arr.get(0);
    int maxIndex = 0;
    long minSum = 0;
    long maxSum = 0;
    
    // Find min and max values and indices
    for (int i = 1; i < n; i++) {
        long num = arr.get(i);
        if (num < minValue) {
            minValue = num;
            minIndex = i;
        }
        if (num > maxValue) {
            maxValue = num;
            maxIndex = i;
        }
    }
    
    // Find both sums
    for (int i = 0; i < n; i++) {
        long num = arr.get(i);
        if (i == minIndex) minSum += num;
        else if (i == maxIndex) maxSum+= num;
        else {
            minSum += num;
            maxSum += num;
        }
    }
    // Correct for edge case where all numbers are equal
    if (minValue == maxValue) {
        minSum -= minValue;
        maxSum = minSum;
    }
    
    // Print out both sums
    System.out.println(minSum + " " + maxSum);
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
