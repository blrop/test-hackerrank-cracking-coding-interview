import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static int getRegionSize(int[][] matrix, int x, int y) {
        if (x < 0 || y < 0 || x >= matrix.length || y >= matrix[0].length || matrix[x][y] == 0) {
            return 0;
        }
        matrix[x][y] = 0;
        return 1 +
            getRegionSize(matrix, x + 1, y + 1) +
            getRegionSize(matrix, x + 1, y - 1) +
            getRegionSize(matrix, x + 1, y) +
            getRegionSize(matrix, x - 1, y + 1) +
            getRegionSize(matrix, x - 1, y - 1) +
            getRegionSize(matrix, x - 1, y) +
            getRegionSize(matrix, x, y + 1) +
            getRegionSize(matrix, x, y - 1);
    }

    public static int getBiggestRegion(int[][] matrix) {
        int maxRegionSize = 0;
        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix[0].length; y++) {
                if (matrix[x][y] == 1) {
                    int regionSize = getRegionSize(matrix, x, y);
                    if (regionSize > maxRegionSize) {
                        maxRegionSize = regionSize;
                    }
                }
            }
        }
        return maxRegionSize;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int grid[][] = new int[n][m];
        for(int grid_i=0; grid_i < n; grid_i++){
            for(int grid_j=0; grid_j < m; grid_j++){
                grid[grid_i][grid_j] = in.nextInt();
            }
        }
        System.out.println(getBiggestRegion(grid));
    }
}
