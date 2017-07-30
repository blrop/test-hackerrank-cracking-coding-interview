import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        HashMap<String, Integer> magazineWords = new HashMap<>();

        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        for(int magazine_i=0; magazine_i < m; magazine_i++){
            String word = in.next();
            if (magazineWords.get(word) == null) {
                magazineWords.put(word, 1);
            } else {
                magazineWords.put(word, magazineWords.get(word) + 1);
            }
        }
        boolean result = true;
        for(int ransom_i=0; ransom_i < n; ransom_i++){
            String word = in.next();
            Integer wordCountAtMagazine = magazineWords.get(word);
            if (wordCountAtMagazine == null || wordCountAtMagazine < 1) {
                result = false;
                break;
            } else {
                magazineWords.put(word, wordCountAtMagazine - 1);
            }
        }

        System.out.println(result ? "Yes" : "No");
    }
}