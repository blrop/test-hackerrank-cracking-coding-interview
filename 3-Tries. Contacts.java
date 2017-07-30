import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Trie trie = new Trie();
        /*
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        for (int a0 = 0; a0 < n; a0++) {
            String op = in.next();
            String contact = in.next();
            if (op.equals("add")) {
                trie.add(contact);
            } else if (op.equals("find")) {
                int foundContacts = trie.find(contact);
                System.out.println(foundContacts);
            }
        }
*/

        trie.add("jack");
        trie.add("jake");
        trie.add("jaferson");
        trie.add("jafessy");
        trie.add("jafry");
        trie.add("don");
        System.out.println(trie.find("ja"));
        System.out.println(trie.find("jk"));
        System.out.println(trie.find("jafe"));
        System.out.println(trie.find("jaf"));
        System.out.println(trie.find("jafr"));
        System.out.println(trie.find("jafk"));
        System.out.println("-");
        System.out.println(trie.find("do"));
        System.out.println(trie.find("don"));
        System.out.println(trie.find("ro"));

    }

}

class TrieItem {
    private ArrayList<TrieItem> childs;
    private boolean completeWord;
    private char letter;

    public TrieItem(char letter) {
        this.letter = letter;
        childs = new ArrayList<>();
        completeWord = false;
    }

    public TrieItem findChildByChar(char letterToFind) {
        TrieItem result = null;

        for (TrieItem child : childs) {
            if (child.getLetter() == letterToFind) {
                return child;
            }
        }

        return result;
    }

    public void setCompleteWord(boolean completeWord) {
        this.completeWord = completeWord;
    }

    public char getLetter() {
        return letter;
    }

    public TrieItem addChild(char letter) {
        TrieItem newItem = new TrieItem(letter);
        childs.add(newItem);
        return newItem;
    }

//    public int getCompleteWordsCount() {
//        int result = 0;
//        for (TrieItem item : childs) {
//            if (item.getCompleteWord()) {
//                result++;
//            }
//
//        }
//        return result;
//    }

    public boolean getCompleteWord() {
        return completeWord;
    }

    public int getChildsCount() {
        int result = 0;
        for (TrieItem item : childs) {
            result += item.getChildsCount();
            if (item.getCompleteWord()) {
                result++;
            }
        }
        return result;
    }
}

class Trie {
    private TrieItem root;

    public Trie() {
        root = new TrieItem('*');
    }

    public void add(String contact) {
        TrieItem currentItem = root;
        for (int i = 0; i < contact.length(); i++) {
            TrieItem nextItem = currentItem.findChildByChar(contact.charAt(i));
            if (nextItem != null) {
                currentItem = nextItem;
            } else {
                currentItem = currentItem.addChild(contact.charAt(i));
            }
        }
        currentItem.setCompleteWord(true);
    }

    public int find(String contact) {
        TrieItem currentItem = root;
        for (int i = 0; i < contact.length(); i++) {
            TrieItem nextItem = currentItem.findChildByChar(contact.charAt(i));
            if (nextItem == null) {
                return 0;
            } else {
                currentItem = nextItem;
            }
        }

        return currentItem.getChildsCount();
    }
}
