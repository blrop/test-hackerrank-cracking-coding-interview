import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static class Graph {
        List<List<Integer>> edges;
        int size;
        public Graph(int size) {
            edges = new ArrayList<>();
            this.size = size;
            for (int i = 0; i < size; i++) {
                edges.add(new ArrayList<Integer>());
            }
        }

        public void addEdge(int first, int second) {
            edges.get(first).add(second);
            edges.get(second).add(first);
        }

        public int[] shortestReach(int startId) { // 0 indexed
            int[] distances = new int[size];
            Arrays.fill(distances, -1);
            Queue<Integer> que = new LinkedList<>();

            que.add(startId);
            distances[startId] = 0;
            HashSet<Integer> seen = new HashSet<>();

            seen.add(startId);
            while (!que.isEmpty()) {
                Integer curr = que.poll();
                for (int node : edges.get(curr)) {
                    if (!seen.contains(node)) {
                        que.add(node);
                        seen.add(node);
                        distances[node] = distances[curr] + 6;
                    }
                }
            }
            return distances;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int queries = scanner.nextInt();

        for (int t = 0; t < queries; t++) {

            // Create a graph of size n where each edge weight is 6:
            Graph graph = new Graph(scanner.nextInt());
            int m = scanner.nextInt();

            // read and set edges
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt() - 1;
                int v = scanner.nextInt() - 1;

                // add each edge to the graph
                graph.addEdge(u, v);
            }

            // Find shortest reach from node s
            int startId = scanner.nextInt() - 1;
            int[] distances = graph.shortestReach(startId);

            for (int i = 0; i < distances.length; i++) {
                if (i != startId) {
                    System.out.print(distances[i]);
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        scanner.close();
    }
}
