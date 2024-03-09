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
     * Complete the 'extraLongFactorials' function below.
     *
     * The function accepts INTEGER n as parameter.
     */

    public static BigInteger extraLongFactorials(int n) {
    // Write your code here
        BigInteger num = new BigInteger(Integer.toString(n));
        BigInteger num_subject = new BigInteger(Integer.toString(n-1));
        if((n-1)!=0){
            num = num.multiply(extraLongFactorials(n-1));
        }
        return num;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        System.out.println(Result.extraLongFactorials(n));
        

        bufferedReader.close();
    }
}