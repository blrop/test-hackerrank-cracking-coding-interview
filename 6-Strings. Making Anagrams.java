import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class Solution {
    private static int getLetterFrequency(String s, char letter) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == letter) {
                result++;
            }
        }
        return result;
    }

    public static int numberNeeded(String first, String second) {
        int result = 0;
        for (int i = 0; i < 26; i++) {
            char letter = (char) ((int) 'a' + i);
            result += Math.abs(getLetterFrequency(first, letter) - getLetterFrequency(second, letter));
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}
