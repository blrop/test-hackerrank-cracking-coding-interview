import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    private static HashMap<String, Long> memory = new HashMap<>();

    public static Long makeChange(int[] coins, int money) {
        Long wayCount = 0L;
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] == money) {
                wayCount++;
            } else if ((money - coins[i]) <= 0) {
                continue;
            } else {
                int[] coinsRest = new int[coins.length - i];
                System.arraycopy(coins, i, coinsRest, 0, coinsRest.length);

                int moneyRest = money - coins[i];
                String hash = moneyRest + "-";
                for (int ii = 0; ii < coinsRest.length; ii++) {
                    hash += coinsRest[ii] + "-";
                }

                Long savedCount = memory.get(hash);

                if (savedCount != null) {
                    wayCount += savedCount;
                } else {

                    Long currentWayCount = makeChange(coinsRest, moneyRest);
                    memory.put(hash, currentWayCount);

                    wayCount += currentWayCount;
                }
            }
        }
        return wayCount;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int coins[] = new int[m];
        for(int coins_i=0; coins_i < m; coins_i++){
            coins[coins_i] = in.nextInt();
        }
        System.out.println(makeChange(coins, n));
    }
}
