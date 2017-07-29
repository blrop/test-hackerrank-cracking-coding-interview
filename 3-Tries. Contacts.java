import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        for (int a0 = 0; a0 < n; a0++) {
            String op = in.next();
            String contact = in.next();
            if (op.equals("add")) {

            } else if (op.equals("find")) {

            }
        }
    }

    private class TrieItem {
        ArrayList<Trie> childs = null;
        boolean completeWord;
        char letter;


    }

    private class Trie {
        private TrieItem root;

        Trie() {
            this.root = new TrieItem();
        }

        public void add(String name) {
            for (int i = 0; i < name.length(); i++) {

            }
        }
    }
}