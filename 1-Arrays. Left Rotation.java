import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arraySize = in.nextInt();
        int stepCount = in.nextInt();
        int a[] = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            a[i] = in.nextInt();
        }

        for (int i = stepCount; i < stepCount + arraySize; i++) {
            int targetIndex = i % arraySize;
            System.out.print(a[targetIndex] + " ");
        }
    }
}