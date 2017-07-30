import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    private static boolean isPairedBrackets(char br1, char br2) {
        return (br1 == '(' && br2 == ')') || (br1 == '[' && br2 == ']') || (br1 == '{' && br2 == '}');
    }

    public static boolean isBalanced(String expression) {
        ArrayList<Character> stack = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.add(ch);
            } else if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.size() < 1) {
                    return false;
                }
                char chFromStack = stack.remove(stack.size() - 1);
                if (!isPairedBrackets(chFromStack, ch)) {
                    return false;
                }
            }
        }
        return stack.size() == 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
        }
/*
        System.out.println( (isBalanced("{[(())]}")) ? "YES" : "NO" );
        System.out.println( (isBalanced("{())]}")) ? "YES" : "NO" );
        System.out.println( (isBalanced("{[(())()[{}]]}")) ? "YES" : "NO" );
        System.out.println( (isBalanced("((((((((((((((((((")) ? "YES" : "NO" );
        System.out.println( (isBalanced("))))))))))")) ? "YES" : "NO" );
*/
    }
}
