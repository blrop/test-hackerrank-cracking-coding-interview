// Write your Checker class here

class Checker implements Comparator {
    public int compare(Object t1, Object t2) {

        Player p1 = (Player) t1;
        Player p2 = (Player) t2;

        if (p1.score == p2.score) {
            return p1.name.compareTo(p2.name);
        } else {
            return Integer.compare(p2.score, p1.score);
        }
    }
}