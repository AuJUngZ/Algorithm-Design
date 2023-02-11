package Midterm;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static int pascalTriangle(int[] db, int row, int col) {
        if (col == 0 || col == row) {
            return 1;
        }
        if (db[row * row + col] != 0) {
            return db[row * row + col];
        }
        db[row * row + col] = pascalTriangle(db, row - 1, col - 1) + pascalTriangle(db, row - 1, col);
        return db[row * row + col];
    }


    /**
     * Buttom-up approach
     */
    public static List<List<Integer>> generate(int number) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        if (number == 0) {
            return triangle;
        }
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);
        for (int i = 1; i < number; i++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(i - 1);
            row.add(1);
            for (int j = 1; j < i; j++) {
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }
            row.add(1);
            triangle.add(row);
        }
        return triangle;
    }
}
