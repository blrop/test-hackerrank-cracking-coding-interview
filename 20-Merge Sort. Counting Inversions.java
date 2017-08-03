import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static long countInversions(int[] arr) {
        int result = 0;
        for (int outer_i = 0; outer_i < (arr.length - 1); outer_i++) {
            for (int inner_i = outer_i + 1; inner_i < arr.length; inner_i++) {
                if (arr[inner_i] < arr[outer_i]) {
                    int tmp = arr[inner_i];
                    arr[inner_i] = arr[outer_i];
                    arr[outer_i] = tmp;

                    result++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int[] arr = new int[n];
            for(int arr_i = 0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            long result = countInversions(arr);
            System.out.println(result);
        }
        in.close();
    }
}
